package com.mobike.mobikeapp.activity.login;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class RegisterRechargeActivity_ViewBinding
  implements Unbinder
{
  private RegisterRechargeActivity b;
  private View c;
  private View d;
  
  @ao
  public RegisterRechargeActivity_ViewBinding(RegisterRechargeActivity paramRegisterRechargeActivity)
  {
    this(paramRegisterRechargeActivity, paramRegisterRechargeActivity.getWindow().getDecorView());
  }
  
  @ao
  public RegisterRechargeActivity_ViewBinding(final RegisterRechargeActivity paramRegisterRechargeActivity, View paramView)
  {
    this.b = paramRegisterRechargeActivity;
    View localView = d.a(paramView, 2131755313, "field 'mPayApproachList' and method 'onItemClickPay'");
    paramRegisterRechargeActivity.mPayApproachList = ((ListView)d.c(localView, 2131755313, "field 'mPayApproachList'", ListView.class));
    this.c = localView;
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramRegisterRechargeActivity.onItemClickPay(paramAnonymousInt);
      }
    });
    localView = d.a(paramView, 2131755317, "field 'mPayBtn' and method 'onClickPay'");
    paramRegisterRechargeActivity.mPayBtn = ((Button)d.c(localView, 2131755317, "field 'mPayBtn'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramRegisterRechargeActivity.onClickPay();
      }
    });
    paramRegisterRechargeActivity.mLoadingToastView = ((LoadingToastView)d.b(paramView, 2131755754, "field 'mLoadingToastView'", LoadingToastView.class));
    paramRegisterRechargeActivity.mProgressDot = ((ImageView)d.b(paramView, 2131755975, "field 'mProgressDot'", ImageView.class));
  }
  
  @i
  public void a()
  {
    RegisterRechargeActivity localRegisterRechargeActivity = this.b;
    if (localRegisterRechargeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localRegisterRechargeActivity.mPayApproachList = null;
    localRegisterRechargeActivity.mPayBtn = null;
    localRegisterRechargeActivity.mLoadingToastView = null;
    localRegisterRechargeActivity.mProgressDot = null;
    ((AdapterView)this.c).setOnItemClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/RegisterRechargeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */