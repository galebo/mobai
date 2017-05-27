package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.adapter.a;
import com.mobike.mobikeapp.model.c.f;
import com.mobike.mobikeapp.model.data.CommonlyAddress;
import java.util.ArrayList;
import java.util.List;

public class SettingAddressActivity
  extends BaseActivity
{
  private ListView a;
  private a b;
  
  private void a()
  {
    this.b = new a(this);
    this.a = ((ListView)findViewById(2131755373));
    this.a.setOnItemClickListener(m.a(this));
    this.a.setAdapter(this.b);
    b();
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    CommonlyAddress localCommonlyAddress2 = f.a().k();
    CommonlyAddress localCommonlyAddress1 = localCommonlyAddress2;
    if (localCommonlyAddress2 == null) {
      localCommonlyAddress1 = new CommonlyAddress(getString(2131296581), getString(2131296609));
    }
    localArrayList.add(localCommonlyAddress1);
    localCommonlyAddress2 = f.a().m();
    localCommonlyAddress1 = localCommonlyAddress2;
    if (localCommonlyAddress2 == null) {
      localCommonlyAddress1 = new CommonlyAddress(getString(2131296960), getString(2131296609));
    }
    localArrayList.add(localCommonlyAddress1);
    this.b.a(localArrayList);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      b();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968650);
    a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/SettingAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */