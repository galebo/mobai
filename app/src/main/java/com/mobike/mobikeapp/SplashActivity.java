package com.mobike.mobikeapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.support.annotation.ab;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.view.View;
import b.a.c;
import b.a.d;
import b.a.j;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.middleware.GeoCountry;
import com.baidu.middleware.GeoRange;
import com.mobike.mobikeapp.model.c.f;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;

@j
public class SplashActivity
  extends Activity
  implements BDLocationListener
{
  private boolean a = false;
  private boolean b;
  private View c;
  private Handler d = new Handler(Looper.getMainLooper());
  private b e;
  private b f;
  private String[] g = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  
  private void a(int paramInt)
  {
    if ((this.f == null) || (!this.f.isShowing())) {
      a(paramInt, new a()
      {
        public void a()
        {
          SplashActivity.this.startActivity(SplashActivity.d(SplashActivity.this));
          SplashActivity.a(SplashActivity.this, true);
        }
        
        public void b()
        {
          SplashActivity.this.finish();
        }
      });
    }
  }
  
  private void a(int paramInt, @ab a parama)
  {
    l.a().b(this);
    l.a().k();
    this.f = new b.a(this, 2131427642).b(paramInt).a(17039370, cd.a(parama)).b(17039360, ce.a(parama)).b();
    this.f.setCanceledOnTouchOutside(false);
    this.f.setCancelable(false);
    this.f.show();
    this.a = false;
  }
  
  @TargetApi(23)
  private void f()
  {
    if (!Settings.System.canWrite(this))
    {
      Intent localIntent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
      localIntent.setData(Uri.parse("package:" + getPackageName()));
      localIntent.addFlags(268435456);
      startActivity(localIntent);
    }
  }
  
  private void g()
  {
    if (com.mobike.mobikeapp.util.a.j())
    {
      i();
      if ((q.a().b()) && (this.d != null)) {
        this.d.post(ca.a());
      }
    }
    startActivity(new Intent(this, MainActivity.class));
    overridePendingTransition(0, 2131034180);
    finish();
  }
  
  private void h()
  {
    this.c = findViewById(2131755901);
  }
  
  private void i()
  {
    f.a().b(MyApplication.b);
  }
  
  private void j()
  {
    if ((this.f != null) && (this.f.isShowing())) {}
    do
    {
      return;
      this.e = new b.a(this, 2131427642).a(getString(2131296598)).b(getString(2131296597)).b(17039360, cb.a(this)).a(17039370, cc.a(this)).b();
      this.e.setCanceledOnTouchOutside(false);
    } while ((this.e.isShowing()) || (isFinishing()));
    this.e.show();
  }
  
  private Intent k()
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", getPackageName(), null));
    return localIntent;
  }
  
  @b.a.e(a={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  void a()
  {
    a(2131296600);
  }
  
  @d(a={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  void b()
  {
    a(2131296600);
  }
  
  @c(a={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public void c()
  {
    if (h.g(this))
    {
      l.a().a(this, this);
      if (h.k(this)) {
        h.a(this, getString(2131296501));
      }
      return;
    }
    a(2131296740, new a()
    {
      public void a()
      {
        SplashActivity.a(SplashActivity.this, true);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.setAction("android.settings.SETTINGS");
        SplashActivity.this.startActivity(localIntent);
      }
      
      public void b()
      {
        SplashActivity.this.finish();
      }
    });
  }
  
  public void d()
  {
    com.mobike.mobikeapp.util.e.a().a(new b()
    {
      public void a()
      {
        com.mobike.mobikeapp.util.e.a().a(true);
        SplashActivity.a(SplashActivity.this);
      }
      
      public void b()
      {
        com.mobike.mobikeapp.util.e.a().a(false);
        SplashActivity.a(SplashActivity.this);
      }
      
      public void c()
      {
        if ((!SplashActivity.this.isFinishing()) && (SplashActivity.b(SplashActivity.this) != null) && (SplashActivity.c(SplashActivity.this) != null)) {
          SplashActivity.c(SplashActivity.this).post(cf.a(this));
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968652);
    h();
    cg.a(this);
  }
  
  protected void onDestroy()
  {
    l.a().b(this);
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    if (this.d != null)
    {
      this.d.removeCallbacksAndMessages(null);
      this.d = null;
    }
    super.onDestroy();
  }
  
  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    if (paramBDLocation != null)
    {
      if (paramBDLocation.getLocType() != 167) {
        break label52;
      }
      if (com.mobike.mobikeapp.imagepicker.b.a.a(this, this.g)) {
        break label30;
      }
      a();
    }
    label30:
    while ((this.e != null) && (this.e.isShowing())) {
      return;
    }
    j();
    return;
    label52:
    if (paramBDLocation.getCountryCode().equals("0")) {
      GeoRange.setCountry(GeoCountry.CHINA);
    }
    for (;;)
    {
      l.a().a(paramBDLocation);
      if ((this.a) || (!h.l(this))) {
        break;
      }
      this.a = true;
      d();
      if (!h.e(this)) {
        l.a().k();
      }
      com.mobike.mobikeapp.util.a.m();
      return;
      GeoRange.setCountry(GeoCountry.ABOARD);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    cg.a(this, paramInt, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.b) {
      if (this.b) {
        break label30;
      }
    }
    label30:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      cg.a(this);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */