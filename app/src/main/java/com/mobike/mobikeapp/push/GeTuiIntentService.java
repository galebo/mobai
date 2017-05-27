package com.mobike.mobikeapp.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.mobike.mobikeapp.SplashActivity;
import com.mobike.mobikeapp.a.b;
import com.mobike.mobikeapp.activity.riding.RideResultActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.service.LocationService;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.RideManager.RideState;
import com.mobike.mobikeapp.util.a;
import com.mobike.mobikeapp.util.q;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GeTuiIntentService
  extends GTIntentService
{
  private static final String a = "ty";
  private static final String b = "tl";
  private static final String c = "ds";
  private static final String d = "ob";
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static final int h = 6;
  private static final int i = 7;
  private static final int j = 110;
  private static final int k = 250;
  
  private void a()
  {
    RideManager.a().a(RideManager.RideState.NOT_RIDE);
    RideManager.a().A();
    RideManager.a().c();
  }
  
  private void a(Context paramContext)
  {
    q.a().b(paramContext, true);
    q.a().a(true);
  }
  
  private void a(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 4: 
    case 250: 
    case 5: 
    case 6: 
      do
      {
        return;
        b(paramContext, paramJSONObject);
        return;
        a(paramJSONObject);
        return;
        d(paramContext, paramJSONObject);
        return;
        c(paramContext, paramJSONObject);
        return;
      } while (!q.a().b());
      a(paramContext);
      return;
    case 7: 
      e(paramContext, paramJSONObject);
      return;
    }
    a(paramContext, paramJSONObject);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, Intent paramIntent)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    localBuilder.setContentTitle(paramString1).setContentText(paramString2).setAutoCancel(true).setDefaults(-1).setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130838071)).setSmallIcon(2130838072);
    if (paramIntent != null) {
      localBuilder.setContentIntent(PendingIntent.getActivity(paramContext, paramInt, paramIntent, 134217728));
    }
    paramContext = localBuilder.build();
    paramContext.flags = 16;
    localNotificationManager.notify(paramInt, paramContext);
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    long l1 = Long.valueOf(paramJSONObject.optString("ds")).longValue();
    String str = paramJSONObject.optString("tl");
    int m = Integer.valueOf(paramJSONObject.optString("ob")).intValue();
    long l2 = System.currentTimeMillis();
    if (l2 < l1)
    {
      MobclickAgent.c(paramContext.getApplicationContext(), "push_time_error");
      return;
    }
    if (l2 <= m * 60000L + l1)
    {
      m = (int)((l2 - l1) / 1000L);
      paramJSONObject = new HashMap();
      paramJSONObject.put("id", str);
      MobclickAgent.a(paramContext.getApplicationContext(), "push_arrive", paramJSONObject, m);
      return;
    }
    MobclickAgent.c(paramContext.getApplicationContext(), "push_time_out");
  }
  
  private void a(SetTagCmdMessage paramSetTagCmdMessage)
  {
    paramSetTagCmdMessage.getSn();
    switch (Integer.valueOf(paramSetTagCmdMessage.getCode()).intValue())
    {
    default: 
      
    case 0: 
      
    case 20001: 
      
    case 20002: 
      
    case 20003: 
      
    case 20004: 
      
    case 20005: 
      
    case 20006: 
      
    case 20008: 
      
    case 20009: 
      
    }
  }
  
  private void a(String paramString)
  {
    RideManager.a().a(RideManager.RideState.RIDING);
    RideManager.a().b(paramString);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject.getString("ob"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void b(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ob");
    if (!paramJSONObject.equals(RideManager.a().b(paramContext))) {
      return;
    }
    a();
    a.e(paramContext.getApplicationContext());
    if (h.a(paramContext.getPackageName(), paramContext))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("urlKey", paramJSONObject);
      h.a(paramContext, RideResultActivity.class, (Bundle)localObject);
      return;
    }
    Object localObject = new Intent(paramContext, RideResultActivity.class);
    ((Intent)localObject).putExtra("urlKey", paramJSONObject);
    ((Intent)localObject).putExtra("TYPE", "PUSH");
    ((Intent)localObject).setFlags(268435456);
    a(paramContext, paramContext.getString(2131296761), paramContext.getString(2131296760), 2, (Intent)localObject);
  }
  
  private void c(Context paramContext, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("ob");
    String str2 = paramJSONObject.optString("tl");
    paramJSONObject = null;
    if (!h.a(paramContext.getPackageName(), paramContext))
    {
      paramJSONObject = new Intent(paramContext, SplashActivity.class);
      paramJSONObject.setFlags(268435456);
    }
    a(paramContext, str2, str1, 3, paramJSONObject);
  }
  
  private void d(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ob");
    Intent localIntent = new Intent(paramContext, LocationService.class);
    localIntent.setAction("com.mobike.app.stoplocation.service");
    localIntent.putExtra("orderId", RideManager.a().b(paramContext));
    a.a(paramContext, localIntent);
    a.a(paramContext);
    q.a().b(paramJSONObject);
    q.a().g(paramContext);
  }
  
  private void e(Context paramContext, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("ob");
    String str2 = paramJSONObject.optString("tl");
    paramJSONObject = null;
    if (!h.a(paramContext.getPackageName(), paramContext))
    {
      paramJSONObject = new Intent(paramContext, SplashActivity.class);
      paramJSONObject.setFlags(268435456);
    }
    a(paramContext, str2, str1, 7, paramJSONObject);
  }
  
  public void onReceiveClientId(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((TextUtils.isEmpty(q.a().a(paramContext))) || (!q.a().a(paramContext).equals(paramString))) {
      b.b(paramContext, paramString);
    }
    b.a(paramContext, paramString);
  }
  
  public void onReceiveCommandResult(Context paramContext, GTCmdMessage paramGTCmdMessage)
  {
    int m = paramGTCmdMessage.getAction();
    if (m == 10009) {
      a((SetTagCmdMessage)paramGTCmdMessage);
    }
    while (m != 10006) {
      return;
    }
  }
  
  public void onReceiveMessageData(Context paramContext, GTTransmitMessage paramGTTransmitMessage)
  {
    String str1 = paramGTTransmitMessage.getTaskId();
    String str2 = paramGTTransmitMessage.getMessageId();
    paramGTTransmitMessage = paramGTTransmitMessage.getPayload();
    PushManager.getInstance().sendFeedbackMessage(paramContext, str1, str2, 90001);
    if (paramGTTransmitMessage != null) {
      paramGTTransmitMessage = new String(paramGTTransmitMessage);
    }
    try
    {
      paramGTTransmitMessage = new JSONObject(paramGTTransmitMessage);
      if (!paramGTTransmitMessage.isNull("ty")) {
        a(paramContext, paramGTTransmitMessage.getInt("ty"), paramGTTransmitMessage);
      }
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void onReceiveOnlineState(Context paramContext, boolean paramBoolean) {}
  
  public void onReceiveServicePid(Context paramContext, int paramInt) {}
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/push/GeTuiIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */