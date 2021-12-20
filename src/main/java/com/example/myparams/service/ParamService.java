package com.example.myparams.service;

import com.alibaba.fastjson.JSONObject;
import com.example.myparams.entity.Params;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface ParamService {
    public Params tranParams(String p);

    Params tranProp(HashMap<String, Object> hashMap);

}
