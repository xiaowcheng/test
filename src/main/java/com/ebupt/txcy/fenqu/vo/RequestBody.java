package com.ebupt.txcy.fenqu.vo;

public class RequestBody {
    
    private String phoneCondition;
    
    private String start;
    
    private String page;
    
    public RequestBody(String phoneCondition, String start, String page) {
        this.phoneCondition = phoneCondition;
        this.start = start;
        this.page = page;
    }
    
    public String getPhoneCondition() {
        return phoneCondition;
    }
    
    public void setPhoneCondition(String phoneCondition) {
        this.phoneCondition = phoneCondition;
    }
    
    public String getStart() {
        return start;
    }
    
    public void setStart(String start) {
        this.start = start;
    }
    
    public String getPage() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
}
