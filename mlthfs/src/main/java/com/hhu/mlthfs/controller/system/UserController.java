package com.hhu.mlthfs.controller.system;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.model.User;
import com.hhu.mlthfs.utils.Constants;
import com.hhu.mlthfs.utils.LayerData;
import com.hhu.mlthfs.utils.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.jws.WebParam;
import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author HHU
 * @since 2018-07-04
 */
@RestController
@RequestMapping("/system")
public class UserController extends BaseController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);

    /**
     * 进入系统-用户管理界面
     * GET
     * @return html
     */

    @GetMapping("/usersPage")
    public ModelAndView userList() {
        ModelAndView mav = new ModelAndView("page/system/user/list");
        return mav;
    }

    /**
     * 初始化为表格添加数据
     * 查询所有的用户
     * get
     * @return  userLayerData
     */
    @GetMapping("/users")
    public LayerData<User> getUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                       ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<User> userLayerData = new LayerData<>();
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        logger.info("=========================map==========="+map.toString());
        if (!map.isEmpty()) {
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                userEntityWrapper.like("login_name", keys);
            }
        }
        Page<User> userPage = userService.selectPage(new Page<>(page, limit), userEntityWrapper);
        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return userLayerData;
    }
    /**
     * 用户列表添加用户按钮转到--用户添加界面
     * GET
     */
    @GetMapping("/users/add")
    public ModelAndView addUser(Model model) {
        List<Role> roleList = roleService.selectAll();
        model.addAttribute("roleList", roleList);
        ModelAndView mav = new ModelAndView("page/system/user/add");
        return mav;
    }
    /**
     * 保存新增用户到数据库
     *
     * @param user
     * @return
     */

    @PostMapping("/users/add")
    public RestResponse add(@RequestBody User user) {
        if (StringUtils.isBlank(user.getLoginName())) {
            return RestResponse.failure("登录名不能为空");
        }
        if (StringUtils.isNotBlank(user.getLoginName())) {
            if (userService.userCount(user.getLoginName()) > 0) {
                return RestResponse.failure("该登录名已被使用");
            }
        }
        if (user.getRoleLists() == null || user.getRoleLists().size() == 0) {
            return RestResponse.failure("用户角色至少选择一个");
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            if (userService.userCount(user.getEmail()) > 0) {
                return RestResponse.failure("该邮箱已被使用");
            }
        }
        if (StringUtils.isNoneBlank(user.getTel())) {
            if (userService.userCount(user.getTel()) > 0) {
                return RestResponse.failure("该手机号已被使用");
            }
        }
//        user.setPassword(Constants.DEFAULT_PASSWORD);
        userService.saveUser(user);
        if (user.getId() == null || user.getId() == 0) {
            return RestResponse.failure("保存用户信息出错");
        }
        //保存用户角色关系
        userService.saveUserRoles(user.getId(), user.getRoleLists());
        return RestResponse.success();
    }

    /**
     * 删除单个用户
     * post
     */
    @PostMapping("/users/delete")
    public RestResponse delete(@RequestParam(value = "id", required = false) Long id) {

        logger.info("=============id======"+id);
        if (id == null || id == 0 || id == 1 || id == 2) {
            return RestResponse.failure("参数错误");
        }
        User user=userService.findUserById(id);

        logger.info("========delete   user======"+user.toString());
        if (user == null){
            return RestResponse.failure("用户不存在");
        }
        userService.deleteUser(user);
        return RestResponse.success();
    }

    /**
     * 进入用户修改界面
     * @return html
     *
     */
    @GetMapping("/users/edit")
    public ModelAndView edit(Long id,Model model){
        User user=userService.findUserById(id);
        StringBuffer roleIds=new StringBuffer();
        if(user != null){
            Set<Role> roleSet=user.getRoleLists();
            if(roleSet != null && roleSet.size()>0){
                for(Role r:roleSet){
                    roleIds.append(r.getId().toString()).append(",");
                }
            }
        }
        List<Role> roleList=roleService.selectAll();
        model.addAttribute("localUser",user);
        model.addAttribute("roleIds",roleIds);
        model.addAttribute("roleList",roleList);

        logger.info(roleIds.toString());
        logger.info(roleList.toString());
        logger.info(roleList.get(1).toString());
        ModelAndView mav=new ModelAndView("page/system/user/edit");
        return mav;


    }












    /**
     * 进入修改密码页面
     *
     * @return
     */

    @GetMapping("/changePassword")
    public ModelAndView changePassword() {
        ModelAndView mav = new ModelAndView("page/system/user/changePassword");
        return mav;
    }

    /**
     * 进入个人信息界面
     *
     * @return
     */
    @GetMapping("/userInfo")
    public ModelAndView userInfo() {
        ModelAndView mav = new ModelAndView("page/system/user/userInfo");
        return mav;
    }
}
