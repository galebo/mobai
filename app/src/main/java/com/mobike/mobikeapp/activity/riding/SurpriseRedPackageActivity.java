package com.mobike.mobikeapp.activity.riding;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mobike.mobikeapp.widget.SurprisePlaceholderView;

public class SurpriseRedPackageActivity
  extends AppCompatActivity
{
  private float a;
  private float b;
  @BindView(a=2131755389)
  SurprisePlaceholderView imagePackageContent;
  @BindView(a=2131755391)
  ImageView imagePackageNotOpen;
  @BindView(a=2131755390)
  ImageView imagePackageOpen;
  @BindView(a=2131755392)
  Button openButton;
  @BindView(a=2131755388)
  ImageView packageMain;
  @BindView(a=2131755247)
  TextView subTitleTextView;
  @BindView(a=2131755117)
  TextView titleTextView;
  
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      Window localWindow = getWindow();
      localWindow.setFlags(67108864, 67108864);
      int i = (int)Math.ceil(25.0F * getResources().getDisplayMetrics().density);
      View localView = new View(this);
      localView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      localView.getLayoutParams().height = i;
      ((ViewGroup)localWindow.getDecorView()).addView(localView);
      localView.setBackgroundColor(-16777216);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    setResult(0);
    overridePendingTransition(17432576, 17432577);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968655);
    ButterKnife.a(this);
    a();
    paramBundle = getResources().getDisplayMetrics();
    this.a = paramBundle.heightPixels;
    this.b = paramBundle.widthPixels;
    this.imagePackageContent.setVisibility(8);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  @OnClick(a={2131755392})
  public void openRedPackage()
  {
    this.imagePackageNotOpen.setPivotY(0.0F);
    this.imagePackageNotOpen.setCameraDistance(10000.0F);
    float f = this.imagePackageOpen.getHeight();
    this.imagePackageOpen.setPivotY(f);
    this.imagePackageOpen.setCameraDistance(10000.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.imagePackageNotOpen, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(0L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.imagePackageNotOpen, "rotationX", new float[] { 0.0F, 70.0F });
    localObjectAnimator2.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator2.setDuration(300L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.titleTextView, "alpha", new float[] { 0.0F });
    localObjectAnimator3.setDuration(100L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.subTitleTextView, "alpha", new float[] { 0.0F });
    localObjectAnimator4.setDuration(100L);
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.imagePackageOpen, "rotationX", new float[] { 0.0F, -90.0F });
    localObjectAnimator2.setDuration(0L);
    localObjectAnimator3 = ObjectAnimator.ofFloat(this.imagePackageOpen, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setDuration(0L);
    localObjectAnimator4 = ObjectAnimator.ofFloat(this.imagePackageOpen, "rotationX", new float[] { -90.0F, 0.0F });
    localObjectAnimator4.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator4.setDuration(300L);
    Object localObject1 = ObjectAnimator.ofFloat(this.imagePackageContent, "alpha", new float[] { 0.0F, 1.0F });
    ((ObjectAnimator)localObject1).setDuration(300L);
    ((ObjectAnimator)localObject1).setInterpolator(new AccelerateInterpolator());
    Object localObject2 = ObjectAnimator.ofFloat(this.imagePackageContent, "Y", new float[] { 250.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.imagePackageContent, "scaleX", new float[] { 0.0F, 1.1F });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.imagePackageContent, "scaleY", new float[] { 0.0F, 1.2F });
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.imagePackageContent, "Z", new float[] { 500.0F });
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.setDuration(500L);
    localAnimatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet2.playTogether(new Animator[] { localObject1, localObjectAnimator7, localObject2, localObjectAnimator5, localObjectAnimator6 });
    localObject2 = ObjectAnimator.ofFloat(this.imagePackageNotOpen, "Y", new float[] { this.a + 270.0F });
    localObjectAnimator5 = ObjectAnimator.ofFloat(this.imagePackageOpen, "Y", new float[] { this.a });
    localObjectAnimator6 = ObjectAnimator.ofFloat(this.packageMain, "Y", new float[] { this.a + 250.0F });
    localObjectAnimator7 = ObjectAnimator.ofFloat(this.openButton, "Y", new float[] { this.a });
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.imagePackageNotOpen, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator8.setDuration(100L);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.imagePackageOpen, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator9.setDuration(100L);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.packageMain, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator10.setDuration(100L);
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(this.openButton, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator11.setDuration(100L);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).setDuration(500L);
    ((AnimatorSet)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObjectAnimator5, localObjectAnimator6, localObjectAnimator7, localObjectAnimator8, localObjectAnimator9, localObjectAnimator10, localObjectAnimator11 });
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localAnimatorSet2, localObject1 });
    localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playSequentially(new Animator[] { localAnimatorSet1, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObject2 });
    localAnimatorSet2.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SurpriseRedPackageActivity.this.setResult(-1);
        SurpriseRedPackageActivity.a(SurpriseRedPackageActivity.this);
        SurpriseRedPackageActivity.this.overridePendingTransition(17432576, 17432577);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localAnimatorSet2.start();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/SurpriseRedPackageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */