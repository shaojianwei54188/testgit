package com.hhu.mlthfs.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hhu.mlthfs.model.ClimateIndex;
import com.hhu.mlthfs.model.vo.ClimateIndexVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HHU
 * @since 2018-07-26
 */
public interface ClimateIndexService extends IService<ClimateIndex> {
    /**
     * 接口，根据时间查询气候因子
     * @param tm
     * @return
     */
//    ClimateIndexVO findClimateIndexByTime(@Param("tm")  String tm);

    Page<ClimateIndexVO> selectClimateIndexListByTime(Page<ClimateIndexVO> page, String tm,Wrapper<ClimateIndexVO> wrapper);


}
