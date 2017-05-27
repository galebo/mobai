package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.support.annotation.ak;
import android.support.annotation.p;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.model.c.h;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShareView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  public static final int g = 64;
  private static final int h = 70;
  private LinearLayout i;
  private a j;
  private Context k;
  
  public ShareView(Context paramContext)
  {
    super(paramContext);
    this.k = paramContext;
  }
  
  public ShareView(Context paramContext, @ac AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.k = paramContext;
  }
  
  @ab
  private FrameLayout a(int paramInt1, @p int paramInt2, @ak int paramInt3)
  {
    int m = h.a(getContext(), 70.0F);
    Object localObject = new LinearLayout.LayoutParams(0, -2, 1.0F);
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new FrameLayout.LayoutParams(m, m);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    Button localButton = new Button(getContext(), null, 2131427572);
    localButton.setGravity(1);
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localButton.setBackgroundColor(getResources().getColor(17170445));
    localButton.setCompoundDrawablesWithIntrinsicBounds(0, paramInt2, 0, 0);
    localButton.setText(paramInt3);
    localButton.setTextColor(getResources().getColor(17170444));
    localButton.setTextSize(12.0F);
    localButton.setTag(Integer.valueOf(paramInt1));
    localButton.setOnClickListener(this);
    localFrameLayout.addView(localButton);
    return localFrameLayout;
  }
  
  public void a(int paramInt)
  {
    this.i = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2130968832, this, false));
    removeAllViews();
    addView(this.i);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), new Pair(Integer.valueOf(2130838210), Integer.valueOf(2131297075)));
    localHashMap.put(Integer.valueOf(2), new Pair(Integer.valueOf(2130838211), Integer.valueOf(2131297073)));
    localHashMap.put(Integer.valueOf(4), new Pair(Integer.valueOf(2130838206), Integer.valueOf(2131297064)));
    localHashMap.put(Integer.valueOf(8), new Pair(Integer.valueOf(2130838207), Integer.valueOf(2131297065)));
    localHashMap.put(Integer.valueOf(16), new Pair(Integer.valueOf(2130838208), Integer.valueOf(2131297067)));
    localHashMap.put(Integer.valueOf(32), new Pair(Integer.valueOf(2130838205), Integer.valueOf(2131297051)));
    localHashMap.put(Integer.valueOf(64), new Pair(Integer.valueOf(2130838209), Integer.valueOf(2131297070)));
    Iterator localIterator = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(64) }).iterator();
    while (localIterator.hasNext())
    {
      int m = ((Integer)localIterator.next()).intValue();
      if ((paramInt & m) > 0)
      {
        Object localObject = (Pair)localHashMap.get(Integer.valueOf(m));
        localObject = a(m, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
        this.i.addView((View)localObject);
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.j == null) {
      throw new IllegalStateException("Share listener is not set!");
    }
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 1: 
      this.j.a(this, SHARE_MEDIA.WEIXIN);
      return;
    case 2: 
      this.j.a(this, SHARE_MEDIA.WEIXIN_CIRCLE);
      return;
    case 4: 
      this.j.a(this, SHARE_MEDIA.QQ);
      return;
    case 8: 
      this.j.a(this, SHARE_MEDIA.QZONE);
      return;
    case 16: 
      this.j.a(this, SHARE_MEDIA.SINA);
      return;
    case 32: 
      this.j.a(this, SHARE_MEDIA.FACEBOOK);
      return;
    }
    this.j.a(this, SHARE_MEDIA.TWITTER);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), h.a(getContext(), 70.0F));
  }
  
  public void setOnShareListener(a parama)
  {
    this.j = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, SHARE_MEDIA paramSHARE_MEDIA);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/ShareView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */