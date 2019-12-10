package com.ebupt.txcy.fenqu.feign.yellowbak;

import com.ebupt.txcy.fenqu.config.FeignConfiguration;
import com.ebupt.txcy.fenqu.vo.yellow.Response;
import com.ebupt.txcy.fenqu.vo.yellowbak.PhoneList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( value = "${service-yellowbak}",configuration = FeignConfiguration.class,fallback = ServiceFeignYellowbak.YellowClientFallback.class)
public interface ServiceFeignYellowbak {
    
    public static final Logger logger = LoggerFactory.getLogger(ServiceFeignYellowbak.class);
    
    @PostMapping(value ="/txcy/yellowpagelibbak/v1/addNumber")
    Response addYellowbakList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/yellowpagelibbak/v1/delNumber")
    Response delYellowbakList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/yellowpagelibbak/v1/updateNumber")
    Response updateYellowbakList(@RequestBody PhoneList phoneList);
    
    @Component
    public class YellowClientFallback implements ServiceFeignYellowbak {
    
    
        @Override
        public Response addYellowbakList(PhoneList phoneList) {
            logger.error("yellowbak add err");
            return null;
        }
    
        @Override
        public Response delYellowbakList(PhoneList phoneList) {
            logger.error("yellowbak del err");
            return null;
        }
    
        @Override
        public Response updateYellowbakList(PhoneList phoneList) {
            logger.error("yellowbak update err");
            return null;
        }
    }
    
}
