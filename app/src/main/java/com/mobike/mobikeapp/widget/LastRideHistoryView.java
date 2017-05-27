package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobike.mobikeapp.data.TripHistoryDataInfo.TripHistoryData;
import com.mobike.mobikeapp.model.c.h;

public class LastRideHistoryView
  extends LinearLayout
{
  private View a;
  private RelativeLayout b;
  private RelativeLayout c;
  private LinearLayout d;
  private Button e;
  private Button f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private LoadingPageView m;
  private TripHistoryDataInfo.TripHistoryData n;
  
  public LastRideHistoryView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LastRideHistoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LastRideHistoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    this.a = LayoutInflater.from(getContext()).inflate(2130968771, null);
    this.b = ((RelativeLayout)this.a.findViewById(2131755964));
    this.e = ((Button)this.a.findViewById(2131755965));
    this.f = ((Button)this.a.findViewById(2131755966));
    this.c = ((RelativeLayout)findViewById(2131755741));
    this.k = ((TextView)findViewById(2131755742));
    this.l = ((TextView)findViewById(2131755743));
    this.j = ((TextView)this.a.findViewById(2131755740));
    this.j.setOnClickListener(f.a(this));
    this.d = ((LinearLayout)this.a.findViewById(2131755299));
    this.g = ((TextView)this.a.findViewById(2131755301));
    this.i = ((TextView)this.a.findViewById(2131755305));
    this.h = ((TextView)this.a.findViewById(2131755303));
    this.m = ((LoadingPageView)this.a.findViewById(2131755751));
    this.b.setVisibility(8);
    this.m.a();
    addView(this.a);
  }
  
  public void a()
  {
    if (this.d.getVisibility() == 0) {
      this.d.setVisibility(8);
    }
    this.m.b();
    this.d.setVisibility(8);
    this.b.setVisibility(0);
    this.f.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  public void a(TripHistoryDataInfo.TripHistoryData paramTripHistoryData)
  {
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    if (this.d.getVisibility() == 0) {
      this.d.setVisibility(8);
    }
    this.n = paramTripHistoryData;
    this.m.b();
    this.d.setVisibility(0);
    this.g.setText(paramTripHistoryData.bikeId);
    this.h.setText(h.c(paramTripHistoryData.rideDate));
    this.i.setText(h.c(paramTripHistoryData.rideDate + Integer.valueOf(paramTripHistoryData.rideTimeInMin).intValue() * 60000L));
  }
  
  public void b()
  {
    if (this.d.getVisibility() == 0) {
      this.d.setVisibility(8);
    }
    this.m.b();
    this.d.setVisibility(8);
    this.b.setVisibility(0);
    this.f.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  public void c()
  {
    this.m.b();
    this.l.setVisibility(0);
    if (this.k == null) {
      this.k = ((TextView)findViewById(2131755742));
    }
    this.k.setVisibility(0);
    if (this.c == null) {
      this.c = ((RelativeLayout)findViewById(2131755741));
    }
    this.c.setVisibility(0);
  }
  
  public void setOnRetryListener(View.OnClickListener paramOnClickListener)
  {
    if (this.l == null) {
      this.l = ((TextView)findViewById(2131755743));
    }
    this.l.setOnClickListener(g.a(this, paramOnClickListener));
  }
  
  public void setRequestListener(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/LastRideHistoryView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */