package com.mobike.mobikeapp.activity.riding;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ab;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import b.a.c;
import b.a.e;
import b.a.j;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.imagepicker.b;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.qiniu.android.b.g;
import com.qiniu.android.http.l;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import org.json.JSONObject;

@j
public class UploadParkingImgActivity
  extends BaseActivity
{
  private ImageView a;
  private TextView b;
  private TextView e;
  private EditText f;
  private Button g;
  private ScrollView h;
  private String i = null;
  private final int j = 250;
  private String k;
  private String l = "";
  private com.mobike.mobikeapp.imagepicker.view.a m;
  private b n;
  
  private void a(Intent paramIntent)
  {
    this.g.setEnabled(true);
    if (paramIntent == null)
    {
      paramIntent = Toast.makeText(this, 2131296756, 0);
      if (!(paramIntent instanceof Toast)) {
        paramIntent.show();
      }
    }
    do
    {
      return;
      VdsAgent.showToast((Toast)paramIntent);
      return;
      if (!h.l(this)) {
        break;
      }
      paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
    } while ((paramIntent == null) || (paramIntent.isEmpty()));
    this.i = ((ImageItem)paramIntent.get(0)).path;
    this.b.setVisibility(8);
    this.n.l().displayImage(this, this.i, this.a);
    return;
    h.a(this, getString(2131296740));
  }
  
  private void a(String paramString1, String paramString2)
  {
    com.mobike.mobikeapp.util.d.a().a(h.f(this.i), paramString2, paramString1, new g()
    {
      public void a(String paramAnonymousString, l paramAnonymousl, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousl.d())
        {
          h.a(UploadParkingImgActivity.this, UploadParkingImgActivity.this.getString(2131296650));
          MobclickAgent.c(UploadParkingImgActivity.this, "10003");
          UploadParkingImgActivity.g(UploadParkingImgActivity.this);
          return;
        }
        h.a(UploadParkingImgActivity.this, UploadParkingImgActivity.this.getString(2131296647));
        UploadParkingImgActivity.a(UploadParkingImgActivity.this).setEnabled(true);
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramBoolean) {}
    for (localLayoutParams.flags |= 0x4000000;; localLayoutParams.flags &= 0xFBFFFFFF)
    {
      localWindow.setAttributes(localLayoutParams);
      return;
    }
  }
  
  private void d()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21))
    {
      a(true);
      this.m = new com.mobike.mobikeapp.imagepicker.view.a(this);
      this.m.a(true);
      this.m.d(2131624128);
    }
    this.h = ((ScrollView)findViewById(2131755249));
    this.a = ((ImageView)findViewById(2131755394));
    this.b = ((TextView)findViewById(2131755395));
    this.f = ((EditText)findViewById(2131755251));
    this.e = ((TextView)findViewById(2131755396));
    this.g = ((Button)findViewById(2131755397));
    this.e.setText(String.format(getString(2131296612), new Object[] { Integer.valueOf(0) }));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        k.a(UploadParkingImgActivity.this);
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UploadParkingImgActivity.a(UploadParkingImgActivity.this).setEnabled(false);
        UploadParkingImgActivity.b(UploadParkingImgActivity.this);
      }
    });
    this.f.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            UploadParkingImgActivity.c(UploadParkingImgActivity.this).fullScroll(130);
          }
        }, 333L);
        return false;
      }
    });
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        UploadParkingImgActivity.d(UploadParkingImgActivity.this).setText(String.format(UploadParkingImgActivity.this.getString(2131296612), new Object[] { Integer.valueOf(paramAnonymousEditable.length()) }));
        if ((TextUtils.isEmpty(UploadParkingImgActivity.e(UploadParkingImgActivity.this))) && ((paramAnonymousEditable.length() == 0) || (TextUtils.isEmpty(paramAnonymousEditable.toString().trim()))))
        {
          UploadParkingImgActivity.a(UploadParkingImgActivity.this).setEnabled(false);
          return;
        }
        UploadParkingImgActivity.a(UploadParkingImgActivity.this).setEnabled(true);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.i)) {
      this.l = com.mobike.mobikeapp.util.a.h();
    }
    if (!h.g(this))
    {
      h.a(this, getString(2131296740));
      return;
    }
    f.a(this.l, this.f.getText().toString(), this.k, new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (201 == paramAnonymousInt)
        {
          UploadParkingImgActivity.this.setResult(10);
          UploadParkingImgActivity.this.finish();
        }
        for (;;)
        {
          h.a(UploadParkingImgActivity.this, paramAnonymousString);
          return;
          UploadParkingImgActivity.a(UploadParkingImgActivity.this).setEnabled(true);
        }
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if (!TextUtils.isEmpty(UploadParkingImgActivity.e(UploadParkingImgActivity.this)))
        {
          paramAnonymousArrayOfd = paramAnonymousJSONObject.optJSONObject("object").optString("token");
          UploadParkingImgActivity.a(UploadParkingImgActivity.this, paramAnonymousArrayOfd, UploadParkingImgActivity.f(UploadParkingImgActivity.this));
          return;
        }
        MobclickAgent.c(UploadParkingImgActivity.this, "10003_2");
        UploadParkingImgActivity.g(UploadParkingImgActivity.this);
      }
    });
  }
  
  private void f()
  {
    setResult(-1);
    finish();
  }
  
  private void k()
  {
    this.n = b.a();
    this.n.a(new GlideImageLoader());
    this.n.c(true);
    this.n.b(false);
    this.n.a(false);
    this.n.d(false);
  }
  
  @TargetApi(16)
  @c(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void a()
  {
    startActivityForResult(new Intent(this, ImageGridActivity.class), 250);
  }
  
  @TargetApi(16)
  @e(a={"android.permission.READ_EXTERNAL_STORAGE"})
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
  
  protected boolean j()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 1004) && (paramInt1 == 250)) {
      a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968657);
    this.k = getIntent().getStringExtra("order_id");
    d();
    k();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    k.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/UploadParkingImgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */