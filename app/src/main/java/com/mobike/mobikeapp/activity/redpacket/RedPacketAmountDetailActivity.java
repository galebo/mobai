package com.mobike.mobikeapp.activity.redpacket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.RequestParams;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.model.c.f;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.y;
import com.mobike.mobikeapp.widget.ShareView;
import com.mobike.mobikeapp.widget.j;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Locale;

public class RedPacketAmountDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int a;
  private LinearLayout b;
  private Animation e;
  private Animation f;
  private boolean g;
  private UMShareListener h;
  
  private void a()
  {
    this.b = ((LinearLayout)findViewById(2131755324));
    this.b.setVisibility(8);
    this.b.setBackgroundColor(-1);
    this.e = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 1, 1.0F);
    this.e.setInterpolator(new AccelerateDecelerateInterpolator());
    this.e.setDuration(250L);
    this.f = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 1.0F, 1, 0.0F);
    this.f.setInterpolator(new AccelerateDecelerateInterpolator());
    this.f.setDuration(250L);
    this.h = new UMShareListener()
    {
      public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
      
      public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable) {}
      
      public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        if (MyApplication.b > f.a().o())
        {
          new j(RedPacketAmountDetailActivity.this, "30033", "30031", "30032").show();
          RedPacketAmountDetailActivity.this.finish();
        }
      }
      
      public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
    };
    ShareView localShareView = (ShareView)findViewById(2131755245);
    localShareView.a(31);
    localShareView.setOnShareListener(d.a(this));
  }
  
  private void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {
      return;
    }
    y.a().a(this, getString(2131296976, new Object[] { String.valueOf(this.a / 100.0F) }), getString(2131296977), d(), "", this.h);
    y.a().a(paramSHARE_MEDIA);
  }
  
  private void b()
  {
    this.g = true;
    this.b.setVisibility(0);
    this.b.startAnimation(this.f);
  }
  
  private void b(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {
      return;
    }
    y.a().a(this, getString(2131296977), paramSHARE_MEDIA, this.h);
    c();
  }
  
  private void c()
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    this.b.startAnimation(this.e);
    this.b.setVisibility(8);
  }
  
  private String d()
  {
    String str = com.mobike.mobikeapp.c.a.A();
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    localRequestParams.put("p", this.a);
    return str + "?" + localRequestParams.toString();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @OnClick(a={2131755322, 2131755323, 2131755320})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131755321: 
    default: 
      return;
    case 2131755323: 
      b();
      return;
    case 2131755322: 
      h.b(paramView.getContext(), MyRedPocketActivity.class);
      return;
    }
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968639);
    ButterKnife.a(this);
    this.a = getIntent().getIntExtra("red_packet_value", 0);
    a();
    h.a(String.valueOf(this.a / 100.0F), (TextView)findViewById(2131755321), this);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/RedPacketAmountDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */