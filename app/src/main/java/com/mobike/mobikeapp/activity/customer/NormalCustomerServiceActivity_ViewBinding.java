package com.mobike.mobikeapp.activity.customer;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LastRideHistoryView;

public class NormalCustomerServiceActivity_ViewBinding
  implements Unbinder
{
  private NormalCustomerServiceActivity b;
  
  @ao
  public NormalCustomerServiceActivity_ViewBinding(NormalCustomerServiceActivity paramNormalCustomerServiceActivity)
  {
    this(paramNormalCustomerServiceActivity, paramNormalCustomerServiceActivity.getWindow().getDecorView());
  }
  
  @ao
  public NormalCustomerServiceActivity_ViewBinding(NormalCustomerServiceActivity paramNormalCustomerServiceActivity, View paramView)
  {
    this.b = paramNormalCustomerServiceActivity;
    paramNormalCustomerServiceActivity.mHistoryView = ((LastRideHistoryView)d.b(paramView, 2131755296, "field 'mHistoryView'", LastRideHistoryView.class));
    paramNormalCustomerServiceActivity.mListView = ((ListView)d.b(paramView, 2131755297, "field 'mListView'", ListView.class));
  }
  
  @i
  public void a()
  {
    NormalCustomerServiceActivity localNormalCustomerServiceActivity = this.b;
    if (localNormalCustomerServiceActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localNormalCustomerServiceActivity.mHistoryView = null;
    localNormalCustomerServiceActivity.mListView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/NormalCustomerServiceActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */