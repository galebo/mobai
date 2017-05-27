package com.mobike.mobikeapp.data;

import android.text.TextUtils;

public class AliPayResult
{
  private String memo;
  private String result;
  private String resultStatus;
  
  public AliPayResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        if (str.startsWith("resultStatus")) {
          this.resultStatus = gatValue(str, "resultStatus");
        }
        if (str.startsWith("result")) {
          this.result = gatValue(str, "result");
        }
        if (str.startsWith("memo")) {
          this.memo = gatValue(str, "memo");
        }
        i += 1;
      }
    }
  }
  
  private String gatValue(String paramString1, String paramString2)
  {
    paramString2 = paramString2 + "={";
    int i = paramString1.indexOf(paramString2);
    return paramString1.substring(paramString2.length() + i, paramString1.lastIndexOf("}"));
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public String getResultStatus()
  {
    return this.resultStatus;
  }
  
  public String toString()
  {
    return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/data/AliPayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */