package com.ebupt.txcy.fenqu.vo.yellow;

public class PhoneListResponse {
    
    private String phonenumber;
    
    private String code;
    
    private String errdesc;
    
    public PhoneListResponse() {
    }
    
    public PhoneListResponse(String phonenumber, String code, String errdesc) {
        this.phonenumber = phonenumber;
        this.code = code;
        this.errdesc = errdesc;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getErrdesc() {
        return errdesc;
    }
    
    public void setErrdesc(String errdesc) {
        this.errdesc = errdesc;
    }
}
