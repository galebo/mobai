package com.mobike.mobikeapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ao;
import android.support.annotation.i;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import butterknife.Unbinder;
import butterknife.internal.d;

public class HelpCardActivity_ViewBinding
  implements Unbinder
{
  private HelpCardActivity b;
  
  @ao
  public HelpCardActivity_ViewBinding(HelpCardActivity paramHelpCardActivity)
  {
    this(paramHelpCardActivity, paramHelpCardActivity.getWindow().getDecorView());
  }
  
  @ao
  public HelpCardActivity_ViewBinding(HelpCardActivity paramHelpCardActivity, View paramView)
  {
    this.b = paramHelpCardActivity;
    paramHelpCardActivity.mViewPager = ((ViewPager)d.b(paramView, 2131755207, "field 'mViewPager'", ViewPager.class));
    paramView = paramView.getContext().getResources();
    paramHelpCardActivity.mTitles = paramView.getStringArray(2131689477);
    paramHelpCardActivity.mContents = paramView.getStringArray(2131689476);
  }
  
  @i
  public void a()
  {
    HelpCardActivity localHelpCardActivity = this.b;
    if (localHelpCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localHelpCardActivity.mViewPager = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/HelpCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */