package com.mobike.mobikeapp.widget;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.d;

public class TreasureWebView_ViewBinding
  implements Unbinder
{
  private TreasureWebView b;
  
  @ao
  public TreasureWebView_ViewBinding(TreasureWebView paramTreasureWebView)
  {
    this(paramTreasureWebView, paramTreasureWebView);
  }
  
  @ao
  public TreasureWebView_ViewBinding(TreasureWebView paramTreasureWebView, View paramView)
  {
    this.b = paramTreasureWebView;
    paramTreasureWebView.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
    paramTreasureWebView.unavailableView = d.a(paramView, 2131755782, "field 'unavailableView'");
    paramTreasureWebView.webView = ((WebView)d.b(paramView, 2131755419, "field 'webView'", WebView.class));
    paramTreasureWebView.mShareContent = ((LinearLayout)d.b(paramView, 2131755278, "field 'mShareContent'", LinearLayout.class));
    paramTreasureWebView.overlayBg = ((FrameLayout)d.b(paramView, 2131755277, "field 'overlayBg'", FrameLayout.class));
    paramTreasureWebView.shareView = ((ShareView)d.b(paramView, 2131755245, "field 'shareView'", ShareView.class));
    paramTreasureWebView.mTreasurePlaceHolder = ((SurprisePlaceholderView)d.b(paramView, 2131755747, "field 'mTreasurePlaceHolder'", SurprisePlaceholderView.class));
    paramTreasureWebView.mTreasurePlaceHolderLayout = ((RelativeLayout)d.b(paramView, 2131755746, "field 'mTreasurePlaceHolderLayout'", RelativeLayout.class));
  }
  
  @i
  public void a()
  {
    TreasureWebView localTreasureWebView = this.b;
    if (localTreasureWebView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localTreasureWebView.loadingPageView = null;
    localTreasureWebView.unavailableView = null;
    localTreasureWebView.webView = null;
    localTreasureWebView.mShareContent = null;
    localTreasureWebView.overlayBg = null;
    localTreasureWebView.shareView = null;
    localTreasureWebView.mTreasurePlaceHolder = null;
    localTreasureWebView.mTreasurePlaceHolderLayout = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/TreasureWebView_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */