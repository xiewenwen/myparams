package com.example.myparams;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.myparams.controller.ParamController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParamsTest {
    @Autowired
    ParamController paramController;
    @Test
    public void testTransParam(){
        String params="{\n" +
                "\"name\":\"xiewenwen\",\n" +
                "\"age\":17,\n" +
                "\"hobbies\":[\"eat\",\"drink\",\"sleep\"],\n" +
                "\"rules\":[{\"sorce\":100,\"type\":\"effect\"},{\"sorce\":80,\"type\":\"complate\"}]\n" +
                "}";
        JSONObject json = JSON.parseObject(params);
        HashMap<String,Object> list=new HashMap<String,Object>();
        Iterator iterator=json.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key=entry.getKey().toString();
            Object value=entry.getValue();
//            System.out.print(entry.getKey().toString());
//            System.out.println(entry.getValue().toString());
            list.put(key,value);
        }
        for (String s:list.keySet()){
            System.out.println(list.get(s));
        }
    }
}
