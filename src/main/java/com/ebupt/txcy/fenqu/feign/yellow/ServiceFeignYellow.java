package com.ebupt.txcy.fenqu.feign.yellow;

import com.ebupt.txcy.fenqu.config.FeignConfiguration;
import com.ebupt.txcy.fenqu.vo.yellow.PhoneList;
import com.ebupt.txcy.fenqu.vo.yellow.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( value = "${service-yellow}",configuration = FeignConfiguration.class,fallback = ServiceFeignYellow.YellowClientFallback.class)
public interface ServiceFeignYellow {
    
    public static final Logger logger = LoggerFactory.getLogger(ServiceFeignYellow.class);
    
    @PostMapping(value ="/txcy/yellowpagelib/v1/addNumber")
    Response addYellowList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/yellowpagelib/v1/delNumber")
    Response delYellowList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/yellowpagelib/v1/updateNumber")
    Response updateYellowList(@RequestBody PhoneList phoneList);
    
    @Component
    public class YellowClientFallback implements ServiceFeignYellow{
    
    
        @Override
        public Response addYellowList(PhoneList phoneList) {
            logger.error("yellow add err");
            return null;
        }
    
        @Override
        public Response delYellowList(PhoneList phoneList) {
            logger.error("yellow del err");
            return null;
        }
    
        @Override
        public Response updateYellowList(PhoneList phoneList) {
            logger.error("yellow update err");
            return null;
        }
    }
    
}
