package com.hhu.mlthfs.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.mapper.RoleDao;
import com.hhu.mlthfs.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-07-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    /**
     * 得到全部角色
     * @return roleList
     */
    @Override
    public List<Role> selectAll() {
        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        List<Role> roleList=baseMapper.selectList(wrapper);
        return roleList;
    }
}
