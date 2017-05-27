package com.mobike.mobikeapp.activity.riding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.activity.customer.LastTenTripHistoryActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.adapter.UserTripAdapter;
import com.mobike.mobikeapp.data.TripHistoryDataInfo;
import com.mobike.mobikeapp.data.TripHistoryDataInfo.TripHistoryData;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.EmptyView;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MyTripsActivity
  extends BaseActivity
{
  private static final int a = 1;
  private UserTripAdapter b;
  private long e = 0L;
  private List<TripHistoryDataInfo.TripHistoryData> f = new ArrayList();
  @BindView(a=2131755751)
  LoadingPageView mLoadingPageView;
  @BindView(a=2131755294)
  ListView mMyTripsListView;
  @BindView(a=2131755293)
  SwipyRefreshLayout mMyTripsSwipyLayout;
  @BindView(a=2131755782)
  View mNetworkStateView;
  
  private void a()
  {
    if (h.g(this))
    {
      this.mNetworkStateView.setVisibility(8);
      this.mLoadingPageView.a();
      this.mMyTripsSwipyLayout.setRefreshing(true);
      this.e = 0L;
      f.b(this.e, 10, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          MyTripsActivity.this.mLoadingPageView.b();
          MyTripsActivity.this.mMyTripsSwipyLayout.setRefreshing(false);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          MyTripsActivity.this.mLoadingPageView.b();
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (TripHistoryDataInfo)new e().a(paramAnonymousJSONObject.toString(), TripHistoryDataInfo.class);
            if (paramAnonymousArrayOfd != null)
            {
              MyTripsActivity.a(MyTripsActivity.this, paramAnonymousArrayOfd.pageTimeStamp);
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.tripHistoryItems;
              if ((MyTripsActivity.a(MyTripsActivity.this) != null) && (paramAnonymousArrayOfd != null) && (!paramAnonymousArrayOfd.isEmpty()))
              {
                MyTripsActivity.a(MyTripsActivity.this).clear();
                MyTripsActivity.a(MyTripsActivity.this).addAll(paramAnonymousArrayOfd);
                MyTripsActivity.b(MyTripsActivity.this).notifyDataSetChanged();
              }
            }
          }
          if (MyTripsActivity.this.mMyTripsSwipyLayout != null) {
            MyTripsActivity.this.mMyTripsSwipyLayout.setRefreshing(false);
          }
        }
      });
    }
  }
  
  private void b()
  {
    Object localObject = (EmptyView)findViewById(2131755611);
    ((EmptyView)localObject).setEmptyText(2131296549);
    ((EmptyView)localObject).setEmptySubText(2131296550);
    this.mMyTripsListView.setEmptyView((View)localObject);
    this.mNetworkStateView.setOnClickListener(a.a(this));
    int i = ContextCompat.getColor(this, 2131624078);
    this.mMyTripsSwipyLayout.setColorSchemeColors(new int[] { i, i });
    this.mMyTripsSwipyLayout.setOnRefreshListener(b.a(this));
    localObject = this.mMyTripsListView;
    UserTripAdapter localUserTripAdapter = new UserTripAdapter(this, this.f);
    this.b = localUserTripAdapter;
    ((ListView)localObject).setAdapter(localUserTripAdapter);
  }
  
  private void c()
  {
    if ((this.e > 0L) && (h.l(this)))
    {
      f.b(this.e, 10, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          MyTripsActivity.this.mMyTripsSwipyLayout.setRefreshing(false);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (TripHistoryDataInfo)new e().a(paramAnonymousJSONObject.toString(), TripHistoryDataInfo.class);
            if (paramAnonymousArrayOfd != null)
            {
              MyTripsActivity.a(MyTripsActivity.this, paramAnonymousArrayOfd.pageTimeStamp);
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.tripHistoryItems;
              if ((paramAnonymousArrayOfd != null) && (!paramAnonymousArrayOfd.isEmpty()))
              {
                MyTripsActivity.a(MyTripsActivity.this).addAll(paramAnonymousArrayOfd);
                MyTripsActivity.b(MyTripsActivity.this).notifyDataSetChanged();
              }
            }
          }
          MyTripsActivity.this.mMyTripsSwipyLayout.setRefreshing(false);
        }
      });
      return;
    }
    this.mMyTripsSwipyLayout.setRefreshing(false);
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
    setContentView(2130968634);
    ButterKnife.a(this);
    b();
    if (q.a().b())
    {
      a();
      return;
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820550, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  @OnItemClick(a={2131755294})
  void onItemClickTrip(AdapterView<?> paramAdapterView, int paramInt)
  {
    paramAdapterView = (TripHistoryDataInfo.TripHistoryData)paramAdapterView.getAdapter().getItem(paramInt);
    String str = paramAdapterView.orderId;
    if (!TextUtils.isEmpty(str))
    {
      if (h.l(this)) {
        startActivity(TripDetailActivity.a(str, paramAdapterView.country));
      }
      return;
    }
    h.a(this, getString(2131297030));
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
      finish();
      VdsAgent.handleClickResult(new Boolean(true));
      return true;
      startActivity(new Intent(this, LastTenTripHistoryActivity.class));
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/MyTripsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */