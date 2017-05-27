package com.mobike.mobikeapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.baidu.middleware.GeoRange;
import com.bumptech.glide.g;
import com.bumptech.glide.o;
import com.growingio.android.sdk.agent.VdsAgent;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.OperationDialogFragment;
import com.mobike.mobikeapp.SplashActivity.b;
import com.mobike.mobikeapp.data.BikeType;
import com.mobike.mobikeapp.data.BikeType.Type;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.data.OperationBoundInfo;
import com.mobike.mobikeapp.data.OperationCardData;
import com.mobike.mobikeapp.data.OperationDataInfo;
import com.mobike.mobikeapp.data.OperationDataInfo.EasterEggConfig;
import com.mobike.mobikeapp.data.OperationDataInfo.OperationBoundConfig;
import com.mobike.mobikeapp.data.OperationDataInfo.OperationCardConfig;
import com.mobike.mobikeapp.data.OperationDataInfo.OperationConfig;
import com.mobike.mobikeapp.data.OperationDataInfo.OperationIconConfig;
import com.mobike.mobikeapp.data.OperationDataInfo.PreciousIconConfig;
import com.mobike.mobikeapp.model.c.h;
import cz.msebera.android.httpclient.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class e
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static e d;
  private OperationDataInfo.OperationBoundConfig[] e = null;
  private List<OperationBoundInfo> f = new ArrayList();
  private ArrayList<OperationCardData> g = new ArrayList();
  private OperationDataInfo.OperationIconConfig h;
  private ArrayList<BikeType> i = new ArrayList();
  private CurrencyEnum j;
  private CountryEnum k;
  private OperationDataInfo.PreciousIconConfig l = null;
  private OperationDataInfo.EasterEggConfig m;
  private int n;
  private boolean o = false;
  
  public static e a()
  {
    if (d == null) {
      d = new e();
    }
    return d;
  }
  
  private void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("settings_prefs", 0);
    try
    {
      this.i = ((ArrayList)com.mobike.mobikeapp.model.c.e.a(localSharedPreferences.getString("bike_type_data", com.mobike.mobikeapp.model.c.e.a(new ArrayList()))));
      if (this.i == null) {
        this.i = new ArrayList();
      }
      if (this.i.isEmpty()) {
        this.i.add(BikeType.createDefaultAllBikeTypes(paramContext));
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
    paramContext.putInt("operation_config_version", paramInt);
    paramContext.putString("operation_config_city", paramString);
    paramContext.apply();
  }
  
  private void a(Context paramContext, OperationDataInfo.OperationCardConfig paramOperationCardConfig)
  {
    switch (paramOperationCardConfig.code)
    {
    default: 
      return;
    case 1: 
      this.g.addAll(paramOperationCardConfig.operationCards);
    }
    for (;;)
    {
      i(paramContext);
      return;
      this.g.clear();
      this.g.addAll(paramOperationCardConfig.operationCards);
      continue;
      this.g.clear();
    }
  }
  
  private void a(Context paramContext, OperationDataInfo.OperationIconConfig paramOperationIconConfig)
  {
    switch (paramOperationIconConfig.code)
    {
    }
    for (;;)
    {
      paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
      try
      {
        paramContext.putString("operation_icon_data", com.mobike.mobikeapp.model.c.e.a(this.h));
        paramContext.apply();
        return;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
      this.h = paramOperationIconConfig;
      b(paramContext, paramOperationIconConfig);
      continue;
      this.h = null;
    }
  }
  
  private void a(Context paramContext, OperationDataInfo.PreciousIconConfig paramPreciousIconConfig)
  {
    if (this.l != null) {
      this.l = null;
    }
    this.l = paramPreciousIconConfig;
    paramContext = paramContext.getSharedPreferences("PRECIOUS_ICON_NAME", 0).edit();
    try
    {
      paramContext.putString("PRECIOUS_ICON_DATA_KEY", com.mobike.mobikeapp.model.c.e.a(this.l));
      paramContext.apply();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Context paramContext, Integer paramInteger)
  {
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
    paramContext.putInt("operation_config_country_key", paramInteger.intValue());
    paramContext.apply();
    this.k = CountryEnum.mapIntegerToCountryEnum(paramInteger);
  }
  
  private void a(Context paramContext, final String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      final int i1 = h.m(paramContext) - h.a(paramContext, 40.0F);
      new Thread(new Runnable()
      {
        public void run()
        {
          Object localObject = com.bumptech.glide.l.c(MyApplication.c).a(paramString).a(i1, this.c);
          try
          {
            localObject = (File)((com.bumptech.glide.f.a)localObject).get();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            return;
          }
          catch (ExecutionException localExecutionException)
          {
            localExecutionException.printStackTrace();
          }
        }
      }).start();
    }
  }
  
  private void a(Context paramContext, List<BikeType> paramList)
  {
    com.mobike.mobikeapp.model.c.f.a().e(BikeType.Type.DEFAULT.ordinal());
    this.i.clear();
    if ((paramList != null) && (paramList.size() > 1)) {
      this.i.add(BikeType.createDefaultAllBikeTypes(paramContext));
    }
    this.i.addAll(paramList);
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
    try
    {
      paramContext.putString("bike_type_data", com.mobike.mobikeapp.model.c.e.a(this.i));
      paramContext.apply();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(FragmentActivity paramFragmentActivity, OperationCardData paramOperationCardData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("info", paramOperationCardData);
    paramOperationCardData = OperationDialogFragment.a(localBundle);
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (!(paramOperationCardData instanceof DialogFragment))
    {
      paramOperationCardData.show(paramFragmentActivity, "startOperationCard");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)paramOperationCardData, paramFragmentActivity, "startOperationCard");
  }
  
  private void a(OperationDataInfo.EasterEggConfig paramEasterEggConfig)
  {
    if (paramEasterEggConfig == null)
    {
      com.mobike.mobikeapp.model.c.f.a().d("");
      this.m = null;
      return;
    }
    this.m = paramEasterEggConfig;
    try
    {
      com.mobike.mobikeapp.model.c.f.a().d(com.mobike.mobikeapp.model.c.e.a(paramEasterEggConfig));
      return;
    }
    catch (IOException paramEasterEggConfig)
    {
      paramEasterEggConfig.printStackTrace();
    }
  }
  
  private void a(OperationDataInfo.OperationConfig paramOperationConfig)
  {
    Context localContext = MyApplication.c;
    if ((paramOperationConfig.bikeTypes != null) && (!paramOperationConfig.bikeTypes.isEmpty()))
    {
      a(localContext, paramOperationConfig.bikeTypes);
      h(localContext);
      if (paramOperationConfig.operationCardConfig != null) {
        a(localContext, paramOperationConfig.operationCardConfig);
      }
      if (paramOperationConfig.operationIconConfig == null) {
        break label167;
      }
      a(localContext, paramOperationConfig.operationIconConfig);
      label69:
      if ((paramOperationConfig.operationBoundsConfig == null) || (paramOperationConfig.operationBoundsConfig.isEmpty())) {
        break label175;
      }
      b(localContext, paramOperationConfig.operationBoundsConfig);
    }
    for (;;)
    {
      a(localContext, paramOperationConfig.operationConfigVersion, paramOperationConfig.cityCode);
      b(localContext, Integer.valueOf(paramOperationConfig.preciousOn));
      a(localContext, paramOperationConfig.country);
      c(localContext, paramOperationConfig.currency);
      com.mobike.mobikeapp.model.c.f.a().g(paramOperationConfig.redPacketOn);
      a(paramOperationConfig.mEggConfig);
      return;
      a(localContext);
      break;
      label167:
      j(localContext);
      break label69;
      label175:
      b(localContext);
    }
  }
  
  private void b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0);
    try
    {
      this.e = ((OperationDataInfo.OperationBoundConfig[])com.mobike.mobikeapp.model.c.e.a(paramContext.getString("service_bounds_data", com.mobike.mobikeapp.model.c.e.a(new OperationDataInfo.OperationBoundConfig[0]))));
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void b(Context paramContext, OperationDataInfo.OperationIconConfig paramOperationIconConfig)
  {
    String str = paramOperationIconConfig.singleClusterUrl;
    paramOperationIconConfig = paramOperationIconConfig.singleClusterSelectUrl;
    int i1 = h.c(paramContext, 47);
    int i2 = h.c(paramContext, 57);
    new Thread(f.a(new String[] { str, paramOperationIconConfig }, i1, i2)).start();
  }
  
  private void b(Context paramContext, Integer paramInteger)
  {
    this.n = paramInteger.intValue();
  }
  
  private void b(Context paramContext, List<OperationDataInfo.OperationBoundConfig> paramList)
  {
    this.f.clear();
    this.e = ((OperationDataInfo.OperationBoundConfig[])paramList.toArray(new OperationDataInfo.OperationBoundConfig[0]));
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
    try
    {
      paramContext.putString("service_bounds_data", com.mobike.mobikeapp.model.c.e.a(this.e));
      paramContext.apply();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private OperationDataInfo.PreciousIconConfig c(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("PRECIOUS_ICON_NAME", 0);
    try
    {
      this.l = ((OperationDataInfo.PreciousIconConfig)com.mobike.mobikeapp.model.c.e.a(paramContext.getString("PRECIOUS_ICON_DATA_KEY", com.mobike.mobikeapp.model.c.e.a(new OperationDataInfo.PreciousIconConfig()))));
      paramContext = this.l;
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private void c(Context paramContext, Integer paramInteger)
  {
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
    paramContext.putInt("operation_config_currency_key", paramInteger.intValue());
    paramContext.apply();
    this.j = CurrencyEnum.mapIntegerToCurrencyEnum(paramInteger);
  }
  
  private int d(Context paramContext)
  {
    return paramContext.getSharedPreferences("settings_prefs", 0).getInt("operation_config_version", 0);
  }
  
  private String e(Context paramContext)
  {
    return paramContext.getSharedPreferences("settings_prefs", 0).getString("operation_config_city", "");
  }
  
  private void f(Context paramContext)
  {
    this.k = CountryEnum.mapIntegerToCountryEnum(Integer.valueOf(paramContext.getSharedPreferences("settings_prefs", 0).getInt("operation_config_country_key", 0)));
  }
  
  private void g(Context paramContext)
  {
    this.j = CurrencyEnum.mapIntegerToCurrencyEnum(Integer.valueOf(paramContext.getSharedPreferences("settings_prefs", 0).getInt("operation_config_currency_key", 0)));
  }
  
  private void h(Context paramContext)
  {
    this.g.clear();
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0);
    try
    {
      paramContext = paramContext.getString("operation_card_data", com.mobike.mobikeapp.model.c.e.a(new ArrayList()));
      if (!TextUtils.isEmpty(paramContext)) {
        this.g = ((ArrayList)com.mobike.mobikeapp.model.c.e.a(paramContext));
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void i(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0).edit();
    if (this.g.isEmpty())
    {
      paramContext.putString("operation_card_data", "");
      paramContext.apply();
      return;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        OperationCardData localOperationCardData = (OperationCardData)localIterator.next();
        if (l1 < localOperationCardData.endTime) {
          localArrayList.add(localOperationCardData);
        }
      }
      paramContext.putString("operation_card_data", com.mobike.mobikeapp.model.c.e.a(localArrayList));
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    paramContext.apply();
  }
  
  private void j(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("settings_prefs", 0);
    try
    {
      this.h = ((OperationDataInfo.OperationIconConfig)com.mobike.mobikeapp.model.c.e.a(paramContext.getString("operation_icon_data", com.mobike.mobikeapp.model.c.e.a(new OperationDataInfo.OperationIconConfig()))));
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void k()
  {
    SharedPreferences.Editor localEditor = MyApplication.c.getSharedPreferences("settings_prefs", 0).edit();
    localEditor.putString("operation_card_data", "");
    localEditor.putString("operation_icon_data", "");
    localEditor.putString("bike_type_data", "");
    localEditor.apply();
  }
  
  public BikeType a(int paramInt)
  {
    if ((this.i != null) && (!this.i.isEmpty()))
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        BikeType localBikeType = (BikeType)localIterator.next();
        if (localBikeType.type == paramInt) {
          return localBikeType;
        }
      }
    }
    return null;
  }
  
  public void a(FragmentActivity paramFragmentActivity)
  {
    if ((this.g != null) && (!this.g.isEmpty()))
    {
      long l1 = System.currentTimeMillis();
      Iterator localIterator = this.g.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          OperationCardData localOperationCardData = (OperationCardData)localIterator.next();
          if ((localOperationCardData.startTime < l1) && (l1 < localOperationCardData.endTime) && (localOperationCardData.frequency != 0) && (!paramFragmentActivity.isFinishing()))
          {
            a(paramFragmentActivity, localOperationCardData);
            i1 = localOperationCardData.frequency - 1;
            localOperationCardData.frequency = i1;
            if (i1 == 0) {
              this.g.remove(localOperationCardData);
            }
          }
        }
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        i(paramFragmentActivity);
      }
      return;
    }
  }
  
  public void a(final SplashActivity.b paramb)
  {
    final Context localContext = MyApplication.c;
    int i1 = d(localContext);
    String str = e(localContext);
    if ((a.j()) || (!TextUtils.equals(str, l.a().e())))
    {
      k();
      i1 = 0;
    }
    com.mobike.mobikeapp.a.f.a(i1, new ad()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        m.d(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousArrayOfd = (OperationDataInfo)x.a(paramAnonymousString, OperationDataInfo.class);
          if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.result == 0))
          {
            paramAnonymousArrayOfd = paramAnonymousArrayOfd.operationConfig;
            if (paramAnonymousArrayOfd != null) {
              e.a(e.this, paramAnonymousArrayOfd);
            }
          }
        }
        if (paramb != null) {
          paramb.a();
        }
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        m.a("responseString = " + paramAnonymousString);
        if ((paramAnonymousInt == 404) || (paramAnonymousInt == 502)) {
          if (paramb != null) {
            paramb.c();
          }
        }
        do
        {
          return;
          e.a(e.this, localContext);
          e.b(e.this, localContext);
          e.c(e.this, localContext);
          e.d(e.this, localContext);
          e.e(e.this, localContext);
        } while (paramb == null);
        paramb.b();
      }
    });
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean b()
  {
    return this.o;
  }
  
  public List<OperationBoundInfo> c()
  {
    if ((this.f.isEmpty()) && (this.e != null) && (this.e.length > 0))
    {
      OperationDataInfo.OperationBoundConfig[] arrayOfOperationBoundConfig = this.e;
      int i2 = arrayOfOperationBoundConfig.length;
      int i1 = 0;
      while (i1 < i2)
      {
        OperationDataInfo.OperationBoundConfig localOperationBoundConfig = arrayOfOperationBoundConfig[i1];
        this.f.add(OperationBoundInfo.buildOperationBoundInfo(localOperationBoundConfig));
        i1 += 1;
      }
    }
    return this.f;
  }
  
  public OperationDataInfo.OperationIconConfig d()
  {
    long l1 = System.currentTimeMillis();
    if ((this.h != null) && (this.h.startTime < l1) && (l1 < this.h.endTime)) {
      return this.h;
    }
    return null;
  }
  
  public OperationDataInfo.EasterEggConfig e()
  {
    return this.m;
  }
  
  public boolean f()
  {
    return (this.i != null) && (this.i.size() > 2);
  }
  
  public List<BikeType> g()
  {
    return this.i;
  }
  
  public CurrencyEnum h()
  {
    if (this.k != null) {
      return this.j;
    }
    if (GeoRange.inCHINA()) {
      return CurrencyEnum.RMB;
    }
    return CurrencyEnum.SGD;
  }
  
  public CountryEnum i()
  {
    if (this.k != null) {
      return this.k;
    }
    if (h() == CurrencyEnum.RMB) {
      return CountryEnum.China;
    }
    return CountryEnum.Singapore;
  }
  
  public boolean j()
  {
    return this.n == 1;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */