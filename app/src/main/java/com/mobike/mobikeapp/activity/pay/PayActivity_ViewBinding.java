package com.mobike.mobikeapp.activity.pay;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class PayActivity_ViewBinding
  implements Unbinder
{
  private PayActivity b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  @ao
  public PayActivity_ViewBinding(PayActivity paramPayActivity)
  {
    this(paramPayActivity, paramPayActivity.getWindow().getDecorView());
  }
  
  @ao
  public PayActivity_ViewBinding(final PayActivity paramPayActivity, View paramView)
  {
    this.b = paramPayActivity;
    View localView = d.a(paramView, 2131755317, "field 'mPayBtn' and method 'onClickPay'");
    paramPayActivity.mPayBtn = ((Button)d.c(localView, 2131755317, "field 'mPayBtn'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramPayActivity.onClickPay();
      }
    });
    localView = d.a(paramView, 2131755313, "field 'mPayApproachList' and method 'OnItemClickInApproach'");
    paramPayActivity.mPayApproachList = ((ListView)d.c(localView, 2131755313, "field 'mPayApproachList'", ListView.class));
    this.d = localView;
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramPayActivity.OnItemClickInApproach(paramAnonymousInt);
      }
    });
    paramPayActivity.mLoadingToastView = ((LoadingToastView)d.b(paramView, 2131755754, "field 'mLoadingToastView'", LoadingToastView.class));
    localView = d.a(paramView, 2131755311, "field 'mRechargeValueList' and method 'OnItemClickInGrid'");
    paramPayActivity.mRechargeValueList = ((GridView)d.c(localView, 2131755311, "field 'mRechargeValueList'", GridView.class));
    this.e = localView;
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramPayActivity.OnItemClickInGrid(paramAnonymousAdapterView, paramAnonymousInt);
      }
    });
    paramView = d.a(paramView, 2131755315, "method 'onClickProtocol'");
    this.f = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramPayActivity.onClickProtocol();
      }
    });
  }
  
  @i
  public void a()
  {
    PayActivity localPayActivity = this.b;
    if (localPayActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localPayActivity.mPayBtn = null;
    localPayActivity.mPayApproachList = null;
    localPayActivity.mLoadingToastView = null;
    localPayActivity.mRechargeValueList = null;
    this.c.setOnClickListener(null);
    this.c = null;
    ((AdapterView)this.d).setOnItemClickListener(null);
    this.d = null;
    ((AdapterView)this.e).setOnItemClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/PayActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */