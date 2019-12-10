package com.ebupt.txcy.fenqu.vo.spamlib;

import java.sql.Date;

public class Spamlib {
    
    private  String phoneNumber;
    
    private Integer sourceId;
    
    private String markType;
    
    private Integer markTimes;
    
    private Integer Id;
    
    private Date updateTime;
    
    public Spamlib() {
    }
    
    public Spamlib(String phoneNumber, Integer sourceId, String markType, Integer markTimes, Integer id) {
        this.phoneNumber = phoneNumber;
        this.sourceId = sourceId;
        this.markType = markType;
        this.markTimes = markTimes;
        Id = id;
    }
    
    public Spamlib(String phoneNumber, Integer sourceId, String markType, Integer markTimes, Integer id, Date updateTime) {
        this.phoneNumber = phoneNumber;
        this.sourceId = sourceId;
        this.markType = markType;
        this.markTimes = markTimes;
        Id = id;
        this.updateTime = updateTime;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Integer getSourceId() {
        return sourceId;
    }
    
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }
    
    public String getMarkType() {
        return markType;
    }
    
    public void setMarkType(String markType) {
        this.markType = markType;
    }
    
    public Integer getMarkTimes() {
        return markTimes;
    }
    
    public void setMarkTimes(Integer markTimes) {
        this.markTimes = markTimes;
    }
    
    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
