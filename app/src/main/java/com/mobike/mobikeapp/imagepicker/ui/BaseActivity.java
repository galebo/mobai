package com.mobike.mobikeapp.imagepicker.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.mobike.mobikeapp.imagepicker.R.color;
import com.mobike.mobikeapp.imagepicker.view.a;

public class BaseActivity
  extends AppCompatActivity
{
  protected a a;
  
  @TargetApi(19)
  private void a(boolean paramBoolean)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramBoolean) {}
    for (localLayoutParams.flags |= 0x4000000;; localLayoutParams.flags &= 0xFBFFFFFF)
    {
      localWindow.setAttributes(localLayoutParams);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 19) {
      a(true);
    }
    this.a = new a(this);
    this.a.a(true);
    this.a.d(R.color.status_bar);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/ui/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */