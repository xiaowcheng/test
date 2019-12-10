package com.ebupt.txcy.fenqu.feign.channel;

import com.ebupt.txcy.fenqu.vo.channel.PhoneList;
import com.ebupt.txcy.fenqu.vo.channel.QueryChannel;
import org.springframework.stereotype.Component;

@Component
public class QueryChannelClientFallback implements ServiceFeignAli,ServiceFeign360,ServiceFeignSougou,ServiceFeignBaidu,ServiceFeignDianhuabang,ServiceFeignTx{
    
    @Override
    public QueryChannel consumer(PhoneList phoneList) {
        
        return new QueryChannel("1000","查询失败",null,0);
    }
    
}