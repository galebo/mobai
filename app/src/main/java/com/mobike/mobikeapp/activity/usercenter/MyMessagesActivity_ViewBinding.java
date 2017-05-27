package com.mobike.mobikeapp.activity.usercenter;

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
import com.mobike.mobikeapp.widget.EmptyView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;

public class MyMessagesActivity_ViewBinding
  implements Unbinder
{
  private MyMessagesActivity b;
  private View c;
  
  @ao
  public MyMessagesActivity_ViewBinding(MyMessagesActivity paramMyMessagesActivity)
  {
    this(paramMyMessagesActivity, paramMyMessagesActivity.getWindow().getDecorView());
  }
  
  @ao
  public MyMessagesActivity_ViewBinding(final MyMessagesActivity paramMyMessagesActivity, View paramView)
  {
    this.b = paramMyMessagesActivity;
    paramMyMessagesActivity.swipyRefreshLayout = ((SwipyRefreshLayout)d.b(paramView, 2131755284, "field 'swipyRefreshLayout'", SwipyRefreshLayout.class));
    View localView = d.a(paramView, 2131755285, "field 'messageListView' and method 'onClickItemMessage'");
    paramMyMessagesActivity.messageListView = ((ListView)d.c(localView, 2131755285, "field 'messageListView'", ListView.class));
    this.c = localView;
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramMyMessagesActivity.onClickItemMessage(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
      }
    });
    paramMyMessagesActivity.emptyView = ((EmptyView)d.b(paramView, 2131755611, "field 'emptyView'", EmptyView.class));
  }
  
  @i
  public void a()
  {
    MyMessagesActivity localMyMessagesActivity = this.b;
    if (localMyMessagesActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localMyMessagesActivity.swipyRefreshLayout = null;
    localMyMessagesActivity.messageListView = null;
    localMyMessagesActivity.emptyView = null;
    ((AdapterView)this.c).setOnItemClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MyMessagesActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */