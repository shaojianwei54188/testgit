package com.hhu.mlthfs.base;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public abstract class TreeEntity<T extends Model> extends DataEntity<T> {


    private static final long serialVersionUID = 8113016637288210273L;
    /**
     * 父菜单
     */
    @TableField(value = "parent_id")
    protected Long parentId;

    /**
     * 菜单层级
     * 节点层次（第一层，第二层，第三层....）
     */
    @TableField(value = "menu_level")
    protected Integer menuLevel;

    /**
     * 父菜单联集
     */
    @TableField(value = "parent_ids")
    protected String parentIds;

    /**
     * 排序
     */
    @TableField(value = "menu_sort")
    protected Integer menuSort;

    @TableField(exist = false)
    protected List<T> children;

    @TableField(exist = false)
    protected T parentTree;

    public TreeEntity() {
        super();
        this.menuSort = 30;
    }
    public TreeEntity(Long id) {
        super(id);
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getParentIds() {
        return parentIds;
    }

    @Length( max = 1000, message = "路径长度必须介于 1 和 1000 之间")
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public T getParentTree() {
        return parentTree;
    }

    public void setParentTree(T parentTree) {
        this.parentTree = parentTree;
    }
}
