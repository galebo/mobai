package com.mobike.mobikeapp.a;

import java.net.MalformedURLException;
import java.net.URL;

public class a
{
  public static String a = "";
  public static String b = "";
  public static boolean c = false;
  public static boolean d = true;
  
  public static String a(String paramString)
  {
    if (d) {}
    String str2;
    for (String str1 = "https";; str1 = "http")
    {
      str2 = b(paramString);
      try
      {
        String str3 = new URL(str1, str2, paramString).toString();
        return str3;
      }
      catch (MalformedURLException localMalformedURLException) {}
    }
    return str1 + "://" + str2 + paramString;
  }
  
  private static String b(String paramString)
  {
    if (paramString.startsWith("/pay/")) {
      return "papi.mobike.com/mobike-api";
    }
    if ((paramString.startsWith("/rentmgr/")) || (paramString.startsWith("/schedu/"))) {
      return "lapi.mobike.com/mobike-api";
    }
    if ((paramString.startsWith("/user/")) || (paramString.startsWith("/usermgr/"))) {
      return "uapi.mobike.com/mobike-api";
    }
    if (paramString.startsWith("/api/")) {
      return "capi.mobike.com/mobike-api";
    }
    return "api.mobike.com/mobike-api";
  }
  
  public static abstract interface a
  {
    public static final int A = 350;
    public static final int B = 404;
    public static final int C = 500;
    public static final int D = 501;
    public static final int E = 502;
    public static final int F = 543;
    public static final int G = 547;
    public static final int H = 548;
    public static final int I = 600;
    public static final int J = 601;
    public static final int K = 2002;
    public static final int L = 2004;
    public static final int M = 3000;
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 200;
    public static final int d = 201;
    public static final int e = 100;
    public static final int f = 101;
    public static final int g = 102;
    public static final int h = 103;
    public static final int i = 104;
    public static final int j = 105;
    public static final int k = 107;
    public static final int l = 108;
    public static final int m = 109;
    public static final int n = 111;
    public static final int o = 120;
    public static final int p = 135;
    public static final int q = 140;
    public static final int r = 144;
    public static final int s = 150;
    public static final int t = 250;
    public static final int u = 252;
    public static final int v = 254;
    public static final int w = 300;
    public static final int x = 310;
    public static final int y = 320;
    public static final int z = 340;
  }
  
  public static abstract interface b
  {
    public static final String a = "api.mobike.com/mobike-api";
    public static final String b = "papi.mobike.com/mobike-api";
    public static final String c = "lapi.mobike.com/mobike-api";
    public static final String d = "uapi.mobike.com/mobike-api";
    public static final String e = "capi.mobike.com/mobike-api";
  }
  
  public static abstract interface c
  {
    public static final String A = "/schedu/active.do";
    public static final String B = "/schedu/beep.do";
    public static final String C = "/rentmgr/ridingtrack.do";
    public static final String D = "/rentmgr/getriding.do";
    public static final String E = "/rentmgr/getridingtrackurl.do";
    public static final String F = "/rentmgr/ridinghistory.do";
    public static final String G = "/rentmgr/orderinfo.do";
    public static final String H = "/rentmgr/acceptcommand.do";
    public static final String I = "/pay/downpayment.do";
    public static final String J = "/pay/weixin.do";
    public static final String K = "/pay/alipay.do";
    public static final String L = "/pay/refund.do";
    public static final String M = "/pay/account.do";
    public static final String N = "/pay/rechargehistory.do";
    public static final String O = "/pay/presenmoney.do";
    public static final String P = "/pay/getpricingstrategy.do";
    public static final String Q = "/pay/getstripecustomer.do";
    public static final String R = "/pay/makestripepayment.do";
    public static final String S = "/pay/addstripesource.do";
    public static final String T = "/pay/deletestripesource.do";
    public static final String U = "/pay/payway.do";
    public static final String V = "/pay/getpricingstrategyv2.do";
    public static final String W = "/pay/bindwxpayinfo.do";
    public static final String X = "/pay/unbindwxpayinfo.do";
    public static final String Y = "/pay/transferRedpacketToWallet.do";
    public static final String Z = "/msg/msglist.do";
    public static final String a = "/api/config/v1.do";
    public static final String aa = "/faults/report.do";
    public static final String ab = "/pay/problem/v2.do";
    public static final String ac = "/faults/depositproblem.do";
    public static final String ad = "/faults/negativegrievance.do";
    public static final String ae = "/api/school.do";
    public static final String af = "/api/user/addmedicinaladdress.do";
    public static final String ag = "/api/getserviceonoff.do";
    public static final String ah = "/upgrade/version.do";
    public static final String ai = "/redpacket/water/list.do";
    public static final String aj = "/redpacket/withdraw/add.do";
    public static final String ak = "/redpacket/notify.do";
    public static final String al = "/redpacket/water/detail.do";
    public static final String am = "/coupon/genwdcoupon.do";
    public static final String an = "https://graph.qq.com/oauth2.0/me?unionid=1";
    public static final String ao = "&access_token=";
    public static final String ap = "/getHomeBannerNative.do";
    public static final String aq = "/wx/getUserRDFreeInfo.do";
    public static final String ar = "config/v1.do";
    public static final String b = "/usermgr/bindinguid.do";
    public static final String c = "/usermgr/getverifycode.do";
    public static final String d = "/usermgr/login.do";
    public static final String e = "/usermgr/logout.do";
    public static final String f = "/usermgr/idcode.do";
    public static final String g = "/usermgr/student.do";
    public static final String h = "/usermgr/studentcertification.do";
    public static final String i = "/usermgr/save.do";
    public static final String j = "/usermgr/invitaion.do";
    public static final String k = "/usermgr/firstshare.do";
    public static final String l = "/usermgr/changemobile.do";
    public static final String m = "/usermgr/binddeviceinfo.do";
    public static final String n = "/usermgr/userimg.do";
    public static final String o = "/usermgr/bindsso.do";
    public static final String p = "/usermgr/unbindsso.do";
    public static final String q = "/rent/useful.do";
    public static final String r = "/rent/parkimg.do";
    public static final String s = "/rent/pointhelp.do";
    public static final String t = "/rent/nearbyBikesInfo.do";
    public static final String u = "/rentmgr/unlockBike.do";
    public static final String v = "/rentmgr/sendunlockcommand.do";
    public static final String w = "/rentmgr/getridestate.do";
    public static final String x = "/rentmgr/lockstatus.do";
    public static final String y = "/schedu/confirmation.do";
    public static final String z = "/schedu/stop.do";
  }
  
  public static abstract interface d
  {
    public static final String a = "http";
    public static final String b = "https";
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */