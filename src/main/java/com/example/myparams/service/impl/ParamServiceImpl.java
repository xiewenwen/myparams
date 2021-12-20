package com.example.myparams.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myparams.entity.Params;
import com.example.myparams.entity.Property;
import com.example.myparams.service.ParamService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

@Service
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
        for(String key:hashMap.keySet()){
            Object value=hashMap.get(key);
            Property property=new Property();
            property.setPropName(key);
            property.setPropValue(value);
            property.setEdit(true);
            property.setNull(false);
            property.setRange(null);
            property.setSingle(true);
            property.setPropType(value.getClass().toString());

            JSONObject jsonObject=JSONObject.parseObject(JSONObject.toJSONString(property));
            paramlist.put(key,jsonObject);

//            if(value.getClass().isArray());{
//
//            }
        }
        params.setParamList(paramlist);
        return params;
    }
}
