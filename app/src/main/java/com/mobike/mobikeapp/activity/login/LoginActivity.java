package com.mobike.mobikeapp.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.middleware.GeoRange;
import com.bumptech.glide.l;
import com.bumptech.glide.o;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.LoginDataInfo;
import com.mobike.mobikeapp.data.LoginDataInfo.LoginData;
import com.mobike.mobikeapp.util.AccountManager;
import com.mobike.mobikeapp.util.a;
import com.mobike.mobikeapp.util.aa;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;
import com.umeng.socialize.bean.SHARE_MEDIA;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity
  extends BaseActivity
  implements com.mobike.mobikeapp.b.a.e
{
  private EditText a;
  private Spinner b;
  private ArrayAdapter<CountryEnum> e;
  private EditText f;
  private Button g;
  private TextView h;
  private Button i;
  private TextView j;
  private CircleImageView k;
  private LoadingToastView l;
  private boolean m;
  @BindView(a=2131755271)
  ImageButton mQQlogInBt;
  @BindView(a=2131755267)
  View mSsoLayout;
  @BindView(a=2131755259)
  ViewStub mViewStub;
  @BindView(a=2131755270)
  ImageButton mWechatLogInBt;
  private CountDownTimer n;
  private com.mobike.mobikeapp.b.a.i o;
  private String p;
  private String q;
  
  public static Intent a()
  {
    return new Intent("android.intent.action.VIEW", Uri.parse("mobike://home/login"));
  }
  
  private void a(int paramInt)
  {
    q.a().a(this, paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      finish();
      return;
      aa.a();
      startActivity(new Intent(this, RegisterRechargeActivity.class));
      continue;
      startActivity(new Intent(this, IDCardVerifyActivity.class));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.a();
      return;
    }
    this.l.b();
  }
  
  private boolean a(String paramString, CountryEnum paramCountryEnum)
  {
    try
    {
      paramString = PhoneNumberUtil.c().b(paramString, paramCountryEnum.iso);
      return PhoneNumberUtil.c().f(paramString);
    }
    catch (NumberParseException paramString) {}
    return false;
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.a.setError(getString(2131296559));
      this.a.requestFocus();
      return false;
    }
    if (!a(paramString, f()))
    {
      this.a.setError(getString(2131296565));
      this.a.requestFocus();
      return false;
    }
    return true;
  }
  
  private boolean c(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private CountryEnum f()
  {
    return (CountryEnum)this.e.getItem(this.b.getSelectedItemPosition());
  }
  
  private void k()
  {
    this.a.setError(getString(2131296565));
    this.a.requestFocus();
  }
  
  private void l()
  {
    this.a.setError(null);
    String str = n();
    if (b(str))
    {
      q.a().d(str);
      if (com.mobike.mobikeapp.model.c.h.l(this))
      {
        this.g.setEnabled(false);
        this.l.setLoadingText(2131296591);
        a(true);
        com.mobike.mobikeapp.a.f.a(str, new n()
        {
          public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
          {
            LoginActivity.a(LoginActivity.this, false);
            LoginActivity.g(LoginActivity.this).setEnabled(true);
            LoginActivity.h(LoginActivity.this).requestFocus();
          }
          
          public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
          {
            LoginActivity.a(LoginActivity.this, false);
            if (paramAnonymousJSONObject != null) {}
            for (;;)
            {
              try
              {
                switch (paramAnonymousJSONObject.getInt("code"))
                {
                case 0: 
                  paramAnonymousArrayOfd = paramAnonymousJSONObject.getString("message");
                  if (!TextUtils.isEmpty(paramAnonymousArrayOfd)) {
                    com.mobike.mobikeapp.model.c.h.a(LoginActivity.this, paramAnonymousArrayOfd);
                  }
                  LoginActivity.g(LoginActivity.this).setEnabled(true);
                  return;
                }
              }
              catch (JSONException paramAnonymousArrayOfd)
              {
                LoginActivity.g(LoginActivity.this).setEnabled(true);
                return;
              }
              LoginActivity.i(LoginActivity.this);
              LoginActivity.h(LoginActivity.this).requestFocus();
              LoginActivity.a(LoginActivity.this, new CountDownTimer(60000L, 1000L)
              {
                public void onFinish()
                {
                  LoginActivity.g(LoginActivity.this).setText(2131296588);
                  LoginActivity.g(LoginActivity.this).setEnabled(true);
                  LoginActivity.b(LoginActivity.this, false);
                }
                
                public void onTick(long paramAnonymous2Long)
                {
                  LoginActivity.g(LoginActivity.this).setText(String.format(LoginActivity.this.getResources().getString(2131296589), new Object[] { Long.valueOf(paramAnonymous2Long / 1000L) }));
                  LoginActivity.g(LoginActivity.this).setEnabled(false);
                  LoginActivity.b(LoginActivity.this, true);
                }
              }.start());
              com.mobike.mobikeapp.model.c.h.a(LoginActivity.this, LoginActivity.this.getString(2131296963));
              return;
              LoginActivity.c(LoginActivity.this);
              LoginActivity.g(LoginActivity.this).setEnabled(true);
              return;
              LoginActivity.g(LoginActivity.this).setEnabled(true);
              return;
            }
          }
        });
      }
    }
  }
  
  private void m()
  {
    if (this.n != null) {
      this.n.cancel();
    }
  }
  
  private String n()
  {
    if (f() == CountryEnum.China) {
      return this.a.getText().toString();
    }
    return this.b.getSelectedItem() + this.a.getText().toString();
  }
  
  private void o()
  {
    a(false);
    this.i.setEnabled(true);
    com.mobike.mobikeapp.model.c.h.a(this, getString(2131296677));
  }
  
  private void p()
  {
    this.f.setError(getString(2131296566));
    this.f.requestFocus();
    a(false);
    this.i.setEnabled(true);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (LoginDataInfo)new com.google.gson.e().a(paramString, LoginDataInfo.class);
      if ((paramString == null) || (paramString.logindata == null)) {
        break label225;
      }
      paramString = paramString.logindata;
      q.a().a(getApplicationContext(), paramString.userId, paramString.mobileNo, paramString.accessToken, paramString.publicKey);
      com.mobike.mobikeapp.model.c.f.a().a(paramString.nickName);
      com.mobike.mobikeapp.model.c.f.a().c(paramString.shareValue);
      com.mobike.mobikeapp.model.c.f.a().a(paramString.mAddresses);
      com.mobike.mobikeapp.model.c.f.a().a(Integer.valueOf(paramString.requestedDeposit));
      q.a().b(getApplicationContext(), paramString.userName);
      q.a().e(getApplicationContext(), paramString.userAvatar);
      com.mobike.mobikeapp.a.b.b(getApplicationContext(), q.a().a(this));
      q.a().d(getApplicationContext(), paramString.comment);
      q.a().a(getApplicationContext(), paramString.country);
      q.a().b(getApplicationContext(), paramString.currency);
      AccountManager.a().a(paramString.deposit);
      a(false);
      m();
      a(paramString.progress);
      a.l();
    }
    label225:
    do
    {
      return;
      p();
    } while (TextUtils.isEmpty(paramString.message));
    com.mobike.mobikeapp.model.c.h.a(this, paramString.message);
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.p = ((String)paramMap.get("unionid"));
    this.q = ((String)paramMap.get("source"));
    Object localObject1 = this.mViewStub.inflate();
    this.mViewStub.setVisibility(0);
    this.mSsoLayout.setVisibility(8);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131755914);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131755915);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.q))
    {
      localStringBuilder.append(getString(2131296993));
      if (this.q.equals("WX_APP"))
      {
        localStringBuilder.append(getString(2131296995));
        localStringBuilder.append(getString(2131296994));
      }
    }
    else
    {
      ((TextView)localObject2).setText(localStringBuilder.toString());
      localObject1 = (CircleImageView)((View)localObject1).findViewById(2131755913);
      localObject2 = l.a(this).a((String)paramMap.get("profile_image_url"));
      if (!this.q.equals("WX_APP")) {
        break label276;
      }
    }
    label276:
    for (int i1 = 2130838319;; i1 = 2130838073)
    {
      ((com.bumptech.glide.g)localObject2).d(i1).g().a((ImageView)localObject1);
      localTextView.setText((CharSequence)paramMap.get("screen_name"));
      return;
      if (!this.q.equals("QQ")) {
        break;
      }
      localStringBuilder.append(getString(2131296996));
      break;
    }
  }
  
  public void b()
  {
    EditText localEditText = null;
    this.a.setError(null);
    this.f.setError(null);
    String str1 = n();
    String str2 = this.f.getText().toString();
    if (TextUtils.isEmpty(str2))
    {
      this.f.setError(getString(2131296564));
      localEditText = this.f;
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (TextUtils.isEmpty(str1))
      {
        this.a.setError(getString(2131296559));
        localEditText = this.a;
      }
      do
      {
        i1 = 1;
        while (i1 != 0)
        {
          localEditText.requestFocus();
          return;
          if (!a(str1, f()))
          {
            this.a.setError(getString(2131296565));
            localEditText = this.a;
            i1 = 1;
          }
        }
      } while (!com.mobike.mobikeapp.model.c.h.l(this));
      this.l.setLoadingText(2131296534);
      a(true);
      this.i.setEnabled(false);
      com.mobike.mobikeapp.a.f.a(str1, str2, this.q, this.p, new ad()
      {
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            paramAnonymousArrayOfd = new com.google.gson.e();
            paramAnonymousString = (LoginDataInfo)paramAnonymousArrayOfd.a(paramAnonymousString, LoginDataInfo.class);
            if ((paramAnonymousString != null) && (paramAnonymousString.logindata != null))
            {
              q localq = q.a();
              LoginActivity localLoginActivity = LoginActivity.this;
              if (paramAnonymousString.logindata.ssoUserInfoArrayList != null)
              {
                paramAnonymousArrayOfd = paramAnonymousArrayOfd.b(paramAnonymousString.logindata.ssoUserInfoArrayList);
                localq.c(localLoginActivity, paramAnonymousArrayOfd);
                paramAnonymousArrayOfd = paramAnonymousString.logindata;
                q.a().a(LoginActivity.this.getApplicationContext(), paramAnonymousArrayOfd.userId, paramAnonymousArrayOfd.mobileNo, paramAnonymousArrayOfd.accessToken, paramAnonymousArrayOfd.publicKey);
                com.mobike.mobikeapp.model.c.f.a().a(paramAnonymousArrayOfd.nickName);
                com.mobike.mobikeapp.model.c.f.a().c(paramAnonymousArrayOfd.shareValue);
                com.mobike.mobikeapp.model.c.f.a().a(paramAnonymousArrayOfd.mAddresses);
                com.mobike.mobikeapp.model.c.f.a().a(Integer.valueOf(paramAnonymousArrayOfd.requestedDeposit));
                q.a().b(LoginActivity.this.getApplicationContext(), paramAnonymousArrayOfd.userName);
                q.a().e(LoginActivity.this.getApplicationContext(), paramAnonymousArrayOfd.userAvatar);
                com.mobike.mobikeapp.a.b.b(LoginActivity.this.getApplicationContext(), q.a().a(LoginActivity.this));
                q.a().d(LoginActivity.this.getApplicationContext(), paramAnonymousArrayOfd.comment);
                q.a().a(LoginActivity.this.getApplicationContext(), paramAnonymousArrayOfd.country);
                q.a().b(LoginActivity.this.getApplicationContext(), paramAnonymousArrayOfd.currency);
                AccountManager.a().a(paramAnonymousArrayOfd.deposit);
                LoginActivity.a(LoginActivity.this, false);
                LoginActivity.i(LoginActivity.this);
                LoginActivity.a(LoginActivity.this, paramAnonymousArrayOfd.progress);
                a.l();
              }
            }
            do
            {
              return;
              paramAnonymousArrayOfd = "";
              break;
              LoginActivity.j(LoginActivity.this);
            } while (TextUtils.isEmpty(paramAnonymousString.message));
            com.mobike.mobikeapp.model.c.h.a(LoginActivity.this, paramAnonymousString.message);
            return;
          }
          LoginActivity.k(LoginActivity.this);
        }
        
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          LoginActivity.k(LoginActivity.this);
        }
      });
      return;
    }
  }
  
  public void c()
  {
    this.l.a();
  }
  
  public void d()
  {
    this.l.b();
  }
  
  public void e()
  {
    Toast localToast = Toast.makeText(this, getString(2131297002), 0);
    if (!(localToast instanceof Toast))
    {
      localToast.show();
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.o.a(paramInt1, paramInt2, paramIntent);
  }
  
  @OnClick(a={2131755271})
  public void onClickQQ()
  {
    this.o.a(SHARE_MEDIA.QQ);
  }
  
  @OnClick(a={2131755270})
  public void onClickWeChat()
  {
    this.o.a(SHARE_MEDIA.WEIXIN);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968626);
    ButterKnife.a(this);
    this.o = new com.mobike.mobikeapp.b.d(this);
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21)) {
      findViewById(2131755256).setPadding(0, com.mobike.mobikeapp.model.c.h.q(this), 0, 0);
    }
    getSupportActionBar().k(2130837894);
    this.g = ((Button)findViewById(2131755188));
    this.g.setOnClickListener(e.a(this));
    this.g.setEnabled(false);
    this.h = ((TextView)findViewById(2131755264));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = LoginActivity.a(LoginActivity.this).getText().toString();
        if ((LoginActivity.a(LoginActivity.this, paramAnonymousView)) && (com.mobike.mobikeapp.model.c.h.l(LoginActivity.this)))
        {
          if (LoginActivity.b(LoginActivity.this)) {
            com.mobike.mobikeapp.model.c.h.a(LoginActivity.this, LoginActivity.this.getString(2131297137));
          }
        }
        else {
          return;
        }
        q.a().d(paramAnonymousView);
        com.mobike.mobikeapp.a.f.b(paramAnonymousView, new n()
        {
          public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, String paramAnonymous2String, Throwable paramAnonymous2Throwable)
          {
            com.mobike.mobikeapp.model.c.h.a(LoginActivity.this, LoginActivity.this.getString(2131296965));
          }
          
          public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, Throwable paramAnonymous2Throwable, JSONArray paramAnonymous2JSONArray)
          {
            super.a(paramAnonymous2Int, paramAnonymous2ArrayOfd, paramAnonymous2Throwable, paramAnonymous2JSONArray);
          }
          
          public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, Throwable paramAnonymous2Throwable, JSONObject paramAnonymous2JSONObject)
          {
            super.a(paramAnonymous2Int, paramAnonymous2ArrayOfd, paramAnonymous2Throwable, paramAnonymous2JSONObject);
          }
          
          public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
          {
            for (;;)
            {
              try
              {
                switch (paramAnonymous2JSONObject.getInt("code"))
                {
                case 0: 
                  paramAnonymous2ArrayOfd = paramAnonymous2JSONObject.getString("object");
                  com.mobike.mobikeapp.model.c.h.a(LoginActivity.this, paramAnonymous2ArrayOfd);
                  return;
                }
              }
              catch (JSONException paramAnonymous2ArrayOfd)
              {
                paramAnonymous2ArrayOfd.printStackTrace();
                return;
              }
              new b.a(LoginActivity.this, 2131427642).a(2131297134).b(2131297135).a(2131296393).a(2131296624, i.a()).b().show();
              return;
              LoginActivity.c(LoginActivity.this);
              return;
            }
          }
        });
      }
    });
    this.b = ((Spinner)findViewById(2131755262));
    paramBundle = new CountryEnum[2];
    paramBundle[0] = CountryEnum.China;
    paramBundle[1] = CountryEnum.Singapore;
    this.e = new a(this, 2130968839, paramBundle);
    this.b.setAdapter(this.e);
    this.b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      @Instrumented
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemSelected(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (CountryEnum)LoginActivity.d(LoginActivity.this).getItem(paramAnonymousInt);
        paramAnonymousView = LoginActivity.e(LoginActivity.this);
        if (paramAnonymousAdapterView == CountryEnum.China) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = 4)
        {
          paramAnonymousView.setVisibility(paramAnonymousInt);
          return;
        }
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    Object localObject = com.mobike.mobikeapp.util.g.a(this);
    int i1;
    if (localObject != null)
    {
      i1 = 0;
      while (i1 < paramBundle.length)
      {
        if (paramBundle[i1] == localObject) {
          this.b.setSelection(i1);
        }
        i1 += 1;
      }
    }
    paramBundle = this.b;
    if (!GeoRange.inCHINA())
    {
      i1 = 1;
      paramBundle.setSelection(i1);
      paramBundle = findViewById(2131755261);
      localObject = findViewById(2131755260);
      if (GeoRange.inCHINA()) {
        break label435;
      }
      paramBundle.setVisibility(0);
      ((View)localObject).setVisibility(8);
    }
    for (;;)
    {
      this.a = ((EditText)findViewById(2131755263));
      this.a.clearFocus();
      this.a.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          boolean bool = true;
          if (paramAnonymousEditable.length() == 0)
          {
            LoginActivity.f(LoginActivity.this).setEnabled(false);
            LoginActivity.g(LoginActivity.this).setEnabled(false);
            return;
          }
          if (!LoginActivity.b(LoginActivity.this)) {
            LoginActivity.g(LoginActivity.this).setEnabled(true);
          }
          paramAnonymousEditable = LoginActivity.f(LoginActivity.this);
          if ((LoginActivity.b(LoginActivity.this, LoginActivity.a(LoginActivity.this).getText().toString())) && (!TextUtils.isEmpty(LoginActivity.h(LoginActivity.this).getText().toString()))) {}
          for (;;)
          {
            paramAnonymousEditable.setEnabled(bool);
            return;
            bool = false;
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.f = ((EditText)findViewById(2131755187));
      this.f.setOnEditorActionListener(f.a(this));
      this.i = ((Button)findViewById(2131755265));
      this.i.setOnClickListener(g.a(this));
      this.f.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (paramAnonymousEditable.length() == 0)
          {
            LoginActivity.f(LoginActivity.this).setEnabled(false);
            return;
          }
          LoginActivity.f(LoginActivity.this).setEnabled(LoginActivity.b(LoginActivity.this, LoginActivity.a(LoginActivity.this).getText().toString()));
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.l = ((LoadingToastView)findViewById(2131755754));
      ((TextView)findViewById(2131755266)).setOnClickListener(h.a(this));
      return;
      i1 = 0;
      break;
      label435:
      paramBundle.setVisibility(8);
      ((View)localObject).setVisibility(0);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.mobike.mobikeapp.a.g.a(this);
    this.o.a();
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
    super.onPause();
    com.mobike.mobikeapp.model.c.h.a(this, this.a);
  }
  
  private class a<T>
    extends ArrayAdapter<T>
  {
    public a(int paramInt, T[] paramArrayOfT)
    {
      super(paramArrayOfT, arrayOfObject);
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = LoginActivity.this.getLayoutInflater().inflate(17367049, paramViewGroup, false);
      }
      paramView = (CountryEnum)getItem(paramInt);
      ((TextView)localView.findViewById(16908308)).setText(paramView.mobileCode + " " + com.mobike.mobikeapp.util.g.a(LoginActivity.this, paramView.iso));
      return localView;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */