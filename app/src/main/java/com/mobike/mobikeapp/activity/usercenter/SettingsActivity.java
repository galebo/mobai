package com.mobike.mobikeapp.activity.usercenter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.b.a;
import android.widget.Button;
import android.widget.ListView;
import com.loopj.android.http.c;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.model.data.b;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.RideManager.RideState;
import cz.msebera.android.httpclient.d;
import java.util.Arrays;
import java.util.List;

public class SettingsActivity
  extends BaseActivity
{
  private com.mobike.mobikeapp.adapter.p a;
  private Button b;
  
  private void a()
  {
    if (RideManager.a().h() == RideManager.RideState.NOT_RIDE)
    {
      new b.a(this, 2131427642).a(2131296680).b(2131296479).a(17039370, p.a(this)).b(17039360, q.a()).c();
      return;
    }
    h.a(this, getString(2131296681));
  }
  
  private void b()
  {
    if ((com.mobike.mobikeapp.util.q.a().b()) && (!RideManager.a().u()) && (!RideManager.a().v()))
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  private List<b> c()
  {
    return Arrays.asList(new b[] { com.mobike.mobikeapp.adapter.q.a(this), com.mobike.mobikeapp.adapter.q.b(this), com.mobike.mobikeapp.adapter.q.c(this), com.mobike.mobikeapp.adapter.q.d(this), com.mobike.mobikeapp.adapter.q.e(this), com.mobike.mobikeapp.adapter.q.f(this) });
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a(c());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968651);
    paramBundle = (ListView)findViewById(2131755374);
    this.a = new com.mobike.mobikeapp.adapter.p(this);
    this.a.a(c());
    paramBundle.setAdapter(this.a);
    paramBundle.setOnItemClickListener(n.a(this));
    this.b = ((Button)findViewById(2131755375));
    this.b.setOnClickListener(o.a(this));
    b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */