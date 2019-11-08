package com.ebupt.txcy.fenqu.vo;

public class YellowInfo
{
  private String phone;
  private short sourceID;
  private String profession;
  private String classBType;
  
  public YellowInfo(String phone, short sourceID, String profession, String classBType)
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
    this.profession = profession;
    this.classBType = classBType;
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
  
  public String getProfession()
  {
    return this.profession;
  }
  
  public void setProfession(String profession)
  {
    this.profession = profession;
  }
  
  public String getClassBType()
  {
    return this.classBType;
  }
  
  public void setClassBType(String classBType)
  {
    this.classBType = classBType;
  }
}
