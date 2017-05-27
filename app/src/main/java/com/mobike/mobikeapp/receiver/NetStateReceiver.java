package com.mobike.mobikeapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.middleware.GeoRange;
import com.mobike.mobikeapp.util.e;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.p;
import org.greenrobot.eventbus.c;

public class NetStateReceiver
  extends BroadcastReceiver
{
  private boolean a = true;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = com.mobike.mobikeapp.model.c.h.h(paramContext);
    if ((paramContext != null) && (paramContext.isAvailable()) && (!this.a))
    {
      this.a = true;
      e.a().a(null);
      l.a().j();
      if (GeoRange.inCHINA()) {}
      switch (paramContext.getType())
      {
      default: 
        p.a().g();
        c.a().d(new com.mobike.mobikeapp.model.a.h(this.a));
      }
    }
    do
    {
      return;
      p.a().b();
      if ((TextUtils.isEmpty(l.a().e())) || (p.a().e())) {
        break;
      }
      p.a().d();
      break;
      p.a().g();
      break;
      this.a = false;
      c.a().d(new com.mobike.mobikeapp.model.a.h(this.a));
    } while (!GeoRange.inCHINA());
    p.a().g();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/receiver/NetStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */