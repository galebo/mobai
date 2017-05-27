package com.mobike.mobikeapp.c;

import android.support.annotation.ac;
import com.baidu.middleware.GeoRange;
import com.loopj.android.http.RequestParams;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class a
{
  public static String a = "m.mobike.com/app/pages";
  public static final String b = "https";
  
  public static String A()
  {
    return a("/red_packet/index.html");
  }
  
  public static String B()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("time", RideManager.a().x());
    localRequestParams.put("free", RideManager.a().y() * 60);
    return b("/EggShell.html", localRequestParams);
  }
  
  public static String a()
  {
    return "m.mobike.com/app/pages";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("p", paramInt1);
    localRequestParams.put("t", paramInt2);
    return b("/redPacketProblem.html", localRequestParams);
  }
  
  public static String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static String a(String paramString, int paramInt)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("orderid", paramString);
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    localRequestParams.put("country", paramInt);
    return a("/ridingtrack/index.html", localRequestParams);
  }
  
  public static String a(String paramString, @ac RequestParams paramRequestParams)
  {
    RequestParams localRequestParams = paramRequestParams;
    if (paramRequestParams == null) {}
    try
    {
      localRequestParams = new RequestParams();
      if (GeoRange.inCHINA()) {}
      for (paramRequestParams = "0";; paramRequestParams = "1")
      {
        localRequestParams.add("countryid", paramRequestParams);
        localRequestParams.add("belongid", String.valueOf(q.a().g().id));
        return new URL("https", a(), paramString + "?" + localRequestParams).toString();
      }
      return "https" + a() + paramString;
    }
    catch (MalformedURLException paramRequestParams) {}
  }
  
  public static String b()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("version", MyApplication.a);
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    return a("/aboutus/index.html", localRequestParams);
  }
  
  public static String b(String paramString)
  {
    return a(paramString);
  }
  
  public static String b(String paramString, @ac RequestParams paramRequestParams)
  {
    return a("/help/" + Locale.getDefault().getLanguage() + paramString, paramRequestParams);
  }
  
  public static String c()
  {
    return a("/treasure_hunt/index.html");
  }
  
  public static String c(String paramString)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("invitationCode", paramString);
    return a("/download/index.html", localRequestParams);
  }
  
  public static String d()
  {
    return b("/ChargeExplanation.html", null);
  }
  
  public static String d(String paramString)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("orderid", paramString);
    localRequestParams.put("citycode", l.a().e());
    return a("/eggshell_bike_result/index.html", localRequestParams);
  }
  
  public static String e()
  {
    return b("/ChargeProtocal.html", null);
  }
  
  public static String f()
  {
    return b("/protocol.html", null);
  }
  
  public static String g()
  {
    return b("/AccountSign.html", null);
  }
  
  public static String h()
  {
    return b("/UnlockReservation.html", null);
  }
  
  public static String i()
  {
    return b("/FareDeposit.html", null);
  }
  
  public static String j()
  {
    return b("/AboutMobike.html", null);
  }
  
  public static String k()
  {
    return b("/TheCarGuide.html", null);
  }
  
  public static String l()
  {
    return b("/AboutCycling.html", null);
  }
  
  public static String m()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("time", RideManager.a().x());
    localRequestParams.put("free", RideManager.a().y() * 60);
    return b("/redPacketCapturing.html", localRequestParams);
  }
  
  public static String n()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("time", RideManager.a().x());
    localRequestParams.put("free", RideManager.a().y() * 60);
    return b("/treasureHuntCapturing.html", localRequestParams);
  }
  
  public static String o()
  {
    return b("/MobikeCredit.html", null);
  }
  
  public static String p()
  {
    return b("/DepositInstruction.html", null);
  }
  
  public static String q()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("citycode", l.a().e());
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    localRequestParams.put("currency", q.a().j().id);
    return a("/coupon/index.html", localRequestParams);
  }
  
  public static String r()
  {
    return b("/coupon.html", null);
  }
  
  public static String s()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("times", System.currentTimeMillis());
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    return a("/credit/index.html", localRequestParams);
  }
  
  public static String t()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    return a("/feedback/index.html", localRequestParams);
  }
  
  public static String u()
  {
    return b("/QueryPayBack.html", null);
  }
  
  public static String v()
  {
    return b("/PayBackExplanation.html", null);
  }
  
  public static String w()
  {
    return b("/BikeDock.html", null);
  }
  
  public static String x()
  {
    return b("/HelpFindCar.html", null);
  }
  
  public static String y()
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    return a("/progrestatus/index.html", localRequestParams);
  }
  
  public static String z()
  {
    return a("/download/index.html");
  }
  
  public static abstract interface a
  {
    public static final String a = "m.mobike.com/app/pages";
    public static final String b = "staging-m.mobike.com/app/pages";
    public static final String c = "integration-m.mobike.com/app/pages";
    public static final String d = "canary-m.mobike.com/app/pages";
  }
  
  public static abstract interface b
  {
    public static final String A = "/treasure_hunt/index.html";
    public static final String B = "/treasureHuntCapturing.html";
    public static final String C = "/eggshell_bike_result/index.html";
    public static final String D = "/EggShell.html";
    public static final String a = "/aboutus/index.html";
    public static final String b = "/protocol.html";
    public static final String c = "/ChargeExplanation.html";
    public static final String d = "/ChargeProtocal.html";
    public static final String e = "/AccountSign.html";
    public static final String f = "/ridingtrack/index.html";
    public static final String g = "/credit/index.html";
    public static final String h = "/BikeDock.html";
    public static final String i = "/HelpFindCar.html";
    public static final String j = "/PayBackExplanation.html";
    public static final String k = "/QueryPayBack.html";
    public static final String l = "/DepositInstruction.html";
    public static final String m = "/UnlockReservation.html";
    public static final String n = "/FareDeposit.html";
    public static final String o = "/AboutMobike.html";
    public static final String p = "/TheCarGuide.html";
    public static final String q = "/AboutCycling.html";
    public static final String r = "/MobikeCredit.html";
    public static final String s = "/feedback/index.html";
    public static final String t = "/progrestatus/index.html";
    public static final String u = "/coupon/index.html";
    public static final String v = "/coupon.html";
    public static final String w = "/download/index.html";
    public static final String x = "/redPacketProblem.html";
    public static final String y = "/redPacketCapturing.html";
    public static final String z = "/red_packet/index.html";
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */