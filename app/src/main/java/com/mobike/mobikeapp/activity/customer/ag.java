package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class ag
{
  private static final int a = 6;
  private static final String[] b = { "android.permission.CAMERA" };
  
  static void a(ReportUnlockFailActivity paramReportUnlockFailActivity)
  {
    if (h.a(paramReportUnlockFailActivity, b))
    {
      paramReportUnlockFailActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramReportUnlockFailActivity, b, 6);
  }
  
  static void a(ReportUnlockFailActivity paramReportUnlockFailActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramReportUnlockFailActivity) < 23) && (!h.a(paramReportUnlockFailActivity, b)))
    {
      paramReportUnlockFailActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramReportUnlockFailActivity.a();
      return;
    }
    if (!h.a(paramReportUnlockFailActivity, b))
    {
      paramReportUnlockFailActivity.c();
      return;
    }
    paramReportUnlockFailActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */