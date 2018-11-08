package com.hhu.mlthfs.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hhu.mlthfs.model.ForecastDataResult;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hhu.mlthfs.model.vo.ClimateIndexVO;
import com.hhu.mlthfs.model.vo.ForecastDepartureVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author HHU
 * @since 2018-10-24
 */
public interface ForecastDataResultDao extends BaseMapper<ForecastDataResult> {

    List<ForecastDepartureVo> findForecastDepartureByTimeAndSection(com.baomidou.mybatisplus.plugins.pagination.Pagination page,
                                                                    @Param("forecastTimeStart")  String forecastTimeStart,
                                                                    @Param("forecastSection")  String forecastSection,
                                                                    @Param("ew") Wrapper<ForecastDepartureVo> wrapper

    );
}