package com.mobike.mobikeapp.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.activity.pay.WalletActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager.PayType;
import com.mobike.mobikeapp.util.q;
import cz.msebera.android.httpclient.d;

public class e<T extends com.mobike.mobikeapp.model.data.a>
  extends ad
{
  private Class<T> k;
  com.google.gson.e l;
  T m = null;
  
  public e(Class paramClass)
  {
    super("UTF-8");
    this.k = paramClass;
    this.l = new com.google.gson.e();
  }
  
  public e(String paramString)
  {
    super(paramString);
  }
  
  private void a(com.mobike.mobikeapp.model.data.a parama, T paramT, int paramInt)
  {
    if (MyApplication.c == null) {
      return;
    }
    switch (parama.result)
    {
    default: 
      a(paramInt, parama.message);
      return;
    case 0: 
      a(paramInt, null, paramT);
      return;
    case 100: 
    case 101: 
      com.mobike.mobikeapp.util.a.a(MyApplication.c, AccountManager.PayType.DEPOSIT);
      a(paramInt, MyApplication.c.getString(2131296749));
      return;
    case 102: 
      h.a(MyApplication.c, WalletActivity.class);
      if (!TextUtils.isEmpty(parama.message))
      {
        a(paramInt, parama.message);
        return;
      }
      a(paramInt, MyApplication.c.getString(2131296750));
      return;
    case 104: 
    case 105: 
      if (!TextUtils.isEmpty(parama.message))
      {
        a(paramInt, parama.message);
        return;
      }
      a(paramInt, MyApplication.c.getString(2131296436));
      return;
    case 103: 
    case 111: 
    case 500: 
      if (!TextUtils.isEmpty(parama.message))
      {
        a(paramInt, parama.message);
        return;
      }
      a(paramInt, MyApplication.c.getString(2131296430));
      return;
    case 108: 
    case 150: 
      a(paramInt, MyApplication.c.getString(2131296421));
      return;
    case 120: 
    case 200: 
      a(paramInt, parama.message);
      return;
    case 135: 
      a(paramInt, MyApplication.c.getString(2131296433));
      return;
    case 250: 
      q.a().g(MyApplication.c);
      paramT = new Intent(MyApplication.c, LoginActivity.class);
      paramT.setFlags(268435456);
      MyApplication.c.startActivity(paramT);
      com.mobike.mobikeapp.util.a.e(MyApplication.c.getApplicationContext());
      a(paramInt, parama.message);
      return;
    }
    a(paramInt, parama.message);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, d[] paramArrayOfd, T paramT) {}
  
  public void a(final int paramInt, final d[] paramArrayOfd, final String paramString)
  {
    if (paramInt != 204)
    {
      paramArrayOfd = new Runnable()
      {
        public void run()
        {
          e.b(e.this, new Runnable()
          {
            public void run()
            {
              if (TextUtils.isEmpty(e.2.this.a))
              {
                e.this.a(e.2.this.b, e.2.this.c, e.this.m);
                return;
              }
              e locale;
              int i;
              try
              {
                e.this.m = ((com.mobike.mobikeapp.model.data.a)e.this.l.a(e.2.this.a, e.a(e.this)));
                com.mobike.mobikeapp.model.data.a locala = e.this.m;
                e.a(e.this, locala, e.this.m, e.2.this.b);
                return;
              }
              catch (JsonSyntaxException localJsonSyntaxException)
              {
                locale = e.this;
                i = e.2.this.b;
                if (!TextUtils.isEmpty(localJsonSyntaxException.getMessage())) {}
              }
              for (String str = "";; str = str.getMessage())
              {
                locale.a(i, str);
                return;
              }
            }
          });
        }
      };
      if (!d())
      {
        new Thread(paramArrayOfd).start();
        return;
      }
      paramArrayOfd.run();
      return;
    }
    a(paramInt, paramArrayOfd, this.m);
  }
  
  public void a(final int paramInt, d[] paramArrayOfd, final String paramString, Throwable paramThrowable)
  {
    paramArrayOfd = new Runnable()
    {
      public void run()
      {
        e.a(e.this, new Runnable()
        {
          public void run()
          {
            if ((e.1.this.a >= 400) && (e.1.this.a < 500))
            {
              e.this.a(e.1.this.a, e.1.this.b + "请求错误");
              return;
            }
            if ((e.1.this.a >= 300) && (e.1.this.a < 400))
            {
              e.this.a(e.1.this.a, e.1.this.b + "重定向");
              return;
            }
            e.this.a(e.1.this.a, e.1.this.b + "服务器错误");
          }
        });
      }
    };
    if (d())
    {
      paramArrayOfd.run();
      return;
    }
    new Thread(paramArrayOfd).start();
  }
  
  public void a(int paramInt, d[] paramArrayOfd, Throwable paramThrowable, T paramT) {}
  
  protected void l()
  {
    this.m = null;
    this.l = null;
    this.k = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */