package com.mobike.mobikeapp.util;

import java.util.ArrayList;
import java.util.List;

public class w
{
  private static w b = new w();
  private List<a> a;
  
  public static w a()
  {
    return b;
  }
  
  public void a(a parama)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(parama);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      int j = this.a.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.a.get(i)).a(paramString1, paramString2);
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */