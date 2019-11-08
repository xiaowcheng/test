package com.ebupt.txcy.fenqu.dao;

import com.ebupt.txcy.fenqu.po.WhitePhone_week;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.*;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.Date;


@SuppressWarnings("ALL")
public class MySimpleRepository<T, ID> extends SimpleJpaRepository<T, ID> {
    
    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;

    @Autowired
    public MySimpleRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
    }
    
    @Override
    @Transactional
    public <S extends T> S save(S entity) {
//        if (entityInformation.isNew(entity)) {
//            em.persist(entity);
//            return entity;
//        } else {
//            return em.merge(entity);
//        }
      

        if (entity.getClass().equals(WhitePhone_week.class)) {
            if(entityInformation.isNew(entity)){
                return super.save(entity);
            }else {
                WhitePhone_week whitePhone = (WhitePhone_week)entity;
                Object obj = em.find(WhitePhone_week.class,whitePhone.getPhonenumber());
                if(obj == null ){
                    return super.save(entity);
                }
                whitePhone = (WhitePhone_week)obj;
                if (whitePhone.getMarkdate().before(DateUtils.addDays(new Date(),1)) &&whitePhone.getMarkdate().after(DateUtils.addDays(new Date(),-6)) ){
                    return entity;
                }else{
                    return super.save(entity);
                }
            }

        }else
        {
            return super.save(entity);
        }
    }
}