package com.mobike.mobikeapp.activity.customer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.MainActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.LockNoFeeInfo;
import com.mobike.mobikeapp.data.LockNoFeeInfo.LockNoFeeData;
import com.mobike.mobikeapp.imagepicker.a.a;
import com.mobike.mobikeapp.imagepicker.b;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.NonFocusingScrollView;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import org.json.JSONObject;

@b.a.j
public class LockNoFeeActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private EditText e;
  private Button f;
  private ImageView g;
  private b h;
  private NonFocusingScrollView i;
  private String j;
  private LoadingPageView k;
  
  private void a(final String paramString1, String paramString2)
  {
    MobclickAgent.c(this, "40007");
    this.k.setVisibility(0);
    this.f.setEnabled(false);
    f.a(RideManager.a().b(this), com.mobike.mobikeapp.util.l.a().h(), new com.loopj.android.http.n()
    {
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousString, paramAnonymousThrowable);
        org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.e(paramAnonymousInt));
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = (LockNoFeeInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), LockNoFeeInfo.class);
        if ((paramAnonymousArrayOfd.result == 0) && (paramAnonymousArrayOfd.data != null))
        {
          org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.e(0));
          if (!TextUtils.isEmpty(LockNoFeeActivity.a(LockNoFeeActivity.this)))
          {
            paramAnonymousJSONObject = h.f(LockNoFeeActivity.a(LockNoFeeActivity.this));
            if ((paramAnonymousJSONObject != null) && (!paramAnonymousArrayOfd.data.autoEndTrip))
            {
              com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, paramString1, paramAnonymousArrayOfd.data.token, p.a(this));
              return;
            }
            LockNoFeeActivity.a(LockNoFeeActivity.this, true);
            return;
          }
          LockNoFeeActivity.a(LockNoFeeActivity.this, paramAnonymousArrayOfd.data.autoEndTrip);
          return;
        }
        h.a(LockNoFeeActivity.this, paramAnonymousArrayOfd.message);
      }
    }, paramString1, paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      new b.a(this).a(true).a(l.a(this)).a(2131296648).b(2131296646).a(2131296649, m.a(this)).c();
      return;
    }
    h.a(this, getString(2131296650));
    e();
  }
  
  private void d()
  {
    MobclickAgent.c(this, "40006");
    f();
    k();
    this.b = ((TextView)findViewById(2131755301));
    this.b.setText(getString(2131296380, new Object[] { RideManager.a().n() }));
    this.k = ((LoadingPageView)findViewById(2131755751));
    this.f = ((Button)findViewById(2131755197));
    this.f.setOnClickListener(j.a(this));
    this.g = ((ImageView)findViewById(2131755250));
    this.g.setOnClickListener(k.a(this));
  }
  
  private void e()
  {
    this.k.setVisibility(8);
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  private void f()
  {
    this.h = b.a();
    this.h.a(new GlideImageLoader());
    this.h.c(true);
    this.h.b(false);
    this.h.a(false);
    this.h.d(false);
  }
  
  private void k()
  {
    this.i = ((NonFocusingScrollView)findViewById(2131755249));
    this.a = ((TextView)findViewById(2131755252));
    this.a.setText(getString(2131296901, new Object[] { Integer.valueOf(140) }));
    this.e = ((EditText)findViewById(2131755251));
    this.e.setOnTouchListener(n.a(this));
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          LockNoFeeActivity.d(LockNoFeeActivity.this).setEnabled(true);
          return;
        }
        LockNoFeeActivity.d(LockNoFeeActivity.this).setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LockNoFeeActivity.c(LockNoFeeActivity.this).setText(LockNoFeeActivity.this.getString(2131296901, new Object[] { Integer.valueOf(140 - paramAnonymousCharSequence.length()) }));
      }
    });
  }
  
  @b.a.c(a={"android.permission.READ_EXTERNAL_STORAGE"})
  public void a()
  {
    startActivityForResult(new Intent(this, ImageGridActivity.class), 100);
  }
  
  @TargetApi(16)
  @b.a.e(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void b()
  {
    h.a(this, getString(2131296509));
  }
  
  @TargetApi(16)
  @b.a.d(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void c()
  {
    h.a(this, getString(2131296509));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 1004)
    {
      if ((paramIntent != null) && (paramInt1 == 100))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
        this.j = ((ImageItem)paramIntent.get(0)).path;
        this.h.l().displayImage(this, ((ImageItem)paramIntent.get(0)).path, this.g);
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
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.k.getVisibility() != 0)
    {
      super.onBackPressed();
      return;
    }
    h.a(this, getString(2131296793));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968624);
    d();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    q.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/LockNoFeeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */