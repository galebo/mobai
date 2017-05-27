package com.mobike.mobikeapp.receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.mobike.mobikeapp.MainActivity;
import com.mobike.mobikeapp.MyApplication;

public class BookingAlarmReceiver
  extends WakefulBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!MyApplication.a())
    {
      paramIntent = new NotificationCompat.Builder(paramContext).setSmallIcon(2130838071).setContentTitle(paramContext.getString(2131296443)).setContentText(paramContext.getString(2131296442)).setAutoCancel(true);
      Intent localIntent = new Intent(paramContext, MainActivity.class);
      localIntent.setAction("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.LAUNCHER");
      paramIntent.setContentIntent(PendingIntent.getActivity(paramContext, 0, localIntent, 134217728));
      ((NotificationManager)paramContext.getSystemService("notification")).notify(1, paramIntent.build());
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/receiver/BookingAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */