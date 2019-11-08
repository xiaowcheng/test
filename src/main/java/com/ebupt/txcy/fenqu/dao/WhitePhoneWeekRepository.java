package com.ebupt.txcy.fenqu.dao;

import com.ebupt.txcy.fenqu.po.WhitePhone_week;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhitePhoneWeekRepository extends JpaRepository<WhitePhone_week, String> {

}
