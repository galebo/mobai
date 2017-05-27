package com.mobike.mobikeapp.activity.riding;

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

public class TripDetailActivity_ViewBinding
  implements Unbinder
{
  private TripDetailActivity b;
  private View c;
  
  @ao
  public TripDetailActivity_ViewBinding(TripDetailActivity paramTripDetailActivity)
  {
    this(paramTripDetailActivity, paramTripDetailActivity.getWindow().getDecorView());
  }
  
  @ao
  public TripDetailActivity_ViewBinding(final TripDetailActivity paramTripDetailActivity, View paramView)
  {
    this.b = paramTripDetailActivity;
    paramTripDetailActivity.webView = ((WebView)d.b(paramView, 2131755393, "field 'webView'", WebView.class));
    View localView = d.a(paramView, 2131755782, "field 'unavailableView' and method 'onClickUnavailable'");
    paramTripDetailActivity.unavailableView = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramTripDetailActivity.onClickUnavailable(paramAnonymousView);
      }
    });
    paramTripDetailActivity.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
    paramTripDetailActivity.mShareContent = ((LinearLayout)d.b(paramView, 2131755278, "field 'mShareContent'", LinearLayout.class));
    paramTripDetailActivity.overlayBg = ((FrameLayout)d.b(paramView, 2131755277, "field 'overlayBg'", FrameLayout.class));
  }
  
  @i
  public void a()
  {
    TripDetailActivity localTripDetailActivity = this.b;
    if (localTripDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localTripDetailActivity.webView = null;
    localTripDetailActivity.unavailableView = null;
    localTripDetailActivity.loadingPageView = null;
    localTripDetailActivity.mShareContent = null;
    localTripDetailActivity.overlayBg = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/TripDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */