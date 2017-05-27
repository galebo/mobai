package com.mobike.mobikeapp.activity.riding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.a.g;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.data.ShareInfo;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.ShareView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class TripDetailActivity
  extends BaseActivity
{
  public static final String a = "com.mobike.android.extra.order.id";
  public static final String b = "com.mobike.android.extra.country.id";
  private static final int e = 1;
  private TranslateAnimation f;
  private TranslateAnimation g;
  private boolean h;
  private String i;
  private int j;
  private ShareAction k = new ShareAction(this);
  private UMShareListener l = new UMShareListener()
  {
    public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      com.mobike.mobikeapp.model.c.h.a(TripDetailActivity.this, TripDetailActivity.this.getString(2131296459));
    }
    
    public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
    {
      com.mobike.mobikeapp.model.c.h.a(TripDetailActivity.this, TripDetailActivity.this.getString(2131296575));
    }
    
    public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      if (MyApplication.b > com.mobike.mobikeapp.model.c.f.a().o()) {
        new com.mobike.mobikeapp.widget.j(TripDetailActivity.this, "30023", "30021", "30022").show();
      }
      if (com.mobike.mobikeapp.model.c.f.a().g())
      {
        com.mobike.mobikeapp.a.f.a(TripDetailActivity.this, new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymous2Int, String paramAnonymous2String)
          {
            if (paramAnonymous2Int == 200) {
              com.mobike.mobikeapp.model.c.f.a().c(9);
            }
            com.mobike.mobikeapp.model.c.h.a(TripDetailActivity.this, paramAnonymous2String);
          }
          
          public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
          {
            paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
            com.mobike.mobikeapp.model.c.h.a(TripDetailActivity.this, paramAnonymous2ArrayOfd.message);
            com.mobike.mobikeapp.model.c.f.a().c(9);
          }
        });
        return;
      }
      com.mobike.mobikeapp.model.c.h.a(TripDetailActivity.this, TripDetailActivity.this.getString(2131296986));
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
  @BindView(a=2131755393)
  WebView webView;
  
  public static Intent a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("mobike://home/tripdetail"));
    localIntent.putExtra("com.mobike.android.extra.order.id", paramString);
    localIntent.putExtra("com.mobike.android.extra.country.id", paramInt);
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
        TripDetailActivity.this.loadingPageView.b();
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        TripDetailActivity.this.loadingPageView.a();
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
          TripDetailActivity.this.loadingPageView.b();
        }
        for (;;)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          return;
          if (!com.mobike.mobikeapp.model.c.h.g(TripDetailActivity.this))
          {
            TripDetailActivity.this.loadingPageView.b();
            TripDetailActivity.this.unavailableView.setVisibility(0);
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
  
  private void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {
      return;
    }
    if (SHARE_MEDIA.WEIXIN_CIRCLE == paramSHARE_MEDIA) {
      this.k.setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(this.l).withMedia(new UMImage(this, e())).share();
    }
    for (;;)
    {
      d();
      return;
      if (SHARE_MEDIA.SINA != paramSHARE_MEDIA) {
        break;
      }
      this.k.setPlatform(SHARE_MEDIA.SINA).setCallback(this.l).withText(getString(2131296982)).share();
    }
    Object localObject2 = q.a().m(this);
    Object localObject1 = com.mobike.mobikeapp.c.a.a(this.i, this.j) + "share=true";
    if ((localObject2 == null) || (TextUtils.isEmpty(((ShareInfo)localObject2).getTitle())) || (TextUtils.isEmpty(((ShareInfo)localObject2).getContent())))
    {
      localObject1 = new ShareInfo(getString(2131296984), getString(2131296983), (String)localObject1, "");
      if (TextUtils.isEmpty(((ShareInfo)localObject1).getImgPath())) {
        break label297;
      }
    }
    label297:
    for (localObject2 = new UMImage(this, ((ShareInfo)localObject1).getImgPath());; localObject2 = new UMImage(this, 2130838185))
    {
      com.umeng.socialize.media.h localh = new com.umeng.socialize.media.h(((ShareInfo)localObject1).getUrl());
      localh.b(((ShareInfo)localObject1).getTitle());
      localh.a(((ShareInfo)localObject1).getContent());
      localh.a((UMImage)localObject2);
      this.k.setPlatform(paramSHARE_MEDIA).setCallback(this.l).withMedia(localh).share();
      break;
      if (TextUtils.isEmpty(((ShareInfo)localObject2).getUrl())) {}
      for (;;)
      {
        ((ShareInfo)localObject2).setUrl((String)localObject1);
        localObject1 = localObject2;
        break;
        localObject1 = ((ShareInfo)localObject2).getUrl();
      }
    }
  }
  
  private void b()
  {
    this.mShareContent.setVisibility(8);
    this.mShareContent.setBackgroundColor(-1);
    this.f = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 1, 1.0F);
    this.f.setInterpolator(new AccelerateDecelerateInterpolator());
    this.f.setDuration(250L);
    this.g = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 1.0F, 1, 0.0F);
    this.g.setInterpolator(new AccelerateDecelerateInterpolator());
    this.g.setDuration(250L);
    ShareView localShareView = (ShareView)findViewById(2131755245);
    localShareView.a(31);
    localShareView.setOnShareListener(j.a(this));
  }
  
  private void c()
  {
    this.h = true;
    this.mShareContent.setVisibility(0);
    this.overlayBg.setVisibility(0);
    this.mShareContent.startAnimation(this.g);
  }
  
  private void d()
  {
    this.h = false;
    this.mShareContent.startAnimation(this.f);
    this.mShareContent.setVisibility(8);
    this.overlayBg.setVisibility(8);
  }
  
  private Bitmap e()
  {
    int m = 720;
    if ((this.webView == null) || (this.webView.getHeight() == 0))
    {
      com.mobike.mobikeapp.model.c.h.a(this, getString(2131297136));
      return null;
    }
    this.webView.setDrawingCacheEnabled(true);
    this.webView.buildDrawingCache();
    int n = com.mobike.mobikeapp.model.c.h.m(this);
    if (n >= 720) {}
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(this.webView.getDrawingCache(), m, Math.round(m * 1.5F), false);
      this.webView.setDrawingCacheEnabled(false);
      if (localBitmap == null) {
        break;
      }
      return a(localBitmap, m);
      if (n >= 540) {
        m = 540;
      } else {
        m = 480;
      }
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((com.mobike.mobikeapp.model.c.h.m(this) >= 1430) && (com.mobike.mobikeapp.model.c.h.o(this) >= 2500)) {}
    for (float f1 = 0.65F;; f1 = 1.0F)
    {
      int m = (int)(com.mobike.mobikeapp.model.c.h.a(this, 50.0F) * f1);
      int n = (int)(com.mobike.mobikeapp.model.c.h.a(this, 26.0F) * f1);
      int i1 = (int)(com.mobike.mobikeapp.model.c.h.a(this, 10.0F) * f1);
      int i2 = (int)(com.mobike.mobikeapp.model.c.h.a(this, 8.0F) * f1);
      float f2 = com.mobike.mobikeapp.model.c.h.b(this, 12.0F) * f1;
      float f3 = com.mobike.mobikeapp.model.c.h.b(this, 9.0F) * f1;
      int i3 = paramBitmap.getWidth();
      int i4 = paramBitmap.getHeight();
      float f4 = paramInt / i3;
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f4, f4);
      Object localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, i3, i4, (Matrix)localObject1, true);
      i3 = ((Bitmap)localObject2).getHeight();
      paramBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), 2130838074), m, m, true);
      localObject1 = Bitmap.createBitmap(paramInt, (int)(i3 + 0 + com.mobike.mobikeapp.model.c.h.a(this, 60.0F) * f1), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      localCanvas.drawColor(ContextCompat.getColor(this, 2131624001));
      localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 2.0F, null);
      f1 = ((Bitmap)localObject2).getHeight() + 2.0F;
      localObject2 = new Paint();
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setTextSize(f2);
      ((Paint)localObject2).setDither(false);
      ((Paint)localObject2).setAntiAlias(true);
      ((Paint)localObject2).setStyle(Paint.Style.FILL_AND_STROKE);
      localCanvas.drawText(getString(2131296399), m + n + n / 2, i2 + f1 + f2, (Paint)localObject2);
      localObject2 = new Paint();
      ((Paint)localObject2).setColor(ContextCompat.getColor(this, 2131624119));
      ((Paint)localObject2).setTextSize(f3);
      ((Paint)localObject2).setAntiAlias(true);
      ((Paint)localObject2).setDither(true);
      ((Paint)localObject2).setStyle(Paint.Style.FILL_AND_STROKE);
      localCanvas.drawText(getString(2131297156), (float)(m + n * 1.5D), i2 + f1 + f2 + i1 + f3, (Paint)localObject2);
      localCanvas.drawBitmap(paramBitmap, n, f1, null);
      return (Bitmap)localObject1;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (q.a().b()) {
        this.webView.loadUrl(com.mobike.mobikeapp.c.a.a(this.i, this.j));
      }
    }
    else {
      return;
    }
    finish();
  }
  
  public void onBackPressed()
  {
    if (this.webView.canGoBack())
    {
      this.webView.goBack();
      return;
    }
    if (this.h)
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
    this.webView.loadUrl(com.mobike.mobikeapp.c.a.a(this.i, this.j));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968656);
    ButterKnife.a(this);
    this.i = getIntent().getStringExtra("com.mobike.android.extra.order.id");
    this.j = getIntent().getIntExtra("com.mobike.android.extra.country.id", 0);
    if (TextUtils.isEmpty(this.i))
    {
      paramBundle = Toast.makeText(this, 2131297030, 0);
      if ((paramBundle instanceof Toast)) {
        break label148;
      }
      paramBundle.show();
    }
    for (;;)
    {
      finish();
      a();
      b();
      setTitle(getString(2131296731));
      if (!q.a().b()) {
        break;
      }
      if (com.mobike.mobikeapp.model.c.h.g(this))
      {
        this.webView.loadUrl(com.mobike.mobikeapp.c.a.a(this.i, this.j));
        this.loadingPageView.a();
        this.unavailableView.setVisibility(8);
      }
      return;
      label148:
      VdsAgent.showToast((Toast)paramBundle);
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820554, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    g.a(this);
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
    if (this.h) {
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


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/TripDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */