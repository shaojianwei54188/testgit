package com.hhu.mlthfs.controller.combine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 模型综合 控制层
 */
@RestController
@RequestMapping("/combine")
public class CombinationController {

    /**
     * 执行方案综合
     * @return
     */
    @GetMapping("/doCombinationPage")
    public ModelAndView doPlanCombination(){

        ModelAndView mav=new ModelAndView("page/combine/doCombinationPage");
        return mav;
    }


    /**
     * 模型综合结果界面
     * @return
     */
    @GetMapping("/CombinationResultPage")
    public ModelAndView planCombinationResultPage(){

        ModelAndView mav=new ModelAndView("page/combine/CombinationResultPage");
        return mav;
    }
}
