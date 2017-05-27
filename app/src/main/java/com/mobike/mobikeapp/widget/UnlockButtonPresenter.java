package com.mobike.mobikeapp.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.ab;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UnlockButtonPresenter
{
  private View a;
  @BindView(a=2131755734)
  ImageView qrcodeImage;
  @BindView(a=2131755733)
  ImageView treasureImage;
  
  public UnlockButtonPresenter(@ab View paramView)
  {
    this.a = paramView;
    ButterKnife.a(this, paramView);
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.qrcodeImage, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator1.setDuration(1200L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(2);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.treasureImage, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator2.setDuration(1200L);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.start();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/UnlockButtonPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */