package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AlertInfoBar
  extends LinearLayout
{
  private TextView a;
  private TextView b;
  
  public AlertInfoBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlertInfoBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlertInfoBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.b.setText(paramInt);
    this.b.setVisibility(0);
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131755431));
    this.b = ((TextView)findViewById(2131755432));
  }
  
  public void setAlertText(int paramInt)
  {
    this.a.setText(paramInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/AlertInfoBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */