package com.ebupt.txcy.fenqu.controller;

import com.ebupt.txcy.fenqu.feign.ChannelServiceFeignClientInterface;
import com.ebupt.txcy.fenqu.service.WhitePhoneWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/consumer")
public class TestController {
    
    @Resource
    ChannelServiceFeignClientInterface channelServiceFeignClientInterface;
    
    @Autowired
    WhitePhoneWeekService whitePhoneWeekService;
    
    
    
//    @GetMapping("/date")
//    public String getDate( @RequestParam String param ) {
//        return channelServiceFeignClientInterface.consumer(new RequestBody("","0","10")).toString();
//    }
    @GetMapping("/test")
    public String getTest( @RequestParam String param ) {
    
//        PhoneList phoneList = new PhoneList(list);
//        return channelServiceFeignClientInterface.consumer(phoneList);
        
        Set<String> list = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i+"");
        }
        
       
        whitePhoneWeekService.saveAll(list);
        
   
        
        return "2";
    }
}
