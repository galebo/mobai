package com.mobike.mobikeapp.activity.customer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.adapter.i;
import com.mobike.mobikeapp.adapter.j;
import com.mobike.mobikeapp.data.TripHistoryDataInfo.TripHistoryData;
import com.mobike.mobikeapp.model.c.h;
import java.util.Arrays;

public class NormalLastRideDescActivity
  extends BaseActivity
{
  private i a;
  private TripHistoryDataInfo.TripHistoryData b;
  
  private void a()
  {
    this.b = ((TripHistoryDataInfo.TripHistoryData)getIntent().getSerializableExtra(com.mobike.mobikeapp.model.c.b.aQ));
    b();
    ((TextView)findViewById(2131755301)).setText(this.b.bikeId);
    TextView localTextView1 = (TextView)findViewById(2131755303);
    TextView localTextView2 = (TextView)findViewById(2131755305);
    localTextView1.setText(h.c(this.b.rideDate));
    localTextView2.setText(h.c(this.b.rideDate + Integer.valueOf(this.b.rideTimeInMin).intValue() * 60000L));
  }
  
  private void b()
  {
    ListView localListView = (ListView)findViewById(2131755306);
    this.a = new i(this, Arrays.asList(new com.mobike.mobikeapp.model.data.b[] { j.a(this, this.b.bikeId), j.c(this, this.b.bikeId) }));
    localListView.setAdapter(this.a);
    localListView.setOnItemClickListener(ab.a(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968636);
    a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/NormalLastRideDescActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */