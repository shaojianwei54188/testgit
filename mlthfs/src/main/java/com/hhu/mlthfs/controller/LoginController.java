package com.hhu.mlthfs.controller;

import com.google.common.collect.Maps;
import com.hhu.mlthfs.utils.Constants;
import com.hhu.mlthfs.utils.RestResponse;
import com.hhu.mlthfs.utils.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;


@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 进入首页
     *
     * @return
     */
    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    /**
     * 进入登陆界面
     *
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        logger.info("跳到这边的路径为:" + request.getRequestURI());
        org.apache.shiro.subject.Subject s = SecurityUtils.getSubject();
        logger.info("是否记住登录--->" + s.isRemembered() + "<-----是否有权限登录----->" + s.isAuthenticated() + "<----");
        if (s.isAuthenticated()) {
            ModelAndView mav = new ModelAndView("redirect:index");
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("login");
            return mav;
        }
    }

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @PostMapping("/login/main")
    public RestResponse loginMain(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        String code = request.getParameter("code");

        logger.info("---username:" + username + "----password:" + password + "---rememberMe:" + rememberMe + "----code:" + code);

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return RestResponse.failure("用户名或者密码不能为空");
        }
        if (StringUtils.isBlank(rememberMe)) {
            return RestResponse.failure("记住我不能为空");
        }
        if (StringUtils.isBlank(code)) {
            return RestResponse.failure("验证码不能为空");
        }
        Map<String, Object> map = Maps.newHashMap();
        String error = null;

        HttpSession session = request.getSession();

        logger.info("loginMain中的session" + session.getId());
        logger.info("------------请求的session状态：" + String.valueOf(session).toString());

        if (session == null) {
            return RestResponse.failure("session超时");
        }
        String trueCode = (String) session.getAttribute(Constants.VALIDATE_CODE);

        logger.info("------------session中验证码的状态：" + String.valueOf(session).toString());
        logger.info("--------------trueCode-------" + trueCode);

        if (StringUtils.isBlank(trueCode)) {
            return RestResponse.failure("验证码超时");
        }
        if (StringUtils.isBlank(code) || !trueCode.toLowerCase().equals(code.toLowerCase())) {
            error = "验证码错误";
        } else {
            /* 当前用户*/
            Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username
                    , password
                    , Boolean.valueOf(rememberMe));
            try {
                user.login(token);
                if (user.isAuthenticated()) {
                    map.put("url", "index");
                }
            } catch (IncorrectCredentialsException e) {
                error = "登录密码错误.";
            } catch (ExcessiveAttemptsException e) {
                error = "登录失败次数过多";
            } catch (LockedAccountException e) {
                error = "帐号已被锁定.";
            } catch (DisabledAccountException e) {
                error = "帐号已被禁用.";
            } catch (ExpiredCredentialsException e) {
                error = "帐号已过期.";
            } catch (UnknownAccountException e) {
                error = "帐号不存在";
            } catch (UnauthorizedException e) {
                error = "您没有得到相应的授权！";
            }
        }
        if (StringUtils.isBlank(error)) {
            return RestResponse.success("登录成功").setData(map);
        } else {
            return RestResponse.failure(error);
        }
    }


    @GetMapping("/systemLogout")
    public ModelAndView logOut() {
        logger.info("-----------------退出系统登录-------------");
        ModelAndView mav = new ModelAndView("redirect:login");
        return mav;
    }

    /**
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
     */
    @GetMapping("/genCaptcha")
    public void genCaptcha(HttpServletRequest request,
                           HttpServletResponse response) {

        try {
            logger.info("------进入生成验证码genCaptcha----");
            //设置页面不缓存
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            //设置输出的内容的类型为JPEG图像
            response.setContentType("image/jpeg");

            String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_ALL_MIXED, 4, null);
            logger.info("===============verifyCode:" + verifyCode);
            HttpSession session = request.getSession(true);
            logger.info("genCaptcha中的session" + session.getId());
            //将验证码放到HttpSession里面
            session.setAttribute(Constants.VALIDATE_CODE, verifyCode);
            logger.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");

            session.getAttribute(Constants.VALIDATE_CODE);
            System.out.println(" request.getSession().getAttribute(Constants.VALIDATE_CODE);" + request.getSession().getAttribute(Constants.VALIDATE_CODE));

            BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 116, 36, 5, true, new Color(249, 205, 173), null, null);
            //写给浏览器
            ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            logger.info("获取验证码异常：" + e.getMessage());
        }
    }

    /**
     * 首页地图展示
     *
     * @return
     */
    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("tdt");
        return modelAndView;
    }


    @GetMapping(value = "")
    public ModelAndView index2() {
        logger.info(" 这是空的请求路径");
        Subject s = SecurityUtils.getSubject();
        logger.info("=============是否经过身份验证：" + String.valueOf(s.isAuthenticated()));
        return s.isAuthenticated() ? new ModelAndView("redirect:index") : new ModelAndView("login");
    }
}
