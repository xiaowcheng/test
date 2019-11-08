package com.ebupt.txcy.fenqu.vo.spamlib;

import java.util.List;

public class PhoneList {
    
    private List<Spamlib> phoneList;
    
    public PhoneList() {
    }
    
    public PhoneList(List<Spamlib> phoneList) {
        this.phoneList = phoneList;
    }
    
    public List<Spamlib> getPhoneList() {
        return phoneList;
    }
    
    public void setPhoneList(List<Spamlib> phoneList) {
        this.phoneList = phoneList;
    }
}
