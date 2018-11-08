package com.hhu.mlthfs.model;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.hhu.mlthfs.base.TreeEntity;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 
 * </p>
 *
 * @author HHU
 * @since 2018-08-31
 */
@TableName("sys_menu")
@KeySequence(value = "sys_menu_seq",clazz = Long.class)
public class Menu extends TreeEntity<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
	private String name;

    /**
     * 链接地址
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String menuHref;
    /**
     * 打开方式
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String target;
    /**
     * 图标
     */
	private String icon;
    /**
     * 显示背景色
     */
	@TableField("bg_color")
	private String bgColor;
    /**
     * 是否显示
     */
	@TableField(value="is_show",strategy= FieldStrategy.IGNORED)
	private Integer isShow;
    /**
     * 权限标识
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String permission;

	@TableField(exist = false)
	private Integer dataCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 0, max = 1000, message = "icon长度必须介于 1 和 1000 之间")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParentId() {
		return parentId;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}
}
