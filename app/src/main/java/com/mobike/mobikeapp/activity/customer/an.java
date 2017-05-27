package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class an
{
  private static final int a = 7;
  private static final String[] b = { "android.permission.CAMERA" };
  private static final int c = 8;
  private static final String[] d = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(ReportViolationsActivity paramReportViolationsActivity)
  {
    if (h.a(paramReportViolationsActivity, b))
    {
      paramReportViolationsActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramReportViolationsActivity, b, 7);
  }
  
  static void a(ReportViolationsActivity paramReportViolationsActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      if ((h.a(paramReportViolationsActivity) < 23) && (!h.a(paramReportViolationsActivity, b)))
      {
        paramReportViolationsActivity.b();
        return;
      }
      if (h.a(paramArrayOfInt))
      {
        paramReportViolationsActivity.a();
        return;
      }
      if (!h.a(paramReportViolationsActivity, b))
      {
        paramReportViolationsActivity.c();
        return;
      }
      paramReportViolationsActivity.b();
      return;
    }
    if ((h.a(paramReportViolationsActivity) < 23) && (!h.a(paramReportViolationsActivity, d)))
    {
      paramReportViolationsActivity.e();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramReportViolationsActivity.d();
      return;
    }
    if (!h.a(paramReportViolationsActivity, d))
    {
      paramReportViolationsActivity.f();
      return;
    }
    paramReportViolationsActivity.e();
  }
  
  static void b(ReportViolationsActivity paramReportViolationsActivity)
  {
    if (h.a(paramReportViolationsActivity, d))
    {
      paramReportViolationsActivity.d();
      return;
    }
    ActivityCompat.requestPermissions(paramReportViolationsActivity, d, 8);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */