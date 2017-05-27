package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.support.annotation.ak;
import android.support.annotation.p;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmptyView
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private TextView c;
  
  public EmptyView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmptyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131755612));
    this.b = ((TextView)findViewById(2131755613));
    this.c = ((TextView)findViewById(2131755614));
  }
  
  public void setEmptyImg(@p int paramInt)
  {
    this.a.setImageResource(paramInt);
  }
  
  public void setEmptySubText(@ak int paramInt)
  {
    this.c.setText(paramInt);
    this.c.setVisibility(0);
  }
  
  public void setEmptyText(@ak int paramInt)
  {
    this.b.setText(paramInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/EmptyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */