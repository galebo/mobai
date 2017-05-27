package com.mobike.mobikeapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.middleware.map.LatLng;
import com.mobike.mobikeapp.model.c.e;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class PoiSearchSugItem
  implements Serializable
{
  public String address;
  public String keyword;
  public LatLng mLocation;
  public SugItemType type;
  
  public PoiSearchSugItem(LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.type = SugItemType.LOCATION;
    this.mLocation = paramLatLng;
    this.address = paramString1;
    this.keyword = paramString2;
  }
  
  public PoiSearchSugItem(SugItemType paramSugItemType, String paramString1, String paramString2)
  {
    this.type = paramSugItemType;
    this.keyword = paramString1;
    this.address = paramString2;
  }
  
  public static void clearPoiSearchHistory(Context paramContext)
  {
    paramContext.getSharedPreferences("poi_history_prefs", 0).edit().putString("poi_keywords", "").apply();
  }
  
  public static LinkedList<PoiSearchSugItem> getPoiSearchHistory(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("poi_history_prefs", 0).getString("poi_keywords", e.a(new LinkedList()));
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = (LinkedList)e.a(paramContext);
        return paramContext;
      }
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void savePoiSearchHistory(Context paramContext, LinkedList<PoiSearchSugItem> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
      return;
    }
    try
    {
      paramContext.getSharedPreferences("poi_history_prefs", 0).edit().putString("poi_keywords", e.a(paramLinkedList)).commit();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PoiSearchSugItem)) {
      return (this.keyword.equals(((PoiSearchSugItem)paramObject).keyword)) && (this.address.equals(((PoiSearchSugItem)paramObject).address));
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return this.keyword.hashCode() * 31 + this.address.hashCode();
  }
  
  public String toString()
  {
    return this.keyword;
  }
  
  public static enum SugItemType
  {
    HISTORY,  LOCATION;
    
    private SugItemType() {}
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/data/PoiSearchSugItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */