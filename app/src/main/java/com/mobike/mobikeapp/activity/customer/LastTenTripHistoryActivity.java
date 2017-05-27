package com.mobike.mobikeapp.activity.customer;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.e;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.TripHistoryDataInfo;
import com.mobike.mobikeapp.data.TripHistoryDataInfo.TripHistoryData;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.widget.EmptyView;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.umeng.analytics.MobclickAgent;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class LastTenTripHistoryActivity
  extends BaseActivity
{
  private a a;
  private LoadingPageView b;
  private TextView e;
  
  private void a()
  {
    MobclickAgent.c(this, "40015");
    this.b = ((LoadingPageView)findViewById(2131755751));
    this.e = ((TextView)findViewById(2131755247));
    this.b.a();
    b();
    c();
  }
  
  private void b()
  {
    this.a = new a(null);
    ListView localListView = (ListView)findViewById(2131755248);
    localListView.setAdapter(this.a);
    localListView.setOnItemClickListener(i.a(this));
    EmptyView localEmptyView = (EmptyView)findViewById(2131755611);
    localEmptyView.setEmptyText(2131296549);
    localEmptyView.setEmptySubText(2131296550);
    localListView.setEmptyView(localEmptyView);
  }
  
  private void c()
  {
    if (h.g(this))
    {
      f.b(System.currentTimeMillis(), 10, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          LastTenTripHistoryActivity.a(LastTenTripHistoryActivity.this).b();
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          LastTenTripHistoryActivity.a(LastTenTripHistoryActivity.this).b();
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (TripHistoryDataInfo)new e().a(paramAnonymousJSONObject.toString(), TripHistoryDataInfo.class);
            if (paramAnonymousArrayOfd != null)
            {
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.tripHistoryItems;
              if ((paramAnonymousArrayOfd != null) && (!paramAnonymousArrayOfd.isEmpty()))
              {
                LastTenTripHistoryActivity.b(LastTenTripHistoryActivity.this).setVisibility(0);
                LastTenTripHistoryActivity.c(LastTenTripHistoryActivity.this).a(paramAnonymousArrayOfd);
              }
            }
          }
        }
      });
      return;
    }
    this.b.b();
    h.a(this, getString(2131296740));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968623);
    a();
  }
  
  private class a
    extends BaseAdapter
  {
    private List<TripHistoryDataInfo.TripHistoryData> b = new ArrayList();
    
    private a() {}
    
    private void a(String paramString, TextView paramTextView)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      int i = paramString.indexOf(":");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(LastTenTripHistoryActivity.this, 2131624119)), 0, i + 1, 34);
      paramTextView.setText(localSpannableStringBuilder);
      localSpannableStringBuilder.clear();
    }
    
    public TripHistoryDataInfo.TripHistoryData a(int paramInt)
    {
      return (TripHistoryDataInfo.TripHistoryData)this.b.get(paramInt);
    }
    
    public void a(List<TripHistoryDataInfo.TripHistoryData> paramList)
    {
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = LayoutInflater.from(LastTenTripHistoryActivity.this).inflate(2130968759, null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131755301));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131755708));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131755709));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131755303));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        TripHistoryDataInfo.TripHistoryData localTripHistoryData = a(paramInt);
        paramViewGroup.a.setText(localTripHistoryData.bikeId);
        paramViewGroup.d.setText(h.c(localTripHistoryData.rideDate));
        long l = h.c(localTripHistoryData.rideTimeInMin);
        a(LastTenTripHistoryActivity.this.getString(2131296941) + com.mobike.mobikeapp.util.a.a(LastTenTripHistoryActivity.this, l), paramViewGroup.b);
        a(LastTenTripHistoryActivity.this.getString(2131296930) + o.a(localTripHistoryData.rideCost), paramViewGroup.c);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      
      a() {}
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/LastTenTripHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */