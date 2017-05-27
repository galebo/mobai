package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.data.MessageDataInfo.MessageData;
import com.mobike.mobikeapp.model.BaseActivity;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.ShareView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class MessageDetailActivity
  extends BaseActivity
{
  public static final String a = "com.mobike.mobikeapp.web.info";
  private MessageDataInfo.MessageData b;
  private TranslateAnimation c;
  private TranslateAnimation d;
  private boolean e;
  private ShareAction f = new ShareAction(this);
  private UMShareListener g = new UMShareListener()
  {
    public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      com.mobike.mobikeapp.model.c.h.a(MessageDetailActivity.this, MessageDetailActivity.this.getString(2131296459));
    }
    
    public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
    {
      com.mobike.mobikeapp.model.c.h.a(MessageDetailActivity.this, MessageDetailActivity.this.getString(2131296575));
    }
    
    public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      if (MyApplication.b > com.mobike.mobikeapp.model.c.f.a().o()) {
        new com.mobike.mobikeapp.widget.j(MessageDetailActivity.this, "30023", "30021", "30022").show();
      }
      if (com.mobike.mobikeapp.model.c.f.a().g())
      {
        com.mobike.mobikeapp.a.f.a(MessageDetailActivity.this, new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymous2Int, String paramAnonymous2String)
          {
            if (paramAnonymous2Int == 200) {
              com.mobike.mobikeapp.model.c.f.a().c(9);
            }
            com.mobike.mobikeapp.model.c.h.a(MessageDetailActivity.this, paramAnonymous2String);
          }
          
          public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
          {
            paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
            com.mobike.mobikeapp.model.c.h.a(MessageDetailActivity.this, paramAnonymous2ArrayOfd.message);
            com.mobike.mobikeapp.model.c.f.a().c(9);
          }
        });
        return;
      }
      com.mobike.mobikeapp.model.c.h.a(MessageDetailActivity.this, MessageDetailActivity.this.getString(2131296986));
    }
    
    public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
  };
  @BindView(a=2131755751)
  LoadingPageView loadingPageView;
  @BindView(a=2131755278)
  LinearLayout mShareContent;
  @BindView(a=2131755277)
  FrameLayout overlayBg;
  @BindView(a=2131755782)
  View unavailableView;
  @BindView(a=2131755276)
  WebView webView;
  
  public static Intent a(MessageDataInfo.MessageData paramMessageData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("mobike://home/message"));
    localIntent.putExtra("com.mobike.mobikeapp.web.info", paramMessageData);
    return localIntent;
  }
  
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
        MessageDetailActivity.this.loadingPageView.b();
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        MessageDetailActivity.this.loadingPageView.a();
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        paramAnonymousSslErrorHandler.proceed();
      }
    });
    WebView localWebView = this.webView;
    WebChromeClient local3 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (100 == paramAnonymousInt) {
          MessageDetailActivity.this.loadingPageView.b();
        }
        for (;;)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          return;
          if (!com.mobike.mobikeapp.model.c.h.g(MessageDetailActivity.this))
          {
            MessageDetailActivity.this.loadingPageView.b();
            MessageDetailActivity.this.unavailableView.setVisibility(0);
          }
        }
      }
    };
    if (!(localWebView instanceof WebView)) {
      localWebView.setWebChromeClient(local3);
    }
    for (;;)
    {
      this.webView.setOnTouchListener(i.a(this));
      return;
      VdsAgent.setWebChromeClient((WebView)localWebView, local3);
    }
  }
  
  private void b()
  {
    this.mShareContent.setVisibility(8);
    this.mShareContent.setBackgroundColor(-1);
    this.c = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 1, 1.0F);
    this.c.setInterpolator(new AccelerateDecelerateInterpolator());
    this.c.setDuration(250L);
    this.d = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 1.0F, 1, 0.0F);
    this.d.setInterpolator(new AccelerateDecelerateInterpolator());
    this.d.setDuration(250L);
    ShareView localShareView = (ShareView)findViewById(2131755245);
    localShareView.a(31);
    localShareView.setOnShareListener(j.a(this));
  }
  
  private void c()
  {
    this.e = true;
    this.mShareContent.setVisibility(0);
    this.overlayBg.setVisibility(0);
    this.mShareContent.startAnimation(this.d);
  }
  
  private void d()
  {
    this.e = false;
    this.mShareContent.startAnimation(this.c);
    this.mShareContent.setVisibility(8);
    this.overlayBg.setVisibility(8);
  }
  
  protected void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {}
    while ((this.b == null) || (TextUtils.isEmpty(this.b.title))) {
      return;
    }
    if (!TextUtils.isEmpty(this.b.image)) {}
    for (UMImage localUMImage = new UMImage(this, this.b.image);; localUMImage = new UMImage(this, 2130838185))
    {
      if (!TextUtils.isEmpty(this.b.url))
      {
        com.umeng.socialize.media.h localh = new com.umeng.socialize.media.h(this.b.url);
        localh.b(this.b.title);
        localh.a(this.b.body);
        localh.a(localUMImage);
        this.f.setPlatform(paramSHARE_MEDIA).setCallback(this.g).withMedia(localh).share();
      }
      d();
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
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
    this.webView.loadUrl(this.b.url);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968629);
    ButterKnife.a(this);
    this.b = ((MessageDataInfo.MessageData)getIntent().getSerializableExtra("com.mobike.mobikeapp.web.info"));
    a();
    b();
    setTitle(this.b.title);
    if (com.mobike.mobikeapp.model.c.h.g(this))
    {
      this.webView.loadUrl(this.b.url);
      this.loadingPageView.a();
      this.unavailableView.setVisibility(8);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820554, paramMenu);
    return true;
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
    if (this.e) {
      d();
    }
    for (;;)
    {
      VdsAgent.handleClickResult(new Boolean(true));
      return true;
      c();
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MessageDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */