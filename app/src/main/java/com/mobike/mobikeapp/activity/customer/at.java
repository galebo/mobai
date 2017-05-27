package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class at
{
  private static final int a = 9;
  private static final String[] b = { "android.permission.CAMERA" };
  private static final int c = 10;
  private static final String[] d = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(RidingOtherIssueActivity paramRidingOtherIssueActivity)
  {
    if (h.a(paramRidingOtherIssueActivity, b))
    {
      paramRidingOtherIssueActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramRidingOtherIssueActivity, b, 9);
  }
  
  static void a(RidingOtherIssueActivity paramRidingOtherIssueActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 9: 
      if ((h.a(paramRidingOtherIssueActivity) < 23) && (!h.a(paramRidingOtherIssueActivity, b)))
      {
        paramRidingOtherIssueActivity.b();
        return;
      }
      if (h.a(paramArrayOfInt))
      {
        paramRidingOtherIssueActivity.a();
        return;
      }
      if (!h.a(paramRidingOtherIssueActivity, b))
      {
        paramRidingOtherIssueActivity.c();
        return;
      }
      paramRidingOtherIssueActivity.b();
      return;
    }
    if ((h.a(paramRidingOtherIssueActivity) < 23) && (!h.a(paramRidingOtherIssueActivity, d)))
    {
      paramRidingOtherIssueActivity.e();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramRidingOtherIssueActivity.d();
      return;
    }
    if (!h.a(paramRidingOtherIssueActivity, d))
    {
      paramRidingOtherIssueActivity.f();
      return;
    }
    paramRidingOtherIssueActivity.e();
  }
  
  static void b(RidingOtherIssueActivity paramRidingOtherIssueActivity)
  {
    if (h.a(paramRidingOtherIssueActivity, d))
    {
      paramRidingOtherIssueActivity.d();
      return;
    }
    ActivityCompat.requestPermissions(paramRidingOtherIssueActivity, d, 10);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */