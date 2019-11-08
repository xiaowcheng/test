package com.ebupt.txcy.fenqu.customer;

import com.ebupt.txcy.fenqu.feign.ChannelServiceFeignClientInterface;
import com.ebupt.txcy.fenqu.vo.channel.TypeConstants;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FenquCustomerApplicationTests {
    
    @Autowired
    private TypeConstants typeConstants;
    
    @Resource
    ChannelServiceFeignClientInterface channelServiceFeignClientInterface;

    @Test
    void contextLoads() {
//        System.out.println(typeConstants);
        channelServiceFeignClientInterface.test("zhanghao");
    }

}
