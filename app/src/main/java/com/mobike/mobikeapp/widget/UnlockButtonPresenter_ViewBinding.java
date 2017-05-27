package com.mobike.mobikeapp.widget;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class UnlockButtonPresenter_ViewBinding
  implements Unbinder
{
  private UnlockButtonPresenter b;
  
  @ao
  public UnlockButtonPresenter_ViewBinding(UnlockButtonPresenter paramUnlockButtonPresenter, View paramView)
  {
    this.b = paramUnlockButtonPresenter;
    paramUnlockButtonPresenter.treasureImage = ((ImageView)d.b(paramView, 2131755733, "field 'treasureImage'", ImageView.class));
    paramUnlockButtonPresenter.qrcodeImage = ((ImageView)d.b(paramView, 2131755734, "field 'qrcodeImage'", ImageView.class));
  }
  
  @i
  public void a()
  {
    UnlockButtonPresenter localUnlockButtonPresenter = this.b;
    if (localUnlockButtonPresenter == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localUnlockButtonPresenter.treasureImage = null;
    localUnlockButtonPresenter.qrcodeImage = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/UnlockButtonPresenter_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */