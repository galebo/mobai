package com.mobike.mobikeapp.activity.usercenter;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import b.a.j;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.widget.LoadingToastView;
import java.util.ArrayList;
import org.json.JSONObject;

@j
public class ContestNegativeRecordActivity
  extends BaseActivity
{
  private static final int a = 100;
  private String b;
  private ImageView e;
  private com.mobike.mobikeapp.imagepicker.b f;
  private String g;
  private EditText h;
  private TextView i;
  private Button j;
  private LoadingToastView k;
  
  private void d()
  {
    k();
    this.e = ((ImageView)findViewById(2131755192));
    this.e.setOnClickListener(c.a(this));
    this.h = ((EditText)findViewById(2131755190));
    this.h.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        boolean bool = true;
        ContestNegativeRecordActivity.a(ContestNegativeRecordActivity.this).setText(ContestNegativeRecordActivity.this.getString(2131296901, new Object[] { Integer.valueOf(140 - paramAnonymousEditable.length()) }));
        Button localButton = ContestNegativeRecordActivity.b(ContestNegativeRecordActivity.this);
        if (!TextUtils.isEmpty(paramAnonymousEditable)) {}
        for (;;)
        {
          localButton.setEnabled(bool);
          return;
          bool = false;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.i = ((TextView)findViewById(2131755191));
    this.i.setText(getString(2131296901, new Object[] { Integer.valueOf(140) }));
    this.j = ((Button)findViewById(2131755193));
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(final View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        h.a(ContestNegativeRecordActivity.this, ContestNegativeRecordActivity.b(ContestNegativeRecordActivity.this));
        if (h.l(ContestNegativeRecordActivity.this))
        {
          ContestNegativeRecordActivity.c(ContestNegativeRecordActivity.this).a();
          ContestNegativeRecordActivity.b(ContestNegativeRecordActivity.this).setEnabled(false);
          paramAnonymousView = com.mobike.mobikeapp.util.a.k();
          f.b(ContestNegativeRecordActivity.d(ContestNegativeRecordActivity.this), ContestNegativeRecordActivity.e(ContestNegativeRecordActivity.this).getText().toString(), paramAnonymousView, new com.mobike.mobikeapp.model.b.a()
          {
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              ContestNegativeRecordActivity.c(ContestNegativeRecordActivity.this).b();
              ContestNegativeRecordActivity.b(ContestNegativeRecordActivity.this).setEnabled(true);
              h.a(ContestNegativeRecordActivity.this, paramAnonymous2String);
            }
            
            public void a(int paramAnonymous2Int, cz.msebera.android.httpclient.d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
            {
              paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new com.google.gson.e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
              if (paramAnonymous2ArrayOfd.result == 0)
              {
                if (TextUtils.isEmpty(ContestNegativeRecordActivity.f(ContestNegativeRecordActivity.this))) {
                  break label92;
                }
                paramAnonymous2JSONObject = h.f(ContestNegativeRecordActivity.f(ContestNegativeRecordActivity.this));
                if (paramAnonymous2JSONObject != null) {
                  com.mobike.mobikeapp.util.d.a().a(paramAnonymous2JSONObject, paramAnonymousView, paramAnonymous2ArrayOfd.message, d.a(this));
                }
              }
              else
              {
                return;
              }
              ContestNegativeRecordActivity.g(ContestNegativeRecordActivity.this);
              return;
              label92:
              ContestNegativeRecordActivity.g(ContestNegativeRecordActivity.this);
            }
          });
        }
      }
    });
    this.j.setEnabled(false);
    this.k = ((LoadingToastView)findViewById(2131755754));
  }
  
  private void e()
  {
    this.k.b();
    f();
  }
  
  private void f()
  {
    Object localObject = new b.a(this, 2131427642);
    ((b.a)localObject).b(2131296404).a(2131296624, new DialogInterface.OnClickListener()
    {
      @Instrumented
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
        paramAnonymousDialogInterface.dismiss();
        ContestNegativeRecordActivity.this.setResult(-1);
        ContestNegativeRecordActivity.this.finish();
      }
    });
    localObject = ((b.a)localObject).b();
    ((android.support.v7.app.b)localObject).setCanceledOnTouchOutside(false);
    ((android.support.v7.app.b)localObject).show();
  }
  
  private void k()
  {
    this.f = com.mobike.mobikeapp.imagepicker.b.a();
    this.f.a(new GlideImageLoader());
    this.f.c(true);
    this.f.b(false);
    this.f.a(false);
    this.f.d(false);
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
        this.g = ((ImageItem)paramIntent.get(0)).path;
        this.f.l().displayImage(this, ((ImageItem)paramIntent.get(0)).path, this.e);
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
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968609);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (this.b = paramBundle.getStringExtra("appeal_ticket_id");; this.b = "")
    {
      d();
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    e.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/ContestNegativeRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */