package com.hhu.mlthfs.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.model.User;
import com.hhu.mlthfs.mapper.UserDao;
import com.hhu.mlthfs.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hhu.mlthfs.utils.ToolUtil;
import com.sun.media.sound.SF2GlobalRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-07-06
 */
@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public User findUserByLoginName(String name) {
        Map<String,Object> map=Maps.newHashMap();
        map.put("loginName",name);
        User u=baseMapper.selectUserByMap(map);
        return u;
    }

    @Override
    public int userCount(String param) {
        EntityWrapper<User> wrapper=new EntityWrapper<>();
        wrapper.eq("login_name",param)
                .or()
                .eq("email",param)
                .or()
                .eq("tel",param);
        int count=baseMapper.selectCount(wrapper);
        return count;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public User saveUser(User user) {
        ToolUtil.entryptPassword(user);
        baseMapper.insert(user);
        return findUserById(user.getId())  ;

    }

    @Override
    public User findUserById(Long id) {
        Map<String,Object> map= Maps.newHashMap();
        map.put("id",id);
        return baseMapper.selectUserByMap(map);

    }
    @Override
    public void saveUserRoles(Long id, Set<Role> roleSet) {
        baseMapper.saveUserRoles(id,roleSet);
    }

    /**
     * 删除用户
     *
     * @param user
     */
    @Override
    public void deleteUser(User user) {
        user.setDelFlag(true);
        user.updateById();

    }
}
