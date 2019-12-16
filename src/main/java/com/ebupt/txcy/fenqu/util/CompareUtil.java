package com.ebupt.txcy.fenqu.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.ebupt.txcy.fenqu.vo.channel.QueryChannel;
import com.ebupt.txcy.fenqu.vo.channel.QueryResp;
import com.ebupt.txcy.fenqu.vo.channel.QueryRespItem;
import com.ebupt.txcy.fenqu.vo.channel.ThirdInfo;
import com.ebupt.txcy.fenqu.vo.YellowInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class CompareUtil {
  
  public static final Logger logger = LoggerFactory.getLogger(CompareUtil.class);
  
  @Value("${channel.firstSourceid}")
  public int firstSourceid ;
  
  
  public ConcurrentHashMap<Integer, ArrayList<YellowInfo>> yellowMap = null;
  public ConcurrentHashMap<String, List<ThirdInfo>> thirdMap = null;
  public ArrayList<List<ThirdInfo>> thirdarrayList = null;
  public Set<String> whitephoneList = null;
  public ConcurrentHashMap<String, Integer> whitephoneMap = null;
  
  public ConcurrentHashMap<Integer, ArrayList<YellowInfo>> getYellowMap()
  {
    return this.yellowMap;
  }
  
  public ArrayList<List<ThirdInfo>> getThirdArrayList()
  {
    return this.thirdarrayList;
  }
  
  public Set<String> getWhitephoneList()
  {
    return this.whitephoneList;
  }
  
  public ConcurrentHashMap<Integer, ArrayList<YellowInfo>> getYellowInfo(QueryRespItem item, int name, ConcurrentHashMap<Integer, ArrayList<YellowInfo>> yellowMap) {
    
    String phone = item.getNumber();
    int mode = item.getMold().intValue();
    YellowInfo info = null;
    //黄页
    if (mode == 0)
    {
      if ((item.getTeldesc() == "未知") || (item.getName() == "未知"))
      {
        info = new YellowInfo(phone, (short)name, "", "");
      }
      else
      {
        info = new YellowInfo(phone, (short)name, item.getTeldesc(), item.getName());
      }
    }
    else
    {
      info = new YellowInfo(phone, (short)name, "", "");
    }
    
    ArrayList<YellowInfo> authArray = null;
    ArrayList<YellowInfo> noauthArray = null;
    
    Integer isAuth = null;
    
    if ((info.getClassBType() == null) || (info.getClassBType() == ""))
    {
      authArray = (ArrayList)yellowMap.get(Integer.valueOf(0));
      authArray.add(info);
      yellowMap.remove(Integer.valueOf(0));
      yellowMap.put(Integer.valueOf(0), authArray);
      noauthArray = (ArrayList)yellowMap.get(Integer.valueOf(1));
      noauthArray.add(info);
      yellowMap.remove(Integer.valueOf(1));
      yellowMap.put(Integer.valueOf(1), noauthArray);
    }
    else if (name == firstSourceid)
    {
        Integer auth = item.getIsAuth();
        authArray = (ArrayList)yellowMap.get(auth);
        ArrayList<YellowInfo> tmparray = new ArrayList();
        tmparray.add(info);
        for (YellowInfo tmp : authArray) {
          tmparray.add(tmp);
        }
        yellowMap.remove(auth);
        yellowMap.put(auth, tmparray);
    }
    else
    {
      Integer auth = item.getIsAuth();
      authArray = (ArrayList)yellowMap.get(auth);
      authArray.add(info);
      yellowMap.remove(auth);
      yellowMap.put(auth, authArray);
    }
    return yellowMap;
  }
  
  public ConcurrentHashMap<String, List<ThirdInfo>> getThirdInfo(QueryRespItem item, int name) {
    
    String phone = item.getNumber();
    
    int mode = item.getMold().intValue();
    int id = item.getId().intValue();
    
    ThirdInfo info = null;
    
    //标记
    if (mode == 1)
    {
      if (item.getType() == "未知")
      {
        info = new ThirdInfo(item.getNumber(), (short)name, "", 0, id);
      }
      else
      {
        info = new ThirdInfo(item.getNumber(), (short)name, item.getType(), item.getCount().intValue(), id);
      }
    }
    else
    {
      info = new ThirdInfo(item.getNumber(), (short)name, "", 0, id);
    }
    //不存在号码信息
    if (this.thirdMap.get(phone) == null)
    {
      List<ThirdInfo> list = new ArrayList();
      list.add(info);
      this.thirdMap.put(phone, list);
    }
    else
    {
      List<ThirdInfo> list = (List)this.thirdMap.get(phone);
      List<ThirdInfo> newlist = new ArrayList();
      if ((name == firstSourceid) && (info.getCount() > 0))
      {
        newlist.add(info);
        for (ThirdInfo tmpinfo : list) {
          newlist.add(tmpinfo);
        }
      }else {
        newlist = new ArrayList();
        if (info.getCount() > ((ThirdInfo)list.get(0)).getCount())
        {
          newlist.add(info);
          for (ThirdInfo tmpinfo : list) {
            newlist.add(tmpinfo);
          }
        }
        else
        {
          newlist = new ArrayList();
          for (ThirdInfo tmpinfo : list) {
            newlist.add(tmpinfo);
          }
          newlist.add(info);
        }
      }
      this.thirdMap.remove(phone);
      this.thirdMap.put(phone, newlist);
    }
    return this.thirdMap;
  }
  
  public ConcurrentHashMap<String, Integer> getWhitePhoneMap(QueryRespItem item) {
    String phone = item.getNumber();
    
    if (this.whitephoneMap.get(phone) == null)
    {
      this.whitephoneMap.put(phone, Integer.valueOf(1));
    }
    else
    {
      int time = ((Integer)this.whitephoneMap.get(phone)).intValue();
      this.whitephoneMap.remove(phone);
      this.whitephoneMap.put(phone, Integer.valueOf(time + 1));
    }
    return this.whitephoneMap;
  }
  
  public void isWhitephone(int size) {
    Iterator<String> phones = this.whitephoneMap.keySet().iterator();
    while (phones.hasNext())
    {
      String phone = (String)phones.next();
      int times = ((Integer)this.whitephoneMap.get(phone)).intValue();
      if (times == size) {
        this.whitephoneList.add(phone);
      }
    }
  }
  
  public void dealInfoandWhite(QueryRespItem item, int name)
  {
    try
    {
      int mode = item.getMold().intValue();
      switch (mode)
      {
      case 0: 
        this.yellowMap = getYellowInfo(item, name, this.yellowMap);
        this.thirdMap = getThirdInfo(item, name);
        break;
      case 1: 
        this.thirdMap = getThirdInfo(item, name);
        this.yellowMap = getYellowInfo(item, name, this.yellowMap);
        break;
      case 2: 
        this.yellowMap = getYellowInfo(item, name, this.yellowMap);
        this.thirdMap = getThirdInfo(item, name);
        this.whitephoneMap = getWhitePhoneMap(item);
      }
    }
    catch (Exception e)
    {
      this.logger.error("", e);
    }
  }
  
  public void dealInfo(ConcurrentHashMap<String, QueryChannel> maps)
  {
  
    Collection<QueryChannel> values = maps.values();
    Iterator<QueryChannel> iterator = values.iterator();
    
    this.yellowMap = new ConcurrentHashMap();
    ArrayList<YellowInfo> array1 = new ArrayList();
    ArrayList<YellowInfo> array2 = new ArrayList();
    this.yellowMap.put(Integer.valueOf(0), array1);
    this.yellowMap.put(Integer.valueOf(1), array2);
    this.thirdMap = new ConcurrentHashMap();
    this.whitephoneMap = new ConcurrentHashMap();
    this.thirdarrayList = new ArrayList();
    this.whitephoneList = new HashSet<>();
  
  
    List<QueryRespItem> msg = null;
    
    while (iterator.hasNext())
    {
      
      try{
        QueryChannel queryResp = iterator.next();
        this.logger.info("list length is {}", queryResp.getData().size());
        for (QueryRespItem queryRespItem: queryResp.getData())
        {
          dealInfoandWhite(queryRespItem,queryResp.getName());
        }
     }
      catch (Exception e)
      {
        this.logger.error("CompareUtil:", e);
      }
    }
    isWhitephone(maps.size());
    for (String phone : this.thirdMap.keySet())
    {
      ArrayList<ThirdInfo> thirdlist = (ArrayList)this.thirdMap.get(phone);
      
      this.thirdarrayList.add(thirdlist);
    }
  }
}