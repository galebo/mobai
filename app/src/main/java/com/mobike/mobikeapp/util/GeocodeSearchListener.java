package com.mobike.mobikeapp.util;

import android.text.TextUtils;
import com.baidu.middleware.GeoRange;
import com.baidu.middleware.search.ERRORNO;
import com.baidu.middleware.search.OnGetGeocodeResultListener;
import com.baidu.middleware.search.ReGeoCodeResult;
import com.baidu.middleware.search.ReGeoCodeResult.AddressComponent;
import java.util.ArrayList;
import java.util.List;

public class GeocodeSearchListener
  implements OnGetGeocodeResultListener
{
  private RideManager.RideState a = RideManager.RideState.NOT_RIDE;
  private GeocodeMode b;
  private a c;
  
  private void a(ReGeoCodeResult.AddressComponent paramAddressComponent)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramAddressComponent.street)) {
      localArrayList.add(paramAddressComponent.street);
    }
    if (!TextUtils.isEmpty(paramAddressComponent.city)) {
      localArrayList.add(paramAddressComponent.city);
    }
    if (!TextUtils.isEmpty(paramAddressComponent.province)) {
      localArrayList.add(paramAddressComponent.province);
    }
    if (!TextUtils.isEmpty(paramAddressComponent.countryName)) {
      localArrayList.add(paramAddressComponent.countryName);
    }
    paramAddressComponent = TextUtils.join(" ", localArrayList);
    this.c.a(paramAddressComponent);
  }
  
  private void a(ReGeoCodeResult paramReGeoCodeResult)
  {
    this.c.b(n.a(String.valueOf(paramReGeoCodeResult.getCitycode())));
  }
  
  private void b(ReGeoCodeResult paramReGeoCodeResult)
  {
    if (this.a == RideManager.RideState.RESERVATION) {
      this.a = RideManager.RideState.NOT_RIDE;
    }
    if (GeoRange.inCHINA())
    {
      this.c.a(paramReGeoCodeResult.getAddress());
      return;
    }
    a(paramReGeoCodeResult.getAddressDetail());
  }
  
  public void a(GeocodeMode paramGeocodeMode)
  {
    this.b = paramGeocodeMode;
  }
  
  public void a(a parama)
  {
    this.c = parama;
  }
  
  public void a(RideManager.RideState paramRideState)
  {
    this.a = paramRideState;
  }
  
  public void onGetReverseGeoCodeResult(ReGeoCodeResult paramReGeoCodeResult)
  {
    if ((paramReGeoCodeResult != null) && (paramReGeoCodeResult.error == ERRORNO.NO_ERROR) && (this.c != null)) {}
    switch (1.a[this.b.ordinal()])
    {
    default: 
      return;
    case 1: 
      b(paramReGeoCodeResult);
      return;
    }
    a(paramReGeoCodeResult);
  }
  
  public static enum GeocodeMode
  {
    SEARCH_ADDRESS,  SEARCH_NEARBY_BIKE;
    
    private GeocodeMode() {}
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/GeocodeSearchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */