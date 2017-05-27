package com.mobike.mobikeapp.activity.customer;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class q
{
  private static final int a = 2;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(LockNoFeeActivity paramLockNoFeeActivity)
  {
    if (h.a(paramLockNoFeeActivity, b))
    {
      paramLockNoFeeActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramLockNoFeeActivity, b, 2);
  }
  
  static void a(LockNoFeeActivity paramLockNoFeeActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramLockNoFeeActivity) < 23) && (!h.a(paramLockNoFeeActivity, b)))
    {
      paramLockNoFeeActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramLockNoFeeActivity.a();
      return;
    }
    if (!h.a(paramLockNoFeeActivity, b))
    {
      paramLockNoFeeActivity.c();
      return;
    }
    paramLockNoFeeActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */