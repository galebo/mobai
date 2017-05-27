package com.mobike.mobikeapp.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import butterknife.OnTouch;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.HelpCardActivity;
import com.mobike.mobikeapp.data.ManualCampusVerifyDataInfo;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.aa;
import com.mobike.mobikeapp.util.m;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class IDCardVerifyActivity
  extends BaseActivity
{
  private static final int a = 1000;
  private Handler b = new Handler();
  private Animation e;
  @BindView(a=2131755209)
  View mEditView;
  @BindView(a=2131755210)
  EditText mIDCardNameView;
  @BindView(a=2131755211)
  EditText mIDCardNoView;
  @BindView(a=2131755214)
  View mPendingView;
  @BindView(a=2131755977)
  ImageView mProgressDot;
  @BindView(a=2131755754)
  LoadingToastView mProgressView;
  @BindView(a=2131755215)
  View mRejectedView;
  @BindView(a=2131755212)
  Button mVerifyBtn;
  @BindView(a=2131755208)
  ScrollView mVerifyIDCardForm;
  
  private void a()
  {
    startActivityForResult(new Intent(this, SubmitIDInfoActivity.class), 1000);
  }
  
  private void a(String paramString)
  {
    this.mProgressView.b();
    this.mVerifyBtn.setEnabled(true);
    if (!TextUtils.isEmpty(paramString))
    {
      h.a(this, paramString);
      return;
    }
    h.a(this, getString(2131297126));
  }
  
  @OnTextChanged(a={2131755210, 2131755211}, b=OnTextChanged.Callback.AFTER_TEXT_CHANGED)
  void afterNameTextChanged(Editable paramEditable)
  {
    paramEditable = this.mVerifyBtn;
    if ((this.mIDCardNameView.getText().length() > 0) && (this.mIDCardNoView.getText().length() == 18)) {}
    for (boolean bool = true;; bool = false)
    {
      paramEditable.setEnabled(bool);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1000))
    {
      q.a().a(this, 4);
      this.mEditView.setVisibility(8);
      this.mRejectedView.setVisibility(8);
      this.mPendingView.setVisibility(0);
    }
  }
  
  public void onBackPressed()
  {
    if (!q.a().c(this)) {
      super.onBackPressed();
    }
  }
  
  @OnClick(a={2131755213})
  void onClickNoId()
  {
    this.mIDCardNameView.setError(null);
    this.mIDCardNoView.setError(null);
    a();
  }
  
  @OnClick(a={2131755217})
  void onClickRedo()
  {
    a();
  }
  
  @OnClick(a={2131755212})
  void onClickVerify()
  {
    EditText localEditText = null;
    this.mIDCardNameView.setError(null);
    this.mIDCardNoView.setError(null);
    final String str1 = this.mIDCardNameView.getText().toString();
    String str2 = this.mIDCardNoView.getText().toString();
    int i;
    if (TextUtils.isEmpty(str1))
    {
      this.mIDCardNameView.setError(getString(2131296559));
      localEditText = this.mIDCardNameView;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        localEditText.requestFocus();
      }
      while (!h.l(this))
      {
        return;
        if (TextUtils.isEmpty(str2))
        {
          this.mIDCardNoView.setError(getString(2131296559));
          localEditText = this.mIDCardNoView;
          i = 1;
          break;
        }
        if ((TextUtils.isEmpty(str2)) || (q.a().e(str2))) {
          break label206;
        }
        this.mIDCardNoView.setError(getString(2131296563));
        localEditText = this.mIDCardNoView;
        i = 1;
        break;
      }
      this.mProgressView.setLoadingText(2131297131);
      this.mProgressView.a();
      this.mVerifyBtn.setEnabled(false);
      q.a().a(this, true);
      com.mobike.mobikeapp.a.f.b(str1, str2, new ad()
      {
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            paramAnonymousArrayOfd = (ManualCampusVerifyDataInfo)new e().a(paramAnonymousString, ManualCampusVerifyDataInfo.class);
            if (paramAnonymousArrayOfd != null) {
              switch (paramAnonymousArrayOfd.result)
              {
              default: 
                IDCardVerifyActivity.a(IDCardVerifyActivity.this, paramAnonymousArrayOfd.message);
              }
            }
          }
          for (;;)
          {
            q.a().a(IDCardVerifyActivity.this, false);
            return;
            aa.c();
            q.a().a(IDCardVerifyActivity.this, 0);
            q.a().b(IDCardVerifyActivity.this, str1);
            com.mobike.mobikeapp.model.c.f.a().b(true);
            h.a(IDCardVerifyActivity.this, paramAnonymousArrayOfd.message);
            IDCardVerifyActivity.this.finish();
            IDCardVerifyActivity.this.startActivity(HelpCardActivity.a(IDCardVerifyActivity.this, new Integer[] { Integer.valueOf(4) }));
            continue;
            IDCardVerifyActivity.this.mIDCardNoView.setError(IDCardVerifyActivity.this.getString(2131296563));
            IDCardVerifyActivity.this.mIDCardNoView.requestFocus();
            IDCardVerifyActivity.a(IDCardVerifyActivity.this, paramAnonymousArrayOfd.message);
            continue;
            IDCardVerifyActivity.a(IDCardVerifyActivity.this, paramAnonymousArrayOfd.message);
            continue;
            q.a().g(IDCardVerifyActivity.this);
            IDCardVerifyActivity.this.startActivity(new Intent(IDCardVerifyActivity.this, LoginActivity.class));
            IDCardVerifyActivity.a(IDCardVerifyActivity.this, paramAnonymousArrayOfd.message);
            IDCardVerifyActivity.this.finish();
            continue;
            new b.a(IDCardVerifyActivity.this, 2131427642).a(2131296911).b(2131296910).a(17039370, c.a(this)).b(17039360, d.a()).c();
            IDCardVerifyActivity.a(IDCardVerifyActivity.this, paramAnonymousArrayOfd.message);
          }
        }
        
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          IDCardVerifyActivity.a(IDCardVerifyActivity.this, null);
          q.a().a(IDCardVerifyActivity.this, false);
        }
      });
      return;
      label206:
      i = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968617);
    ButterKnife.a(this);
    m.a("onCreate");
    getSupportActionBar().k(2130837894);
    switch (q.a().b(this))
    {
    }
    for (;;)
    {
      this.e = AnimationUtils.loadAnimation(this, 2131034162);
      return;
      this.mEditView.setVisibility(8);
      this.mPendingView.setVisibility(0);
      this.mRejectedView.setVisibility(8);
      continue;
      this.mEditView.setVisibility(8);
      this.mPendingView.setVisibility(8);
      this.mRejectedView.setVisibility(0);
      paramBundle = q.a().j(getApplicationContext());
      TextView localTextView = (TextView)this.mRejectedView.findViewById(2131755216);
      if (!TextUtils.isEmpty(paramBundle)) {
        localTextView.setText(paramBundle.replace('^', '\n'));
      }
    }
  }
  
  @OnTextChanged(a={2131755210}, b=OnTextChanged.Callback.TEXT_CHANGED)
  void onNameTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = this.mIDCardNameView.getText().toString();
    paramCharSequence = h.h(paramCharSequence.toString());
    if (!str.equals(paramCharSequence))
    {
      this.mIDCardNameView.setText(paramCharSequence);
      this.mIDCardNameView.setSelection(paramCharSequence.length());
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
    if (!q.a().c(this)) {
      finish();
    }
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
  
  protected void onPause()
  {
    this.e.cancel();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mProgressDot.startAnimation(this.e);
  }
  
  @OnTouch(a={2131755210, 2131755211})
  boolean onTouchCardName()
  {
    this.b.postDelayed(b.a(this), 500L);
    return false;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/IDCardVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */