package com.hhu.mlthfs.controller.datainfo;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.ClimateIndex;
import com.hhu.mlthfs.model.ClimateName;
import com.hhu.mlthfs.model.vo.ClimateIndexVO;
import com.hhu.mlthfs.service.ClimateIndexService;
import com.hhu.mlthfs.service.ClimateNameService;
import com.hhu.mlthfs.utils.DateUtil;
import com.hhu.mlthfs.utils.LayerData;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.runtime.directive.Foreach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 气候因子数据控制类
 * 用于处理气候因子数据的请求
 * /data/climateIndexPage
 *
 * todo 请求路径换成restful风格
 */
@RestController
@RequestMapping("/data")
public class ClimateIndexController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(BasicInfoController.class);

    /**
     * 系统进入气象因子数据管理界面
     * @return view
     */
    @GetMapping("/climateIndexPage")
    public ModelAndView climateIndex(){
        ModelAndView mav=new ModelAndView("page/datainfo/climate_index/climateIndex");
        return mav;
    }

    @GetMapping("/climateIndex")
    public LayerData<ClimateIndexVO> list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                          @RequestParam(value = "limit",defaultValue = "130") Integer limit,
                                          @RequestParam(value = "tm",defaultValue = "201804") String tm,
                                          ServletRequest request ){
        Map map= WebUtils.getParametersStartingWith(request,"s_");
        logger.info("===================keys=========="+map.toString());
        LayerData<ClimateIndexVO> climateIndexVOLayerData =new LayerData<>();

        EntityWrapper<ClimateIndexVO> climateIndexVOEntityWrapper = new EntityWrapper<>();

        if (!map.isEmpty()) {
            String keys = (String) map.get("time");
            if (StringUtils.isNotBlank(keys)) {
                climateIndexVOEntityWrapper.like("tm", keys);
            }
        }else if(map.isEmpty()){
            //初始化展示上一个月的130项数据，
            climateIndexVOEntityWrapper.like("tm", DateUtil.getLastMonth());
        }

        Page<ClimateIndexVO> climateIndexVOPage=climateIndexService.selectClimateIndexListByTime(new Page<>(page,limit),tm,climateIndexVOEntityWrapper);

        climateIndexVOLayerData.setData(climateIndexVOPage.getRecords());
        climateIndexVOLayerData.setCount(climateIndexVOPage.getTotal());

        logger.info(climateIndexVOLayerData.toString());

        return climateIndexVOLayerData;
    }
}
