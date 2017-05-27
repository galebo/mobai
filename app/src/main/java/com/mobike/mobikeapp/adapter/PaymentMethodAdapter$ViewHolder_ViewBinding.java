package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class PaymentMethodAdapter$ViewHolder_ViewBinding
  implements Unbinder
{
  private PaymentMethodAdapter.ViewHolder b;
  
  @ao
  public PaymentMethodAdapter$ViewHolder_ViewBinding(PaymentMethodAdapter.ViewHolder paramViewHolder, View paramView)
  {
    this.b = paramViewHolder;
    paramViewHolder.payApproachItemIcon = ((ImageView)d.b(paramView, 2131755829, "field 'payApproachItemIcon'", ImageView.class));
    paramViewHolder.payApproachItemTitle = ((TextView)d.b(paramView, 2131755830, "field 'payApproachItemTitle'", TextView.class));
    paramViewHolder.payApproachCheckRadio = ((RadioButton)d.b(paramView, 2131755831, "field 'payApproachCheckRadio'", RadioButton.class));
  }
  
  @i
  public void a()
  {
    PaymentMethodAdapter.ViewHolder localViewHolder = this.b;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localViewHolder.payApproachItemIcon = null;
    localViewHolder.payApproachItemTitle = null;
    localViewHolder.payApproachCheckRadio = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/PaymentMethodAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */