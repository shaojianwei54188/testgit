package com.hhu.mlthfs.controller.forecast;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.ForecastDataResult;
import com.hhu.mlthfs.model.ForecastReleaseResult;
import com.hhu.mlthfs.model.HistoryQData;
import com.hhu.mlthfs.model.vo.ForecastDepartureVo;
import com.hhu.mlthfs.utils.LayerData;
import com.hhu.mlthfs.utils.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 作业预报执行  控制层
 */
@RestController
@RequestMapping("/forecast")
public class DoForecastController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(DoForecastController.class);

    /**
     * 系统进入作业预报界面
     *
     * @return
     */
    @GetMapping("/doForecastPage")
    public ModelAndView doForecastPageIndex() {
        ModelAndView mav = new ModelAndView("page/forecast/DoForecast/doForecastPage");
        return mav;
    }

    /**
     * 作业预报界面，显示七大方案的预报距平值的表格数据
     *
     * @param page
     * @param limit
     * @param forecastSection
     * @param forecastTimeStart
     * @param request
     * @return
     */
    @GetMapping("/doForecastInfo")
    public LayerData<ForecastDepartureVo> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                               @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                                               @RequestParam(value = "forecastSection", defaultValue = "") String forecastSection,
                                               @RequestParam(value = "forecastTimeStart", defaultValue = "") String forecastTimeStart,
                                               ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ForecastDepartureVo> forecastDepartureVoLayerData = new LayerData<>();
        EntityWrapper<ForecastDepartureVo> forecastDepartureVoEntityWrapper = new EntityWrapper<>();
        forecastSection = (String) map.get("section");
        forecastTimeStart = (String) map.get("forecastTimeStart");
        Page<ForecastDepartureVo> forecastDepartureVoPage = forecastDataResultService.
                selectForecastDepartureByTimeAndSection(new Page<>(page, limit),
                        forecastTimeStart,
                        forecastSection,
                        forecastDepartureVoEntityWrapper);
        forecastDepartureVoLayerData.setData(forecastDepartureVoPage.getRecords());
        forecastDepartureVoLayerData.setCount(forecastDepartureVoPage.getTotal());
        return forecastDepartureVoLayerData;

    }


    @GetMapping("/doForecastInfo2")
    public LayerData<ForecastDataResult> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                                              String forecastSection,
                                              String modelName,
                                              String forecastTimeStart
    ) {
        LayerData<ForecastDataResult> forecastDataResultLayerData = new LayerData<>();
        EntityWrapper<ForecastDataResult> forecastDataResultEntityWrapper = new EntityWrapper<>();
        forecastDataResultEntityWrapper.eq("forecast_section", forecastSection);
        forecastDataResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);
        forecastDataResultEntityWrapper.eq("plan_name", modelName);

        Page<ForecastDataResult> forecastDepartureVoPage = forecastDataResultService.selectPage(new Page<>(page, limit), forecastDataResultEntityWrapper);
        forecastDataResultLayerData.setData(forecastDepartureVoPage.getRecords());
        forecastDataResultLayerData.setCount(forecastDepartureVoPage.getTotal());
        return forecastDataResultLayerData;
    }


    /**
     * 点击 对比按钮 跳转到对比界面，左图右表
     * 显示的内容是同一预报月份的七大模型的对比值
     *
     * @param page
     * @param limit
     * @param forecastTime
     * @param forecastTimeStart
     * @param forecastSection
     * @param model
     * @return
     */
    @GetMapping("/editPage")
    public ModelAndView edit(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                             String forecastTime,
                             String forecastTimeStart,
                             String forecastSection,
                             Model model) {
        LayerData<ForecastDataResult> forecastDataResultLayerData = new LayerData<>();
        EntityWrapper<ForecastDataResult> forecastDataResultEntityWrapper = new EntityWrapper<>();
        forecastDataResultEntityWrapper.eq("forecast_section", forecastSection);
        forecastDataResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);
        forecastDataResultEntityWrapper.eq("forecast_time", forecastTime);
        forecastDataResultEntityWrapper.eq("plan_name", "综合预报");

        Page<ForecastDataResult> forecastDepartureVoPage = forecastDataResultService.selectPage(new Page<>(page, limit), forecastDataResultEntityWrapper);
        forecastDataResultLayerData.setData(forecastDepartureVoPage.getRecords());
        forecastDataResultLayerData.setCount(forecastDepartureVoPage.getTotal());
        Double bma = forecastDataResultLayerData.getData().get(0).getForecastValue();
        model.addAttribute("forecastTimeStart", forecastTimeStart);
        model.addAttribute("forecastTime", forecastTime);
        model.addAttribute("forecastSection", forecastSection);
        model.addAttribute("bma", bma);
        ModelAndView mav = new ModelAndView("page/forecast/DoForecast/edit");
        return mav;
    }

    /**
     * 点击各个方案的曲线图表，跳转到详情界面，展示的是同一方案预报的12个月的预报值
     *
     * @param forecastSection
     * @param forecastTimeStart
     * @param modelName
     * @param model
     * @return
     */
    @GetMapping("/info")
    public ModelAndView info(String forecastSection,
                             String forecastTimeStart,
                             String modelName,
                             Model model) {
        model.addAttribute("modelName", modelName);
        model.addAttribute("forecastSection", forecastSection);
        model.addAttribute("forecastTimeStart", forecastTimeStart);
        ModelAndView mav = new ModelAndView("page/forecast/DoForecast/info");
        return mav;
    }

    /**
     * 获取单方案的12个月的信息
     * 用于画图展示
     *
     * @param request
     * @param modelName
     * @param forecastTimeStart
     * @param forecastSection
     * @return
     */
    @GetMapping("/getInfo")
    public Map<String, Object> getInfoList(ServletRequest request,
                                           String modelName,
                                           String forecastTimeStart,
                                           String forecastSection) {
        //创建集合来接受数据库数据
        List<ForecastDataResult> forecastDataResultList = new ArrayList<>();

        List<HistoryQData> historyQDataList = new ArrayList<>();

        //存放数组
        Map<String, Object> dataMap = Maps.newHashMap();
        EntityWrapper<ForecastDataResult> forecastDataResultEntityWrapper = new EntityWrapper<>();
        forecastDataResultEntityWrapper.eq("plan_name", modelName);
        forecastDataResultEntityWrapper.eq("forecast_section", forecastSection);
        forecastDataResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);

        forecastDataResultList = forecastDataResultService.selectList(forecastDataResultEntityWrapper);

        EntityWrapper<HistoryQData> historyQDataEntityWrapper = new EntityWrapper<>();

        historyQDataEntityWrapper.ge("tm", "2012-" + forecastTimeStart.substring(forecastTimeStart.length() - 2));
        historyQDataEntityWrapper.eq("forecast_section", forecastSection);
        historyQDataList = historyQDataService.selectList(historyQDataEntityWrapper);


        //创建装载模型名称的数组
        String[] timeArr = new String[forecastDataResultList.size()];

        //创建装载预报值的数组
        Double[] forecastValueArr = new Double[forecastDataResultList.size()];
        //创建装载历史均值的数组
        Double[] historyAverageValueArr = new Double[forecastDataResultList.size()];
        //创建装载历史最大值的数组
        Double[] historyMaxValueArr = new Double[12];
        //创建装载历史最大值的数组
        Double[] historyMinValueArr = new Double[12];

        //定义数组下标
        int i = 0;
        for (ForecastDataResult forecastDataResult : forecastDataResultList) {
            timeArr[i] = forecastDataResult.getForecastTime();
            forecastValueArr[i] = forecastDataResult.getForecastValue();
            historyAverageValueArr[i] = forecastDataResult.getHistoryAverage();
            i++;
        }

        int j = 0;
        for (j = 0; j < 12; j++) {
            historyMaxValueArr[j] = historyQDataList.get(j).getMonthMaxQ();
            historyMinValueArr[j] = historyQDataList.get(j).getMonthMinQ();
        }
        //将数组放入集合
        dataMap.put("timeArr", timeArr);
        dataMap.put("forecastValueArr", forecastValueArr);
        dataMap.put("historyAverageValueArr", historyAverageValueArr);
        dataMap.put("monthMaxValueArr", historyMaxValueArr);
        dataMap.put("monthMinValueArr", historyMinValueArr);
        return dataMap;
    }


    /**
     * 获取对比信息，作图
     *
     * @param request
     * @param forecastTime
     * @param forecastTimeStart
     * @param forecastSection
     * @return
     */
    @GetMapping("/editInfo")
    public Map<String, Object> getForecastResultList(ServletRequest request,
                                                     String forecastTime,
                                                     String forecastTimeStart,
                                                     String forecastSection) {
        //创建集合来接受数据库数据
        List<ForecastDataResult> forecastDataResultList = new ArrayList<>();
        List<HistoryQData> historyQDataList = new ArrayList<>();
        //存放数组
        Map<String, Object> dataMap = Maps.newHashMap();
        EntityWrapper<ForecastDataResult> forecastDataResultEntityWrapper = new EntityWrapper<>();
        forecastDataResultEntityWrapper.eq("forecast_time", forecastTime);
        forecastDataResultEntityWrapper.eq("forecast_section", forecastSection);
        forecastDataResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);

        forecastDataResultList = forecastDataResultService.selectList(forecastDataResultEntityWrapper);

        //创建装载模型名称的数组
        String[] modelArr = new String[forecastDataResultList.size()];
        //创建装载预报值的数组
        Double[] forecastValueArr = new Double[forecastDataResultList.size()];
        //创建装载历史均值的数组
        Double[] historyAverageValueArr = new Double[forecastDataResultList.size()];
        //定义数组下标
        int i = 0;
        for (ForecastDataResult forecastDataResult : forecastDataResultList) {
            modelArr[i] = forecastDataResult.getPlanName();
            forecastValueArr[i] = forecastDataResult.getForecastValue();
            historyAverageValueArr[i] = forecastDataResult.getHistoryAverage();
            i++;
        }
        EntityWrapper<HistoryQData> historyQDataEntityWrapper = new EntityWrapper<>();
        historyQDataEntityWrapper.eq("forecast_section", forecastSection);
        historyQDataEntityWrapper.eq("tm", "2012-" + forecastTime.substring(forecastTime.length() - 2));
        historyQDataList = historyQDataService.selectList(historyQDataEntityWrapper);

        //将数组放入集合
        dataMap.put("modelArr", modelArr);
        dataMap.put("forecastValueArr", forecastValueArr);
        dataMap.put("historyAverageValueArr", historyAverageValueArr);
        dataMap.put("monthMaxValueArr", historyQDataList.get(0).getMonthMaxQ());
        dataMap.put("monthMinValueArr", historyQDataList.get(0).getMonthMinQ());
        return dataMap;
    }


    /**
     * 展示 多个模型，同一个月的预报结果列表
     *
     * @param page
     * @param limit
     * @param forecastSection
     * @param forecastTime
     * @param forecastTimeStart
     * @return
     */

    @GetMapping("/editInfo2")
    public LayerData<ForecastDataResult> list2(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                               @RequestParam(value = "limit", defaultValue = "12") Integer limit,
                                               String forecastSection,
                                               String forecastTime,
                                               String forecastTimeStart) {

        LayerData<ForecastDataResult> forecastDataResultLayerData = new LayerData<>();

        EntityWrapper<ForecastDataResult> forecastDataResultEntityWrapper = new EntityWrapper<>();
        forecastDataResultEntityWrapper.eq("forecast_section", forecastSection);
        forecastDataResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);
        forecastDataResultEntityWrapper.eq("forecast_time", forecastTime);

        Page<ForecastDataResult> forecastDepartureVoPage = forecastDataResultService.selectPage(new Page<>(page, limit), forecastDataResultEntityWrapper);
        forecastDataResultLayerData.setData(forecastDepartureVoPage.getRecords());
        forecastDataResultLayerData.setCount(forecastDepartureVoPage.getTotal());

        return forecastDataResultLayerData;

    }

    /**
     * 手动添加提交发布结果
     */
    @PostMapping("/addInfo")
    public RestResponse add(@RequestBody ForecastReleaseResult forecastReleaseResult,
                            String forecastTimeStart) {

        forecastReleaseResult.setId(null);
        forecastReleaseResult.setForecastTimeStart(forecastTimeStart);

        //首先根据断面名称+起报时间+预报时间+模型名称（综合预报）查出综合预报的值bmaSysValue
        EntityWrapper<ForecastDataResult> forecastDataResultEntityWrapper = new EntityWrapper<>();
        forecastDataResultEntityWrapper.eq("forecast_section", forecastReleaseResult.getForecastSection());
        forecastDataResultEntityWrapper.eq("forecast_time_start", forecastTimeStart);
        forecastDataResultEntityWrapper.eq("forecast_time", forecastReleaseResult.getForecastTime());
        forecastDataResultEntityWrapper.eq("plan_name", "综合预报");
        //查出系统中的综合预报的值
        Double bmaSysValue = forecastDataResultService.selectOne(forecastDataResultEntityWrapper).getForecastValue();

//        logger.info("==bmaSysValue===" + bmaSysValue);
//        logger.info("==forecastReleaseResult.getForecastValue()===" + forecastReleaseResult.getForecastValue());
//        System.out.println("判断：" + (bmaSysValue.equals(forecastReleaseResult.getForecastValue())));

        if (bmaSysValue.equals(forecastReleaseResult.getForecastValue())) {
            forecastReleaseResult.setReleaseType(0);
            forecastReleaseResult.setReleasePerson("系统");
            forecastReleaseResult.setModelName("综合预报");
        } else {
            forecastReleaseResult.setReleaseType(1);
            forecastReleaseResult.setReleasePerson("预报员");//TODO 换成当前登录人姓名
            forecastReleaseResult.setModelName(null);
        }

//        System.out.println(forecastReleaseResult);

        forecastReleaseResultService.insert(forecastReleaseResult);

//        System.out.println(forecastReleaseResult.getId());
        return RestResponse.success();
    }
}
