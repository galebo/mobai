package com.mobike.mobikeapp;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class j
{
  private static final int a = 17;
  private static final String[] b = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  
  static void a(MainActivity paramMainActivity)
  {
    if (h.a(paramMainActivity, b))
    {
      paramMainActivity.b();
      return;
    }
    ActivityCompat.requestPermissions(paramMainActivity, b, 17);
  }
  
  static void a(MainActivity paramMainActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramMainActivity) < 23) && (!h.a(paramMainActivity, b)))
    {
      paramMainActivity.c();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramMainActivity.b();
      return;
    }
    if (!h.a(paramMainActivity, b))
    {
      paramMainActivity.d();
      return;
    }
    paramMainActivity.c();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */