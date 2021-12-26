package com.example.myparams;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.myparams.controller.ParamController;
import com.example.myparams.entity.Params;
import com.example.myparams.service.ParamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ParamsTest {
    @Autowired
    private ParamController paramController;

    @Autowired
    private ParamService paramService;

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

    @Test
    public void testservce(){
        HashMap<String,Object> list=new HashMap<String,Object>();
        list.put("name","xirwenwen");
        list.put("age",19);

        HashMap<String, Object> params=new HashMap<String, Object>();
        params.put("name","xienwewne");
        params.put("age",18);
        list.put("info",params);
        Object[] array={params,params};
        list.put("array",array);
        paramService.tranProp(list);
        Params params1=paramService.tranProp(list);
        System.out.println(JSONObject.toJSONString(params1.getParamList(),SerializerFeature.DisableCircularReferenceDetect));

    }
}
