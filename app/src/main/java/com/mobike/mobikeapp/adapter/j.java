package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.content.Intent;
import com.mobike.mobikeapp.activity.customer.BikeDamageReportActivity;
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.activity.customer.LastTenTripHistoryActivity;
import com.mobike.mobikeapp.activity.customer.LockNoFeeActivity;
import com.mobike.mobikeapp.activity.customer.LockRingIssueActivity;
import com.mobike.mobikeapp.activity.customer.ReportUnlockFailActivity;
import com.mobike.mobikeapp.activity.customer.ReportViolationsActivity;
import com.mobike.mobikeapp.activity.customer.RidingOtherIssueActivity;
import com.mobike.mobikeapp.activity.usercenter.UserManuelAllQuestionActivity;
import com.mobike.mobikeapp.c.a;
import com.mobike.mobikeapp.model.data.b.a;

public class j
{
  public static com.mobike.mobikeapp.model.data.b a(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296883), a.g());
    return new b.a().b(2131296883).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b a(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, BikeDamageReportActivity.class);
    paramContext.putExtra(com.mobike.mobikeapp.model.c.b.aP, paramString);
    return new b.a().b(2131296423).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b b(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296914), a.h());
    return new b.a().b(2131296914).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b b(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, LockRingIssueActivity.class);
    paramContext.putExtra(com.mobike.mobikeapp.model.c.b.aP, paramString);
    return new b.a().b(2131296675).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b c(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296512), a.i());
    return new b.a().b(2131296512).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b c(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, RidingOtherIssueActivity.class);
    paramContext.putExtra(com.mobike.mobikeapp.model.c.b.aP, paramString);
    return new b.a().b(2131296653).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b d(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296922), a.k());
    return new b.a().b(2131296922).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b e(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296381), a.l());
    return new b.a().b(2131296381).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b f(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296383), a.j());
    return new b.a().b(2131296383).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b g(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296382), a.o());
    return new b.a().b(2131296382).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b h(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296579), a.x());
    return new b.a().b(2131296579).a(paramContext).a().c();
  }
  
  public static com.mobike.mobikeapp.model.data.b i(Context paramContext)
  {
    return new b.a().a(new Intent(paramContext, LastTenTripHistoryActivity.class)).b(2131296614).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b j(Context paramContext)
  {
    return new b.a().a(new Intent(paramContext, LockNoFeeActivity.class)).b(2131296672).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b k(Context paramContext)
  {
    return new b.a().b(2131296654).a(new Intent(paramContext, ReportUnlockFailActivity.class)).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b l(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131297148), a.w());
    return new b.a().b(2131297148).a(paramContext).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b m(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296884), a.g());
    return new b.a().a(paramContext).b(2131296884).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b n(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296512), a.i());
    return new b.a().a(paramContext).b(2131296512).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b o(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296817), a.o());
    return new b.a().a(paramContext).b(2131296817).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b p(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296922), a.k());
    return new b.a().a(paramContext).b(2131296922).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b q(Context paramContext)
  {
    return new b.a().b(2131296644).a(new Intent(paramContext, ReportViolationsActivity.class)).c();
  }
  
  public static com.mobike.mobikeapp.model.data.b r(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296504), a.y());
    return new b.a().a(paramContext).b(2131296794).a().c();
  }
  
  public static com.mobike.mobikeapp.model.data.b s(Context paramContext)
  {
    return new b.a().b(2131296816).a(new Intent(paramContext, UserManuelAllQuestionActivity.class)).c();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */