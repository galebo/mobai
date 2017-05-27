package com.mobike.mobikeapp.util;

import com.qiniu.android.b.g;
import com.qiniu.android.b.j;
import com.qiniu.android.b.k;
import java.io.File;

public class d
{
  private static d a = new d();
  private j b = null;
  
  public static d a()
  {
    return a;
  }
  
  public void a(File paramFile, String paramString1, String paramString2, g paramg)
  {
    this.b.a(paramFile, paramString1, paramString2, paramg, null);
  }
  
  public void a(File paramFile, String paramString1, String paramString2, g paramg, k paramk)
  {
    this.b.a(paramFile, paramString1, paramString2, paramg, paramk);
  }
  
  public void a(String paramString) {}
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, g paramg)
  {
    this.b.a(paramArrayOfByte, paramString1, paramString2, paramg, null);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */