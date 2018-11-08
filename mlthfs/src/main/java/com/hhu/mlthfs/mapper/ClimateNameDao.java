package com.hhu.mlthfs.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hhu.mlthfs.model.ClimateName;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author HHU
 * @since 2018-07-24
 */
public interface ClimateNameDao extends BaseMapper<ClimateName> {

    List<ClimateName> findAllClimateName();

}