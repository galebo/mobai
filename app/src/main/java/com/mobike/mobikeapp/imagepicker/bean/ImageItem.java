package com.mobike.mobikeapp.imagepicker.bean;

import java.io.Serializable;

public class ImageItem
  implements Serializable
{
  public long addTime;
  public int height;
  public String mimeType;
  public String name;
  public String path;
  public long size;
  public int width;
  
  public boolean equals(Object paramObject)
  {
    try
    {
      ImageItem localImageItem = (ImageItem)paramObject;
      if (this.path.equalsIgnoreCase(localImageItem.path))
      {
        long l1 = this.addTime;
        long l2 = localImageItem.addTime;
        if (l1 == l2) {
          return true;
        }
      }
      return false;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
    return super.equals(paramObject);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/bean/ImageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */