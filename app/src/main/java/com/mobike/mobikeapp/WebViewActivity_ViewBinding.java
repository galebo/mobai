package com.mobike.mobikeapp;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.ShareView;

public class WebViewActivity_ViewBinding
  implements Unbinder
{
  private WebViewActivity b;
  private View c;
  
  @ao
  public WebViewActivity_ViewBinding(WebViewActivity paramWebViewActivity)
  {
    this(paramWebViewActivity, paramWebViewActivity.getWindow().getDecorView());
  }
  
  @ao
  public WebViewActivity_ViewBinding(final WebViewActivity paramWebViewActivity, View paramView)
  {
    this.b = paramWebViewActivity;
    paramWebViewActivity.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
    View localView = d.a(paramView, 2131755782, "field 'unavailableView' and method 'onClickUnavailable'");
    paramWebViewActivity.unavailableView = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramWebViewActivity.onClickUnavailable(paramAnonymousView);
      }
    });
    paramWebViewActivity.webView = ((WebView)d.b(paramView, 2131755419, "field 'webView'", WebView.class));
    paramWebViewActivity.mShareContent = ((LinearLayout)d.b(paramView, 2131755278, "field 'mShareContent'", LinearLayout.class));
    paramWebViewActivity.overlayBg = ((FrameLayout)d.b(paramView, 2131755277, "field 'overlayBg'", FrameLayout.class));
    paramWebViewActivity.shareView = ((ShareView)d.b(paramView, 2131755245, "field 'shareView'", ShareView.class));
    paramWebViewActivity.toolbarRightTextview = ((TextView)d.b(paramView, 2131755925, "field 'toolbarRightTextview'", TextView.class));
  }
  
  @i
  public void a()
  {
    WebViewActivity localWebViewActivity = this.b;
    if (localWebViewActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localWebViewActivity.loadingPageView = null;
    localWebViewActivity.unavailableView = null;
    localWebViewActivity.webView = null;
    localWebViewActivity.mShareContent = null;
    localWebViewActivity.overlayBg = null;
    localWebViewActivity.shareView = null;
    localWebViewActivity.toolbarRightTextview = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/WebViewActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */