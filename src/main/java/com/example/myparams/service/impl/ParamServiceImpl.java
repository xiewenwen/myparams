package com.example.myparams.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myparams.entity.Params;
import com.example.myparams.entity.Property;
import com.example.myparams.service.ParamService;
import com.example.myparams.util.ParamDealUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

@Service("paramService")
public class ParamServiceImpl implements ParamService {

    @Override
    public Params tranParams(String p) {
        Params param=new Params();
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        hashMap.put("1","001");
        param.setParamDetail(hashMap);
        System.out.println("进入service");
        return param;
    }

    @Override
    public Params tranProp(HashMap<String, Object> hashMap) {
        Params params=new Params();
        HashMap<String, JSONObject> paramlist=new HashMap<String, JSONObject>();
        for (String key:hashMap.keySet()){
            Property property=new Property();
            Object value=hashMap.get(key);
            property.setPropName(key);
            property.setPropValue(value);
            //获取child子参数
            property.setChildren(ParamDealUtil.getParamDeal(value));
            JSONObject jsonObject=JSONObject.parseObject(JSONObject.toJSONString(property));
            paramlist.put(property.getPropName(),jsonObject);

        }
        params.setParamList(paramlist);
        return params;
    }
}
