package com.mobike.mobikeapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.SearchAutoComplete;
import android.support.v7.widget.SearchView.c;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.middleware.map.LatLng;
import com.baidu.middleware.search.ERRORNO;
import com.baidu.middleware.search.OnGetSuggestionResultListener;
import com.baidu.middleware.search.PoiInfo;
import com.baidu.middleware.search.SuggestionInfo;
import com.baidu.middleware.search.SuggestionResult;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.adapter.n;
import com.mobike.mobikeapp.data.PoiSearchSugItem;
import com.mobike.mobikeapp.data.PoiSearchSugItem.SugItemType;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.model.data.CommonlyAddress;
import com.mobike.mobikeapp.util.GeocodeSearchListener;
import com.mobike.mobikeapp.util.GeocodeSearchListener.GeocodeMode;
import com.mobike.mobikeapp.util.GeocodeSearchListener.a;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.util.s;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class ActionSearchActivity
  extends BaseActivity
{
  private static final int s = 1;
  private static final int t = 2;
  private LinkedList<PoiSearchSugItem> a = null;
  private n b;
  private SearchView e;
  private ListView f;
  private View g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private TextView k;
  private TextView l;
  private RelativeLayout m;
  private ImageView n;
  private TextView o;
  private TextView p;
  private RelativeLayout q;
  private View r;
  private Set<String> u;
  private boolean v;
  
  private void a()
  {
    b();
    k();
    m();
    LatLng localLatLng = l.a().h();
    if (localLatLng != null) {
      a(localLatLng);
    }
  }
  
  private void a(SearchView.SearchAutoComplete paramSearchAutoComplete)
  {
    try
    {
      Field localField = paramSearchAutoComplete.getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("mCursorDrawableRes");
      localField.setAccessible(true);
      localField.set(paramSearchAutoComplete, Integer.valueOf(2130838233));
      return;
    }
    catch (Exception paramSearchAutoComplete)
    {
      paramSearchAutoComplete.printStackTrace();
    }
  }
  
  private void a(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.e.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {}
    try
    {
      Method localMethod = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[] { Integer.TYPE, ResultReceiver.class });
      localMethod.setAccessible(true);
      if (localMethod != null) {
        localMethod.invoke(localInputMethodManager, new Object[] { Integer.valueOf(2), null });
      }
      localInputMethodManager.showSoftInput(paramView, 2);
      return;
    }
    catch (Exception paramView) {}
  }
  
  private void a(LatLng paramLatLng)
  {
    GeocodeSearchListener localGeocodeSearchListener = new GeocodeSearchListener();
    localGeocodeSearchListener.a(new GeocodeSearchListener.a()
    {
      public void a(final String paramAnonymousString)
      {
        ActionSearchActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (!TextUtils.isEmpty(paramAnonymousString))
            {
              ActionSearchActivity.j(ActionSearchActivity.this).setText(paramAnonymousString);
              return;
            }
            ActionSearchActivity.j(ActionSearchActivity.this).setText(ActionSearchActivity.this.getString(2131296567));
          }
        });
      }
      
      public void b(String paramAnonymousString) {}
    });
    localGeocodeSearchListener.a(GeocodeSearchListener.GeocodeMode.SEARCH_ADDRESS);
    l.a().a(paramLatLng, localGeocodeSearchListener);
  }
  
  private void a(PoiInfo paramPoiInfo)
  {
    this.a = PoiSearchSugItem.getPoiSearchHistory(this);
    if (this.a == null) {
      this.a = new LinkedList();
    }
    paramPoiInfo = new PoiSearchSugItem(PoiSearchSugItem.SugItemType.HISTORY, paramPoiInfo.getName(), paramPoiInfo.getAddress());
    if (this.a.contains(paramPoiInfo)) {
      this.a.remove(paramPoiInfo);
    }
    for (;;)
    {
      this.a.add(0, paramPoiInfo);
      PoiSearchSugItem.savePoiSearchHistory(this, this.a);
      return;
      if (this.a.size() >= 10) {
        this.a.remove(9);
      }
    }
  }
  
  private void a(final CommonlyAddress paramCommonlyAddress)
  {
    com.mobike.mobikeapp.a.f.a(paramCommonlyAddress.mTitle, paramCommonlyAddress.mContent, paramCommonlyAddress.mPosition, paramCommonlyAddress.lat, paramCommonlyAddress.lng, new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if ((ActionSearchActivity.a(ActionSearchActivity.this) != null) && (ActionSearchActivity.a(ActionSearchActivity.this).contains(String.valueOf(paramCommonlyAddress.mPosition))))
        {
          ActionSearchActivity.a(ActionSearchActivity.this).remove(String.valueOf(paramCommonlyAddress.mPosition));
          com.mobike.mobikeapp.model.c.f.a().b(ActionSearchActivity.a(ActionSearchActivity.this));
        }
      }
    });
  }
  
  private void a(String paramString)
  {
    if (!h.g(this)) {
      h.a(this, 2131296740);
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    h.a(this, this.f);
    s.a().a(paramString, l.a().i(), f.a(this));
  }
  
  private void a(Set<String> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    label81:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramSet = (String)localIterator.next();
        if (paramSet.equals(String.valueOf(1))) {
          paramSet = com.mobike.mobikeapp.model.c.f.a().k();
        }
      }
      for (;;)
      {
        if (paramSet == null) {
          break label81;
        }
        a(paramSet);
        break;
        if (paramSet.equals(String.valueOf(2))) {
          paramSet = com.mobike.mobikeapp.model.c.f.a().m();
        } else {
          paramSet = null;
        }
      }
    }
  }
  
  private void b()
  {
    this.r = findViewById(2131755160);
    this.q = ((RelativeLayout)findViewById(2131755165));
    this.p = ((TextView)findViewById(2131755168));
    this.o = ((TextView)findViewById(2131755167));
    this.n = ((ImageView)findViewById(2131755166));
    this.m = ((RelativeLayout)findViewById(2131755161));
    this.l = ((TextView)findViewById(2131755164));
    this.k = ((TextView)findViewById(2131755163));
    this.j = ((ImageView)findViewById(2131755162));
    if (q.a().b())
    {
      c();
      this.u = com.mobike.mobikeapp.model.c.f.a().l();
      if (this.u != null) {
        a(this.u);
      }
    }
  }
  
  private void c()
  {
    this.r.setVisibility(0);
    this.j.setSelected(false);
    this.n.setSelected(false);
    this.m.setOnClickListener(a.a(this));
    this.q.setOnClickListener(b.a(this));
    d();
  }
  
  private void d()
  {
    f();
    e();
  }
  
  private void e()
  {
    CommonlyAddress localCommonlyAddress = com.mobike.mobikeapp.model.c.f.a().m();
    TextView localTextView;
    if (localCommonlyAddress != null)
    {
      localTextView = this.o;
      if (!TextUtils.isEmpty(localCommonlyAddress.mTitle)) {
        break label68;
      }
      str = "";
      localTextView.setText(str);
      localTextView = this.p;
      if (!TextUtils.isEmpty(localCommonlyAddress.mContent)) {
        break label76;
      }
    }
    label68:
    label76:
    for (String str = "";; str = localCommonlyAddress.mContent)
    {
      localTextView.setText(str);
      this.n.setSelected(true);
      return;
      str = localCommonlyAddress.mTitle;
      break;
    }
  }
  
  private void f()
  {
    CommonlyAddress localCommonlyAddress = com.mobike.mobikeapp.model.c.f.a().k();
    TextView localTextView;
    if (localCommonlyAddress != null)
    {
      localTextView = this.k;
      if (!TextUtils.isEmpty(localCommonlyAddress.mTitle)) {
        break label68;
      }
      str = "";
      localTextView.setText(str);
      localTextView = this.l;
      if (!TextUtils.isEmpty(localCommonlyAddress.mContent)) {
        break label76;
      }
    }
    label68:
    label76:
    for (String str = "";; str = localCommonlyAddress.mContent)
    {
      localTextView.setText(str);
      this.j.setSelected(true);
      return;
      str = localCommonlyAddress.mTitle;
      break;
    }
  }
  
  private void k()
  {
    this.e = ((SearchView)findViewById(2131755170));
    this.e.setIconified(false);
    this.e.setIconifiedByDefault(true);
    this.e.setQueryHint(getString(2131296955));
    SearchView.SearchAutoComplete localSearchAutoComplete = (SearchView.SearchAutoComplete)this.e.findViewById(2131755152);
    localSearchAutoComplete.setTextColor(-1);
    localSearchAutoComplete.setHintTextColor(ContextCompat.getColor(this, 2131624125));
    a(localSearchAutoComplete);
    localSearchAutoComplete.requestFocus();
    a(localSearchAutoComplete);
    this.e.setOnQueryTextListener(new SearchView.c()
    {
      public boolean a(String paramAnonymousString)
      {
        ActionSearchActivity.a(ActionSearchActivity.this, paramAnonymousString);
        return true;
      }
      
      public boolean b(String paramAnonymousString)
      {
        if (paramAnonymousString.length() == 0)
        {
          ActionSearchActivity.a(ActionSearchActivity.this, true);
          if (!h.g(ActionSearchActivity.this))
          {
            h.a(ActionSearchActivity.this, ActionSearchActivity.this.getString(2131296740));
            return true;
          }
          ActionSearchActivity.b(ActionSearchActivity.this).a();
          ActionSearchActivity.c(ActionSearchActivity.this).setText("");
          ActionSearchActivity.b(ActionSearchActivity.this).a(ActionSearchActivity.d(ActionSearchActivity.this));
          if (ActionSearchActivity.d(ActionSearchActivity.this).size() > 0)
          {
            if (ActionSearchActivity.e(ActionSearchActivity.this).getFooterViewsCount() == 0) {
              ActionSearchActivity.e(ActionSearchActivity.this).addFooterView(ActionSearchActivity.f(ActionSearchActivity.this));
            }
            if (ActionSearchActivity.e(ActionSearchActivity.this).getEmptyView() != null) {
              ActionSearchActivity.e(ActionSearchActivity.this).setEmptyView(null);
            }
          }
          ActionSearchActivity.b(ActionSearchActivity.this).notifyDataSetChanged();
          return false;
        }
        ActionSearchActivity.a(ActionSearchActivity.this, false);
        if (!h.g(ActionSearchActivity.this))
        {
          h.a(ActionSearchActivity.this, ActionSearchActivity.this.getString(2131296740));
          return true;
        }
        if (ActionSearchActivity.g(ActionSearchActivity.this).d()) {
          ActionSearchActivity.g(ActionSearchActivity.this).setIconified(false);
        }
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          ActionSearchActivity.b(ActionSearchActivity.this).a(ActionSearchActivity.d(ActionSearchActivity.this));
          ActionSearchActivity.b(ActionSearchActivity.this).notifyDataSetChanged();
          return true;
        }
        ActionSearchActivity.h(ActionSearchActivity.this);
        s.a().a(paramAnonymousString, l.a().i(), new OnGetSuggestionResultListener()
        {
          public void onGetSuggestionResult(SuggestionResult paramAnonymous2SuggestionResult)
          {
            if ((paramAnonymous2SuggestionResult != null) && (paramAnonymous2SuggestionResult.getAllSuggestions() != null) && (paramAnonymous2SuggestionResult.error == ERRORNO.NO_ERROR) && (!ActionSearchActivity.i(ActionSearchActivity.this)))
            {
              paramAnonymous2SuggestionResult = paramAnonymous2SuggestionResult.getAllSuggestions().iterator();
              while (paramAnonymous2SuggestionResult.hasNext())
              {
                localSuggestionInfo = (SuggestionInfo)paramAnonymous2SuggestionResult.next();
                ActionSearchActivity.b(ActionSearchActivity.this).a(localSuggestionInfo.key, localSuggestionInfo.address);
              }
              if (ActionSearchActivity.b(ActionSearchActivity.this).getCount() == 0)
              {
                ActionSearchActivity.c(ActionSearchActivity.this).setText(ActionSearchActivity.this.getString(2131296958));
                ActionSearchActivity.e(ActionSearchActivity.this).setEmptyView(ActionSearchActivity.c(ActionSearchActivity.this));
                ActionSearchActivity.b(ActionSearchActivity.this).notifyDataSetChanged();
              }
            }
            while (paramAnonymous2SuggestionResult.getAllSuggestions() != null) {
              for (;;)
              {
                SuggestionInfo localSuggestionInfo;
                return;
                ActionSearchActivity.e(ActionSearchActivity.this).removeFooterView(ActionSearchActivity.f(ActionSearchActivity.this));
              }
            }
            ActionSearchActivity.c(ActionSearchActivity.this).setText(ActionSearchActivity.this.getString(2131296958));
            ActionSearchActivity.e(ActionSearchActivity.this).setEmptyView(ActionSearchActivity.c(ActionSearchActivity.this));
          }
        });
        return true;
      }
    });
  }
  
  private void l()
  {
    runOnUiThread(c.a(this));
  }
  
  private void m()
  {
    o();
    this.h = ((TextView)findViewById(2131755172));
    this.f = ((ListView)findViewById(2131755171));
    this.f.setEmptyView(this.h);
    this.i = ((TextView)findViewById(2131755159));
    this.g = View.inflate(this, 2130968813, null);
    if (this.a.size() > 0) {
      this.f.addFooterView(this.g);
    }
    if (this.a.size() > 0) {
      this.h.setText(getString(2131296958));
    }
    this.f.setAdapter(this.b);
    this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView = (PoiSearchSugItem)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if ((paramAnonymousView == null) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)) {
          ActionSearchActivity.k(ActionSearchActivity.this);
        }
        if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.keyword))) {
          ActionSearchActivity.a(ActionSearchActivity.this, paramAnonymousView.keyword);
        }
      }
    });
    this.f.setOnTouchListener(d.a(this));
  }
  
  private void n()
  {
    runOnUiThread(e.a(this));
    PoiSearchSugItem.clearPoiSearchHistory(this);
  }
  
  private void o()
  {
    this.a = PoiSearchSugItem.getPoiSearchHistory(this);
    if (this.a == null) {
      this.a = new LinkedList();
    }
    this.b = new n(this);
    this.b.a(this.f);
    this.b.a(this.a);
  }
  
  public void finish()
  {
    h.a(this, this.e);
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 1: 
        f();
        return;
      }
      e();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968604);
    a();
    getSupportActionBar().d(false);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820553, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    s.a().b();
    super.onDestroy();
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
      h.a(this, this.e);
      finish();
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/ActionSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */