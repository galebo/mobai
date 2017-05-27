package com.mobike.mobikeapp.util;

import com.mobike.mobikeapp.data.CurrencyEnum;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class o
{
  private static DecimalFormat a = new DecimalFormat("0.00");
  
  public static String a(float paramFloat)
  {
    String str = d(paramFloat);
    return str + q.a().j().getSymbol();
  }
  
  public static String a(float paramFloat, CurrencyEnum paramCurrencyEnum)
  {
    String str = d(paramFloat);
    return str + paramCurrencyEnum.getSymbol();
  }
  
  public static String a(int paramInt)
  {
    return d(b(Integer.valueOf(paramInt)));
  }
  
  public static String a(Integer paramInteger)
  {
    return a(b(paramInteger));
  }
  
  public static String a(String paramString)
  {
    return paramString + q.a().j().getSymbol();
  }
  
  public static String a(String paramString, CurrencyEnum paramCurrencyEnum)
  {
    return paramString + paramCurrencyEnum.getSymbol();
  }
  
  public static String a(BigDecimal paramBigDecimal)
  {
    paramBigDecimal = paramBigDecimal.toString();
    return paramBigDecimal + q.a().j().getSymbol();
  }
  
  public static float b(Integer paramInteger)
  {
    return paramInteger.intValue() / 100.0F;
  }
  
  public static String b(float paramFloat)
  {
    String str = d(paramFloat);
    return q.a().j().getPrefixSymbol() + str;
  }
  
  public static String b(float paramFloat, CurrencyEnum paramCurrencyEnum)
  {
    String str = d(paramFloat);
    return paramCurrencyEnum.getPrefixSymbol() + str;
  }
  
  public static String b(BigDecimal paramBigDecimal)
  {
    return a.format(paramBigDecimal);
  }
  
  public static String c(float paramFloat)
  {
    return d(paramFloat);
  }
  
  private static String d(float paramFloat)
  {
    if (paramFloat == Math.round(paramFloat)) {
      return String.valueOf((int)paramFloat);
    }
    return String.valueOf(paramFloat);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */