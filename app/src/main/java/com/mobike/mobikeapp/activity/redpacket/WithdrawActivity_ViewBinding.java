package com.mobike.mobikeapp.activity.redpacket;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class WithdrawActivity_ViewBinding
  implements Unbinder
{
  private WithdrawActivity b;
  private View c;
  private View d;
  private View e;
  
  @ao
  public WithdrawActivity_ViewBinding(WithdrawActivity paramWithdrawActivity)
  {
    this(paramWithdrawActivity, paramWithdrawActivity.getWindow().getDecorView());
  }
  
  @ao
  public WithdrawActivity_ViewBinding(final WithdrawActivity paramWithdrawActivity, View paramView)
  {
    this.b = paramWithdrawActivity;
    View localView = d.a(paramView, 2131755925, "field 'mFAQTv' and method 'onClickFAQ'");
    paramWithdrawActivity.mFAQTv = ((TextView)d.c(localView, 2131755925, "field 'mFAQTv'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramWithdrawActivity.onClickFAQ();
      }
    });
    paramWithdrawActivity.mWithdrawTv = ((TextView)d.b(paramView, 2131755420, "field 'mWithdrawTv'", TextView.class));
    localView = d.a(paramView, 2131755421, "field 'mWithdrawLv' and method 'onItemClickMethod'");
    paramWithdrawActivity.mWithdrawLv = ((ListView)d.c(localView, 2131755421, "field 'mWithdrawLv'", ListView.class));
    this.d = localView;
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramWithdrawActivity.onItemClickMethod(paramAnonymousInt);
      }
    });
    paramWithdrawActivity.loadingToastView = ((LoadingToastView)d.b(paramView, 2131755754, "field 'loadingToastView'", LoadingToastView.class));
    paramView = d.a(paramView, 2131755422, "field 'mWithdrawBtn' and method 'onClickWithdraw'");
    paramWithdrawActivity.mWithdrawBtn = ((Button)d.c(paramView, 2131755422, "field 'mWithdrawBtn'", Button.class));
    this.e = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramWithdrawActivity.onClickWithdraw();
      }
    });
  }
  
  @i
  public void a()
  {
    WithdrawActivity localWithdrawActivity = this.b;
    if (localWithdrawActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localWithdrawActivity.mFAQTv = null;
    localWithdrawActivity.mWithdrawTv = null;
    localWithdrawActivity.mWithdrawLv = null;
    localWithdrawActivity.loadingToastView = null;
    localWithdrawActivity.mWithdrawBtn = null;
    this.c.setOnClickListener(null);
    this.c = null;
    ((AdapterView)this.d).setOnItemClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/WithdrawActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */