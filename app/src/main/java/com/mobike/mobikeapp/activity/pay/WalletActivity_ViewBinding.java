package com.mobike.mobikeapp.activity.pay;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class WalletActivity_ViewBinding
  implements Unbinder
{
  private WalletActivity b;
  private View c;
  private View d;
  
  @ao
  public WalletActivity_ViewBinding(WalletActivity paramWalletActivity)
  {
    this(paramWalletActivity, paramWalletActivity.getWindow().getDecorView());
  }
  
  @ao
  public WalletActivity_ViewBinding(final WalletActivity paramWalletActivity, View paramView)
  {
    this.b = paramWalletActivity;
    paramWalletActivity.walletBalance = ((TextView)d.b(paramView, 2131755412, "field 'walletBalance'", TextView.class));
    paramWalletActivity.walletBalanceHint = ((TextView)d.b(paramView, 2131755413, "field 'walletBalanceHint'", TextView.class));
    paramWalletActivity.walletDeposit = ((TextView)d.b(paramView, 2131755415, "field 'walletDeposit'", TextView.class));
    View localView = d.a(paramView, 2131755416, "field 'walletRefund' and method 'onClickRefund'");
    paramWalletActivity.walletRefund = ((TextView)d.c(localView, 2131755416, "field 'walletRefund'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramWalletActivity.onClickRefund();
      }
    });
    paramWalletActivity.mLoadingToastView = ((LoadingToastView)d.b(paramView, 2131755754, "field 'mLoadingToastView'", LoadingToastView.class));
    paramWalletActivity.walletBanner = ((TextView)d.b(paramView, 2131755411, "field 'walletBanner'", TextView.class));
    paramView = d.a(paramView, 2131755417, "method 'onClickSubmit'");
    this.d = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramWalletActivity.onClickSubmit();
      }
    });
  }
  
  @i
  public void a()
  {
    WalletActivity localWalletActivity = this.b;
    if (localWalletActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localWalletActivity.walletBalance = null;
    localWalletActivity.walletBalanceHint = null;
    localWalletActivity.walletDeposit = null;
    localWalletActivity.walletRefund = null;
    localWalletActivity.mLoadingToastView = null;
    localWalletActivity.walletBanner = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/WalletActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */