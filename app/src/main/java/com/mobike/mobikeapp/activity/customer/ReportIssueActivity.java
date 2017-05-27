package com.mobike.mobikeapp.activity.customer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ab;
import android.support.v4.util.Pair;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import b.a.c;
import b.a.e;
import b.a.j;
import com.google.zxing.client.android.QRCodeScannerActivity;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.RideManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@j
public class ReportIssueActivity
  extends BaseActivity
{
  public static final int a = 100;
  public static final int b = 300;
  private Handler e = new Handler();
  private ScrollView f;
  private GridView g;
  private b h;
  private EditText i;
  private TextView j;
  private Button k;
  private String l;
  private TextView m;
  private TextView n;
  private Button o;
  private Bitmap p;
  private Button q;
  private Button r;
  private a s;
  private List<Pair<Integer, String>> t;
  private List<Pair<Integer, String>> u;
  private String v;
  private FrameLayout w;
  private ViewStub x;
  
  private void a(Intent paramIntent)
  {
    this.o.setEnabled(false);
    if (paramIntent == null)
    {
      paramIntent = Toast.makeText(this, 2131296756, 0);
      if (!(paramIntent instanceof Toast))
      {
        paramIntent.show();
        return;
      }
      VdsAgent.showToast((Toast)paramIntent);
      return;
    }
    if (h.l(this))
    {
      this.v = ((ImageItem)((ArrayList)paramIntent.getSerializableExtra("extra_result_items")).get(0)).path;
      return;
    }
    h.a(this, getString(2131296740));
  }
  
  private void b(Intent paramIntent)
  {
    this.l = paramIntent.getStringExtra("qrcode");
    this.m.setText(this.l);
    this.k.setVisibility(8);
    this.q.setEnabled(this.h.b());
  }
  
  private void k()
  {
    this.f = ((ScrollView)findViewById(2131755349));
    this.g = ((GridView)findViewById(2131755353));
    this.h = new b(null);
    this.g.setAdapter(this.h);
    this.g.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((Integer)((Pair)ReportIssueActivity.a(ReportIssueActivity.this).getItem(paramAnonymousInt)).first).intValue() == -1)
        {
          ReportIssueActivity.b(ReportIssueActivity.this);
          return;
        }
        if (ReportIssueActivity.c(ReportIssueActivity.this) != null) {
          ReportIssueActivity.c(ReportIssueActivity.this).e();
        }
        ReportIssueActivity.a(ReportIssueActivity.this).a(paramAnonymousInt);
        ReportIssueActivity.a(ReportIssueActivity.this).notifyDataSetChanged();
      }
    });
    this.i = ((EditText)findViewById(2131755354));
    this.i.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ReportIssueActivity.d(ReportIssueActivity.this).setBackgroundResource(2130837834);
          return;
        }
        ReportIssueActivity.d(ReportIssueActivity.this).setBackgroundResource(2130837835);
      }
    });
    this.i.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        ReportIssueActivity.f(ReportIssueActivity.this).postDelayed(new Runnable()
        {
          public void run()
          {
            ReportIssueActivity.e(ReportIssueActivity.this).fullScroll(130);
          }
        }, 500L);
        return false;
      }
    });
    this.i.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = ReportIssueActivity.this.getResources().getInteger(2131558408);
        paramAnonymousEditable = String.format(ReportIssueActivity.this.getString(2131296544), new Object[] { Integer.valueOf(i - paramAnonymousEditable.length()) });
        ReportIssueActivity.g(ReportIssueActivity.this).setText(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.j = ((TextView)findViewById(2131755355));
    this.j.setText(String.format(getString(2131296544), new Object[] { Integer.valueOf(getResources().getInteger(2131558408)) }));
    this.k = ((Button)findViewById(2131755352));
    View.OnClickListener local6 = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ad.a(ReportIssueActivity.this);
      }
    };
    this.k.setOnClickListener(local6);
    this.m = ((TextView)findViewById(2131755350));
    this.n = ((TextView)findViewById(2131755351));
    this.n.setOnClickListener(local6);
    this.o = ((Button)findViewById(2131755356));
    this.o.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ReportIssueActivity.h(ReportIssueActivity.this);
      }
    });
    this.q = ((Button)findViewById(2131755358));
    this.q.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ReportIssueActivity.i(ReportIssueActivity.this);
      }
    });
  }
  
  private void l()
  {
    if (this.x == null)
    {
      this.x = ((ViewStub)findViewById(2131755359));
      this.x.inflate();
      this.w = ((FrameLayout)findViewById(2131756006));
      this.r = ((Button)findViewById(2131756008));
      this.r.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ReportIssueActivity.c(ReportIssueActivity.this).c();
          ReportIssueActivity.j(ReportIssueActivity.this);
        }
      });
      t();
      ListView localListView = (ListView)findViewById(2131756007);
      this.s = new a(null);
      localListView.setAdapter(this.s);
      this.w.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ReportIssueActivity.j(ReportIssueActivity.this);
        }
      });
    }
    m();
  }
  
  private void m()
  {
    this.w.setVisibility(0);
  }
  
  private void n()
  {
    this.s.d();
    this.w.setVisibility(8);
    this.h.a(this.s.a(), 3);
    this.h.notifyDataSetChanged();
  }
  
  private void o()
  {
    q();
    ad.b(this);
  }
  
  private void p()
  {
    Intent localIntent = new Intent(this, QRCodeScannerActivity.class);
    localIntent.setAction("com.mobike.action.getQRCode");
    startActivityForResult(localIntent, 100);
  }
  
  private void q()
  {
    com.mobike.mobikeapp.imagepicker.b localb = com.mobike.mobikeapp.imagepicker.b.a();
    localb.a(new GlideImageLoader());
    localb.c(true);
    localb.b(false);
    localb.a(false);
    localb.d(false);
  }
  
  private void r()
  {
    if (TextUtils.isEmpty(this.v)) {}
    for (final String str1 = null;; str1 = com.mobike.mobikeapp.util.a.k())
    {
      if (-1 != this.h.a()) {
        break label92;
      }
      if (this.s != null) {
        break;
      }
      return;
    }
    label92:
    for (String str2 = this.s.b();; str2 = this.h.a() + ",")
    {
      String str3 = this.i.getText().toString();
      if (!h.l(this)) {
        break;
      }
      this.q.setEnabled(false);
      f.a(this.l, str1, str2, str3, new com.mobike.mobikeapp.model.b.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          h.a(ReportIssueActivity.this, paramAnonymousString);
          ReportIssueActivity.l(ReportIssueActivity.this).setEnabled(true);
        }
        
        public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject != null) {
            try
            {
              paramAnonymousArrayOfd = paramAnonymousJSONObject.getString("object");
              paramAnonymousJSONObject = h.f(ReportIssueActivity.k(ReportIssueActivity.this));
              if (paramAnonymousJSONObject != null)
              {
                com.mobike.mobikeapp.util.d.a().a(paramAnonymousJSONObject, str1, paramAnonymousArrayOfd, ac.a(this));
                return;
              }
              h.a(ReportIssueActivity.this, ReportIssueActivity.this.getString(2131296650));
              ReportIssueActivity.this.finish();
              return;
            }
            catch (JSONException paramAnonymousArrayOfd)
            {
              paramAnonymousArrayOfd.printStackTrace();
            }
          }
        }
      });
      return;
    }
  }
  
  private void s()
  {
    if (this.t == null) {
      this.t = new ArrayList();
    }
    for (;;)
    {
      this.t.add(new Pair(Integer.valueOf(7), getString(2131296654)));
      this.t.add(new Pair(Integer.valueOf(8), getString(2131296639)));
      this.t.add(new Pair(Integer.valueOf(9), getString(2131296644)));
      this.t.add(new Pair(Integer.valueOf(-1), getString(2131296904)));
      this.t.add(new Pair(Integer.valueOf(17), getString(2131296557)));
      this.t.add(new Pair(Integer.valueOf(5), getString(2131296653)));
      return;
      this.t.clear();
    }
  }
  
  private void t()
  {
    if (this.u == null) {
      this.u = new ArrayList();
    }
    for (;;)
    {
      this.u.add(new Pair(Integer.valueOf(11), getString(2131296562)));
      this.u.add(new Pair(Integer.valueOf(3), getString(2131296643)));
      this.u.add(new Pair(Integer.valueOf(12), getString(2131296561)));
      this.u.add(new Pair(Integer.valueOf(13), getString(2131296571)));
      this.u.add(new Pair(Integer.valueOf(14), getString(2131296569)));
      this.u.add(new Pair(Integer.valueOf(15), getString(2131296560)));
      this.u.add(new Pair(Integer.valueOf(0), getString(2131296633)));
      return;
      this.u.clear();
    }
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
  
  @TargetApi(16)
  @c(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void d()
  {
    startActivityForResult(new Intent(this, ImageGridActivity.class), 300);
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
      b(paramIntent);
    }
    while ((paramInt2 != 1004) || (paramInt1 != 300)) {
      return;
    }
    a(paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.w != null) && (this.w.getVisibility() == 0))
    {
      n();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968645);
    s();
    k();
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21)) {
      findViewById(2131755256).setPadding(0, h.q(this), 0, 0);
    }
    if ((RideManager.a().u()) || (RideManager.a().p()))
    {
      this.l = RideManager.a().n();
      this.m.setText(this.l);
      this.k.setVisibility(8);
    }
    do
    {
      do
      {
        return;
        paramBundle = getIntent();
      } while (paramBundle == null);
      paramBundle = paramBundle.getStringExtra(com.mobike.mobikeapp.model.c.b.aP);
    } while (TextUtils.isEmpty(paramBundle));
    this.l = paramBundle;
    this.m.setText(this.l);
    this.k.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    if (this.p != null) {
      this.p.recycle();
    }
    super.onDestroy();
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
    ad.a(this, paramInt, paramArrayOfInt);
  }
  
  private class a
    extends BaseAdapter
  {
    private Set<Integer> b = new HashSet();
    private Set<Integer> c = new HashSet();
    
    private a() {}
    
    private boolean f()
    {
      return !this.b.isEmpty();
    }
    
    public void a(int paramInt)
    {
      Button localButton;
      if (this.c.contains(Integer.valueOf(paramInt)))
      {
        this.c.remove(Integer.valueOf(paramInt));
        localButton = ReportIssueActivity.p(ReportIssueActivity.this);
        if ((!f()) && (!a())) {
          break label110;
        }
      }
      label110:
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        return;
        if (this.b.contains(Integer.valueOf(paramInt)))
        {
          this.b.remove(Integer.valueOf(paramInt));
          break;
        }
        this.b.add(Integer.valueOf(paramInt));
        break;
      }
    }
    
    public boolean a()
    {
      return !this.c.isEmpty();
    }
    
    public String b()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        i = ((Integer)((Pair)ReportIssueActivity.o(ReportIssueActivity.this).get(i)).first).intValue();
        localStringBuilder.append(i + ",");
      }
      return localStringBuilder.toString();
    }
    
    public void c()
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (!this.c.contains(Integer.valueOf(i))) {
          this.c.add(Integer.valueOf(i));
        }
      }
    }
    
    public void d()
    {
      this.b.clear();
      notifyDataSetChanged();
      Button localButton = ReportIssueActivity.p(ReportIssueActivity.this);
      if ((f()) || (a())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        return;
      }
    }
    
    public void e()
    {
      this.c.clear();
      notifyDataSetChanged();
      Button localButton = ReportIssueActivity.p(ReportIssueActivity.this);
      if ((f()) || (a())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        return;
      }
    }
    
    public int getCount()
    {
      if (ReportIssueActivity.o(ReportIssueActivity.this) == null) {
        return 0;
      }
      return ReportIssueActivity.o(ReportIssueActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      if (ReportIssueActivity.o(ReportIssueActivity.this) == null) {
        return null;
      }
      return ReportIssueActivity.o(ReportIssueActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = View.inflate(ReportIssueActivity.this, 2130968761, null);
      }
      paramView = (Pair)getItem(paramInt);
      CheckBox localCheckBox = (CheckBox)paramViewGroup.findViewById(2131755715);
      localCheckBox.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ReportIssueActivity.a.this.a(paramInt);
        }
      });
      if (paramView != null) {
        localCheckBox.setText((CharSequence)paramView.second);
      }
      if (this.c.contains(Integer.valueOf(paramInt)))
      {
        localCheckBox.setChecked(true);
        return paramViewGroup;
      }
      localCheckBox.setChecked(false);
      return paramViewGroup;
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private Set<Integer> b = new HashSet();
    
    private b() {}
    
    public int a()
    {
      int i = -1;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        i = ((Integer)((Pair)ReportIssueActivity.n(ReportIssueActivity.this).get(i)).first).intValue();
      }
      return i;
    }
    
    public void a(int paramInt)
    {
      Button localButton;
      if (this.b.contains(Integer.valueOf(paramInt)))
      {
        this.b.remove(Integer.valueOf(paramInt));
        localButton = ReportIssueActivity.l(ReportIssueActivity.this);
        if ((!b()) || (ReportIssueActivity.m(ReportIssueActivity.this) == null)) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        return;
        this.b.clear();
        this.b.add(Integer.valueOf(paramInt));
        break;
      }
    }
    
    public void a(boolean paramBoolean, int paramInt)
    {
      Button localButton;
      if (paramBoolean)
      {
        this.b.clear();
        this.b.add(Integer.valueOf(paramInt));
        localButton = ReportIssueActivity.l(ReportIssueActivity.this);
        if ((!b()) || (ReportIssueActivity.m(ReportIssueActivity.this) == null)) {
          break label93;
        }
      }
      label93:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localButton.setEnabled(paramBoolean);
        return;
        if (!this.b.contains(Integer.valueOf(paramInt))) {
          break;
        }
        this.b.remove(Integer.valueOf(paramInt));
        break;
      }
    }
    
    public boolean b()
    {
      return !this.b.isEmpty();
    }
    
    public int getCount()
    {
      if (ReportIssueActivity.n(ReportIssueActivity.this) == null) {
        return 0;
      }
      return ReportIssueActivity.n(ReportIssueActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ReportIssueActivity.n(ReportIssueActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(ReportIssueActivity.this).inflate(2130968829, paramViewGroup, false);
      }
      paramView = (Pair)getItem(paramInt);
      ((TextView)localView.findViewById(2131755899)).setText((CharSequence)paramView.second);
      paramView = (CheckBox)localView.findViewById(2131755900);
      if (this.b.contains(Integer.valueOf(paramInt)))
      {
        paramView.setChecked(true);
        return localView;
      }
      paramView.setChecked(false);
      return localView;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/ReportIssueActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */