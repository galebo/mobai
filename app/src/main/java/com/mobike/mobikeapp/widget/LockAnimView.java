package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.bumptech.glide.g;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.l;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.o;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.util.RideManager;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class LockAnimView
  extends RelativeLayout
{
  private static final int a = 25;
  private static final long b = 800L;
  private static final int c = 5;
  private static final long d = 1000L;
  private static final float e = 100.0F / (float)(RideManager.b() / 1000L);
  private float f;
  private a g;
  private ImageView h;
  private ImageView i;
  private CountDownTimer j;
  private ProgressBar k;
  private TextView l;
  private TextSwitcher m;
  private boolean n;
  private ArrayList<String> o;
  private int p = 0;
  private AnimationDrawable q;
  private long r;
  
  public LockAnimView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LockAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LockAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String getNextTips()
  {
    int i1 = this.p + 1;
    this.p = i1;
    if (i1 >= this.o.size()) {
      this.p = 0;
    }
    return (String)this.o.get(this.p);
  }
  
  public void a()
  {
    this.h = ((ImageView)findViewById(2131755949));
    this.i = ((ImageView)findViewById(2131755950));
    this.k = ((ProgressBar)findViewById(2131755951));
    this.l = ((TextView)findViewById(2131755952));
    this.m = ((TextSwitcher)findViewById(2131755953));
    this.o = new ArrayList(Arrays.asList(getResources().getStringArray(2131689474)));
    Collections.shuffle(this.o);
    this.m.setFactory(new ViewSwitcher.ViewFactory()
    {
      public View makeView()
      {
        TextView localTextView = new TextView(LockAnimView.this.getContext());
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        localTextView.setTextSize(12.0F);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setTextColor(ContextCompat.getColor(LockAnimView.this.getContext(), 2131624129));
        return localTextView;
      }
    });
    this.m.setInAnimation(AnimationUtils.loadAnimation(getContext(), 2131034122));
    this.m.setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2131034169));
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.n = true;
    this.r = System.currentTimeMillis();
    this.h.setVisibility(0);
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing()))
    {
      l.a(paramBaseActivity).a(Integer.valueOf(2130838305)).p().a(DiskCacheStrategy.SOURCE).a(this.h);
      this.f = 0.0F;
      setProgress((int)this.f);
      this.j = new CountDownTimer(RideManager.b(), 1000L)
      {
        public void onFinish() {}
        
        public void onTick(long paramAnonymousLong)
        {
          LockAnimView.a(LockAnimView.this, LockAnimView.a(LockAnimView.this) + LockAnimView.h());
          LockAnimView.this.setProgress((int)LockAnimView.a(LockAnimView.this));
          if ((int)(paramAnonymousLong / 1000L) % 5 == 0)
          {
            if (LockAnimView.b(LockAnimView.this) != null) {
              break label76;
            }
            if (LockAnimView.c(LockAnimView.this) != null) {
              LockAnimView.c(LockAnimView.this).onFinish();
            }
          }
          label76:
          while (LockAnimView.b(LockAnimView.this) == null) {
            return;
          }
          LockAnimView.b(LockAnimView.this).setText(LockAnimView.d(LockAnimView.this));
        }
      }.start();
      this.k.setVisibility(0);
      this.l.setVisibility(0);
      this.m.setVisibility(0);
    }
  }
  
  public void b()
  {
    if (this.j != null) {
      this.j.cancel();
    }
    this.m.setVisibility(8);
    this.n = false;
    int i1 = (int)((System.currentTimeMillis() - this.r) / 1000L);
    MobclickAgent.a(getContext(), "90010", null, i1);
    this.j = new CountDownTimer(800L, 25L)
    {
      public void onFinish()
      {
        LockAnimView.this.setProgress(100);
        LockAnimView.e(LockAnimView.this).setVisibility(8);
        LockAnimView.f(LockAnimView.this).setBackgroundResource(2130838301);
        LockAnimView.f(LockAnimView.this).setVisibility(0);
        ((AnimationDrawable)LockAnimView.f(LockAnimView.this).getBackground()).start();
        new Timer().schedule(new TimerTask()
        {
          public void run()
          {
            ((AnimationDrawable)LockAnimView.f(LockAnimView.this).getBackground()).stop();
            LockAnimView.a(LockAnimView.this, false);
            if (LockAnimView.g(LockAnimView.this) != null) {
              LockAnimView.g(LockAnimView.this).a();
            }
          }
        }, 1000L);
      }
      
      public void onTick(long paramAnonymousLong)
      {
        LockAnimView.a(LockAnimView.this, LockAnimView.a(LockAnimView.this) + this.a);
        LockAnimView.this.setProgress((int)LockAnimView.a(LockAnimView.this));
      }
    }.start();
  }
  
  public void c()
  {
    this.h.setVisibility(8);
    setVisibility(4);
    this.n = false;
    if (this.j != null) {
      this.j.cancel();
    }
  }
  
  public void d()
  {
    setVisibility(0);
    setProgress(0);
  }
  
  public void e()
  {
    this.g = null;
    if (this.j != null) {
      this.j.cancel();
    }
    this.m.removeAllViews();
  }
  
  public boolean f()
  {
    return this.n;
  }
  
  public void g()
  {
    this.q = ((AnimationDrawable)this.i.getBackground());
    if (this.q != null)
    {
      int i2 = this.q.getNumberOfFrames();
      int i1 = 0;
      while (i1 < i2)
      {
        Drawable localDrawable = this.q.getFrame(i1);
        if (((localDrawable instanceof BitmapDrawable)) && (!((BitmapDrawable)localDrawable).getBitmap().isRecycled())) {
          ((BitmapDrawable)localDrawable).getBitmap().recycle();
        }
        localDrawable.setCallback(null);
        i1 += 1;
      }
      this.q.setCallback(null);
      this.q = null;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public void setOnAnimationEndListener(a parama)
  {
    this.g = parama;
  }
  
  public void setProgress(int paramInt)
  {
    this.k.setProgress(paramInt);
    if (this.l != null)
    {
      if (paramInt < 100) {
        this.l.setText(String.format(getResources().getString(2131297098), new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    else {
      return;
    }
    this.l.setText(2131297099);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/LockAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */