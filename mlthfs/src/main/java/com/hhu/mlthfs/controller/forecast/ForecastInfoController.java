package com.hhu.mlthfs.controller.forecast;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.hhu.mlthfs.base.BaseController;
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
 * 预报结果详情 控制层
 */
@RestController
@RequestMapping("/forecast")
public class ForecastInfoController extends BaseController {
    public static final Logger logger = LoggerFactory.getLogger(ForecastInfoController.class);


    /**
     * 进入系统方案详情界面
     *
     * @return
     */
    @GetMapping("/forecastinfoPage")
    public ModelAndView forecastInfoIndex() {
        ModelAndView mav = new ModelAndView("page/forecast/forecastinfo/forecastinfoPage");
        return mav;
    }

    /**
     * 预报结果信息列表
     *
     * @param page
     * @param limit
     * @param request
     * @return
     */

    @GetMapping("/forecastInfo")
    public LayerData<ForecastResult> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                                          ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ForecastResult> forecastResultLayerData = new LayerData<>();
        EntityWrapper<ForecastResult> forecastResultEntityWrapper = new EntityWrapper<>();
        forecastResultEntityWrapper.eq("del_flag", false);
        forecastResultEntityWrapper.like("plan_type", "0");
        if (!map.isEmpty()) {
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                forecastResultEntityWrapper.like("forecast_section", keys);

            } else {
                map.remove("key");
            }

            String forecastTime = (String) map.get("forecastTime");
            if (StringUtils.isNotBlank(forecastTime)) {
                forecastResultEntityWrapper.like("forecast_time", forecastTime);
            } else {
                map.remove("forecastTime");
            }

            String forecastTimeStart = (String) map.get("forecastTimeStart");
            if (StringUtils.isNotBlank(forecastTimeStart)) {
                forecastResultEntityWrapper.like("forecast_time_start", forecastTimeStart);
            } else {
                map.remove("forecastTimeStart");
            }

            String planId = (String) map.get("planId");
            if (StringUtils.isNotBlank(forecastTimeStart)) {
                forecastResultEntityWrapper.like("plan_id", planId);
            } else {
                map.remove("planId");
            }
        }
        Page<ForecastResult> forecastResultPage = forecastResultService.selectPage(new Page<>(page, limit), forecastResultEntityWrapper);
        forecastResultLayerData.setCount(forecastResultPage.getTotal());
        forecastResultLayerData.setData(forecastResultPage.getRecords());
        logger.info(forecastResultLayerData.toString());
        return forecastResultLayerData;
    }

    /**
     * 点击详情进入界面  展示预报结果的图形界面
     *
     * @param planId
     * @param forecastTimeStart
     * @param forecastSection
     * @param model
     * @return
     */
    @GetMapping("/forecastInfo/edit")
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
        ModelAndView mav = new ModelAndView("page/forecast/forecastinfo/edit");
        return mav;
    }

    /**
     * 获取 展示预报结果图 的数据
     * @param request
     * @param planId
     * @param forecastTimeStart
     * @param forecastSection
     * @return
     */
    @GetMapping("/forecastInfo/edit/forecastResult")
    public Map<String, Object> getForecastResultList(ServletRequest request,
                                                     String planId,
                                                     String forecastTimeStart,
                                                     String forecastSection) {
        //创建集合来接受数据库数据
        List<ForecastResult> forecastResultList = new ArrayList<>();

        //存放数组
        Map<String, Object> dataMap = Maps.newHashMap();
        EntityWrapper<ForecastResult> forecastResultEntityWrapper=new EntityWrapper<>();
        forecastResultEntityWrapper.eq("plan_id", planId);
        forecastResultEntityWrapper.eq("forecast_section", forecastSection);
        forecastResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);

        forecastResultList=forecastResultService.selectList(forecastResultEntityWrapper);
        logger.info("====forecastResultList====="+forecastResultList);
        logger.info("====forecastResultList.size====="+forecastResultList.size());

        //创建装载预报时间的数组
        String[] timeArr = new String[forecastResultList.size()];

        //创建装载预报值的数组
        Double[] forecastValueArr = new Double[forecastResultList.size()];
        //创建装载历史均值的数组
        Double[] historyAverageValueArr = new Double[forecastResultList.size()];
        //定义数组下标
        int i = 0;
        for (ForecastResult forecastResult : forecastResultList) {
            timeArr[i] = forecastResult.getForecastTime();
            forecastValueArr[i] = forecastResult.getForecastValue();
            historyAverageValueArr[i] = forecastResult.getHistoryAverage();
            i++;
        }
        //将数组放入集合
        dataMap.put("timeArr", timeArr);
        dataMap.put("forecastValueArr", forecastValueArr);
        dataMap.put("historyAverageValueArr", historyAverageValueArr);
        return dataMap;
    }

}
