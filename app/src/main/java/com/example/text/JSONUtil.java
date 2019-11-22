package com.example.text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.Serializable;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2011:34
 * desc   :
 * package: Text:
 */
public class JSONUtil<T,PK extends Serializable> {
    /**
     * json字符串转换为对象
     * **/
    public PK JsonStrToObject(T jsonStr, Class<PK> clazz) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        try {
            if (jsonStr != null) {
                PK pk = gson.fromJson(jsonStr.toString(), clazz);
                return pk;
            }
        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
