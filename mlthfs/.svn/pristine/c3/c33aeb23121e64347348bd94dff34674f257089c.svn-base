package com.hhu.mlthfs.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.model.User;
import com.hhu.mlthfs.utils.LayerData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 相关角色管理的controller
 */

@RestController
@RequestMapping("/system")
public class RoleController extends BaseController {
    private static Logger logger= LoggerFactory.getLogger(RoleController.class);
    /**
     * 系统跳转到角色页面
     * get
     * @return html
     *
     */
    @GetMapping("/rolesPage")
    public ModelAndView roleList(){
        ModelAndView mav=new ModelAndView("page/system/role/list");
        return mav;
    }
    /**
     * 加载角色列表
     * get
     * @return roleLayerData
     */
    @GetMapping("/roles")
    public LayerData<Role> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<Role> roleLayerData = new LayerData<>();
        EntityWrapper<Role> roleEntityWrapper = new EntityWrapper<>();
        roleEntityWrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String keys = (String) map.get("key");
            if(StringUtils.isNotBlank(keys)) {
                roleEntityWrapper.like("name", keys);
            }
        }
        Page<Role> rolePage = roleService.selectPage(new Page<>(page,limit),roleEntityWrapper);
        roleLayerData.setCount(rolePage.getTotal());
        roleLayerData.setData(setUserToRole(rolePage.getRecords()));
        return roleLayerData;
    }

    private List<Role> setUserToRole(List<Role> roles){
        for(Role r : roles){
            if(r.getCreateId() != null && r.getCreateId() != 0){
                User u = userService.findUserById(r.getCreateId());
                logger.info(u.getNickName());
                if(StringUtils.isBlank(u.getNickName())){
                    u.setNickName(u.getLoginName());
                }
                r.setCreateUser(u);
            }
            if(r.getUpdateId() != null && r.getUpdateId() != 0){
                User u  = userService.findUserById(r.getUpdateId());
                if(StringUtils.isBlank(u.getNickName())){
                    u.setNickName(u.getLoginName());
                }
                r.setUpdateUser(u);
            }
        }
        return roles;
    }
    /**
     * 系统跳转到添加用户角色页面
     */
    @GetMapping("/add")
    public ModelAndView addUser(){
        ModelAndView mav=new ModelAndView("page/system/role/add" );
        return mav;
    }


}
