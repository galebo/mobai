package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class DragViewLayout
  extends FrameLayout
{
  private ViewDragHelper a;
  private View b;
  private int c;
  private a d;
  private boolean e;
  private ViewDragHelper.Callback f = new ViewDragHelper.Callback()
  {
    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return DragViewLayout.a(DragViewLayout.this).getLeft();
    }
    
    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (DragViewLayout.b(DragViewLayout.this) != null) {
        DragViewLayout.b(DragViewLayout.this).b();
      }
      return paramAnonymousInt1;
    }
    
    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      if (DragViewLayout.b(DragViewLayout.this) == null) {
        return;
      }
      if (Math.abs(paramAnonymousView.getTop() - DragViewLayout.c(DragViewLayout.this)) > ViewConfiguration.get(DragViewLayout.this.getContext()).getScaledTouchSlop() * 3)
      {
        DragViewLayout.a locala = DragViewLayout.b(DragViewLayout.this);
        if (paramAnonymousView.getTop() < DragViewLayout.c(DragViewLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          locala.a(bool);
          return;
        }
      }
      DragViewLayout.d(DragViewLayout.this).smoothSlideViewTo(DragViewLayout.a(DragViewLayout.this), DragViewLayout.a(DragViewLayout.this).getLeft(), DragViewLayout.c(DragViewLayout.this));
      ViewCompat.postInvalidateOnAnimation(DragViewLayout.this);
      DragViewLayout.b(DragViewLayout.this).c();
    }
    
    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView == DragViewLayout.a(DragViewLayout.this);
    }
  };
  
  public DragViewLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DragViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DragViewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ViewDragHelper.create(this, this.f);
  }
  
  public void computeScroll()
  {
    if (this.a.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.c = this.b.getTop();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = getChildAt(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.shouldInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      float f1 = paramMotionEvent.getY();
      if (((f1 < this.b.getTop()) || (f1 > this.b.getTop() + this.b.getHeight())) && (this.d != null) && (!this.e))
      {
        this.e = true;
        this.d.d();
      }
    }
    this.a.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setmListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/DragViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */