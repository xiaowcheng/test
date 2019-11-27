package com.ebupt.txcy.fenqu.test;

import com.ebupt.txcy.fenqu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

public class RedisTest {
    
    public static void main(String[] args) {
//        List days = new ArrayList();
//
//        for (int i = 0; i < 7 ; i++) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.add(Calendar.DAY_OF_YEAR,-i);
//            String nowDay = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
//            days.add(nowDay);
//        }
//        days.forEach(System.out::println);
        
//        List<String> list = new ArrayList<>(20000);
//        for (int i = 9990000; i < 10000000 ; i++) {
//            list.add(i+"");
//        }
//        for (int i = 9995000; i < 10005000 ; i++) {
//            list.add(i+"");
//        }
//
//
//        System.out.println("----------");
//
//        System.out.println(list.size());
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
//        System.out.println(sdf.format(new Date()));
//
//        list = new ArrayList<>(new HashSet<>(list));
//        System.out.println(sdf.format(new Date()));
//        System.out.println(list.size());
    
        Set set = new HashSet();
        set.add("12");
        System.out.println(set.contains("123"));

    }
}


