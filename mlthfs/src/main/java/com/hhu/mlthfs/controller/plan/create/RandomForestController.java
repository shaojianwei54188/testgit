package com.hhu.mlthfs.controller.plan.create;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 随机森林模型相关的控制层
 *
 *
 */
@RestController
@RequestMapping("/plan/rf")
public class RandomForestController {
    /**
     * 进入随机森林界面
     */
    @GetMapping("/rfPage")
    public ModelAndView rfIndex(Model model){
        ModelAndView mav=new ModelAndView("page/plan/createPlan/rf/rfPage");
        return mav;

    }
}
