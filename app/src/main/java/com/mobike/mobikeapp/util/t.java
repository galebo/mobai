package com.mobike.mobikeapp.util;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class t
{
  private static final String a = "RSAUtils";
  private static String b = "RSA";
  private static String c = "RSA/ECB/PKCS1Padding";
  
  public static KeyPair a()
  {
    return a(1024);
  }
  
  public static KeyPair a(int paramInt)
  {
    try
    {
      Object localObject = KeyPairGenerator.getInstance(b);
      ((KeyPairGenerator)localObject).initialize(paramInt);
      localObject = ((KeyPairGenerator)localObject).genKeyPair();
      return (KeyPair)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }
  
  public static PublicKey a(InputStream paramInputStream)
    throws Exception
  {
    try
    {
      paramInputStream = a(c(paramInputStream));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new Exception("公钥数据流读取错误");
    }
    catch (NullPointerException paramInputStream)
    {
      throw new Exception("公钥输入流为空");
    }
  }
  
  public static PublicKey a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      paramString = KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InvalidKeySpecException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static PublicKey a(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString1 = new RSAPublicKeySpec(new BigInteger(paramString1), new BigInteger(paramString2));
    return KeyFactory.getInstance(b).generatePublic(paramString1);
  }
  
  public static PublicKey a(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(b).generatePublic(paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance(c);
      localCipher.init(2, paramPrivateKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance(c);
      localCipher.init(1, paramPublicKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static PrivateKey b(InputStream paramInputStream)
    throws Exception
  {
    try
    {
      paramInputStream = b(c(paramInputStream));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new Exception("私钥数据读取错误");
    }
    catch (NullPointerException paramInputStream)
    {
      throw new Exception("私钥输入流为空");
    }
  }
  
  public static PrivateKey b(String paramString)
  {
    try
    {
      paramString = new PKCS8EncodedKeySpec(Base64.decode(paramString, 0));
      paramString = KeyFactory.getInstance(b).generatePrivate(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InvalidKeySpecException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static PrivateKey b(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString1 = new RSAPublicKeySpec(new BigInteger(paramString1), new BigInteger(paramString2));
    return KeyFactory.getInstance(b).generatePrivate(paramString1);
  }
  
  public static PrivateKey b(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(b).generatePrivate(paramArrayOfByte);
  }
  
  private static String c(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      if (str.charAt(0) != '-')
      {
        localStringBuilder.append(str);
        localStringBuilder.append('\r');
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */