package com.mobike.mobikeapp.activity.usercenter;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class e
{
  private static final int a = 15;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(ContestNegativeRecordActivity paramContestNegativeRecordActivity)
  {
    if (h.a(paramContestNegativeRecordActivity, b))
    {
      paramContestNegativeRecordActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramContestNegativeRecordActivity, b, 15);
  }
  
  static void a(ContestNegativeRecordActivity paramContestNegativeRecordActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramContestNegativeRecordActivity) < 23) && (!h.a(paramContestNegativeRecordActivity, b)))
    {
      paramContestNegativeRecordActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramContestNegativeRecordActivity.a();
      return;
    }
    if (!h.a(paramContestNegativeRecordActivity, b))
    {
      paramContestNegativeRecordActivity.c();
      return;
    }
    paramContestNegativeRecordActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */