package com.mobike.mobikeapp.activity.customer;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.adapter.i;
import com.mobike.mobikeapp.adapter.j;
import com.mobike.mobikeapp.model.data.b;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.RideManager.RideState;
import com.umeng.analytics.MobclickAgent;
import java.util.Arrays;
import java.util.List;

public class RidingCustomerServiceActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private ListView e;
  private i f;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131755369));
    this.b = ((TextView)findViewById(2131755301));
    this.a.setText(getString(2131296920, new Object[] { Long.valueOf((int)RideManager.a().l() / 60000L) }));
    this.b.setText(RideManager.a().n());
    b();
    MobclickAgent.c(this, "40004");
  }
  
  private void b()
  {
    if (RideManager.a().h() != RideManager.RideState.LOCKED) {}
    for (List localList = Arrays.asList(new b[] { j.j(this), j.a(this, RideManager.a().n()), j.b(this, RideManager.a().n()), j.l(this), j.c(this, RideManager.a().n()), j.r(this) });; localList = Arrays.asList(new b[] { j.a(this, RideManager.a().n()), j.l(this), j.c(this, RideManager.a().n()), j.r(this) }))
    {
      this.e = ((ListView)findViewById(2131755370));
      this.f = new i(this, localList);
      this.e.setAdapter(this.f);
      this.e.setOnItemClickListener(ao.a(this));
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968648);
    a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/RidingCustomerServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */