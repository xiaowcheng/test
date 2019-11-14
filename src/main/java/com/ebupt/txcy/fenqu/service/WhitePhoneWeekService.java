package com.ebupt.txcy.fenqu.service;

import com.ebupt.txcy.fenqu.dao.WhitePhoneWeekRepository;
import com.ebupt.txcy.fenqu.po.WhitePhone_week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor=Exception.class)
public class WhitePhoneWeekService {
    
    @Autowired
    WhitePhoneWeekRepository whitePhoneWeekRepository;
    
    
    @Autowired
    JdbcTemplate jdbctemp;
    
    @Transactional
    public List<String> selectAll(List<String> list){
      
        String batchArgs = "(";
        for (int i=0;i<list.size()-2;i++) {
            batchArgs = batchArgs+list.get(i)+",";
        }
        batchArgs = batchArgs+list.get(list.size()-1)+")";
        
        String sql="select phonenumber from txcy_whitephone_week where phonenumber in "+batchArgs;
        List<String> mapList= jdbctemp.query(sql,new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("phonenumber");
            }});
        return mapList;
    }
    
    
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
