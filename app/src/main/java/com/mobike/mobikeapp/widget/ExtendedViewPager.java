package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class ExtendedViewPager
  extends ViewPager
{
  public ExtendedViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendedViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof TouchImageView)) {
      return ((TouchImageView)paramView).a(-paramInt1);
    }
    return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/ExtendedViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */