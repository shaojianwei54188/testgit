package com.hhu.mlthfs.model;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hhu.mlthfs.base.DataEntity;

import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author HHU
 * @since 2018-07-06
 */
@TableName("sys_role")
@KeySequence(value = "sys_role_seq",clazz = Long.class)
public class Role extends DataEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @TableField("name")
	private String name;

    @TableField(exist = false)
    private Set<User> userSet;

	/**
	 * getter/setter
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
}
