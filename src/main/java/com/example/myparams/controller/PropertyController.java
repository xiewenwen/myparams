package com.example.myparams.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.myparams.entity.Params;
import com.example.myparams.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin
public class PropertyController {
    @Autowired
    public ParamService paramService;

    @RequestMapping("transProps")
    public String transProp(@RequestBody HashMap<String, Object> hashMap){
        System.out.println(hashMap.toString());
       Params params= paramService.tranProp(hashMap);
        System.out.println(JSONObject.toJSONString(params.getParamList()));
       return  JSONObject.toJSONString(params.getParamList());
    }


}
