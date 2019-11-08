package com.ebupt.txcy.fenqu.vo.ndeliver;

import java.util.List;

public class PhoneList {
    
    private List<NdeliverObj> phoneList;
    
    public PhoneList() {
    }
    
    public PhoneList(List<NdeliverObj> phoneList) {
        this.phoneList = phoneList;
    }
    
    public List<NdeliverObj> getPhoneList() {
        return phoneList;
    }
    
    public void setPhoneList(List<NdeliverObj> phoneList) {
        this.phoneList = phoneList;
    }
}
