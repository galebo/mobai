package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.RideManager.RideState;

public class BottomPopupWindow
  extends PopupWindow
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private View e;
  
  public BottomPopupWindow(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968780, null);
    this.a = ((TextView)this.e.findViewById(2131755759));
    this.b = ((TextView)this.e.findViewById(2131755760));
    this.c = ((TextView)this.e.findViewById(2131755761));
    this.d = ((TextView)this.e.findViewById(2131755762));
    if (RideManager.a().u())
    {
      paramAttributeSet = ContextCompat.getDrawable(paramContext, 2130837927);
      paramAttributeSet.setBounds(0, 0, paramAttributeSet.getMinimumWidth(), paramAttributeSet.getMinimumHeight());
      this.a.setCompoundDrawables(null, paramAttributeSet, null, null);
      this.a.setText(paramContext.getString(2131296673));
    }
    for (;;)
    {
      setContentView(this.e);
      setWidth(h.m(paramContext) - h.a(paramContext, 10.0F) * 2);
      setHeight(-2);
      setFocusable(true);
      setTouchable(true);
      setOutsideTouchable(true);
      setBackgroundDrawable(new ColorDrawable(0));
      setAnimationStyle(2131427500);
      return;
      if (RideManager.a().h() == RideManager.RideState.LOCKED)
      {
        paramAttributeSet = ContextCompat.getDrawable(paramContext, 2130837914);
        paramAttributeSet.setBounds(0, 0, paramAttributeSet.getMinimumWidth(), paramAttributeSet.getMinimumHeight());
        this.a.setCompoundDrawables(null, paramAttributeSet, null, null);
        this.a.setText(paramContext.getString(2131297148));
      }
      else
      {
        paramAttributeSet = ContextCompat.getDrawable(paramContext, 2130837926);
        paramAttributeSet.setBounds(0, 0, paramAttributeSet.getMinimumWidth(), paramAttributeSet.getMinimumHeight());
        this.a.setCompoundDrawables(null, paramAttributeSet, null, null);
        this.a.setText(paramContext.getString(2131296654));
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
    this.b.setOnClickListener(paramOnClickListener);
    this.c.setOnClickListener(paramOnClickListener);
    this.d.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/BottomPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */