package com.mobike.mobikeapp.b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.middleware.map.LatLng;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.b.a.e;
import com.mobike.mobikeapp.b.a.i;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements i
{
  private e a = null;
  private UMShareAPI b;
  private String c;
  
  public d(e parame)
  {
    this.a = parame;
    this.b = UMShareAPI.get((Activity)parame);
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
      d.a(d.this).d();
    }
    
    public void onComplete(SHARE_MEDIA paramSHARE_MEDIA, int paramInt, final Map<String, String> paramMap)
    {
      d.a(d.this).d();
      String str;
      if (SHARE_MEDIA.WEIXIN == paramSHARE_MEDIA)
      {
        paramMap.put("source", "WX_APP");
        if (paramSHARE_MEDIA != SHARE_MEDIA.WEIXIN) {
          break label202;
        }
        str = (String)paramMap.get("unionid");
        label50:
        if (!paramSHARE_MEDIA.toString().equals(SHARE_MEDIA.WEIXIN.toString())) {
          break label218;
        }
      }
      label202:
      label218:
      for (paramSHARE_MEDIA = "WX_APP";; paramSHARE_MEDIA = "QQ")
      {
        f.a(str, paramSHARE_MEDIA, (String)paramMap.get("openid"), (String)paramMap.get("profile_image_url"), (String)paramMap.get("screen_name"), l.a().h().latitude, l.a().h().longitude, (String)paramMap.get("expires_in"), new ad()
        {
          public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString)
          {
            try
            {
              paramAnonymousArrayOfd = new JSONObject(paramAnonymousString);
              Object localObject = paramAnonymousArrayOfd.optJSONObject("object");
              if (localObject != null)
              {
                localObject = ((JSONObject)localObject).optJSONArray("thirdPartInfo");
                if (localObject != null) {
                  q.a().c((Activity)d.a(d.this), ((JSONArray)localObject).toString());
                }
              }
              paramAnonymousInt = paramAnonymousArrayOfd.optInt("code");
              if (paramAnonymousInt == 2001)
              {
                d.a(d.this).a(paramMap);
                return;
              }
              if (paramAnonymousInt == 0)
              {
                d.a(d.this).a(paramAnonymousString);
                return;
              }
            }
            catch (JSONException paramAnonymousArrayOfd) {}
          }
          
          public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
          
          public void h()
          {
            d.a(d.this).d();
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
        break label50;
      }
    }
    
    public void onError(SHARE_MEDIA paramSHARE_MEDIA, int paramInt, Throwable paramThrowable)
    {
      d.a(d.this).d();
      d.a(d.this).e();
    }
    
    public void onStart(SHARE_MEDIA paramSHARE_MEDIA)
    {
      d.a(d.this).c();
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */