package com.mobike.mobikeapp.activity.riding;

import android.support.v4.app.ActivityCompat;
import b.a.h;

final class k
{
  private static final int a = 14;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  
  static void a(UploadParkingImgActivity paramUploadParkingImgActivity)
  {
    if (h.a(paramUploadParkingImgActivity, b))
    {
      paramUploadParkingImgActivity.a();
      return;
    }
    ActivityCompat.requestPermissions(paramUploadParkingImgActivity, b, 14);
  }
  
  static void a(UploadParkingImgActivity paramUploadParkingImgActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramUploadParkingImgActivity) < 23) && (!h.a(paramUploadParkingImgActivity, b)))
    {
      paramUploadParkingImgActivity.b();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramUploadParkingImgActivity.a();
      return;
    }
    if (!h.a(paramUploadParkingImgActivity, b))
    {
      paramUploadParkingImgActivity.c();
      return;
    }
    paramUploadParkingImgActivity.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */