package com.ebupt.txcy.fenqu.vo.channel;

import java.util.List;

public class PhoneList {
    
    private List<String> phoneList;
    
    public PhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
    
    public List<String> getPhoneList() {
        return phoneList;
    }
    
    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
}
