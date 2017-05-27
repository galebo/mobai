package com.mobike.mobikeapp.activity.usercenter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingPageView;

public class MyCouponsActivity_ViewBinding
  implements Unbinder
{
  private MyCouponsActivity b;
  private View c;
  
  @ao
  public MyCouponsActivity_ViewBinding(MyCouponsActivity paramMyCouponsActivity)
  {
    this(paramMyCouponsActivity, paramMyCouponsActivity.getWindow().getDecorView());
  }
  
  @ao
  public MyCouponsActivity_ViewBinding(final MyCouponsActivity paramMyCouponsActivity, View paramView)
  {
    this.b = paramMyCouponsActivity;
    paramMyCouponsActivity.webView = ((WebView)d.b(paramView, 2131755194, "field 'webView'", WebView.class));
    View localView = d.a(paramView, 2131755782, "field 'unavailableView' and method 'onClickUnavailable'");
    paramMyCouponsActivity.unavailableView = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyCouponsActivity.onClickUnavailable(paramAnonymousView);
      }
    });
    paramMyCouponsActivity.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
  }
  
  @i
  public void a()
  {
    MyCouponsActivity localMyCouponsActivity = this.b;
    if (localMyCouponsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localMyCouponsActivity.webView = null;
    localMyCouponsActivity.unavailableView = null;
    localMyCouponsActivity.loadingPageView = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MyCouponsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */