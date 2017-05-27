package com.mobike.mobikeapp.activity.usercenter;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class x
{
  private static final int a = 16;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(UserDetailActivity paramUserDetailActivity)
  {
    if (h.a(paramUserDetailActivity, b))
    {
      paramUserDetailActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramUserDetailActivity, b, 16);
  }
  
  static void a(UserDetailActivity paramUserDetailActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramUserDetailActivity) < 23) && (!h.a(paramUserDetailActivity, b)))
    {
      paramUserDetailActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramUserDetailActivity.a();
      return;
    }
    if (!h.a(paramUserDetailActivity, b))
    {
      paramUserDetailActivity.c();
      return;
    }
    paramUserDetailActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */