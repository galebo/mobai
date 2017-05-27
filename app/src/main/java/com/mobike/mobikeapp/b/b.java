package com.mobike.mobikeapp.b;

import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.RedPacketData;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class b
  implements com.mobike.mobikeapp.b.a.a
{
  com.mobike.mobikeapp.b.a.b a;
  
  public b(com.mobike.mobikeapp.b.a.b paramb)
  {
    this.a = paramb;
  }
  
  public void a()
  {
    f.e(new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        b.this.a.b();
        b.this.a.a(paramAnonymousInt, paramAnonymousString);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        b.this.a.b();
        if (paramAnonymousJSONObject != null)
        {
          paramAnonymousArrayOfd = (RedPacketData)new com.google.gson.e().a(paramAnonymousJSONObject.toString(), RedPacketData.class);
          if (paramAnonymousArrayOfd.getData() != null) {
            b.this.a.a(paramAnonymousArrayOfd.getData());
          }
        }
      }
    });
  }
  
  public void a(int paramInt)
  {
    f.a(paramInt, -2, new com.mobike.mobikeapp.a.e(com.mobike.mobikeapp.model.data.a.class)
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        b.this.a.a(paramAnonymousInt, paramAnonymousString);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, com.mobike.mobikeapp.model.data.a paramAnonymousa)
      {
        b.this.a.a(paramAnonymousa);
      }
      
      public void g()
      {
        b.this.a.a();
      }
      
      public void h()
      {
        b.this.a.b();
      }
    });
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */