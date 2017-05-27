package com.mobike.mobikeapp.adapter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class UserDetailAdapter$HolderView_ViewBinding
  implements Unbinder
{
  private UserDetailAdapter.HolderView b;
  
  @ao
  public UserDetailAdapter$HolderView_ViewBinding(UserDetailAdapter.HolderView paramHolderView, View paramView)
  {
    this.b = paramHolderView;
    paramHolderView.margin = d.a(paramView, 2131755705, "field 'margin'");
    paramHolderView.name = ((TextView)d.b(paramView, 2131755541, "field 'name'", TextView.class));
    paramHolderView.content = ((TextView)d.b(paramView, 2131755723, "field 'content'", TextView.class));
    paramHolderView.rootView = ((RelativeLayout)d.b(paramView, 2131755722, "field 'rootView'", RelativeLayout.class));
  }
  
  @i
  public void a()
  {
    UserDetailAdapter.HolderView localHolderView = this.b;
    if (localHolderView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localHolderView.margin = null;
    localHolderView.name = null;
    localHolderView.content = null;
    localHolderView.rootView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/UserDetailAdapter$HolderView_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */