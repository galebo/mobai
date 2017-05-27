package com.mobike.mobikeapp.activity.pay;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class j
{
  private static final int a = 13;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(DepositRefundIssueActivity paramDepositRefundIssueActivity)
  {
    if (h.a(paramDepositRefundIssueActivity, b))
    {
      paramDepositRefundIssueActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramDepositRefundIssueActivity, b, 13);
  }
  
  static void a(DepositRefundIssueActivity paramDepositRefundIssueActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramDepositRefundIssueActivity) < 23) && (!h.a(paramDepositRefundIssueActivity, b)))
    {
      paramDepositRefundIssueActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramDepositRefundIssueActivity.a();
      return;
    }
    if (!h.a(paramDepositRefundIssueActivity, b))
    {
      paramDepositRefundIssueActivity.c();
      return;
    }
    paramDepositRefundIssueActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */