package com.mobike.mobikeapp.activity.login;

import android.support.v4.app.ActivityCompat;
import b.a.b;
import b.a.h;
import java.lang.ref.WeakReference;

final class q
{
  private static final int a = 12;
  private static final String[] b = { "android.permission.READ_EXTERNAL_STORAGE" };
  private static b c;
  
  static void a(SubmitIDInfoActivity paramSubmitIDInfoActivity, int paramInt)
  {
    if (h.a(paramSubmitIDInfoActivity, b))
    {
      paramSubmitIDInfoActivity.a(paramInt);
      return;
    }
    c = new a(paramSubmitIDInfoActivity, paramInt, null);
    ActivityCompat.requestPermissions(paramSubmitIDInfoActivity, b, 12);
  }
  
  static void a(SubmitIDInfoActivity paramSubmitIDInfoActivity, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((h.a(paramSubmitIDInfoActivity) < 23) && (!h.a(paramSubmitIDInfoActivity, b)))
    {
      paramSubmitIDInfoActivity.a();
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
      if (!h.a(paramSubmitIDInfoActivity, b)) {
        paramSubmitIDInfoActivity.b();
      } else {
        paramSubmitIDInfoActivity.a();
      }
    }
  }
  
  private static final class a
    implements b
  {
    private final WeakReference<SubmitIDInfoActivity> a;
    private final int b;
    
    private a(SubmitIDInfoActivity paramSubmitIDInfoActivity, int paramInt)
    {
      this.a = new WeakReference(paramSubmitIDInfoActivity);
      this.b = paramInt;
    }
    
    public void a()
    {
      SubmitIDInfoActivity localSubmitIDInfoActivity = (SubmitIDInfoActivity)this.a.get();
      if (localSubmitIDInfoActivity == null) {
        return;
      }
      ActivityCompat.requestPermissions(localSubmitIDInfoActivity, q.a(), 12);
    }
    
    public void b()
    {
      SubmitIDInfoActivity localSubmitIDInfoActivity = (SubmitIDInfoActivity)this.a.get();
      if (localSubmitIDInfoActivity == null) {
        return;
      }
      localSubmitIDInfoActivity.a();
    }
    
    public void c()
    {
      SubmitIDInfoActivity localSubmitIDInfoActivity = (SubmitIDInfoActivity)this.a.get();
      if (localSubmitIDInfoActivity == null) {
        return;
      }
      localSubmitIDInfoActivity.a(this.b);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */