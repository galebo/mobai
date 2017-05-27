package com.mobike.mobikeapp.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.ac;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baidu.middleware.GeoRange;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.util.e;

public class UnlockButton
  extends LinearLayout
  implements View.OnClickListener
{
  private View a;
  private a b;
  @BindView(a=2131755734)
  ImageView mQrcodeImage;
  @BindView(a=2131755733)
  ImageView mTreasureImage;
  
  public UnlockButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public UnlockButton(Context paramContext, @ac AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public UnlockButton(Context paramContext, @ac AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.mTreasureImage.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mQrcodeImage, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator1.setDuration(1200L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(2);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mTreasureImage, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator2.setDuration(1200L);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.start();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968766, this, false);
    addView(paramContext);
    paramContext.findViewById(2131755732).setOnClickListener(this);
  }
  
  private void b()
  {
    this.mTreasureImage.setAlpha(0.0F);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.b != null) {
      this.b.b(this);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.a(this);
    if ((e.a().j()) && (GeoRange.inCHINA()))
    {
      a();
      return;
    }
    b();
  }
  
  public void setOnUnlockClickListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(View paramView);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/UnlockButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */