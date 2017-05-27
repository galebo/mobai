package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingToastView
  extends FrameLayout
{
  private ImageView a;
  private TextView b;
  private Animation c;
  
  public LoadingToastView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoadingToastView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoadingToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.startAnimation(this.c);
    }
    setVisibility(0);
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.clearAnimation();
    }
    setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131755755));
    this.b = ((TextView)findViewById(2131755756));
    this.c = AnimationUtils.loadAnimation(getContext(), 2131034159);
  }
  
  public void setLoadingText(int paramInt)
  {
    this.b.setText(paramInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/LoadingToastView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */