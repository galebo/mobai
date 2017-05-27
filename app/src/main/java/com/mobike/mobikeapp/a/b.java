package com.mobike.mobikeapp.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.a;
import com.mobike.mobikeapp.util.q;
import org.json.JSONObject;

public class b
{
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    String str;
    do
    {
      return;
      str = com.mobike.mobikeapp.model.c.f.a().r();
    } while ((!q.a().b()) || ((!TextUtils.isEmpty(str)) && (str.startsWith(q.a().d())) && (str.contains(paramString))));
    new Handler(Looper.getMainLooper()).post(c.a(paramContext, paramString));
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      q.a().c(paramString);
      str = a.g(paramContext);
    } while ((TextUtils.isEmpty(str)) || (!h.g(paramContext)));
    new Handler(Looper.myLooper()).post(d.a(str, paramString, paramContext));
  }
  
  private static void d(Context paramContext, String paramString)
  {
    final String str2 = h.u(paramContext);
    final String str3 = h.w(paramContext);
    String str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str1;
    if (TextUtils.isEmpty(str1)) {
      paramContext = "";
    }
    f.b(paramString, str2, str3, paramContext, new n()
    {
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject) {}
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousJSONObject.optInt("code") == 0) {
          com.mobike.mobikeapp.model.c.f.a().c(q.a().d() + "#" + this.k + "#" + str2 + "#" + str3);
        }
      }
    });
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */