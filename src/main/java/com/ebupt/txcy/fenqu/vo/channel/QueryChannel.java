package com.ebupt.txcy.fenqu.vo.channel;

public class QueryChannel {
    
    private int code;
    
    private String msg;
    
    private QueryResp data;
    
    public QueryChannel(int code, String msg, QueryResp data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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
    
    public QueryResp getData() {
        return data;
    }
    
    public void setData(QueryResp data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "QueryChannel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
