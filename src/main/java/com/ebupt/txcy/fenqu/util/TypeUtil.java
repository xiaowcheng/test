package com.ebupt.txcy.fenqu.util;

import java.util.ArrayList;

import com.ebupt.txcy.fenqu.vo.channel.Type;
import com.ebupt.txcy.fenqu.vo.channel.TypeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class TypeUtil
{
  private static Logger logger = LoggerFactory.getLogger(TypeUtil.class);
  
  
  @Autowired
  private TypeConstants typeConstants;

  public String dealNewType(String type)
  {
    if ((type == null) || (type.equalsIgnoreCase(""))) {
      return null;
    }
    ArrayList<Type> typeconstants = (ArrayList<Type>) typeConstants.getTypes();
    for (Type typeinfo : typeconstants) {
      if ((typeinfo.getValue().contains(type)) || (type.contains(typeinfo.getValue()))) {
        if (typeinfo.getKey().equalsIgnoreCase("type0"))
        {
          if (!type.contains("反诈骗")) {
            return "疑似诈骗";
          }
        }
        else
        {
          if (typeinfo.getKey().equalsIgnoreCase("type1")) {
            return "疑似骚扰";
          }
          if (typeinfo.getKey().equalsIgnoreCase("type15")) {
            return "疑似违法";
          }
          return typeinfo.getValue();
        }
      }
    }
    return type;
  }
}
