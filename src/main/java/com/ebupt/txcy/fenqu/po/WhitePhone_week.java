package com.ebupt.txcy.fenqu.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="TXCY_WHITEPHONE_WEEK")
@Entity
public class WhitePhone_week implements Serializable {
    
    

    @Id
    private String phonenumber;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date markdate;
    
    public WhitePhone_week() {
    }
    
    public WhitePhone_week(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public WhitePhone_week(String phonenumber, Date markdate) {
        this.phonenumber = phonenumber;
        this.markdate = markdate;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public Date getMarkdate() {
        return markdate;
    }
    
    public void setMarkdate(Date markdate) {
        this.markdate = markdate;
    }
}
