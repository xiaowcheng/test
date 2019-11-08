package com.ebupt.txcy.fenqu.vo.yellow;

import java.sql.Date;

public class YellowpagelibObj {
    
    private String phonenumber;
    
    private String classAtype;
    
    private String profession;
    
    private String classBtype;
    
    private String sourceId;
    
    private Date createTime;
    
    public YellowpagelibObj() {
    }
    
    public YellowpagelibObj(String phonenumber, String classAtype, String profession, String classBtype, String sourceId) {
        this.phonenumber = phonenumber;
        this.classAtype = classAtype;
        this.profession = profession;
        this.classBtype = classBtype;
        this.sourceId = sourceId;
    }
    
    public YellowpagelibObj(String phonenumber, String classAtype, String profession, String classBtype, String sourceId, Date createTime) {
        this.phonenumber = phonenumber;
        this.classAtype = classAtype;
        this.profession = profession;
        this.classBtype = classBtype;
        this.sourceId = sourceId;
        this.createTime = createTime;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getClassAtype() {
        return classAtype;
    }
    
    public void setClassAtype(String classAtype) {
        this.classAtype = classAtype;
    }
    
    public String getProfession() {
        return profession;
    }
    
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public String getClassBtype() {
        return classBtype;
    }
    
    public void setClassBtype(String classBtype) {
        this.classBtype = classBtype;
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
