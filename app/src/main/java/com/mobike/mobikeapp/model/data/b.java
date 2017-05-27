package com.mobike.mobikeapp.model.data;

import android.content.Intent;
import android.support.annotation.ac;
import android.support.annotation.ak;
import android.support.annotation.p;

public class b
{
  private int a;
  private int b;
  private Intent c;
  private boolean d;
  
  @p
  public int a()
  {
    return this.a;
  }
  
  public Intent b()
  {
    return this.c;
  }
  
  @ak
  public int c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public static class a
  {
    private b a = new b(null);
    
    public a a()
    {
      b.a(this.a, true);
      return this;
    }
    
    public a a(@p int paramInt)
    {
      b.a(this.a, paramInt);
      return this;
    }
    
    public a a(@ac Intent paramIntent)
    {
      b.a(this.a, paramIntent);
      return this;
    }
    
    public a b()
    {
      b.a(this.a, false);
      return this;
    }
    
    public a b(@ak int paramInt)
    {
      b.b(this.a, paramInt);
      return this;
    }
    
    public b c()
    {
      return this.a;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/model/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */