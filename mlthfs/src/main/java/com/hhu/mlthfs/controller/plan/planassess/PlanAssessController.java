package com.hhu.mlthfs.controller.plan.planassess;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.PlanAssessIndex;
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
 * 方案评价 控制层
 */
@RestController
@RequestMapping("/plan")
public class PlanAssessController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(PlanAssessController.class);

    /**
     * 进入方案评价界面
     *
     * @return
     */
    @GetMapping("/planAssessPage")
    public ModelAndView planAssessPageIndex() {

        ModelAndView mav = new ModelAndView("page/plan/planAssess/planAssessPage");
        return mav;
    }


    /**
     * 获取方案评价指标信息
     */
    @GetMapping("/planAssessIndex")
    public LayerData<PlanAssessIndex> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<PlanAssessIndex> planAssessIndexLayerData = new LayerData<>();
        EntityWrapper<PlanAssessIndex> planAssessIndexEntityWrapper = new EntityWrapper<>();
        planAssessIndexEntityWrapper.eq("del_flag", false);
        if (!map.isEmpty()) {
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                planAssessIndexEntityWrapper.like("forecast_section", keys);
            } else {
                map.remove("key");
            }

            String forecastTimeStart = (String) map.get("forecastTimeStart");
            if (StringUtils.isNotBlank(forecastTimeStart)) {
                planAssessIndexEntityWrapper.like("forecast_time_start", forecastTimeStart);
            } else {
                map.remove("forecastTimeStart");
            }
        }
        Page<PlanAssessIndex> planAssessIndexPage = planAssessIndexService.selectPage(new Page<>(page, limit), planAssessIndexEntityWrapper);
        planAssessIndexLayerData.setCount(planAssessIndexPage.getTotal());
        planAssessIndexLayerData.setData(planAssessIndexPage.getRecords());

        logger.info(planAssessIndexLayerData.toString());
        return planAssessIndexLayerData;

    }


}
