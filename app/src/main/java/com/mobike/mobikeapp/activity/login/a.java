package com.mobike.mobikeapp.activity.login;

import android.support.v4.app.ActivityCompat;
import b.a.b;
import b.a.h;
import java.lang.ref.WeakReference;

final class a
{
  private static final int a = 11;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  private static b c;
  
  static void a(CampusVerifyActivity paramCampusVerifyActivity, int paramInt)
  {
    if (h.a(paramCampusVerifyActivity, b))
    {
      paramCampusVerifyActivity.a(paramInt);
      return;
    }
    c = new a(paramCampusVerifyActivity, paramInt, null);
    ActivityCompat.requestPermissions(paramCampusVerifyActivity, b, 11);
  }
  
  static void a(CampusVerifyActivity paramCampusVerifyActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramCampusVerifyActivity) < 23) && (!h.a(paramCampusVerifyActivity, b)))
    {
      paramCampusVerifyActivity.a();
      return;
    }
    if (h.a(paramArrayOfInt)) {
      if (c != null) {
        c.c();
      }
    }
    for (;;)
    {
      c = null;
      return;
      if (!h.a(paramCampusVerifyActivity, b)) {
        paramCampusVerifyActivity.b();
      } else {
        paramCampusVerifyActivity.a();
      }
    }
  }
  
  private static final class a
    implements b
  {
    private final WeakReference<CampusVerifyActivity> a;
    private final int b;
    
    private a(CampusVerifyActivity paramCampusVerifyActivity, int paramInt)
    {
      this.a = new WeakReference(paramCampusVerifyActivity);
      this.b = paramInt;
    }
    
    public void a()
    {
      CampusVerifyActivity localCampusVerifyActivity = (CampusVerifyActivity)this.a.get();
      if (localCampusVerifyActivity == null) {
        return;
      }
      ActivityCompat.requestPermissions(localCampusVerifyActivity, a.a(), 11);
    }
    
    public void b()
    {
      CampusVerifyActivity localCampusVerifyActivity = (CampusVerifyActivity)this.a.get();
      if (localCampusVerifyActivity == null) {
        return;
      }
      localCampusVerifyActivity.a();
    }
    
    public void c()
    {
      CampusVerifyActivity localCampusVerifyActivity = (CampusVerifyActivity)this.a.get();
      if (localCampusVerifyActivity == null) {
        return;
      }
      localCampusVerifyActivity.a(this.b);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */