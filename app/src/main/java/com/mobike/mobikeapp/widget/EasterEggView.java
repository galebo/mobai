package com.mobike.mobikeapp.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.support.annotation.f;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.bumptech.glide.o;
import com.mobike.mobikeapp.data.OperationDataInfo.EasterEggConfig;
import com.mobike.mobikeapp.util.e;
import com.mobike.mobikeapp.widget.fllowerAnimation.FlowerAnimation;
import java.util.Locale;

public class EasterEggView
  extends FrameLayout
{
  TextView a;
  View b;
  ViewGroup c;
  ObjectAnimator d;
  int[] e;
  private ImageView f;
  private a g;
  private FlowerAnimation h;
  
  public EasterEggView(@ab Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EasterEggView(@ab Context paramContext, @ac AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EasterEggView(@ab Context paramContext, @ac AttributeSet paramAttributeSet, @f int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968770, null);
    b(paramContext);
    addView(paramContext);
    this.d = ObjectAnimator.ofFloat(this.b, "rotation", new float[] { -15.0F, 11.0F, -8.0F, 6.0F, -4.0F, 0.0F });
  }
  
  private void b()
  {
    this.h = new FlowerAnimation(getContext());
    this.c.addView(this.h);
  }
  
  private void b(View paramView)
  {
    setClickable(true);
    this.a = ((TextView)paramView.findViewById(2131755737));
    this.f = ((ImageView)paramView.findViewById(2131755739));
    this.b = paramView.findViewById(2131755738);
    this.c = ((ViewGroup)paramView.findViewById(2131755736));
    paramView.findViewById(2131755738).setOnClickListener(b.a(this));
    paramView.findViewById(2131755517).setOnClickListener(c.a(this));
    Object localObject = l.c(getContext());
    if (e.a().e() == null)
    {
      paramView = "";
      ((o)localObject).a(paramView).a(this.f);
      localObject = new SpannableStringBuilder();
      if (e.a().e() != null) {
        break label252;
      }
      paramView = getContext().getString(2131296535);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView)) {
        ((SpannableStringBuilder)localObject).append(paramView);
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131296540));
      if (!Locale.getDefault().getCountry().equals(Locale.CHINA.getLanguage())) {
        localSpannableStringBuilder.append(" ");
      }
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), 2131624078)), 0, paramView.length(), 34);
      this.a.setText(localSpannableStringBuilder.append((CharSequence)localObject));
      b();
      return;
      paramView = e.a().e().mLogoImage;
      break;
      label252:
      if (e.a().e().firstdescr == null) {
        paramView = "";
      } else {
        paramView = e.a().e().firstdescr;
      }
    }
  }
  
  private void c()
  {
    if ((this.d != null) && (this.d.isRunning())) {
      this.d.cancel();
    }
    setVisibility(8);
  }
  
  private void d()
  {
    this.b.setPivotX(this.b.getWidth() / 2);
    this.b.setPivotY(this.b.getHeight());
    this.d.setStartDelay(200L);
    this.d.setDuration(3000L);
    this.d.setRepeatCount(-1);
    this.d.setInterpolator(new LinearOutSlowInInterpolator());
    this.d.setRepeatMode(1);
    this.d.start();
  }
  
  public void a()
  {
    new Handler().post(d.a(this));
    this.b.animate().translationY(0.0F).setDuration(500L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        EasterEggView.a(EasterEggView.this);
      }
    }).start();
  }
  
  public void a(View paramView)
  {
    if (this.g != null) {
      this.g.a();
    }
    c();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b.setRotationX(this.b.getWidth() / 2);
    this.b.setRotationY(this.b.getHeight());
  }
  
  public void setListener(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/EasterEggView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */