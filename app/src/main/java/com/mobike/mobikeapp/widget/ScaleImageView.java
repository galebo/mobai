package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.mobike.mobikeapp.R.styleable;

public class ScaleImageView
  extends ImageView
{
  private float a = 0.0F;
  
  public ScaleImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ScaleImageView_Style);
    paramContext.recycle();
  }
  
  public ScaleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (0.0F == this.a)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if ((i == 1073741824) && (m != 1073741824)) {
      i = View.MeasureSpec.makeMeasureSpec(Math.round(k * this.a), 1073741824);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, i);
      return;
      if ((i != 1073741824) && (m == 1073741824))
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.round(j / this.a), 1073741824);
        i = paramInt2;
      }
      else if (k != 0)
      {
        i = View.MeasureSpec.makeMeasureSpec(Math.round(k * this.a), 1073741824);
      }
      else
      {
        i = paramInt2;
        if (j != 0)
        {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.round(j / this.a), 1073741824);
          i = paramInt2;
        }
      }
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/ScaleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */