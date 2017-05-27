package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.adapter.j;
import com.mobike.mobikeapp.adapter.p;
import com.mobike.mobikeapp.model.data.b;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.RideManager.RideState;
import java.util.ArrayList;
import java.util.List;

public class UserManuelActivity
  extends BaseActivity
{
  private p a;
  
  private void a()
  {
    ListView localListView = (ListView)findViewById(2131755275);
    this.a = new p(this);
    this.a.a(b());
    localListView.setAdapter(this.a);
    localListView.setOnItemClickListener(y.a(this));
  }
  
  private List<b> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (RideManager.a().h() == RideManager.RideState.RIDING) {
      localArrayList.add(j.j(this));
    }
    if ((RideManager.a().h() != RideManager.RideState.RIDING) && (RideManager.a().h() != RideManager.RideState.LOCKED)) {
      localArrayList.add(j.k(this));
    }
    localArrayList.add(j.a(this, RideManager.a().n()));
    localArrayList.add(com.mobike.mobikeapp.adapter.q.e(this));
    localArrayList.add(com.mobike.mobikeapp.adapter.q.f(this));
    localArrayList.add(j.q(this));
    localArrayList.add(j.h(this));
    localArrayList.add(j.s(this));
    return localArrayList;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (com.mobike.mobikeapp.util.q.a().b()))
    {
      a();
      return;
    }
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a(b());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968660);
    if (com.mobike.mobikeapp.util.q.a().b())
    {
      a();
      return;
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default: 
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    }
    finish();
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/UserManuelActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */