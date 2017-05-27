package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.util.Pair;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.model.a;
import com.mobike.mobikeapp.model.c.f;
import java.util.ArrayList;
import java.util.List;

public class j
  extends a
{
  private Intent f;
  private String g;
  private String h;
  private String i;
  
  public j(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext);
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    a(paramContext);
    b(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Integer.valueOf(2131755506), k.a(this, paramContext)));
    localArrayList.add(new Pair(Integer.valueOf(2131755507), l.a(this, paramContext)));
    localArrayList.add(new Pair(Integer.valueOf(2131755508), m.a(this)));
    e(2130968694);
    f(250);
    a(localArrayList);
    setCanceledOnTouchOutside(false);
  }
  
  private void b(Context paramContext)
  {
    paramContext = "market://details?id=" + paramContext.getPackageName();
    this.f = new Intent("android.intent.action.VIEW");
    this.f.setData(Uri.parse(paramContext));
  }
  
  public void show()
  {
    List localList = getContext().getPackageManager().queryIntentActivities(this.f, 0);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    f.a().f(MyApplication.b);
    super.show();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */