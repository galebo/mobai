package com.mobike.mobikeapp.util;

import com.loopj.android.http.c;
import com.mobike.mobikeapp.a.f;

public class v
  implements Runnable
{
  c a;
  
  public v(c paramc)
  {
    this.a = paramc;
  }
  
  public void run()
  {
    f.b(this.a);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */