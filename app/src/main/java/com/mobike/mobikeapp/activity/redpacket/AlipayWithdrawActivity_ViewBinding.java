package com.mobike.mobikeapp.activity.redpacket;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;

public class AlipayWithdrawActivity_ViewBinding
  implements Unbinder
{
  private AlipayWithdrawActivity b;
  private View c;
  private View d;
  
  @ao
  public AlipayWithdrawActivity_ViewBinding(AlipayWithdrawActivity paramAlipayWithdrawActivity)
  {
    this(paramAlipayWithdrawActivity, paramAlipayWithdrawActivity.getWindow().getDecorView());
  }
  
  @ao
  public AlipayWithdrawActivity_ViewBinding(final AlipayWithdrawActivity paramAlipayWithdrawActivity, View paramView)
  {
    this.b = paramAlipayWithdrawActivity;
    paramAlipayWithdrawActivity.mAlipayAccountEt = ((EditText)d.b(paramView, 2131755173, "field 'mAlipayAccountEt'", EditText.class));
    paramAlipayWithdrawActivity.mAlipayRealNameEt = ((EditText)d.b(paramView, 2131755174, "field 'mAlipayRealNameEt'", EditText.class));
    paramAlipayWithdrawActivity.mAlipayAmountEt = ((EditText)d.b(paramView, 2131755177, "field 'mAlipayAmountEt'", EditText.class));
    View localView = d.a(paramView, 2131755179, "field 'mWithdrawButton' and method 'withdrawMoney'");
    paramAlipayWithdrawActivity.mWithdrawButton = ((Button)d.c(localView, 2131755179, "field 'mWithdrawButton'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramAlipayWithdrawActivity.withdrawMoney(paramAnonymousView);
      }
    });
    paramAlipayWithdrawActivity.mVerifyEt = ((EditText)d.b(paramView, 2131755175, "field 'mVerifyEt'", EditText.class));
    paramView = d.a(paramView, 2131755176, "field 'mTimerTv' and method 'sendSmsCode'");
    paramAlipayWithdrawActivity.mTimerTv = ((Button)d.c(paramView, 2131755176, "field 'mTimerTv'", Button.class));
    this.d = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramAlipayWithdrawActivity.sendSmsCode();
      }
    });
  }
  
  @i
  public void a()
  {
    AlipayWithdrawActivity localAlipayWithdrawActivity = this.b;
    if (localAlipayWithdrawActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localAlipayWithdrawActivity.mAlipayAccountEt = null;
    localAlipayWithdrawActivity.mAlipayRealNameEt = null;
    localAlipayWithdrawActivity.mAlipayAmountEt = null;
    localAlipayWithdrawActivity.mWithdrawButton = null;
    localAlipayWithdrawActivity.mVerifyEt = null;
    localAlipayWithdrawActivity.mTimerTv = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/AlipayWithdrawActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */