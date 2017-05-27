package com.mobike.mobikeapp.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.offline.MKOLUpdateElement;
import com.baidu.mapapi.map.offline.MKOfflineMap;
import com.baidu.mapapi.map.offline.MKOfflineMapListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class p
  implements MKOfflineMapListener
{
  private static p a;
  private MKOfflineMap b;
  private List<MKOLUpdateElement> c = null;
  
  public static p a()
  {
    if (a == null) {
      a = new p();
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    c();
    MKOLUpdateElement localMKOLUpdateElement = this.b.getUpdateInfo(paramInt);
    if (localMKOLUpdateElement != null) {
      switch (localMKOLUpdateElement.status)
      {
      case 3: 
      default: 
        if (localMKOLUpdateElement.update) {
          this.b.update(paramInt);
        }
        break;
      case 1: 
      case 2: 
      case 4: 
        return;
      }
    }
    this.b.start(paramInt);
  }
  
  public void b()
  {
    if (this.b == null) {
      this.b = new MKOfflineMap();
    }
    this.b.init(this);
  }
  
  public boolean b(int paramInt)
  {
    MKOLUpdateElement localMKOLUpdateElement = this.b.getUpdateInfo(paramInt);
    if (localMKOLUpdateElement == null) {}
    while ((localMKOLUpdateElement.update) || (localMKOLUpdateElement.status != 4)) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    this.c = this.b.getAllUpdateInfo();
    if (this.c == null) {
      this.c = new ArrayList();
    }
  }
  
  public void d()
  {
    a(f());
  }
  
  public boolean e()
  {
    return b(f());
  }
  
  public int f()
  {
    String str = l.a().g();
    if (TextUtils.isEmpty(str)) {
      return -1;
    }
    return Integer.parseInt(str);
  }
  
  public void g()
  {
    if (this.b != null)
    {
      c();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        MKOLUpdateElement localMKOLUpdateElement = (MKOLUpdateElement)localIterator.next();
        if (localMKOLUpdateElement.status == 1) {
          this.b.pause(localMKOLUpdateElement.cityID);
        }
      }
    }
  }
  
  public void h()
  {
    if (this.b != null)
    {
      this.b.destroy();
      this.b = null;
    }
  }
  
  public void onGetOfflineMapState(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */