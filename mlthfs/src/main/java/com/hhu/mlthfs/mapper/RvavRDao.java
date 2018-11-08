package com.hhu.mlthfs.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hhu.mlthfs.model.RvavR;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hhu.mlthfs.model.vo.WaterInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author HHU
 * @since 2018-08-02
 */
public interface RvavRDao extends BaseMapper<RvavR> {


//    List<ClimateIndexVO> findClimateIndexListByTime(com.baomidou.mybatisplus.plugins.pagination.Pagination page,
//                                                    @Param("tm")  String tm,
//                                                    @Param("ew") Wrapper<ClimateIndexVO> wrapper);


    /**
     * 根据月份返回水情的月平均值
     * @param page
     * @return
     */

    List<WaterInfoVo> findWaterInfoListByMonth(Pagination page,
                                               @Param("startTm") String startTm,
                                               @Param("endTm") String endTm);
}