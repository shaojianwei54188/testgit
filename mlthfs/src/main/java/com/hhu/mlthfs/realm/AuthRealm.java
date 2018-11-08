package com.hhu.mlthfs.realm;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.hhu.mlthfs.model.Menu;
import com.hhu.mlthfs.model.Role;
import com.hhu.mlthfs.model.User;
import com.hhu.mlthfs.service.UserService;
import com.hhu.mlthfs.utils.Constants;
import com.hhu.mlthfs.utils.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Set;

@Component(value = "authRealm")
public class AuthRealm extends AuthorizingRealm {
    private static final Logger logger= LoggerFactory.getLogger(AuthRealm.class);

    @Autowired
    @Lazy
    private UserService userService;

    /**
     * 登陆认证
     * doGetAuthorizationInfo
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("------登录认证---doGetAuthorizationInfo方法开始调用--------------");

        ShiroUser shiroUser = (ShiroUser)principalCollection.getPrimaryPrincipal();

        User user = userService.findUserByLoginName(shiroUser.getLoginName());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //得到user的角色
        Set<Role> roles = user.getRoleLists();
        Set<String> roleNames = Sets.newHashSet();
        //遍历角色，添加给roleNames
        for (Role role : roles) {
            if(StringUtils.isNotBlank(role.getName())){
                roleNames.add(role.getName());
            }
        }

        //得到user的权限
        Set<Menu> menus = user.getMenus();
        Set<String> permissions = Sets.newHashSet();
        //遍历权限，封装给permission
        for (Menu menu : menus) {
            if(StringUtils.isNotBlank(menu.getPermission())){
                permissions.add(menu.getPermission());
            }
        }
        info.setRoles(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 授权
     * doGetAuthenticationInfo
     * 在这个方法中，进行身份验证
     * SimpleAuthenticationInfo(user对象，从数据库中获取的password，当前realm的名称)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("-----授权----doGetAuthenticationInfo方法开始调用------------");

        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username= (String) token.getPrincipal();

        logger.info("----------需要验证的username："+username);

        User user =userService.findUserByLoginName(username);

        if(user == null){
            throw new UnknownAccountException();//没找到账号
        }

        byte[] salt= Encodes.decodeHex(user.getSalt());
        logger.info("---------------salt:"+salt);
        ShiroUser shiroUser=new ShiroUser(user.getId()
                                        ,user.getLoginName()
                                        ,user.getNickName());
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
                        shiroUser
                        ,user.getPassword()
                        , ByteSource.Util.bytes(salt)
                        ,getName() //realm name
        );
        return authenticationInfo;
    }

    public void removeUserAuthorizationInfoCache(String username){

        SimplePrincipalCollection pc=new SimplePrincipalCollection();
        pc.add(username,super.getName());
        super.clearCachedAuthorizationInfo(pc);
    }

    /**
     * 密码校验
     * HashedCredentialsMatcher中的doCredentialsMatch（）方法进行密码匹配
     * matcher设置加密方法和迭代次数
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        //新定义密码校验规则
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher(Constants.HASH_ALGORITHM);
        matcher.setHashIterations(Constants.HASH_INTERATIONS);
        //将新的校验规则给shiro
        setCredentialsMatcher(matcher);
    }

    /**
     * 自定义Authentication对象，
     * 使得Subject除了携带用户的登录名外还可以携带更多信息.
     */
    public static class ShiroUser implements Serializable{

        private static final long serialVersionUID = 357045558440493710L;

        public Long id;
        public String loginName;
        public String nickName;

        public ShiroUser(Long id, String loginName, String nickName) {
            this.id = id;
            this.loginName = loginName;
            this.nickName = nickName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return nickName;
        }
        /**
         * 重载hashCode,只计算loginName;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(loginName);
        }

        /**
         * 重载equals,只计算loginName;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ShiroUser other = (ShiroUser) obj;
            if (loginName == null) {
                return other.loginName == null;
            } else return loginName.equals(other.loginName);
        }
    }


}
