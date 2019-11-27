package com.ebupt.txcy.fenqu.util;

import com.ebupt.txcy.fenqu.feign.ndeliver.ServiceFeignDeliver;
import com.ebupt.txcy.fenqu.feign.spamlib.ServiceFeignSpamlib;
import com.ebupt.txcy.fenqu.feign.yellow.ServiceFeignYellow;
import com.ebupt.txcy.fenqu.feign.yellowbak.ServiceFeignYellowbak;
import com.ebupt.txcy.fenqu.service.WhitePhoneWeekService;
import com.ebupt.txcy.fenqu.vo.channel.ThirdInfo;
import com.ebupt.txcy.fenqu.vo.YellowInfo;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.ebupt.txcy.fenqu.vo.ndeliver.NdeliverObj;
import com.ebupt.txcy.fenqu.vo.spamlib.Spamlib;
import com.ebupt.txcy.fenqu.vo.yellow.PhoneList;
import com.ebupt.txcy.fenqu.vo.yellow.YellowpagelibObj;
import com.ebupt.txcy.fenqu.vo.yellowbak.Yellowpagelibbak;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

public class DBTask implements Runnable
{
  private final Logger logger = LoggerFactory.getLogger(DBTask.class);
  
  private Set<String> whitePhone;
  private ArrayList<List<ThirdInfo>> arrayList;
  private ConcurrentHashMap<Integer, ArrayList<YellowInfo>> yellowMap;
  
  @Resource
  ServiceFeignYellow serviceFeignYellow;
  
  @Resource
  ServiceFeignYellowbak serviceFeignYellowbak;
  
  @Resource
  ServiceFeignDeliver serviceFeignDeliver;
  
  @Resource
  ServiceFeignSpamlib serviceFeignSpamlib;
  
  @Autowired
  WhitePhoneWeekService whitePhoneWeekService;
  
  @Autowired
  private TypeUtil typeUtil;
  
  @Value("${quhao-list}")
  private List<String> list;
  
  public DBTask(Set<String> whitePhone, ArrayList<List<ThirdInfo>> arrayList, ConcurrentHashMap<Integer, ArrayList<YellowInfo>> yellowMap)
  {
    this.whitePhone = whitePhone;
    this.arrayList = arrayList;
    this.yellowMap = yellowMap;
  }
  
  public void run()
  {
    try
    {
      inquiryDBInsert();
    }
    catch (Exception e)
    {
      this.logger.error("[Exception]", e);
    }
    catch (Throwable t)
    {
      this.logger.error("[Exception]", t);
    }
    this.logger.info("DBTask over---");
  }
  
  public void inquiryDBInsert()
  {
    writeDeliverInfo(this.arrayList, this.whitePhone);
    writeYellowInfo(this.yellowMap);
  }
  
  public String getNewPhone(String phone)
  {
    if (phone.trim().startsWith("+")) {
      phone = "00" + phone;
    }
    if (phone.trim().startsWith("0086")) {
      phone = phone.trim().substring(4);
    } else if (phone.trim().startsWith("86")) {
      phone = phone.trim().substring(2);
    }
    
    if (phone.length() == 10) {
      if (list.contains(phone.substring(2))) {
        phone = "0" + phone;
      }
    }
    if ((phone.length() == 11) && 
      (!phone.startsWith("1")) && 
      (list.contains(phone.substring(3)))) {
      phone = "0" + phone;
    }
    return phone;
  }
  
  public void writeYellowInfo(ConcurrentHashMap<Integer, ArrayList<YellowInfo>> yellowMap)
  {
    if (yellowMap.size() == 0) {
      return;
    }
    Date date = new Date(); //获取当前的系统时间。
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ; //使用了默认的格式创建了一个日期格式化对象。
    String time = dateFormat.format(date); //可以把日期转换转指定格式的字符串
  
    ArrayList<YellowInfo> authArray = (ArrayList)yellowMap.get(Integer.valueOf(0));
    ArrayList<YellowInfo> noauthArray = (ArrayList)yellowMap.get(Integer.valueOf(1));
    
    this.logger.debug("yellowMap authArray size is " + authArray.size());
    this.logger.debug("yellowMap noauthArray size is " + noauthArray.size());

    try
    {
  
      List<YellowpagelibObj> delList = new ArrayList<>();
      List<YellowpagelibObj> addList = new ArrayList<>();
      PhoneList addPhone = new PhoneList();
      PhoneList delPhone = new PhoneList();
      YellowpagelibObj yellowpagelibObj = null;
      for (YellowInfo info : authArray) {
        //插入yellowpagelib
        //emp.classBType is null
        if (info.getClassBType() == null) {
          //删除黄页数据
          yellowpagelibObj = new YellowpagelibObj(getNewPhone(info.getPhone()),"",info.getProfession(),info.getClassBType(),info.getSourceID()+"");
          delList.add(yellowpagelibObj);
        }else{
          yellowpagelibObj = new YellowpagelibObj(getNewPhone(info.getPhone()),"",info.getProfession(),info.getClassBType(),info.getSourceID()+"");
          addList.add(yellowpagelibObj);
        }
      }
      addPhone.setPhoneList(addList);
      delPhone.setPhoneList(delList);
      
      serviceFeignYellow.addYellowList(addPhone);
      serviceFeignYellow.delYellowList(delPhone);
    }
    catch (Exception e)
    {
      this.logger.error("[Exception]", e);
    }
    
    try
    {
      List<Yellowpagelibbak> delList = new ArrayList<>();
      List<Yellowpagelibbak> addList = new ArrayList<>();
      com.ebupt.txcy.fenqu.vo.yellowbak.PhoneList addPhone = new com.ebupt.txcy.fenqu.vo.yellowbak.PhoneList();
      com.ebupt.txcy.fenqu.vo.yellowbak.PhoneList delPhone = new com.ebupt.txcy.fenqu.vo.yellowbak.PhoneList();
      Yellowpagelibbak yellowpagelibbak = null;
      for (YellowInfo info : noauthArray)
      {
        //批量插入 yellowbakpagelib
        if (info.getClassBType() == null) {
          //删除黄页数据
          yellowpagelibbak = new Yellowpagelibbak(getNewPhone(info.getPhone()),"",info.getProfession(),info.getClassBType(),info.getSourceID()+"");
          delList.add(yellowpagelibbak);
        }else{
          yellowpagelibbak = new Yellowpagelibbak(getNewPhone(info.getPhone()),"",info.getProfession(),info.getClassBType(),info.getSourceID()+"");
          addList.add(yellowpagelibbak);
        }
      }
      addPhone.setPhoneList(addList);
      delPhone.setPhoneList(delList);
      
      serviceFeignYellowbak.addYellowbakList(addPhone);
      serviceFeignYellowbak.delYellowbakList(delPhone);
    }
    catch (Exception e)
    {
      this.logger.error("[Exception]", e);
    }
  }
  
  public void writeDeliverInfo(ArrayList<List<ThirdInfo>> arrayList, Set<String> whitePhone) {
    if (arrayList == null) {
      return;
    }
  
    this.logger.debug("arrayList size is " + arrayList.size());
  
    try {
      
      List<NdeliverObj> deliverList = new ArrayList<>();
      List<Spamlib> spamlibList = new ArrayList<>();
      for (List<ThirdInfo> array : arrayList) {
        int i = 0;
        for (ThirdInfo info : array) {
          String type = typeUtil.dealNewType(info.getType());
          if (i == 0) {
            //插入ndeliver
            deliverList.add(new NdeliverObj(getNewPhone(info.getPhone()),"","",info.getCount()+"",type,info.getSourceID()+""));
          }
          //插入spmlib表
          spamlibList.add(new Spamlib(getNewPhone(info.getPhone()),(int)info.getSourceID(),type,info.getCount(),info.getId()));
          i++;
        }
      }
      com.ebupt.txcy.fenqu.vo.ndeliver.PhoneList deliver = new com.ebupt.txcy.fenqu.vo.ndeliver.PhoneList(deliverList);
      com.ebupt.txcy.fenqu.vo.spamlib.PhoneList spamlib = new com.ebupt.txcy.fenqu.vo.spamlib.PhoneList(spamlibList);
  
      serviceFeignDeliver.addDeliverList(deliver);
      serviceFeignSpamlib.addSpamlibList(spamlib);

    }
    catch (Exception e)
    {
      this.logger.error("[Exception]", e);
    }
    
   
    if (whitePhone == null || whitePhone.size() <= 0) {
      logger.info("third rerun white_week data is null");
      return;
    }

    try
    {
      whitePhoneWeekService.saveRedisAll(whitePhone);
    }
    catch (Exception e)
    {
      this.logger.error("[Exception]", e);
    }
  }
}
