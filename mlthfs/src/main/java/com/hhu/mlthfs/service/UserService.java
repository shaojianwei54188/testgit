package com.hhu.mlthfs.service;

import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.model.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HHU
 * @since 2018-07-06
 */
public interface UserService extends IService<User> {

    User findUserByLoginName(String name);

    int userCount(String param);

    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 根据i查用户
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 保存用户角色关系
     * @param id
     * @param roleSet
     */
    void saveUserRoles(Long id,Set<Role> roleSet);

    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);
	
}
