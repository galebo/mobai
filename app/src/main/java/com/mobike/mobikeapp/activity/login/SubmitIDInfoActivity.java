package com.mobike.mobikeapp.activity.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;
import b.a.c;
import b.a.j;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.data.ManualCampusVerifyDataInfo;
import com.mobike.mobikeapp.data.ManualCampusVerifyDataInfo.CampusIDPhotoData;
import com.mobike.mobikeapp.imagepicker.b;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.a;
import com.mobike.mobikeapp.widget.AutoCompleteClearableTextView;
import com.mobike.mobikeapp.widget.LoadingToastView;
import java.util.ArrayList;
import org.json.JSONObject;

@j
public class SubmitIDInfoActivity
  extends BaseActivity
{
  private static final int a = 101;
  private static final int b = 102;
  private ScrollView e;
  private LoadingToastView f;
  private EditText g;
  private EditText h;
  private AutoCompleteClearableTextView i;
  private TextWatcher j;
  private ImageView k;
  private ImageView l;
  private String m;
  private String n;
  private Button o;
  private Handler p = new Handler();
  private String[] q;
  
  private void b(int paramInt)
  {
    c();
    q.a(this, paramInt);
  }
  
  private void c()
  {
    b localb = b.a();
    localb.a(new GlideImageLoader());
    localb.c(true);
    localb.b(false);
    localb.a(false);
    localb.d(false);
  }
  
  private void d()
  {
    if ((this.g.getText().length() > 0) && (this.h.getText().length() > 0) && (this.i.getText().length() > 0) && (!TextUtils.isEmpty(this.m)) && (!TextUtils.isEmpty(this.n)))
    {
      this.o.setEnabled(true);
      return;
    }
    this.o.setEnabled(false);
  }
  
  private void e()
  {
    this.o.setEnabled(false);
    this.f.a();
    String str1 = this.g.getText().toString();
    String str2 = this.h.getText().toString();
    String str3 = this.i.getText().toString();
    final String str4 = a.d();
    final String str5 = a.e();
    com.mobike.mobikeapp.a.f.a(str1, str2, str3, str4, str5, 0, new n()
    {
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        h.a(SubmitIDInfoActivity.this, paramAnonymousString);
        SubmitIDInfoActivity.g(SubmitIDInfoActivity.this).setEnabled(true);
        SubmitIDInfoActivity.h(SubmitIDInfoActivity.this).b();
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousString, paramAnonymousThrowable);
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = (ManualCampusVerifyDataInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), ManualCampusVerifyDataInfo.class);
        if (paramAnonymousArrayOfd != null) {
          switch (paramAnonymousArrayOfd.result)
          {
          default: 
            h.a(SubmitIDInfoActivity.this, paramAnonymousArrayOfd.message);
            SubmitIDInfoActivity.g(SubmitIDInfoActivity.this).setEnabled(true);
            SubmitIDInfoActivity.h(SubmitIDInfoActivity.this).b();
          }
        }
        do
        {
          return;
          paramAnonymousArrayOfd = paramAnonymousArrayOfd.campusIDPhotoData;
        } while (paramAnonymousArrayOfd == null);
        paramAnonymousJSONObject = h.f(SubmitIDInfoActivity.f(SubmitIDInfoActivity.this));
        com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, str4, paramAnonymousArrayOfd.idPhotoOneToken, o.a(this, str5, paramAnonymousArrayOfd));
      }
    });
  }
  
  @TargetApi(16)
  @b.a.e(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void a()
  {
    h.a(this, getString(2131296509));
  }
  
  @TargetApi(16)
  @c(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void a(int paramInt)
  {
    startActivityForResult(new Intent(this, ImageGridActivity.class), paramInt);
  }
  
  @TargetApi(16)
  @b.a.d(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void b()
  {
    h.a(this, getString(2131296509));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 1004)
    {
      if (paramIntent != null) {
        break label39;
      }
      paramIntent = Toast.makeText(this, 2131296756, 0);
      if (!(paramIntent instanceof Toast)) {
        paramIntent.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showToast((Toast)paramIntent);
    return;
    label39:
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
    switch (paramInt1)
    {
    default: 
      return;
    case 101: 
      this.m = ((ImageItem)paramIntent.get(0)).path;
      l.a(this).a(this.m).d().a(this.k);
      d();
      return;
    }
    this.n = ((ImageItem)paramIntent.get(0)).path;
    l.a(this).a(this.n).d().a(this.l);
    d();
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968654);
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21)) {
      findViewById(2131755320).setPadding(0, h.q(this), 0, 0);
    }
    getSupportActionBar().c(false);
    this.e = ((ScrollView)findViewById(2131755381));
    this.g = ((EditText)findViewById(2131755382));
    this.h = ((EditText)findViewById(2131755383));
    this.i = ((AutoCompleteClearableTextView)findViewById(2131755384));
    this.q = getResources().getStringArray(2131689479);
    paramBundle = new ArrayAdapter(this, 17367043, this.q);
    this.i.setAdapter(paramBundle);
    this.i.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        SubmitIDInfoActivity.c(SubmitIDInfoActivity.this).post(new Runnable()
        {
          public void run()
          {
            SubmitIDInfoActivity.b(SubmitIDInfoActivity.this).smoothScrollTo(0, SubmitIDInfoActivity.a(SubmitIDInfoActivity.this).getBottom());
          }
        });
        return false;
      }
    });
    this.j = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        SubmitIDInfoActivity.d(SubmitIDInfoActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.g.addTextChangedListener(this.j);
    this.h.addTextChangedListener(this.j);
    this.i.addTextChangedListener(this.j);
    this.k = ((ImageView)findViewById(2131755385));
    this.l = ((ImageView)findViewById(2131755386));
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        h.a(SubmitIDInfoActivity.this, SubmitIDInfoActivity.a(SubmitIDInfoActivity.this));
        SubmitIDInfoActivity.a(SubmitIDInfoActivity.this, 101);
      }
    });
    this.l.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        h.a(SubmitIDInfoActivity.this, SubmitIDInfoActivity.a(SubmitIDInfoActivity.this));
        SubmitIDInfoActivity.a(SubmitIDInfoActivity.this, 102);
      }
    });
    this.o = ((Button)findViewById(2131755387));
    this.o.setEnabled(false);
    this.o.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (h.l(SubmitIDInfoActivity.this)) {
          SubmitIDInfoActivity.e(SubmitIDInfoActivity.this);
        }
      }
    });
    this.f = ((LoadingToastView)findViewById(2131755754));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820555, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
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
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    q.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/SubmitIDInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */