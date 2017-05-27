package com.mobike.mobikeapp;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class cg
{
  private static final int a = 22;
  private static final String[] b = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  
  static void a(SplashActivity paramSplashActivity)
  {
    if (h.a(paramSplashActivity, b))
    {
      paramSplashActivity.c();
      return;
    }
    ActivityCompat.requestPermissions(paramSplashActivity, b, 22);
  }
  
  static void a(SplashActivity paramSplashActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramSplashActivity) < 23) && (!h.a(paramSplashActivity, b)))
    {
      paramSplashActivity.a();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramSplashActivity.c();
      return;
    }
    if (!h.a(paramSplashActivity, b))
    {
      paramSplashActivity.b();
      return;
    }
    paramSplashActivity.a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */