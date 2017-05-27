package com.mobike.mobikeapp.activity.riding;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;

public class MyTripsActivity_ViewBinding
  implements Unbinder
{
  private MyTripsActivity b;
  private View c;
  
  @ao
  public MyTripsActivity_ViewBinding(MyTripsActivity paramMyTripsActivity)
  {
    this(paramMyTripsActivity, paramMyTripsActivity.getWindow().getDecorView());
  }
  
  @ao
  public MyTripsActivity_ViewBinding(final MyTripsActivity paramMyTripsActivity, View paramView)
  {
    this.b = paramMyTripsActivity;
    paramMyTripsActivity.mNetworkStateView = d.a(paramView, 2131755782, "field 'mNetworkStateView'");
    paramMyTripsActivity.mLoadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'mLoadingPageView'", LoadingPageView.class));
    paramMyTripsActivity.mMyTripsSwipyLayout = ((SwipyRefreshLayout)d.b(paramView, 2131755293, "field 'mMyTripsSwipyLayout'", SwipyRefreshLayout.class));
    paramView = d.a(paramView, 2131755294, "field 'mMyTripsListView' and method 'onItemClickTrip'");
    paramMyTripsActivity.mMyTripsListView = ((ListView)d.c(paramView, 2131755294, "field 'mMyTripsListView'", ListView.class));
    this.c = paramView;
    ((AdapterView)paramView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramMyTripsActivity.onItemClickTrip(paramAnonymousAdapterView, paramAnonymousInt);
      }
    });
  }
  
  @i
  public void a()
  {
    MyTripsActivity localMyTripsActivity = this.b;
    if (localMyTripsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localMyTripsActivity.mNetworkStateView = null;
    localMyTripsActivity.mLoadingPageView = null;
    localMyTripsActivity.mMyTripsSwipyLayout = null;
    localMyTripsActivity.mMyTripsListView = null;
    ((AdapterView)this.c).setOnItemClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/MyTripsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */