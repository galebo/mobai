package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class MyRideItemRecyclerViewAdapter$ViewHolder_ViewBinding
  implements Unbinder
{
  private MyRideItemRecyclerViewAdapter.ViewHolder b;
  
  @ao
  public MyRideItemRecyclerViewAdapter$ViewHolder_ViewBinding(MyRideItemRecyclerViewAdapter.ViewHolder paramViewHolder, View paramView)
  {
    this.b = paramViewHolder;
    paramViewHolder.mCostBucket = ((TextView)d.b(paramView, 2131755717, "field 'mCostBucket'", TextView.class));
    paramViewHolder.mCostDesc = ((TextView)d.b(paramView, 2131755720, "field 'mCostDesc'", TextView.class));
    paramViewHolder.mCostAmount = ((TextView)d.b(paramView, 2131755718, "field 'mCostAmount'", TextView.class));
    paramViewHolder.mCostIcon = ((ImageView)d.b(paramView, 2131755716, "field 'mCostIcon'", ImageView.class));
    paramViewHolder.mCostHintLine = ((ImageView)d.b(paramView, 2131755719, "field 'mCostHintLine'", ImageView.class));
  }
  
  @i
  public void a()
  {
    MyRideItemRecyclerViewAdapter.ViewHolder localViewHolder = this.b;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localViewHolder.mCostBucket = null;
    localViewHolder.mCostDesc = null;
    localViewHolder.mCostAmount = null;
    localViewHolder.mCostIcon = null;
    localViewHolder.mCostHintLine = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/MyRideItemRecyclerViewAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */