package com.ebupt.txcy.fenqu.customer;

import com.ebupt.txcy.fenqu.feign.ChannelServiceFeignClientInterface;
import com.ebupt.txcy.fenqu.util.RedisUtil;
import com.ebupt.txcy.fenqu.vo.channel.TypeConstants;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FenquCustomerApplicationTests {
    
    @Autowired
    private TypeConstants typeConstants;
    
    @Resource
    private RedisUtil redisUtil;
    
    @Resource
    ChannelServiceFeignClientInterface channelServiceFeignClientInterface;
    
    @Value("${quhao-list}")
    private List<String> list;

    @Test
    void contextLoads() {
//        System.out.println(typeConstants);
    
//        List<String> list = new ArrayList<>(1000*1000);
//        for (int j = 0*1000*1000; j < 1000*1000; j++) {
//            list.add(j+"");
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
//        System.out.println(sdf.format(new Date()));
//        Long a = redisUtil.addHyperLogLog("HyperLogLog",list.toArray());
//        System.out.println(a);
//        System.out.println(sdf.format(new Date()));
//

            
//            for (int k = 0; k < 30; k++) {
//                String key = "test"+k;
//                List<String> list = new ArrayList<>(1000*1000);
//                for (long j = k*1000*1000+(13870000000l); j < 1000*1000*(k+1)+(13870000000l); j++) {
//                    list.add(j+"");
//                }
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
//                System.out.println(sdf.format(new Date()));
//                redisUtil.sSetAndTime(key,-1,list.toArray());
//                System.out.println(sdf.format(new Date()));
//            }
    
//        List<String> list = new ArrayList<>();
//        list.add("chengyiwu");
//        list.add("1121312");
////        Set<Object> set =  redisUtil.sdiff("key1","chengyiwu");
////        set.forEach(System.out::println);
//        redisUtil.sSetAndTime("key3",-1,list.toArray());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
//        System.out.println(sdf.format(new Date()));
//        for (int i = 0; i < 30; i++) {
//            if( redisUtil.isMember("test"+i,"56511551") ){
//                break;
//            }
//        }
//        System.out.println(sdf.format(new Date()));
//        System.out.println("----------"+redisUtil.isMember("test0","1000"));
//        System.out.println(sdf.format(new Date()));
    
//        System.out.println(sdf.format(new Date()));
//        for (int i = 0; i < 10; i++) {
//            System.out.println("----------"+redisUtil.addHyperLogLog("runoobkey","redis"));
//        }
//        System.out.println(sdf.format(new Date()));
    
//        List<String> list = new ArrayList<>();
//        for (int i = 299995000; i < 300005000; i++) {
//            list.add(i+"");
//        }
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        redisUtil.sSetAndTime(uuid,1000,list.toArray());
//
//        List<String> list1 = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            list1.add("test"+i);
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
//        System.out.println(sdf.format(new Date()));
//        Set set = redisUtil.sdiff(uuid,list1);
//        System.out.println(sdf.format(new Date()));
//        set.forEach(System.out::println);
    
//        list.forEach(System.out::println);
        System.out.println(list.size());
    }

}
