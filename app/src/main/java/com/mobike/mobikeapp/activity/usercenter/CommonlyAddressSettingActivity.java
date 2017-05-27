package com.mobike.mobikeapp.activity.usercenter;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.middleware.map.LatLng;
import com.baidu.middleware.search.ERRORNO;
import com.baidu.middleware.search.OnGetPoiSearchResultListener;
import com.baidu.middleware.search.PoiInfo;
import com.baidu.middleware.search.PoiResult;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.adapter.n;
import com.mobike.mobikeapp.data.PoiSearchSugItem;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.model.data.CommonlyAddress;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.s;
import cz.msebera.android.httpclient.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class CommonlyAddressSettingActivity
  extends BaseActivity
{
  private LinkedList<PoiSearchSugItem> a = null;
  private n b;
  private SearchView e;
  private ListView f;
  private TextView g;
  private int h;
  private Set<String> i;
  
  private void a()
  {
    b();
    c();
    this.i = com.mobike.mobikeapp.model.c.f.a().l();
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
  
  private void a(final PoiSearchSugItem paramPoiSearchSugItem)
  {
    com.mobike.mobikeapp.a.f.a(paramPoiSearchSugItem.keyword, paramPoiSearchSugItem.address, this.h, paramPoiSearchSugItem.mLocation.latitude, paramPoiSearchSugItem.mLocation.longitude, new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this) == null) {
          CommonlyAddressSettingActivity.a(CommonlyAddressSettingActivity.this, new HashSet());
        }
        if (!CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this).contains(String.valueOf(CommonlyAddressSettingActivity.g(CommonlyAddressSettingActivity.this))))
        {
          CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this).add(String.valueOf(CommonlyAddressSettingActivity.g(CommonlyAddressSettingActivity.this)));
          com.mobike.mobikeapp.model.c.f.a().b(CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this));
        }
        CommonlyAddressSettingActivity.b(CommonlyAddressSettingActivity.this, paramPoiSearchSugItem);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if ((CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this) != null) && (CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this).contains(String.valueOf(CommonlyAddressSettingActivity.g(CommonlyAddressSettingActivity.this)))))
        {
          CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this).remove(String.valueOf(paramPoiSearchSugItem.address));
          com.mobike.mobikeapp.model.c.f.a().b(CommonlyAddressSettingActivity.f(CommonlyAddressSettingActivity.this));
        }
        CommonlyAddressSettingActivity.b(CommonlyAddressSettingActivity.this, paramPoiSearchSugItem);
      }
    });
  }
  
  private void a(final String paramString1, String paramString2, final String paramString3)
  {
    if (!h.g(this)) {
      h.a(this, 2131296740);
    }
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    h.a(this, this.f);
    s.a().a(paramString1, l.a().i(), new OnGetPoiSearchResultListener()
    {
      public void onGetPoiResult(PoiResult paramAnonymousPoiResult)
      {
        if ((paramAnonymousPoiResult == null) || (paramAnonymousPoiResult.error != ERRORNO.NO_ERROR))
        {
          h.a(CommonlyAddressSettingActivity.this, CommonlyAddressSettingActivity.this.getString(2131296958));
          return;
        }
        paramAnonymousPoiResult = paramAnonymousPoiResult.getAllPoi();
        if ((paramAnonymousPoiResult != null) && (!paramAnonymousPoiResult.isEmpty()))
        {
          paramAnonymousPoiResult = (PoiInfo)paramAnonymousPoiResult.get(0);
          CommonlyAddressSettingActivity.a(CommonlyAddressSettingActivity.this, new PoiSearchSugItem(paramAnonymousPoiResult.getLocation(), paramString3, paramString1));
          return;
        }
        h.a(CommonlyAddressSettingActivity.this, CommonlyAddressSettingActivity.this.getString(2131296958));
      }
    });
  }
  
  private void b()
  {
    this.e = ((SearchView)findViewById(2131755170));
    this.e.setIconified(false);
    this.e.setIconifiedByDefault(true);
    this.e.setQueryHint(getString(2131296956));
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
        h.a(CommonlyAddressSettingActivity.a(CommonlyAddressSettingActivity.this).getContext(), CommonlyAddressSettingActivity.a(CommonlyAddressSettingActivity.this));
        if (paramAnonymousString.length() == 0) {
          return false;
        }
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).a(CommonlyAddressSettingActivity.b(CommonlyAddressSettingActivity.this));
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).notifyDataSetChanged();
        }
        for (;;)
        {
          return true;
          s.a().a(paramAnonymousString, l.a().i(), a.a(this));
        }
      }
      
      public boolean b(String paramAnonymousString)
      {
        if (paramAnonymousString.length() == 0)
        {
          if (!h.g(CommonlyAddressSettingActivity.this))
          {
            h.a(CommonlyAddressSettingActivity.this, CommonlyAddressSettingActivity.this.getString(2131296740));
            return true;
          }
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).a();
          CommonlyAddressSettingActivity.d(CommonlyAddressSettingActivity.this).setText("");
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).a(CommonlyAddressSettingActivity.b(CommonlyAddressSettingActivity.this));
          if (CommonlyAddressSettingActivity.b(CommonlyAddressSettingActivity.this).size() > 0) {
            CommonlyAddressSettingActivity.e(CommonlyAddressSettingActivity.this).setEmptyView(null);
          }
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).notifyDataSetChanged();
          return false;
        }
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).a(CommonlyAddressSettingActivity.b(CommonlyAddressSettingActivity.this));
          CommonlyAddressSettingActivity.c(CommonlyAddressSettingActivity.this).notifyDataSetChanged();
          return true;
        }
        s.a().a(paramAnonymousString, l.a().i(), b.a(this));
        return true;
      }
    });
  }
  
  private void b(PoiSearchSugItem paramPoiSearchSugItem)
  {
    paramPoiSearchSugItem = new CommonlyAddress(paramPoiSearchSugItem.mLocation.latitude, paramPoiSearchSugItem.mLocation.longitude, paramPoiSearchSugItem.address, this.h, paramPoiSearchSugItem.keyword);
    com.mobike.mobikeapp.model.c.f.a().a(paramPoiSearchSugItem);
    setResult(-1);
    finish();
  }
  
  private void c()
  {
    d();
    this.g = ((TextView)findViewById(2131755172));
    this.f = ((ListView)findViewById(2131755171));
    this.f.setEmptyView(this.g);
    if (this.a.size() > 0) {
      this.g.setText(getString(2131296958));
    }
    this.f.setAdapter(this.b);
    this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (PoiSearchSugItem)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          if (paramAnonymousAdapterView.mLocation != null) {
            CommonlyAddressSettingActivity.a(CommonlyAddressSettingActivity.this, paramAnonymousAdapterView);
          }
        }
        else {
          return;
        }
        CommonlyAddressSettingActivity.a(CommonlyAddressSettingActivity.this, paramAnonymousAdapterView.keyword, null, paramAnonymousAdapterView.address);
      }
    });
    this.f.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        h.a(CommonlyAddressSettingActivity.this, CommonlyAddressSettingActivity.e(CommonlyAddressSettingActivity.this));
        return false;
      }
    });
  }
  
  private void d()
  {
    this.a = PoiSearchSugItem.getPoiSearchHistory(this);
    if (this.a == null) {
      this.a = new LinkedList();
    }
    this.b = new n(this);
    this.b.a(this.f);
    this.b.a(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968608);
    this.h = getIntent().getIntExtra("position", 0);
    a();
    getSupportActionBar().d(false);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820553, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
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


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/CommonlyAddressSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */