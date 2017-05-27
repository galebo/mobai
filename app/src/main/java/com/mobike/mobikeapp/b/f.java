package com.mobike.mobikeapp.b;

import com.loopj.android.http.n;
import com.mobike.mobikeapp.b.a.g;
import com.mobike.mobikeapp.b.a.h;
import com.mobike.mobikeapp.util.q;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class f
  implements h
{
  private g a;
  
  public f(g paramg)
  {
    this.a = paramg;
  }
  
  public void a()
  {
    com.mobike.mobikeapp.a.f.a(q.a().e(), 1, new n()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousString, paramAnonymousThrowable);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousJSONObject);
        if ((paramAnonymousJSONObject != null) && (paramAnonymousJSONObject.optInt("code", -1) == 0)) {
          f.a(f.this).a();
        }
      }
    });
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    com.mobike.mobikeapp.a.f.b(paramString1, paramString2, paramString3, new n()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousThrowable, paramAnonymousJSONObject);
        f.a(f.this).b("");
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousJSONObject != null)
        {
          if (paramAnonymousJSONObject.optInt("code", -1) == 0) {
            f.a(f.this).a(paramAnonymousJSONObject.optString("message"));
          }
        }
        else {
          return;
        }
        f.a(f.this).b(paramAnonymousJSONObject.optString("message"));
      }
    });
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */