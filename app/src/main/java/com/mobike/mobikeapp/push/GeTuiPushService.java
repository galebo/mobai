package com.mobike.mobikeapp.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.sdk.GTServiceManager;

public class GeTuiPushService
  extends Service
{
  public static final String a = GeTuiPushService.class.getName();
  
  public IBinder onBind(Intent paramIntent)
  {
    return GTServiceManager.getInstance().onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    GTServiceManager.getInstance().onCreate(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GTServiceManager.getInstance().onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    GTServiceManager.getInstance().onLowMemory();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return GTServiceManager.getInstance().onStartCommand(this, paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/push/GeTuiPushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */