package com.mobike.mobikeapp.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.ab;
import android.text.TextUtils;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ac;
import com.loopj.android.http.c;
import com.loopj.android.http.n;
import com.loopj.android.http.t;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.activity.pay.WalletActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager.PayType;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.m;
import com.mobike.mobikeapp.util.q;
import cz.msebera.android.httpclient.conn.ssl.b;
import cz.msebera.android.httpclient.conn.ssl.i;
import cz.msebera.android.httpclient.d;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Locale;
import org.json.JSONObject;

public class g
{
  private static final String a = "M@bike768";
  private static com.loopj.android.http.a b = null;
  private static com.loopj.android.http.a c = null;
  private static ac d = null;
  private static ac e = null;
  
  public static void a(Context paramContext)
  {
    if (a.d) {
      if (c != null) {
        c.a(paramContext, true);
      }
    }
    while (b == null) {
      return;
    }
    b.a(paramContext, true);
  }
  
  private static void a(@ab com.loopj.android.http.a parama)
  {
    parama.e(20000);
    if (a.d) {}
    try
    {
      InputStream localInputStream = MyApplication.c.getAssets().open("cert/newMobike.bks");
      Object localObject = KeyStore.getInstance("BKS");
      ((KeyStore)localObject).load(localInputStream, "M@bike768".toCharArray());
      localObject = new t((KeyStore)localObject);
      ((t)localObject).a(new b());
      parama.a((i)localObject);
      localInputStream.close();
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  public static void a(String paramString, RequestParams paramRequestParams, c paramc)
  {
    m.a("url :" + paramString + "/n " + paramRequestParams.toString());
    if (a.d) {
      if (c == null)
      {
        c = new com.loopj.android.http.a();
        a(c);
      }
    }
    for (com.loopj.android.http.a locala = c;; locala = b)
    {
      b(locala);
      locala.c(a.a(paramString), paramRequestParams, paramc);
      return;
      if (b == null)
      {
        b = new com.loopj.android.http.a();
        a(b);
      }
    }
  }
  
  public static void a(String paramString, RequestParams paramRequestParams, com.mobike.mobikeapp.model.b.a parama)
  {
    if (a.d) {
      if (c == null)
      {
        c = new com.loopj.android.http.a();
        a(c);
      }
    }
    for (com.loopj.android.http.a locala = c;; locala = b)
    {
      b(locala);
      locala.c(a.a(paramString), paramRequestParams, new n()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          paramAnonymousArrayOfd = MyApplication.c;
          m.a("responseString =  " + paramAnonymousString + " throwable = " + paramAnonymousThrowable.getMessage());
          paramAnonymousString = this.k;
          if (paramAnonymousInt == 200) {}
          for (paramAnonymousArrayOfd = paramAnonymousArrayOfd.getResources().getString(2131296740);; paramAnonymousArrayOfd = paramAnonymousArrayOfd.getResources().getString(2131296965))
          {
            paramAnonymousString.a(paramAnonymousInt, paramAnonymousArrayOfd);
            return;
          }
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject.optInt("code") == 0)
          {
            this.k.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousJSONObject);
            return;
          }
          g.a(paramAnonymousJSONObject.optInt("code"), this.k, paramAnonymousJSONObject.optString("message"));
        }
      });
      return;
      if (b == null)
      {
        b = new com.loopj.android.http.a();
        a(b);
      }
    }
  }
  
  private static void b(int paramInt, com.mobike.mobikeapp.model.b.a parama, String paramString)
  {
    Context localContext = MyApplication.c;
    switch (paramInt)
    {
    default: 
      parama.a(paramInt, paramString);
      return;
    case 100: 
    case 101: 
      com.mobike.mobikeapp.util.a.a(localContext, AccountManager.PayType.DEPOSIT);
      parama.a(paramInt, localContext.getString(2131296749));
      return;
    case 102: 
      h.a(localContext, WalletActivity.class);
      if (!TextUtils.isEmpty(paramString))
      {
        parama.a(paramInt, paramString);
        return;
      }
      parama.a(paramInt, localContext.getString(2131296750));
      return;
    case 104: 
    case 105: 
      if (!TextUtils.isEmpty(paramString))
      {
        parama.a(paramInt, paramString);
        return;
      }
      parama.a(paramInt, localContext.getString(2131296436));
      return;
    case 103: 
    case 111: 
    case 500: 
      if (!TextUtils.isEmpty(paramString))
      {
        parama.a(paramInt, paramString);
        return;
      }
      parama.a(paramInt, localContext.getString(2131296430));
      return;
    case 108: 
    case 150: 
      parama.a(paramInt, localContext.getString(2131296421));
      return;
    case 120: 
    case 200: 
      parama.a(paramInt, paramString);
      return;
    case 135: 
      parama.a(paramInt, localContext.getString(2131296433));
      return;
    case 250: 
      q.a().g(localContext);
      paramString = new Intent(localContext, LoginActivity.class);
      paramString.setFlags(268435456);
      localContext.startActivity(paramString);
      com.mobike.mobikeapp.util.a.e(localContext);
      parama.a(paramInt, "");
      return;
    }
    parama.a(paramInt, paramString);
  }
  
  private static void b(com.loopj.android.http.a parama)
  {
    String str1 = q.a().e();
    long l = System.currentTimeMillis();
    String str2 = h.a(str1, l);
    parama.k();
    parama.a("mobileNo", str1);
    parama.a("time", String.valueOf(l));
    parama.a("eption", str2);
    parama.a("citycode", l.a().e());
    parama.a("version", com.mobike.mobikeapp.util.a.b());
    parama.a("platform", "1");
    parama.a("accesstoken", q.a().c());
    parama.a("uuid", q.a().a(MyApplication.c));
    parama.a("os", String.valueOf(Build.VERSION.SDK_INT));
    parama.a("lang", Locale.getDefault().getLanguage());
  }
  
  public static void b(String paramString, RequestParams paramRequestParams, c paramc)
  {
    if (TextUtils.indexOf(paramString, "https://") > -1) {
      if (c == null)
      {
        c = new com.loopj.android.http.a();
        a(c);
      }
    }
    for (com.loopj.android.http.a locala = c;; locala = b)
    {
      locala.b(paramString, paramRequestParams, paramc);
      return;
      if (b == null)
      {
        b = new com.loopj.android.http.a();
        a(b);
      }
    }
  }
  
  public static void c(String paramString, RequestParams paramRequestParams, c paramc)
  {
    if (a.d) {
      if (e == null)
      {
        e = new ac();
        a(e);
      }
    }
    for (ac localac = e;; localac = d)
    {
      b(localac);
      localac.c(a.a(paramString), paramRequestParams, paramc);
      return;
      if (d == null)
      {
        d = new ac();
        a(d);
      }
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */