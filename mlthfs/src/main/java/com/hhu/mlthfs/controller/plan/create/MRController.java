package com.hhu.mlthfs.controller.plan.create;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 多元回归模型
 * MR
 *
 */
@RestController
@RequestMapping("/plan/mr")
public class MRController {
    /**
     * 进入系统界面
     * @return
     */
    @GetMapping("/mrPage")
    public ModelAndView mrIndex(){
        ModelAndView mav=new ModelAndView("page/plan/createPlan/mr/mrPage");
        return mav;
    }
}
