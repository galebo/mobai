package com.mobike.mobikeapp.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.util.r;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity
  extends Activity
  implements IWXAPIEventHandler
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    r.a(this).a(getIntent(), this);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    r.a(this).a(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    r.a(this).a(paramBaseResp.errCode);
    finish();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/wxapi/WXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */