package com.hhu.mlthfs.service.impl;

import com.hhu.mlthfs.model.Menu;
import com.hhu.mlthfs.mapper.MenuDao;
import com.hhu.mlthfs.service.MenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-08-31
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Override
    public List<Menu> selectAllMenus(Map<String, Object> map) {
        return baseMapper.getMenus(map);
    }
}
