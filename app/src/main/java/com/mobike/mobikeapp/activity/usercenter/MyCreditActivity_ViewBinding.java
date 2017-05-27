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

public class MyCreditActivity_ViewBinding
  implements Unbinder
{
  private MyCreditActivity b;
  private View c;
  
  @ao
  public MyCreditActivity_ViewBinding(MyCreditActivity paramMyCreditActivity)
  {
    this(paramMyCreditActivity, paramMyCreditActivity.getWindow().getDecorView());
  }
  
  @ao
  public MyCreditActivity_ViewBinding(final MyCreditActivity paramMyCreditActivity, View paramView)
  {
    this.b = paramMyCreditActivity;
    paramMyCreditActivity.webView = ((WebView)d.b(paramView, 2131755195, "field 'webView'", WebView.class));
    View localView = d.a(paramView, 2131755782, "field 'unavailableView' and method 'onClickUnavailable'");
    paramMyCreditActivity.unavailableView = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramMyCreditActivity.onClickUnavailable(paramAnonymousView);
      }
    });
    paramMyCreditActivity.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
  }
  
  @i
  public void a()
  {
    MyCreditActivity localMyCreditActivity = this.b;
    if (localMyCreditActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localMyCreditActivity.webView = null;
    localMyCreditActivity.unavailableView = null;
    localMyCreditActivity.loadingPageView = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MyCreditActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */