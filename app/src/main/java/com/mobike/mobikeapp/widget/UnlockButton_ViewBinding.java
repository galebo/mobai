package com.mobike.mobikeapp.widget;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class UnlockButton_ViewBinding
  implements Unbinder
{
  private UnlockButton b;
  
  @ao
  public UnlockButton_ViewBinding(UnlockButton paramUnlockButton)
  {
    this(paramUnlockButton, paramUnlockButton);
  }
  
  @ao
  public UnlockButton_ViewBinding(UnlockButton paramUnlockButton, View paramView)
  {
    this.b = paramUnlockButton;
    paramUnlockButton.mTreasureImage = ((ImageView)d.b(paramView, 2131755733, "field 'mTreasureImage'", ImageView.class));
    paramUnlockButton.mQrcodeImage = ((ImageView)d.b(paramView, 2131755734, "field 'mQrcodeImage'", ImageView.class));
  }
  
  @i
  public void a()
  {
    UnlockButton localUnlockButton = this.b;
    if (localUnlockButton == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localUnlockButton.mTreasureImage = null;
    localUnlockButton.mQrcodeImage = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/UnlockButton_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */