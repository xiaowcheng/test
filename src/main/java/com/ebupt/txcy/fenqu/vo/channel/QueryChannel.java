package com.ebupt.txcy.fenqu.vo.channel;

public class QueryChannel {
    
    private int code;
    
    private String msg;
    
    private QueryRespItem data;
    
    public QueryChannel(int code, String msg, QueryRespItem data) {
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
    
    public QueryRespItem getData() {
        return data;
    }
    
    public void setData(QueryRespItem data) {
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
