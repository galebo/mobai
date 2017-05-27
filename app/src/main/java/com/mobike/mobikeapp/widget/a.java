package com.mobike.mobikeapp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.model.c.h;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class a
  extends PopupWindow
  implements View.OnClickListener
{
  private static final String a = "CustomShareBoard";
  private ShareAction b;
  private Activity c;
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
    this.c = paramActivity;
    this.b = new ShareAction(paramActivity);
    a(paramActivity);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130968849, null);
    paramContext.findViewById(2131755926).setOnClickListener(this);
    paramContext.findViewById(2131755927).setOnClickListener(this);
    paramContext.findViewById(2131755930).setOnClickListener(this);
    paramContext.findViewById(2131755929).setOnClickListener(this);
    setContentView(paramContext);
    setWidth(-1);
    setHeight(-2);
    setFocusable(true);
    setBackgroundDrawable(new BitmapDrawable());
    setTouchable(true);
  }
  
  private void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    this.b.setCallback(new UMShareListener()
    {
      public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        h.a(a.a(a.this), paramAnonymousSHARE_MEDIA.toString() + "分享取消了");
      }
      
      public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
      {
        h.a(a.a(a.this), paramAnonymousSHARE_MEDIA.toString() + "平台分享失败");
      }
      
      public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        h.a(a.a(a.this), paramAnonymousSHARE_MEDIA.toString() + "平台分享成功");
      }
      
      public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131755928: 
    default: 
      return;
    case 2131755926: 
      a(SHARE_MEDIA.WEIXIN);
      return;
    case 2131755927: 
      a(SHARE_MEDIA.WEIXIN_CIRCLE);
      return;
    case 2131755930: 
      a(SHARE_MEDIA.SINA);
      return;
    }
    a(SHARE_MEDIA.QZONE);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */