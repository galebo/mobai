package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ab;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bumptech.glide.f;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.bumptech.glide.o;
import com.mobike.mobikeapp.R.styleable;
import com.mobike.mobikeapp.model.c.h;
import com.umeng.socialize.utils.c;

public class HintCardView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private ImageButton d;
  private ImageView e;
  private float f = 30.0F;
  private float g = 18.0F;
  
  public HintCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HintCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HintCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject1 = inflate(paramContext, 2130968855, this);
    this.a = ((TextView)((View)localObject1).findViewById(2131755970));
    this.b = ((TextView)((View)localObject1).findViewById(2131755971));
    this.c = ((TextView)((View)localObject1).findViewById(2131755972));
    this.d = ((ImageButton)((View)localObject1).findViewById(2131755973));
    this.e = ((ImageView)((View)localObject1).findViewById(2131755969));
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131755968);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HintCardView_Style);
    this.f = paramAttributeSet.getDimension(5, this.f);
    this.g = paramAttributeSet.getDimension(6, this.g);
    float f1 = paramAttributeSet.getDimension(8, -2.0F);
    this.a.setTextColor(paramAttributeSet.getColor(2, -16777216));
    this.b.setTextColor(paramAttributeSet.getColor(3, -7829368));
    if (f1 != -2.0F)
    {
      c.b("topViewHeight = " + f1);
      ((LinearLayout)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, h.a(paramContext, f1)));
    }
    localObject2 = new RelativeLayout.LayoutParams(h.a(paramContext, this.f), h.a(paramContext, this.f));
    int i = (int)((this.f - this.g) / 2.0F + 0.5D);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, h.a(paramContext, i), h.a(paramContext, i), 0);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if (paramAttributeSet.hasValue(7))
    {
      i = paramAttributeSet.getResourceId(7, 0);
      if (i != 0)
      {
        localObject1 = (LinearLayout)((View)localObject1).findViewById(2131755967);
        ((LinearLayout)localObject1).addView(LayoutInflater.from(paramContext).inflate(i, (ViewGroup)localObject1, false));
      }
    }
    paramAttributeSet.recycle();
  }
  
  public void a()
  {
    this.d.setVisibility(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)paramFloat1, (int)(paramFloat1 * paramFloat2 + 0.5F));
    localLayoutParams.setMargins(h.a(getContext(), 5.0F), h.a(getContext(), 5.0F), h.a(getContext(), 5.0F), h.a(getContext(), 5.0F));
    localLayoutParams.gravity = 17;
    this.e.setLayoutParams(localLayoutParams);
    this.e.setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.a.setText(paramString1);
    this.b.setText(paramString2);
    this.e.setImageResource(paramInt);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.a.setText(paramString1);
    this.b.setText(paramString2);
    this.e.setImageBitmap(paramBitmap);
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable)
  {
    this.a.setText(paramString1);
    this.b.setText(paramString2);
    this.e.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a.setText(paramString1);
    this.b.setText(paramString2);
    l.c(getContext().getApplicationContext()).a(paramString3).d(2130837716).e().a(this.e);
    if (!TextUtils.isEmpty(paramString4))
    {
      this.c.setText(paramString4);
      return;
    }
    paramString1 = new LinearLayout.LayoutParams(-1, h.a(getContext(), 40.0F));
    this.c.setLayoutParams(paramString1);
  }
  
  public void b()
  {
    this.d.setVisibility(4);
  }
  
  public void c()
  {
    this.d.setVisibility(0);
  }
  
  public void d()
  {
    this.d.setVisibility(8);
  }
  
  public void setColseOnclickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setContentOnclickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setJumpOnclickListener(@ab View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitleOnclickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.a.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/HintCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */