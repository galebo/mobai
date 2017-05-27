package com.mobike.mobikeapp.bridge;

import android.support.annotation.ab;
import android.support.annotation.ac;

public class g
{
  String a;
  String b;
  String c;
  
  public static g a(@ab String paramString)
  {
    g localg = new g();
    localg.a = paramString;
    localg.b = null;
    localg.c = null;
    return localg;
  }
  
  public static g a(@ab String paramString1, @ac String paramString2)
  {
    g localg = new g();
    localg.a = paramString1;
    localg.b = paramString2;
    localg.c = null;
    return localg;
  }
  
  public static g a(@ab String paramString1, @ac String paramString2, @ac String paramString3)
  {
    g localg = new g();
    localg.a = paramString1;
    localg.b = paramString2;
    localg.c = paramString3;
    return localg;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/bridge/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */