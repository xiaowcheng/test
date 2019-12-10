package com.ebupt.txcy.fenqu.vo.channel;

import java.util.List;

public class QueryChannel {
    
    private int code;
    
    private String msg;
    
    private List<QueryRespItem> data;
    
    private int name;
    
    public QueryChannel(int code, String msg, List<QueryRespItem> data, int name) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.name = name;
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public List<QueryRespItem> getData() {
        return data;
    }
    
    public void setData(List<QueryRespItem> data) {
        this.data = data;
    }
    
    public int getName() {
        return name;
    }
    
    public void setName(int name) {
        this.name = name;
    }
    
}
