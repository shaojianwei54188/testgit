package com.hhu.mlthfs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/table1")
    public ModelAndView hellotest(){
        ModelAndView mav=new ModelAndView("page/map");
        return mav;
    }

    @GetMapping("/map2")
    public ModelAndView mapTest(){
        ModelAndView mav=new ModelAndView("page/map2");
        return mav;
    }

}
