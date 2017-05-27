package com.mobike.mobikeapp.activity.pay;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;

public class RefundResultActivity
  extends BaseActivity
{
  private int a = 0;
  private String b = null;
  private int e = 0;
  
  private void a()
  {
    Object localObject = (ImageView)findViewById(2131755331);
    TextView localTextView2 = (TextView)findViewById(2131755332);
    TextView localTextView1 = (TextView)findViewById(2131755336);
    TextView localTextView3 = (TextView)findViewById(2131755330);
    ((TextView)findViewById(2131755333)).setText(q.a().j().getPrefixSymbol());
    Button localButton = (Button)findViewById(2131755335);
    switch (this.a)
    {
    }
    for (;;)
    {
      ((TextView)findViewById(2131755327)).setText(o.a(this.e));
      localButton.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RefundResultActivity.this.finish();
        }
      });
      return;
      ((ImageView)localObject).setImageResource(2130838109);
      localTextView2.setText(2131296878);
      localObject = new RelativeLayout.LayoutParams(-1, h.a(this, 45.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      int i = h.a(this, getResources().getDimension(2131361833));
      ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, i, 0);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, i, 0);
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localTextView1.setVisibility(0);
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RefundResultActivity.this.startActivity(new Intent(RefundResultActivity.this, RechargeHistoryActivity.class));
        }
      });
      continue;
      ((ImageView)localObject).setImageResource(2130838108);
      localTextView2.setText(2131296865);
      localTextView1.setVisibility(4);
      localTextView3.setVisibility(0);
      localTextView3.setText(2131296866);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968642);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.a = paramBundle.getIntExtra("refund_code", 0);
      this.b = paramBundle.getStringExtra("refund_message");
      this.e = paramBundle.getIntExtra("refund_amount", 0);
      a();
    }
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default: 
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    }
    finish();
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/RefundResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */