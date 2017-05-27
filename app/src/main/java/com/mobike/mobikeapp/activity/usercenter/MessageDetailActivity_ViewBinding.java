package com.mobike.mobikeapp.activity.usercenter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingPageView;

public class MessageDetailActivity_ViewBinding
  implements Unbinder
{
  private MessageDetailActivity b;
  private View c;
  
  @ao
  public MessageDetailActivity_ViewBinding(MessageDetailActivity paramMessageDetailActivity)
  {
    this(paramMessageDetailActivity, paramMessageDetailActivity.getWindow().getDecorView());
  }
  
  @ao
  public MessageDetailActivity_ViewBinding(final MessageDetailActivity paramMessageDetailActivity, View paramView)
  {
    this.b = paramMessageDetailActivity;
    paramMessageDetailActivity.webView = ((WebView)d.b(paramView, 2131755276, "field 'webView'", WebView.class));
    View localView = d.a(paramView, 2131755782, "field 'unavailableView' and method 'onClickUnavailable'");
    paramMessageDetailActivity.unavailableView = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMessageDetailActivity.onClickUnavailable(paramAnonymousView);
      }
    });
    paramMessageDetailActivity.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
    paramMessageDetailActivity.mShareContent = ((LinearLayout)d.b(paramView, 2131755278, "field 'mShareContent'", LinearLayout.class));
    paramMessageDetailActivity.overlayBg = ((FrameLayout)d.b(paramView, 2131755277, "field 'overlayBg'", FrameLayout.class));
  }
  
  @i
  public void a()
  {
    MessageDetailActivity localMessageDetailActivity = this.b;
    if (localMessageDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localMessageDetailActivity.webView = null;
    localMessageDetailActivity.unavailableView = null;
    localMessageDetailActivity.loadingPageView = null;
    localMessageDetailActivity.mShareContent = null;
    localMessageDetailActivity.overlayBg = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MessageDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */