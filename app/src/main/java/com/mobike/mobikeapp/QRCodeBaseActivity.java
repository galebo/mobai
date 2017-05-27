package com.mobike.mobikeapp;

import android.os.Bundle;

public class QRCodeBaseActivity
  extends BaseActivity
{
  protected boolean e = false;
  protected boolean f = false;
  protected boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  
  protected void k()
  {
    this.g = false;
    this.f = false;
    this.h = false;
    this.i = false;
    this.j = false;
  }
  
  protected void l()
  {
    finish();
    overridePendingTransition(17432576, 17432577);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e = false;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/QRCodeBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */