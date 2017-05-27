package com.mobike.mobikeapp.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.ac;
import android.support.annotation.ag;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.mobike.mobikeapp.util.RideManager;
import com.umeng.analytics.MobclickAgent;
import java.util.UUID;

@ag(b=18)
public class BluetoothService
  extends Service
{
  public static final long a = 5000L;
  public static final long b = 10000L;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final String l = "com.mobike.ACTION_GATT_CONNECTED";
  public static final String m = "com.mobike.ACTION_GATT_DISCONNECTED";
  public static final String n = "com.mobike.ACTION_GATT_SERVICES_DISCOVERED";
  public static final String o = "com.mobike.ACTION_DATA_AVAILABLE";
  public static final String p = "com.mobike.ACTION_DATA_WRITE_DONE";
  public static final String q = "com.mobike.EXTRA_DATA";
  public static final String r = "com.mobike.DEVICE_DOES_NOT_SUPPORT_UART";
  public static final UUID s = UUID.fromString("A000FAA0-0047-005A-0052-6D6F62696B65");
  public static final UUID t = UUID.fromString("A000FEE0-0047-005A-0052-6D6F62696B65");
  public static final UUID u = UUID.fromString("A000FEE1-0047-005A-0052-6D6F62696B65");
  public static final UUID v = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  private BluetoothAdapter A;
  private String B;
  private BluetoothGatt C;
  private a D = a.a;
  private final BluetoothGattCallback E = new BluetoothGattCallback()
  {
    public void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      if (RideManager.a().u())
      {
        BluetoothService.b(BluetoothService.this).postDelayed(b.a(this, paramAnonymousBluetoothGattCharacteristic), 0L);
        return;
      }
      BluetoothService.a(BluetoothService.this, "com.mobike.ACTION_DATA_AVAILABLE", paramAnonymousBluetoothGattCharacteristic);
    }
    
    public void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0) {
        BluetoothService.a(BluetoothService.this, "com.mobike.ACTION_DATA_AVAILABLE", paramAnonymousBluetoothGattCharacteristic);
      }
    }
    
    public void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0)
      {
        if (BluetoothService.this.c) {
          RideManager.a().b(false);
        }
        BluetoothService.a(BluetoothService.this, "com.mobike.ACTION_DATA_WRITE_DONE");
      }
    }
    
    public void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt2 == 2)
      {
        BluetoothService.a(BluetoothService.this, BluetoothService.a.c);
        BluetoothService.a(BluetoothService.this, "com.mobike.ACTION_GATT_CONNECTED");
        BluetoothService.a(BluetoothService.this).discoverServices();
      }
      while (paramAnonymousInt2 != 0) {
        return;
      }
      BluetoothService.a(BluetoothService.this, BluetoothService.a.a);
      RideManager.a().C();
      BluetoothService.a(BluetoothService.this, "com.mobike.ACTION_GATT_DISCONNECTED");
    }
    
    public void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0) {
        BluetoothService.a(BluetoothService.this, "com.mobike.ACTION_GATT_SERVICES_DISCOVERED");
      }
    }
    
    public void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0) {
        BluetoothService.this.d();
      }
    }
  };
  public boolean c = false;
  private final String w = BluetoothService.class.getSimpleName();
  private final Handler x = new Handler();
  private final IBinder y = new b();
  private BluetoothManager z;
  
  private void a(String paramString, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    paramString = new Intent(paramString);
    if (u.equals(paramBluetoothGattCharacteristic.getUuid())) {
      paramString.putExtra("com.mobike.EXTRA_DATA", paramBluetoothGattCharacteristic.getValue());
    }
    LocalBroadcastManager.getInstance(this).sendBroadcast(paramString);
  }
  
  private void b(String paramString)
  {
    paramString = new Intent(paramString);
    LocalBroadcastManager.getInstance(this).sendBroadcast(paramString);
  }
  
  public void a(boolean paramBoolean, BluetoothAdapter.LeScanCallback paramLeScanCallback)
  {
    if (this.A != null)
    {
      if (paramBoolean)
      {
        this.x.postDelayed(a.a(this, paramLeScanCallback), 5000L);
        this.A.startLeScan(paramLeScanCallback);
      }
    }
    else {
      return;
    }
    this.A.stopLeScan(paramLeScanCallback);
  }
  
  public boolean a()
  {
    if (this.z == null)
    {
      this.z = ((BluetoothManager)getSystemService("bluetooth"));
      if (this.z == null) {
        return false;
      }
    }
    this.A = this.z.getAdapter();
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((this.A == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if ((this.B != null) && (paramString.equals(this.B)) && (this.C != null))
    {
      if (this.C.connect())
      {
        this.D = a.b;
        return true;
      }
      return false;
    }
    BluetoothDevice localBluetoothDevice = this.A.getRemoteDevice(paramString);
    if (localBluetoothDevice == null)
    {
      MobclickAgent.c(this, "01001");
      return false;
    }
    this.C = localBluetoothDevice.connectGatt(this, false, this.E);
    this.B = paramString;
    this.D = a.b;
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    Object localObject = this.C.getService(s);
    if (localObject == null)
    {
      b("com.mobike.DEVICE_DOES_NOT_SUPPORT_UART");
      return false;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(t);
    if (localObject == null)
    {
      b("com.mobike.DEVICE_DOES_NOT_SUPPORT_UART");
      return false;
    }
    ((BluetoothGattCharacteristic)localObject).setValue(paramArrayOfByte);
    return this.C.writeCharacteristic((BluetoothGattCharacteristic)localObject);
  }
  
  public void b()
  {
    if ((this.A == null) || (this.C == null)) {
      return;
    }
    this.C.disconnect();
  }
  
  public void c()
  {
    if ((Build.VERSION.SDK_INT >= 18) && (this.C != null))
    {
      this.B = null;
      this.C.close();
      this.C = null;
    }
  }
  
  public void d()
  {
    Object localObject = this.C.getService(s);
    if (localObject == null)
    {
      b("com.mobike.DEVICE_DOES_NOT_SUPPORT_UART");
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(u);
    if (localObject == null)
    {
      b("com.mobike.DEVICE_DOES_NOT_SUPPORT_UART");
      return;
    }
    this.C.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true);
    localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(v);
    ((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    this.C.writeDescriptor((BluetoothGattDescriptor)localObject);
  }
  
  @ac
  public IBinder onBind(Intent paramIntent)
  {
    return this.y;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
  
  private static enum a
  {
    private a() {}
  }
  
  public class b
    extends Binder
  {
    public b() {}
    
    public BluetoothService a()
    {
      return BluetoothService.this;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/service/BluetoothService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */