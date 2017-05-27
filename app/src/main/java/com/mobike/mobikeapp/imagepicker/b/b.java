package com.mobike.mobikeapp.imagepicker.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.support.annotation.ak;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mobike.mobikeapp.imagepicker.R.id;
import com.mobike.mobikeapp.imagepicker.R.layout;
import java.lang.reflect.Field;

public class b
{
  public static int a(Activity paramActivity)
  {
    int i = 3;
    int k = paramActivity.getResources().getDisplayMetrics().widthPixels;
    int j = k / paramActivity.getResources().getDisplayMetrics().densityDpi;
    if (j < 3) {}
    for (;;)
    {
      return (k - (int)(2.0F * paramActivity.getResources().getDisplayMetrics().density) * (i - 1)) / i;
      i = j;
    }
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static void a(Context paramContext, @ak int paramInt)
  {
    a(paramContext, paramContext.getString(paramInt));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Toast localToast;
    if (paramContext != null)
    {
      localToast = new Toast(paramContext);
      paramContext = View.inflate(paramContext, R.layout.layout_toast, null);
      ((TextView)paramContext.findViewById(R.id.toast)).setText(paramString);
      localToast.setDuration(0);
      localToast.setView(paramContext);
      if (!(localToast instanceof Toast)) {
        localToast.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static DisplayMetrics b(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */