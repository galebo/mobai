package com.mobike.mobikeapp.data;

import android.content.Context;
import com.bumptech.glide.d.a;
import com.bumptech.glide.l;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.m;

public class MyGlideModule
  implements a
{
  public void applyOptions(Context paramContext, m paramm)
  {
    paramm.a(DecodeFormat.PREFER_ARGB_8888);
  }
  
  public void registerComponents(Context paramContext, l paraml) {}
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/data/MyGlideModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */