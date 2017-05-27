package com.mobike.mobikeapp.activity.pay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.google.gson.e;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.adapter.b;
import com.mobike.mobikeapp.data.StripeCustomer;
import com.mobike.mobikeapp.data.StripeCustomer.Object;
import com.mobike.mobikeapp.data.StripeCustomer.Source;
import com.mobike.mobikeapp.data.StripeCustomer.SourcesInfo;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.widget.LoadingToastView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CreditCardSelectActivity
  extends BaseActivity
{
  public static final int a = 111;
  public static final String b = "TYPE";
  public static final int e = 0;
  public static final int f = 1;
  public static final String g = "SOURCE";
  private RecyclerView h;
  private LoadingToastView i;
  private b j;
  private Button k;
  private int l;
  
  private void a()
  {
    this.i.setLoadingText(2131296496);
    this.i.a();
    f.a(new a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        h.a(CreditCardSelectActivity.this, CreditCardSelectActivity.this.getString(2131296965));
        CreditCardSelectActivity.a(CreditCardSelectActivity.this).b();
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = new e();
        try
        {
          paramAnonymousArrayOfd = (StripeCustomer)paramAnonymousArrayOfd.a(paramAnonymousJSONObject.toString(), StripeCustomer.class);
          if (paramAnonymousArrayOfd != null) {
            CreditCardSelectActivity.b(CreditCardSelectActivity.this).a(paramAnonymousArrayOfd);
          }
          CreditCardSelectActivity.a(CreditCardSelectActivity.this).b();
          return;
        }
        catch (Exception paramAnonymousArrayOfd)
        {
          h.a(CreditCardSelectActivity.this, CreditCardSelectActivity.this.getString(2131296965));
          CreditCardSelectActivity.a(CreditCardSelectActivity.this).b();
        }
      }
    });
  }
  
  private void a(final String paramString)
  {
    this.i.setLoadingText(2131296493);
    this.i.a();
    f.b(new a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        h.a(CreditCardSelectActivity.this, CreditCardSelectActivity.this.getString(2131296965));
        CreditCardSelectActivity.a(CreditCardSelectActivity.this).b();
      }
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        paramAnonymousArrayOfd = CreditCardSelectActivity.b(CreditCardSelectActivity.this).a();
        paramAnonymousJSONObject = new ArrayList();
        Iterator localIterator = paramAnonymousArrayOfd.object.sources.data.iterator();
        while (localIterator.hasNext())
        {
          StripeCustomer.Source localSource = (StripeCustomer.Source)localIterator.next();
          if (!localSource.id.equals(paramString)) {
            paramAnonymousJSONObject.add(localSource);
          }
        }
        paramAnonymousArrayOfd.object.sources.data = paramAnonymousJSONObject;
        CreditCardSelectActivity.b(CreditCardSelectActivity.this).a(paramAnonymousArrayOfd);
        CreditCardSelectActivity.a(CreditCardSelectActivity.this).b();
      }
    }, paramString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 123) && (paramInt2 == -1)) {
      a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968613);
    this.i = ((LoadingToastView)findViewById(2131755754));
    this.k = ((Button)findViewById(2131755197));
    this.k.setEnabled(false);
    this.k.setOnClickListener(c.a(this));
    this.h = ((RecyclerView)findViewById(2131755198));
    this.j = new b(this, this.k, d.a(this));
    this.h.setAdapter(this.j);
    this.h.setLayoutManager(new LinearLayoutManager(this));
    this.l = getIntent().getIntExtra("TYPE", 0);
    if (this.l == 0)
    {
      setTitle(getString(2131296498));
      this.k.setText(getString(2131296498));
    }
    for (;;)
    {
      a();
      return;
      if (this.l == 1)
      {
        setTitle(getString(2131296495));
        this.k.setText(getString(2131296495));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/CreditCardSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */