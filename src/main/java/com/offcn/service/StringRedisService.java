package com.offcn.service;

import com.alibaba.fastjson.JSON;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

@RestController
public class StringRedisService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void store() {
        User user = new User(001, "土包子", 18);
        String json = JSON.toJSONString(user);
        stringRedisTemplate.opsForValue().set("name", json);
    }

    public User get() {

        String str = stringRedisTemplate.opsForValue().get("name");
        User user = JSON.parseObject(str, User.class);
        return  user;
    }


}
