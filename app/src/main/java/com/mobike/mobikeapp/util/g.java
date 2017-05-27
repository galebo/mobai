package com.mobike.mobikeapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mobike.mobikeapp.data.CountryEnum;

public class g
{
  public static CountryEnum a(Context paramContext)
  {
    Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
    paramContext = ((TelephonyManager)localObject).getSimCountryIso();
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = ((TelephonyManager)localObject).getNetworkCountryIso();
    }
    for (;;)
    {
      localObject = CountryEnum.values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CountryEnum localCountryEnum = localObject[i];
        if (localCountryEnum.iso.equals(paramContext.toUpperCase())) {
          return localCountryEnum;
        }
        i += 1;
      }
      return null;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String[] arrayOfString = paramContext.getResources().getStringArray(2131689472);
    paramContext = paramContext.getResources().getStringArray(2131689473);
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (arrayOfString[i].equals(paramString)) {
        return paramContext[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */