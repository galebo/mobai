package com.mobike.mobikeapp.widget;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.support.annotation.ab;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.bridge.i;
import com.mobike.mobikeapp.bridge.i.a;
import com.mobike.mobikeapp.data.ShareInfo;
import com.mobike.mobikeapp.util.q;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import cz.msebera.android.httpclient.d;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class TreasureWebView
  extends RelativeLayout
  implements SurprisePlaceholderView.a
{
  protected static final int a = 1;
  protected static final int b = 31;
  protected static final int c = 96;
  public static final String d = "{\"userid\":\"%s\"}";
  private static final int f = 1000;
  private static final int g = 1001;
  private static final int h = 3000;
  private static final int y = 250;
  protected UMShareListener e = new UMShareListener()
  {
    public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      TreasureWebView.a(TreasureWebView.this, TreasureWebView.a(TreasureWebView.this).getString(2131296459));
    }
    
    public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
    {
      paramAnonymousThrowable.printStackTrace();
      TreasureWebView.a(TreasureWebView.this, TreasureWebView.a(TreasureWebView.this).getString(2131296575));
    }
    
    public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
    {
      if (MyApplication.b > com.mobike.mobikeapp.model.c.f.a().o()) {
        new j(TreasureWebView.a(TreasureWebView.this), "30023", "30021", "30022").show();
      }
      if (com.mobike.mobikeapp.model.c.f.a().g())
      {
        com.mobike.mobikeapp.a.f.a(TreasureWebView.a(TreasureWebView.this), new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymous2Int, String paramAnonymous2String)
          {
            if (paramAnonymous2Int == 200) {
              com.mobike.mobikeapp.model.c.f.a().c(9);
            }
            TreasureWebView.a(TreasureWebView.this, paramAnonymous2String);
          }
          
          public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
          {
            paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new com.google.gson.e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
            TreasureWebView.a(TreasureWebView.this, paramAnonymous2ArrayOfd.message);
            com.mobike.mobikeapp.model.c.f.a().c(9);
          }
        });
        return;
      }
      TreasureWebView.a(TreasureWebView.this, TreasureWebView.a(TreasureWebView.this).getString(2131296986));
    }
    
    public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
  };
  private TranslateAnimation i;
  private TranslateAnimation j;
  private ObjectAnimator k;
  private ObjectAnimator l;
  @BindView(a=2131755751)
  protected LoadingPageView loadingPageView;
  private boolean m;
  @BindView(a=2131755278)
  protected LinearLayout mShareContent;
  @BindView(a=2131755747)
  protected SurprisePlaceholderView mTreasurePlaceHolder;
  @BindView(a=2131755746)
  protected RelativeLayout mTreasurePlaceHolderLayout;
  private ShareInfo n;
  private i o;
  @BindView(a=2131755277)
  protected FrameLayout overlayBg;
  private com.mobike.mobikeapp.bridge.e p;
  private boolean q;
  private String r;
  private String s;
  @BindView(a=2131755245)
  protected ShareView shareView;
  private String t;
  private int u = 0;
  @BindView(a=2131755782)
  protected View unavailableView;
  private Context v;
  private a w;
  @BindView(a=2131755419)
  protected WebView webView;
  private float x;
  
  public TreasureWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TreasureWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public TreasureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
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
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.v = paramContext;
    addView(LayoutInflater.from(paramContext).inflate(2130968776, this, false));
  }
  
  private void b(String paramString)
  {
    com.mobike.mobikeapp.model.c.h.a(getActivity(), paramString);
  }
  
  private void c()
  {
    Log.e("WEBVIEW", "===>height " + this.mShareContent.getHeight());
    this.x = this.mShareContent.getTop();
    this.mShareContent.setVisibility(4);
    this.mShareContent.setBackgroundColor(-1);
    this.shareView.a(31);
    this.shareView.setOnShareListener(w.a(this));
  }
  
  private void d()
  {
    this.m = true;
    this.x = (com.mobike.mobikeapp.util.a.b(getActivity(), false) - this.mShareContent.getHeight());
    if (this.l == null)
    {
      this.l = ObjectAnimator.ofFloat(this.mShareContent, "Y", new float[] { com.mobike.mobikeapp.util.a.b(getActivity(), false), this.x });
      this.l.setDuration(250L);
      this.l.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.mShareContent.setVisibility(0);
    this.overlayBg.setVisibility(0);
    this.l.start();
  }
  
  private void e()
  {
    this.m = false;
    this.x = (com.mobike.mobikeapp.util.a.b(getActivity(), false) - this.mShareContent.getHeight());
    if (this.k == null)
    {
      this.k = ObjectAnimator.ofFloat(this.mShareContent, "Y", new float[] { this.x, com.mobike.mobikeapp.util.a.b(getActivity(), false) });
      this.k.setDuration(250L);
      this.k.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.k.start();
    this.mShareContent.setVisibility(4);
    this.overlayBg.setVisibility(8);
  }
  
  private Activity getActivity()
  {
    return (Activity)this.v;
  }
  
  public void a()
  {
    int i1 = com.mobike.mobikeapp.util.a.a(getActivity(), true);
    a("javascript:showAnimation('{\"width\":" + i1 + "}');");
  }
  
  public void a(View paramView)
  {
    if (this.w != null) {
      this.w.f();
    }
  }
  
  protected void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(getActivity(), paramSHARE_MEDIA)) {}
    do
    {
      return;
      org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.j("share"));
    } while ((this.n == null) || (TextUtils.isEmpty(this.n.getTitle())));
    UMImage localUMImage;
    ShareAction localShareAction;
    if (!TextUtils.isEmpty(this.n.getImgPath()))
    {
      localUMImage = new UMImage(getActivity(), this.n.getImgPath());
      localShareAction = new ShareAction(getActivity());
      if (TextUtils.isEmpty(this.n.getUrl())) {
        break label194;
      }
      com.umeng.socialize.media.h localh = new com.umeng.socialize.media.h(this.n.getUrl());
      localh.b(this.n.getTitle());
      localh.a(this.n.getContent());
      localh.a(localUMImage);
      localShareAction.setPlatform(paramSHARE_MEDIA).setCallback(this.e).withMedia(localh).share();
    }
    for (;;)
    {
      e();
      return;
      localUMImage = new UMImage(getActivity(), 2130838185);
      break;
      label194:
      if (!TextUtils.isEmpty(this.n.getImgPath()))
      {
        localUMImage.b(this.n.getTitle());
        localUMImage.a(this.n.getContent());
        localShareAction.setPlatform(paramSHARE_MEDIA).setCallback(this.e).withMedia(localUMImage).share();
      }
      else
      {
        localShareAction.setPlatform(paramSHARE_MEDIA).setCallback(this.e).withText(this.n.getTitle()).share();
      }
    }
  }
  
  public void a(String paramString)
  {
    this.webView.loadUrl(paramString);
  }
  
  protected void b()
  {
    this.o = new i.a().a(this.webView).a("close", t.a(this)).a("share", u.a(this)).a();
    this.webView.setInitialScale(0);
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.setLayerType(2, null);
    this.webView.getSettings().setDomStorageEnabled(true);
    this.webView.getSettings().setJavaScriptEnabled(true);
    Object localObject = this.webView.getSettings().getUserAgentString();
    this.webView.getSettings().setUserAgentString((String)localObject + " Mobike/" + MyApplication.a);
    this.webView.addJavascriptInterface(new com.mobike.mobikeapp.bridge.c(getActivity()), "app");
    if (Build.VERSION.SDK_INT >= 21) {
      this.webView.getSettings().setMixedContentMode(2);
    }
    this.webView.setBackgroundColor(getResources().getColor(2131624081));
    this.webView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        TreasureWebView.this.loadingPageView.b();
        if (TreasureWebView.b(TreasureWebView.this))
        {
          TreasureWebView.a(TreasureWebView.this, false);
          paramAnonymousWebView.clearHistory();
        }
        TreasureWebView.a(TreasureWebView.this, 0);
        if (TreasureWebView.c(TreasureWebView.this) != null) {
          TreasureWebView.c(TreasureWebView.this).e();
        }
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        TreasureWebView.this.loadingPageView.a();
        TreasureWebView.a(TreasureWebView.this, 1);
        TreasureWebView.this.mTreasurePlaceHolderLayout.setVisibility(8);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        TreasureWebView.a(TreasureWebView.this, 2);
        TreasureWebView.this.mTreasurePlaceHolderLayout.setVisibility(0);
      }
      
      @TargetApi(23)
      public void onReceivedError(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        onReceivedError(paramAnonymousWebView, paramAnonymousWebResourceError.getErrorCode(), paramAnonymousWebResourceError.getDescription().toString(), paramAnonymousWebResourceRequest.getUrl().toString());
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        Log.d("WEBVIEW", "ssl error " + paramAnonymousSslError.toString());
        paramAnonymousSslErrorHandler.proceed();
        TreasureWebView.a(TreasureWebView.this, 2);
      }
      
      @TargetApi(24)
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        Uri localUri = paramAnonymousWebResourceRequest.getUrl();
        if ("mobike".equals(localUri.getScheme()))
        {
          paramAnonymousWebView = localUri.getHost();
          int i = -1;
          switch (paramAnonymousWebView.hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            case 1: 
            default: 
              return true;
              if (paramAnonymousWebView.equals("bridge"))
              {
                i = 0;
                continue;
                if (paramAnonymousWebView.equals("home")) {
                  i = 1;
                }
              }
              break;
            }
          }
          TreasureWebView.d(TreasureWebView.this).a(localUri.toString());
          return true;
        }
        if (((!localUri.getQueryParameterNames().contains("userid")) || (!localUri.getQueryParameterNames().contains("accesstoken"))) && (q.a().b()))
        {
          TreasureWebView.a(TreasureWebView.this, true);
          TreasureWebView.this.a(TreasureWebView.a(TreasureWebView.this, localUri));
          return true;
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        Uri localUri = Uri.parse(paramAnonymousString);
        if ("mobike".equals(localUri.getScheme()))
        {
          paramAnonymousWebView = localUri.getHost();
          int i = -1;
          switch (paramAnonymousWebView.hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              return true;
              if (paramAnonymousWebView.equals("bridge"))
              {
                i = 0;
                continue;
                if (paramAnonymousWebView.equals("home")) {
                  i = 1;
                }
              }
              break;
            }
          }
          TreasureWebView.d(TreasureWebView.this).a(paramAnonymousString);
          return true;
        }
        if (((!localUri.getQueryParameterNames().contains("userid")) || (!localUri.getQueryParameterNames().contains("accesstoken"))) && (q.a().b()))
        {
          TreasureWebView.a(TreasureWebView.this, true);
          TreasureWebView.this.a(TreasureWebView.a(TreasureWebView.this, Uri.parse(paramAnonymousString)));
          return true;
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
      }
    });
    this.unavailableView.setVisibility(4);
    localObject = this.webView;
    WebChromeClient local3 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        TreasureWebView.this.unavailableView.setVisibility(4);
        if (100 == paramAnonymousInt)
        {
          TreasureWebView.this.loadingPageView.b();
          TreasureWebView.a(TreasureWebView.this, 0);
        }
        for (;;)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          return;
          if (!com.mobike.mobikeapp.model.c.h.g(TreasureWebView.a(TreasureWebView.this)))
          {
            TreasureWebView.this.loadingPageView.b();
            TreasureWebView.this.unavailableView.setVisibility(0);
          }
        }
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
      }
    };
    if (!(localObject instanceof WebView)) {
      ((WebView)localObject).setWebChromeClient(local3);
    }
    for (;;)
    {
      this.webView.setOnTouchListener(v.a(this));
      this.webView.getSettings().setUseWideViewPort(true);
      this.webView.getSettings().setLoadWithOverviewMode(true);
      return;
      VdsAgent.setWebChromeClient((WebView)localObject, local3);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.a(this);
    this.unavailableView.setVisibility(4);
    b();
    c();
    this.mTreasurePlaceHolder.setOnCloseListener(this);
  }
  
  public void setOnBridgeListener(a parama)
  {
    this.w = parama;
  }
  
  public static abstract interface a
  {
    public abstract void e();
    
    public abstract void f();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/TreasureWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */