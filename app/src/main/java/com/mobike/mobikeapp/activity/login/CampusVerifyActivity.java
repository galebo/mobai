package com.mobike.mobikeapp.activity.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import b.a.c;
import b.a.j;
import com.bumptech.glide.o;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.data.CampusVerifyDataInfo;
import com.mobike.mobikeapp.data.ManualCampusVerifyDataInfo;
import com.mobike.mobikeapp.data.ManualCampusVerifyDataInfo.CampusIDPhotoData;
import com.mobike.mobikeapp.data.UniversityInfo;
import com.mobike.mobikeapp.data.UniversityInfo.UniversityData;
import com.mobike.mobikeapp.imagepicker.b;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@j
public class CampusVerifyActivity
  extends BaseActivity
{
  private static final int a = 101;
  private static final int b = 102;
  private LoadingToastView e;
  private TextView f;
  private EditText g;
  private Spinner h;
  private String i;
  private Button j;
  private ImageView k;
  private ImageView l;
  private String m;
  private String n;
  private Button o;
  private View p;
  private boolean q = false;
  private View r;
  private UniversityInfo.UniversityData[] s = { new UniversityInfo.UniversityData("1002", "北京大学", 11), new UniversityInfo.UniversityData("2003", "同济大学", 11) };
  private ArrayAdapter<UniversityInfo.UniversityData> t;
  
  private void b(int paramInt)
  {
    d();
    a.a(this, paramInt);
  }
  
  private void c()
  {
    this.p = findViewById(2131755954);
    this.p.setVisibility(0);
    ((TextView)this.p.findViewById(2131755958)).setText(q.a().i(this));
    ((TextView)this.p.findViewById(2131755959)).setText(this.g.getText());
    ((TextView)this.p.findViewById(2131755960)).setText(this.i);
    this.k = ((ImageView)findViewById(2131755961));
    this.l = ((ImageView)findViewById(2131755962));
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CampusVerifyActivity.a(CampusVerifyActivity.this, 101);
      }
    });
    this.l.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CampusVerifyActivity.a(CampusVerifyActivity.this, 102);
      }
    });
    this.o = ((Button)findViewById(2131755963));
    this.o.setEnabled(false);
    this.o.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (h.l(CampusVerifyActivity.this)) {
          CampusVerifyActivity.f(CampusVerifyActivity.this);
        }
      }
    });
    this.q = true;
  }
  
  private void d()
  {
    b localb = b.a();
    localb.a(new GlideImageLoader());
    localb.c(true);
    localb.b(false);
    localb.a(false);
    localb.d(false);
  }
  
  private void e()
  {
    Button localButton = this.o;
    if ((!TextUtils.isEmpty(this.m)) && (!TextUtils.isEmpty(this.n))) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  private void f()
  {
    if (h.l(this))
    {
      this.e.a();
      com.mobike.mobikeapp.a.f.e(com.mobike.mobikeapp.util.l.a().e(), new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          CampusVerifyActivity.j(CampusVerifyActivity.this).b();
        }
        
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null)
          {
            paramAnonymousArrayOfd = (UniversityInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), UniversityInfo.class);
            if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.universities != null) && (!paramAnonymousArrayOfd.universities.isEmpty()))
            {
              CampusVerifyActivity.a(CampusVerifyActivity.this, (UniversityInfo.UniversityData[])paramAnonymousArrayOfd.universities.toArray(CampusVerifyActivity.g(CampusVerifyActivity.this)));
              CampusVerifyActivity.a(CampusVerifyActivity.this, new ArrayAdapter(CampusVerifyActivity.this, 2130968839, paramAnonymousArrayOfd.universities));
              CampusVerifyActivity.h(CampusVerifyActivity.this).setDropDownViewResource(17367049);
              CampusVerifyActivity.i(CampusVerifyActivity.this).setAdapter(CampusVerifyActivity.h(CampusVerifyActivity.this));
            }
          }
          CampusVerifyActivity.j(CampusVerifyActivity.this).b();
        }
      });
    }
  }
  
  private void k()
  {
    this.j.setEnabled(false);
    this.e.a();
    String str = this.g.getText().toString();
    UniversityInfo.UniversityData localUniversityData = (UniversityInfo.UniversityData)this.h.getSelectedItem();
    this.i = localUniversityData.name;
    com.mobike.mobikeapp.a.f.a(str, localUniversityData.code, localUniversityData.name, localUniversityData.type, new n()
    {
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        h.a(CampusVerifyActivity.this, CampusVerifyActivity.this.getString(2131296454));
        CampusVerifyActivity.b(CampusVerifyActivity.this).setEnabled(true);
        CampusVerifyActivity.j(CampusVerifyActivity.this).b();
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousString, paramAnonymousThrowable);
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONArray paramAnonymousJSONArray)
      {
        h.a(CampusVerifyActivity.this, CampusVerifyActivity.this.getString(2131296454));
        CampusVerifyActivity.b(CampusVerifyActivity.this).setEnabled(true);
        CampusVerifyActivity.j(CampusVerifyActivity.this).b();
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousThrowable, paramAnonymousJSONArray);
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
      {
        h.a(CampusVerifyActivity.this, CampusVerifyActivity.this.getString(2131296454));
        CampusVerifyActivity.b(CampusVerifyActivity.this).setEnabled(true);
        CampusVerifyActivity.j(CampusVerifyActivity.this).b();
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousThrowable, paramAnonymousJSONObject);
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = (CampusVerifyDataInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), CampusVerifyDataInfo.class);
        if (paramAnonymousArrayOfd != null) {}
        switch (paramAnonymousArrayOfd.result)
        {
        default: 
          CampusVerifyActivity.b(CampusVerifyActivity.this).setEnabled(true);
          CampusVerifyActivity.j(CampusVerifyActivity.this).b();
          h.a(CampusVerifyActivity.this, paramAnonymousArrayOfd.message);
          return;
        case 0: 
          h.a(CampusVerifyActivity.this, CampusVerifyActivity.this.getString(2131297123));
          q.a().b(CampusVerifyActivity.this, 0);
          CampusVerifyActivity.this.setResult(-1);
          CampusVerifyActivity.this.finish();
          return;
        case 547: 
          CampusVerifyActivity.b(CampusVerifyActivity.this).setEnabled(true);
          CampusVerifyActivity.j(CampusVerifyActivity.this).b();
          h.a(CampusVerifyActivity.this, CampusVerifyActivity.a(CampusVerifyActivity.this));
          CampusVerifyActivity.k(CampusVerifyActivity.this);
          return;
        }
        h.a(CampusVerifyActivity.this, paramAnonymousArrayOfd.message);
        CampusVerifyActivity.a(CampusVerifyActivity.this).requestFocus();
        CampusVerifyActivity.b(CampusVerifyActivity.this).setEnabled(true);
        CampusVerifyActivity.j(CampusVerifyActivity.this).b();
      }
    });
  }
  
  private void l()
  {
    this.o.setEnabled(false);
    this.e.a();
    String str1 = this.g.getText().toString();
    UniversityInfo.UniversityData localUniversityData = (UniversityInfo.UniversityData)this.h.getSelectedItem();
    final String str2 = com.mobike.mobikeapp.util.a.f();
    final String str3 = com.mobike.mobikeapp.util.a.g();
    com.mobike.mobikeapp.a.f.a(str1, localUniversityData.code, localUniversityData.name, localUniversityData.type, str2, str3, new n()
    {
      public void a(int paramAnonymousInt, final cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = (ManualCampusVerifyDataInfo)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), ManualCampusVerifyDataInfo.class);
        if (paramAnonymousArrayOfd != null) {
          switch (paramAnonymousArrayOfd.result)
          {
          default: 
            h.a(CampusVerifyActivity.this, paramAnonymousArrayOfd.message);
            CampusVerifyActivity.n(CampusVerifyActivity.this).setEnabled(true);
            CampusVerifyActivity.j(CampusVerifyActivity.this).b();
          }
        }
        do
        {
          return;
          paramAnonymousArrayOfd = paramAnonymousArrayOfd.campusIDPhotoData;
        } while (paramAnonymousArrayOfd == null);
        paramAnonymousJSONObject = h.f(CampusVerifyActivity.l(CampusVerifyActivity.this));
        com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, str2, paramAnonymousArrayOfd.idPhotoOneToken, new com.qiniu.android.b.g()
        {
          public void a(String paramAnonymous2String, com.qiniu.android.http.l paramAnonymous2l, JSONObject paramAnonymous2JSONObject)
          {
            if (paramAnonymous2l.d())
            {
              paramAnonymous2String = h.f(CampusVerifyActivity.m(CampusVerifyActivity.this));
              com.mobike.mobikeapp.util.d.a().a(paramAnonymous2String, CampusVerifyActivity.9.this.l, paramAnonymousArrayOfd.idPhotoTwoToken, new com.qiniu.android.b.g()
              {
                public void a(String paramAnonymous3String, com.qiniu.android.http.l paramAnonymous3l, JSONObject paramAnonymous3JSONObject)
                {
                  if (paramAnonymous3l.d())
                  {
                    q.a().b(CampusVerifyActivity.this, 4);
                    CampusVerifyActivity.this.setResult(-1);
                    CampusVerifyActivity.this.finish();
                    return;
                  }
                  h.a(CampusVerifyActivity.this, CampusVerifyActivity.this.getString(2131296647));
                  CampusVerifyActivity.n(CampusVerifyActivity.this).setEnabled(true);
                  CampusVerifyActivity.j(CampusVerifyActivity.this).b();
                }
              });
              return;
            }
            h.a(CampusVerifyActivity.this, CampusVerifyActivity.this.getString(2131296647));
            CampusVerifyActivity.n(CampusVerifyActivity.this).setEnabled(true);
            CampusVerifyActivity.j(CampusVerifyActivity.this).b();
          }
        });
      }
    });
  }
  
  private void m()
  {
    this.m = null;
    this.k.setImageResource(2130838227);
    this.n = null;
    this.l.setImageResource(2130838228);
    this.p.setVisibility(8);
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
        break label40;
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
    label40:
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
    switch (paramInt1)
    {
    default: 
      return;
    case 101: 
      this.m = ((ImageItem)paramIntent.get(0)).path;
      com.bumptech.glide.l.a(this).a(this.m).d().a(this.k);
      e();
      return;
    }
    this.n = ((ImageItem)paramIntent.get(0)).path;
    com.bumptech.glide.l.a(this).a(this.n).d().a(this.l);
    e();
  }
  
  public void onBackPressed()
  {
    if (this.q)
    {
      m();
      this.q = false;
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968661);
    this.f = ((TextView)findViewById(2131755184));
    this.f.setText(q.a().i(this));
    this.g = ((EditText)findViewById(2131755408));
    this.h = ((Spinner)findViewById(2131755409));
    this.t = new ArrayAdapter(this, 2130968839, this.s);
    this.t.setDropDownViewResource(17367049);
    this.h.setAdapter(this.t);
    this.g.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramAnonymousEditable = CampusVerifyActivity.b(CampusVerifyActivity.this);
        if (!TextUtils.isEmpty(CampusVerifyActivity.a(CampusVerifyActivity.this).getText())) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousEditable.setEnabled(bool);
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.j = ((Button)findViewById(2131755410));
    this.j.setEnabled(false);
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (h.l(CampusVerifyActivity.this)) {
          CampusVerifyActivity.c(CampusVerifyActivity.this);
        }
      }
    });
    this.e = ((LoadingToastView)findViewById(2131755754));
    this.e.setLoadingText(2131297130);
    if (q.a().d(this) == 5)
    {
      this.r = findViewById(2131755919);
      this.r.setVisibility(0);
      paramBundle = q.a().e(getApplicationContext());
      TextView localTextView = (TextView)this.r.findViewById(2131755920);
      if (!TextUtils.isEmpty(paramBundle)) {
        localTextView.setText(paramBundle.replace('^', '\n'));
      }
      ((Button)findViewById(2131755921)).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CampusVerifyActivity.d(CampusVerifyActivity.this).setVisibility(8);
          h.b(CampusVerifyActivity.this, CampusVerifyActivity.a(CampusVerifyActivity.this));
          CampusVerifyActivity.e(CampusVerifyActivity.this);
        }
      });
      return;
    }
    this.g.requestFocus();
    f();
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
    onBackPressed();
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    a.a(this, paramInt, paramArrayOfInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/CampusVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */