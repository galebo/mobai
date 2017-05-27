package com.mobike.mobikeapp.activity.redpacket;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import butterknife.Unbinder;
import butterknife.internal.d;

public class RedPocketDetailActivity_ViewBinding
  implements Unbinder
{
  private RedPocketDetailActivity b;
  
  @ao
  public RedPocketDetailActivity_ViewBinding(RedPocketDetailActivity paramRedPocketDetailActivity)
  {
    this(paramRedPocketDetailActivity, paramRedPocketDetailActivity.getWindow().getDecorView());
  }
  
  @ao
  public RedPocketDetailActivity_ViewBinding(RedPocketDetailActivity paramRedPocketDetailActivity, View paramView)
  {
    this.b = paramRedPocketDetailActivity;
    paramRedPocketDetailActivity.mRecycerView = ((RecyclerView)d.b(paramView, 2131755326, "field 'mRecycerView'", RecyclerView.class));
    paramRedPocketDetailActivity.mSwipeRefreshLayout = ((SwipeRefreshLayout)d.b(paramView, 2131755325, "field 'mSwipeRefreshLayout'", SwipeRefreshLayout.class));
  }
  
  @i
  public void a()
  {
    RedPocketDetailActivity localRedPocketDetailActivity = this.b;
    if (localRedPocketDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localRedPocketDetailActivity.mRecycerView = null;
    localRedPocketDetailActivity.mSwipeRefreshLayout = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/RedPocketDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */