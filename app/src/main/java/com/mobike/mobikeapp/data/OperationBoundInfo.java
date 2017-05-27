package com.mobike.mobikeapp.data;

import android.graphics.Color;
import com.baidu.middleware.map.LatLng;
import com.baidu.middleware.map.LatLngBounds.Builder;
import com.baidu.middleware.map.PolygonOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OperationBoundInfo
{
  private PolygonOption polygonOptions;
  
  private OperationBoundInfo(PolygonOption paramPolygonOption)
  {
    this.polygonOptions = paramPolygonOption;
  }
  
  public static OperationBoundInfo buildOperationBoundInfo(OperationDataInfo.OperationBoundConfig paramOperationBoundConfig)
  {
    if ((paramOperationBoundConfig != null) && (paramOperationBoundConfig.operationBound != null))
    {
      PolygonOption localPolygonOption = new PolygonOption();
      ArrayList localArrayList = new ArrayList();
      LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
      Iterator localIterator = paramOperationBoundConfig.operationBound.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (double[])localIterator.next();
        localObject = new LatLng(localObject[1], localObject[0]);
        localArrayList.add(localObject);
        localBuilder.include((LatLng)localObject);
      }
      localPolygonOption.points(localArrayList);
      localPolygonOption.fillColor(Color.parseColor(paramOperationBoundConfig.fillColor)).strokeColor(Color.parseColor(paramOperationBoundConfig.boundColor)).strokeWidth(10);
      return new OperationBoundInfo(localPolygonOption);
    }
    return null;
  }
  
  public PolygonOption getPolygonOptions()
  {
    return this.polygonOptions;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/data/OperationBoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */