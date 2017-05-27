package com.mobike.mobikeapp.model.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.l;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.d;

public class c
  implements f<Bitmap>
{
  private static final int i = 2;
  int a;
  int b;
  private com.bumptech.glide.load.engine.a.c c;
  private Matrix d = new Matrix();
  private Bitmap e;
  private final RectF f = new RectF();
  private final RectF g = new RectF();
  private int h;
  
  public c(Context paramContext, int paramInt)
  {
    this(l.b(paramContext).c(), paramInt);
  }
  
  public c(com.bumptech.glide.load.engine.a.c paramc, int paramInt)
  {
    this.c = paramc;
    this.h = paramInt;
  }
  
  private void a(BitmapShader paramBitmapShader)
  {
    int k = Math.min(this.e.getWidth(), this.e.getHeight());
    int j = (this.e.getWidth() - k) / 2;
    k = (this.e.getHeight() - k) / 2;
    if ((j != 0) || (k != 0))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setTranslate(-j, -k);
      paramBitmapShader.setLocalMatrix(localMatrix);
    }
    paramBitmapShader.setLocalMatrix(this.d);
  }
  
  public k<Bitmap> a(k<Bitmap> paramk, int paramInt1, int paramInt2)
  {
    this.e = ((Bitmap)paramk.b());
    paramInt1 = Math.min(this.e.getWidth(), this.e.getHeight());
    this.a = this.e.getWidth();
    this.b = this.e.getHeight();
    Object localObject1 = this.c.a(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    paramk = (k<Bitmap>)localObject1;
    if (localObject1 == null) {
      paramk = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    }
    localObject1 = new Canvas(paramk);
    Object localObject2 = new BitmapShader(this.e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.g.set(0.0F, 0.0F, this.e.getWidth(), this.e.getHeight());
    this.f.set(this.g);
    a((BitmapShader)localObject2);
    Paint localPaint = new Paint();
    localPaint.setShader((Shader)localObject2);
    localPaint.setAntiAlias(true);
    float f1 = paramInt1 / 2.0F;
    ((Canvas)localObject1).drawCircle(f1, f1, f1, localPaint);
    localObject2 = new Paint();
    ((Paint)localObject2).setColor(this.h);
    ((Paint)localObject2).setStrokeWidth(2.0F);
    ((Paint)localObject2).setStyle(Paint.Style.STROKE);
    ((Paint)localObject2).setAntiAlias(true);
    ((Canvas)localObject1).drawCircle(f1, f1, f1 - 1.0F, (Paint)localObject2);
    return d.a(paramk, this.c);
  }
  
  public String a()
  {
    return "CropCircleTransformation";
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/model/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */