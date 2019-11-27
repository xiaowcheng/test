package com.ebupt.txcy.fenqu.service;

import com.ebupt.txcy.fenqu.dao.WhitePhoneWeekRepository;
import com.ebupt.txcy.fenqu.po.WhitePhone_week;
import com.ebupt.txcy.fenqu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor=Exception.class)
public class WhitePhoneWeekService {
    
    @Value("${spring.redis.white_week_expiretime}")
    private int white_week_expiretime;
    
    @Autowired
    WhitePhoneWeekRepository whitePhoneWeekRepository;
    
    
    @Autowired
    JdbcTemplate jdbctemp;
    
    @Resource
    private RedisUtil redisUtil;
    
    /**
     * 获取数据库中是否存在白名单数据
     * @param list
     * @return
     */
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
    
    /**
     * 存入数据库
     * @param set
     */
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
    
    public void saveRedisAll(Set<String> set){
        String key = "white_week_"+new SimpleDateFormat("yyyyMMdd").format(new Date());
        redisUtil.sSetAndTime(key,white_week_expiretime,set.toArray());
    }
}
