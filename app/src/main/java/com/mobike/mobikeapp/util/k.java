package com.mobike.mobikeapp.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.google.zxing.client.android.camera.FrontLightMode;
import com.google.zxing.client.android.camera.d;

public class k
  implements SensorEventListener
{
  private static final float b = 45.0F;
  private static final float c = 450.0F;
  public a a;
  private final Context d;
  private d e;
  private Sensor f;
  private float g = -1.0F;
  
  public k(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public k(Context paramContext, float paramFloat)
  {
    this.d = paramContext;
    this.g = paramFloat;
  }
  
  public void a()
  {
    if (this.f != null)
    {
      ((SensorManager)this.d.getSystemService("sensor")).unregisterListener(this);
      this.e = null;
      this.f = null;
    }
  }
  
  public void a(d paramd)
  {
    this.e = paramd;
    if (FrontLightMode.readPref(PreferenceManager.getDefaultSharedPreferences(this.d)) == FrontLightMode.AUTO)
    {
      paramd = (SensorManager)this.d.getSystemService("sensor");
      this.f = paramd.getDefaultSensor(5);
      if (this.f != null) {
        paramd.registerListener(this, this.f, 3);
      }
    }
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    if ((this.e != null) && (this.a != null))
    {
      if (this.g >= 0.0F) {
        break label66;
      }
      if (f1 > 45.0F) {
        break label48;
      }
      this.a.a(true);
    }
    label48:
    while (f1 < 450.0F) {
      return;
    }
    this.a.a(false);
    return;
    label66:
    if (f1 < this.g)
    {
      this.a.a(true);
      return;
    }
    this.a.a(false);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */