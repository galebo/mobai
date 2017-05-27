package com.mobike.mobikeapp;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ac;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.b.a;
import com.umeng.analytics.MobclickAgent;

public class BaseActivity<T extends a>
  extends AppCompatActivity
{
  private TextView a;
  private ImageView b;
  public T c;
  protected View d;
  
  public T g()
  {
    return null;
  }
  
  void h()
  {
    View localView = findViewById(2131755169);
    if (localView != null)
    {
      this.d = localView;
      setSupportActionBar((Toolbar)localView);
      getSupportActionBar().k(2130838311);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (!j()) {
          break label111;
        }
        getWindow().getDecorView().setSystemUiVisibility(1280);
      }
    }
    for (;;)
    {
      this.a = ((TextView)localView.findViewById(2131755280));
      if (this.a != null)
      {
        getSupportActionBar().d(false);
        getSupportActionBar().c(true);
      }
      this.b = ((ImageView)localView.findViewById(2131755281));
      return;
      label111:
      getWindow().setStatusBarColor(ContextCompat.getColor(this, 2131624128));
    }
  }
  
  public int i()
  {
    int i = 0;
    int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  protected boolean j()
  {
    return true;
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = g();
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
  
  protected void onPause()
  {
    super.onPause();
    MobclickAgent.a(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    MobclickAgent.b(this);
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    if (this.a != null) {
      this.a.setText(paramCharSequence);
    }
    if ((this.b != null) && (TextUtils.isEmpty(paramCharSequence)))
    {
      this.b.setVisibility(0);
      this.b.setImageResource(2130837977);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    h();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */