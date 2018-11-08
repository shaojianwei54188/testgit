package com.hhu.mlthfs.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.model.ForecastDataResult;
import com.baomidou.mybatisplus.service.IService;
import com.hhu.mlthfs.model.vo.ForecastDepartureVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HHU
 * @since 2018-10-24
 */
public interface ForecastDataResultService extends IService<ForecastDataResult> {

    /**
     * 根据
     *
     * 起报时间
     * 断面
     *
     * 查询  预报距平
     *
     */
    Page<ForecastDepartureVo> selectForecastDepartureByTimeAndSection(Page<ForecastDepartureVo> page,
                                                                      String ForecastTimeStart,
                                                                      String ForecastSection,
                                                                      Wrapper<ForecastDepartureVo> wrapper);



}
