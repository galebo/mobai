package com.mobike.mobikeapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class h
{
  public static final String a = "surprise_classic.zip";
  public static final String b = "surprise_lite.zip";
  private static h c = new h();
  private String d = "";
  private String e = "";
  
  public static h a()
  {
    return c;
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("SURPRISE_ZIP_DONE", 0).edit();
    paramContext.putBoolean("PRECIOUS_ICON_DATA_KEY", false);
    paramContext.apply();
  }
  
  @SuppressLint({"NewApi"})
  public static <P, T extends AsyncTask<P, ?, ?>> void a(T paramT, P... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
      return;
    }
    paramT.execute(paramVarArgs);
  }
  
  private void a(File paramFile)
  {
    try
    {
      paramFile.delete();
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.indexOf(paramString, "surprise_classic.zip") > -1)
    {
      this.d = paramString;
      return;
    }
    this.e = paramString;
  }
  
  public static boolean d()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean e()
  {
    String str = Environment.getExternalStorageState();
    return ("mounted".equals(str)) || ("mounted_ro".equals(str));
  }
  
  public String a(String paramString, byte[] paramArrayOfByte)
  {
    if (d()) {
      return b(paramString, paramArrayOfByte);
    }
    return c(paramString, paramArrayOfByte);
  }
  
  public void a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    paramString = a(paramString, paramArrayOfByte);
    a(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramContext, false);
      return;
    }
    paramArrayOfByte = new File(paramString.substring(0, paramString.length() - 4));
    try
    {
      a(new File(paramString), paramArrayOfByte);
      a(paramContext, true);
      return;
    }
    catch (Exception paramString)
    {
      a(paramContext, false);
    }
  }
  
  public void a(final File paramFile1, File paramFile2)
    throws IOException
  {
    ZipInputStream localZipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramFile1)));
    Object localObject;
    for (;;)
    {
      byte[] arrayOfByte;
      ZipEntry localZipEntry;
      File localFile;
      try
      {
        arrayOfByte = new byte[' '];
        localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null) {
          break;
        }
        localFile = new File(paramFile2, localZipEntry.getName());
        if (localZipEntry.isDirectory())
        {
          localObject = localFile;
          if ((((File)localObject).isDirectory()) || (((File)localObject).mkdirs())) {
            break label151;
          }
          throw new FileNotFoundException("Failed to ensure directory: " + ((File)localObject).getAbsolutePath());
        }
      }
      finally
      {
        localZipInputStream.close();
        a(new AsyncTask()
        {
          protected Void a(Void... paramAnonymousVarArgs)
          {
            h.a(h.this, paramFile1);
            return null;
          }
        }, new Void[0]);
      }
      localObject = localFile.getParentFile();
      continue;
      label151:
      if (!localZipEntry.isDirectory())
      {
        localObject = new FileOutputStream(localFile);
        try
        {
          for (;;)
          {
            int i = localZipInputStream.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
          }
        }
        finally
        {
          ((FileOutputStream)localObject).close();
        }
      }
    }
    localZipInputStream.close();
    a(new AsyncTask()
    {
      protected Void a(Void... paramAnonymousVarArgs)
      {
        h.a(h.this, paramFile1);
        return null;
      }
    }, new Void[0]);
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.d)) {
      return "";
    }
    return this.d.substring(0, this.d.length() - 4) + "/Android_classic";
  }
  
  public String b(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      localFileOutputStream.write(paramArrayOfByte);
      localFileOutputStream.close();
      paramString = paramString.getAbsolutePath();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.e)) {
      return "";
    }
    return this.e.substring(0, this.e.length() - 4) + "/Android_lite";
  }
  
  public String c(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new File(Environment.getDataDirectory(), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      localFileOutputStream.write(paramArrayOfByte);
      localFileOutputStream.close();
      paramString = paramString.getAbsolutePath();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */