package com.ebupt.txcy.fenqu.customer;

import com.ebupt.txcy.fenqu.feign.channel.*;
import com.ebupt.txcy.fenqu.util.CompareUtil;
import com.ebupt.txcy.fenqu.util.DBTask;
import com.ebupt.txcy.fenqu.vo.channel.PhoneList;
import com.ebupt.txcy.fenqu.vo.channel.QueryChannel;
import com.ebupt.txcy.fenqu.vo.channel.QueryResp;
import com.ebupt.txcy.fenqu.vo.channel.ThirdInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class AsyncServiceImpl implements AsyncService {
    
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    
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
    
    @Override
//    @Async("asyncServiceExecutor")
    public void executeAsync(List<String> phoneList) {
//        logger.info("start executeAsync");
        List<String> newList = new ArrayList(phoneList.size());
        try {
            //1、号码处理
            for (int i = 0; i < phoneList.size(); i++) {
                logger.info("i:" + i + ";phone:" + phoneList.get(i));
                if (phoneList.size() > 0) {
                    String phone = (String) phoneList.get(0);
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
//                Thread.sleep(200000);
            }
            if (newList.size() <=0) {
                logger.info("没有数据");
                return;
            }
        
//            ConcurrentHashMap<String, QueryResp> maps = new ConcurrentHashMap();
//            ArrayList<List<ThirdInfo>> arrayList = new ArrayList();
//            Set<String> whitePhone = null;
//            QueryChannel queryChannel = null;
//            //2、获取 全部渠道配置
//            if (allChannle.indexOf("360") != -1) {
//                //发起360查询
//                queryChannel = serviceFeign360.consumer(new PhoneList(newList));
//                if (queryChannel == null || queryChannel.getCode() != 200) {
//                    logger.error("360查询失败");
//                } else {
//                    maps.put("360", queryChannel.getData());
//                }
//            }
//            if (allChannle.indexOf("tx") != -1) {
//                //发起tx查询
//                queryChannel = serviceFeignTx.consumer(new PhoneList(newList));
//                if (queryChannel == null || queryChannel.getCode() != 200) {
//                    logger.error("tx查询失败");
//                } else {
//                    maps.put("tx", queryChannel.getData());
//                }
//            }
//            if (allChannle.indexOf("sougou") != -1) {
//                //发起sougou查询
//                queryChannel = serviceFeignSougou.consumer(new PhoneList(newList));
//                if (queryChannel == null || queryChannel.getCode() != 200) {
//                    logger.error("sougou查询失败");
//                } else {
//                    maps.put("sougou", queryChannel.getData());
//                }
//            }
//            if (allChannle.indexOf("dianhuabang") != -1) {
//                //发起dianhuabang查询
//                queryChannel = serviceFeignDianhuabang.consumer(new PhoneList(newList));
//                if (queryChannel == null || queryChannel.getCode() != 200) {
//                    logger.error("dianhuabang查询失败");
//                } else {
//                    maps.put("dianhuabang", queryChannel.getData());
//                }
//            }
//            if (allChannle.indexOf("baidu") != -1) {
//                //发起baidu查询
//                queryChannel = serviceFeignBaidu.consumer(new PhoneList(newList));
//                if (queryChannel == null || queryChannel.getCode() != 200) {
//                    logger.error("baidu查询失败");
//                } else {
//                    maps.put("baidu", queryChannel.getData());
//
//                }
//            }
//            if (allChannle.indexOf("ali") != -1) {
//                //发起ali查询
//                queryChannel = serviceFeignAli.consumer(new PhoneList(newList));
//                if (queryChannel == null || queryChannel.getCode() != 200) {
//                    logger.error("ali查询失败");
//                } else {
//                    maps.put("ali", queryChannel.getData());
//                }
//            }
//
//            //3、获取优先处理渠道
//            //返回数据处理
//            //4、调用入库逻辑（1、入库认证黄页、非认证、标记、其他）
//            CompareUtil compareUtil = new CompareUtil();
//            compareUtil.dealInfo(maps);
//
//            arrayList = compareUtil.getThirdArrayList();
//            whitePhone = compareUtil.getWhitephoneList();
//            Object yellowMap = compareUtil.getYellowMap();
//
//            DBTask task = new DBTask(whitePhone, arrayList, (ConcurrentHashMap) yellowMap);

//            this.logger.info("newCachedThreadPool---");
//            ExecutorService executor = Executors.newCachedThreadPool();
//            executor.submit(task);
//            executor.shutdown();
            Thread.sleep(20000);
//            this.logger.info("executorservice shutdown---");

        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }
}