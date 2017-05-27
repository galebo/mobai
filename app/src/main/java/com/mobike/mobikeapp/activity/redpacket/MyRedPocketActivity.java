package com.mobike.mobikeapp.activity.redpacket;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.b.a;
import android.support.v7.app.j;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.WebViewActivity;
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.data.RedPacketData.DataBean;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class MyRedPocketActivity
  extends BaseActivity
  implements com.mobike.mobikeapp.b.a.b
{
  private static final int a = 1;
  private com.mobike.mobikeapp.b.a.a b;
  private RedPacketData.DataBean e;
  @BindView(a=2131755754)
  LoadingToastView mLoadingToastView;
  @BindView(a=2131755286)
  TextView mRedPocketBalanceTv;
  @BindView(a=2131755925)
  TextView mRedPocketDetailTextView;
  @BindView(a=2131755288)
  TextView mRedPocketInstruction;
  @BindView(a=2131755289)
  TextView mRedPocketStraTv;
  @BindView(a=2131755291)
  Button mWithDrawButton;
  @BindView(a=2131755292)
  Button withdrawWallet;
  
  private void c()
  {
    a();
    this.b.a();
    if (q.a().b())
    {
      this.b.a();
      return;
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  private void d()
  {
    this.mRedPocketDetailTextView.setText(getResources().getString(2131296854));
    this.mRedPocketDetailTextView.setVisibility(0);
    this.mRedPocketDetailTextView.setTextColor(getResources().getColor(2131624021));
    ViewCompat.animate(this.mRedPocketInstruction).scaleY(0.0F).scaleX(0.0F).start();
  }
  
  public void a()
  {
    this.mLoadingToastView.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    h.a(this, paramString);
  }
  
  public void a(RedPacketData.DataBean paramDataBean)
  {
    boolean bool2 = true;
    this.e = paramDataBean;
    h.a(String.format("%.2f", new Object[] { Float.valueOf(paramDataBean.getTotal() / 100.0F) }), this.mRedPocketBalanceTv, this);
    this.mRedPocketInstruction.setText(getString(2131296727, new Object[] { Integer.valueOf(paramDataBean.getWithdrawMaxFee() / 100), Integer.valueOf(paramDataBean.getRemainTimes()) }));
    ViewCompat.animate(this.mRedPocketInstruction).alpha(100.0F).scaleX(1.0F).scaleY(1.0F).setDuration(500L);
    this.mRedPocketInstruction.setVisibility(0);
    Button localButton = this.withdrawWallet;
    if ((paramDataBean.getTotal() > paramDataBean.getWithdrawMaxFee()) && (paramDataBean.getRemainTimes() > 0))
    {
      bool1 = true;
      localButton.setEnabled(bool1);
      localButton = this.mWithDrawButton;
      if (paramDataBean.getTotal() <= 0) {
        break label172;
      }
    }
    label172:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localButton.setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(com.mobike.mobikeapp.model.data.a parama)
  {
    switch (parama.result)
    {
    case 2002: 
    case 2004: 
    default: 
      return;
    }
    a(0, parama.message);
    c();
  }
  
  public void b()
  {
    this.mLoadingToastView.b();
  }
  
  @OnClick(a={2131755290})
  public void goToRedPocketFAQ()
  {
    int j = 0;
    String str = getString(2131296697);
    int i;
    if (this.e == null)
    {
      i = 0;
      if (this.e != null) {
        break label50;
      }
    }
    for (;;)
    {
      startActivity(WebViewActivity.a(str, com.mobike.mobikeapp.c.a.a(i, j)));
      return;
      i = this.e.getWithdrawMaxFee();
      break;
      label50:
      j = this.e.getWithdrawMaxTimesOneday();
    }
  }
  
  @OnClick(a={2131755289})
  public void goToRedPocketStra()
  {
    startActivity(CustomerServiceWebActivity.a(this, getString(2131296705), com.mobike.mobikeapp.c.a.n()));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (q.a().b()) {
        this.b.a();
      }
    }
    else {
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968633);
    ButterKnife.a(this);
    this.b = new com.mobike.mobikeapp.b.b(this);
    d();
  }
  
  protected void onStart()
  {
    super.onStart();
    c();
  }
  
  @OnClick(a={2131755291})
  public void recharge2Wallet()
  {
    Object localObject = new b.a(this, 2131427642);
    ((b.a)localObject).b(getString(2131296857, new Object[] { o.a(Integer.valueOf(this.e.getTotal())) })).a(17039370, b.a(this)).b(17039360, c.a());
    localObject = ((b.a)localObject).b();
    ((j)localObject).setCanceledOnTouchOutside(false);
    ((j)localObject).show();
  }
  
  @OnClick(a={2131755925})
  public void redPocketDetail()
  {
    startActivity(new Intent(this, RedPocketDetailActivity.class));
  }
  
  @OnClick(a={2131755292})
  public void submitWithdraw(View paramView)
  {
    paramView = new Intent(this, WithdrawActivity.class);
    paramView.putExtra("redPacketInfo", this.e);
    startActivity(paramView);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/MyRedPocketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */