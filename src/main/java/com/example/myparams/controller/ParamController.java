package com.example.myparams.controller;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.myparams.entity.Params;
import com.example.myparams.service.ParamService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Arrays;


import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@CrossOrigin
public class ParamController {
    @Autowired
    public ParamService paramService;
    @RequestMapping("transParams")
    public String transParmas(@RequestBody String params){
        String params1="{\n" +
                "\"name\":\"xiewenwen\",\n" +
                "\"age\":17,\n" +
                "\"hobbies\":[\"eat\",\"drink\",\"sleep\"],\n" +
                "\"rules\":[{\"sorce\":100,\"type\":\"effect\"},{\"sorce\":80,\"type\":\"complate\"}]\n" +
                "}";
        System.out.println(params);
        //字符串转json对象
        JSONObject jsonAll = JSON.parseObject(params);
        String p=jsonAll.getString("params");
      JSONObject json=JSON.parseObject(p);
//        JSONArray json = JSONArray.parseArray(p);
        System.out.println("P======="+json.toJSONString());
//        HashMap<String,Object> list=new HashMap<String,Object>();

        int count=0;
        //迭代遍历json对象 封装成数组
        Iterator iterator=json.entrySet().iterator();
        String [] a=new String[json.size()];
        while (iterator.hasNext()) {
            HashMap<String,Object> list=new HashMap<String,Object>();
            Map.Entry entry = (Map.Entry) iterator.next();
            String key=entry.getKey().toString();
            Object value=entry.getValue();
            JSONObject param=new JSONObject();
            System.out.println("VALUE======="+value.toString());
//            list.put(key,value);
            param.put(key,value);
            if(value instanceof String){
//                list.put("type","String");
                param.put("type","string");
            }
            else if(value instanceof Integer){
//                list.put("type","String");
                param.put("type","int");
            }
            else {
                param.put("type","array");
//                list.put("type","array");
            }
            a[count]=param.toJSONString();
            count++;
        }

    return JSON.toJSONString(a);
    }

    @RequestMapping("tParams")
    public String trPrams(@RequestBody HashMap<String,Object> hashMap){
        System.out.println(hashMap.toString());
        for (String s:hashMap.keySet()){
            System.out.println("------"+s);
        }
        Params params=new Params();
        params.setParamDetail(hashMap);
        paramService.tranParams("SD");
        return JSON.toJSONString(params);
    }
}
