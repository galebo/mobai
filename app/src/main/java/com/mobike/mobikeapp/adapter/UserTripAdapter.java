package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.support.annotation.ab;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mobike.mobikeapp.data.TripHistoryDataInfo.TripHistoryData;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.a;
import com.mobike.mobikeapp.util.o;
import java.util.List;

public class UserTripAdapter
  extends BaseAdapter
{
  private Context a;
  private List<TripHistoryDataInfo.TripHistoryData> b;
  
  public UserTripAdapter(Context paramContext, @ab List<TripHistoryDataInfo.TripHistoryData> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
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
      localView = LayoutInflater.from(this.a).inflate(2130968785, paramViewGroup, false);
      localView.setTag(new ViewHolder(localView));
    }
    paramView = (ViewHolder)localView.getTag();
    paramViewGroup = (TripHistoryDataInfo.TripHistoryData)getItem(paramInt);
    paramView.rideDateView.setText(h.c(paramViewGroup.rideDate));
    paramView.bikeIdView.setText(paramViewGroup.bikeId);
    long l = h.c(paramViewGroup.rideTimeInMin);
    paramView.rideDurationView.setText(a.a(this.a, l));
    paramView.rideCostView.setText(o.a(paramViewGroup.rideCost));
    if (paramInt == 0)
    {
      paramView.upTimeLine.setVisibility(4);
      if (getCount() == 1)
      {
        paramView.downTimeLine.setVisibility(4);
        return localView;
      }
      paramView.downTimeLine.setVisibility(0);
      return localView;
    }
    if (paramInt == getCount() - 1)
    {
      paramView.upTimeLine.setVisibility(0);
      paramView.downTimeLine.setVisibility(4);
      return localView;
    }
    paramView.upTimeLine.setVisibility(0);
    paramView.downTimeLine.setVisibility(0);
    return localView;
  }
  
  public static class ViewHolder
  {
    @BindView(a=2131755775)
    TextView bikeIdView;
    @BindView(a=2131755772)
    ImageView downTimeLine;
    @BindView(a=2131755781)
    TextView rideCostView;
    @BindView(a=2131755773)
    TextView rideDateView;
    @BindView(a=2131755778)
    TextView rideDurationView;
    @BindView(a=2131755771)
    ImageView upTimeLine;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.a(this, paramView);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/UserTripAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */