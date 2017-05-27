package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.ac;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.n;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.MainActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;
import cz.msebera.android.httpclient.d;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangeMobileNumActivity
  extends BaseActivity
{
  private ScrollView a;
  private TextView b;
  private EditText e;
  private EditText f;
  private EditText g;
  private Button h;
  private Button i;
  private LoadingToastView j;
  private boolean k;
  private CountDownTimer l;
  private Handler m = new Handler();
  
  private void a()
  {
    this.a = ((ScrollView)findViewById(2131755183));
    this.b = ((TextView)findViewById(2131755184));
    this.b.setText(q.a().i(this));
    this.e = ((EditText)findViewById(2131755185));
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ChangeMobileNumActivity.a(ChangeMobileNumActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.e.postDelayed(new Runnable()
    {
      public void run()
      {
        h.b(ChangeMobileNumActivity.this, ChangeMobileNumActivity.b(ChangeMobileNumActivity.this));
      }
    }, 200L);
    this.f = ((EditText)findViewById(2131755186));
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() < 11) {
          ChangeMobileNumActivity.c(ChangeMobileNumActivity.this).setEnabled(false);
        }
        for (;;)
        {
          ChangeMobileNumActivity.a(ChangeMobileNumActivity.this);
          return;
          if ((!ChangeMobileNumActivity.d(ChangeMobileNumActivity.this)) && (paramAnonymousEditable.length() == 11)) {
            ChangeMobileNumActivity.c(ChangeMobileNumActivity.this).setEnabled(true);
          }
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.g = ((EditText)findViewById(2131755187));
    this.g.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ChangeMobileNumActivity.a(ChangeMobileNumActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.g.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        ChangeMobileNumActivity.f(ChangeMobileNumActivity.this).postDelayed(new Runnable()
        {
          public void run()
          {
            ChangeMobileNumActivity.e(ChangeMobileNumActivity.this).fullScroll(130);
          }
        }, 500L);
        return false;
      }
    });
    this.h = ((Button)findViewById(2131755188));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ChangeMobileNumActivity.g(ChangeMobileNumActivity.this);
      }
    });
    this.h.setEnabled(false);
    this.i = ((Button)findViewById(2131755189));
    this.i.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (h.l(ChangeMobileNumActivity.this))
        {
          ChangeMobileNumActivity.h(ChangeMobileNumActivity.this).setEnabled(false);
          ChangeMobileNumActivity.i(ChangeMobileNumActivity.this).a();
          paramAnonymousView = q.a().e();
          String str = ChangeMobileNumActivity.j(ChangeMobileNumActivity.this).getText().toString();
          f.b(ChangeMobileNumActivity.b(ChangeMobileNumActivity.this).getText().toString(), paramAnonymousView, str, ChangeMobileNumActivity.k(ChangeMobileNumActivity.this).getText().toString(), new a()
          {
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              ChangeMobileNumActivity.h(ChangeMobileNumActivity.this).setEnabled(true);
              ChangeMobileNumActivity.i(ChangeMobileNumActivity.this).b();
              h.a(ChangeMobileNumActivity.this, paramAnonymous2String);
            }
            
            public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
            {
              ChangeMobileNumActivity.h(ChangeMobileNumActivity.this).setEnabled(true);
              ChangeMobileNumActivity.i(ChangeMobileNumActivity.this).b();
              h.a(ChangeMobileNumActivity.this.getApplicationContext(), ChangeMobileNumActivity.this.getString(2131296468));
              q.a().g(ChangeMobileNumActivity.this);
              paramAnonymous2ArrayOfd = new Intent(ChangeMobileNumActivity.this, MainActivity.class);
              ChangeMobileNumActivity.this.startActivity(paramAnonymous2ArrayOfd);
              ChangeMobileNumActivity.this.finish();
            }
          });
        }
      }
    });
    this.i.setEnabled(false);
    this.j = ((LoadingToastView)findViewById(2131755754));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.a();
      return;
    }
    this.j.b();
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 11);
  }
  
  private void b()
  {
    if ((a(this.f.getText().toString())) && (!TextUtils.isEmpty(this.g.getText().toString())) && (!TextUtils.isEmpty(this.e.getText().toString())))
    {
      this.i.setEnabled(true);
      return;
    }
    this.i.setEnabled(false);
  }
  
  private void c()
  {
    String str = this.f.getText().toString();
    if (h.l(this))
    {
      this.j.setLoadingText(2131296591);
      a(true);
      f.a(str, new n()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
        {
          ChangeMobileNumActivity.a(ChangeMobileNumActivity.this, false);
          ChangeMobileNumActivity.k(ChangeMobileNumActivity.this).requestFocus();
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
        {
          ChangeMobileNumActivity.a(ChangeMobileNumActivity.this, false);
          if (paramAnonymousJSONObject != null) {
            for (;;)
            {
              try
              {
                switch (paramAnonymousJSONObject.getInt("code"))
                {
                case 0: 
                  paramAnonymousArrayOfd = paramAnonymousJSONObject.getString("message");
                  if (TextUtils.isEmpty(paramAnonymousArrayOfd)) {
                    return;
                  }
                  h.a(ChangeMobileNumActivity.this, paramAnonymousArrayOfd);
                  return;
                }
              }
              catch (JSONException paramAnonymousArrayOfd)
              {
                paramAnonymousArrayOfd.printStackTrace();
                return;
              }
              ChangeMobileNumActivity.l(ChangeMobileNumActivity.this);
              ChangeMobileNumActivity.k(ChangeMobileNumActivity.this).requestFocus();
              ChangeMobileNumActivity.a(ChangeMobileNumActivity.this, new CountDownTimer(60000L, 1000L)
              {
                public void onFinish()
                {
                  ChangeMobileNumActivity.c(ChangeMobileNumActivity.this).setText(2131296588);
                  ChangeMobileNumActivity.c(ChangeMobileNumActivity.this).setEnabled(true);
                  ChangeMobileNumActivity.b(ChangeMobileNumActivity.this, false);
                }
                
                public void onTick(long paramAnonymous2Long)
                {
                  ChangeMobileNumActivity.c(ChangeMobileNumActivity.this).setText(String.format(ChangeMobileNumActivity.this.getResources().getString(2131296589), new Object[] { Long.valueOf(paramAnonymous2Long / 1000L) }));
                  ChangeMobileNumActivity.c(ChangeMobileNumActivity.this).setEnabled(false);
                  ChangeMobileNumActivity.b(ChangeMobileNumActivity.this, true);
                }
              }.start());
              h.a(ChangeMobileNumActivity.this, ChangeMobileNumActivity.this.getString(2131296963));
              return;
              ChangeMobileNumActivity.m(ChangeMobileNumActivity.this);
              return;
            }
          }
        }
      });
    }
  }
  
  private void d()
  {
    if (this.l != null) {
      this.l.cancel();
    }
  }
  
  private void e()
  {
    this.f.setError(getString(2131296565));
    this.f.requestFocus();
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968607);
    a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/ChangeMobileNumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */