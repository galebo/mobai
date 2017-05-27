package com.mobike.mobikeapp.activity.redpacket;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.b.a.g;
import com.mobike.mobikeapp.b.f;
import com.mobike.mobikeapp.data.RedPacketData.DataBean;
import com.mobike.mobikeapp.util.o;

public class AlipayWithdrawActivity
  extends BaseActivity
  implements g
{
  private CountDownTimer a;
  private com.mobike.mobikeapp.b.a.h b;
  private RedPacketData.DataBean e;
  @BindView(a=2131755173)
  EditText mAlipayAccountEt;
  @BindView(a=2131755177)
  EditText mAlipayAmountEt;
  @BindView(a=2131755174)
  EditText mAlipayRealNameEt;
  @BindView(a=2131755176)
  Button mTimerTv;
  @BindView(a=2131755175)
  EditText mVerifyEt;
  @BindView(a=2131755179)
  Button mWithdrawButton;
  
  private void a(TextWatcher paramTextWatcher, EditText... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].addTextChangedListener(paramTextWatcher);
      i += 1;
    }
  }
  
  private boolean a(EditText... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      EditText localEditText = paramVarArgs[i];
      if ((localEditText.getText() == null) || (localEditText.getText().toString().trim().isEmpty())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    c();
    this.a = new CountDownTimer(60000L, 1000L)
    {
      public void onFinish()
      {
        AlipayWithdrawActivity.this.mTimerTv.setText(2131296588);
        AlipayWithdrawActivity.this.mTimerTv.setEnabled(true);
      }
      
      public void onTick(long paramAnonymousLong)
      {
        AlipayWithdrawActivity.this.mTimerTv.setText(String.format(AlipayWithdrawActivity.this.getResources().getString(2131296589), new Object[] { Long.valueOf(paramAnonymousLong / 1000L) }));
        AlipayWithdrawActivity.this.mTimerTv.setEnabled(false);
      }
    };
  }
  
  private void c()
  {
    this.e = ((RedPacketData.DataBean)getIntent().getSerializableExtra("redPacketInfo"));
    if (this.e != null)
    {
      this.mAlipayRealNameEt.setText(this.e.getRealname());
      this.mAlipayAccountEt.setText(this.e.getAliacct());
      this.mAlipayAmountEt.setText(o.a(Integer.valueOf(this.e.getTotal())));
    }
    a(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (AlipayWithdrawActivity.a(AlipayWithdrawActivity.this, new EditText[] { AlipayWithdrawActivity.this.mAlipayAccountEt, AlipayWithdrawActivity.this.mAlipayRealNameEt, AlipayWithdrawActivity.this.mVerifyEt }))
        {
          AlipayWithdrawActivity.this.mWithdrawButton.setEnabled(true);
          return;
        }
        AlipayWithdrawActivity.this.mWithdrawButton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    }, new EditText[] { this.mAlipayRealNameEt, this.mAlipayAccountEt, this.mVerifyEt });
  }
  
  public void a()
  {
    this.a.start();
  }
  
  public void a(String paramString)
  {
    b.a locala = new b.a(this);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130968700, null);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localView.findViewById(2131755524)).setText(paramString);
    }
    paramString = locala.b(localView).c();
    ((Button)localView.findViewById(2131755525)).setOnClickListener(a.a(this, paramString));
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131296725);
    }
    com.mobike.mobikeapp.model.c.h.a(this, str);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968605);
    ButterKnife.a(this);
    this.b = new f(this);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
  
  @OnClick(a={2131755176})
  public void sendSmsCode()
  {
    this.b.a();
  }
  
  @OnClick(a={2131755179})
  public void withdrawMoney(View paramView)
  {
    if (a(new EditText[] { this.mAlipayAccountEt, this.mAlipayRealNameEt, this.mVerifyEt })) {
      this.b.a(this.mAlipayRealNameEt.getText().toString().trim(), this.mAlipayAccountEt.getText().toString().trim(), this.mVerifyEt.getText().toString());
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/AlipayWithdrawActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */