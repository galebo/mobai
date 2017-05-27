package com.mobike.mobikeapp.model.c;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d
{
  private static final String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  private static String a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    return a[paramByte] + a[(i % 16)];
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = new String(paramString);
      localNoSuchAlgorithmException1.printStackTrace();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        paramString = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
        return paramString;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        for (;;)
        {
          paramString = localNoSuchAlgorithmException1;
          Object localObject = localNoSuchAlgorithmException2;
        }
      }
      localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
      paramString = null;
    }
    return paramString;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      localStringBuffer.append(a(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String b(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return String.valueOf(i);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/model/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */