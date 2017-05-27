package com.mobike.mobikeapp;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class bz
{
  private static final int a = 20;
  private static final String[] b = { "android.permission.CAMERA" };
  private static final int c = 21;
  private static final String[] d = { "android.permission.CAMERA" };
  
  static void a(QRCodeInputActivity paramQRCodeInputActivity)
  {
    if (h.a(paramQRCodeInputActivity, b))
    {
      paramQRCodeInputActivity.c();
      return;
    }
    ActivityCompat.requestPermissions(paramQRCodeInputActivity, b, 20);
  }
  
  static void a(QRCodeInputActivity paramQRCodeInputActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 20: 
      if ((h.a(paramQRCodeInputActivity) < 23) && (!h.a(paramQRCodeInputActivity, b)))
      {
        paramQRCodeInputActivity.a();
        return;
      }
      if (h.a(paramArrayOfInt))
      {
        paramQRCodeInputActivity.c();
        return;
      }
      if (!h.a(paramQRCodeInputActivity, b))
      {
        paramQRCodeInputActivity.b();
        return;
      }
      paramQRCodeInputActivity.a();
      return;
    }
    if ((h.a(paramQRCodeInputActivity) < 23) && (!h.a(paramQRCodeInputActivity, d)))
    {
      paramQRCodeInputActivity.a();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramQRCodeInputActivity.d();
      return;
    }
    if (!h.a(paramQRCodeInputActivity, d))
    {
      paramQRCodeInputActivity.b();
      return;
    }
    paramQRCodeInputActivity.a();
  }
  
  static void b(QRCodeInputActivity paramQRCodeInputActivity)
  {
    if (h.a(paramQRCodeInputActivity, d))
    {
      paramQRCodeInputActivity.d();
      return;
    }
    ActivityCompat.requestPermissions(paramQRCodeInputActivity, d, 21);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */