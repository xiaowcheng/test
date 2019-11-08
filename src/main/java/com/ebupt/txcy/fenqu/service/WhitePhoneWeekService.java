package com.ebupt.txcy.fenqu.service;

import com.ebupt.txcy.fenqu.dao.WhitePhoneWeekRepository;
import com.ebupt.txcy.fenqu.po.WhitePhone_week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional(rollbackFor=Exception.class)
public class WhitePhoneWeekService {
    
    @Autowired
    WhitePhoneWeekRepository whitePhoneWeekRepository;
    
    
    @Autowired
    JdbcTemplate jdbctemp;
    
    
    @Transactional
    public void saveAll(Set<String> set){
        List<Object[]> batchArgs=new ArrayList<Object[]>();
        set.forEach(phone->batchArgs.add(new Object[]{phone}));

        String sql="merge into txcy_whitephone_week a using (select ? as phonenumber,trunc(sysdate,'DD') as markdate from dual) b\n" +
                "        on (a.phonenumber = b.phonenumber and a.markdate < trunc(sysdate,'DD')+1 and a.markdate >= trunc(sysdate,'DD')-6)\n" +
                "        when not matched then\n" +
                "        insert\n" +
                "        values (b.phonenumber,trunc(sysdate,'DD'))";
        jdbctemp.batchUpdate(sql,batchArgs);
    }
}
