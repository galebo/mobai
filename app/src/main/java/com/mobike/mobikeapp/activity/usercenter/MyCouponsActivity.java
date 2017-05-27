package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
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
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.c.a;
import com.mobike.mobikeapp.model.a.b;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingPageView;
import org.greenrobot.eventbus.c;

public class MyCouponsActivity
  extends BaseActivity
{
  private static final int a = 1;
  @BindView(a=2131755751)
  LoadingPageView loadingPageView;
  @BindView(a=2131755782)
  View unavailableView;
  @BindView(a=2131755194)
  WebView webView;
  
  private void a()
  {
    this.webView.setInitialScale(0);
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.getSettings().setDomStorageEnabled(true);
    this.webView.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 21) {
      this.webView.getSettings().setMixedContentMode(2);
    }
    this.webView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        MyCouponsActivity.this.loadingPageView.b();
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        MyCouponsActivity.this.loadingPageView.a();
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        paramAnonymousSslErrorHandler.proceed();
      }
    });
    WebView localWebView = this.webView;
    WebChromeClient local2 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (100 == paramAnonymousInt) {
          MyCouponsActivity.this.loadingPageView.b();
        }
        for (;;)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          return;
          if (!h.g(MyCouponsActivity.this))
          {
            MyCouponsActivity.this.loadingPageView.b();
            MyCouponsActivity.this.unavailableView.setVisibility(0);
          }
        }
      }
    };
    if (!(localWebView instanceof WebView))
    {
      localWebView.setWebChromeClient(local2);
      return;
    }
    VdsAgent.setWebChromeClient((WebView)localWebView, local2);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (!q.a().b()) {
        break label55;
      }
      if (h.g(this))
      {
        this.webView.loadUrl(a.q());
        this.loadingPageView.a();
        this.unavailableView.setVisibility(8);
      }
    }
    return;
    label55:
    finish();
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
    this.webView.loadUrl(a.q());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968610);
    ButterKnife.a(this);
    a();
    setTitle(getString(2131296692));
    if (q.a().b())
    {
      if (h.g(this))
      {
        this.webView.loadUrl(a.q());
        this.loadingPageView.a();
        this.unavailableView.setVisibility(8);
      }
      return;
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820546, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    c.a().d(new b());
    super.onDestroy();
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default: 
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    case 16908332: 
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
    startActivity(CustomerServiceWebActivity.a(this, getString(2131296386), a.r()));
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MyCouponsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */