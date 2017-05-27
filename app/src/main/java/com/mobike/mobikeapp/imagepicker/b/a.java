package com.mobike.mobikeapp.imagepicker.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.ab;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v4.util.SimpleArrayMap;

public class a
{
  private static final SimpleArrayMap<String, Integer> a = new SimpleArrayMap(6);
  
  static
  {
    a.put("com.android.voicemail.permission.ADD_VOICEMAIL", Integer.valueOf(14));
    a.put("android.permission.BODY_SENSORS", Integer.valueOf(20));
    a.put("android.permission.READ_CALL_LOG", Integer.valueOf(16));
    a.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(16));
    a.put("android.permission.USE_SIP", Integer.valueOf(9));
    a.put("android.permission.WRITE_CALL_LOG", Integer.valueOf(16));
  }
  
  public static void a(@ab int[] paramArrayOfInt, a parama)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (paramArrayOfInt[i] != 0)
      {
        parama.a();
        return;
      }
      i += 1;
    }
    parama.b();
  }
  
  public static boolean a(Activity paramActivity, int paramInt, String[] paramArrayOfString)
  {
    if (!a(paramActivity, paramArrayOfString))
    {
      ActivityCompat.requestPermissions(paramActivity, paramArrayOfString, paramInt);
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    for (;;)
    {
      return true;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (PermissionChecker.checkSelfPermission(paramContext, paramVarArgs[i]) != 0) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    paramString = (Integer)a.get(paramString);
    return (paramString == null) || (Build.VERSION.SDK_INT >= paramString.intValue());
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */