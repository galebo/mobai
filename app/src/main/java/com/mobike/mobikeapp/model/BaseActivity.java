package com.mobike.mobikeapp.model;

import android.content.Intent;
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
import com.umeng.analytics.MobclickAgent;

public class BaseActivity
  extends AppCompatActivity
{
  private TextView toolbarTitle;
  private ImageView toolbarTitleImg;
  
  public int getStatusBarHeight()
  {
    int i = 0;
    int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  void initToolbar()
  {
    View localView = findViewById(R.id.toolbar);
    if (localView != null)
    {
      setSupportActionBar((Toolbar)localView);
      getSupportActionBar().k(R.drawable.up_arrow_style);
      setStatusBar();
      this.toolbarTitle = ((TextView)localView.findViewById(R.id.toolbar_title_text));
      if (this.toolbarTitle != null)
      {
        getSupportActionBar().d(false);
        getSupportActionBar().c(true);
      }
      this.toolbarTitleImg = ((ImageView)localView.findViewById(R.id.toolbar_title_image));
    }
  }
  
  protected boolean isSetStateTranslate()
  {
    return true;
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!isTaskRoot())
    {
      paramBundle = getIntent();
      String str = paramBundle.getAction();
      if ((paramBundle.hasCategory("android.intent.category.LAUNCHER")) && (str.equals("android.intent.action.MAIN"))) {
        finish();
      }
    }
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
    if (this.toolbarTitle != null) {
      this.toolbarTitle.setText(paramCharSequence);
    }
    if ((this.toolbarTitleImg != null) && (TextUtils.isEmpty(paramCharSequence)))
    {
      this.toolbarTitleImg.setVisibility(0);
      this.toolbarTitleImg.setImageResource(R.drawable.mobike_title_img);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    initToolbar();
  }
  
  protected void setStatusBar()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (isSetStateTranslate()) {
        getWindow().getDecorView().setSystemUiVisibility(1280);
      }
    }
    else {
      return;
    }
    getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.sub_app_color));
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/model/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */