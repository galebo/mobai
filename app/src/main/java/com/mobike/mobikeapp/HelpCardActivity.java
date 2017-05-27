package com.mobike.mobikeapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.adapter.HelpCardViewAdapter;
import com.mobike.mobikeapp.adapter.HelpCardViewAdapter.a;
import com.mobike.mobikeapp.adapter.MyRideItemRecyclerViewAdapter;
import com.mobike.mobikeapp.data.BikeType;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.data.ResultRidingInfo;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.ZoomOutPageTransformer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelpCardActivity
  extends BaseActivity
{
  public static final String a = "com.mobike.intent.extra.hint.card.list";
  public static final String b = "com.mobike.intent.extra.hint.card.bike";
  public static final String e = "com.mobike.intent.extra.hint.card.ride";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 4;
  public static final int i = 8;
  public static final int j = 16;
  public static final int k = 32;
  public static final int l = 64;
  private final int[] m = { 2130837886, 2130837887, 2130837888, 2130837889, 2130837890 };
  @BindArray(a=2131689476)
  String[] mContents;
  @BindArray(a=2131689477)
  String[] mTitles;
  @BindView(a=2131755207)
  ViewPager mViewPager;
  private List<Integer> n;
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, HelpCardActivity.class);
    paramContext.putIntegerArrayListExtra("com.mobike.intent.extra.hint.card.list", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(16) })));
    return paramContext;
  }
  
  public static Intent a(Context paramContext, @ab BikeType paramBikeType)
  {
    paramContext = new Intent(paramContext, HelpCardActivity.class);
    paramContext.putIntegerArrayListExtra("com.mobike.intent.extra.hint.card.list", new ArrayList(Collections.singletonList(Integer.valueOf(32))));
    paramContext.putExtra("com.mobike.intent.extra.hint.card.bike", paramBikeType);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, @ab ResultRidingInfo paramResultRidingInfo)
  {
    paramContext = new Intent(paramContext, HelpCardActivity.class);
    paramContext.putIntegerArrayListExtra("com.mobike.intent.extra.hint.card.list", new ArrayList(Collections.singletonList(Integer.valueOf(64))));
    paramContext.putExtra("com.mobike.intent.extra.hint.card.ride", paramResultRidingInfo);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, Integer... paramVarArgs)
  {
    paramContext = new Intent(paramContext, HelpCardActivity.class);
    paramContext.putIntegerArrayListExtra("com.mobike.intent.extra.hint.card.list", new ArrayList(Arrays.asList(paramVarArgs)));
    return paramContext;
  }
  
  private List<HelpCardViewAdapter.a> a(List<Integer> paramList)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(16) });
    while (i1 < paramList.size())
    {
      if (((List)localObject).contains(paramList.get(i1)))
      {
        int i2 = ((List)localObject).indexOf(paramList.get(i1));
        localArrayList.add(HelpCardViewAdapter.a.a(this.mTitles[i2], this.mContents[i2], this.m[i2]));
      }
      i1 += 1;
    }
    BikeType localBikeType;
    if (paramList.contains(Integer.valueOf(32)))
    {
      localBikeType = (BikeType)getIntent().getSerializableExtra("com.mobike.intent.extra.hint.card.bike");
      if (!TextUtils.isEmpty(localBikeType.cardBody)) {
        break label217;
      }
      paramList = "";
      if (!TextUtils.isEmpty(localBikeType.cardTitle)) {
        break label233;
      }
    }
    label217:
    label233:
    for (localObject = localBikeType.name;; localObject = localBikeType.cardTitle)
    {
      localArrayList.add(HelpCardViewAdapter.a.a((String)localObject, paramList, localBikeType.cardImage));
      return localArrayList;
      paramList = localBikeType.cardBody.replace('^', '\n');
      break;
    }
  }
  
  private void a()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.width = com.mobike.mobikeapp.model.c.h.m(this);
    getWindow().setAttributes(localLayoutParams);
  }
  
  private void b()
  {
    this.n = getIntent().getIntegerArrayListExtra("com.mobike.intent.extra.hint.card.list");
    if ((this.n == null) || (this.n.isEmpty()))
    {
      finish();
      return;
    }
    if (this.n.contains(Integer.valueOf(64)))
    {
      c();
      return;
    }
    this.mViewPager.setAdapter(new HelpCardViewAdapter(this, a(this.n)));
    this.mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
  }
  
  private void c()
  {
    ResultRidingInfo localResultRidingInfo = (ResultRidingInfo)getIntent().getSerializableExtra("com.mobike.intent.extra.hint.card.ride");
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131755206);
    View localView = getLayoutInflater().inflate(2130968804, localViewGroup, true);
    ((TextView)localView.findViewById(2131755814)).setText(getString(2131297031, new Object[] { q.a().j().getSymbolTrimmed() }));
    Object localObject = (RecyclerView)localView.findViewById(2131755535);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setAdapter(new MyRideItemRecyclerViewAdapter(this, localResultRidingInfo.costSection));
    localObject = (TextView)localView.findViewById(2131755816);
    if (!TextUtils.isEmpty(localResultRidingInfo.notifyMsg))
    {
      ((TextView)localObject).setText(localResultRidingInfo.notifyMsg);
      localObject = (TextView)localView.findViewById(2131755369);
      if (localResultRidingInfo.ridingtime / 60 != 0) {
        break label276;
      }
      ((TextView)localObject).setText(getString(2131297028) + String.format(getString(2131296920), new Object[] { Integer.valueOf(localResultRidingInfo.ridingtime % 60) }));
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131755815)).setText(o.b(localResultRidingInfo.totalfee.add(localResultRidingInfo.coupon.negate()).max(BigDecimal.ZERO)));
      localViewGroup.setOnClickListener(h.a(this));
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label276:
      if (localResultRidingInfo.ridingtime % 60 == 0) {
        ((TextView)localObject).setText(getString(2131297028) + String.format(getString(2131296919), new Object[] { Integer.valueOf(localResultRidingInfo.ridingtime / 60) }));
      } else {
        ((TextView)localObject).setText(getString(2131297028) + String.format(getString(2131296918), new Object[] { Integer.valueOf(localResultRidingInfo.ridingtime / 60), Integer.valueOf(localResultRidingInfo.ridingtime % 60) }));
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2131034175);
  }
  
  public void onBackPressed()
  {
    setResult(-1);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968616);
    ButterKnife.a(this);
    a();
    b();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/HelpCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */