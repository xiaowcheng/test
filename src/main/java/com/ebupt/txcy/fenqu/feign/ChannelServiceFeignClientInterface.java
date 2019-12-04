package com.ebupt.txcy.fenqu.feign;

import com.ebupt.txcy.fenqu.config.FeignConfiguration;
import com.ebupt.txcy.fenqu.vo.PhoneList;
//import com.ebupt.txcy.fenqu.vo.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient( value = "${service-syswhitelist}",configuration = FeignConfiguration.class,fallback = ChannelServiceFeignClientInterface.UserMessageClientFallback.class)
public interface ChannelServiceFeignClientInterface {
//
//    @PostMapping(value ="${fenqu.service-syswhitelist-url}")
////    @Headers("Content-type: application/json")
//    WhiteResp consumer(RequestBody requestBody);
    
    @PostMapping("/test")
    String test(@RequestParam("str") String str);
    
    @PostMapping(value ="/txcy/sysWhiteList/v1/addNumber")
    String consumer(@RequestBody PhoneList phoneList);
    
    @Component
    static class UserMessageClientFallback implements ChannelServiceFeignClientInterface{
        
//        @Override
//        public WhiteResp consumer( RequestBody requestBody) {
//            return new WhiteResp();
//        }
        @Override
        public String test(String str) {
            return "1";
        }
    
        @Override
        public String consumer(PhoneList phoneList){
            return null;
        }
    }
}