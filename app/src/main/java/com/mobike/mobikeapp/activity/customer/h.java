package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;

final class h
{
  private static final int a = 0;
  private static final String[] b = { "android.permission.CAMERA" };
  private static final int c = 1;
  private static final String[] d = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(BikeDamageReportActivity paramBikeDamageReportActivity)
  {
    if (b.a.h.a(paramBikeDamageReportActivity, b))
    {
      paramBikeDamageReportActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramBikeDamageReportActivity, b, 0);
  }
  
  static void a(BikeDamageReportActivity paramBikeDamageReportActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((b.a.h.a(paramBikeDamageReportActivity) < 23) && (!b.a.h.a(paramBikeDamageReportActivity, b)))
      {
        paramBikeDamageReportActivity.b();
        return;
      }
      if (b.a.h.a(paramArrayOfInt))
      {
        paramBikeDamageReportActivity.a();
        return;
      }
      if (!b.a.h.a(paramBikeDamageReportActivity, b))
      {
        paramBikeDamageReportActivity.c();
        return;
      }
      paramBikeDamageReportActivity.b();
      return;
    }
    if ((b.a.h.a(paramBikeDamageReportActivity) < 23) && (!b.a.h.a(paramBikeDamageReportActivity, d)))
    {
      paramBikeDamageReportActivity.e();
      return;
    }
    if (b.a.h.a(paramArrayOfInt))
    {
      paramBikeDamageReportActivity.d();
      return;
    }
    if (!b.a.h.a(paramBikeDamageReportActivity, d))
    {
      paramBikeDamageReportActivity.f();
      return;
    }
    paramBikeDamageReportActivity.e();
  }
  
  static void b(BikeDamageReportActivity paramBikeDamageReportActivity)
  {
    if (b.a.h.a(paramBikeDamageReportActivity, d))
    {
      paramBikeDamageReportActivity.d();
      return;
    }
    ActivityCompat.requestPermissions(paramBikeDamageReportActivity, d, 1);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */