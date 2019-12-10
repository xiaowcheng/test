package com.ebupt.txcy.fenqu.vo.ndeliver;

import java.sql.Date;

public class NdeliverObj {
    
    private String phoneNumber;
    
    private String datatype;
    
    private String sourceName;
    
    private String markTimes;
    
    private String markType;
    
    private Date updateTime;
    
    private String sourceId;
    
    public NdeliverObj() {
    }
    
    public NdeliverObj(String phoneNumber, String datatype, String sourceName, String markTimes, String markType, String sourceid) {
        this.phoneNumber = phoneNumber;
        this.datatype = datatype;
        this.sourceName = sourceName;
        this.markTimes = markTimes;
        this.markType = markType;
        this.sourceId = sourceId;
    }
    
    public NdeliverObj(String phoneNumber, String datatype, String sourceName, String markTimes, String markType, Date updateTime, String sourceId) {
        this.phoneNumber = phoneNumber;
        this.datatype = datatype;
        this.sourceName = sourceName;
        this.markTimes = markTimes;
        this.markType = markType;
        this.updateTime = updateTime;
        this.sourceId = sourceId;
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
    
    public String getDatatype() {
        return datatype;
    }
    
    public void setDatatype(String datatype) {
        this.datatype = datatype;
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
