package com.mobike.mobikeapp.activity.customer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.e;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.adapter.i;
import com.mobike.mobikeapp.adapter.j;
import com.mobike.mobikeapp.data.TripHistoryDataInfo;
import com.mobike.mobikeapp.data.TripHistoryDataInfo.TripHistoryData;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.model.data.b;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LastRideHistoryView;
import com.umeng.analytics.MobclickAgent;
import cz.msebera.android.httpclient.d;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class NormalCustomerServiceActivity
  extends BaseActivity
{
  private static final int a = 1;
  private i b;
  @BindView(a=2131755296)
  LastRideHistoryView mHistoryView;
  @BindView(a=2131755297)
  ListView mListView;
  
  private void a()
  {
    if (h.g(this))
    {
      f.b(System.currentTimeMillis(), 1, new a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          if (paramAnonymousInt == 500)
          {
            NormalCustomerServiceActivity.this.mHistoryView.b();
            return;
          }
          if (paramAnonymousInt == 200)
          {
            NormalCustomerServiceActivity.this.mHistoryView.setVisibility(8);
            return;
          }
          NormalCustomerServiceActivity.this.mHistoryView.setOnRetryListener(aa.a(this));
          NormalCustomerServiceActivity.this.mHistoryView.c();
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (TripHistoryDataInfo)new e().a(paramAnonymousJSONObject.toString(), TripHistoryDataInfo.class);
            if (paramAnonymousArrayOfd != null)
            {
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.tripHistoryItems;
              if ((paramAnonymousArrayOfd == null) || (paramAnonymousArrayOfd.isEmpty())) {
                break label67;
              }
              NormalCustomerServiceActivity.this.mHistoryView.a((TripHistoryDataInfo.TripHistoryData)paramAnonymousArrayOfd.get(0));
            }
          }
          return;
          label67:
          NormalCustomerServiceActivity.this.mHistoryView.setVisibility(8);
        }
      });
      return;
    }
    this.mHistoryView.a();
  }
  
  private void b()
  {
    this.b = new i(this, Arrays.asList(new b[] { j.i(this), j.a(this, RideManager.a().n()), j.k(this), j.m(this), j.n(this), j.o(this), j.p(this), j.r(this) }));
    this.mListView.setAdapter(this.b);
    this.mListView.setOnItemClickListener(z.a(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (q.a().b()) {
        a();
      }
    }
    else {
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968635);
    ButterKnife.a(this);
    this.mHistoryView.setRequestListener(y.a(this));
    b();
    if (q.a().b()) {
      a();
    }
    for (;;)
    {
      MobclickAgent.c(this, "40004");
      return;
      startActivityForResult(LoginActivity.a(), 1);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/NormalCustomerServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */