package com.mobike.mobikeapp.activity.customer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
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
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import org.json.JSONObject;

@j
public class RidingOtherIssueActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private EditText e;
  private ImageView f;
  private Button g;
  private String h;
  private com.mobike.mobikeapp.imagepicker.b i;
  private String j;
  
  private void a(Intent paramIntent)
  {
    this.h = paramIntent.getStringExtra("qrcode");
    this.a.setText(this.h);
  }
  
  private void k()
  {
    MobclickAgent.c(this, "40012");
    this.h = getIntent().getStringExtra(com.mobike.mobikeapp.model.c.b.aP);
    this.a = ((TextView)findViewById(2131755301));
    this.a.setText(this.h);
    this.g = ((Button)findViewById(2131755197));
    this.g.setOnClickListener(ap.a(this));
    ((TextView)findViewById(2131755224)).setText(2131296768);
    findViewById(2131755344).setOnClickListener(aq.a(this));
    this.f = ((ImageView)findViewById(2131755744));
    this.f.setOnClickListener(ar.a(this));
    this.a = ((TextView)findViewById(2131755301));
    o();
    l();
  }
  
  private void l()
  {
    this.i = com.mobike.mobikeapp.imagepicker.b.a();
    this.i.a(new GlideImageLoader());
    this.i.c(true);
    this.i.b(false);
    this.i.a(false);
    this.i.d(false);
  }
  
  private void m()
  {
    if (TextUtils.isEmpty(this.j)) {}
    for (final String str1 = null;; str1 = com.mobike.mobikeapp.util.a.k())
    {
      String str2 = this.e.getText().toString();
      if (h.l(this))
      {
        MobclickAgent.c(this, "40013");
        this.g.setEnabled(false);
        f.a(this.h, str1, "30", str2, new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            h.a(RidingOtherIssueActivity.this, paramAnonymousString);
            RidingOtherIssueActivity.c(RidingOtherIssueActivity.this).setEnabled(true);
          }
          
          public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
          {
            if (paramAnonymousJSONObject != null)
            {
              paramAnonymousArrayOfd = paramAnonymousJSONObject.optString("object");
              if (!TextUtils.isEmpty(RidingOtherIssueActivity.a(RidingOtherIssueActivity.this)))
              {
                paramAnonymousJSONObject = h.f(RidingOtherIssueActivity.a(RidingOtherIssueActivity.this));
                if (paramAnonymousJSONObject != null) {
                  com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, str1, paramAnonymousArrayOfd, as.a(this));
                }
                return;
              }
              RidingOtherIssueActivity.b(RidingOtherIssueActivity.this);
              return;
            }
            RidingOtherIssueActivity.b(RidingOtherIssueActivity.this);
          }
        });
      }
      return;
    }
  }
  
  private void n()
  {
    h.a(this, getString(2131296650));
    finish();
  }
  
  private void o()
  {
    this.b = ((TextView)findViewById(2131755252));
    this.b.setText(getString(2131296901, new Object[] { Integer.valueOf(140) }));
    this.e = ((EditText)findViewById(2131755251));
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          RidingOtherIssueActivity.c(RidingOtherIssueActivity.this).setEnabled(true);
          return;
        }
        RidingOtherIssueActivity.c(RidingOtherIssueActivity.this).setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        RidingOtherIssueActivity.d(RidingOtherIssueActivity.this).setText(RidingOtherIssueActivity.this.getString(2131296901, new Object[] { Integer.valueOf(140 - paramAnonymousCharSequence.length()) }));
      }
    });
  }
  
  private void p()
  {
    Intent localIntent = new Intent(this, QRCodeScannerActivity.class);
    localIntent.setAction("com.mobike.action.getQRCode");
    startActivityForResult(localIntent, 100);
  }
  
  @c(a={"android.permission.CAMERA"})
  void a()
  {
    p();
  }
  
  @e(a={"android.permission.CAMERA"})
  void b()
  {
    h.a(this, 2131296814);
    p();
  }
  
  @b.a.d(a={"android.permission.CAMERA"})
  void c()
  {
    h.a(this, 2131296814);
    p();
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
        break label125;
      }
      if ((paramIntent == null) || (paramInt1 != 100)) {
        break;
      }
    } while (!h.l(this));
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
    this.j = ((ImageItem)paramIntent.get(0)).path;
    this.i.l().displayImage(this, ((ImageItem)paramIntent.get(0)).path, this.f);
    return;
    paramIntent = Toast.makeText(this, 2131296756, 0);
    if (!(paramIntent instanceof Toast))
    {
      paramIntent.show();
      return;
    }
    VdsAgent.showToast((Toast)paramIntent);
    return;
    label125:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968649);
    k();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    at.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/RidingOtherIssueActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */