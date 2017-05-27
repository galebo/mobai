package com.mobike.mobikeapp.activity.pay;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import com.alipay.sdk.app.PayTask;
import com.baidu.middleware.GeoRange;
import com.google.gson.JsonSyntaxException;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.adapter.PaymentMethodAdapter;
import com.mobike.mobikeapp.adapter.PaymentMethodAdapter.a;
import com.mobike.mobikeapp.data.AccountDataInfo;
import com.mobike.mobikeapp.data.AliPayDataInfo;
import com.mobike.mobikeapp.data.AliPayResult;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.PaymentOrderResponse;
import com.mobike.mobikeapp.data.PaymentOrderResponse.PaymentOrderData;
import com.mobike.mobikeapp.data.PricingStrategyResult;
import com.mobike.mobikeapp.data.PricingStrategyResult.Package;
import com.mobike.mobikeapp.data.PricingStrategyResult.PricingStrategy;
import com.mobike.mobikeapp.data.RechargePresentInfo.PackagesBean;
import com.mobike.mobikeapp.data.WXPrepayDataInfo;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager.PayApproach;
import com.mobike.mobikeapp.util.AccountManager.PayType;
import com.mobike.mobikeapp.util.AccountManager.a;
import com.mobike.mobikeapp.util.AccountManager.b;
import com.mobike.mobikeapp.util.aa;
import com.mobike.mobikeapp.util.r;
import com.mobike.mobikeapp.util.r.a;
import com.mobike.mobikeapp.widget.LoadingToastView;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.c;
import org.json.JSONObject;

public class PayActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String b = "pay_type";
  final boolean e;
  private int f;
  private AccountManager.PayType g;
  private PaymentMethodAdapter h;
  private c i;
  private b j;
  private r.a k;
  private Handler l = new Handler();
  private boolean m = false;
  @BindView(a=2131755754)
  LoadingToastView mLoadingToastView;
  @BindView(a=2131755313)
  ListView mPayApproachList;
  @BindView(a=2131755317)
  Button mPayBtn;
  @BindView(a=2131755311)
  GridView mRechargeValueList;
  
  public PayActivity()
  {
    if (com.mobike.mobikeapp.util.q.a().g() != CountryEnum.China) {
      bool = true;
    }
    this.e = bool;
  }
  
  private void a()
  {
    View localView;
    switch (9.a[this.g.ordinal()])
    {
    default: 
      findViewById(2131755310).setVisibility(0);
      findViewById(2131755307).setVisibility(8);
      findViewById(2131755314).setVisibility(0);
      if (com.mobike.mobikeapp.util.q.a().g() == CountryEnum.China)
      {
        c();
        setTitle(2131297021);
        this.mPayBtn.setText(2131296824);
        this.f = 0;
        boolean bool = com.mobike.mobikeapp.util.q.a().i();
        localView = findViewById(2131755316);
        if (!bool) {
          break label264;
        }
      }
      break;
    }
    label264:
    for (int n = 0;; n = 8)
    {
      localView.setVisibility(n);
      if (com.mobike.mobikeapp.util.q.a().g() != CountryEnum.China) {
        break label270;
      }
      com.mobike.mobikeapp.a.f.h(new ad()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
          com.mobike.mobikeapp.util.m.d(paramAnonymousString);
          for (;;)
          {
            try
            {
              boolean bool = TextUtils.isEmpty(paramAnonymousString);
              if (!bool) {
                continue;
              }
              paramAnonymousArrayOfd = null;
            }
            catch (JsonSyntaxException paramAnonymousArrayOfd)
            {
              paramAnonymousArrayOfd = null;
              continue;
              PayActivity.a(PayActivity.this, new PaymentMethodAdapter(PayActivity.this));
            }
            if ((paramAnonymousArrayOfd == null) || (paramAnonymousArrayOfd.data == null)) {
              continue;
            }
            PayActivity.a(PayActivity.this, new PaymentMethodAdapter(PayActivity.this, paramAnonymousArrayOfd.data.order, PayActivity.a(PayActivity.this)));
            if (PayActivity.b(PayActivity.this) > 0) {
              PayActivity.c(PayActivity.this).c(PayActivity.b(PayActivity.this));
            }
            PayActivity.c(PayActivity.this).a(paramAnonymousArrayOfd.data.redPacketValue);
            return;
            paramAnonymousArrayOfd = (PaymentOrderResponse)new com.google.gson.e().a(paramAnonymousString, PaymentOrderResponse.class);
          }
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          PayActivity.a(PayActivity.this, new PaymentMethodAdapter(PayActivity.this));
        }
        
        public void g()
        {
          PayActivity.a(PayActivity.this, true);
          PayActivity.this.mLoadingToastView.a();
          PayActivity.this.mPayBtn.setEnabled(false);
          PayActivity.this.findViewById(2131755316).setVisibility(8);
        }
        
        public void h()
        {
          PayActivity.this.mLoadingToastView.b();
          PayActivity.a(PayActivity.this, false);
          PayActivity.this.mPayApproachList.setAdapter(PayActivity.c(PayActivity.this));
          PayActivity.this.mPayApproachList.setVisibility(0);
          Button localButton = PayActivity.this.mPayBtn;
          if (PayActivity.b(PayActivity.this) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            localButton.setEnabled(bool);
            PayActivity.this.findViewById(2131755316).setVisibility(0);
            return;
          }
        }
      });
      return;
      findViewById(2131755310).setVisibility(8);
      findViewById(2131755307).setVisibility(0);
      findViewById(2131755314).setVisibility(8);
      setTitle(2131296828);
      this.mPayBtn.setText(2131296826);
      this.f = com.mobike.mobikeapp.model.c.f.a().f().intValue();
      ((TextView)findViewById(2131755308)).setText(com.mobike.mobikeapp.util.o.a(Integer.valueOf(this.f)));
      if (GeoRange.inCHINA()) {}
      for (n = 2131296777;; n = 2131296776)
      {
        ((TextView)findViewById(2131755309)).setText(n);
        break;
      }
      b();
      break;
    }
    label270:
    this.mPayApproachList.setVisibility(8);
    findViewById(2131755316).setVisibility(8);
  }
  
  private void a(AccountManager.PayType paramPayType, int paramInt1, int paramInt2)
  {
    if (h.l(this))
    {
      this.mLoadingToastView.a();
      r.a(this).a(this.k);
      com.mobike.mobikeapp.a.f.a(paramPayType, AccountManager.PayApproach.WX_PAY, paramInt1, paramInt2, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          PayActivity.this.mLoadingToastView.b();
          PayActivity.this.mPayBtn.setEnabled(true);
          h.a(PayActivity.this, paramAnonymousString);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (WXPrepayDataInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), WXPrepayDataInfo.class);
            if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.result == 0))
            {
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.prepayInfo;
              paramAnonymousArrayOfd = r.a(PayActivity.this).a(paramAnonymousArrayOfd);
              PayActivity.g(PayActivity.this).postDelayed(p.a(this, paramAnonymousArrayOfd), 1000L);
              r.a(PayActivity.this).a(PayActivity.this, true);
            }
          }
        }
      });
    }
  }
  
  private void a(String paramString)
  {
    new a(null).execute(new String[] { paramString });
  }
  
  private void a(List<RechargePresentInfo.PackagesBean> paramList)
  {
    boolean bool = false;
    GridView localGridView = this.mRechargeValueList;
    paramList = new c(paramList);
    this.i = paramList;
    localGridView.setAdapter(paramList);
    this.i.a(0);
    this.f = this.i.b().getRecharge_money();
    if (this.h != null) {
      this.h.c(this.f);
    }
    paramList = this.mPayBtn;
    if (this.f > 0) {
      bool = true;
    }
    paramList.setEnabled(bool);
    this.i.notifyDataSetChanged();
    this.mRechargeValueList.requestFocus();
  }
  
  private void b()
  {
    this.mLoadingToastView.a();
    this.mLoadingToastView.setLoadingText(2131296662);
    com.mobike.mobikeapp.a.f.b(new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (!PayActivity.d(PayActivity.this)) {
          PayActivity.this.mLoadingToastView.b();
        }
        h.a(PayActivity.this, PayActivity.this.getString(2131296779));
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if (!PayActivity.d(PayActivity.this)) {
          PayActivity.this.mLoadingToastView.b();
        }
        try
        {
          paramAnonymousArrayOfd = (PricingStrategyResult)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), PricingStrategyResult.class);
          if (paramAnonymousArrayOfd != null)
          {
            paramAnonymousArrayOfd = paramAnonymousArrayOfd.pricingStrategy.packages;
            paramAnonymousJSONObject = new ArrayList();
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousArrayOfd.size())
            {
              PricingStrategyResult.Package localPackage = (PricingStrategyResult.Package)paramAnonymousArrayOfd.get(paramAnonymousInt);
              RechargePresentInfo.PackagesBean localPackagesBean = new RechargePresentInfo.PackagesBean();
              localPackagesBean.setIndex(localPackage.id);
              localPackagesBean.setRecharge_money(localPackage.price);
              localPackagesBean.setFreeRides(localPackage.freeRides);
              paramAnonymousJSONObject.add(localPackagesBean);
              paramAnonymousInt += 1;
            }
          }
        }
        catch (JsonSyntaxException paramAnonymousArrayOfd)
        {
          for (;;)
          {
            paramAnonymousArrayOfd = null;
          }
          PayActivity.a(PayActivity.this, paramAnonymousJSONObject);
          return;
        }
        h.a(PayActivity.this, PayActivity.this.getString(2131296779));
      }
    });
  }
  
  private void b(AccountManager.PayType paramPayType, int paramInt1, int paramInt2)
  {
    if (h.l(this))
    {
      this.mLoadingToastView.a();
      com.mobike.mobikeapp.a.f.a(paramPayType, AccountManager.PayApproach.ALI_PAY, paramInt1, paramInt2, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          PayActivity.this.mLoadingToastView.b();
          PayActivity.this.mPayBtn.setEnabled(true);
          h.a(PayActivity.this, paramAnonymousString);
          PayActivity.a(PayActivity.this, paramAnonymousInt);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (AliPayDataInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), AliPayDataInfo.class);
            if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.result == 0))
            {
              PayActivity.g(PayActivity.this).postDelayed(q.a(this, paramAnonymousArrayOfd), 1000L);
              r.a(PayActivity.this).a(PayActivity.this, true);
            }
          }
          else
          {
            return;
          }
          h.a(PayActivity.this, paramAnonymousArrayOfd.message);
          PayActivity.this.mLoadingToastView.b();
          PayActivity.this.mPayBtn.setEnabled(true);
        }
      });
    }
  }
  
  private void c()
  {
    com.mobike.mobikeapp.a.f.g(new ad()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        if (!TextUtils.isEmpty(paramAnonymousString)) {
          paramAnonymousArrayOfd = null;
        }
        try
        {
          paramAnonymousString = new com.google.gson.n().a(paramAnonymousString);
          paramAnonymousArrayOfd = paramAnonymousString;
        }
        catch (JsonSyntaxException paramAnonymousString)
        {
          for (;;) {}
        }
        if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.q()) && (paramAnonymousArrayOfd.t().b("object")))
        {
          paramAnonymousArrayOfd = paramAnonymousArrayOfd.t();
          paramAnonymousArrayOfd = (ArrayList)new com.google.gson.e().a(paramAnonymousArrayOfd.c("object"), new com.google.gson.b.a() {}.b());
          if (paramAnonymousArrayOfd.size() > 0)
          {
            PayActivity.a(PayActivity.this, paramAnonymousArrayOfd);
            return;
          }
          PayActivity.e(PayActivity.this);
          return;
        }
        PayActivity.e(PayActivity.this);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        h.a(PayActivity.this, PayActivity.this.getResources().getString(2131296847));
        PayActivity.e(PayActivity.this);
      }
      
      public void g()
      {
        if (!PayActivity.d(PayActivity.this)) {
          PayActivity.this.mLoadingToastView.a();
        }
      }
      
      public void h()
      {
        if (!PayActivity.d(PayActivity.this)) {
          PayActivity.this.mLoadingToastView.b();
        }
      }
    });
  }
  
  private void c(int paramInt)
  {
    if (250 == paramInt) {
      finish();
    }
  }
  
  private void d()
  {
    Object localObject = this.mRechargeValueList;
    b localb = new b(null);
    this.j = localb;
    ((GridView)localObject).setAdapter(localb);
    this.f = this.j.a().b();
    if (this.h != null) {
      this.h.c(this.f);
    }
    localObject = this.mPayBtn;
    if (this.f > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject).setEnabled(bool);
      this.j.notifyDataSetChanged();
      this.mRechargeValueList.requestFocus();
      return;
    }
  }
  
  private void e()
  {
    this.mLoadingToastView.setLoadingText(2131296778);
    this.l.postDelayed(o.a(this), 3000L);
  }
  
  @OnItemClick(a={2131755313})
  void OnItemClickInApproach(int paramInt)
  {
    if ((this.h.b() == paramInt) || ((this.h.e(paramInt).a() == AccountManager.PayApproach.REDPACKET) && (!this.h.a()))) {
      return;
    }
    this.h.d(paramInt);
    this.h.notifyDataSetChanged();
    Button localButton = this.mPayBtn;
    if (this.f > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  @OnItemClick(a={2131755311})
  void OnItemClickInGrid(AdapterView<?> paramAdapterView, int paramInt)
  {
    boolean bool2 = true;
    Object localObject1 = paramAdapterView.getAdapter();
    Object localObject2;
    if ((localObject1 instanceof b))
    {
      localObject2 = (b)localObject1;
      ((b)localObject2).a(paramInt);
      this.f = ((b)localObject2).a().b();
      Button localButton = this.mPayBtn;
      if (this.f > 0)
      {
        bool1 = true;
        localButton.setEnabled(bool1);
        ((b)localObject2).notifyDataSetChanged();
      }
    }
    else if ((localObject1 instanceof c))
    {
      localObject1 = (c)localObject1;
      ((c)localObject1).a(paramInt);
      this.f = ((c)localObject1).b().getRecharge_money();
      localObject2 = this.mPayBtn;
      if (this.f <= 0) {
        break label194;
      }
    }
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Button)localObject2).setEnabled(bool1);
      ((c)localObject1).notifyDataSetChanged();
      paramAdapterView.requestFocus();
      if (this.h != null)
      {
        this.h.c(this.f);
        if (this.h.e(this.h.b()).a() == AccountManager.PayApproach.REDPACKET) {
          this.mPayBtn.setEnabled(this.h.a());
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this, 2131427642).setMessage(getString(2131296853, new Object[] { com.mobike.mobikeapp.util.o.a(Integer.valueOf(paramInt)) })).setNegativeButton(17039360, l.a(this)).setPositiveButton(17039370, m.a(this, paramInt)).create();
    localAlertDialog.setCanceledOnTouchOutside(false);
    if (!(localAlertDialog instanceof AlertDialog))
    {
      localAlertDialog.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)localAlertDialog);
  }
  
  public void b(int paramInt)
  {
    if ((this.i == null) || (this.e)) {}
    for (int n = -1;; n = this.i.a())
    {
      com.mobike.mobikeapp.a.f.a(paramInt, n, new com.mobike.mobikeapp.a.e(com.mobike.mobikeapp.model.data.a.class)
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          h.a(PayActivity.this, paramAnonymousString);
          PayActivity.this.mPayBtn.setEnabled(true);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, com.mobike.mobikeapp.model.data.a paramAnonymousa)
        {
          h.a(PayActivity.this, paramAnonymousa.message);
          c.a().d(new AccountDataInfo());
          PayActivity.this.finish();
        }
        
        public void g()
        {
          PayActivity.this.mLoadingToastView.a();
        }
        
        public void h()
        {
          PayActivity.this.mLoadingToastView.b();
        }
      });
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int n = -1;
    if (paramInt1 == 111) {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("SOURCE");
        this.mLoadingToastView.a();
        this.mLoadingToastView.setLoadingText(2131296778);
        localPayType = this.g;
        paramInt1 = n;
        if (this.g == AccountManager.PayType.DEPOSIT) {
          paramInt1 = this.f;
        }
        if (this.g == AccountManager.PayType.RECHARGE)
        {
          paramInt2 = this.i.b().getIndex();
          com.mobike.mobikeapp.a.f.a(localPayType, paramInt1, paramIntent, paramInt2, new com.mobike.mobikeapp.model.b.a()
          {
            public void a(int paramAnonymousInt, String paramAnonymousString)
            {
              PayActivity.this.mLoadingToastView.b();
              h.a(PayActivity.this, PayActivity.this.getString(2131296774));
            }
            
            public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
            {
              if (paramAnonymousJSONObject == null)
              {
                PayActivity.this.mLoadingToastView.b();
                h.a(PayActivity.this, PayActivity.this.getString(2131296774));
                return;
              }
              if (PayActivity.a(PayActivity.this) == AccountManager.PayType.DEPOSIT)
              {
                if (!com.mobike.mobikeapp.util.q.a().h()) {
                  break label72;
                }
                com.mobike.mobikeapp.util.q.a().a(PayActivity.this, 3);
              }
              for (;;)
              {
                PayActivity.f(PayActivity.this);
                return;
                label72:
                com.mobike.mobikeapp.util.q.a().a(PayActivity.this, 0);
              }
            }
          });
        }
      }
    }
    while (paramInt1 != 1)
    {
      for (;;)
      {
        AccountManager.PayType localPayType;
        return;
        paramInt2 = 0;
      }
      this.mPayBtn.setEnabled(true);
      return;
    }
    if (com.mobike.mobikeapp.util.q.a().b())
    {
      a();
      return;
    }
    finish();
  }
  
  @OnClick(a={2131755317})
  void onClickPay()
  {
    if (this.f > 0)
    {
      if (h.l(this))
      {
        this.mPayBtn.setEnabled(false);
        if ((this.i != null) && (!this.e)) {
          break label89;
        }
        n = -1;
        label38:
        if (!this.e) {
          break label100;
        }
      }
      label89:
      label100:
      for (Object localObject = AccountManager.PayApproach.STRIPE;; localObject = this.h.c()) {
        switch (9.b[localObject.ordinal()])
        {
        default: 
          return;
          n = this.i.a();
          break label38;
        }
      }
      if (r.a(this).a())
      {
        a(this.g, this.f, n);
        return;
      }
      h.a(this, getString(2131297155));
      return;
      b(this.g, this.f, n);
      return;
      localObject = new Intent(this, CreditCardSelectActivity.class);
      if (this.g == AccountManager.PayType.DEPOSIT) {}
      for (int n = 1;; n = 0)
      {
        ((Intent)localObject).putExtra("TYPE", n);
        startActivityForResult((Intent)localObject, 111);
        return;
      }
      a(this.f);
      return;
    }
    h.a(this, getString(2131296620));
  }
  
  @OnClick(a={2131755315})
  void onClickProtocol()
  {
    startActivity(CustomerServiceWebActivity.a(this, getString(2131296786), com.mobike.mobikeapp.c.a.e()));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968637);
    ButterKnife.a(this);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.g = AccountManager.PayType.values()[paramBundle.getIntExtra("pay_type", 1)];
    }
    if (com.mobike.mobikeapp.util.q.a().b()) {
      a();
    }
    for (;;)
    {
      this.k = k.a(this);
      return;
      startActivityForResult(LoginActivity.a(), 1);
    }
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
    }
    finish();
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.l.postDelayed(n.a(this), 1000L);
  }
  
  private class a
    extends AsyncTask<String, Void, String>
  {
    private a() {}
    
    protected String a(String... paramVarArgs)
    {
      return new PayTask(PayActivity.this).pay(paramVarArgs[0], true);
    }
    
    protected void a(String paramString)
    {
      r.a(PayActivity.this).a(PayActivity.this, false);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new AliPayResult(paramString);
        paramString.getResult();
        paramString = paramString.getResultStatus();
        if (TextUtils.equals(paramString, "9000"))
        {
          if ((com.mobike.mobikeapp.util.q.a().b(PayActivity.this) == 2) && (PayActivity.a(PayActivity.this) != null) && (PayActivity.a(PayActivity.this) == AccountManager.PayType.DEPOSIT))
          {
            com.mobike.mobikeapp.util.q.a().a(PayActivity.this, 3);
            if (PayActivity.a(PayActivity.this) == AccountManager.PayType.DEPOSIT) {
              aa.b();
            }
          }
          PayActivity.f(PayActivity.this);
        }
      }
      else
      {
        return;
      }
      if (TextUtils.equals(paramString, "8000")) {
        h.a(PayActivity.this, PayActivity.this.getString(2131296778));
      }
      for (;;)
      {
        PayActivity.this.mLoadingToastView.b();
        PayActivity.this.mPayBtn.setEnabled(true);
        return;
        h.a(PayActivity.this, PayActivity.this.getString(2131296774));
      }
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private final AccountManager.b[] b = { new AccountManager.b(10, 1000), new AccountManager.b(20, 2000), new AccountManager.b(50, 5000), new AccountManager.b(100, 10000) };
    private int c = 0;
    
    private b() {}
    
    public AccountManager.b a()
    {
      return this.b[this.c];
    }
    
    public void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public int getCount()
    {
      return this.b.length;
    }
    
    public Object getItem(int paramInt)
    {
      return this.b[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = View.inflate(PayActivity.this, 2130968805, null);
      }
      paramView = (AccountManager.b)getItem(paramInt);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131755817);
      localTextView.setText(PayActivity.this.getString(2131296784, new Object[] { paramView.c() }));
      if (this.c == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setSelected(bool);
        return paramViewGroup;
      }
    }
  }
  
  private class c
    extends BaseAdapter
  {
    List<RechargePresentInfo.PackagesBean> a;
    private int c = 0;
    
    public c()
    {
      List localList;
      this.a = localList;
    }
    
    public int a()
    {
      return this.c;
    }
    
    public void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public RechargePresentInfo.PackagesBean b()
    {
      return b(this.c);
    }
    
    public RechargePresentInfo.PackagesBean b(int paramInt)
    {
      return (RechargePresentInfo.PackagesBean)this.a.get(paramInt);
    }
    
    public int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool3 = true;
      boolean bool2 = true;
      Object localObject;
      if (com.mobike.mobikeapp.util.q.a().g() == CountryEnum.China)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = View.inflate(PayActivity.this, 2130968822, null);
        }
        paramView = b(paramInt);
        localTextView = (TextView)paramViewGroup.findViewById(2131755876);
        localObject = (TextView)paramViewGroup.findViewById(2131755877);
        LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131755875);
        localTextView.setText(PayActivity.this.getString(2131296845, new Object[] { Integer.valueOf(paramView.getRecharge_money() / 100) }));
        if (paramView.getType() != 0)
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setText(PayActivity.this.getString(2131296846, new Object[] { Integer.valueOf(paramView.getGiven_money() / 100) }));
          if (this.c != paramInt) {
            break label216;
          }
          bool1 = true;
          label160:
          localTextView.setSelected(bool1);
          if (this.c != paramInt) {
            break label222;
          }
          bool1 = true;
          label178:
          ((TextView)localObject).setSelected(bool1);
          if (this.c != paramInt) {
            break label228;
          }
        }
        label216:
        label222:
        label228:
        for (bool1 = bool2;; bool1 = false)
        {
          localLinearLayout.setSelected(bool1);
          return paramViewGroup;
          ((TextView)localObject).setVisibility(8);
          break;
          bool1 = false;
          break label160;
          bool1 = false;
          break label178;
        }
      }
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = View.inflate(PayActivity.this, 2130968815, null);
      }
      paramView = b(paramInt);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131755117);
      localTextView.setText(com.mobike.mobikeapp.util.o.a(Integer.valueOf(paramView.getRecharge_money())));
      if (this.c == paramInt)
      {
        bool1 = true;
        localTextView.setSelected(bool1);
        localTextView = (TextView)paramViewGroup.findViewById(2131755845);
        if (paramView.getFreeRides() != 1) {
          break label363;
        }
        paramView = PayActivity.this.getString(2131296781);
        localTextView.setText(paramView);
        if (this.c != paramInt) {
          break label444;
        }
      }
      label363:
      label444:
      for (boolean bool1 = bool3;; bool1 = false)
      {
        localTextView.setSelected(bool1);
        return paramViewGroup;
        bool1 = false;
        break;
        localObject = PayActivity.this;
        if (paramView.getFreeRides() > 0) {}
        for (paramView = "+" + paramView.getFreeRides();; paramView = "" + paramView.getFreeRides())
        {
          paramView = ((PayActivity)localObject).getString(2131296780, new Object[] { paramView });
          break;
        }
      }
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */