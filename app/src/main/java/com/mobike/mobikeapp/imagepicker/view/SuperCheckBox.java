package com.mobike.mobikeapp.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class SuperCheckBox
  extends CheckBox
{
  public SuperCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public SuperCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SuperCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (!bool) {
      playSoundEffect(0);
    }
    return bool;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/view/SuperCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */