package com.mobike.mobikeapp.activity.login;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;

public class LoginActivity_ViewBinding
  implements Unbinder
{
  private LoginActivity b;
  private View c;
  private View d;
  
  @ao
  public LoginActivity_ViewBinding(LoginActivity paramLoginActivity)
  {
    this(paramLoginActivity, paramLoginActivity.getWindow().getDecorView());
  }
  
  @ao
  public LoginActivity_ViewBinding(final LoginActivity paramLoginActivity, View paramView)
  {
    this.b = paramLoginActivity;
    View localView = d.a(paramView, 2131755270, "field 'mWechatLogInBt' and method 'onClickWeChat'");
    paramLoginActivity.mWechatLogInBt = ((ImageButton)d.c(localView, 2131755270, "field 'mWechatLogInBt'", ImageButton.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramLoginActivity.onClickWeChat();
      }
    });
    localView = d.a(paramView, 2131755271, "field 'mQQlogInBt' and method 'onClickQQ'");
    paramLoginActivity.mQQlogInBt = ((ImageButton)d.c(localView, 2131755271, "field 'mQQlogInBt'", ImageButton.class));
    this.d = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramLoginActivity.onClickQQ();
      }
    });
    paramLoginActivity.mViewStub = ((ViewStub)d.b(paramView, 2131755259, "field 'mViewStub'", ViewStub.class));
    paramLoginActivity.mSsoLayout = d.a(paramView, 2131755267, "field 'mSsoLayout'");
  }
  
  @i
  public void a()
  {
    LoginActivity localLoginActivity = this.b;
    if (localLoginActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localLoginActivity.mWechatLogInBt = null;
    localLoginActivity.mQQlogInBt = null;
    localLoginActivity.mViewStub = null;
    localLoginActivity.mSsoLayout = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/LoginActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */