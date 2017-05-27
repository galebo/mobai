package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.frakbot.jumpingbeans.b;
import net.frakbot.jumpingbeans.b.a;

public class LoadingPageView
  extends LinearLayout
{
  private ImageView a;
  private Animation b;
  private TextView c;
  private b d;
  
  public LoadingPageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoadingPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoadingPageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.startAnimation(this.b);
    }
    this.d = b.a(this.c).a().b();
    setVisibility(0);
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.clearAnimation();
    }
    if (this.d != null) {
      this.d.a();
    }
    setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131755752));
    this.c = ((TextView)findViewById(2131755753));
    this.b = AnimationUtils.loadAnimation(getContext(), 2131034159);
  }
  
  public void setLoadingText(int paramInt)
  {
    this.c.setText(paramInt);
    this.d = b.a(this.c).a().b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/LoadingPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */