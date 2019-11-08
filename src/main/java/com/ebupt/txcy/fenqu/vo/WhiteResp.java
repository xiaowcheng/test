package com.ebupt.txcy.fenqu.vo;

import java.util.List;

public class WhiteResp {
    
    private int code;
    
    private String msg;
    
    private List<String> data;
    
    private int count;
    
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
    
    public List<String> getData() {
        return data;
    }
    
    public void setData(List<String> data) {
        this.data = data;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public String toString() {
        return "WhiteResp{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
    
    
}
