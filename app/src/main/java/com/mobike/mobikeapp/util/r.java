package com.mobike.mobikeapp.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.mobike.mobikeapp.data.WXPrepayDataInfo.WXPrepayInfo;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class r
{
  public static final String a = "pay_in_progress";
  private static final int b = 553779201;
  private static r c;
  private static IWXAPI d;
  private static a e;
  
  public static r a(Context paramContext)
  {
    if (c == null)
    {
      c = new r();
      d = WXAPIFactory.createWXAPI(paramContext, "wx822295c9333f22d8", false);
    }
    return c;
  }
  
  public PayReq a(WXPrepayDataInfo.WXPrepayInfo paramWXPrepayInfo)
  {
    PayReq localPayReq = new PayReq();
    localPayReq.appId = "wx822295c9333f22d8";
    localPayReq.partnerId = "1236691302";
    localPayReq.prepayId = paramWXPrepayInfo.prepayId;
    localPayReq.packageValue = paramWXPrepayInfo.packageValue;
    localPayReq.nonceStr = paramWXPrepayInfo.nonceStr;
    localPayReq.timeStamp = paramWXPrepayInfo.timeStamp;
    localPayReq.sign = paramWXPrepayInfo.sign;
    return localPayReq;
  }
  
  public void a(int paramInt)
  {
    if (e != null) {
      e.a(paramInt);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("user_info", 0).edit().putBoolean("pay_in_progress", paramBoolean).apply();
  }
  
  public void a(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    d.handleIntent(paramIntent, paramIWXAPIEventHandler);
  }
  
  public void a(a parama)
  {
    e = parama;
  }
  
  public void a(PayReq paramPayReq)
  {
    d.registerApp("wx822295c9333f22d8");
    d.sendReq(paramPayReq);
  }
  
  public boolean a()
  {
    if (d != null)
    {
      d.getWXAppSupportAPI();
      return d.isWXAppInstalled();
    }
    return false;
  }
  
  public void b()
  {
    e = null;
  }
  
  public boolean b(Context paramContext)
  {
    return paramContext.getSharedPreferences("user_info", 0).getBoolean("pay_in_progress", false);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */