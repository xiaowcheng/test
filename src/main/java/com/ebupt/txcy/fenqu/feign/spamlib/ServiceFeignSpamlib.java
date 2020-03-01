package com.ebupt.txcy.fenqu.feign.spamlib;

import com.ebupt.txcy.fenqu.config.FeignConfiguration;
import com.ebupt.txcy.fenqu.vo.spamlib.PhoneList;
import com.ebupt.txcy.fenqu.vo.yellow.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( value = "${service-spamlib}",configuration = FeignConfiguration.class,fallback = ServiceFeignSpamlib.SpamlibClientFallback.class)
public interface ServiceFeignSpamlib {
    
    @PostMapping(value ="/txcy/spamlib/v1/addNumber")
    Response addSpamlibList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/spamlib/v1/delNumber")
    Response delSpamlibList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/spamlib/v1/updateNumber")
    Response updateSpamlibList(@RequestBody PhoneList phoneList);
    
    @Slf4j
    @Component
    public class SpamlibClientFallback implements ServiceFeignSpamlib {
    
    
        @Override
        public Response addSpamlibList(PhoneList phoneList) {
            log.error("spamlib add err");
            return null;
        }
    
        @Override
        public Response delSpamlibList(PhoneList phoneList) {
            log.error("spamlib del err");
            return null;
        }
    
        @Override
        public Response updateSpamlibList(PhoneList phoneList) {
            log.error("spamlib update err");
            return null;
        }
    }
    
}
