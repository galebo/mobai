package com.mobike.mobikeapp.activity.login;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;
import de.hdodenhof.circleimageview.CircleImageView;

public class SsoUserInfoActivity_ViewBinding
  implements Unbinder
{
  private SsoUserInfoActivity b;
  
  @ao
  public SsoUserInfoActivity_ViewBinding(SsoUserInfoActivity paramSsoUserInfoActivity)
  {
    this(paramSsoUserInfoActivity, paramSsoUserInfoActivity.getWindow().getDecorView());
  }
  
  @ao
  public SsoUserInfoActivity_ViewBinding(SsoUserInfoActivity paramSsoUserInfoActivity, View paramView)
  {
    this.b = paramSsoUserInfoActivity;
    paramSsoUserInfoActivity.mNameTv = ((TextView)d.b(paramView, 2131755184, "field 'mNameTv'", TextView.class));
    paramSsoUserInfoActivity.mRulesTv = ((TextView)d.b(paramView, 2131755379, "field 'mRulesTv'", TextView.class));
    paramSsoUserInfoActivity.mBindingSourceTv = ((TextView)d.b(paramView, 2131755378, "field 'mBindingSourceTv'", TextView.class));
    paramSsoUserInfoActivity.mUnbindTv = ((TextView)d.b(paramView, 2131755380, "field 'mUnbindTv'", TextView.class));
    paramSsoUserInfoActivity.mCircleImageView = ((CircleImageView)d.b(paramView, 2131755377, "field 'mCircleImageView'", CircleImageView.class));
  }
  
  @i
  public void a()
  {
    SsoUserInfoActivity localSsoUserInfoActivity = this.b;
    if (localSsoUserInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localSsoUserInfoActivity.mNameTv = null;
    localSsoUserInfoActivity.mRulesTv = null;
    localSsoUserInfoActivity.mBindingSourceTv = null;
    localSsoUserInfoActivity.mUnbindTv = null;
    localSsoUserInfoActivity.mCircleImageView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/SsoUserInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */