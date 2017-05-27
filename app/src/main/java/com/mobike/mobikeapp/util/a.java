package com.mobike.mobikeapp.util;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.ab;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.b.a;
import android.support.v7.app.j;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.growingio.android.sdk.collection.GrowingIO;
import com.hyphenate.chat.ChatClient;
import com.hyphenate.helpdesk.callback.Callback;
import com.hyphenate.helpdesk.easeui.util.IntentBuilder;
import com.hyphenate.helpdesk.model.ContentFactory;
import com.hyphenate.helpdesk.model.VisitorInfo;
import com.mobike.mobikeapp.MainActivity;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.activity.pay.PayActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.receiver.BookingAlarmReceiver;
import com.mobike.mobikeapp.receiver.BookingTimeOutAlarmReceiver;
import com.mobike.mobikeapp.receiver.TrackerAlarmReceiver;
import com.mobike.mobikeapp.service.LocationService;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Locale;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView.a;

public class a
{
  public static final String a = "com.mobike.app.stoplocation.service";
  
  public static int a()
  {
    return MyApplication.b;
  }
  
  public static int a(Activity paramActivity)
  {
    return (int)Math.ceil(25.0F * paramActivity.getResources().getDisplayMetrics().density);
  }
  
  public static int a(Activity paramActivity, boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (!paramBoolean) {
      return localDisplayMetrics.widthPixels;
    }
    return (int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density);
  }
  
  public static j a(Activity paramActivity, RideManager.d paramd)
  {
    b.a locala = new b.a(paramActivity, 2131427642);
    locala.b(2131296551).a(2131296594, b.a(paramActivity)).b(2131296659, c.a(paramd)).a(false);
    paramActivity = locala.b();
    paramActivity.setCanceledOnTouchOutside(false);
    return paramActivity;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getString(2131296448);
    case 999: 
      return paramContext.getString(2131296852, new Object[] { paramString });
    }
    return paramContext.getString(2131296542, new Object[] { paramString });
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    int i = (int)(paramLong / 3600000L);
    int j = (int)((paramLong - i * 3600000L) / 60000L);
    if (i > 0) {
      return String.format(paramContext.getResources().getString(2131296933), new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    return String.format(paramContext.getResources().getString(2131296934), new Object[] { Integer.valueOf(j) });
  }
  
  public static MaterialShowcaseView a(Activity paramActivity, View paramView)
  {
    return new MaterialShowcaseView.a(paramActivity).d().a().a(paramView).a(2131296624).g(paramActivity.getResources().getColor(2131624078)).c(2131296435).b(2131296434).d(paramActivity.getResources().getColor(2131624081)).h(1000).a(true).b(true).a(com.mobike.mobikeapp.model.c.b.aS).f();
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MainActivity.class);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (h.e(paramContext))
    {
      c(paramContext, false);
      d(paramContext);
      paramContext.startService(paramIntent);
    }
  }
  
  public static void a(Context paramContext, AccountManager.PayType paramPayType)
  {
    Intent localIntent = new Intent(paramContext, PayActivity.class);
    localIntent.putExtra("pay_type", paramPayType.ordinal());
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, BookingAlarmReceiver.class), 134217728);
    if (paramBoolean)
    {
      long l = i() - 60000L;
      if (l > 0L) {
        localAlarmManager.set(0, l + System.currentTimeMillis(), paramContext);
      }
      return;
    }
    localAlarmManager.cancel(paramContext);
  }
  
  public static void a(final Context paramContext, int... paramVarArgs)
  {
    ChatClient.getInstance().login(q.a().e(), q.a().e(), new Callback()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        if (204 == paramAnonymousInt)
        {
          a.i(paramContext);
          return;
        }
        org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.f(paramAnonymousInt));
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        if (this.a.length > 0) {
          a.h(paramContext);
        }
        org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.f(0));
      }
    });
  }
  
  public static boolean a(Activity paramActivity, SHARE_MEDIA paramSHARE_MEDIA)
  {
    SHARE_MEDIA localSHARE_MEDIA = paramSHARE_MEDIA;
    if (SHARE_MEDIA.QZONE == paramSHARE_MEDIA) {
      localSHARE_MEDIA = SHARE_MEDIA.QQ;
    }
    if (SHARE_MEDIA.SINA == localSHARE_MEDIA) {}
    while (UMShareAPI.get(paramActivity).isInstall(paramActivity, localSHARE_MEDIA)) {
      return true;
    }
    h.a(paramActivity, paramActivity.getString(2131296400));
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      boolean bool = n().equals(new Locale(paramString).getLanguage());
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static int b(Activity paramActivity, boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (!paramBoolean) {
      return localDisplayMetrics.heightPixels;
    }
    int i = (int)(localDisplayMetrics.heightPixels / localDisplayMetrics.density);
    return localDisplayMetrics.densityDpi;
  }
  
  public static String b()
  {
    return MyApplication.a;
  }
  
  public static void b(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, LocationService.class));
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, BookingTimeOutAlarmReceiver.class), 134217728);
    if (paramBoolean) {
      localAlarmManager.set(0, System.currentTimeMillis() + 60000L, paramContext);
    }
    while (i() > 60000L) {
      return;
    }
    localAlarmManager.cancel(paramContext);
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("pay_order.jpg");
    return localStringBuilder.toString();
  }
  
  public static void c(Context paramContext)
  {
    paramContext.stopService(new Intent(paramContext, LocationService.class));
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("ride_prefs", 0).edit();
    paramContext.putBoolean("isRecordingTrack", paramBoolean);
    paramContext.apply();
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("id_info_photo_1");
    return localStringBuilder.toString();
  }
  
  public static void d(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, TrackerAlarmReceiver.class), 0);
    if (h.e(paramContext))
    {
      localAlarmManager.setInexactRepeating(2, SystemClock.elapsedRealtime(), 60000L, localPendingIntent);
      return;
    }
    localAlarmManager.cancel(localPendingIntent);
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("id_info_photo_2");
    return localStringBuilder.toString();
  }
  
  public static void e(Context paramContext)
  {
    if ((paramContext != null) && (h.e(paramContext)))
    {
      c(paramContext, false);
      d(paramContext);
      Intent localIntent = new Intent(paramContext, LocationService.class);
      localIntent.setAction("com.mobike.app.stoplocation.service");
      paramContext.startService(localIntent);
      NotificationManagerCompat.from(paramContext).cancel(1001);
    }
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("student_photo_1");
    return localStringBuilder.toString();
  }
  
  public static void f(Context paramContext)
  {
    c(paramContext, true);
    b(paramContext);
    d(paramContext);
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("student_photo_2");
    return localStringBuilder.toString();
  }
  
  public static String g(Context paramContext)
  {
    return paramContext.getSharedPreferences("user_info", 0).getString("userid", "");
  }
  
  public static String h()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("parking_photo");
    return localStringBuilder.toString();
  }
  
  public static void h(Context paramContext)
  {
    Intent localIntent = new IntentBuilder(paramContext).setServiceIMNumber("kefuchannelimid_908598").setVisitorInfo(ContentFactory.createVisitorInfo(null).name(q.a().i(paramContext)).phone(q.a().e())).build();
    localIntent.putExtra(com.mobike.mobikeapp.model.c.b.aP, RideManager.a().n());
    String str2 = RideManager.a().b(paramContext);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      int i = str2.length();
      str1 = str2.substring(i / 2, i);
    }
    localIntent.putExtra("orderId", str1);
    paramContext.startActivity(localIntent);
  }
  
  public static long i()
  {
    return 900000L - 1000L * RideManager.a().m();
  }
  
  public static void i(Context paramContext)
  {
    ChatClient.getInstance().createAccount(q.a().e(), q.a().e(), new Callback()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        org.greenrobot.eventbus.c.a().d(new com.mobike.mobikeapp.model.a.f(paramAnonymousInt));
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        a.a(this.a, new int[0]);
      }
    });
  }
  
  public static boolean j()
  {
    return com.mobike.mobikeapp.model.c.f.a().d() != MyApplication.b;
  }
  
  public static String k()
  {
    StringBuilder localStringBuilder = o();
    localStringBuilder.append("bike_issue.jpg");
    return localStringBuilder.toString();
  }
  
  public static void l()
  {
    GrowingIO localGrowingIO = GrowingIO.getInstance();
    if (q.a().b()) {}
    for (String str = q.a().d();; str = null)
    {
      localGrowingIO.setCS1("user_id", str);
      return;
    }
  }
  
  public static void m()
  {
    GrowingIO.getInstance().setCS2("citycode", l.a().e());
  }
  
  public static String n()
  {
    return Locale.getDefault().getLanguage();
  }
  
  @ab
  private static StringBuilder o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.a().d());
    localStringBuilder.append('_');
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append('_');
    return localStringBuilder;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */