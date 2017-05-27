package com.mobike.mobikeapp.util;

import android.text.TextUtils;
import com.baidu.middleware.GeoRange;
import com.baidu.middleware.map.LatLng;
import com.baidu.middleware.map.LatLngBounds;
import com.baidu.middleware.map.LatLngBounds.Builder;
import com.baidu.middleware.search.OnGetPoiSearchResultListener;
import com.baidu.middleware.search.OnGetSuggestionResultListener;
import com.baidu.middleware.search.PoiCitySearchOption;
import com.baidu.middleware.search.PoiSearch;
import com.baidu.middleware.search.SuggestionSearch;
import com.baidu.middleware.search.SuggestionSearchOption;

public class s
{
  private static final String a = "LocationManager";
  private static final s b = new s();
  private PoiSearch c = null;
  private SuggestionSearch d = null;
  
  public static s a()
  {
    return b;
  }
  
  private LatLngBounds c()
  {
    if (!GeoRange.inCHINA())
    {
      LatLng localLatLng = l.a().h();
      return new LatLngBounds.Builder().include(l.a().a(localLatLng)).include(l.a().b(localLatLng)).build();
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2, OnGetPoiSearchResultListener paramOnGetPoiSearchResultListener)
  {
    LatLngBounds localLatLngBounds = c();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = new PoiCitySearchOption().city(paramString2).keyword(paramString1).latlngBounds(localLatLngBounds);
      if (this.c == null) {
        this.c = PoiSearch.newInstance();
      }
      this.c.setOnGetPoiSearchResultListener(paramOnGetPoiSearchResultListener);
      this.c.searchInCity(paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, OnGetSuggestionResultListener paramOnGetSuggestionResultListener)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      LatLngBounds localLatLngBounds = c();
      paramString1 = new SuggestionSearchOption().city(paramString2).keyword(paramString1).latlngBounds(localLatLngBounds);
      if (this.d == null) {
        this.d = SuggestionSearch.newInstance();
      }
      this.d.setOnGetSuggestionResultListener(paramOnGetSuggestionResultListener);
      this.d.requestSuggestion(paramString1);
    }
  }
  
  public void b()
  {
    if (this.c != null)
    {
      this.c.destory();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.destory();
      this.d = null;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */