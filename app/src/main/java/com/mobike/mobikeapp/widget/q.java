package com.mobike.mobikeapp.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.ab;
import android.widget.TextView;
import java.text.DecimalFormat;

public class q
{
  public static final int a = 25;
  public static final int b = 20;
  private TextView c;
  private DecimalFormat d = new DecimalFormat("0.0");
  private int e = 25;
  private int f = 20;
  private double g;
  private boolean h = false;
  private Handler i;
  
  public q(@ab final TextView paramTextView)
  {
    this.c = paramTextView;
    this.i = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        double d1 = q.a(q.this) / q.b(q.this);
        double d2 = ((Double)paramAnonymousMessage.obj).doubleValue();
        if ((q.c(q.this)) && (d2 < q.a(q.this)))
        {
          paramTextView.setText(q.d(q.this).format(d2));
          if (d1 > 0.1D) {}
          for (;;)
          {
            d2 = d1 + d2;
            d1 = d2;
            if (d2 > q.a(q.this)) {
              d1 = q.a(q.this);
            }
            q.e(q.this).sendMessageDelayed(q.e(q.this).obtainMessage(0, Double.valueOf(d1)), q.f(q.this));
            return;
            d1 = 0.1D;
          }
        }
        q.a(q.this, false);
      }
    };
  }
  
  public void a()
  {
    this.h = true;
    this.i.sendMessageDelayed(this.i.obtainMessage(0, Double.valueOf(0.0D)), this.f);
  }
  
  public void a(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(DecimalFormat paramDecimalFormat)
  {
    this.d = paramDecimalFormat;
  }
  
  public void b()
  {
    this.h = false;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */