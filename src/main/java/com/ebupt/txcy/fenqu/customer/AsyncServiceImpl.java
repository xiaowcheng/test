package com.ebupt.txcy.fenqu.customer;

import com.ebupt.txcy.fenqu.feign.channel.*;
import com.ebupt.txcy.fenqu.util.CompareUtil;
import com.ebupt.txcy.fenqu.util.DBTask;
import com.ebupt.txcy.fenqu.util.RedisUtil;
import com.ebupt.txcy.fenqu.vo.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {
    
    @Resource
    private RedisUtil redisUtil;
    
    @Resource
    private  DBTask dbTask;
    
    @Resource
    ServiceFeign360 serviceFeign360;
    
    @Resource
    ServiceFeignAli serviceFeignAli;
    
    @Resource
    ServiceFeignBaidu serviceFeignBaidu;
    
    @Resource
    ServiceFeignDianhuabang serviceFeignDianhuabang;
    
    @Resource
    ServiceFeignSougou serviceFeignSougou;
    
    @Resource
    ServiceFeignTx serviceFeignTx;
    
    
    @Value("${channel.allChannel}")
    private String allChannle;
    
    @Value("${spring.redis.white_week_searchtime}")
    private int white_week_searchtime;
    
    @Override
    public void executeAsync(List<String> phoneList) {
        log.debug("[SVC]start executeAsync");
        phoneList = new ArrayList<>(new HashSet<>(phoneList)) ;
        List<String> newList = new ArrayList(phoneList.size());
        try {
            //1、号码处理
            for (int i = 0; i < phoneList.size(); i++) {
             log.debug("i:" + i + ";phone:" + phoneList.get(i));
                if (phoneList.size() > 0) {
                    String phone = (String) phoneList.get(i);
                    String newphone = null;
                    if (phone.trim().startsWith("+86")) {
                        newphone = phone.trim().substring(3);
                    } else if (phone.trim().startsWith("0086")) {
                        newphone = phone.trim().substring(4);
                    } else if (phone.trim().startsWith("86")) {
                        newphone = phone.trim().substring(2);
                    } else {
                        newphone = phone;
                    }
                    newList.add(newphone);
                }

            }
//            Thread.sleep(200000);
//            return;
            //2、获取 全部渠道配置
            if (newList.size() <=0) {
                log.warn("数据格式不正确，没有数据");
                return;
            }

            //去除txcy_whitelist_week 数据
            newList = delWhiteWeek(newList);
            if (newList.size() <=0) {
                log.warn("号码数据均存在redis中，即均已处理过");
                return;
            }

            ConcurrentHashMap<String, QueryChannel> maps = new ConcurrentHashMap();
            ArrayList<List<ThirdInfo>> arrayList = new ArrayList<>();
            Set<String> whitePhone = null;
            QueryChannel queryChannel = null;

            if (allChannle.indexOf("360") != -1) {
                //发起360查询
                queryChannel = serviceFeign360.consumer(new PhoneList(newList));
                log.debug("#####"+queryChannel.getCode());
                if (queryChannel == null || !"0000".equals(queryChannel.getCode())) {
                    log.warn("360查询失败");
                } else {
                    maps.put("360", queryChannel);
                }
            }
            if (allChannle.indexOf("tx") != -1) {
                //发起tx查询
                queryChannel = serviceFeignTx.consumer(new PhoneList(newList));
                if (queryChannel == null || !"0000".equals(queryChannel.getCode())) {
                    log.warn("tx查询失败");
                } else {
                    maps.put("tx", queryChannel);
                }
            }
            if (allChannle.indexOf("sougou") != -1) {
                //发起sougou查询
                queryChannel = serviceFeignSougou.consumer(new PhoneList(newList));
                if (queryChannel == null || !"0000".equals(queryChannel.getCode())) {
                    log.warn("sougou查询失败");
                } else {
                    maps.put("sougou", queryChannel);
                }
            }
            if (allChannle.indexOf("dianhuabang") != -1) {
                //发起dianhuabang查询
                queryChannel = serviceFeignDianhuabang.consumer(new PhoneList(newList));
                if (queryChannel == null || !"0000".equals(queryChannel.getCode())) {
                    log.warn("dianhuabang查询失败");
                } else {
                    maps.put("dianhuabang", queryChannel);
                }
            }
            if (allChannle.indexOf("baidu") != -1) {
                //发起baidu查询
                queryChannel = serviceFeignBaidu.consumer(new PhoneList(newList));
                if (queryChannel == null || !"0000".equals(queryChannel.getCode())) {
                    log.warn("baidu查询失败");
                } else {
                    maps.put("baidu", queryChannel);

                }
            }
            if (allChannle.indexOf("ali") != -1) {
                //发起ali查询
                queryChannel = serviceFeignAli.consumer(new PhoneList(newList));
                if (queryChannel == null || !"0000".equals(queryChannel.getCode())) {
                    log.warn("ali查询失败");
                } else {
                    maps.put("ali", queryChannel);
                }
            }
            if(maps.isEmpty()){
               log.error("所有渠道查询均失败，核实渠道信息");
               return;
            }

            
            
            //3、获取优先处理渠道
            //返回数据处理
            //4、调用入库逻辑（1、入库认证黄页、非认证、标记、其他）
            CompareUtil compareUtil = new CompareUtil();
            compareUtil.dealInfo(maps);

            arrayList = compareUtil.getThirdArrayList();
            whitePhone = compareUtil.getWhitephoneList();
            Object yellowMap = compareUtil.getYellowMap();
            
            if (whitePhone != null && whitePhone.size() >0){
                dbTask.writeWhite(whitePhone);
    
                //去除txcy_whitelist_week 数据
                //arrayList = new ArrayList<>(delWhiteWeek( arrayList));
            }
            
            if (arrayList == null || arrayList.size() <=0) {
                log.info("所有号码在渠道侧均为白名单");
                return;
            }
            
            dbTask.run( arrayList, (ConcurrentHashMap) yellowMap);

        }catch(Exception e){
            e.printStackTrace();
        }
        log.debug("[SVC]end executeAsync");
    }
    
    public List delWhiteWeek(List list){
        try{
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            redisUtil.sSetAndTime(uuid,300,list.toArray());
            
            //获取需要判断多少内数据有效
            List days = new ArrayList();
            for (int i = 0; i < white_week_searchtime ; i++) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_YEAR,-i);
                String nowDay = "white_week_"+new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
                days.add(nowDay);
            }
            
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
//        System.out.println(sdf.format(new Date()));
            Set set = redisUtil.sdiff(uuid,days);
//        System.out.println(sdf.format(new Date()));
            return new ArrayList(set);
        }catch (Exception e){
            log.error("redis del whiteweek err"+e.getMessage());
            return list;
        }
    }
}