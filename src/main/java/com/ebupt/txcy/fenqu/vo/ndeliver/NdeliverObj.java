package com.ebupt.txcy.fenqu.vo.ndeliver;

import java.sql.Date;

public class NdeliverObj {
    
    private String phoneNumber;
    
    private String dataType;
    
    private String sourceName;
    
    private String markTimes;
    
    private String markType;
    
    private Date updateTime;
    
    private String sourceId;
    
    private String id;
    
    public NdeliverObj() {
    }
    
    public NdeliverObj(String phoneNumber, String dataType, String sourceName, String markTimes, String markType, String sourceId,String id) {
        this.phoneNumber = phoneNumber;
        this.dataType = dataType;
        this.sourceName = sourceName;
        this.markTimes = markTimes;
        this.markType = markType;
        this.sourceId = sourceId;
        this.id = id;
    }
    
    public NdeliverObj(String phoneNumber, String dataType, String sourceName, String markTimes, String markType, Date updateTime, String sourceId,String id) {
        this.phoneNumber = phoneNumber;
        this.dataType = dataType;
        this.sourceName = sourceName;
        this.markTimes = markTimes;
        this.markType = markType;
        this.updateTime = updateTime;
        this.sourceId = sourceId;
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getSourceId() {
        return sourceId;
    }
    
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
    
    public String getDataType() {
        return dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    public String getSourceName() {
        return sourceName;
    }
    
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    
    public String getMarkTimes() {
        return markTimes;
    }
    
    public void setMarkTimes(String markTimes) {
        this.markTimes = markTimes;
    }
    
    public String getMarkType() {
        return markType;
    }
    
    public void setMarkType(String markType) {
        this.markType = markType;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
