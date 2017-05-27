package com.mobike.mobikeapp.activity.riding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.JsonSyntaxException;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.n;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.HelpCardActivity;
import com.mobike.mobikeapp.MainActivity;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.activity.customer.NormalCustomerServiceActivity;
import com.mobike.mobikeapp.activity.pay.WalletActivity;
import com.mobike.mobikeapp.activity.redpacket.RedPacketAmountDetailActivity;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.data.ResultRidingInfo;
import com.mobike.mobikeapp.model.c.b;
import com.mobike.mobikeapp.util.AccountManager;
import com.mobike.mobikeapp.util.AccountManager.a;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.aa;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.util.y;
import com.mobike.mobikeapp.widget.EasterEggView;
import com.mobike.mobikeapp.widget.NonFocusingScrollView;
import com.mobike.mobikeapp.widget.ShareView;
import com.mobike.mobikeapp.widget.j;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class RideResultActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final int B = 0;
  private static final int C = 1;
  private EasterEggView A;
  private TextView a;
  private TextView b;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private View j;
  private RelativeLayout k;
  private View l;
  private ResultRidingInfo m;
  private boolean n = false;
  private String o = null;
  private final int p = 2;
  private final int q = 250;
  private boolean r = true;
  private boolean s = false;
  private final String t = "uploadImage";
  private final String u = "isNeedUpload";
  private LinearLayout v;
  private TranslateAnimation w;
  private TranslateAnimation x;
  private NonFocusingScrollView y;
  private com.mobike.mobikeapp.model.a z;
  
  private void a()
  {
    NotificationManagerCompat.from(this).cancel(1001);
    org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.d());
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.z = new com.mobike.mobikeapp.model.a(this).f(300).g(370);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Integer.valueOf(2131755510), f.a(this)));
    localArrayList.add(new Pair(Integer.valueOf(2131755511), g.a(this, paramInt)));
    localArrayList.add(new Pair(Integer.valueOf(2131755513), h.a(this, paramInt)));
    this.z.setCanceledOnTouchOutside(false);
    this.z.e(2130968696).a(localArrayList).show();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.A.setVisibility(0);
      this.A.a();
      return;
    }
    a(paramInt2);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("isNeedUpload", true);
      this.r = bool;
      if (!bool) {
        k();
      }
      bool = paramBundle.getBoolean("uploadImage", false);
      this.s = bool;
      if (bool) {
        k();
      }
    }
  }
  
  private void a(View paramView)
  {
    if (this.r)
    {
      paramView = new Intent(this, UploadParkingImgActivity.class);
      paramView.putExtra("order_id", this.o);
      startActivityForResult(paramView, 250);
      return;
    }
    com.mobike.mobikeapp.model.c.h.a(paramView.getContext(), getString(2131296419));
  }
  
  private void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {
      return;
    }
    if ((this.m != null) && (TextUtils.isEmpty(this.m.shareTil)) && (TextUtils.isEmpty(this.m.shareCon)))
    {
      y.a().a(this, getString(2131296984), getString(2131296983), p(), "", n());
      y.a().a(paramSHARE_MEDIA);
      f();
      return;
    }
    if (TextUtils.isEmpty(this.m.shareurl)) {}
    for (String str = p();; str = this.m.shareurl)
    {
      q.a().b(this, this.m.shareTil, this.m.shareCon, this.m.shareImg, this.m.shareurl);
      y.a().a(this, this.m.shareTil, this.m.shareCon, str, this.m.shareImg, n());
      break;
    }
  }
  
  private void b()
  {
    this.j = findViewById(2131755364);
    this.j.setOnClickListener(this);
    y.a().a(this);
    this.v = ((LinearLayout)findViewById(2131755324));
    this.v.setVisibility(8);
    this.v.setBackgroundColor(-1);
    this.w = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 1, 1.0F);
    this.w.setInterpolator(new AccelerateDecelerateInterpolator());
    this.w.setDuration(250L);
    this.x = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 1.0F, 1, 0.0F);
    this.x.setInterpolator(new AccelerateDecelerateInterpolator());
    this.x.setDuration(250L);
    this.v.setOnClickListener(this);
    ShareView localShareView = (ShareView)findViewById(2131755245);
    localShareView.a(31);
    localShareView.setOnShareListener(c.a(this));
  }
  
  private void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("red_packet_value", paramInt);
    com.mobike.mobikeapp.model.c.h.a(this, RedPacketAmountDetailActivity.class, localBundle);
  }
  
  private void b(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {
      return;
    }
    y.a().a(this, getString(2131296982), paramSHARE_MEDIA, n());
    f();
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.o)) {
      return;
    }
    if (!com.mobike.mobikeapp.model.c.h.l(this))
    {
      this.l.setVisibility(0);
      this.l.setOnClickListener(this);
      return;
    }
    com.mobike.mobikeapp.a.f.g(this.o, new ad()
    {
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        if (!TextUtils.isEmpty(paramAnonymousString)) {
          paramAnonymousArrayOfd = null;
        }
        try
        {
          paramAnonymousString = new n().a(paramAnonymousString);
          paramAnonymousArrayOfd = paramAnonymousString;
        }
        catch (JsonSyntaxException paramAnonymousString)
        {
          for (;;) {}
        }
        if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.q()) && (paramAnonymousArrayOfd.t().b("object")))
        {
          RideResultActivity.a(RideResultActivity.this, (ResultRidingInfo)new com.google.gson.e().a(paramAnonymousArrayOfd.t().c("object"), ResultRidingInfo.class));
          RideResultActivity.a(RideResultActivity.this, RideResultActivity.a(RideResultActivity.this).awardType, RideResultActivity.a(RideResultActivity.this).redPacket);
          RideResultActivity.b(RideResultActivity.this);
          return;
        }
        RideResultActivity.c(RideResultActivity.this).setVisibility(0);
        return;
        RideResultActivity.c(RideResultActivity.this).setVisibility(0);
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        RideResultActivity.c(RideResultActivity.this).setVisibility(0);
      }
    });
  }
  
  private void d()
  {
    this.i = ((TextView)findViewById(2131755491));
    this.i.setOnClickListener(this);
    this.a = ((TextView)findViewById(2131755369));
    TextView localTextView1 = (TextView)findViewById(2131755492);
    TextView localTextView2 = (TextView)findViewById(2131755488);
    this.b = ((TextView)findViewById(2131755485));
    this.e = ((TextView)findViewById(2131755478));
    this.f = ((TextView)findViewById(2131755477));
    this.k = ((RelativeLayout)findViewById(2131755475));
    this.l = findViewById(2131755320);
    this.g = ((TextView)findViewById(2131755479));
    this.h = ((TextView)findViewById(2131755480));
    this.A = ((EasterEggView)findViewById(2131755365));
    this.A.setListener(d.a(this));
    localTextView1.setOnClickListener(this);
    localTextView2.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.y = ((NonFocusingScrollView)findViewById(2131755181));
    int i2 = com.mobike.mobikeapp.model.c.h.o(this) - com.mobike.mobikeapp.model.c.h.a(this, 50.0F);
    int i1 = i2;
    if (Build.VERSION.SDK_INT >= 19) {
      i1 = i2 - i();
    }
    this.y.setMinimumHeight(i1);
    this.o = getIntent().getStringExtra("urlKey");
    this.n = "PUSH".equals(getIntent().getStringExtra("TYPE"));
    if (TextUtils.isEmpty(this.o))
    {
      this.m = ((ResultRidingInfo)getIntent().getSerializableExtra(b.aL));
      if (this.m == null)
      {
        this.l.setVisibility(0);
        return;
      }
      this.o = this.m.orderId;
      a(this.m.awardType, this.m.redPacket);
      l();
      return;
    }
    c();
  }
  
  private void e()
  {
    this.j.setVisibility(0);
    this.v.setVisibility(0);
    this.v.startAnimation(this.x);
  }
  
  private void f()
  {
    this.j.setVisibility(8);
    this.v.startAnimation(this.w);
    this.v.setVisibility(8);
  }
  
  private void k()
  {
    this.i.setEnabled(false);
  }
  
  private void l()
  {
    RideManager.a().b(this, "");
    if (this.m != null)
    {
      this.r = this.m.isNeedUploadImg();
      int i1 = com.mobike.mobikeapp.model.c.f.a().b();
      if (i1 == 0) {
        aa.d();
      }
      i1 += 1;
      findViewById(2131755481).setVisibility(0);
      if (this.m.ridingtime / 60 == 0)
      {
        this.a.setText(String.format(getString(2131296920), new Object[] { Integer.valueOf(this.m.ridingtime % 60) }));
        if (this.m.balance <= 0.0F) {
          break label410;
        }
        this.b.setText(o.a(this.m.balance));
        label136:
        this.g.setText(String.format(getString(2131296925), new Object[] { o.a(this.m.totalfee) }));
        if (this.m.coupon.compareTo(BigDecimal.ZERO) <= 0) {
          break label437;
        }
        this.h.setText(getString(2131296932, new Object[] { o.a(this.m.coupon) }));
      }
      for (;;)
      {
        BigDecimal localBigDecimal = this.m.totalfee.add(this.m.coupon.negate());
        this.e.setText(o.b(localBigDecimal));
        this.f.setText(q.a().j().getPrefixSymbol());
        if (i1 == 2) {
          new Handler().postDelayed(e.a(this), 1000L);
        }
        if (i1 < 3) {
          com.mobike.mobikeapp.model.c.f.a().a(i1);
        }
        return;
        if (this.m.ridingtime % 60 == 0)
        {
          this.a.setText(String.format(getString(2131296919), new Object[] { Integer.valueOf(this.m.ridingtime / 60) }));
          break;
        }
        this.a.setText(String.format(getString(2131296918), new Object[] { Integer.valueOf(this.m.ridingtime / 60), Integer.valueOf(this.m.ridingtime % 60) }));
        break;
        label410:
        this.b.setText(getString(2131296917));
        this.b.setTextColor(-65536);
        break label136;
        label437:
        this.h.setText(getString(2131296936));
      }
    }
    this.l.setVisibility(0);
    com.mobike.mobikeapp.model.c.h.a(this, getString(2131296570));
  }
  
  private void m()
  {
    if (this.v.getVisibility() == 0)
    {
      f();
      return;
    }
    y.a().a(this);
    e();
  }
  
  private UMShareListener n()
  {
    new UMShareListener()
    {
      public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        com.mobike.mobikeapp.model.c.h.a(RideResultActivity.this, RideResultActivity.this.getString(2131296459));
      }
      
      public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
      {
        com.mobike.mobikeapp.model.c.h.a(RideResultActivity.this, RideResultActivity.this.getString(2131296575));
      }
      
      public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        if (MyApplication.b > com.mobike.mobikeapp.model.c.f.a().o()) {
          new j(RideResultActivity.this, "30023", "30021", "30022").show();
        }
        if (com.mobike.mobikeapp.model.c.f.a().g())
        {
          com.mobike.mobikeapp.a.f.a(RideResultActivity.this, new com.mobike.mobikeapp.model.b.a()
          {
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              if (paramAnonymous2Int == 200) {
                com.mobike.mobikeapp.model.c.f.a().c(9);
              }
              com.mobike.mobikeapp.model.c.h.a(RideResultActivity.this, paramAnonymous2String);
            }
            
            public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
            {
              paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new com.google.gson.e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
              com.mobike.mobikeapp.model.c.h.a(RideResultActivity.this, paramAnonymous2ArrayOfd.message);
              com.mobike.mobikeapp.model.c.f.a().c(9);
            }
          });
          return;
        }
        com.mobike.mobikeapp.model.c.h.a(RideResultActivity.this, RideResultActivity.this.getString(2131296986));
      }
      
      public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
    };
  }
  
  private String o()
  {
    return com.mobike.mobikeapp.c.a.a(this.m.orderId, com.mobike.mobikeapp.util.e.a().i().id);
  }
  
  private String p()
  {
    return o() + "&share=true";
  }
  
  private void q()
  {
    if ((!com.mobike.mobikeapp.model.c.h.l(this)) || (this.m == null) || (TextUtils.isEmpty(this.m.orderId))) {
      return;
    }
    startActivity(TripDetailActivity.a(this.m.orderId, com.mobike.mobikeapp.util.e.a().i().id));
  }
  
  private Bitmap r()
  {
    int i1 = com.mobike.mobikeapp.model.c.h.a(this, 180.0F);
    this.k.setDrawingCacheEnabled(true);
    this.k.buildDrawingCache();
    Bitmap localBitmap = Bitmap.createScaledBitmap(this.k.getDrawingCache(), com.mobike.mobikeapp.model.c.h.m(this) - com.mobike.mobikeapp.model.c.h.a(this, 30.0F), i1, false);
    if (localBitmap != null)
    {
      this.k.setDrawingCacheEnabled(false);
      return localBitmap;
    }
    return null;
  }
  
  private void s()
  {
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 250)
    {
      if (paramInt2 == -1)
      {
        this.s = true;
        k();
      }
      while (paramInt2 != 10) {
        return;
      }
      this.r = false;
      k();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.n) {
      s();
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131755492: 
    case 2131755488: 
    case 2131755485: 
    case 2131755478: 
    case 2131755479: 
    case 2131755320: 
      do
      {
        return;
        m();
        return;
        q();
        return;
        AccountManager.a().a(new AccountManager.a()
        {
          public void a()
          {
            com.mobike.mobikeapp.model.c.h.b(RideResultActivity.this, WalletActivity.class);
          }
          
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            com.mobike.mobikeapp.model.c.h.a(RideResultActivity.this, paramAnonymousString);
          }
        });
        return;
        q();
        return;
        com.mobike.mobikeapp.model.c.h.b(this, WalletActivity.class);
        return;
      } while (!com.mobike.mobikeapp.model.c.h.g(this));
      c();
      return;
    case 2131755324: 
      f();
      return;
    case 2131755491: 
      a(paramView);
      return;
    case 2131755926: 
      a(SHARE_MEDIA.WEIXIN);
      MobclickAgent.c(paramView.getContext(), "20009");
      return;
    case 2131755927: 
      a(SHARE_MEDIA.WEIXIN_CIRCLE);
      MobclickAgent.c(paramView.getContext(), "20010");
      return;
    case 2131755928: 
      a(SHARE_MEDIA.QQ);
      MobclickAgent.c(paramView.getContext(), "20013");
      return;
    case 2131755929: 
      a(SHARE_MEDIA.QZONE);
      MobclickAgent.c(paramView.getContext(), "20011");
      return;
    case 2131755930: 
      b(SHARE_MEDIA.SINA);
      MobclickAgent.c(paramView.getContext(), "20012");
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968647);
    a();
    d();
    b();
    a(paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820552, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    com.mobike.mobikeapp.a.g.a(this);
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
      if (this.n) {
        s();
      }
      finish();
      VdsAgent.handleClickResult(new Boolean(true));
      return true;
    }
    MobclickAgent.c(this, "40031");
    paramMenuItem = new Intent(this, NormalCustomerServiceActivity.class);
    paramMenuItem.addFlags(268435456);
    startActivity(paramMenuItem);
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("uploadImage", this.s);
    paramBundle.putBoolean("isNeedUpload", this.r);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void watchDetail(View paramView)
  {
    if (this.m == null) {
      return;
    }
    startActivity(HelpCardActivity.a(this, this.m));
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/RideResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */