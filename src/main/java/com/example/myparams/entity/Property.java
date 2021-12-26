package com.example.myparams.entity;

import java.util.Arrays;

public class Property {
    //参数名
    private String propName;
    //参数值
    private Object propValue;
    //参数类型
    private String propType;
    //参数是否为空
    private boolean isNull;
    //参数枚举值
    private String[] range;
    //参数是否多个
    private boolean isSingle;
    //参数是否需要编辑
    private boolean isEdit;


    //参数下面的子函数
    private Object children;

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Object getPropValue() {
        return propValue;
    }

    public void setPropValue(Object propValue) {
        this.propValue = propValue;
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public String[] getRange() {
        return range;
    }

    public void setRange(String[] range) {
        this.range = range;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public Property() {
    }

    public Property(String propName, Object propValue, String propType, boolean isNull, String[] range, boolean isSingle, boolean isEdit,Object children) {
        this.propName = propName;
        this.propValue = propValue;
        this.propType = propType;
        this.isNull = isNull;
        this.range = range;
        this.isSingle = isSingle;
        this.isEdit = isEdit;
        this.children=children;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propName='" + propName + '\'' +
                ", propValue=" + propValue +
                ", propType='" + propType + '\'' +
                ", isNull=" + isNull +
                ", range=" + Arrays.toString(range) +
                ", isSingle=" + isSingle +
                ", isEdit=" + isEdit +
                ", children="+children+
                '}';
    }
}
