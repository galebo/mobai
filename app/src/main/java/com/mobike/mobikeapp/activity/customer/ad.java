package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class ad
{
  private static final int a = 4;
  private static final String[] b = { "android.permission.CAMERA" };
  private static final int c = 5;
  private static final String[] d = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(ReportIssueActivity paramReportIssueActivity)
  {
    if (h.a(paramReportIssueActivity, b))
    {
      paramReportIssueActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramReportIssueActivity, b, 4);
  }
  
  static void a(ReportIssueActivity paramReportIssueActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      if ((h.a(paramReportIssueActivity) < 23) && (!h.a(paramReportIssueActivity, b)))
      {
        paramReportIssueActivity.b();
        return;
      }
      if (h.a(paramArrayOfInt))
      {
        paramReportIssueActivity.a();
        return;
      }
      if (!h.a(paramReportIssueActivity, b))
      {
        paramReportIssueActivity.c();
        return;
      }
      paramReportIssueActivity.b();
      return;
    }
    if ((h.a(paramReportIssueActivity) < 23) && (!h.a(paramReportIssueActivity, d)))
    {
      paramReportIssueActivity.e();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramReportIssueActivity.d();
      return;
    }
    if (!h.a(paramReportIssueActivity, d))
    {
      paramReportIssueActivity.f();
      return;
    }
    paramReportIssueActivity.e();
  }
  
  static void b(ReportIssueActivity paramReportIssueActivity)
  {
    if (h.a(paramReportIssueActivity, d))
    {
      paramReportIssueActivity.d();
      return;
    }
    ActivityCompat.requestPermissions(paramReportIssueActivity, d, 5);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */