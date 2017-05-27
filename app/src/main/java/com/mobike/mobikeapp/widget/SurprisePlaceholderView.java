package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class SurprisePlaceholderView
  extends RelativeLayout
  implements View.OnClickListener
{
  private FrameLayout a;
  private a b;
  
  public SurprisePlaceholderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SurprisePlaceholderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SurprisePlaceholderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968845, this, false);
    addView(paramContext);
    this.a = ((FrameLayout)paramContext.findViewById(2131755924));
    this.a.setOnClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.b == null) {
      return;
    }
    this.b.a(this);
  }
  
  public void setOnCloseListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/SurprisePlaceholderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */