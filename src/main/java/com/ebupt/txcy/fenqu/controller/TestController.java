package com.ebupt.txcy.fenqu.controller;

import com.ebupt.txcy.fenqu.feign.ChannelServiceFeignClientInterface;
import com.ebupt.txcy.fenqu.service.WhitePhoneWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ebupt.txcy.fenqu.vo.RequestBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ebupt.txcy.fenqu.vo.PhoneList;

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
}
