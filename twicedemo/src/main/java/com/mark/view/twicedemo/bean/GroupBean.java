package com.mark.view.twicedemo.bean;

import java.util.List;

/**
 * 项目名称：MarkSelectDialogDemo
 * 类描述：筛选的分类实体类
 *
 * Created by mark on 2018/4/11 14:40
 * 修改人：mark
 * 修改时间：2018/4/11 14:40
 * 修改备注：
 */
public class GroupBean {
    private String typeName;
    private List<ChildBean>  childBeanList;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<ChildBean> getChildBeanList() {
        return childBeanList;
    }

    public void setChildBeanList(List<ChildBean> childBeanList) {
        this.childBeanList = childBeanList;
    }
}
