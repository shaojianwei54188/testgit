package com.hhu.mlthfs.controller.datainfo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.Basicinfo;
import com.hhu.mlthfs.utils.LayerData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 *
 *
 * 气象因子数据
 * controller控制类
 *
 */
@RestController
@RequestMapping("/data")
public class BasicInfoController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(BasicInfoController.class);
    /**
     * 系统跳转到气候因子界面
     * @return
     */
    @GetMapping("/basicinfoPage")
    public ModelAndView basicInfo(){

        ModelAndView mav=new ModelAndView("page/datainfo/basic_info/basicInfo");
        return mav;
    }

    /**
     * 获取断面基础信息列表
     *
     */
    @GetMapping("/basicinfo")
    public LayerData<Basicinfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                     ServletRequest request){
        Map map= WebUtils.getParametersStartingWith(request,"s_");
        LayerData<Basicinfo> basicinfoLayerData = new LayerData<>();
        EntityWrapper<Basicinfo> basicinfoEntityWrapper=new EntityWrapper<>();
        basicinfoEntityWrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String keys= (String) map.get("key");
            if(StringUtils.isNotBlank(keys)){
                basicinfoEntityWrapper.like("stnm",keys);
            }
        }
        Page<Basicinfo> basicinfopage=basicinfoService.selectPage(new Page<>(page,limit),basicinfoEntityWrapper);
        basicinfoLayerData.setCount(basicinfopage.getTotal());
        basicinfoLayerData.setData(basicinfopage.getRecords());
        logger.info(basicinfoLayerData.toString());
        return basicinfoLayerData;

    }


}
