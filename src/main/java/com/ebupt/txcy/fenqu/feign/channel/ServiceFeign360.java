package com.ebupt.txcy.fenqu.feign.channel;

import com.ebupt.txcy.fenqu.config.FeignConfiguration;
import com.ebupt.txcy.fenqu.vo.channel.PhoneList;
import com.ebupt.txcy.fenqu.vo.channel.QueryChannel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( value = "${service-360}",fallback = QueryChannelClientFallback.class)
public interface ServiceFeign360 {
    
    @PostMapping(value ="/txcy/thirdinquiry360/v1/search360")
    QueryChannel consumer(@RequestBody PhoneList phoneList);
    
}
