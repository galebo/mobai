package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class x
{
  private static final int a = 3;
  private static final String[] b = { "android.permission.CAMERA" };
  
  static void a(LockRingIssueActivity paramLockRingIssueActivity)
  {
    if (h.a(paramLockRingIssueActivity, b))
    {
      paramLockRingIssueActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramLockRingIssueActivity, b, 3);
  }
  
  static void a(LockRingIssueActivity paramLockRingIssueActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramLockRingIssueActivity) < 23) && (!h.a(paramLockRingIssueActivity, b)))
    {
      paramLockRingIssueActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramLockRingIssueActivity.a();
      return;
    }
    if (!h.a(paramLockRingIssueActivity, b))
    {
      paramLockRingIssueActivity.c();
      return;
    }
    paramLockRingIssueActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */