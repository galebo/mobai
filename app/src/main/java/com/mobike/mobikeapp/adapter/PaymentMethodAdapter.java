package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.support.annotation.ac;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.util.AccountManager.PayApproach;
import com.mobike.mobikeapp.util.AccountManager.PayType;
import com.mobike.mobikeapp.util.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PaymentMethodAdapter
  extends BaseAdapter
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 7;
  private static a[] e = { new a(2130838320, 2131297157, AccountManager.PayApproach.WX_PAY), new a(2130837604, 2131296394, AccountManager.PayApproach.ALI_PAY) };
  private static a[] f = { new a(2130837705, 2131296499, AccountManager.PayApproach.STRIPE) };
  private static a g = new a(2130837923, 2131296782, AccountManager.PayApproach.REDPACKET);
  private AccountManager.PayType d;
  private a[] h;
  private Context i;
  private int j = 0;
  private int k;
  private int l;
  
  public PaymentMethodAdapter(Context paramContext)
  {
    this.i = paramContext;
    this.h = e;
  }
  
  public PaymentMethodAdapter(Context paramContext, List<Integer> paramList, @ac AccountManager.PayType paramPayType)
  {
    this.i = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramContext = new ArrayList();
      List localList = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(7) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int m = ((Integer)paramList.next()).intValue();
        if (localList.contains(Integer.valueOf(m))) {
          switch (m)
          {
          default: 
            break;
          case 1: 
            paramContext.add(e[1]);
            break;
          case 2: 
            paramContext.add(e[0]);
            break;
          case 7: 
            if (AccountManager.PayType.RECHARGE == paramPayType) {
              paramContext.add(g);
            }
            break;
          }
        }
      }
      this.h = ((a[])paramContext.toArray(new a[paramContext.size()]));
      return;
    }
    this.h = e;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public boolean a()
  {
    return this.k >= this.l;
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b(int paramInt)
  {
    this.k -= paramInt;
  }
  
  public AccountManager.PayApproach c()
  {
    return e(this.j).c;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
    notifyDataSetChanged();
  }
  
  public void d()
  {
    this.h = null;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public a e(int paramInt)
  {
    if (q.a().g() != CountryEnum.China) {}
    for (int m = 1; m != 0; m = 0) {
      return f[paramInt];
    }
    return this.h[paramInt];
  }
  
  public int getCount()
  {
    if (q.a().g() != CountryEnum.China) {}
    for (int m = 1; m != 0; m = 0) {
      return f.length;
    }
    return this.h.length;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    label71:
    int m;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.i).inflate(2130968808, paramViewGroup, false);
      paramViewGroup = new ViewHolder(paramView);
      paramView.setTag(paramViewGroup);
      localObject = e(paramInt);
      if (((a)localObject).c != AccountManager.PayApproach.REDPACKET) {
        break label249;
      }
      if (this.k < this.l) {
        break label216;
      }
      bool1 = true;
      localObject = paramViewGroup.payApproachItemIcon;
      if (!bool1) {
        break label222;
      }
      m = 2130837923;
      label86:
      ((ImageView)localObject).setImageResource(m);
      localObject = paramViewGroup.payApproachItemTitle;
      Context localContext = this.i;
      if (!bool1) {
        break label229;
      }
      m = 2131296782;
      label114:
      ((TextView)localObject).setText(localContext.getString(m, new Object[] { Float.valueOf(this.k / 100.0F) }));
      localObject = paramViewGroup.payApproachItemTitle;
      if (!bool1) {
        break label236;
      }
      m = -16777216;
      label159:
      ((TextView)localObject).setTextColor(m);
      paramViewGroup.payApproachCheckRadio.setEnabled(bool1);
      paramViewGroup = paramViewGroup.payApproachCheckRadio;
      if ((!bool1) || (this.j != paramInt)) {
        break label243;
      }
    }
    label216:
    label222:
    label229:
    label236:
    label243:
    for (bool1 = bool2;; bool1 = false)
    {
      paramViewGroup.setChecked(bool1);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      bool1 = false;
      break label71;
      m = 2130837922;
      break label86;
      m = 2131296783;
      break label114;
      m = 2131623993;
      break label159;
    }
    label249:
    paramViewGroup.payApproachItemIcon.setImageResource(((a)localObject).a);
    if (((a)localObject).b != 0)
    {
      paramViewGroup.payApproachItemTitle.setText(((a)localObject).b);
      paramViewGroup = paramViewGroup.payApproachCheckRadio;
      if (this.j != paramInt) {
        break label315;
      }
    }
    for (;;)
    {
      paramViewGroup.setChecked(bool1);
      return paramView;
      paramViewGroup.payApproachItemTitle.setText("");
      break;
      label315:
      bool1 = false;
    }
  }
  
  static class ViewHolder
  {
    @BindView(a=2131755831)
    RadioButton payApproachCheckRadio;
    @BindView(a=2131755829)
    ImageView payApproachItemIcon;
    @BindView(a=2131755830)
    TextView payApproachItemTitle;
    
    ViewHolder(View paramView)
    {
      ButterKnife.a(this, paramView);
    }
  }
  
  public static class a
  {
    int a;
    int b;
    AccountManager.PayApproach c;
    
    public a(int paramInt1, int paramInt2, AccountManager.PayApproach paramPayApproach)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramPayApproach;
    }
    
    public AccountManager.PayApproach a()
    {
      return this.c;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/PaymentMethodAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */