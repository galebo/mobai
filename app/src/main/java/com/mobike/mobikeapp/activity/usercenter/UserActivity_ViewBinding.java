package com.mobike.mobikeapp.activity.usercenter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;

public class UserActivity_ViewBinding
  implements Unbinder
{
  private UserActivity b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  
  @ao
  public UserActivity_ViewBinding(UserActivity paramUserActivity)
  {
    this(paramUserActivity, paramUserActivity.getWindow().getDecorView());
  }
  
  @ao
  public UserActivity_ViewBinding(final UserActivity paramUserActivity, View paramView)
  {
    this.b = paramUserActivity;
    paramUserActivity.mToolbar = ((Toolbar)d.b(paramView, 2131755169, "field 'mToolbar'", Toolbar.class));
    paramUserActivity.mTitleView = ((TextView)d.b(paramView, 2131755280, "field 'mTitleView'", TextView.class));
    paramUserActivity.mUserRideSummary = d.a(paramView, 2131755981, "field 'mUserRideSummary'");
    View localView = d.a(paramView, 2131755980, "field 'mUserRegisterSummary' and method 'onClickRegisterSummary'");
    paramUserActivity.mUserRegisterSummary = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickRegisterSummary(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755979, "field 'mErrorPanel' and method 'onClickError'");
    paramUserActivity.mErrorPanel = localView;
    this.d = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickError(paramAnonymousView);
      }
    });
    paramUserActivity.mBalanceView = ((TextView)d.b(paramView, 2131755983, "field 'mBalanceView'", TextView.class));
    paramUserActivity.mCouponView = ((TextView)d.b(paramView, 2131755985, "field 'mCouponView'", TextView.class));
    paramUserActivity.mNewMessageView = ((TextView)d.b(paramView, 2131755989, "field 'mNewMessageView'", TextView.class));
    paramUserActivity.mNewInviteView = ((TextView)d.b(paramView, 2131755991, "field 'mNewInviteView'", TextView.class));
    localView = d.a(paramView, 2131756003, "field 'mUserAvatarView' and method 'onClickAvatar'");
    paramUserActivity.mUserAvatarView = ((ImageView)d.c(localView, 2131756003, "field 'mUserAvatarView'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickAvatar();
      }
    });
    paramUserActivity.mUserNameTextView = ((TextView)d.b(paramView, 2131756004, "field 'mUserNameTextView'", TextView.class));
    localView = d.a(paramView, 2131756005, "field 'mCreditBtn' and method 'onClickCredit'");
    paramUserActivity.mCreditBtn = ((Button)d.c(localView, 2131756005, "field 'mCreditBtn'", Button.class));
    this.f = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickCredit();
      }
    });
    paramUserActivity.distanceText = ((TextView)d.b(paramView, 2131755999, "field 'distanceText'", TextView.class));
    paramUserActivity.carbonText = ((TextView)d.b(paramView, 2131756000, "field 'carbonText'", TextView.class));
    paramUserActivity.powerText = ((TextView)d.b(paramView, 2131756001, "field 'powerText'", TextView.class));
    paramUserActivity.mRegisterDepositView = d.a(paramView, 2131755997, "field 'mRegisterDepositView'");
    paramUserActivity.mRegisterVerifyView = d.a(paramView, 2131755998, "field 'mRegisterVerifyView'");
    localView = d.a(paramView, 2131755982, "method 'onClickEntry'");
    this.g = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755984, "method 'onClickEntry'");
    this.h = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755986, "method 'onClickEntry'");
    this.i = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755988, "method 'onClickEntry'");
    this.j = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755990, "method 'onClickEntry'");
    this.k = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755992, "method 'onClickEntry'");
    this.l = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
    paramView = d.a(paramView, 2131755994, "method 'onClickEntry'");
    this.m = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramUserActivity.onClickEntry(paramAnonymousView);
      }
    });
  }
  
  @i
  public void a()
  {
    UserActivity localUserActivity = this.b;
    if (localUserActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localUserActivity.mToolbar = null;
    localUserActivity.mTitleView = null;
    localUserActivity.mUserRideSummary = null;
    localUserActivity.mUserRegisterSummary = null;
    localUserActivity.mErrorPanel = null;
    localUserActivity.mBalanceView = null;
    localUserActivity.mCouponView = null;
    localUserActivity.mNewMessageView = null;
    localUserActivity.mNewInviteView = null;
    localUserActivity.mUserAvatarView = null;
    localUserActivity.mUserNameTextView = null;
    localUserActivity.mCreditBtn = null;
    localUserActivity.distanceText = null;
    localUserActivity.carbonText = null;
    localUserActivity.powerText = null;
    localUserActivity.mRegisterDepositView = null;
    localUserActivity.mRegisterVerifyView = null;
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
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.l.setOnClickListener(null);
    this.l = null;
    this.m.setOnClickListener(null);
    this.m = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/UserActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */