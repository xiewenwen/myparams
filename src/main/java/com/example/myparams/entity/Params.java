package com.example.myparams.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class Params {

    private HashMap<String,Object> paramDetail=new HashMap<String,Object>();
    //尝试使用JSONObject
    private HashMap<String, JSONObject> paramList=new HashMap<String,JSONObject>();


    public Params() {
    }

    public HashMap<String, Object> getParamDetail() {
        return paramDetail;
    }

    public void setParamDetail(HashMap<String, Object> paramDetail) {
        this.paramDetail = paramDetail;
    }

    public HashMap<String, JSONObject> getParamList() {
        return paramList;
    }

    public void setParamList(HashMap<String, JSONObject> paramList) {
        this.paramList = paramList;
    }

    public Params(HashMap<String, Object> paramDetail, HashMap<String, JSONObject> paramList) {
        this.paramDetail = paramDetail;
        this.paramList = paramList;
    }

    @Override
    public String toString() {
        return "Params{" +
                "paramDetail=" + paramDetail +
                ", paramList=" + paramList +
                '}';
    }
}
