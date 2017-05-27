package com.mobike.mobikeapp.activity.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import com.alipay.sdk.app.PayTask;
import com.baidu.middleware.GeoRange;
import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.HelpCardActivity;
import com.mobike.mobikeapp.activity.pay.CreditCardSelectActivity;
import com.mobike.mobikeapp.adapter.PaymentMethodAdapter;
import com.mobike.mobikeapp.data.AliPayDataInfo;
import com.mobike.mobikeapp.data.AliPayResult;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.data.PaymentOrderResponse;
import com.mobike.mobikeapp.data.PaymentOrderResponse.PaymentOrderData;
import com.mobike.mobikeapp.data.WXPrepayDataInfo;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager;
import com.mobike.mobikeapp.util.AccountManager.PayApproach;
import com.mobike.mobikeapp.util.AccountManager.PayType;
import com.mobike.mobikeapp.util.AccountManager.a;
import com.mobike.mobikeapp.util.aa;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.util.r;
import com.mobike.mobikeapp.util.r.a;
import com.mobike.mobikeapp.widget.LoadingToastView;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class RegisterRechargeActivity
  extends BaseActivity
{
  private PaymentMethodAdapter a;
  private Animation b;
  private Handler e = new Handler();
  private r.a f;
  @BindView(a=2131755754)
  LoadingToastView mLoadingToastView;
  @BindView(a=2131755313)
  ListView mPayApproachList;
  @BindView(a=2131755317)
  Button mPayBtn;
  @BindView(a=2131755975)
  ImageView mProgressDot;
  
  private void a()
  {
    if (q.a().h())
    {
      AccountManager.a().a(null);
      q.a().a(this, 3);
      ContextCompat.startActivity(this, new Intent(this, IDCardVerifyActivity.class), null);
    }
    for (;;)
    {
      finish();
      return;
      q.a().a(this, 0);
      startActivity(HelpCardActivity.a(this, new Integer[] { Integer.valueOf(4) }));
      com.mobike.mobikeapp.model.c.f.a().b(true);
    }
  }
  
  private void a(int paramInt)
  {
    if (250 == paramInt) {
      finish();
    }
  }
  
  private void a(AccountManager.PayType paramPayType, int paramInt)
  {
    if (h.l(this))
    {
      this.mLoadingToastView.a();
      r.a(this).a(this.f);
      com.mobike.mobikeapp.a.f.a(paramPayType, AccountManager.PayApproach.WX_PAY, paramInt, -1, new a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          com.mobike.mobikeapp.util.m.a("message =" + paramAnonymousString);
          RegisterRechargeActivity.this.mLoadingToastView.b();
          RegisterRechargeActivity.this.mPayBtn.setEnabled(true);
          h.a(RegisterRechargeActivity.this, paramAnonymousString);
          RegisterRechargeActivity.a(RegisterRechargeActivity.this, paramAnonymousInt);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (WXPrepayDataInfo)new e().a(paramAnonymousJSONObject.toString(), WXPrepayDataInfo.class);
            if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.result == 0))
            {
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.prepayInfo;
              paramAnonymousArrayOfd = r.a(RegisterRechargeActivity.this).a(paramAnonymousArrayOfd);
              RegisterRechargeActivity.c(RegisterRechargeActivity.this).postDelayed(m.a(this, paramAnonymousArrayOfd), 1000L);
              r.a(RegisterRechargeActivity.this).a(RegisterRechargeActivity.this, true);
            }
          }
        }
      });
    }
  }
  
  private void a(String paramString)
  {
    this.mLoadingToastView.a();
    this.mLoadingToastView.setLoadingText(2131296778);
    com.mobike.mobikeapp.a.f.a(AccountManager.PayType.DEPOSIT, com.mobike.mobikeapp.model.c.f.a().f().intValue(), paramString, 0, new a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        RegisterRechargeActivity.this.mLoadingToastView.b();
        h.a(RegisterRechargeActivity.this, RegisterRechargeActivity.this.getString(2131296774));
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        RegisterRechargeActivity.this.mLoadingToastView.b();
        if (paramAnonymousJSONObject == null)
        {
          h.a(RegisterRechargeActivity.this, RegisterRechargeActivity.this.getString(2131296774));
          return;
        }
        AccountManager.a().a(new AccountManager.a()
        {
          public void a()
          {
            RegisterRechargeActivity.b(RegisterRechargeActivity.this);
          }
          
          public void a(int paramAnonymous2Int, String paramAnonymous2String)
          {
            RegisterRechargeActivity.this.mLoadingToastView.b();
            RegisterRechargeActivity.this.mPayBtn.setEnabled(true);
            h.a(RegisterRechargeActivity.this, paramAnonymous2String);
          }
        });
      }
    });
  }
  
  private void b(AccountManager.PayType paramPayType, int paramInt)
  {
    if (h.l(this))
    {
      this.mLoadingToastView.a();
      com.mobike.mobikeapp.a.f.a(paramPayType, AccountManager.PayApproach.ALI_PAY, paramInt, -1, new a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          RegisterRechargeActivity.this.mLoadingToastView.b();
          RegisterRechargeActivity.this.mPayBtn.setEnabled(true);
          h.a(RegisterRechargeActivity.this, paramAnonymousString);
          RegisterRechargeActivity.a(RegisterRechargeActivity.this, paramAnonymousInt);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (AliPayDataInfo)new e().a(paramAnonymousJSONObject.toString(), AliPayDataInfo.class);
            if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.result == 0))
            {
              RegisterRechargeActivity.c(RegisterRechargeActivity.this).postDelayed(n.a(this, paramAnonymousArrayOfd), 1000L);
              r.a(RegisterRechargeActivity.this).a(RegisterRechargeActivity.this, true);
            }
          }
          else
          {
            return;
          }
          h.a(RegisterRechargeActivity.this, paramAnonymousArrayOfd.message);
          RegisterRechargeActivity.this.mLoadingToastView.b();
          RegisterRechargeActivity.this.mPayBtn.setEnabled(true);
        }
      });
    }
  }
  
  private void b(String paramString)
  {
    new a(null).execute(new String[] { paramString });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 111)
    {
      if (paramInt2 == -1) {
        a(paramIntent.getStringExtra("SOURCE"));
      }
    }
    else {
      return;
    }
    this.mPayBtn.setEnabled(true);
  }
  
  @OnClick(a={2131755317})
  public void onClickPay()
  {
    if (h.l(this))
    {
      this.mPayBtn.setEnabled(false);
      if (q.a().g() != CountryEnum.China)
      {
        Intent localIntent = new Intent(this, CreditCardSelectActivity.class);
        localIntent.putExtra("TYPE", 1);
        startActivityForResult(localIntent, 111);
      }
    }
    else
    {
      return;
    }
    int i = com.mobike.mobikeapp.model.c.f.a().f().intValue();
    switch (6.a[this.a.c().ordinal()])
    {
    default: 
      return;
    case 1: 
      if (r.a(this).a())
      {
        a(AccountManager.PayType.DEPOSIT, i);
        return;
      }
      h.a(this, getString(2131297155));
      return;
    }
    b(AccountManager.PayType.DEPOSIT, i);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968643);
    ButterKnife.a(this);
    getSupportActionBar().k(2130837894);
    this.b = AnimationUtils.loadAnimation(this, 2131034162);
    this.f = j.a(this);
    if (!q.a().h())
    {
      findViewById(2131755976).setVisibility(8);
      findViewById(2131755974).setVisibility(4);
      findViewById(2131755337).setVisibility(8);
    }
    ((TextView)findViewById(2131755339)).setText(o.a(com.mobike.mobikeapp.model.c.f.a().f().intValue()));
    ((TextView)findViewById(2131755333)).setText(q.a().j().getPrefixSymbol());
    if (GeoRange.inCHINA())
    {
      ((TextView)findViewById(2131755340)).setText(2131296894);
      ((TextView)findViewById(2131755341)).setText(2131296898);
      ((TextView)findViewById(2131755338)).setText(2131296891);
      findViewById(2131755342).setVisibility(0);
    }
    if (q.a().g() == CountryEnum.China)
    {
      com.mobike.mobikeapp.a.f.h(new ad()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
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
              paramAnonymousArrayOfd = new PaymentMethodAdapter(RegisterRechargeActivity.this);
              continue;
            }
            paramAnonymousString = RegisterRechargeActivity.this;
            if ((paramAnonymousArrayOfd == null) || (paramAnonymousArrayOfd.data == null)) {
              continue;
            }
            paramAnonymousArrayOfd = new PaymentMethodAdapter(RegisterRechargeActivity.this, paramAnonymousArrayOfd.data.order, null);
            RegisterRechargeActivity.a(paramAnonymousString, paramAnonymousArrayOfd);
            return;
            paramAnonymousArrayOfd = (PaymentOrderResponse)new e().a(paramAnonymousString, PaymentOrderResponse.class);
          }
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          RegisterRechargeActivity.a(RegisterRechargeActivity.this, new PaymentMethodAdapter(RegisterRechargeActivity.this));
        }
        
        public void g()
        {
          RegisterRechargeActivity.this.mLoadingToastView.a();
          RegisterRechargeActivity.this.mPayBtn.setEnabled(false);
          RegisterRechargeActivity.this.mPayApproachList.setVisibility(8);
        }
        
        public void h()
        {
          RegisterRechargeActivity.this.mLoadingToastView.b();
          RegisterRechargeActivity.this.mPayApproachList.setAdapter(RegisterRechargeActivity.a(RegisterRechargeActivity.this));
          RegisterRechargeActivity.this.mPayApproachList.setVisibility(0);
          RegisterRechargeActivity.this.mPayBtn.setEnabled(true);
        }
      });
      return;
    }
    paramBundle = this.mPayApproachList;
    PaymentMethodAdapter localPaymentMethodAdapter = new PaymentMethodAdapter(this);
    this.a = localPaymentMethodAdapter;
    paramBundle.setAdapter(localPaymentMethodAdapter);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null)
    {
      this.e.removeCallbacksAndMessages(null);
      this.e = null;
    }
    this.f = null;
    this.mProgressDot.clearAnimation();
    if (this.a != null)
    {
      this.a.d();
      this.a = null;
    }
    this.b = null;
  }
  
  @OnItemClick(a={2131755313})
  public void onItemClickPay(int paramInt)
  {
    if (this.a.b() != paramInt)
    {
      this.a.d(paramInt);
      this.a.notifyDataSetChanged();
      if (!this.mPayBtn.isEnabled()) {
        this.mPayBtn.setEnabled(true);
      }
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
  
  protected void onPause()
  {
    this.mProgressDot.clearAnimation();
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.e.postDelayed(k.a(this), 100L);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e.postDelayed(l.a(this), 1000L);
  }
  
  private class a
    extends AsyncTask<String, Void, String>
  {
    private a() {}
    
    protected String a(String... paramVarArgs)
    {
      return new PayTask(RegisterRechargeActivity.this).pay(paramVarArgs[0], true);
    }
    
    protected void a(String paramString)
    {
      RegisterRechargeActivity.this.mLoadingToastView.b();
      RegisterRechargeActivity.this.mPayBtn.setEnabled(true);
      r.a(RegisterRechargeActivity.this).a(RegisterRechargeActivity.this, false);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new AliPayResult(paramString);
        paramString.getResult();
        paramString = paramString.getResultStatus();
        if (TextUtils.equals(paramString, "9000"))
        {
          RegisterRechargeActivity.b(RegisterRechargeActivity.this);
          aa.b();
        }
      }
      else
      {
        return;
      }
      if (TextUtils.equals(paramString, "8000"))
      {
        h.a(RegisterRechargeActivity.this, RegisterRechargeActivity.this.getString(2131296778));
        return;
      }
      h.a(RegisterRechargeActivity.this, RegisterRechargeActivity.this.getString(2131296774));
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/RegisterRechargeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */