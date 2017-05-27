package com.mobike.mobikeapp.activity.customer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.v4.util.Pair;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import b.a.e;
import b.a.j;
import com.google.zxing.client.android.QRCodeScannerActivity;
import com.growingio.android.sdk.agent.VdsAgent;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.widget.GridViewAtMostView;
import com.mobike.mobikeapp.widget.LoadingPageView;
import com.mobike.mobikeapp.widget.NonFocusingScrollView;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@j
public class BikeDamageReportActivity
  extends BaseActivity
{
  ArrayList<Pair<Integer, String>> a;
  private String b;
  private TextView e;
  private TextView f;
  private TextView g;
  private EditText h;
  private Button i;
  private ImageView j;
  private GridViewAtMostView k;
  private a l;
  private NonFocusingScrollView m;
  private LoadingPageView n;
  private String o;
  private com.mobike.mobikeapp.imagepicker.b p;
  
  private void a(Intent paramIntent)
  {
    if (TextUtils.isEmpty(this.b))
    {
      this.b = paramIntent.getStringExtra("qrcode");
      o();
    }
    for (;;)
    {
      this.e.setText(this.b);
      return;
      this.b = paramIntent.getStringExtra("qrcode");
    }
  }
  
  private void k()
  {
    MobclickAgent.c(this, "40008");
    this.n = ((LoadingPageView)findViewById(2131755751));
    this.b = getIntent().getStringExtra(com.mobike.mobikeapp.model.c.b.aP);
    this.e = ((TextView)findViewById(2131755346));
    this.f = ((TextView)findViewById(2131755347));
    findViewById(2131755344).setOnClickListener(a.a(this));
    this.j = ((ImageView)findViewById(2131755744));
    this.j.setOnClickListener(b.a(this));
    this.i = ((Button)findViewById(2131755197));
    this.i.setOnClickListener(c.a(this));
    m();
    n();
    q();
    if (RideManager.a().p()) {
      this.b = RideManager.a().n();
    }
    o();
  }
  
  private void l()
  {
    if (TextUtils.isEmpty(this.o)) {}
    for (final String str1 = null;; str1 = com.mobike.mobikeapp.util.a.k())
    {
      String str2 = this.l.c();
      String str3 = this.h.getText().toString();
      if (h.l(this))
      {
        MobclickAgent.c(this, "40009");
        this.n.a();
        this.i.setEnabled(false);
        com.mobike.mobikeapp.a.f.a(this.b, str1, str2, str3, new com.mobike.mobikeapp.model.b.a()
        {
          public void a(int paramAnonymousInt, String paramAnonymousString)
          {
            h.a(BikeDamageReportActivity.this, paramAnonymousString);
            BikeDamageReportActivity.b(BikeDamageReportActivity.this).b();
            BikeDamageReportActivity.c(BikeDamageReportActivity.this).setEnabled(true);
          }
          
          public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
          {
            if (paramAnonymousJSONObject != null)
            {
              paramAnonymousArrayOfd = paramAnonymousJSONObject.optString("object");
              paramAnonymousJSONObject.optString("message");
              paramAnonymousJSONObject = h.f(BikeDamageReportActivity.a(BikeDamageReportActivity.this));
              if (paramAnonymousJSONObject != null) {
                com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, str1, paramAnonymousArrayOfd, f.a(this));
              }
            }
            else
            {
              return;
            }
            h.a(BikeDamageReportActivity.this, BikeDamageReportActivity.this.getString(2131296650));
            BikeDamageReportActivity.this.finish();
          }
        });
      }
      return;
    }
  }
  
  private void m()
  {
    this.k = ((GridViewAtMostView)findViewById(2131755182));
    p();
    this.l = new a(null);
    this.k.setAdapter(this.l);
  }
  
  private void n()
  {
    this.m = ((NonFocusingScrollView)findViewById(2131755181));
    this.g = ((TextView)findViewById(2131755252));
    this.g.setText(getString(2131296901, new Object[] { Integer.valueOf(140) }));
    this.h = ((EditText)findViewById(2131755251));
    this.h.setOnTouchListener(d.a(this));
    this.h.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        BikeDamageReportActivity.d(BikeDamageReportActivity.this).setText(BikeDamageReportActivity.this.getString(2131296901, new Object[] { Integer.valueOf(140 - paramAnonymousCharSequence.length()) }));
      }
    });
  }
  
  private void o()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      this.e.setTextSize(18.0F);
      this.e.setText(this.b);
      this.e.animate().translationY(-14.0F).translationX(h.a(this, 10.0F)).setDuration(500L).start();
      this.f.animate().scaleX(1.0F).scaleY(1.0F).setDuration(500L).start();
      if (this.l.a().size() > 0) {
        this.i.setEnabled(true);
      }
    }
  }
  
  private void p()
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    for (;;)
    {
      this.a.add(new Pair(Integer.valueOf(11), getString(2131296562)));
      this.a.add(new Pair(Integer.valueOf(3), getString(2131296643)));
      this.a.add(new Pair(Integer.valueOf(12), getString(2131296561)));
      this.a.add(new Pair(Integer.valueOf(13), getString(2131296571)));
      this.a.add(new Pair(Integer.valueOf(14), getString(2131296569)));
      this.a.add(new Pair(Integer.valueOf(15), getString(2131296560)));
      this.a.add(new Pair(Integer.valueOf(0), getString(2131296633)));
      this.a.add(new Pair(Integer.valueOf(5), getString(2131296653)));
      return;
      this.a.clear();
    }
  }
  
  private void q()
  {
    this.p = com.mobike.mobikeapp.imagepicker.b.a();
    this.p.a(new GlideImageLoader());
    this.p.c(true);
    this.p.b(false);
    this.p.a(false);
    this.p.d(false);
  }
  
  private void r()
  {
    Intent localIntent = new Intent(this, QRCodeScannerActivity.class);
    localIntent.setAction("com.mobike.action.getQRCode");
    startActivityForResult(localIntent, 100);
  }
  
  @b.a.c(a={"android.permission.CAMERA"})
  void a()
  {
    r();
  }
  
  @e(a={"android.permission.CAMERA"})
  void b()
  {
    h.a(this, 2131296814);
    r();
  }
  
  @b.a.d(a={"android.permission.CAMERA"})
  void c()
  {
    h.a(this, 2131296814);
    r();
  }
  
  @b.a.c(a={"android.permission.READ_EXTERNAL_STORAGE"})
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
    this.o = ((ImageItem)paramIntent.get(0)).path;
    this.p.l().displayImage(this, ((ImageItem)paramIntent.get(0)).path, this.j);
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
  
  public void onBackPressed()
  {
    if (this.n.getVisibility() != 0) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968606);
    k();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt) {}
  
  private class a
    extends BaseAdapter
  {
    private List<Integer> b = new ArrayList();
    
    private a() {}
    
    public List<Integer> a()
    {
      return this.b;
    }
    
    public void a(int paramInt)
    {
      Integer localInteger = (Integer)((Pair)BikeDamageReportActivity.this.a.get(paramInt)).first;
      if (this.b.contains(localInteger))
      {
        this.b.remove(localInteger);
        if (this.b.size() == 0) {
          BikeDamageReportActivity.c(BikeDamageReportActivity.this).setEnabled(false);
        }
      }
      do
      {
        return;
        this.b.add(localInteger);
      } while (TextUtils.isEmpty(BikeDamageReportActivity.e(BikeDamageReportActivity.this)));
      BikeDamageReportActivity.c(BikeDamageReportActivity.this).setEnabled(true);
    }
    
    public boolean b()
    {
      return !this.b.isEmpty();
    }
    
    public String c()
    {
      Collections.sort(this.b, new Comparator()
      {
        public int a(Integer paramAnonymousInteger1, Integer paramAnonymousInteger2)
        {
          if (paramAnonymousInteger1.intValue() > paramAnonymousInteger2.intValue()) {
            return 1;
          }
          return -1;
        }
      });
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        localStringBuilder.append(i + ",");
      }
      return localStringBuilder.toString();
    }
    
    public void d()
    {
      this.b.clear();
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (BikeDamageReportActivity.this.a == null) {
        return 0;
      }
      return BikeDamageReportActivity.this.a.size();
    }
    
    public Object getItem(int paramInt)
    {
      if (BikeDamageReportActivity.this.a == null) {
        return null;
      }
      return BikeDamageReportActivity.this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = View.inflate(BikeDamageReportActivity.this, 2130968761, null);
      }
      paramView = (Pair)getItem(paramInt);
      CheckBox localCheckBox = (CheckBox)paramViewGroup.findViewById(2131755715);
      localCheckBox.setOnClickListener(g.a(this, paramInt));
      if (paramView != null) {
        localCheckBox.setText((CharSequence)paramView.second);
      }
      if (this.b.contains(((Pair)BikeDamageReportActivity.this.a.get(paramInt)).first))
      {
        localCheckBox.setChecked(true);
        return paramViewGroup;
      }
      localCheckBox.setChecked(false);
      return paramViewGroup;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/BikeDamageReportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */