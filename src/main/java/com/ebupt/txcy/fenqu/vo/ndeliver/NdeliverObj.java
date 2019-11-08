package com.ebupt.txcy.fenqu.vo.ndeliver;

import java.sql.Date;

public class NdeliverObj {
    
    private String phonenumer;
    
    private String datatype;
    
    private String sourceName;
    
    private String markTimes;
    
    private String markType;
    
    private Date updateTime;
    
    private String sourceid;
    
    public NdeliverObj() {
    }
    
    public NdeliverObj(String phonenumer, String datatype, String sourceName, String markTimes, String markType, String sourceid) {
        this.phonenumer = phonenumer;
        this.datatype = datatype;
        this.sourceName = sourceName;
        this.markTimes = markTimes;
        this.markType = markType;
        this.sourceid = sourceid;
    }
    
    public NdeliverObj(String phonenumer, String datatype, String sourceName, String markTimes, String markType, Date updateTime, String sourceid) {
        this.phonenumer = phonenumer;
        this.datatype = datatype;
        this.sourceName = sourceName;
        this.markTimes = markTimes;
        this.markType = markType;
        this.updateTime = updateTime;
        this.sourceid = sourceid;
    }
    
    public String getPhonenumer() {
        return phonenumer;
    }
    
    public void setPhonenumer(String phonenumer) {
        this.phonenumer = phonenumer;
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
    
    public String getSourceid() {
        return sourceid;
    }
    
    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }
}
