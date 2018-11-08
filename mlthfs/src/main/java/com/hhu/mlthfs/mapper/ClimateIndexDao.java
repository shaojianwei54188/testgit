package com.hhu.mlthfs.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hhu.mlthfs.model.ClimateIndex;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hhu.mlthfs.model.vo.ClimateIndexVO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author HHU
 * @since 2018-07-26
 */
public interface ClimateIndexDao extends BaseMapper<ClimateIndex> {

    /**
     * 根据时间查询130项气候因子
     * @param tm
     * @return
     */

    List<ClimateIndexVO> findClimateIndexListByTime(com.baomidou.mybatisplus.plugins.pagination.Pagination page,
                                                    @Param("tm")  String tm,
                                                    @Param("ew") Wrapper<ClimateIndexVO> wrapper);




}