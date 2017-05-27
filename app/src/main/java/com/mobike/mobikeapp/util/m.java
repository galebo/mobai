package com.mobike.mobikeapp.util;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.e;
import com.orhanobut.logger.i;

public class m
{
  static
  {
    e.a("MOBIKE").a(LogLevel.NONE);
  }
  
  public static void a(Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      e.a(paramObject);
      return;
    }
    e.a("类型错误");
  }
  
  public static void a(String paramString)
  {
    e.b(paramString, new Object[0]);
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    e.a(paramThrowable, paramString, new Object[0]);
  }
  
  public static void b(String paramString)
  {
    e.a(paramString);
  }
  
  public static void c(String paramString)
  {
    e.e(paramString, new Object[0]);
  }
  
  public static void d(String paramString)
  {
    e.c(paramString);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */