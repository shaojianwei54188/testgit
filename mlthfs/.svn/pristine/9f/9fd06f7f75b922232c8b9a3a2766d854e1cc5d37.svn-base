package com.hhu.mlthfs.controller.plan.create;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 季节性自回归模型创建
 * (SAP)
 * 创建方案
 */
@RestController
@RequestMapping("/plan/sap")
public class SAPController {
    /**
     * 进入系统界面
     * @return
     */
    @GetMapping("/sapPage")
    public ModelAndView sapIndex(){
        ModelAndView mav=new ModelAndView("page/plan/createPlan/sap/sapPage");
        return mav;
    }
}
