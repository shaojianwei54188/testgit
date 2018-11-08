package com.hhu.mlthfs.controller.datainfo;

import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.base.BaseController;
import com.hhu.mlthfs.model.vo.WaterInfoVo;
import com.hhu.mlthfs.utils.DateUtil;
import com.hhu.mlthfs.utils.LayerData;
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
 * 水情数据控制层
 *
 * 包括河道水情、水库水情数据
 */

@RestController
@RequestMapping("/data")
public class WaterInfoController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(BasicInfoController.class);


    /**
     * 进入水情数据界面
     * @return html
     */
    @GetMapping("/waterInfoPage")
    public ModelAndView waterInfoPage(){
        ModelAndView mav=new ModelAndView("page/datainfo/hydro_info/waterInfo");
        return mav;
    }

    /**
     * 返回水情数据
     *
     *
     * 河道水情数据（根据sttdrcd=5的数据计算）
     *      4月的平均值需要的时间范围
     *          2018-04-01 08:00:00 < idtm <= 2018-05-01 08:00:00
     * 水库水情数据
     *       站码：61802700   丹江口水库  根据sttdrcd=5的数据计算  时间范围： 2018-04-01 08:00:00 < idtm <= 2018-05-01 08:00:00
     *       站码：60106980   三峡       根据sttdrcd=1的数据计算   时间范围： 2018-04-02 08:00:00 <= idtm < 2018-05-02 08:00:00
     *
     * @param  startTm 前端页面传入的月份，月份默认显示上个月的时间
     * @param endTm    前端传入月份的下一月
     */
    @GetMapping("/waterInfo")
    public LayerData<WaterInfoVo> list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit",defaultValue = "130") Integer limit,
                                       @RequestParam(value="startTm",defaultValue = "2018-04") String startTm,
                                       @RequestParam(value="endTm",defaultValue = "2018-05") String endTm,
                                       ServletRequest request){
        Map map= WebUtils.getParametersStartingWith(request,"s_");
        if(!map.isEmpty()){
            String keys= (String) map.get("startTm");
            logger.info("=====================keys=============="+keys);
            startTm=keys;
            endTm=DateUtil.getPreMonth(startTm);
            logger.info("=====================endTm=============="+endTm);

        }else if(map.isEmpty()){
            startTm= DateUtil.getLastMonth2();
            endTm=DateUtil.getPreMonth(startTm);
        }
        LayerData<WaterInfoVo> waterInfoVoLayerData=new LayerData<>();
        Page<WaterInfoVo> waterInfoVoPage=rvavRService.findWaterInfoListByMonth(new Page<>(page,limit),startTm,endTm);
        waterInfoVoLayerData.setData(waterInfoVoPage.getRecords());
        waterInfoVoLayerData.setCount(waterInfoVoPage.getTotal());
        logger.info("=====================waterInfoVoLayerData=============="+waterInfoVoLayerData.toString());
        return waterInfoVoLayerData;
    }

}
