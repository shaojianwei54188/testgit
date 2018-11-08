package com.hhu.mlthfs.mapper;

import com.hhu.mlthfs.model.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author HHU
 * @since 2018-08-31
 */
public interface MenuDao extends BaseMapper<Menu> {

List<Menu>  getMenus(Map map);

}