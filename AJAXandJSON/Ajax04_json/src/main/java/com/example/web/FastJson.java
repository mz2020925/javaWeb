package com.example.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJson {


    public static void main(String[] args) {
        // 1.java对象转换成json字符串，，，注意是互相转换的是json字符串而不是json对象
        User user = new User("zmz", "123456");
        String jsonOfUser = JSON.toJSONString(user);  // {"password":"123456","username":"zmz"}
        System.out.println(jsonOfUser);

        // 2.json字符串转换为java对象
        User userOfJson = JSON.parseObject("{\"password\":\"123456\",\"username\":\"zmz\"}", User.class);
        System.out.println(userOfJson);

    }
}
