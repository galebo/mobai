package com.mobike.mobikeapp.imagepicker.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageFolder
  implements Serializable
{
  public ImageItem cover;
  public ArrayList<ImageItem> images;
  public String name;
  public String path;
  
  public boolean equals(Object paramObject)
  {
    try
    {
      ImageFolder localImageFolder = (ImageFolder)paramObject;
      if (this.path.equalsIgnoreCase(localImageFolder.path))
      {
        boolean bool = this.name.equalsIgnoreCase(localImageFolder.name);
        if (bool) {
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


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/bean/ImageFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */