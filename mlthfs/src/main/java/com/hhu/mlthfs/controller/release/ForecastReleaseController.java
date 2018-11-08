package com.hhu.mlthfs.controller.release;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.ForecastReleaseResult;
import com.hhu.mlthfs.model.HistoryQData;
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

@RestController
@RequestMapping("/release")
public class ForecastReleaseController extends BaseController {
    public static final Logger logger = LoggerFactory.getLogger(ForecastReleaseController.class);


    /**
     * 进入系统预报发布界面
     *
     * @return
     */
    @GetMapping("/releasePage")
    public ModelAndView forecastInfoIndex() {
        ModelAndView mav = new ModelAndView("page/forecastRelease/forecastReleasePage");
        return mav;
    }

    /**
     * 展示发布结果表
     *
     * @param page
     * @param limit
     * @param request
     * @return
     */

    @GetMapping("/releaseResultInfo")
    public LayerData<ForecastReleaseResult> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                                                 ServletRequest request) {

        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ForecastReleaseResult> forecastReleaseResultLayerData = new LayerData<>();
        EntityWrapper<ForecastReleaseResult> forecastReleaseResultEntityWrapper = new EntityWrapper<>();
        forecastReleaseResultEntityWrapper.eq("del_flag", false);
        if (!map.isEmpty()) {
            String keys = (String) map.get("forecastSection");
            if (StringUtils.isNotBlank(keys)) {
                forecastReleaseResultEntityWrapper.like("forecast_section", keys);

            } else {
                map.remove("forecastSection");
            }

            String forecastTime = (String) map.get("forecastTime");
            if (StringUtils.isNotBlank(forecastTime)) {
                forecastReleaseResultEntityWrapper.like("forecast_time", forecastTime);
            } else {
                map.remove("forecastTime");
            }
        }
        Page<ForecastReleaseResult> forecastReleaseResultPage = forecastReleaseResultService.selectPage(new Page<>(page, limit), forecastReleaseResultEntityWrapper);
        forecastReleaseResultLayerData.setCount(forecastReleaseResultPage.getTotal());
        forecastReleaseResultLayerData.setData(forecastReleaseResultPage.getRecords());

        logger.info(forecastReleaseResultLayerData.toString());
        return forecastReleaseResultLayerData;
    }


    /**
     * 点击发布结果的详情 按钮进入详情页面
     */

    @GetMapping("/releaseResultInfo/edit")
    public ModelAndView releasePage(Model model,
                                    String forecastSection,
                                    String forecastTime,
                                    String forecastValue,
                                    String releaseType,
                                    String releaseTime,
                                    String releasePerson,
                                    String modelName,
                                    String forecastTimeStart) {

        logger.info("==forecastSection==" + forecastSection);
        logger.info("==forecastTimeStart==" + forecastTimeStart);
        logger.info("==forecastTime==" + forecastTime);
        logger.info("==forecastValue==" + forecastValue);

        logger.info("==releaseType==" + releaseType);
        logger.info("==releaseTime==" + releaseTime);
        logger.info("==releasePerson==" + releasePerson);
        logger.info("==modelName==" + modelName);

        model.addAttribute("forecastSection", forecastSection);
        model.addAttribute("forecastTimeStart", forecastTimeStart);
        model.addAttribute("forecastTime", forecastTime);
        model.addAttribute("forecastValue", forecastValue);

        model.addAttribute("releaseType", releaseType);
        model.addAttribute("releaseTime", releaseTime);
        model.addAttribute("releasePerson", releasePerson);
        model.addAttribute("modelName", modelName);
        ModelAndView mav = new ModelAndView("page/forecastRelease/edit");
        return mav;

    }


    /**
     * 点击详情界面进入之后展示的图表（左边）
     * <p>
     * 起报时间的前一年+预报月份的值
     */

    @GetMapping("/getReleaseResult")
    public Map<String, Object> getReleaseResultList(ServletRequest request,
                                                    String forecastTime,
                                                    Double forecastValue,
                                                    String forecastTimeStart,
                                                    String forecastSection) {

        logger.info("==forecastSection123==" + forecastSection);
        logger.info("==forecastTimeStart123==" + forecastTimeStart);
        logger.info("==forecastTime123==" + forecastTime);
        logger.info("==forecastValue123==" + forecastValue);

        forecastTimeStart = "2017-11";


        //将起报年份用spilt函数根据-分割成数组
        String[] aa = forecastTimeStart.split("-");
        System.out.println(aa[0]);
        System.out.println(aa[1]);
        //构造起始时间，暂定为起报年份的年份减一，
        // 如起报年份为2018-11，那么展示的时间范围是2017-11到2018-11

        int yearNo = Integer.parseInt(aa[0]);
        String historyTimeStart = String.valueOf(yearNo - 1) + "-" + aa[1];
        String historyTimeEnd = forecastTimeStart;

        logger.info("==historyTimeStart==" + historyTimeStart);
        logger.info("==historyTimeEnd==" + historyTimeEnd);
        //创建集合来接受数据库数据
        List<HistoryQData> historyQDataList = new ArrayList<>();

        Map<String, Object> dataMap = Maps.newHashMap();

        EntityWrapper<HistoryQData> historyQDataEntityWrapper = new EntityWrapper<>();
        historyQDataEntityWrapper.eq("forecast_section", forecastSection);

        historyQDataEntityWrapper.between("tm", historyTimeStart, historyTimeEnd);
        historyQDataEntityWrapper.notLike("tm", historyTimeEnd);
        historyQDataList = historyQDataService.selectList(historyQDataEntityWrapper);
        logger.info("==historyQDataList==" + historyQDataList);
        logger.info("==historyQDataList.size()==" + historyQDataList.size());

        //创建装载时间的数组，长度+1是为了加上最后的预报时间
        String[] timeArr = new String[historyQDataList.size() + 1];
        //创建装载流量的数组，长度+1是为了放最后的预报值
        Double[] historyQArr = new Double[historyQDataList.size() + 1];

        int i = 0;
        for (HistoryQData historyQData: historyQDataList) {
            timeArr[i]=historyQData.getTm();
            historyQArr[i]=historyQData.getMonthQ();
            i++;
        }
        timeArr[timeArr.length-1]=forecastTime;
        historyQArr[historyQArr.length-1]=forecastValue;
        logger.info(timeArr.toString());
        logger.info(historyQArr.toString());

        //将数组放入集合
        dataMap.put("timeArr",timeArr);
        dataMap.put("historyQArr",historyQArr);

        return dataMap;

    }


}
