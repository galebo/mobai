package com.mobike.mobikeapp.activity.pay;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.AccountManager;
import com.mobike.mobikeapp.util.o;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class RefundAccountActivity
  extends BaseActivity
{
  private EditText a;
  private Button b;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968641);
    ((TextView)findViewById(2131755327)).setText(o.a(Integer.valueOf(AccountManager.a().b())));
    this.a = ((EditText)findViewById(2131755328));
    this.b = ((Button)findViewById(2131755329));
    this.b.setEnabled(false);
    this.a.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        Button localButton = RefundAccountActivity.a(RefundAccountActivity.this);
        if (!TextUtils.isEmpty(paramAnonymousEditable.toString())) {}
        for (boolean bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = RefundAccountActivity.b(RefundAccountActivity.this).getText().toString();
        if (h.l(RefundAccountActivity.this))
        {
          RefundAccountActivity.a(RefundAccountActivity.this).setEnabled(false);
          f.b(paramAnonymousView, 0, new n()
          {
            public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, String paramAnonymous2String, Throwable paramAnonymous2Throwable)
            {
              super.a(paramAnonymous2Int, paramAnonymous2ArrayOfd, paramAnonymous2String, paramAnonymous2Throwable);
            }
            
            public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
            {
              AccountManager.a().a(0);
              paramAnonymous2ArrayOfd = new Intent(RefundAccountActivity.this, RefundResultActivity.class);
              paramAnonymous2ArrayOfd.putExtra("refund_code", 0);
              paramAnonymous2ArrayOfd.putExtra("refund_amount", AccountManager.a().b());
              paramAnonymous2ArrayOfd.putExtra("refund_message", RefundAccountActivity.this.getString(2131296879));
              RefundAccountActivity.this.startActivity(paramAnonymous2ArrayOfd);
              RefundAccountActivity.this.finish();
            }
          });
        }
      }
    });
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/RefundAccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */