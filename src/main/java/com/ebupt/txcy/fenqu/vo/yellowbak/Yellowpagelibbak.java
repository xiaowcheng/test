package com.ebupt.txcy.fenqu.vo.yellowbak;

import java.sql.Date;

public class Yellowpagelibbak {
    
    private String phoneNumber;
    
    private  String classAType;
    
    private String profession;
    
    private String classBType;
    
    private String sourceId;
    
    private Date createTime;
    
    public Yellowpagelibbak() {
    }
    
    public Yellowpagelibbak(String phoneNumber, String classAType, String profession, String classBType, String sourceId) {
        this.phoneNumber = phoneNumber;
        this.classAType = classAType;
        this.profession = profession;
        this.classBType = classBType;
        this.sourceId = sourceId;
    }
    
    public Yellowpagelibbak(String phoneNumber, String classAType, String profession, String classBType, String sourceId, Date createTime) {
        this.phoneNumber = phoneNumber;
        this.classAType = classAType;
        this.profession = profession;
        this.classBType = classBType;
        this.sourceId = sourceId;
        this.createTime = createTime;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getClassAType() {
        return classAType;
    }
    
    public void setClassAType(String classAType) {
        this.classAType = classAType;
    }
    
    public String getProfession() {
        return profession;
    }
    
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public String getClassBType() {
        return classBType;
    }
    
    public void setClassBType(String classBType) {
        this.classBType = classBType;
    }
    
    public String getSourceId() {
        return sourceId;
    }
    
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
