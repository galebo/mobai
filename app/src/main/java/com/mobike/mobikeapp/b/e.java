package com.mobike.mobikeapp.b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.middleware.map.LatLng;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.b.a.i;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import cz.msebera.android.httpclient.d;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements i
{
  private com.mobike.mobikeapp.b.a.f a = null;
  private UMShareAPI b;
  private String c;
  
  public e(com.mobike.mobikeapp.b.a.f paramf)
  {
    this.a = paramf;
    this.b = UMShareAPI.get((Activity)paramf);
  }
  
  public Map<String, String> a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    this.b.getPlatformInfo((Activity)this.a, paramSHARE_MEDIA, new a(null));
    return null;
  }
  
  public void a()
  {
    this.b.release();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  private class a
    implements UMAuthListener
  {
    private a() {}
    
    public void onCancel(SHARE_MEDIA paramSHARE_MEDIA, int paramInt)
    {
      e.a(e.this).e();
    }
    
    public void onComplete(SHARE_MEDIA paramSHARE_MEDIA, int paramInt, final Map<String, String> paramMap)
    {
      String str;
      if (SHARE_MEDIA.WEIXIN == paramSHARE_MEDIA)
      {
        paramMap.put("source", "WX_APP");
        if (paramSHARE_MEDIA != SHARE_MEDIA.WEIXIN) {
          break label190;
        }
        str = (String)paramMap.get("unionid");
        label38:
        if (!paramSHARE_MEDIA.toString().equals(SHARE_MEDIA.WEIXIN.toString())) {
          break label206;
        }
      }
      label190:
      label206:
      for (paramSHARE_MEDIA = "WX_APP";; paramSHARE_MEDIA = "QQ")
      {
        com.mobike.mobikeapp.a.f.a(str, paramSHARE_MEDIA, (String)paramMap.get("openid"), (String)paramMap.get("profile_image_url"), (String)paramMap.get("screen_name"), l.a().h().latitude, l.a().h().longitude, (String)paramMap.get("expires_in"), new ad()
        {
          public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
          {
            try
            {
              paramAnonymousArrayOfd = new JSONObject(paramAnonymousString);
              paramAnonymousString = paramAnonymousArrayOfd.optJSONObject("object");
              if (paramAnonymousString != null)
              {
                paramAnonymousString = paramAnonymousString.optJSONArray("thirdPartInfo");
                if (paramAnonymousString != null) {
                  q.a().c((Activity)e.a(e.this), paramAnonymousString.toString());
                }
              }
              if (paramAnonymousArrayOfd.optInt("code") == 0) {
                e.a(e.this).a(paramMap);
              }
              return;
            }
            catch (JSONException paramAnonymousArrayOfd) {}
          }
          
          public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
          
          public void h()
          {
            e.a(e.this).e();
          }
        });
        return;
        if (SHARE_MEDIA.QQ != paramSHARE_MEDIA) {
          break;
        }
        paramMap.put("source", "QQ");
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("unionid"))) {
          break;
        }
        paramMap.put("unionid", paramMap.get("openid"));
        break;
        str = (String)paramMap.get("openid");
        break label38;
      }
    }
    
    public void onError(SHARE_MEDIA paramSHARE_MEDIA, int paramInt, Throwable paramThrowable)
    {
      e.a(e.this).f();
      e.a(e.this).e();
    }
    
    public void onStart(SHARE_MEDIA paramSHARE_MEDIA)
    {
      e.a(e.this).d();
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */