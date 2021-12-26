package com.example.myparams.util;

import com.alibaba.fastjson.JSONObject;
import com.example.myparams.entity.Params;
import com.example.myparams.entity.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParamDealUtil {

//    public static List<Object> clist=new ArrayList<Object>();

    public static Object getParamDeal(Object object) {
        System.out.println(object.getClass().toString());
        Property property=new Property();
        List<Property> list=new ArrayList<Property>();
        if(object.getClass().isArray()){
            System.out.println("进入数组转换");
            Object[] obj = (Object[])object;
            //children构造
            for (int i=0;i<obj.length;i++){
                Property p=new Property();
                p.setPropValue(obj[i]);
                list.add(p);
            }

        }
        else if(object.getClass().toString().contains("HashMap")){
            System.out.println("进入map转换");
            HashMap<String, Object> map =(HashMap<String, Object>)object;
            for(String key:map.keySet()){
                Property pro=new Property();
                pro.setPropName(key);
                pro.setPropValue(map.get(key));
                list.add(pro);
            }
        }
        else if(object.getClass().toString().contains("ArrayList")){
            System.out.println("进入list转换");
            List<Property> propertyList=(List<Property>)object;
            for (Object o:propertyList){
                Property pa=new Property();
                pa.setPropValue(o);
                list.add(pa);
            }
        }
        else{
            System.out.println("进入其他类型转换");
            list=null;
        }
        return list;


    }
}
