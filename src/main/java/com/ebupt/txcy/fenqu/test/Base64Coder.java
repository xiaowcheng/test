package com.ebupt.txcy.fenqu.test;

import java.io.PrintStream;
import org.apache.commons.codec.binary.Base64;

public class Base64Coder
{
  public static void main(String[] args)
    throws Exception
  {
    String src = "hi,i am 北邮.";
    System.out.println("src:" + src);
    String en = encryptBASE64(src.getBytes());
    System.out.println("en :[" + en + "]");
    
    byte[] de = decryptBASE64(en);
    String ded = new String(de);
    System.out.println("de :" + ded);
  }
  
  public static String encryptBASE64(byte[] srcBytes)
    throws Exception
  {
    return Base64.encodeBase64URLSafeString(srcBytes);
  }
  
  public static byte[] decryptBASE64(String encodedString)
    throws Exception
  {
    return Base64.decodeBase64(encodedString);
  }
}
