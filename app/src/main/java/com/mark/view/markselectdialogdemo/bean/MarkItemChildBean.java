package com.mark.view.markselectdialogdemo.bean;

/**
 * 项目名称：MarkSelectDialogDemo
 * 类描述：子分类的实体类
 * Created by mark on 2018/4/11 14:42
 * 修改人：mark
 * 修改时间：2018/4/11 14:42
 * 修改备注：
 */
public class MarkItemChildBean {
    private String value;
    private int id;
    private boolean isSelected;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
