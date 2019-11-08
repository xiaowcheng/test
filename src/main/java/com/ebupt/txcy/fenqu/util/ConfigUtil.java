package com.ebupt.txcy.fenqu.util;

import java.util.HashSet;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil
{
  private static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
  
  
  public static HashSet<String> quhao = new HashSet();
  
  public static boolean isInteger(String str)
  {
    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
    return pattern.matcher(str).matches();
  }
  

}
