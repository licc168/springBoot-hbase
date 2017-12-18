package com.licc.hbase.util;

/**
 * Function:(这里用一句话描述这个类的作用)
 *
 * @author Administrator
 * @version 1.0.0
 * @date 2017/12/18 20:05
 * @see
 */
public class StringUtil {
  public static String stringToAscii(String value)
  {
    StringBuffer sbu = new StringBuffer();
    char[] chars = value.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if(i != chars.length - 1)
      {
        sbu.append((int)chars[i]).append(",");
      }
      else {
        sbu.append((int)chars[i]);
      }
    }
    return sbu.toString();
  }
}
