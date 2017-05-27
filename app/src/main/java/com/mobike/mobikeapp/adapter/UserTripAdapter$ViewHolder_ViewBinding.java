package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class UserTripAdapter$ViewHolder_ViewBinding
  implements Unbinder
{
  private UserTripAdapter.ViewHolder b;
  
  @ao
  public UserTripAdapter$ViewHolder_ViewBinding(UserTripAdapter.ViewHolder paramViewHolder, View paramView)
  {
    this.b = paramViewHolder;
    paramViewHolder.upTimeLine = ((ImageView)d.b(paramView, 2131755771, "field 'upTimeLine'", ImageView.class));
    paramViewHolder.downTimeLine = ((ImageView)d.b(paramView, 2131755772, "field 'downTimeLine'", ImageView.class));
    paramViewHolder.rideDateView = ((TextView)d.b(paramView, 2131755773, "field 'rideDateView'", TextView.class));
    paramViewHolder.bikeIdView = ((TextView)d.b(paramView, 2131755775, "field 'bikeIdView'", TextView.class));
    paramViewHolder.rideDurationView = ((TextView)d.b(paramView, 2131755778, "field 'rideDurationView'", TextView.class));
    paramViewHolder.rideCostView = ((TextView)d.b(paramView, 2131755781, "field 'rideCostView'", TextView.class));
  }
  
  @i
  public void a()
  {
    UserTripAdapter.ViewHolder localViewHolder = this.b;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localViewHolder.upTimeLine = null;
    localViewHolder.downTimeLine = null;
    localViewHolder.rideDateView = null;
    localViewHolder.bikeIdView = null;
    localViewHolder.rideDurationView = null;
    localViewHolder.rideCostView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/UserTripAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */