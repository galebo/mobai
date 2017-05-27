package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.content.Intent;
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.activity.pay.WalletActivity;
import com.mobike.mobikeapp.activity.riding.MyTripsActivity;
import com.mobike.mobikeapp.activity.usercenter.InviteFriendActivity;
import com.mobike.mobikeapp.activity.usercenter.MyCouponsActivity;
import com.mobike.mobikeapp.activity.usercenter.MyCreditActivity;
import com.mobike.mobikeapp.activity.usercenter.MyMessagesActivity;
import com.mobike.mobikeapp.activity.usercenter.SettingAddressActivity;
import com.mobike.mobikeapp.activity.usercenter.SettingsActivity;
import com.mobike.mobikeapp.activity.usercenter.UserManuelActivity;
import com.mobike.mobikeapp.c.a;
import com.mobike.mobikeapp.model.data.b;
import com.mobike.mobikeapp.model.data.b.a;

public class q
{
  public static b a(Context paramContext)
  {
    paramContext = new Intent(paramContext, SettingAddressActivity.class);
    return new b.a().b(2131296475).a(paramContext).c();
  }
  
  public static b b(Context paramContext)
  {
    paramContext = new Intent("com.mobike.action.checkupdate");
    return new b.a().b(2131296472).a(paramContext).c();
  }
  
  public static b c(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296384), a.b());
    return new b.a().b(2131296384).a(paramContext).a().c();
  }
  
  public static b d(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131297118), a.f());
    return new b.a().b(2131297118).a(paramContext).c();
  }
  
  public static b e(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296513), a.p());
    return new b.a().b(2131296513).a(paramContext).c();
  }
  
  public static b f(Context paramContext)
  {
    paramContext = CustomerServiceWebActivity.a(paramContext, paramContext.getString(2131296786), a.e());
    return new b.a().b(2131296786).a(paramContext).c();
  }
  
  public static b g(Context paramContext)
  {
    paramContext = new Intent(paramContext, MyTripsActivity.class);
    return new b.a().b(2131296732).a(paramContext).c();
  }
  
  public static b h(Context paramContext)
  {
    paramContext = new Intent(paramContext, MyCreditActivity.class);
    return new b.a().b(2131296693).a(paramContext).c();
  }
  
  public static b i(Context paramContext)
  {
    return new b.a().b(2131296733).a(new Intent(paramContext, WalletActivity.class)).c();
  }
  
  public static b j(Context paramContext)
  {
    return new b.a().b(2131296692).a(new Intent(paramContext, MyCouponsActivity.class)).c();
  }
  
  public static b k(Context paramContext)
  {
    return new b.a().b(2131297116).a(new Intent(paramContext, UserManuelActivity.class)).c();
  }
  
  public static b l(Context paramContext)
  {
    paramContext = new Intent(paramContext, MyMessagesActivity.class);
    return new b.a().b(2131296694).a(paramContext).c();
  }
  
  public static b m(Context paramContext)
  {
    return new b.a().b(2131296973).a(new Intent(paramContext, InviteFriendActivity.class)).c();
  }
  
  public static b n(Context paramContext)
  {
    return new b.a().b(2131296966).a(new Intent(paramContext, SettingsActivity.class)).c();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */