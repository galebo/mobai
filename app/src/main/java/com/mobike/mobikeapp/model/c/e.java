package com.mobike.mobikeapp.model.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class e
{
  public static Object a(String paramString)
    throws IOException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new ObjectInputStream(new ByteArrayInputStream(b(paramString))).readObject();
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new IOException("Deserialization error: " + paramString.getMessage(), paramString);
    }
  }
  
  public static String a(Serializable paramSerializable)
    throws IOException
  {
    if (paramSerializable == null) {
      return "";
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramSerializable);
      localObjectOutputStream.close();
      paramSerializable = a(localByteArrayOutputStream.toByteArray());
      return paramSerializable;
    }
    catch (Exception paramSerializable)
    {
      throw new IOException("Serialization error: " + paramSerializable.getMessage(), paramSerializable);
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      localStringBuffer.append((char)((paramArrayOfByte[i] >> 4 & 0xF) + 97));
      localStringBuffer.append((char)((paramArrayOfByte[i] & 0xF) + 97));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      arrayOfByte[(i / 2)] = ((byte)(j - 97 << 4));
      j = paramString.charAt(i + 1);
      int k = i / 2;
      arrayOfByte[k] = ((byte)(j - 97 + arrayOfByte[k]));
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/model/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */