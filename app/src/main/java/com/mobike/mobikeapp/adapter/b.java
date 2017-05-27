package com.mobike.mobikeapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.mobike.mobikeapp.activity.pay.CreditCardSelectActivity.a;
import com.mobike.mobikeapp.data.StripeCustomer;
import com.mobike.mobikeapp.data.StripeCustomer.Object;
import com.mobike.mobikeapp.data.StripeCustomer.Source;
import com.mobike.mobikeapp.data.StripeCustomer.SourcesInfo;
import java.util.ArrayList;
import java.util.List;

public class b
  extends RecyclerView.a<RecyclerView.v>
{
  private Activity a;
  private Button b;
  private CreditCardSelectActivity.a c;
  private StripeCustomer d;
  private int e = 0;
  
  public b(Activity paramActivity, Button paramButton, CreditCardSelectActivity.a parama)
  {
    this.a = paramActivity;
    this.b = paramButton;
    this.c = parama;
  }
  
  private void a(String paramString)
  {
    new android.support.v7.app.b.a(this.a, 2131427642).a(2131296492).b(2131296491, f.a()).a(2131296494, g.a(this, paramString)).b().show();
  }
  
  private List<StripeCustomer.Source> d()
  {
    if ((this.d == null) || (this.d.object == null)) {
      return new ArrayList();
    }
    return this.d.object.sources.data;
  }
  
  public StripeCustomer a()
  {
    return this.d;
  }
  
  public void a(StripeCustomer paramStripeCustomer)
  {
    boolean bool = false;
    this.d = paramStripeCustomer;
    if (this.e >= d().size()) {
      this.e = 0;
    }
    paramStripeCustomer = this.b;
    if (d().size() > 0) {
      bool = true;
    }
    paramStripeCustomer.setEnabled(bool);
    notifyDataSetChanged();
  }
  
  public String b()
  {
    List localList = d();
    if (localList.size() == 0) {
      return null;
    }
    return ((StripeCustomer.Source)localList.get(this.e)).id;
  }
  
  public void c()
  {
    this.a = null;
  }
  
  public int getItemCount()
  {
    return d().size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == d().size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.v paramv, int paramInt)
  {
    boolean bool = true;
    if (getItemViewType(paramInt) == 1)
    {
      paramv.itemView.setOnClickListener(c.a(this));
      return;
    }
    StripeCustomer.Source localSource = (StripeCustomer.Source)d().get(paramInt);
    b localb = (b)paramv;
    localb.a.setText(localSource.lastFour);
    RadioButton localRadioButton = localb.b;
    if (paramInt == this.e) {}
    for (;;)
    {
      localRadioButton.setChecked(bool);
      localb.itemView.setOnClickListener(d.a(this, paramv));
      localb.itemView.setOnLongClickListener(e.a(this, localSource));
      return;
      bool = false;
    }
  }
  
  public RecyclerView.v onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new a(View.inflate(this.a, 2130968677, null));
    }
    return new b(View.inflate(this.a, 2130968678, null));
  }
  
  class a
    extends RecyclerView.v
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  class b
    extends RecyclerView.v
  {
    TextView a;
    RadioButton b;
    
    public b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131755493));
      this.b = ((RadioButton)paramView.findViewById(2131755136));
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */