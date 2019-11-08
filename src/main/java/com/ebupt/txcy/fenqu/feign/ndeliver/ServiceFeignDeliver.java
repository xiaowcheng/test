package com.ebupt.txcy.fenqu.feign.ndeliver;

import com.ebupt.txcy.fenqu.config.FeignConfiguration;
import com.ebupt.txcy.fenqu.feign.yellow.ServiceFeignYellow;
import com.ebupt.txcy.fenqu.vo.ndeliver.PhoneList;
import com.ebupt.txcy.fenqu.vo.yellow.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( value = "${service-deliver}",configuration = FeignConfiguration.class,fallback = ServiceFeignDeliver.DeliverClientFallback.class)
public interface ServiceFeignDeliver {
    
    public static final Logger logger = LoggerFactory.getLogger(ServiceFeignDeliver.class);
    
    @PostMapping(value ="/txcy/ndeliver/v1/addNumber")
    Response addDeliverList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/ndeliver/v1/updateNumber")
    Response delDeliverList(@RequestBody PhoneList phoneList);
    
    @PostMapping(value ="/txcy/ndeliver/v1/delNumber")
    Response updateDeliverList(@RequestBody PhoneList phoneList);
    
    @Component
    public class DeliverClientFallback implements ServiceFeignDeliver{
    
        @Override
        public Response addDeliverList(PhoneList phoneList) {
            logger.error("deliver add err");
            return null;
        }
    
        @Override
        public Response delDeliverList(PhoneList phoneList) {
            logger.error("deliver del err");
            return null;
        }
    
        @Override
        public Response updateDeliverList(PhoneList phoneList) {
            logger.error("deliver update err");
            return null;
        }
    }
}
