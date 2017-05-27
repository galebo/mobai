package com.mobike.mobikeapp.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.ac;
import android.text.TextUtils;
import com.baidu.middleware.map.LatLng;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.c;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager.PayApproach;
import com.mobike.mobikeapp.util.AccountManager.PayType;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.l;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.util.t;
import java.security.PublicKey;
import java.util.Locale;

public class f
{
  public static void a(int paramInt1, int paramInt2, e<com.mobike.mobikeapp.model.data.a> parame)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("totalfee", paramInt1);
    localRequestParams.put("index", paramInt2);
    g.a("/pay/transferRedpacketToWallet.do", localRequestParams, parame);
  }
  
  public static void a(int paramInt1, LatLng paramLatLng, int paramInt2, String paramString, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    if (q.a().b()) {
      localRequestParams.put("userid", q.a().d());
    }
    localRequestParams.put("longitude", Double.valueOf(paramLatLng.longitude));
    localRequestParams.put("latitude", Double.valueOf(paramLatLng.latitude));
    localRequestParams.put("cityCode", paramString);
    localRequestParams.put("scope", paramInt2);
    localRequestParams.put("biketype", paramInt1);
    g.a("/rent/nearbyBikesInfo.do", localRequestParams, parama);
  }
  
  public static void a(int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("version", paramInt);
    if (l.a().b())
    {
      LatLng localLatLng = l.a().h();
      localRequestParams.put("latitude", Double.valueOf(localLatLng.latitude));
      localRequestParams.put("longitude", Double.valueOf(localLatLng.longitude));
      localRequestParams.put("citycode", l.a().e());
    }
    g.a("/api/config/v1.do", localRequestParams, paramc);
  }
  
  public static void a(long paramLong, int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("times", paramLong);
    localRequestParams.put("size", paramInt);
    localRequestParams.put("citycode", l.a().e());
    g.a("/msg/msglist.do", localRequestParams, paramc);
  }
  
  public static void a(long paramLong, int paramInt, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("pagetimestamp", paramLong);
    localRequestParams.put("pagesize", paramInt);
    g.a("/pay/rechargehistory.do", localRequestParams, parama);
  }
  
  public static void a(long paramLong, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("times", paramLong);
    g.a("/redpacket/water/list.do", localRequestParams, paramc);
  }
  
  public static void a(long paramLong, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("times", paramLong);
    g.a("/rentmgr/getriding.do", localRequestParams, parama);
  }
  
  public static void a(Context paramContext, com.mobike.mobikeapp.model.b.a parama)
  {
    paramContext = new RequestParams();
    paramContext.put("userid", q.a().d());
    g.a("/usermgr/firstshare.do", paramContext, parama);
  }
  
  private static void a(RequestParams paramRequestParams)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    String str2 = q.a().d() + "#" + str1;
    PublicKey localPublicKey = t.a(q.a().f());
    str2 = q.a().a(str2, localPublicKey);
    paramRequestParams.put("timestamp", str1);
    paramRequestParams.put("epdata", str2);
  }
  
  public static void a(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/rentmgr/getridestate.do", localRequestParams, paramc);
  }
  
  public static void a(com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/pay/getstripecustomer.do", localRequestParams, parama);
  }
  
  public static void a(com.mobike.mobikeapp.model.b.a parama, String paramString)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("source", paramString);
    g.a("/pay/addstripesource.do", localRequestParams, parama);
  }
  
  public static void a(AccountManager.PayApproach paramPayApproach, String paramString1, String paramString2, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("source", paramPayApproach.ordinal());
    localRequestParams.put("payno", paramString1);
    localRequestParams.put("img", paramString2);
    g.a("/faults/depositproblem.do", localRequestParams, parama);
  }
  
  public static void a(AccountManager.PayType paramPayType, int paramInt1, String paramString, int paramInt2, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("currency", q.a().j().id);
    localRequestParams.put("paytype", paramPayType.ordinal());
    localRequestParams.put("amount", paramInt1);
    localRequestParams.put("source", paramString);
    localRequestParams.put("pricingstrategy", paramInt2);
    g.a("/pay/makestripepayment.do", localRequestParams, parama);
  }
  
  public static void a(AccountManager.PayType paramPayType, AccountManager.PayApproach paramPayApproach, int paramInt1, int paramInt2, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("paytype", paramPayType.ordinal());
    localRequestParams.put("payapproach", paramPayApproach.ordinal());
    localRequestParams.put("totalfee", paramInt1);
    if (paramInt2 > -1) {
      localRequestParams.put("index", paramInt2);
    }
    switch (1.a[paramPayApproach.ordinal()])
    {
    default: 
      return;
    case 1: 
      g.a("/pay/weixin.do", localRequestParams, parama);
      return;
    }
    g.a("/pay/alipay.do", localRequestParams, parama);
  }
  
  public static void a(String paramString1, float paramFloat, String paramString2, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("distance", Float.valueOf(paramFloat));
    localRequestParams.put("track", paramString2);
    localRequestParams.put("orderid", paramString1);
    g.a("/rentmgr/ridingtrack.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString, int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("mobileNo", paramString);
    if (paramInt == 1) {
      localRequestParams.put("isredpacket", paramInt);
    }
    g.a("/usermgr/getverifycode.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeIds", paramString);
    localRequestParams.put("biketype", paramInt);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localRequestParams.put("isactive", paramInt);
      paramString = l.a().h();
      if (paramString != null)
      {
        localRequestParams.put("latitude", Double.valueOf(paramString.latitude));
        localRequestParams.put("longitude", Double.valueOf(paramString.longitude));
      }
      g.a("/schedu/confirmation.do", localRequestParams, parama);
      return;
    }
  }
  
  public static void a(String paramString, LatLng paramLatLng, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikecode", paramString);
    localRequestParams.put("channel", 1);
    if (paramLatLng != null)
    {
      localRequestParams.put("longitude", Double.valueOf(paramLatLng.longitude));
      localRequestParams.put("latitude", Double.valueOf(paramLatLng.latitude));
      localRequestParams.put("citycode", l.a().e());
    }
    a(localRequestParams);
    g.a("/rentmgr/unlockBike.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, LatLng paramLatLng, c paramc, String paramString2, String paramString3)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("orderid", paramString1);
    if (paramLatLng != null)
    {
      localRequestParams.put("longitude", Double.valueOf(paramLatLng.longitude));
      localRequestParams.put("latitude", Double.valueOf(paramLatLng.latitude));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("img", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localRequestParams.put("bz", paramString3);
    }
    a(localRequestParams);
    g.a("/pay/problem/v2.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString, c paramc)
  {
    a(paramString, 0, paramc);
  }
  
  public static void a(String paramString, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("bikeIds", paramString);
    g.a("/rent/pointhelp.do", localRequestParams, parama);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, double paramDouble1, double paramDouble2, com.mobike.mobikeapp.model.b.a parama)
  {
    Object localObject = MyApplication.c;
    if (!h.g((Context)localObject))
    {
      h.a((Context)localObject, ((Context)localObject).getString(2131296740));
      return;
    }
    localObject = new RequestParams();
    ((RequestParams)localObject).put("userid", q.a().d());
    ((RequestParams)localObject).put("title", paramString1);
    ((RequestParams)localObject).put("content", paramString2);
    ((RequestParams)localObject).put("position", paramInt);
    ((RequestParams)localObject).put("lat", Double.valueOf(paramDouble1));
    ((RequestParams)localObject).put("lng", Double.valueOf(paramDouble2));
    g.a("/api/user/addmedicinaladdress.do", (RequestParams)localObject, parama);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeid", paramString1);
    localRequestParams.put("orderid", paramString2);
    paramString1 = l.a().h();
    if (paramString1 != null)
    {
      localRequestParams.put("longitude", Double.valueOf(paramString1.longitude));
      localRequestParams.put("latitude", Double.valueOf(paramString1.latitude));
    }
    localRequestParams.put("errorcode", paramInt);
    a(localRequestParams);
    g.a("/rentmgr/sendunlockcommand.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", paramString1);
    localRequestParams.put("uuid", paramString2);
    localRequestParams.put("channel", 1);
    g.a("/usermgr/bindinguid.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (q.a().b())
    {
      localRequestParams.put("userid", q.a().d());
      localRequestParams.put("student_name", q.a().i(MyApplication.c));
    }
    localRequestParams.put("student_id", paramString1);
    localRequestParams.put("tag", paramInt);
    localRequestParams.put("schoolCode", paramString2);
    localRequestParams.put("schoolName", paramString3);
    g.a("/usermgr/student.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (q.a().b())
    {
      localRequestParams.put("userid", q.a().d());
      localRequestParams.put("student_name", q.a().i(MyApplication.c));
    }
    localRequestParams.put("student_id", paramString1);
    localRequestParams.put("tag", paramInt);
    localRequestParams.put("schoolCode", paramString2);
    localRequestParams.put("schoolName", paramString3);
    localRequestParams.put("imgone", paramString4);
    localRequestParams.put("imgtwo", paramString5);
    g.a("/usermgr/studentcertification.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeid", paramString1);
    localRequestParams.put("orderid", paramString2);
    localRequestParams.put("btdata", paramString3);
    paramString1 = l.a().h();
    if (paramString1 != null)
    {
      localRequestParams.put("latitude", Double.valueOf(paramString1.latitude));
      localRequestParams.put("longitude", Double.valueOf(paramString1.longitude));
    }
    g.a("/rentmgr/acceptcommand.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("park_photo", paramString1);
    localRequestParams.put("comments", paramString2);
    localRequestParams.put("orderid", paramString3);
    paramString1 = l.a().h();
    if (paramString1 != null)
    {
      localRequestParams.put("latitude", Double.valueOf(paramString1.latitude));
      localRequestParams.put("longitude", Double.valueOf(paramString1.longitude));
    }
    g.a("/rent/parkimg.do", localRequestParams, parama);
  }
  
  public static void a(String paramString1, String paramString2, @ac String paramString3, @ac String paramString4, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("mobileNo", paramString1);
    localRequestParams.put("capt", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localRequestParams.put("source", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localRequestParams.put("unionId", paramString4);
    }
    if (l.a().b())
    {
      localRequestParams.put("citycode", l.a().e());
      paramString1 = l.a().h();
      localRequestParams.put("latitude", Double.valueOf(paramString1.latitude));
      localRequestParams.put("longitude", Double.valueOf(paramString1.longitude));
    }
    g.a("/usermgr/login.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikecode", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("imgpath", paramString2);
    }
    localRequestParams.put("typeids", paramString3);
    localRequestParams.put("desp", paramString4);
    localRequestParams.put("orderid", RideManager.a().c(MyApplication.c));
    paramString1 = l.a().h();
    if (paramString1 != null)
    {
      localRequestParams.put("latitude", Double.valueOf(paramString1.latitude));
      localRequestParams.put("longitude", Double.valueOf(paramString1.longitude));
      localRequestParams.put("citycode", l.a().e());
    }
    g.a("/faults/report.do", localRequestParams, parama);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, double paramDouble1, double paramDouble2, String paramString6, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (!TextUtils.isEmpty(paramString1)) {
      localRequestParams.put("unionId", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("source", paramString2);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("openId", paramString3);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("avatar", paramString4);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("nickName", paramString5);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("latitude", Double.valueOf(paramDouble1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("longitude", Double.valueOf(paramDouble2));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("expTime", paramString6);
    }
    g.a("/usermgr/bindsso.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (q.a().b()) {
      localRequestParams.put("userid", q.a().d());
    }
    localRequestParams.put("idcard_name", paramString1);
    localRequestParams.put("idcard_number", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localRequestParams.put("nation", paramString3);
    }
    localRequestParams.put("imgone", paramString4);
    localRequestParams.put("imgtwo", paramString5);
    localRequestParams.put("tag", paramInt);
    g.a("/usermgr/idcode.do", localRequestParams, paramc);
  }
  
  public static void a(@ac String paramString1, @ac String paramString2, @ac String paramString3, @ac String paramString4, @ac String paramString5, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    if (!TextUtils.isEmpty(paramString3)) {
      localRequestParams.add("unionId", paramString3);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localRequestParams.add("nickName", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.add("avatar", paramString2);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localRequestParams.add("openid", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localRequestParams.add("exTime", paramString5);
    }
    g.a("/pay/bindwxpayinfo.do", localRequestParams, paramc);
  }
  
  public static void a(String paramString, boolean paramBoolean, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeid", paramString);
    localRequestParams.put("isuse", Boolean.valueOf(paramBoolean));
    g.a("/rent/useful.do", localRequestParams, parama);
  }
  
  public static void b(int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("version", paramInt);
    g.a("/upgrade/version.do", localRequestParams, paramc);
  }
  
  public static void b(long paramLong, int paramInt, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("times", paramLong);
    localRequestParams.put("size", paramInt);
    g.a("/rentmgr/ridinghistory.do", localRequestParams, parama);
  }
  
  public static void b(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.c("/rentmgr/getridestate.do", localRequestParams, paramc);
  }
  
  public static void b(com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/pay/getpricingstrategy.do", localRequestParams, parama);
  }
  
  public static void b(com.mobike.mobikeapp.model.b.a parama, String paramString)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("source", paramString);
    g.a("/pay/deletestripesource.do", localRequestParams, parama);
  }
  
  public static void b(String paramString, int paramInt, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("account", paramString);
    localRequestParams.put("type", String.valueOf(paramInt));
    g.a("/pay/account.do", localRequestParams, paramc);
  }
  
  public static void b(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("mobileNo", paramString);
    localRequestParams.put("isvoice", 1);
    g.a("/usermgr/getverifycode.do", localRequestParams, paramc);
  }
  
  public static void b(String paramString, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeid", paramString);
    g.a("/schedu/stop.do", localRequestParams, parama);
  }
  
  public static void b(String paramString1, String paramString2, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (q.a().b()) {
      localRequestParams.put("userid", q.a().d());
    }
    localRequestParams.put("idcard_name", paramString1);
    localRequestParams.put("idcard_number", paramString2);
    g.a("/usermgr/idcode.do", localRequestParams, paramc);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("realname", paramString1);
    localRequestParams.put("aliacct", paramString2);
    localRequestParams.put("capt", paramString3);
    a(localRequestParams);
    g.a("/redpacket/withdraw/add.do", localRequestParams, paramc);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("negativeid", paramString1);
    localRequestParams.put("reason", paramString2);
    localRequestParams.put("img", paramString3);
    g.a("/faults/negativegrievance.do", localRequestParams, parama);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("clientid", paramString1);
    localRequestParams.add("device1", paramString2);
    localRequestParams.add("device2", paramString3);
    localRequestParams.add("deviceid", paramString4);
    localRequestParams.add("userid", q.a().d());
    localRequestParams.add("producer", Build.PRODUCT);
    localRequestParams.add("productionName", Build.MODEL);
    localRequestParams.add("ostype", "1");
    localRequestParams.add("osversion", String.valueOf(Build.VERSION.SDK_INT));
    g.a("/usermgr/binddeviceinfo.do", localRequestParams, paramc);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("idcode", paramString1);
    localRequestParams.put("capt", paramString4);
    localRequestParams.put("oldmobile", paramString2);
    localRequestParams.put("newmobile", paramString3);
    g.a("/usermgr/changemobile.do", localRequestParams, parama);
  }
  
  public static void c(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/pay/refund.do", localRequestParams, paramc);
  }
  
  public static void c(com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/pay/downpayment.do", localRequestParams, parama);
  }
  
  public static void c(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeid", paramString);
    g.a("/schedu/active.do", localRequestParams, paramc);
  }
  
  public static void c(String paramString, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("imagepath", paramString);
    localRequestParams.put("userid", q.a().d());
    g.a("/usermgr/save.do", localRequestParams, parama);
  }
  
  public static void c(String paramString1, String paramString2, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (!TextUtils.isEmpty(paramString1)) {
      localRequestParams.put("unionId", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localRequestParams.put("source", paramString2);
    }
    g.a("/usermgr/unbindsso.do", localRequestParams, paramc);
  }
  
  public static void d(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/usermgr/invitaion.do", localRequestParams, paramc);
  }
  
  public static void d(com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/pay/presenmoney.do", localRequestParams, parama);
  }
  
  public static void d(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikeid", paramString);
    g.a("/schedu/beep.do", localRequestParams, paramc);
  }
  
  public static void d(String paramString, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("nickname", paramString);
    g.a("/usermgr/save.do", localRequestParams, parama);
  }
  
  public static void e(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/usermgr/logout.do", localRequestParams, paramc);
  }
  
  public static void e(com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    g.a("/redpacket/water/detail.do", localRequestParams, parama);
  }
  
  public static void e(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("bikecode", paramString);
    g.a("/rentmgr/lockstatus.do", localRequestParams, paramc);
  }
  
  public static void e(String paramString, com.mobike.mobikeapp.model.b.a parama)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("citycode", paramString);
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    g.a("/api/school.do", localRequestParams, parama);
  }
  
  public static void f(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    g.a("/api/getserviceonoff.do", localRequestParams, paramc);
  }
  
  public static void f(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("orderid", paramString);
    g.a("/rentmgr/getridingtrackurl.do", localRequestParams, paramc);
  }
  
  public static void g(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    localRequestParams.add("citycode", l.a().e());
    g.a("/pay/getpricingstrategyv2.do", localRequestParams, paramc);
  }
  
  public static void g(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("orderid", paramString);
    localRequestParams.put("ios", "2");
    paramString = l.a().h();
    if (paramString != null)
    {
      localRequestParams.put("latitude", Double.valueOf(paramString.latitude));
      localRequestParams.put("longitude", Double.valueOf(paramString.longitude));
    }
    g.a("/rentmgr/orderinfo.do", localRequestParams, paramc);
  }
  
  public static void h(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    g.a("/pay/payway.do", localRequestParams, paramc);
  }
  
  public static void h(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("invitcode", paramString);
    g.a("/usermgr/invitaion.do", localRequestParams, paramc);
  }
  
  public static void i(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    g.a("/coupon/genwdcoupon.do", localRequestParams, paramc);
  }
  
  public static void i(String paramString, c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", q.a().d());
    localRequestParams.put("invitcode", paramString);
    localRequestParams.put("isinvited", Boolean.valueOf(true));
    g.a("/usermgr/invitaion.do", localRequestParams, paramc);
  }
  
  public static void j(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    g.a("/pay/unbindwxpayinfo.do", localRequestParams, paramc);
  }
  
  public static void j(String paramString, c paramc)
  {
    g.b(paramString, new RequestParams(), paramc);
  }
  
  public static void k(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    String str2 = l.a().e();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    localRequestParams.add("citycode", str1);
    g.a("/getHomeBannerNative.do", localRequestParams, paramc);
  }
  
  public static void l(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    if (q.a().b()) {
      localRequestParams.add("userid", q.a().d());
    }
    g.a("/wx/getUserRDFreeInfo.do", localRequestParams, paramc);
  }
  
  public static void m(c paramc)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.add("userid", q.a().d());
    g.a("/redpacket/notify.do", localRequestParams, paramc);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */