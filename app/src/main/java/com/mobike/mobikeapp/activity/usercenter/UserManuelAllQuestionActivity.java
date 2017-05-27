package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.adapter.j;
import com.mobike.mobikeapp.adapter.p;
import com.mobike.mobikeapp.model.data.b;
import com.mobike.mobikeapp.util.q;
import java.util.Arrays;
import java.util.List;

public class UserManuelAllQuestionActivity
  extends BaseActivity
{
  private p a;
  private TextView b;
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131755274));
    this.b.setOnLongClickListener(z.a());
    ListView localListView = (ListView)findViewById(2131755275);
    this.a = new p(this);
    this.a.a(b());
    localListView.setAdapter(this.a);
    localListView.setOnItemClickListener(aa.a(this));
  }
  
  private List<b> b()
  {
    return Arrays.asList(new b[] { j.a(this), j.b(this), j.c(this), j.d(this), j.e(this), j.f(this), j.g(this) });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (q.a().b()))
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
    setContentView(2130968628);
    if (q.a().b())
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


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/UserManuelAllQuestionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */