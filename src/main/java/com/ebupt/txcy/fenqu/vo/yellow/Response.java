package com.ebupt.txcy.fenqu.vo.yellow;

import java.util.List;

public class Response {
    
    private String code;
    
    private String msg;
    
    private List<PhoneListResponse> data;
    
    public Response() {
    }
    
    public Response(String code, String msg, List<PhoneListResponse> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public List<PhoneListResponse> getData() {
        return data;
    }
    
    public void setData(List<PhoneListResponse> data) {
        this.data = data;
    }
}
