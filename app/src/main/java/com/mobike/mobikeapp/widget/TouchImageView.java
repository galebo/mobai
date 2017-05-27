package com.mobike.mobikeapp.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;

public class TouchImageView
  extends ImageView
{
  private static final String a = "DEBUG";
  private static final float b = 0.75F;
  private static final float c = 1.25F;
  private ScaleGestureDetector A;
  private GestureDetector B;
  private GestureDetector.OnDoubleTapListener C = null;
  private View.OnTouchListener D = null;
  private e E = null;
  private float d;
  private Matrix e;
  private Matrix f;
  private h g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float[] l;
  private Context m;
  private c n;
  private ImageView.ScaleType o;
  private boolean p;
  private boolean q;
  private i r;
  private int s;
  private int t;
  private int u;
  private int v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    case 1073741824: 
    default: 
      return paramInt2;
    case -2147483648: 
      return Math.min(paramInt3, paramInt2);
    }
    return paramInt3;
  }
  
  private PointF a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.e.getValues(this.l);
    float f4 = getDrawable().getIntrinsicWidth();
    float f3 = getDrawable().getIntrinsicHeight();
    float f1 = this.l[2];
    float f2 = this.l[5];
    f1 = (paramFloat1 - f1) * f4 / getImageWidth();
    f2 = (paramFloat2 - f2) * f3 / getImageHeight();
    paramFloat2 = f2;
    paramFloat1 = f1;
    if (paramBoolean)
    {
      paramFloat1 = Math.min(Math.max(f1, 0.0F), f4);
      paramFloat2 = Math.min(Math.max(f2, 0.0F), f3);
    }
    return new PointF(paramFloat1, paramFloat2);
  }
  
  private void a(double paramDouble, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f2;
    float f1;
    float f3;
    if (paramBoolean)
    {
      f2 = this.j;
      f1 = this.k;
      f3 = this.d;
      this.d = ((float)(this.d * paramDouble));
      if (this.d <= f1) {
        break label93;
      }
      this.d = f1;
      paramDouble = f1 / f3;
    }
    for (;;)
    {
      this.e.postScale((float)paramDouble, (float)paramDouble, paramFloat1, paramFloat2);
      e();
      return;
      f2 = this.h;
      f1 = this.i;
      break;
      label93:
      if (this.d < f2)
      {
        this.d = f2;
        paramDouble = f2 / f3;
      }
    }
  }
  
  private void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramFloat3 < paramInt3)
    {
      this.l[paramInt1] = ((paramInt3 - paramInt4 * this.l[0]) * 0.5F);
      return;
    }
    if (paramFloat1 > 0.0F)
    {
      this.l[paramInt1] = (-((paramFloat3 - paramInt3) * 0.5F));
      return;
    }
    paramFloat1 = (Math.abs(paramFloat1) + paramInt2 * 0.5F) / paramFloat2;
    this.l[paramInt1] = (-(paramFloat1 * paramFloat3 - paramInt3 * 0.5F));
  }
  
  private void a(Context paramContext)
  {
    super.setClickable(true);
    this.m = paramContext;
    this.A = new ScaleGestureDetector(paramContext, new g(null));
    this.B = new GestureDetector(paramContext, new d(null));
    this.e = new Matrix();
    this.f = new Matrix();
    this.l = new float[9];
    this.d = 1.0F;
    if (this.o == null) {
      this.o = ImageView.ScaleType.FIT_CENTER;
    }
    this.h = 1.0F;
    this.i = 3.0F;
    this.j = (0.75F * this.h);
    this.k = (1.25F * this.i);
    setImageMatrix(this.e);
    setScaleType(ImageView.ScaleType.MATRIX);
    setState(h.a);
    this.q = false;
    super.setOnTouchListener(new f(null));
  }
  
  @TargetApi(16)
  private void a(Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimation(paramRunnable);
      return;
    }
    postDelayed(paramRunnable, 16L);
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    if (paramFloat3 <= paramFloat2)
    {
      paramFloat2 -= paramFloat3;
      paramFloat3 = 0.0F;
      if (paramFloat1 >= paramFloat3) {
        break label37;
      }
      paramFloat3 = -paramFloat1 + paramFloat3;
    }
    label37:
    do
    {
      return paramFloat3;
      paramFloat3 = paramFloat2 - paramFloat3;
      paramFloat2 = 0.0F;
      break;
      paramFloat3 = f1;
    } while (paramFloat1 <= paramFloat2);
    return -paramFloat1 + paramFloat2;
  }
  
  private PointF b(float paramFloat1, float paramFloat2)
  {
    this.e.getValues(this.l);
    float f2 = getDrawable().getIntrinsicWidth();
    float f1 = getDrawable().getIntrinsicHeight();
    paramFloat1 /= f2;
    paramFloat2 /= f1;
    f1 = this.l[2];
    f2 = getImageWidth();
    float f3 = this.l[5];
    return new PointF(paramFloat1 * f2 + f1, paramFloat2 * getImageHeight() + f3);
  }
  
  private float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 <= paramFloat2) {
      paramFloat1 = 0.0F;
    }
    return paramFloat1;
  }
  
  private void c()
  {
    if ((this.e != null) && (this.t != 0) && (this.s != 0))
    {
      this.e.getValues(this.l);
      this.f.setValues(this.l);
      this.z = this.x;
      this.y = this.w;
      this.v = this.t;
      this.u = this.s;
    }
  }
  
  private void d()
  {
    this.e.getValues(this.l);
    float f2 = this.l[2];
    float f1 = this.l[5];
    f2 = b(f2, this.s, getImageWidth());
    f1 = b(f1, this.t, getImageHeight());
    if ((f2 != 0.0F) || (f1 != 0.0F)) {
      this.e.postTranslate(f2, f1);
    }
  }
  
  private void e()
  {
    d();
    this.e.getValues(this.l);
    if (getImageWidth() < this.s) {
      this.l[2] = ((this.s - getImageWidth()) / 2.0F);
    }
    if (getImageHeight() < this.t) {
      this.l[5] = ((this.t - getImageHeight()) / 2.0F);
    }
    this.e.setValues(this.l);
  }
  
  private void f()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0)) {}
    while ((this.e == null) || (this.f == null)) {
      return;
    }
    int i1 = localDrawable.getIntrinsicWidth();
    int i2 = localDrawable.getIntrinsicHeight();
    float f4 = this.s / i1;
    float f5 = this.t / i2;
    float f1 = f5;
    float f2 = f4;
    float f6 = f5;
    float f3 = f4;
    switch (1.a[this.o.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    case 1: 
      f1 = 1.0F;
      f2 = 1.0F;
    case 5: 
      f3 = this.s - i1 * f2;
      f4 = this.t - i2 * f1;
      this.w = (this.s - f3);
      this.x = (this.t - f4);
      if ((!a()) && (!this.p))
      {
        this.e.setScale(f2, f1);
        this.e.postTranslate(f3 / 2.0F, f4 / 2.0F);
        this.d = 1.0F;
      }
      break;
    }
    for (;;)
    {
      d();
      setImageMatrix(this.e);
      return;
      f1 = Math.max(f4, f5);
      f2 = f1;
      break;
      f6 = Math.min(1.0F, Math.min(f4, f5));
      f3 = f6;
      f1 = Math.min(f3, f6);
      f2 = f1;
      break;
      if ((this.y == 0.0F) || (this.z == 0.0F)) {
        c();
      }
      this.f.getValues(this.l);
      this.l[0] = (this.w / i1 * this.d);
      this.l[4] = (this.x / i2 * this.d);
      f1 = this.l[2];
      f2 = this.l[5];
      f3 = this.y;
      a(2, f1, this.d * f3, getImageWidth(), this.u, this.s, i1);
      a(5, f2, this.z * this.d, getImageHeight(), this.v, this.t, i2);
      this.e.setValues(this.l);
    }
  }
  
  private void g()
  {
    float[] arrayOfFloat = new float[9];
    this.e.getValues(arrayOfFloat);
    Log.d("DEBUG", "Scale: " + arrayOfFloat[0] + " TransX: " + arrayOfFloat[2] + " TransY: " + arrayOfFloat[5]);
  }
  
  private float getImageHeight()
  {
    return this.x * this.d;
  }
  
  private float getImageWidth()
  {
    return this.w * this.d;
  }
  
  private void setState(h paramh)
  {
    this.g = paramh;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.d, paramFloat1, paramFloat2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramFloat3, this.o);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
  {
    if (!this.q)
    {
      this.r = new i(paramFloat1, paramFloat2, paramFloat3, paramScaleType);
      return;
    }
    if (paramScaleType != this.o) {
      setScaleType(paramScaleType);
    }
    b();
    a(paramFloat1, this.s / 2, this.t / 2, true);
    this.e.getValues(this.l);
    this.l[2] = (-(getImageWidth() * paramFloat2 - this.s * 0.5F));
    this.l[5] = (-(getImageHeight() * paramFloat3 - this.t * 0.5F));
    this.e.setValues(this.l);
    d();
    setImageMatrix(this.e);
  }
  
  public boolean a()
  {
    return this.d != 1.0F;
  }
  
  public boolean a(int paramInt)
  {
    return canScrollHorizontally(paramInt);
  }
  
  public void b()
  {
    this.d = 1.0F;
    f();
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    this.e.getValues(this.l);
    float f1 = this.l[2];
    if (getImageWidth() < this.s) {}
    while (((f1 >= -1.0F) && (paramInt < 0)) || ((Math.abs(f1) + this.s + 1.0F >= getImageWidth()) && (paramInt > 0))) {
      return false;
    }
    return true;
  }
  
  public float getCurrentZoom()
  {
    return this.d;
  }
  
  public float getMaxZoom()
  {
    return this.i;
  }
  
  public float getMinZoom()
  {
    return this.h;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.o;
  }
  
  public PointF getScrollPosition()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return null;
    }
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = ((Drawable)localObject).getIntrinsicHeight();
    localObject = a(this.s / 2, this.t / 2, true);
    ((PointF)localObject).x /= i1;
    ((PointF)localObject).y /= i2;
    return (PointF)localObject;
  }
  
  public RectF getZoomedRect()
  {
    if (this.o == ImageView.ScaleType.FIT_XY) {
      throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }
    PointF localPointF1 = a(0.0F, 0.0F, true);
    PointF localPointF2 = a(this.s, this.t, true);
    float f1 = getDrawable().getIntrinsicWidth();
    float f2 = getDrawable().getIntrinsicHeight();
    return new RectF(localPointF1.x / f1, localPointF1.y / f2, localPointF2.x / f1, localPointF2.y / f2);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.q = true;
    this.p = true;
    if (this.r != null)
    {
      a(this.r.a, this.r.b, this.r.c, this.r.d);
      this.r = null;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int i1 = localDrawable.getIntrinsicWidth();
    int i2 = localDrawable.getIntrinsicHeight();
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    this.s = a(paramInt1, i3, i1);
    this.t = a(paramInt2, i4, i2);
    setMeasuredDimension(this.s, this.t);
    f();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.d = paramParcelable.getFloat("saveScale");
      this.l = paramParcelable.getFloatArray("matrix");
      this.f.setValues(this.l);
      this.z = paramParcelable.getFloat("matchViewHeight");
      this.y = paramParcelable.getFloat("matchViewWidth");
      this.v = paramParcelable.getInt("viewHeight");
      this.u = paramParcelable.getInt("viewWidth");
      this.p = paramParcelable.getBoolean("imageRendered");
      super.onRestoreInstanceState(paramParcelable.getParcelable("instanceState"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putFloat("saveScale", this.d);
    localBundle.putFloat("matchViewHeight", this.x);
    localBundle.putFloat("matchViewWidth", this.w);
    localBundle.putInt("viewWidth", this.s);
    localBundle.putInt("viewHeight", this.t);
    this.e.getValues(this.l);
    localBundle.putFloatArray("matrix", this.l);
    localBundle.putBoolean("imageRendered", this.p);
    return localBundle;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    c();
    f();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    c();
    f();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    c();
    f();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    c();
    f();
  }
  
  public void setMaxZoom(float paramFloat)
  {
    this.i = paramFloat;
    this.k = (1.25F * this.i);
  }
  
  public void setMinZoom(float paramFloat)
  {
    this.h = paramFloat;
    this.j = (0.75F * this.h);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.C = paramOnDoubleTapListener;
  }
  
  public void setOnTouchImageViewListener(e parame)
  {
    this.E = parame;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.D = paramOnTouchListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.FIT_START) || (paramScaleType == ImageView.ScaleType.FIT_END)) {
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    }
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      super.setScaleType(ImageView.ScaleType.MATRIX);
    }
    do
    {
      return;
      this.o = paramScaleType;
    } while (!this.q);
    setZoom(this);
  }
  
  public void setZoom(float paramFloat)
  {
    a(paramFloat, 0.5F, 0.5F);
  }
  
  public void setZoom(TouchImageView paramTouchImageView)
  {
    PointF localPointF = paramTouchImageView.getScrollPosition();
    a(paramTouchImageView.getCurrentZoom(), localPointF.x, localPointF.y, paramTouchImageView.getScaleType());
  }
  
  @TargetApi(9)
  private class a
  {
    Scroller a;
    OverScroller b;
    boolean c;
    
    public a(Context paramContext)
    {
      if (Build.VERSION.SDK_INT < 9)
      {
        this.c = true;
        this.a = new Scroller(paramContext);
        return;
      }
      this.c = false;
      this.b = new OverScroller(paramContext);
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (this.c)
      {
        this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
        return;
      }
      this.b.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void a(boolean paramBoolean)
    {
      if (this.c)
      {
        this.a.forceFinished(paramBoolean);
        return;
      }
      this.b.forceFinished(paramBoolean);
    }
    
    public boolean a()
    {
      if (this.c) {
        return this.a.isFinished();
      }
      return this.b.isFinished();
    }
    
    public boolean b()
    {
      if (this.c) {
        return this.a.computeScrollOffset();
      }
      this.b.computeScrollOffset();
      return this.b.computeScrollOffset();
    }
    
    public int c()
    {
      if (this.c) {
        return this.a.getCurrX();
      }
      return this.b.getCurrX();
    }
    
    public int d()
    {
      if (this.c) {
        return this.a.getCurrY();
      }
      return this.b.getCurrY();
    }
  }
  
  private class b
    implements Runnable
  {
    private static final float c = 500.0F;
    private long b;
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private AccelerateDecelerateInterpolator i = new AccelerateDecelerateInterpolator();
    private PointF j;
    private PointF k;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.e);
      this.b = System.currentTimeMillis();
      this.d = TouchImageView.d(TouchImageView.this);
      this.e = paramFloat1;
      this.h = paramBoolean;
      PointF localPointF = TouchImageView.a(TouchImageView.this, paramFloat2, paramFloat3, false);
      this.f = localPointF.x;
      this.g = localPointF.y;
      this.j = TouchImageView.a(TouchImageView.this, this.f, this.g);
      this.k = new PointF(TouchImageView.i(TouchImageView.this) / 2, TouchImageView.k(TouchImageView.this) / 2);
    }
    
    private float a()
    {
      float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.b) / 500.0F);
      return this.i.getInterpolation(f1);
    }
    
    private void a(float paramFloat)
    {
      float f1 = this.j.x;
      float f2 = this.k.x;
      float f3 = this.j.x;
      float f4 = this.j.y;
      float f5 = this.k.y;
      float f6 = this.j.y;
      PointF localPointF = TouchImageView.a(TouchImageView.this, this.f, this.g);
      TouchImageView.m(TouchImageView.this).postTranslate(f1 + (f2 - f3) * paramFloat - localPointF.x, f4 + (f5 - f6) * paramFloat - localPointF.y);
    }
    
    private double b(float paramFloat)
    {
      return (this.d + (this.e - this.d) * paramFloat) / TouchImageView.d(TouchImageView.this);
    }
    
    public void run()
    {
      float f1 = a();
      double d1 = b(f1);
      TouchImageView.a(TouchImageView.this, d1, this.f, this.g, this.h);
      a(f1);
      TouchImageView.q(TouchImageView.this);
      TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this).a();
      }
      if (f1 < 1.0F)
      {
        TouchImageView.a(TouchImageView.this, this);
        return;
      }
      TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
    }
  }
  
  private class c
    implements Runnable
  {
    TouchImageView.a a;
    int b;
    int c;
    
    c(int paramInt1, int paramInt2)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.d);
      this.a = new TouchImageView.a(TouchImageView.this, TouchImageView.r(TouchImageView.this));
      TouchImageView.m(TouchImageView.this).getValues(TouchImageView.s(TouchImageView.this));
      int i = (int)TouchImageView.s(TouchImageView.this)[2];
      int j = (int)TouchImageView.s(TouchImageView.this)[5];
      int k;
      int m;
      int n;
      int i1;
      if (TouchImageView.j(TouchImageView.this) > TouchImageView.i(TouchImageView.this))
      {
        k = TouchImageView.i(TouchImageView.this) - (int)TouchImageView.j(TouchImageView.this);
        m = 0;
        if (TouchImageView.l(TouchImageView.this) <= TouchImageView.k(TouchImageView.this)) {
          break label162;
        }
        n = TouchImageView.k(TouchImageView.this) - (int)TouchImageView.l(TouchImageView.this);
        i1 = 0;
      }
      for (;;)
      {
        this.a.a(i, j, paramInt1, paramInt2, k, m, n, i1);
        this.b = i;
        this.c = j;
        return;
        m = i;
        k = i;
        break;
        label162:
        i1 = j;
        n = j;
      }
    }
    
    public void a()
    {
      if (this.a != null)
      {
        TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
        this.a.a(true);
      }
    }
    
    public void run()
    {
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this).a();
      }
      if (this.a.a()) {
        this.a = null;
      }
      while (!this.a.b()) {
        return;
      }
      int i = this.a.c();
      int j = this.a.d();
      int k = this.b;
      int m = this.c;
      this.b = i;
      this.c = j;
      TouchImageView.m(TouchImageView.this).postTranslate(i - k, j - m);
      TouchImageView.n(TouchImageView.this);
      TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
      TouchImageView.a(TouchImageView.this, this);
    }
  }
  
  private class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {}
      for (boolean bool = TouchImageView.a(TouchImageView.this).onDoubleTap(paramMotionEvent);; bool = false)
      {
        if (TouchImageView.c(TouchImageView.this) == TouchImageView.h.a) {
          if (TouchImageView.d(TouchImageView.this) != TouchImageView.e(TouchImageView.this)) {
            break label97;
          }
        }
        label97:
        for (float f = TouchImageView.f(TouchImageView.this);; f = TouchImageView.e(TouchImageView.this))
        {
          paramMotionEvent = new TouchImageView.b(TouchImageView.this, f, paramMotionEvent.getX(), paramMotionEvent.getY(), false);
          TouchImageView.a(TouchImageView.this, paramMotionEvent);
          bool = true;
          return bool;
        }
      }
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {
        return TouchImageView.a(TouchImageView.this).onDoubleTapEvent(paramMotionEvent);
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (TouchImageView.b(TouchImageView.this) != null) {
        TouchImageView.b(TouchImageView.this).a();
      }
      TouchImageView.a(TouchImageView.this, new TouchImageView.c(TouchImageView.this, (int)paramFloat1, (int)paramFloat2));
      TouchImageView.a(TouchImageView.this, TouchImageView.b(TouchImageView.this));
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      TouchImageView.this.performLongClick();
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {
        return TouchImageView.a(TouchImageView.this).onSingleTapConfirmed(paramMotionEvent);
      }
      return TouchImageView.this.performClick();
    }
  }
  
  public static abstract interface e
  {
    public abstract void a();
  }
  
  private class f
    implements View.OnTouchListener
  {
    private PointF b = new PointF();
    
    private f() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      TouchImageView.g(TouchImageView.this).onTouchEvent(paramMotionEvent);
      TouchImageView.h(TouchImageView.this).onTouchEvent(paramMotionEvent);
      PointF localPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((TouchImageView.c(TouchImageView.this) == TouchImageView.h.a) || (TouchImageView.c(TouchImageView.this) == TouchImageView.h.b) || (TouchImageView.c(TouchImageView.this) == TouchImageView.h.d)) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      for (;;)
      {
        TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
        if (TouchImageView.o(TouchImageView.this) != null) {
          TouchImageView.o(TouchImageView.this).onTouch(paramView, paramMotionEvent);
        }
        if (TouchImageView.p(TouchImageView.this) != null) {
          TouchImageView.p(TouchImageView.this).a();
        }
        return true;
        this.b.set(localPointF);
        if (TouchImageView.b(TouchImageView.this) != null) {
          TouchImageView.b(TouchImageView.this).a();
        }
        TouchImageView.a(TouchImageView.this, TouchImageView.h.b);
        continue;
        if (TouchImageView.c(TouchImageView.this) == TouchImageView.h.b)
        {
          float f3 = localPointF.x;
          float f4 = this.b.x;
          float f1 = localPointF.y;
          float f2 = this.b.y;
          f3 = TouchImageView.a(TouchImageView.this, f3 - f4, TouchImageView.i(TouchImageView.this), TouchImageView.j(TouchImageView.this));
          f1 = TouchImageView.a(TouchImageView.this, f1 - f2, TouchImageView.k(TouchImageView.this), TouchImageView.l(TouchImageView.this));
          TouchImageView.m(TouchImageView.this).postTranslate(f3, f1);
          TouchImageView.n(TouchImageView.this);
          this.b.set(localPointF.x, localPointF.y);
          continue;
          TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
        }
      }
    }
  }
  
  private class g
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private g() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.a(TouchImageView.this, paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), true);
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this).a();
      }
      return true;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.c);
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      super.onScaleEnd(paramScaleGestureDetector);
      TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
      int i = 0;
      float f = TouchImageView.d(TouchImageView.this);
      if (TouchImageView.d(TouchImageView.this) > TouchImageView.f(TouchImageView.this))
      {
        f = TouchImageView.f(TouchImageView.this);
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramScaleGestureDetector = new TouchImageView.b(TouchImageView.this, f, TouchImageView.i(TouchImageView.this) / 2, TouchImageView.k(TouchImageView.this) / 2, true);
          TouchImageView.a(TouchImageView.this, paramScaleGestureDetector);
        }
        return;
        if (TouchImageView.d(TouchImageView.this) < TouchImageView.e(TouchImageView.this))
        {
          f = TouchImageView.e(TouchImageView.this);
          i = 1;
        }
      }
    }
  }
  
  private static enum h
  {
    private h() {}
  }
  
  private class i
  {
    public float a;
    public float b;
    public float c;
    public ImageView.ScaleType d;
    
    public i(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramScaleType;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/TouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */