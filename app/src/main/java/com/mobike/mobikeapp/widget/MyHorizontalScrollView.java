package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedList;

public class MyHorizontalScrollView
  extends HorizontalScrollView
  implements View.OnClickListener
{
  private a a;
  private b b;
  private LinearLayout c;
  private TextView d;
  private int e = 90;
  private int f;
  private int g;
  private e h;
  private int i = 3;
  private int j;
  private int k = 15;
  private int l = 7;
  private int m = 30;
  private int n = 10;
  private int o = 0;
  private float p = 0.7F;
  private int q;
  private LinkedList<View> r = new LinkedList();
  
  public MyHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = (WindowManager)paramContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.j = (paramAttributeSet.widthPixels - com.mobike.mobikeapp.model.c.h.a(getContext(), this.e * this.i + 60));
    this.n = (this.j / (this.i * 2));
    setHorizontalScrollBarEnabled(false);
  }
  
  private void c(int paramInt)
  {
    int i1 = 200;
    postDelayed(h.a(this, paramInt), 100L);
    if (Math.abs(this.q - paramInt) > 1) {
      i1 = (int)('È' * this.p * Math.abs(this.q - paramInt));
    }
    this.q = paramInt;
    post(i.a(this, paramInt, i1));
  }
  
  protected void a()
  {
    if (this.f == this.h.a() - 1) {}
    do
    {
      return;
      scrollTo(0, 0);
      this.r.remove(this.c.getChildAt(0));
      this.c.removeViewAt(0);
      Object localObject = this.h;
      int i1 = this.f + 1;
      this.f = i1;
      localObject = ((e)localObject).a(i1, null, this.c);
      ((View)localObject).setOnClickListener(this);
      this.c.addView((View)localObject);
      this.r.add(localObject);
      this.g += 1;
    } while (this.a == null);
    c();
  }
  
  public void a(int paramInt)
  {
    this.c = ((LinearLayout)findViewById(2131755621));
    this.c.removeAllViews();
    this.r.clear();
    Object localObject = new FrameLayout.LayoutParams(com.mobike.mobikeapp.model.c.h.a(getContext(), this.e), (int)TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics()), 1);
    this.d = ((TextView)findViewById(2131755620));
    ((FrameLayout.LayoutParams)localObject).gravity = 3;
    ((FrameLayout.LayoutParams)localObject).leftMargin = (com.mobike.mobikeapp.model.c.h.a(getContext(), this.k) + this.n);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setTranslationX(0.0F);
    int i1 = 0;
    if (i1 < paramInt)
    {
      localObject = this.h.a(i1, null, this.c);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.mobike.mobikeapp.model.c.h.a(getContext(), this.e), (int)TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics()), 1.0F);
      if (i1 == 0) {}
      for (localLayoutParams.leftMargin = (com.mobike.mobikeapp.model.c.h.a(getContext(), this.k) + this.n);; localLayoutParams.leftMargin = this.n)
      {
        localLayoutParams.rightMargin = this.n;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setOnClickListener(this);
        this.c.addView((View)localObject);
        this.r.add(i1, localObject);
        this.f = i1;
        i1 += 1;
        break;
      }
    }
    if (this.a != null) {
      c();
    }
    c(this.o);
  }
  
  public void a(e parame)
  {
    this.h = parame;
    a(parame.a());
  }
  
  public View b(int paramInt)
  {
    return (View)this.r.get(paramInt);
  }
  
  protected void b()
  {
    if (this.g == 0) {}
    do
    {
      int i1;
      do
      {
        return;
        i1 = this.f - this.i;
      } while (i1 < 0);
      int i2 = this.c.getChildCount() - 1;
      this.r.remove(this.c.getChildAt(i2));
      this.c.removeViewAt(i2);
      View localView = this.h.a(i1, null, this.c);
      this.r.add(localView);
      this.c.addView(localView, 0);
      localView.setOnClickListener(this);
      scrollTo(this.e, 0);
      this.f -= 1;
      this.g -= 1;
    } while (this.a == null);
    c();
  }
  
  public void c()
  {
    int i1 = 0;
    while (i1 < this.c.getChildCount())
    {
      this.c.getChildAt(i1).setBackgroundColor(0);
      i1 += 1;
    }
    this.a.a(this.g, this.c.getChildAt(0));
    this.c.getChildAt(0).setSelected(true);
  }
  
  public int getChildWidth()
  {
    return this.e;
  }
  
  public int getViewPosSize()
  {
    return this.r.size();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i1 = 0;
    while (i1 < this.c.getChildCount())
    {
      this.c.getChildAt(i1).setBackgroundColor(0);
      i1 += 1;
    }
    if (this.b != null) {
      this.b.a(paramView, this.r.indexOf(paramView));
    }
    c(this.r.indexOf(paramView));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c = ((LinearLayout)findViewById(2131755621));
  }
  
  public void setChildMargin(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setCurrentImageChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public void setLeftMargin(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void setRightMargin(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setSelectItem(int paramInt)
  {
    this.o = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/MyHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */