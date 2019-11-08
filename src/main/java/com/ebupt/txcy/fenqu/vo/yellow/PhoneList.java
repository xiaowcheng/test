package com.ebupt.txcy.fenqu.vo.yellow;

import java.util.List;

public class PhoneList {
    
    private List<YellowpagelibObj> phoneList;
    
    public PhoneList() {
    }
    
    public PhoneList(List<YellowpagelibObj> phoneList) {
        this.phoneList = phoneList;
    }
    
    public List<YellowpagelibObj> getPhoneList() {
        return phoneList;
    }
    
    public void setPhoneList(List<YellowpagelibObj> phoneList) {
        this.phoneList = phoneList;
    }
}
