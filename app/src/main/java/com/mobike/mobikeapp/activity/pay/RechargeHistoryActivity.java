package com.mobike.mobikeapp.activity.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.data.RechargeHistoryDataInfo;
import com.mobike.mobikeapp.data.RechargeHistoryDataInfo.RechargeHistoryItem;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.m;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.EmptyView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class RechargeHistoryActivity
  extends BaseActivity
{
  private static final int a = 1;
  private long b;
  private a e;
  private SwipyRefreshLayout f;
  
  private void a()
  {
    this.f = ((SwipyRefreshLayout)findViewById(2131755318));
    int i = ContextCompat.getColor(this, 2131624078);
    this.f.setColorSchemeColors(new int[] { i, i });
    this.f.setOnRefreshListener(r.a(this));
    ListView localListView = (ListView)findViewById(2131755319);
    this.e = new a(this);
    localListView.setAdapter(this.e);
    EmptyView localEmptyView = (EmptyView)findViewById(2131755611);
    if (h.g(this))
    {
      localEmptyView.setEmptyImg(2130838080);
      localEmptyView.setEmptyText(2131296548);
      localListView.setEmptyView(localEmptyView);
      this.b = 0L;
      b();
      return;
    }
    localEmptyView.setEmptyImg(2130837992);
    localEmptyView.setEmptyText(2131296740);
    localListView.setEmptyView(localEmptyView);
  }
  
  private void b()
  {
    if (this.b >= 0L)
    {
      if (h.l(this)) {
        f.a(this.b, 10, new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            RechargeHistoryActivity.a(RechargeHistoryActivity.this).setRefreshing(false);
          }
          
          public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
          {
            RechargeHistoryActivity.a(RechargeHistoryActivity.this).setRefreshing(false);
            if (paramAnonymousJSONObject != null)
            {
              m.d(paramAnonymousJSONObject.toString());
              paramAnonymousArrayOfd = (RechargeHistoryDataInfo)new e().a(paramAnonymousJSONObject.toString(), RechargeHistoryDataInfo.class);
              if (paramAnonymousArrayOfd.result == 0)
              {
                if (RechargeHistoryActivity.b(RechargeHistoryActivity.this) == 0L) {
                  RechargeHistoryActivity.c(RechargeHistoryActivity.this).a();
                }
                RechargeHistoryActivity.a(RechargeHistoryActivity.this, paramAnonymousArrayOfd.pageTimeStamp);
                RechargeHistoryActivity.c(RechargeHistoryActivity.this).a(paramAnonymousArrayOfd.rechargeHistoryItems);
              }
              if ((paramAnonymousArrayOfd.rechargeHistoryItems != null) && (paramAnonymousArrayOfd.rechargeHistoryItems.size() < 10)) {
                RechargeHistoryActivity.a(RechargeHistoryActivity.this, -1L);
              }
            }
          }
        });
      }
      return;
    }
    h.a(this, getString(2131296833));
    this.f.setRefreshing(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (q.a().b())
      {
        this.b = 0L;
        b();
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
    setContentView(2130968638);
    a();
    if (!q.a().b()) {
      startActivityForResult(LoginActivity.a(), 1);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820551, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
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
      continue;
      startActivity(CustomerServiceWebActivity.a(this, getString(2131296875), com.mobike.mobikeapp.c.a.v()));
    }
  }
  
  private static class a
    extends BaseAdapter
  {
    private List<RechargeHistoryDataInfo.RechargeHistoryItem> a = new ArrayList();
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public void a()
    {
      if ((this.a != null) && (!this.a.isEmpty())) {
        this.a.clear();
      }
      notifyDataSetChanged();
    }
    
    public void a(List<RechargeHistoryDataInfo.RechargeHistoryItem> paramList)
    {
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if ((this.a != null) && (!this.a.isEmpty())) {
        return this.a.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.b).inflate(2130968821, paramViewGroup, false);
        paramView = new a(null);
        paramView.a = ((TextView)localView.findViewById(2131755871));
        paramView.b = ((TextView)localView.findViewById(2131755872));
        paramView.c = ((TextView)localView.findViewById(2131755874));
        paramView.d = ((TextView)localView.findViewById(2131755873));
        localView.setTag(paramView);
      }
      paramView = (a)localView.getTag();
      paramViewGroup = (RechargeHistoryDataInfo.RechargeHistoryItem)getItem(paramInt);
      paramView.d.setText(o.a(paramViewGroup.cash));
      String str = h.c(paramViewGroup.timestamp);
      paramView.b.setText(str);
      paramView.c.setText(paramViewGroup.payApproach);
      paramView.a.setText(paramViewGroup.getStatusCodeText(localView.getContext()));
      return localView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      
      private a() {}
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/RechargeHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */