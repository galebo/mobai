package com.mobike.mobikeapp.activity.usercenter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ac;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.activity.pay.WalletActivity;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager;
import com.mobike.mobikeapp.util.AccountManager.a;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class MobileNumActivity
  extends BaseActivity
{
  private TextView a;
  private Button b;
  private LoadingToastView e;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131755768));
    this.a.setText(String.format(getString(2131296502), new Object[] { q.a().e() }));
    this.b = ((Button)findViewById(2131755770));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (h.l(MobileNumActivity.this))
        {
          MobileNumActivity.a(MobileNumActivity.this).a();
          MobileNumActivity.b(MobileNumActivity.this).setEnabled(false);
          AccountManager.a().a(new AccountManager.a()
          {
            public void a()
            {
              MobileNumActivity.a(MobileNumActivity.this).b();
              MobileNumActivity.b(MobileNumActivity.this).setEnabled(true);
              if (AccountManager.a().d())
              {
                new b.a(MobileNumActivity.this, 2131427642).b(2131297153).a(17039370, new DialogInterface.OnClickListener()
                {
                  @Instrumented
                  public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    VdsAgent.onClick(this, paramAnonymous3DialogInterface, paramAnonymous3Int);
                    Intent localIntent = new Intent(MobileNumActivity.this, WalletActivity.class);
                    MobileNumActivity.this.startActivity(localIntent);
                    paramAnonymous3DialogInterface.dismiss();
                  }
                }).b(17039360, new DialogInterface.OnClickListener()
                {
                  @Instrumented
                  public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    VdsAgent.onClick(this, paramAnonymous3DialogInterface, paramAnonymous3Int);
                    paramAnonymous3DialogInterface.dismiss();
                  }
                }).b().show();
                return;
              }
              if (q.a().b(MobileNumActivity.this) != 0)
              {
                h.a(MobileNumActivity.this, MobileNumActivity.this.getString(2131296466));
                return;
              }
              Intent localIntent = new Intent(MobileNumActivity.this, ChangeMobileNumActivity.class);
              MobileNumActivity.this.startActivity(localIntent);
            }
            
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              MobileNumActivity.a(MobileNumActivity.this).b();
              MobileNumActivity.b(MobileNumActivity.this).setEnabled(true);
              h.a(MobileNumActivity.this, paramAnonymous2String);
            }
          });
        }
      }
    });
    this.e = ((LoadingToastView)findViewById(2131755754));
    if (q.a().g() != CountryEnum.China)
    {
      this.b.setVisibility(8);
      findViewById(2131755769).setVisibility(8);
    }
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968630);
    a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MobileNumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */