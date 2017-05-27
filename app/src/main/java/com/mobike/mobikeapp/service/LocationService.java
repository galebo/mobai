package com.mobike.mobikeapp.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.ac;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.middleware.map.LatLng;
import com.baidu.middleware.util.DistanceUtil;
import com.google.gson.e;
import com.loopj.android.http.c;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.MainActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.RideStateDataInfo;
import com.mobike.mobikeapp.data.RideStateDataInfo.RideStateInfo;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.util.v;
import com.umeng.analytics.MobclickAgent;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocationService
  extends Service
  implements BDLocationListener
{
  public static final int a = 1001;
  private static final String e = "LocationService";
  ScheduledExecutorService b;
  v c;
  Thread d;
  private boolean f = false;
  private double g = 0.0D;
  private a h = null;
  private List<a> i = null;
  private boolean j;
  private String k = null;
  private boolean l;
  private c m;
  
  private void a()
  {
    if (this.d != null) {
      this.d.interrupt();
    }
    if (this.b != null) {
      this.b.shutdownNow();
    }
  }
  
  private void a(final SharedPreferences paramSharedPreferences, String paramString)
  {
    String str;
    float f1;
    if (h.g(this))
    {
      MobclickAgent.c(this, "MBKAPP20000");
      str = paramSharedPreferences.getString("track_string", "");
      f1 = paramSharedPreferences.getFloat("track_distance", 0.0F);
      if (TextUtils.isEmpty(str))
      {
        MobclickAgent.c(this, "MBKAPP20004");
        d();
      }
    }
    else
    {
      return;
    }
    f.a(paramString, f1, str, new n()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousString, paramAnonymousThrowable);
        MobclickAgent.c(LocationService.this, "MBKAPP20002");
        LocationService.b(LocationService.this);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONArray paramAnonymousJSONArray)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousThrowable, paramAnonymousJSONArray);
        MobclickAgent.c(LocationService.this, "MBKAPP20002");
        LocationService.b(LocationService.this);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousThrowable, paramAnonymousJSONObject);
        MobclickAgent.c(LocationService.this, "MBKAPP20002");
        LocationService.b(LocationService.this);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = paramSharedPreferences.edit();
        paramAnonymousArrayOfd.putString("track_string", "");
        paramAnonymousArrayOfd.putFloat("track_distance", 0.0F);
        paramAnonymousArrayOfd.apply();
        MobclickAgent.c(LocationService.this, "MBKAPP20001");
        LocationService.b(LocationService.this);
      }
    });
  }
  
  private void a(String paramString)
  {
    c();
    b(paramString);
    this.f = false;
    stopForeground(true);
  }
  
  private void b()
  {
    this.i = new ArrayList();
    this.g = 0.0D;
    l.a().a(this);
    l.a().a(this);
    l.a().a(5000L);
    l.a().j();
  }
  
  private void b(String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("ride_prefs", 0);
    if (q.a().b())
    {
      paramString = RideManager.a().b(this);
      if (!TextUtils.isEmpty(paramString))
      {
        a(localSharedPreferences, paramString);
        return;
      }
      MobclickAgent.c(this, "MBKAPP20003");
      d();
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      RideManager.a().a(this, paramString);
      a(localSharedPreferences, paramString);
      return;
    }
    d();
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("ride_prefs", 0).edit();
    localEditor.putBoolean("isRecordingTrack", false);
    localEditor.putFloat("track_distance", (float)this.g);
    if ((this.i != null) && (!this.i.isEmpty()))
    {
      String str2 = "#" + TextUtils.join("#", this.i);
      String str1 = str2;
      if (!TextUtils.isEmpty(this.k)) {
        str1 = this.k + str2;
      }
      localEditor.putString("track_string", str1);
    }
    localEditor.apply();
  }
  
  private void d()
  {
    this.j = true;
    stopSelf();
  }
  
  @ac
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    if (this.j)
    {
      l.a().b(this);
      l.a().k();
      this.f = false;
    }
    for (;;)
    {
      super.onDestroy();
      return;
      MobclickAgent.c(this, "MBKAPP20006");
      c();
      l.a().b(this);
      sendBroadcast(new Intent("com.mobike.app.stoplocation.service.restart"));
    }
  }
  
  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    if (this.h == null)
    {
      String str = getSharedPreferences("ride_prefs", 0).getString("track_string", "");
      if ((this.k == null) && (!TextUtils.isEmpty(str)))
      {
        this.k = str;
        MobclickAgent.c(this, "MBKAPP20007");
      }
      this.h = new a(paramBDLocation);
      this.i.add(this.h);
      return;
    }
    paramBDLocation = new a(paramBDLocation);
    double d1 = DistanceUtil.getDistance(this.h.a(), paramBDLocation.a());
    if ((0.0D < d1) && (d1 < 500.0D))
    {
      this.g = (d1 + this.g);
      RideManager.a().a((float)this.g);
      this.i.add(paramBDLocation);
    }
    for (;;)
    {
      this.h = paramBDLocation;
      return;
      if (d1 == 0.0D) {
        a.a((a)this.i.get(this.i.size() - 1), System.currentTimeMillis());
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramIntent.getAction())) && (paramIntent.getAction().equals("com.mobike.app.stoplocation.service")))
    {
      a();
      a(paramIntent.getStringExtra("orderId"));
    }
    for (;;)
    {
      return 2;
      if (!this.f)
      {
        this.f = true;
        b();
        paramIntent = new Intent(this, MainActivity.class);
        paramIntent.setFlags(335544320);
        paramIntent = PendingIntent.getActivity(this, 0, paramIntent, 134217728);
        android.support.v7.app.NotificationCompat.Builder localBuilder = new android.support.v7.app.NotificationCompat.Builder(this);
        localBuilder.setSmallIcon(2130838072).setContentTitle(getText(2131296946)).setContentText(getText(2131296945)).setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130838071)).setContentIntent(paramIntent);
        startForeground(1001, localBuilder.build());
        if (this.b == null)
        {
          this.m = new n()
          {
            public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject) {}
            
            public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
            {
              paramAnonymousArrayOfd = (RideStateDataInfo)new e().a(paramAnonymousJSONObject.toString(), RideStateDataInfo.class);
              if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.result == 0))
              {
                paramAnonymousArrayOfd = paramAnonymousArrayOfd.ridestateInfo;
                if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.ride != 1))
                {
                  LocationService.a(LocationService.this);
                  LocationService.a(LocationService.this, "");
                }
              }
            }
          };
          this.c = new v(this.m);
          this.d = new Thread(this.c);
          this.b = Executors.newScheduledThreadPool(1);
          this.b.scheduleWithFixedDelay(this.d, 10L, 10L, TimeUnit.MINUTES);
        }
      }
    }
  }
  
  private class a
  {
    private LatLng b;
    private long c;
    
    a(BDLocation paramBDLocation)
    {
      this.b = new LatLng(paramBDLocation.getLatitude(), paramBDLocation.getLongitude());
      this.c = System.currentTimeMillis();
    }
    
    public LatLng a()
    {
      return this.b;
    }
    
    public String toString()
    {
      return this.b.longitude + "," + this.b.latitude + ";" + this.c;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/service/LocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */