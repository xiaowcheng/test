package com.ebupt.txcy.fenqu.service;

import com.ebupt.txcy.fenqu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WhitePhoneWeekService {
    
    @Value("${spring.redis.white_week_expiretime}")
    private int white_week_expiretime;
    
    @Resource
    private RedisUtil redisUtil;
    
    
    public void saveRedisAll(Set<String> set){
        String key = "white_week_"+new SimpleDateFormat("yyyyMMdd").format(new Date());
        redisUtil.sSetAndTime(key,white_week_expiretime,set.toArray());
    }
}
