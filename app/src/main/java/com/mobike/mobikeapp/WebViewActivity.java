package com.mobike.mobikeapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ab;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.a.g;
import com.mobike.mobikeapp.bridge.c;
import com.mobike.mobikeapp.bridge.i;
import com.mobike.mobikeapp.bridge.i.a;
import com.mobike.mobikeapp.data.ShareInfo;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.ShareView;
import com.mobike.mobikeapp.widget.j;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class WebViewActivity
  extends BaseActivity
{
  protected static final int a = 1;
  protected static final int b = 31;
  protected static final int e = 96;
  public static final String f = "{\"userid\":\"%s\"}";
  protected ShareAction g = new ShareAction(this);
  protected UMShareListener h = new UMShareListener()
  {
    public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      com.mobike.mobikeapp.model.c.h.a(WebViewActivity.this, WebViewActivity.this.getString(2131296459));
    }
    
    public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
    {
      com.mobike.mobikeapp.model.c.h.a(WebViewActivity.this, WebViewActivity.this.getString(2131296575));
    }
    
    public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      if (MyApplication.b > com.mobike.mobikeapp.model.c.f.a().o()) {
        new j(WebViewActivity.this, "30023", "30021", "30022").show();
      }
      if (com.mobike.mobikeapp.model.c.f.a().g())
      {
        com.mobike.mobikeapp.a.f.a(WebViewActivity.this, new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymous2Int, String paramAnonymous2String)
          {
            if (paramAnonymous2Int == 200) {
              com.mobike.mobikeapp.model.c.f.a().c(9);
            }
            com.mobike.mobikeapp.model.c.h.a(WebViewActivity.this, paramAnonymous2String);
          }
          
          public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
          {
            paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new com.google.gson.e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
            com.mobike.mobikeapp.model.c.h.a(WebViewActivity.this, paramAnonymous2ArrayOfd.message);
            com.mobike.mobikeapp.model.c.f.a().c(9);
          }
        });
        return;
      }
      com.mobike.mobikeapp.model.c.h.a(WebViewActivity.this, WebViewActivity.this.getString(2131296986));
    }
    
    public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
  };
  private TranslateAnimation i;
  private TranslateAnimation j;
  private boolean k;
  private ShareInfo l;
  @BindView(a=2131755751)
  protected LoadingPageView loadingPageView;
  private i m;
  @BindView(a=2131755278)
  protected LinearLayout mShareContent;
  private com.mobike.mobikeapp.bridge.e n;
  private boolean o;
  @BindView(a=2131755277)
  protected FrameLayout overlayBg;
  private String p;
  private String q;
  @BindView(a=2131755245)
  protected ShareView shareView;
  @BindView(a=2131755925)
  protected TextView toolbarRightTextview;
  @BindView(a=2131755782)
  protected View unavailableView;
  @BindView(a=2131755419)
  protected WebView webView;
  
  public static Intent a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("mobike://home/web"));
    localIntent.putExtra("webview_title", paramString1);
    localIntent.putExtra("webview_url", paramString2);
    return localIntent;
  }
  
  private String a(@ab Uri paramUri)
  {
    if (TextUtils.isEmpty(paramUri.getQuery())) {}
    for (Object localObject = paramUri;; localObject = Uri.parse(paramUri.toString().replace(paramUri.getQuery(), "")))
    {
      localObject = ((Uri)localObject).buildUpon();
      if (q.a().b()) {
        ((Uri.Builder)localObject).appendQueryParameter("userid", q.a().d()).appendQueryParameter("accesstoken", q.a().c());
      }
      Iterator localIterator = paramUri.getQueryParameterNames().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!"userid".equals(str)) && (!"accesstoken".equals(str))) {
          ((Uri.Builder)localObject).appendQueryParameter(str, paramUri.getQueryParameter(str));
        }
      }
    }
    return ((Uri.Builder)localObject).toString();
  }
  
  protected void a()
  {
    this.m = new i.a().a(this.webView).a("close", new com.mobike.mobikeapp.bridge.a(this)).a("open", new com.mobike.mobikeapp.bridge.d(this)).a("share", ch.a(this)).a("login", ci.a(this)).a("logout", cj.a(this)).a();
    this.webView.setInitialScale(0);
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.setLayerType(2, null);
    Object localObject1 = this.webView.getSettings();
    if (localObject1 != null)
    {
      ((WebSettings)localObject1).setUseWideViewPort(true);
      ((WebSettings)localObject1).setLoadWithOverviewMode(true);
      ((WebSettings)localObject1).setDomStorageEnabled(true);
      ((WebSettings)localObject1).setAppCacheEnabled(true);
      ((WebSettings)localObject1).setDatabaseEnabled(true);
      ((WebSettings)localObject1).setJavaScriptEnabled(true);
      ((WebSettings)localObject1).setPluginState(WebSettings.PluginState.ON);
      ((WebSettings)localObject1).setUserAgentString(((WebSettings)localObject1).getUserAgentString() + " Mobike/" + MyApplication.a);
    }
    this.webView.addJavascriptInterface(new c(this), "app");
    if (Build.VERSION.SDK_INT >= 21) {
      this.webView.getSettings().setMixedContentMode(2);
    }
    final Object localObject2 = (LoadingPageView)findViewById(2131755751);
    this.webView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        localObject2.b();
        if (WebViewActivity.a(WebViewActivity.this))
        {
          WebViewActivity.a(WebViewActivity.this, false);
          paramAnonymousWebView.clearHistory();
          paramAnonymousWebView.clearCache(true);
        }
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        localObject2.a();
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        paramAnonymousSslErrorHandler.proceed();
      }
      
      @TargetApi(24)
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        int j = 0;
        Uri localUri = paramAnonymousWebResourceRequest.getUrl();
        boolean bool1 = "mobike".equals(localUri.getScheme());
        boolean bool2 = localUri.getHost().contains("mobike");
        int i;
        if ((!localUri.getQueryParameterNames().contains("userid")) || (!localUri.getQueryParameterNames().contains("accesstoken")))
        {
          i = 1;
          label67:
          if (!bool1) {
            break label205;
          }
          paramAnonymousWebView = localUri.getHost();
          switch (paramAnonymousWebView.hashCode())
          {
          default: 
            label108:
            i = -1;
          }
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return true;
            i = 0;
            break label67;
            if (!paramAnonymousWebView.equals("bridge")) {
              break label108;
            }
            i = j;
            continue;
            if (!paramAnonymousWebView.equals("home")) {
              break label108;
            }
            i = 1;
          }
        }
        WebViewActivity.b(WebViewActivity.this).a(localUri.toString());
        return true;
        WebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", localUri));
        return true;
        label205:
        if ((bool2) && (i != 0) && (q.a().b()))
        {
          WebViewActivity.a(WebViewActivity.this, true);
          WebViewActivity.this.webView.stopLoading();
          WebViewActivity.this.webView.loadUrl(WebViewActivity.a(WebViewActivity.this, localUri));
          return true;
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        int j = 0;
        Uri localUri = Uri.parse(paramAnonymousString);
        boolean bool1 = "mobike".equals(localUri.getScheme());
        boolean bool2 = localUri.getHost().contains("mobike");
        int i;
        if ((!localUri.getQueryParameterNames().contains("userid")) || (!localUri.getQueryParameterNames().contains("accesstoken")))
        {
          i = 1;
          label65:
          if (!bool1) {
            break label201;
          }
          paramAnonymousWebView = localUri.getHost();
          switch (paramAnonymousWebView.hashCode())
          {
          default: 
            label108:
            i = -1;
          }
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return true;
            i = 0;
            break label65;
            if (!paramAnonymousWebView.equals("bridge")) {
              break label108;
            }
            i = j;
            continue;
            if (!paramAnonymousWebView.equals("home")) {
              break label108;
            }
            i = 1;
          }
        }
        WebViewActivity.b(WebViewActivity.this).a(paramAnonymousString);
        return true;
        WebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", localUri));
        return true;
        label201:
        if ((bool2) && (i != 0) && (q.a().b()))
        {
          WebViewActivity.a(WebViewActivity.this, true);
          WebViewActivity.this.webView.stopLoading();
          WebViewActivity.this.webView.loadUrl(WebViewActivity.a(WebViewActivity.this, Uri.parse(paramAnonymousString)));
          return true;
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
      }
    });
    localObject1 = this.webView;
    localObject2 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (100 == paramAnonymousInt) {
          localObject2.b();
        }
        for (;;)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          return;
          if (!com.mobike.mobikeapp.model.c.h.g(WebViewActivity.this))
          {
            localObject2.b();
            WebViewActivity.this.unavailableView.setVisibility(0);
          }
        }
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        WebViewActivity.this.setTitle(paramAnonymousString);
      }
    };
    if (!(localObject1 instanceof WebView)) {
      ((WebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      this.webView.setOnTouchListener(ck.a(this));
      return;
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
    }
  }
  
  protected void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {}
    while ((this.l == null) || (TextUtils.isEmpty(this.l.getTitle()))) {
      return;
    }
    UMImage localUMImage;
    if (!TextUtils.isEmpty(this.l.getImgPath()))
    {
      localUMImage = new UMImage(this, this.l.getImgPath());
      if (TextUtils.isEmpty(this.l.getUrl())) {
        break label155;
      }
      com.umeng.socialize.media.h localh = new com.umeng.socialize.media.h(this.l.getUrl());
      localh.b(this.l.getTitle());
      localh.a(this.l.getContent());
      localh.a(localUMImage);
      this.g.setPlatform(paramSHARE_MEDIA).setCallback(this.h).withMedia(localh).share();
    }
    for (;;)
    {
      d();
      return;
      localUMImage = new UMImage(this, 2130838185);
      break;
      label155:
      if (!TextUtils.isEmpty(this.l.getImgPath()))
      {
        localUMImage.b(this.l.getTitle());
        localUMImage.a(this.l.getContent());
        this.g.setPlatform(paramSHARE_MEDIA).setCallback(this.h).withMedia(localUMImage).share();
      }
      else
      {
        this.g.setPlatform(paramSHARE_MEDIA).setCallback(this.h).withText(this.l.getTitle()).share();
      }
    }
  }
  
  protected void b()
  {
    this.mShareContent.setVisibility(8);
    this.mShareContent.setBackgroundColor(-1);
    this.i = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 1, 1.0F);
    this.i.setInterpolator(new AccelerateDecelerateInterpolator());
    this.i.setDuration(250L);
    this.j = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 1.0F, 1, 0.0F);
    this.j.setInterpolator(new AccelerateDecelerateInterpolator());
    this.j.setDuration(250L);
    this.shareView.a(31);
    this.shareView.setOnShareListener(cl.a(this));
  }
  
  protected void c()
  {
    this.k = true;
    this.mShareContent.setVisibility(0);
    this.overlayBg.setVisibility(0);
    this.mShareContent.startAnimation(this.j);
  }
  
  protected void d()
  {
    this.k = false;
    this.mShareContent.startAnimation(this.i);
    this.mShareContent.setVisibility(8);
    this.overlayBg.setVisibility(8);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      this.webView.reload();
    }
    for (;;)
    {
      UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramInt1 == 1001) && (paramInt2 == -1))
      {
        if (this.webView.canGoBack()) {
          this.webView.goBack();
        } else {
          finish();
        }
      }
      else if (paramInt1 == 1)
      {
        WebView localWebView;
        if ((com.mobike.mobikeapp.model.c.h.g(this)) && (q.a().b()))
        {
          this.loadingPageView.a();
          this.unavailableView.setVisibility(8);
          this.o = true;
          localWebView = this.webView;
          if (TextUtils.isEmpty(this.webView.getUrl())) {
            break label203;
          }
        }
        label203:
        for (String str = this.webView.getUrl();; str = this.q)
        {
          localWebView.loadUrl(a(Uri.parse(str)));
          if (this.n == null) {
            break;
          }
          if (!q.a().b()) {
            break label212;
          }
          this.n.a(0, "success", String.format("{\"userid\":\"%s\"}", new Object[] { q.a().d() }));
          break;
        }
        label212:
        this.n.a(200, "error", null);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.webView.canGoBack())
    {
      this.webView.goBack();
      return;
    }
    if (this.k)
    {
      d();
      return;
    }
    super.onBackPressed();
  }
  
  @OnClick(a={2131755782})
  public void onClickUnavailable(View paramView)
  {
    if (com.mobike.mobikeapp.model.c.h.g(this))
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
    this.webView.loadUrl(this.q);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968663);
    ButterKnife.a(this);
    paramBundle = getIntent();
    this.p = paramBundle.getStringExtra("webview_title");
    this.q = paramBundle.getStringExtra("webview_url");
    paramBundle = paramBundle.getData();
    if (paramBundle != null)
    {
      if (TextUtils.isEmpty(this.q)) {
        this.q = paramBundle.getQueryParameter("url");
      }
      if (TextUtils.isEmpty(this.p)) {
        this.p = paramBundle.getQueryParameter("title");
      }
    }
    if (!TextUtils.isEmpty(this.p)) {
      setTitle(this.p);
    }
    a();
    b();
    if (com.mobike.mobikeapp.model.c.h.g(this))
    {
      this.webView.loadUrl(this.q);
      this.loadingPageView.a();
      this.unavailableView.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    this.webView.destroy();
    g.a(this);
    super.onDestroy();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/WebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */