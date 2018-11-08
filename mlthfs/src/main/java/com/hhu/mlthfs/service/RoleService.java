package com.hhu.mlthfs.service;

import com.hhu.mlthfs.model.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HHU
 * @since 2018-07-06
 */
public interface RoleService extends IService<Role> {


    /**
     * 返回所有角色
     *
     * @return 角色列表
     */
    List<Role> selectAll();

	
}
