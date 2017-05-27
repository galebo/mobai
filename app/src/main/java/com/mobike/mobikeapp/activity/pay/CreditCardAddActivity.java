package com.mobike.mobikeapp.activity.pay;

import android.os.Bundle;
import android.widget.Button;
import com.braintreepayments.cardform.view.CardForm;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.z;
import com.mobike.mobikeapp.widget.LoadingToastView;
import cz.msebera.android.httpclient.d;
import org.json.JSONObject;

public class CreditCardAddActivity
  extends BaseActivity
{
  public static final int a = 123;
  private LoadingToastView b;
  private CardForm e;
  private Button f;
  
  private void a()
  {
    if (!this.e.b()) {
      h.a(this, getString(2131296485));
    }
    String str1;
    Integer localInteger1;
    Integer localInteger2;
    String str2;
    do
    {
      return;
      str1 = this.e.getCardNumber();
      localInteger1 = Integer.valueOf(this.e.getExpirationMonth());
      localInteger2 = Integer.valueOf(this.e.getExpirationYear());
      str2 = this.e.getCvv();
    } while (!z.a(new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        CreditCardAddActivity.a(CreditCardAddActivity.this).b();
        h.a(CreditCardAddActivity.this, paramAnonymousString);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        CreditCardAddActivity.a(CreditCardAddActivity.this).b();
        CreditCardAddActivity.this.setResult(-1);
        CreditCardAddActivity.this.finish();
      }
    }, this, str1, localInteger1.intValue(), localInteger2.intValue(), str2));
    this.b.a();
    this.b.setLoadingText(2131296487);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968612);
    this.b = ((LoadingToastView)findViewById(2131755754));
    this.e = ((CardForm)findViewById(2131755196));
    this.e.a(true).b(true).c(true).d(false).e(false).a(getString(2131296486)).setup(this);
    this.e.setOnCardFormSubmitListener(a.a(this));
    this.f = ((Button)findViewById(2131755197));
    this.f.setOnClickListener(b.a(this));
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/CreditCardAddActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */