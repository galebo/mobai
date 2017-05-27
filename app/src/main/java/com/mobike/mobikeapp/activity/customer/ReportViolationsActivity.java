package com.mobike.mobikeapp.activity.customer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import b.a.c;
import b.a.e;
import b.a.j;
import com.google.zxing.client.android.QRCodeScannerActivity;
import com.growingio.android.sdk.agent.VdsAgent;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.NonFocusingScrollView;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import org.json.JSONObject;

@j
public class ReportViolationsActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private TextView e;
  private String f;
  private EditText g;
  private NonFocusingScrollView h;
  private Button i;
  private String j;
  private com.mobike.mobikeapp.imagepicker.b k;
  private ImageView l;
  private LoadingPageView m;
  
  private void a(Intent paramIntent)
  {
    if (TextUtils.isEmpty(this.f))
    {
      this.f = paramIntent.getStringExtra("qrcode");
      n();
    }
    for (;;)
    {
      this.a.setText(this.f);
      return;
      this.f = paramIntent.getStringExtra("qrcode");
    }
  }
  
  private void k()
  {
    this.m = ((LoadingPageView)findViewById(2131755751));
    this.l = ((ImageView)findViewById(2131755744));
    this.l.setOnClickListener(ah.a(this));
    findViewById(2131755344).setOnClickListener(ai.a(this));
    this.a = ((TextView)findViewById(2131755346));
    this.b = ((TextView)findViewById(2131755347));
    if (RideManager.a().p()) {}
    for (this.f = RideManager.a().n();; this.f = getIntent().getStringExtra(com.mobike.mobikeapp.model.c.b.aP))
    {
      if (TextUtils.isEmpty(this.f)) {
        this.f = RideManager.a().I();
      }
      l();
      this.i = ((Button)findViewById(2131755197));
      this.i.setOnClickListener(aj.a(this));
      m();
      n();
      MobclickAgent.c(this, "40003");
      return;
    }
  }
  
  private void l()
  {
    this.h = ((NonFocusingScrollView)findViewById(2131755249));
    this.e = ((TextView)findViewById(2131755252));
    this.e.setText(getString(2131296901, new Object[] { Integer.valueOf(140) }));
    this.g = ((EditText)findViewById(2131755251));
    this.g.setOnTouchListener(ak.a(this));
    this.g.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        boolean bool2 = false;
        if (paramAnonymousEditable.length() > 0)
        {
          paramAnonymousEditable = ReportViolationsActivity.d(ReportViolationsActivity.this);
          boolean bool1 = bool2;
          if (!TextUtils.isEmpty(ReportViolationsActivity.b(ReportViolationsActivity.this)))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(ReportViolationsActivity.c(ReportViolationsActivity.this))) {
              bool1 = true;
            }
          }
          paramAnonymousEditable.setEnabled(bool1);
          return;
        }
        ReportViolationsActivity.d(ReportViolationsActivity.this).setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ReportViolationsActivity.a(ReportViolationsActivity.this).setText(ReportViolationsActivity.this.getString(2131296901, new Object[] { Integer.valueOf(140 - paramAnonymousCharSequence.length()) }));
      }
    });
  }
  
  private void m()
  {
    this.k = com.mobike.mobikeapp.imagepicker.b.a();
    this.k.a(new GlideImageLoader());
    this.k.c(true);
    this.k.b(false);
    this.k.a(false);
    this.k.d(false);
  }
  
  private void n()
  {
    Button localButton;
    if (!TextUtils.isEmpty(this.f))
    {
      this.a.setTextSize(18.0F);
      this.a.setText(this.f);
      this.a.animate().translationY(-14.0F).translationX(h.a(this, 10.0F)).setDuration(500L).start();
      this.b.animate().scaleX(1.0F).scaleY(1.0F).setDuration(500L).start();
      localButton = this.i;
      if ((TextUtils.isEmpty(this.j)) || (TextUtils.isEmpty(this.g.getText()))) {
        break label123;
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent(this, QRCodeScannerActivity.class);
    localIntent.setAction("com.mobike.action.getQRCode");
    startActivityForResult(localIntent, 100);
  }
  
  private void p()
  {
    final String str1 = com.mobike.mobikeapp.util.a.k();
    String str2 = this.g.getText().toString();
    if (h.l(this))
    {
      MobclickAgent.c(this, "40005");
      this.m.a();
      this.i.setEnabled(false);
      f.a(this.f, str1, "9", str2, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          h.a(ReportViolationsActivity.this, paramAnonymousString);
          ReportViolationsActivity.d(ReportViolationsActivity.this).setEnabled(true);
          ReportViolationsActivity.f(ReportViolationsActivity.this).b();
        }
        
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = paramAnonymousJSONObject.optString("object");
            if (!TextUtils.isEmpty(ReportViolationsActivity.c(ReportViolationsActivity.this)))
            {
              paramAnonymousJSONObject = h.f(ReportViolationsActivity.c(ReportViolationsActivity.this));
              if (paramAnonymousJSONObject != null)
              {
                com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, str1, paramAnonymousArrayOfd, am.a(this));
                return;
              }
              ReportViolationsActivity.e(ReportViolationsActivity.this);
              return;
            }
            ReportViolationsActivity.e(ReportViolationsActivity.this);
            return;
          }
          ReportViolationsActivity.e(ReportViolationsActivity.this);
        }
      });
    }
  }
  
  private void q()
  {
    this.m.b();
    h.a(this, getString(2131296650));
    finish();
  }
  
  @c(a={"android.permission.CAMERA"})
  void a()
  {
    o();
  }
  
  @e(a={"android.permission.CAMERA"})
  void b()
  {
    h.a(this, 2131296814);
    o();
  }
  
  @b.a.d(a={"android.permission.CAMERA"})
  void c()
  {
    h.a(this, 2131296814);
    o();
  }
  
  @c(a={"android.permission.READ_EXTERNAL_STORAGE"})
  public void d()
  {
    startActivityForResult(new Intent(this, ImageGridActivity.class), 100);
  }
  
  @TargetApi(16)
  @e(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void e()
  {
    h.a(this, getString(2131296509));
  }
  
  @TargetApi(16)
  @b.a.d(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void f()
  {
    h.a(this, getString(2131296509));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100)) {
      a(paramIntent);
    }
    do
    {
      return;
      if (paramInt2 != 1004) {
        break label168;
      }
      if ((paramIntent == null) || (paramInt1 != 100)) {
        break;
      }
    } while (!h.l(this));
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
    this.j = ((ImageItem)paramIntent.get(0)).path;
    this.k.l().displayImage(this, ((ImageItem)paramIntent.get(0)).path, this.l);
    paramIntent = this.i;
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g.getText()))) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.setEnabled(bool);
      return;
    }
    paramIntent = Toast.makeText(this, 2131296756, 0);
    if (!(paramIntent instanceof Toast))
    {
      paramIntent.show();
      return;
    }
    VdsAgent.showToast((Toast)paramIntent);
    return;
    label168:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.m.getVisibility() != 0) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968644);
    k();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    an.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/ReportViolationsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */