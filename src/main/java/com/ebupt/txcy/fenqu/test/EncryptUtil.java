package com.ebupt.txcy.fenqu.test;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptUtil
{
  private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);
  
  public static String md5encrypt(String inputText)
  {
    if ((inputText == null) || ("".equals(inputText.trim()))) {
      throw new IllegalArgumentException("Please input encrypt text");
    }
    String encryptText = null;
    try
    {
      MessageDigest m = MessageDigest.getInstance("md5");
      m.update(inputText.getBytes("utf-8"));
      byte[] s = m.digest();
      

      return hex(s);
    }
    catch (NoSuchAlgorithmException e)
    {
      logger.error("Error:", e);
    }
    catch (UnsupportedEncodingException e)
    {
      logger.error("Error:", e);
    }
    return encryptText;
  }
  
  private static String hex(byte[] arr)
  {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < arr.length; i++) {
      sb.append(Integer.toHexString(arr[i] & 0xFF | 0x100).substring(1, 3));
    }
    return sb.toString();
  }
  
  public static byte[] AESencrypt(String content, String password)
  {
    try
    {
      byte[] enCodeFormat = password.getBytes("utf-8");
      SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
      
      Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
      cipher.init(1, key);
      char b = '\000';
      while (content.length() % 16 != 0) {
        content = content + String.valueOf(b);
      }
      byte[] byteContent = content.getBytes("utf-8");
      
      return cipher.doFinal(byteContent);
    }
    catch (NoSuchAlgorithmException e)
    {
      logger.error("Error:", e);
    }
    catch (NoSuchPaddingException e)
    {
      logger.error("Error:", e);
    }
    catch (InvalidKeyException e)
    {
      logger.error("Error:", e);
    }
    catch (UnsupportedEncodingException e)
    {
      logger.error("Error:", e);
    }
    catch (IllegalBlockSizeException e)
    {
      logger.error("Error:", e);
    }
    catch (BadPaddingException e)
    {
      logger.error("Error:", e);
    }
    return null;
  }
  
  public static byte[] AESdecrypt(byte[] content, String password)
  {
    try
    {
      byte[] enCodeFormat = password.getBytes("UTF-8");
      SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
      
      Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
      cipher.init(2, key);
      logger.debug("length before AES1:" + content.length);
      
      return cipher.doFinal(content);
    }
    catch (NoSuchAlgorithmException e)
    {
      logger.error("Error:", e);
    }
    catch (NoSuchPaddingException e)
    {
      logger.error("Error:", e);
    }
    catch (InvalidKeyException e)
    {
      logger.error("Error:", e);
    }
    catch (IllegalBlockSizeException e)
    {
      logger.error("Error:", e);
    }
    catch (BadPaddingException e)
    {
      logger.error("Error:", e);
    }
    catch (UnsupportedEncodingException e)
    {
      logger.error("Error:", e);
    }
    return null;
  }
  
  private static String h(byte[] arr)
  {
    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    int j = arr.length;
    char[] str = new char[j * 2];
    int k = 0;
    for (int i = 0; i < j; i++)
    {
      byte byte0 = arr[i];
      str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
      str[(k++)] = hexDigits[(byte0 & 0xF)];
    }
    return new String(str);
  }
  
//  public static void main(String[] args)
//  {
//    md5encrypt("invoke NumberQuery tx 13671346001 13671346002 13671346003 13671346004 13671346005 13671346006 13671346007 13671346008 13671346009 13671346010 13671346011 13671346012 13671346013 13671346014 13671346015 13671346016 13671346017 13671346018CommandInvoke invoke NumberQuery tx 13671346001 13671346002 13671346003 13671346004 13671346005 13671346006 13671346007 13671346008 13671346009 13671346010 13671346011 13671346012 13671346013 13671346014 13671346015 13671346016 13671346017 13671346018invoke NumberQuery tx 13671346001 13671346002 13671346003 13671346004 13671346005 13671346006 13671346007 13671346008 13671346009 13671346010 13671346011 13671346012 13671346013 13671346014 13671346015 13671346016 13671346017 13671346018CommandInvoke invoke NumberQuery tx 13671346001 13671346002 13671346003 13671346004 13671346005 13671346006 13671346007 13671346008 13671346009 13671346010 13671346011 13671346012 13671346013 13671346014 13671346015 13671346016 13671346017 13671346018");
//  }
  
  public static void main(String[] args)
    throws Exception
  {
    String content = "hid=36a8cd4e2b6c3ae939ad4ecf4356de15&nums=13800000001";
    String password = "Sogou$Haoma$YDCY";
    
    System.out.println("src: " + content);
    byte[] encryptResult = AESencrypt(content, password);
    
    String enstr = new String(encryptResult);
    System.out.println("en: " + enstr);
    String enstr64 = Base64Coder.encryptBASE64(encryptResult);
    System.out.println("en + base64: " + enstr64);
    
    byte[] decryptResult = AESdecrypt(encryptResult, password);
    System.out.println("de: " + new String(decryptResult));
    
    
    String a = "Uaqj9WpbUdh3GfvjEVEkI57TWt7Jkq8vcKCrvstGlR3NTAI_h3KyzWP2XGhc4RMcY_GK0Pl6t-j8otPtX4d2Pg";
           a = "Uaqj9WpbUdh3GfvjEVEkI57TWt7Jkq8vcKCrvstGlR3NTAI/h3KyzWP2XGhc4RMcCFXrt18zcF/5QQzT8Wd11g==";
  
    decryptResult = AESdecrypt(Base64Coder.decryptBASE64(a), password);
    System.out.println("de: " + new String(decryptResult));
  }
}
