package com.mobike.mobikeapp.activity.customer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.bridge.c;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.widget.LoadingPageView;

public class CustomerServiceWebActivity
  extends BaseActivity
{
  public static final String a = "com.mobike.intent.customerservice.extra.url";
  public static final String b = "com.mobike.intent.customerservice.extra.title";
  private String e;
  @BindView(a=2131755751)
  LoadingPageView loadingPageView;
  @BindView(a=2131755782)
  View unavailableView;
  @BindView(a=2131755199)
  WebView webView;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new Intent(paramContext, CustomerServiceWebActivity.class);
    paramContext.putExtra("com.mobike.intent.customerservice.extra.title", paramString1);
    paramContext.putExtra("com.mobike.intent.customerservice.extra.url", paramString2);
    return paramContext;
  }
  
  private void a()
  {
    this.webView.setInitialScale(0);
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.getSettings().setDomStorageEnabled(true);
    this.webView.getSettings().setJavaScriptEnabled(true);
    WebView localWebView;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.webView.getSettings().setMixedContentMode(2);
      this.webView.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          CustomerServiceWebActivity.this.loadingPageView.b();
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          CustomerServiceWebActivity.this.loadingPageView.a();
        }
        
        public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
        {
          paramAnonymousSslErrorHandler.proceed();
        }
      });
      localWebView = this.webView;
      localObject = new WebChromeClient()
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          if (100 == paramAnonymousInt) {
            CustomerServiceWebActivity.this.loadingPageView.b();
          }
          while (h.g(CustomerServiceWebActivity.this)) {
            return;
          }
          CustomerServiceWebActivity.this.loadingPageView.b();
          CustomerServiceWebActivity.this.unavailableView.setVisibility(0);
        }
      };
      if ((localWebView instanceof WebView)) {
        break label165;
      }
      localWebView.setWebChromeClient((WebChromeClient)localObject);
    }
    for (;;)
    {
      this.webView.addJavascriptInterface(new c(this), "app");
      this.webView.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          CustomerServiceWebActivity.this.loadingPageView.b();
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          CustomerServiceWebActivity.this.loadingPageView.a();
        }
        
        public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
        {
          paramAnonymousSslErrorHandler.proceed();
        }
      });
      localWebView = this.webView;
      localObject = new WebChromeClient()
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          if (100 == paramAnonymousInt) {
            CustomerServiceWebActivity.this.loadingPageView.b();
          }
          for (;;)
          {
            super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
            return;
            if (!h.g(CustomerServiceWebActivity.this))
            {
              CustomerServiceWebActivity.this.loadingPageView.b();
              CustomerServiceWebActivity.this.unavailableView.setVisibility(0);
            }
          }
        }
      };
      if ((localWebView instanceof WebView)) {
        break;
      }
      localWebView.setWebChromeClient((WebChromeClient)localObject);
      return;
      label165:
      VdsAgent.setWebChromeClient((WebView)localWebView, (WebChromeClient)localObject);
    }
    VdsAgent.setWebChromeClient((WebView)localWebView, (WebChromeClient)localObject);
  }
  
  public void onBackPressed()
  {
    if (this.webView.canGoBack())
    {
      this.webView.goBack();
      return;
    }
    super.onBackPressed();
  }
  
  @OnClick(a={2131755782})
  public void onClickUnavailable(View paramView)
  {
    if (h.g(this))
    {
      this.loadingPageView.a();
      paramView.setVisibility(8);
      if (!TextUtils.isEmpty(this.webView.getUrl())) {
        this.webView.reload();
      }
    }
    else
    {
      return;
    }
    this.webView.loadUrl(this.e);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968614);
    ButterKnife.a(this);
    a();
    Intent localIntent = getIntent();
    paramBundle = localIntent.getStringExtra("com.mobike.intent.customerservice.extra.title");
    this.e = localIntent.getStringExtra("com.mobike.intent.customerservice.extra.url");
    if (!TextUtils.isEmpty(paramBundle)) {}
    for (;;)
    {
      setTitle(paramBundle);
      if (h.g(this))
      {
        this.webView.loadUrl(this.e);
        this.loadingPageView.a();
        this.unavailableView.setVisibility(8);
      }
      return;
      paramBundle = getString(2131296504);
    }
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    if (paramMenuItem.getItemId() == 16908332)
    {
      if (this.webView.canGoBack()) {
        this.webView.goBack();
      }
      for (;;)
      {
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
        finish();
      }
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    VdsAgent.handleClickResult(new Boolean(bool));
    return bool;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/CustomerServiceWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */