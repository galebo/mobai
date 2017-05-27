package com.mobike.mobikeapp.b;

import com.google.gson.b.a;
import com.google.gson.e;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.PocketDataInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  implements com.mobike.mobikeapp.b.a.d
{
  private com.mobike.mobikeapp.b.a.c a;
  private long b = 0L;
  
  public c(com.mobike.mobikeapp.b.a.c paramc)
  {
    this.a = paramc;
  }
  
  private void a(final boolean paramBoolean)
  {
    f.a(this.b, new n()
    {
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.a(paramAnonymousInt, paramAnonymousArrayOfd, paramAnonymousString, paramAnonymousThrowable);
        c.b(c.this).a(null);
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousJSONObject != null)
        {
          paramAnonymousArrayOfd = paramAnonymousJSONObject.optJSONObject("data");
          if (paramAnonymousArrayOfd == null) {
            break label123;
          }
          paramAnonymousJSONObject = (ArrayList)new e().a(paramAnonymousArrayOfd.optJSONArray("data").toString(), new a() {}.b());
          c.a(c.this, paramAnonymousArrayOfd.optLong("lastTimes", 0L));
          if (c.a(c.this) < 0L) {
            c.b(c.this).b();
          }
          if (paramBoolean) {
            c.b(c.this).b(paramAnonymousJSONObject);
          }
        }
        else
        {
          return;
        }
        c.b(c.this).a(paramAnonymousJSONObject);
        return;
        label123:
        c.b(c.this).b();
      }
    });
  }
  
  public void a()
  {
    a(false);
  }
  
  public void b()
  {
    this.b = 0L;
    a(true);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */