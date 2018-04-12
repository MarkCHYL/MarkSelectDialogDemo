package com.mark.view.markselectdialogdemo.bean;

import java.util.ArrayList;
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
public class MarkSelectBean {
    private String typeName;
    private List<MarkItemChildBean>  childBeanList;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<MarkItemChildBean> getChildBeanList() {
        return childBeanList;
    }

    public void setChildBeanList(List<MarkItemChildBean> childBeanList) {
        this.childBeanList = childBeanList;
    }
}
