package com.mobike.mobikeapp.util;

import android.text.TextUtils;
import com.baidu.middleware.GeoRange;
import com.baidu.middleware.util.CityCodeConverter;
import com.baidu.middleware.util.CityCodeConverter.CityCodeType;
import com.baidu.middleware.util.CityCodeMode;

public class n
{
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (GeoRange.inCHINA())
      {
        CityCodeMode localCityCodeMode = CityCodeConverter.getInstance().from(CityCodeConverter.CityCodeType.BAIDUMAP).to(CityCodeConverter.CityCodeType.AMAP).convert(paramString);
        str = paramString;
        if (localCityCodeMode != null) {
          str = localCityCodeMode.getGaodeCityCode();
        }
      }
      return str;
    }
    return null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */