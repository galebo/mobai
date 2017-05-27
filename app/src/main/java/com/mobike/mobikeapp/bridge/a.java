package com.mobike.mobikeapp.bridge;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class a
  implements f
{
  private WeakReference<Activity> a;
  
  public a(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  public void a(String paramString, e parame)
  {
    if (this.a.get() != null) {
      ((Activity)this.a.get()).finish();
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/bridge/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */