package com.hhu.mlthfs.controller.plan.create;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 小波分析模型创建（WA）
 * 控制层
 */
@RestController
@RequestMapping("/plan/wa")
public class WAController {

    /**
     * 进入系统界面
     * @return
     */
    @GetMapping("/waPage")
    public ModelAndView waIndex(){
        ModelAndView mav=new ModelAndView("page/plan/createPlan/wa/waPage");
        return mav;
    }
}
