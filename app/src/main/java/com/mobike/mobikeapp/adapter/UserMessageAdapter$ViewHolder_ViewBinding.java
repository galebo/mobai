package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class UserMessageAdapter$ViewHolder_ViewBinding
  implements Unbinder
{
  private UserMessageAdapter.ViewHolder b;
  
  @ao
  public UserMessageAdapter$ViewHolder_ViewBinding(UserMessageAdapter.ViewHolder paramViewHolder, View paramView)
  {
    this.b = paramViewHolder;
    paramViewHolder.image = ((ImageView)d.b(paramView, 2131755712, "field 'image'", ImageView.class));
    paramViewHolder.date = ((TextView)d.b(paramView, 2131755710, "field 'date'", TextView.class));
    paramViewHolder.title = ((TextView)d.b(paramView, 2131755713, "field 'title'", TextView.class));
    paramViewHolder.body = ((TextView)d.b(paramView, 2131755714, "field 'body'", TextView.class));
  }
  
  @i
  public void a()
  {
    UserMessageAdapter.ViewHolder localViewHolder = this.b;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localViewHolder.image = null;
    localViewHolder.date = null;
    localViewHolder.title = null;
    localViewHolder.body = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/UserMessageAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */