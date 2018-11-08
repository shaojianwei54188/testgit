package com.hhu.mlthfs.controller.adjust;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.controller.forecast.ForecastInfoController;
import com.hhu.mlthfs.model.ForecastResult;
import com.hhu.mlthfs.utils.LayerData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 单模型校正 控制层
 */
@RestController
@RequestMapping("/adjust")
public class AdjustController extends BaseController {
    public static final Logger logger = LoggerFactory.getLogger(ForecastInfoController.class);

    /**
     * 进入系统 执行校正界面
     *
     * @return
     */
    @GetMapping("/doAdjustPage")
    public ModelAndView doForecastPageIndex() {
        ModelAndView mav = new ModelAndView("page/adjust/doAdjustPage");
        return mav;
    }

    /**
     * 进入 校正结果列表界面
     */
    @GetMapping("/adjustResultPage")
    public ModelAndView adjustResultPage() {
        ModelAndView mav = new ModelAndView("page/adjust/adjustinfo/adjustinfo");
        return mav;
    }

    /**
     * 校正结果信息列表
     */
    @GetMapping("/adjustInfo")
    public LayerData<ForecastResult> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                                          ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        //返回校正结果
        LayerData<ForecastResult> adjustResultLayerData = new LayerData<>();
        EntityWrapper<ForecastResult> adjustResultEntityWrapper = new EntityWrapper<>();
        adjustResultEntityWrapper.eq("del_flag", false);
        adjustResultEntityWrapper.eq("plan_type", "0");
        if (!map.isEmpty()) {
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                adjustResultEntityWrapper.like("forecast_section", keys);

            } else {
                map.remove("key");
            }

            String forecastTime = (String) map.get("forecastTime");
            if (StringUtils.isNotBlank(forecastTime)) {
                adjustResultEntityWrapper.like("forecast_time", forecastTime);
            } else {
                map.remove("forecastTime");
            }
            String forecastTimeStart = (String) map.get("forecastTimeStart");
            if (StringUtils.isNotBlank(forecastTimeStart)) {
                adjustResultEntityWrapper.like("forecast_time_start", forecastTimeStart);
            } else {
                map.remove("forecastTimeStart");
            }

            String planId = (String) map.get("planId");
            if (StringUtils.isNotBlank(forecastTimeStart)) {
                adjustResultEntityWrapper.like("plan_id", planId);
            } else {
                map.remove("planId");
            }
        }
        Page<ForecastResult> adjustResultPage = forecastResultService.selectPage(new Page<>(page, limit), adjustResultEntityWrapper);
        adjustResultLayerData.setCount(adjustResultPage.getTotal());
        adjustResultLayerData.setData(adjustResultPage.getRecords());
        logger.info(adjustResultLayerData.toString());
        return adjustResultLayerData;
    }


    /**
     * 进入 校正结果详情界面
     * @param planId
     * @param forecastTimeStart
     * @param forecastSection
     * @param model
     * @return
     */
    @GetMapping("/adjustInfo/edit")
    public ModelAndView edit(String planId,
                             String forecastTimeStart,
                             String forecastSection,
                             Model model) {

        logger.info("forecastTimeStart==" + forecastTimeStart);
        logger.info("planId==" + planId);
        logger.info("forecastSection==" + forecastSection);
        model.addAttribute("forecastTimeStart", forecastTimeStart);
        model.addAttribute("planId", planId);
        model.addAttribute("forecastSection", forecastSection);
        ModelAndView mav = new ModelAndView("page/adjust/adjustinfo/edit");
        return mav;
    }


    @GetMapping("/adjustInfo/edit/adjustResult")
    public Map<String, Object> adjustResultList(ServletRequest request,
                                                String planId,
                                                String forecastTimeStart,
                                                String forecastSection){

        //创建集合来接受数据库数据
        List<ForecastResult> adjustResultList = new ArrayList<>();

        //存放数组
        Map<String, Object> dataMap = Maps.newHashMap();
        EntityWrapper<ForecastResult> adjustResultEntityWrapper=new EntityWrapper<>();
        adjustResultEntityWrapper.eq("plan_id", planId);
        adjustResultEntityWrapper.eq("forecast_section", forecastSection);
        adjustResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);

        adjustResultList=forecastResultService.selectList(adjustResultEntityWrapper);
        logger.info("====forecastResultList====="+adjustResultList);
        logger.info("====forecastResultList.size====="+adjustResultList.size());

        //创建装载预报时间的数组
        String[] timeArr = new String[adjustResultList.size()];

        //创建装载预报值的数组
        Double[] forecastValueArr = new Double[adjustResultList.size()];
        //创建装载历史均值的数组
        Double[] adjustValueArr = new Double[adjustResultList.size()];
        //定义数组下标
        int i = 0;
        for (ForecastResult forecastResult : adjustResultList) {
            timeArr[i] = forecastResult.getForecastTime();
            forecastValueArr[i] = forecastResult.getForecastValue();
            adjustValueArr[i] = forecastResult.getForecastAdjustValue();
            i++;
        }
        //将数组放入集合
        dataMap.put("timeArr", timeArr);
        dataMap.put("forecastValueArr", forecastValueArr);
        dataMap.put("adjustValueArr", adjustValueArr);
        return dataMap;

    }
}
