package com.ebupt.txcy.fenqu.vo;

import java.util.List;

public class PhoneList {
    
    private List<String> phoneNumbers;
    
    public PhoneList(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    
    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
