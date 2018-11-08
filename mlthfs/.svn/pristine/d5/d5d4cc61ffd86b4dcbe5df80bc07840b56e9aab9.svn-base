package com.hhu.mlthfs.controller.system;


import com.google.common.collect.Maps;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.utils.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HHU
 * @since 2018-08-31
 */
@RestController
@RequestMapping("/system")
public class MenuController extends BaseController {
    public static final Logger logger= LoggerFactory.getLogger(MenuController.class);

    /**
     * 转到权限列表界面
     * @param model
     * @return html
     */
    @GetMapping("/menusPage")
    public ModelAndView list(Model model){
        ModelAndView mav=new ModelAndView("page/system/menu/test");
        return mav;
    }

    /**
     * 展示treelist
     * @return
     */
    @PostMapping("/menus/treelist")
    public RestResponse treelist(){
        Map<String,Object> map= Maps.newHashMap();
        map.put("parentId",null);
        map.put("isShow",false);
        return RestResponse.success().setData(menuService.selectAllMenus(map));

    }
	
}
