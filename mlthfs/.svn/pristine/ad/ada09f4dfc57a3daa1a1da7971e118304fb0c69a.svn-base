package com.hhu.mlthfs.mapper;

import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author HHU
 * @since 2018-07-06
 */
@Repository
public interface UserDao extends BaseMapper<User> {

   User selectUserByMap(Map<String, Object> map);

    /**
     * 保存用户角色关系
     * @param id
     * @param roles
     */
    void saveUserRoles(@Param("userId")Long id, @Param("roleIds")Set<Role> roles);


}