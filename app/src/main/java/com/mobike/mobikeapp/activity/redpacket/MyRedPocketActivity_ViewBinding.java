package com.mobike.mobikeapp.activity.redpacket;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class MyRedPocketActivity_ViewBinding
  implements Unbinder
{
  private MyRedPocketActivity b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  @ao
  public MyRedPocketActivity_ViewBinding(MyRedPocketActivity paramMyRedPocketActivity)
  {
    this(paramMyRedPocketActivity, paramMyRedPocketActivity.getWindow().getDecorView());
  }
  
  @ao
  public MyRedPocketActivity_ViewBinding(final MyRedPocketActivity paramMyRedPocketActivity, View paramView)
  {
    this.b = paramMyRedPocketActivity;
    paramMyRedPocketActivity.mRedPocketBalanceTv = ((TextView)d.b(paramView, 2131755286, "field 'mRedPocketBalanceTv'", TextView.class));
    View localView = d.a(paramView, 2131755291, "field 'mWithDrawButton' and method 'recharge2Wallet'");
    paramMyRedPocketActivity.mWithDrawButton = ((Button)d.c(localView, 2131755291, "field 'mWithDrawButton'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyRedPocketActivity.recharge2Wallet();
      }
    });
    localView = d.a(paramView, 2131755289, "field 'mRedPocketStraTv' and method 'goToRedPocketStra'");
    paramMyRedPocketActivity.mRedPocketStraTv = ((TextView)d.c(localView, 2131755289, "field 'mRedPocketStraTv'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyRedPocketActivity.goToRedPocketStra();
      }
    });
    paramMyRedPocketActivity.mRedPocketInstruction = ((TextView)d.b(paramView, 2131755288, "field 'mRedPocketInstruction'", TextView.class));
    paramMyRedPocketActivity.mLoadingToastView = ((LoadingToastView)d.b(paramView, 2131755754, "field 'mLoadingToastView'", LoadingToastView.class));
    localView = d.a(paramView, 2131755292, "field 'withdrawWallet' and method 'submitWithdraw'");
    paramMyRedPocketActivity.withdrawWallet = ((Button)d.c(localView, 2131755292, "field 'withdrawWallet'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyRedPocketActivity.submitWithdraw(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755925, "field 'mRedPocketDetailTextView' and method 'redPocketDetail'");
    paramMyRedPocketActivity.mRedPocketDetailTextView = ((TextView)d.c(localView, 2131755925, "field 'mRedPocketDetailTextView'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyRedPocketActivity.redPocketDetail();
      }
    });
    paramView = d.a(paramView, 2131755290, "method 'goToRedPocketFAQ'");
    this.g = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyRedPocketActivity.goToRedPocketFAQ();
      }
    });
  }
  
  @i
  public void a()
  {
    MyRedPocketActivity localMyRedPocketActivity = this.b;
    if (localMyRedPocketActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localMyRedPocketActivity.mRedPocketBalanceTv = null;
    localMyRedPocketActivity.mWithDrawButton = null;
    localMyRedPocketActivity.mRedPocketStraTv = null;
    localMyRedPocketActivity.mRedPocketInstruction = null;
    localMyRedPocketActivity.mLoadingToastView = null;
    localMyRedPocketActivity.withdrawWallet = null;
    localMyRedPocketActivity.mRedPocketDetailTextView = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/MyRedPocketActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */