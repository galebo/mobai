package com.mobike.mobikeapp.activity.customer;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingPageView;

public class CustomerServiceWebActivity_ViewBinding
  implements Unbinder
{
  private CustomerServiceWebActivity b;
  private View c;
  
  @ao
  public CustomerServiceWebActivity_ViewBinding(CustomerServiceWebActivity paramCustomerServiceWebActivity)
  {
    this(paramCustomerServiceWebActivity, paramCustomerServiceWebActivity.getWindow().getDecorView());
  }
  
  @ao
  public CustomerServiceWebActivity_ViewBinding(final CustomerServiceWebActivity paramCustomerServiceWebActivity, View paramView)
  {
    this.b = paramCustomerServiceWebActivity;
    paramCustomerServiceWebActivity.webView = ((WebView)d.b(paramView, 2131755199, "field 'webView'", WebView.class));
    View localView = d.a(paramView, 2131755782, "field 'unavailableView' and method 'onClickUnavailable'");
    paramCustomerServiceWebActivity.unavailableView = localView;
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramCustomerServiceWebActivity.onClickUnavailable(paramAnonymousView);
      }
    });
    paramCustomerServiceWebActivity.loadingPageView = ((LoadingPageView)d.b(paramView, 2131755751, "field 'loadingPageView'", LoadingPageView.class));
  }
  
  @i
  public void a()
  {
    CustomerServiceWebActivity localCustomerServiceWebActivity = this.b;
    if (localCustomerServiceWebActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localCustomerServiceWebActivity.webView = null;
    localCustomerServiceWebActivity.unavailableView = null;
    localCustomerServiceWebActivity.loadingPageView = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/CustomerServiceWebActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */