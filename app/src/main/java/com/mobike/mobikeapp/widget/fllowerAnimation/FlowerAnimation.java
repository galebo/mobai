package com.mobike.mobikeapp.widget.fllowerAnimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FlowerAnimation
  extends View
  implements ValueAnimator.AnimatorUpdateListener
{
  private static final Paint y = new Paint();
  int[] a = { ContextCompat.getColor(getContext(), 2131624051), ContextCompat.getColor(getContext(), 2131624052), ContextCompat.getColor(getContext(), 2131624053) };
  ObjectAnimator b;
  ObjectAnimator c;
  ObjectAnimator d;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private List<Flower> h = new ArrayList();
  private List<Flower> i = new ArrayList();
  private List<Flower> j = new ArrayList();
  private int k = 1500;
  private int l = 200;
  private int m = 8;
  private int n = 0;
  private int o = 0;
  private int p = 15;
  private float q = 0.2F;
  private int r = 28;
  private int s = 35;
  private int t = (int)TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics());
  private Paint u;
  private PathMeasure v = null;
  private float w = TypedValue.applyDimension(1, 60.0F, getResources().getDisplayMetrics());
  private String x = getClass().getSimpleName();
  
  static
  {
    y.setStyle(Paint.Style.FILL);
  }
  
  public FlowerAnimation(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    y.setColor(paramInt1);
    float f1 = paramInt2 / 2.0F;
    localCanvas.drawCircle(f1, f1, f1, y);
    return localBitmap;
  }
  
  private List<a> a(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    Random localRandom = new Random();
    int i1 = 0;
    while (i1 < this.p) {
      if (i1 == 0)
      {
        localArrayList.add(parama);
        i1 += 1;
      }
      else
      {
        a locala = new a(0.0F, 0.0F);
        if (localRandom.nextInt(100) % 2 == 0) {}
        for (parama.a += localRandom.nextInt(this.t);; parama.a -= localRandom.nextInt(this.t))
        {
          locala.b = ((int)(this.o / this.p * i1));
          localArrayList.add(locala);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(float paramFloat, List<Flower> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((Flower)paramList.next()).setValue(paramFloat);
    }
  }
  
  private void a(int paramInt1, List<Flower> paramList, int paramInt2)
  {
    int i1 = (int)(this.n * 3 / 4.0F);
    int i4 = this.n / paramInt1;
    int i5 = this.o / 2 / paramInt1;
    int i6 = (int)(this.o * 3 / 4.0F);
    Random localRandom = new Random();
    i1 = 0;
    while (i1 < paramInt1)
    {
      int i2 = localRandom.nextInt(this.r);
      Path localPath = new Path();
      int i3 = (localRandom.nextInt(i6) % (this.o - i5 + 1) + i5) / 2 + paramInt2;
      float f1 = i4 * (i2 + 1);
      i2 = i3;
      if (i3 > i6 / 2) {
        i2 = i6 / 2 - i1 * 4;
      }
      a(localPath, a(new a(f1, -i2)));
      Flower localFlower = new Flower();
      localFlower.setPath(localPath);
      localFlower.setResId(c(this.a[localRandom.nextInt(3)], (localRandom.nextInt(3) + 2) * this.m));
      paramList.add(localFlower);
      i1 += 1;
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.n = paramContext.getDefaultDisplay().getWidth();
    this.o = ((int)(paramContext.getDefaultDisplay().getHeight() * 2.0F));
    this.u = new Paint();
    this.u.setAntiAlias(true);
    this.v = new PathMeasure();
    a(this.r, this.h, 0);
    a(this.s - this.r, this.i, this.o / 4);
    a(this.s - this.r, this.j, this.o / 4);
  }
  
  private void a(Canvas paramCanvas, List<Flower> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Flower localFlower = (Flower)paramList.next();
      float[] arrayOfFloat = new float[2];
      this.v.setPath(localFlower.getPath(), false);
      this.v.getPosTan(this.o * localFlower.getValue(), arrayOfFloat, null);
      paramCanvas.drawBitmap(localFlower.getResId(), arrayOfFloat[0], arrayOfFloat[1] - this.w, null);
    }
  }
  
  private void a(Path paramPath, List<a> paramList)
  {
    if (paramList.size() > 1)
    {
      int i1 = 0;
      if (i1 < paramList.size())
      {
        a locala1 = (a)paramList.get(i1);
        a locala2;
        if (i1 == 0)
        {
          locala2 = (a)paramList.get(i1 + 1);
          locala1.c = ((locala2.a - locala1.a) * this.q);
          locala1.d = ((locala2.b - locala1.b) * this.q);
          label99:
          if (i1 != 0) {
            break label275;
          }
          paramPath.moveTo(locala1.a, locala1.b);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (i1 == paramList.size() - 1)
          {
            locala2 = (a)paramList.get(i1 - 1);
            locala1.c = ((locala1.a - locala2.a) * this.q);
            locala1.d = ((locala1.b - locala2.b) * this.q);
            break label99;
          }
          locala2 = (a)paramList.get(i1 + 1);
          a locala3 = (a)paramList.get(i1 - 1);
          locala1.c = ((locala2.a - locala3.a) * this.q);
          locala1.d = ((locala2.b - locala3.b) * this.q);
          break label99;
          label275:
          locala2 = (a)paramList.get(i1 - 1);
          float f1 = locala2.a;
          float f2 = locala2.c;
          float f3 = locala2.b;
          paramPath.cubicTo(f1 + f2, locala2.d + f3, locala1.a - locala1.c, locala1.b - locala1.d, locala1.a, locala1.b);
        }
      }
    }
  }
  
  public static Bitmap b(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    y.setColor(paramInt1);
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(paramInt2, 0.0F);
    localPath.lineTo(paramInt2, paramInt2);
    localPath.lineTo(0.0F, paramInt2);
    localPath.close();
    localCanvas.drawPath(localPath, y);
    return localBitmap;
  }
  
  public static Bitmap c(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    y.setColor(paramInt1);
    Random localRandom = new Random();
    Path localPath = new Path();
    float f1 = (float)Math.tan((localRandom.nextInt(20) + 10) / 180.0F * 3.141592653589793D) * paramInt2;
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(paramInt2, f1);
    localPath.lineTo(f1, paramInt2);
    localPath.close();
    localCanvas.drawPath(localPath, y);
    return localBitmap;
  }
  
  public void a()
  {
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
    this.b = ObjectAnimator.ofFloat(this, "phase1", new float[] { 0.0F, 1.0F });
    this.b.setDuration(this.k * 3 / 2);
    this.b.addUpdateListener(this);
    this.b.setInterpolator(new AccelerateInterpolator());
    this.b.start();
    if ((this.c != null) && (this.c.isRunning())) {
      this.c.cancel();
    }
    this.c = ObjectAnimator.ofFloat(this, "phase2", new float[] { 0.0F, 1.0F });
    this.c.setDuration(this.k / 3 * 2);
    this.c.addUpdateListener(this);
    this.c.setStartDelay(this.l * 2);
    this.c.start();
    this.c.setInterpolator(new AccelerateDecelerateInterpolator());
    if ((this.d != null) && (this.d.isRunning())) {
      this.d.cancel();
    }
    this.d = ObjectAnimator.ofFloat(this, "phase3", new float[] { 0.0F, 1.0F });
    this.d.setDuration(this.k / 3);
    this.d.addUpdateListener(this);
    this.d.setInterpolator(new AccelerateInterpolator(2.0F));
    this.d.setStartDelay(this.l * 4);
    this.d.start();
  }
  
  public float getPhase1()
  {
    return this.e;
  }
  
  public float getPhase2()
  {
    return this.f;
  }
  
  public float getPhase3()
  {
    return this.g;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    a(getPhase1(), this.h);
    if ((this.c != null) && (this.c.isRunning())) {
      a(getPhase2(), this.i);
    }
    if ((this.d != null) && (this.d.isRunning())) {
      a(getPhase3(), this.j);
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas, this.h);
    if ((this.c != null) && (this.c.isRunning())) {
      a(paramCanvas, this.i);
    }
    if ((this.d != null) && (this.d.isRunning())) {
      a(paramCanvas, this.j);
    }
  }
  
  public void setPhase1(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void setPhase2(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setPhase3(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  private class a
  {
    public float a = 0.0F;
    public float b = 0.0F;
    public float c = 0.0F;
    public float d = 0.0F;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/fllowerAnimation/FlowerAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */