package com.ebupt.txcy.fenqu.controller;

import com.ebupt.txcy.fenqu.feign.ChannelServiceFeignClientInterface;
import com.ebupt.txcy.fenqu.service.WhitePhoneWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ebupt.txcy.fenqu.vo.RequestBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ebupt.txcy.fenqu.vo.channel.PhoneList;

@RestController
@RequestMapping("/consumer")
public class TestController {
    
    @Resource
    ChannelServiceFeignClientInterface channelServiceFeignClientInterface;
    
    @Autowired
    WhitePhoneWeekService whitePhoneWeekService;
    
    
    
    @GetMapping("/date")
    public String getDate( @RequestParam String param ) {
        List<String> list = new ArrayList<>();
        list.add(param);
        return channelServiceFeignClientInterface.consumer(new PhoneList(list)).toString();
    }
    @GetMapping("/test")
    public String getTest( @RequestParam String param ) {
    
//        PhoneList phoneList = new PhoneList(list);
//        return channelServiceFeignClientInterface.consumer(phoneList);
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i+"");
        }
    
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
        System.out.println(sdf.format(new Date()));
        List<String> a = whitePhoneWeekService.selectAll(list);
        
    
    
        System.out.println(a);
        System.out.println(sdf.format(new Date()));
        return "2";
    }
}
