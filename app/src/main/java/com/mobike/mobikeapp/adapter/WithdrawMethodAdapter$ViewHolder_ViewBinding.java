package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class WithdrawMethodAdapter$ViewHolder_ViewBinding
  implements Unbinder
{
  private WithdrawMethodAdapter.ViewHolder b;
  
  @ao
  public WithdrawMethodAdapter$ViewHolder_ViewBinding(WithdrawMethodAdapter.ViewHolder paramViewHolder, View paramView)
  {
    this.b = paramViewHolder;
    paramViewHolder.withdrawIcon = ((ImageView)d.b(paramView, 2131755724, "field 'withdrawIcon'", ImageView.class));
    paramViewHolder.withdrawMethodName = ((TextView)d.b(paramView, 2131755725, "field 'withdrawMethodName'", TextView.class));
    paramViewHolder.withdrawMethodTip = ((TextView)d.b(paramView, 2131755726, "field 'withdrawMethodTip'", TextView.class));
    paramViewHolder.withdrawCheck = ((RadioButton)d.b(paramView, 2131755727, "field 'withdrawCheck'", RadioButton.class));
    paramViewHolder.authColumn = ((RelativeLayout)d.b(paramView, 2131755728, "field 'authColumn'", RelativeLayout.class));
    paramViewHolder.authAvatar = ((ImageView)d.b(paramView, 2131755729, "field 'authAvatar'", ImageView.class));
    paramViewHolder.authNickname = ((TextView)d.b(paramView, 2131755730, "field 'authNickname'", TextView.class));
    paramViewHolder.authStatus = ((TextView)d.b(paramView, 2131755731, "field 'authStatus'", TextView.class));
  }
  
  @i
  public void a()
  {
    WithdrawMethodAdapter.ViewHolder localViewHolder = this.b;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localViewHolder.withdrawIcon = null;
    localViewHolder.withdrawMethodName = null;
    localViewHolder.withdrawMethodTip = null;
    localViewHolder.withdrawCheck = null;
    localViewHolder.authColumn = null;
    localViewHolder.authAvatar = null;
    localViewHolder.authNickname = null;
    localViewHolder.authStatus = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/WithdrawMethodAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */