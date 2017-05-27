package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class HelpCardViewAdapter$ViewHolder_ViewBinding
  implements Unbinder
{
  private HelpCardViewAdapter.ViewHolder b;
  
  @ao
  public HelpCardViewAdapter$ViewHolder_ViewBinding(HelpCardViewAdapter.ViewHolder paramViewHolder, View paramView)
  {
    this.b = paramViewHolder;
    paramViewHolder.imageView = ((ImageView)d.b(paramView, 2131755808, "field 'imageView'", ImageView.class));
    paramViewHolder.indexView = ((TextView)d.b(paramView, 2131755811, "field 'indexView'", TextView.class));
    paramViewHolder.middleView = ((TextView)d.b(paramView, 2131755812, "field 'middleView'", TextView.class));
    paramViewHolder.nextView = ((TextView)d.b(paramView, 2131755813, "field 'nextView'", TextView.class));
    paramViewHolder.titleView = ((TextView)d.b(paramView, 2131755809, "field 'titleView'", TextView.class));
    paramViewHolder.contentView = ((TextView)d.b(paramView, 2131755810, "field 'contentView'", TextView.class));
  }
  
  @i
  public void a()
  {
    HelpCardViewAdapter.ViewHolder localViewHolder = this.b;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localViewHolder.imageView = null;
    localViewHolder.indexView = null;
    localViewHolder.middleView = null;
    localViewHolder.nextView = null;
    localViewHolder.titleView = null;
    localViewHolder.contentView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/HelpCardViewAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */