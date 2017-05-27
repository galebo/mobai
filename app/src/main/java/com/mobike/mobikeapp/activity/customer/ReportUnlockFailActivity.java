package com.mobike.mobikeapp.activity.customer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ac;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import b.a.c;
import b.a.e;
import b.a.j;
import com.google.zxing.client.android.QRCodeScannerActivity;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.widget.LoadingToastView;
import com.umeng.analytics.MobclickAgent;
import org.json.JSONObject;

@j
public class ReportUnlockFailActivity
  extends BaseActivity
{
  private ScrollView a;
  private String b;
  private TextView e;
  private TextView f;
  private EditText g;
  private TextView h;
  private Button i;
  private LoadingToastView j;
  private Handler k = new Handler();
  
  private void a(Intent paramIntent)
  {
    if (TextUtils.isEmpty(this.b))
    {
      this.b = paramIntent.getStringExtra("qrcode");
      e();
      this.e.setText(this.b);
      paramIntent = this.i;
      if (TextUtils.isEmpty(this.b)) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      paramIntent.setEnabled(bool);
      return;
      this.b = paramIntent.getStringExtra("qrcode");
      break;
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, QRCodeScannerActivity.class);
    localIntent.setAction("com.mobike.action.getQRCode");
    startActivityForResult(localIntent, 100);
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      this.e.setTextSize(18.0F);
      this.e.setText(this.b);
      this.e.animate().translationY(-14.0F).translationX(h.a(this, 10.0F)).setDuration(500L).start();
      this.f.animate().scaleX(1.0F).scaleY(1.0F).setDuration(500L).start();
    }
  }
  
  @c(a={"android.permission.CAMERA"})
  void a()
  {
    d();
  }
  
  @e(a={"android.permission.CAMERA"})
  void b()
  {
    h.a(this, 2131296814);
    d();
  }
  
  @b.a.d(a={"android.permission.CAMERA"})
  void c()
  {
    h.a(this, 2131296814);
    d();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100))
    {
      a(paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968646);
    this.a = ((ScrollView)findViewById(2131755360));
    this.e = ((TextView)findViewById(2131755346));
    this.f = ((TextView)findViewById(2131755347));
    findViewById(2131755344).setOnClickListener(ae.a(this));
    this.g = ((EditText)findViewById(2131755361));
    this.g.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ReportUnlockFailActivity.a(ReportUnlockFailActivity.this).setText(ReportUnlockFailActivity.this.getString(2131296901, new Object[] { Integer.valueOf(140 - paramAnonymousEditable.length()) }));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.g.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        ReportUnlockFailActivity.b(ReportUnlockFailActivity.this).postDelayed(af.a(this), 200L);
        return false;
      }
    });
    this.h = ((TextView)findViewById(2131755362));
    this.h.setText(getString(2131296901, new Object[] { Integer.valueOf(140) }));
    this.i = ((Button)findViewById(2131755363));
    this.i.setEnabled(false);
    this.i.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MobclickAgent.c(ReportUnlockFailActivity.this, "40017");
        h.a(ReportUnlockFailActivity.this, ReportUnlockFailActivity.d(ReportUnlockFailActivity.this));
        if (h.l(ReportUnlockFailActivity.this))
        {
          ReportUnlockFailActivity.e(ReportUnlockFailActivity.this).a();
          ReportUnlockFailActivity.d(ReportUnlockFailActivity.this).setEnabled(false);
          f.a(ReportUnlockFailActivity.f(ReportUnlockFailActivity.this), null, "7", ReportUnlockFailActivity.g(ReportUnlockFailActivity.this).getText().toString(), new a()
          {
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              ReportUnlockFailActivity.e(ReportUnlockFailActivity.this).b();
              ReportUnlockFailActivity.d(ReportUnlockFailActivity.this).setEnabled(true);
              h.a(ReportUnlockFailActivity.this, paramAnonymous2String);
            }
            
            public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
            {
              ReportUnlockFailActivity.e(ReportUnlockFailActivity.this).b();
              h.a(ReportUnlockFailActivity.this, ReportUnlockFailActivity.this.getString(2131296650));
              ReportUnlockFailActivity.this.finish();
            }
          });
        }
      }
    });
    this.j = ((LoadingToastView)findViewById(2131755754));
    MobclickAgent.c(this, "40016");
    if (RideManager.a().p())
    {
      this.b = RideManager.a().n();
      e();
      this.i.setEnabled(true);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/ReportUnlockFailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */