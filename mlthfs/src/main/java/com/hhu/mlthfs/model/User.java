package com.hhu.mlthfs.model;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.google.common.collect.Sets;
import com.hhu.mlthfs.base.DataEntity;
import lombok.Data;

import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author HHU
 * @since 2018-07-05
 */
@Data
@TableName("sys_user")
@KeySequence(value = "sys_user_seq",clazz = Long.class)
public class User extends DataEntity<User> {
    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    @TableField("login_name")
	private String loginName;
    /**
     * 昵称
     */
    @TableField(value = "nick_name",strategy= FieldStrategy.IGNORED)
	private String nickName;
    /**
     * 密码
     */
	private String password;
    /**
     * shiro加密盐
     */
	private String salt;
    /**
     * 电话
     */
    @TableField(strategy = FieldStrategy.IGNORED)
	private String tel;
    /**
     * 邮箱
     */
    @TableField(strategy = FieldStrategy.IGNORED)
	private String email;

	/**
	 * 角色列表
	 */

	@TableField(exist = false)
    private Set<Role> roleLists= Sets.newHashSet();

	/**
	 * 菜单列表
	 */
	@TableField(exist=false)
	private Set<Menu> menus = Sets.newHashSet();


    /**
     * getter/setter
     */
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public Set<Role> getRoleLists() {
        return roleLists;
    }

    public void setRoleLists(Set<Role> roleLists) {
        this.roleLists = roleLists;
    }

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
}
