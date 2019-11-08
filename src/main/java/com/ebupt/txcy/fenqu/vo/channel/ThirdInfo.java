package com.ebupt.txcy.fenqu.vo.channel;

public class ThirdInfo
{
  private String phone;
  private short sourceID;
  private String type;
  private int count;
  
  public ThirdInfo(String phone, short sourceID, String type, int count, String showTimes)
  {
    this.phone = phone.trim();
    this.sourceID = sourceID;
    this.type = type;
    this.count = count;
    this.showTimes = showTimes;
  }
  
  public ThirdInfo(String phone, short sourceID, String type, int count, int id)
  {
    if (phone.trim().startsWith("+86")) {
      this.phone = phone.trim().substring(2);
    } else if (phone.trim().startsWith("0086")) {
      this.phone = phone.trim().substring(3);
    } else if (phone.trim().startsWith("86")) {
      this.phone = phone.trim().substring(1);
    }
    this.phone = phone.trim();
    this.sourceID = sourceID;
    this.type = type;
    this.count = count;
    this.id = id;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  
  public short getSourceID()
  {
    return this.sourceID;
  }
  
  public void setSourceID(short sourceID)
  {
    this.sourceID = sourceID;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public void setCount(int count)
  {
    this.count = count;
  }
  
  public String getShowTimes()
  {
    return this.showTimes;
  }
  
  public void setShowTimes(String showTimes)
  {
    this.showTimes = showTimes;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  private int id = 0;
  private String showTimes;
}
