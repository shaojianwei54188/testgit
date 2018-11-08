package com.hhu.mlthfs.controller.plan.create;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 创建模型方案
 * 支持向量机（SVM）
 * 控制层
 */
@RestController
@RequestMapping("/plan/svm")
public class SVMController {
    /**
     * 进入创建支持向量机模型页面
     * @return 页面
     */
    @GetMapping("/svmPage")
    public ModelAndView svmIndex(Model model){
        ModelAndView mav=new ModelAndView("page/plan/createPlan/svm/svmPage");
        return mav;
    }
}
