package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.support.annotation.ab;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.bumptech.glide.o;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.model.c.c;
import java.util.List;

public class WithdrawMethodAdapter
  extends BaseAdapter
{
  private Context a;
  private List<a> b;
  private int c = 0;
  
  public WithdrawMethodAdapter(Context paramContext, @ab List<a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label33:
    a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130968765, paramViewGroup, false);
      paramViewGroup = new ViewHolder(paramView);
      paramView.setTag(paramViewGroup);
      locala = (a)getItem(paramInt);
      localObject = paramViewGroup.withdrawCheck;
      if (this.c != paramInt) {
        break label109;
      }
    }
    label109:
    for (boolean bool = true;; bool = false)
    {
      ((RadioButton)localObject).setChecked(bool);
      switch (locala.a)
      {
      default: 
        return paramView;
        paramViewGroup = (ViewHolder)paramView.getTag();
        break label33;
      }
    }
    paramViewGroup.withdrawIcon.setImageResource(2130837896);
    paramViewGroup.withdrawMethodName.setText(2131296394);
    paramViewGroup.withdrawMethodTip.setVisibility(8);
    paramViewGroup.authColumn.setVisibility(8);
    return paramView;
    paramViewGroup.withdrawIcon.setImageResource(2130837897);
    paramViewGroup.withdrawMethodName.setText(2131297157);
    paramViewGroup.withdrawMethodTip.setVisibility(0);
    Object localObject = paramViewGroup.withdrawMethodTip;
    if (locala.b) {}
    for (paramInt = 2131296711;; paramInt = 2131296710)
    {
      ((TextView)localObject).setText(paramInt);
      if (!locala.b) {
        break;
      }
      paramViewGroup.authColumn.setVisibility(0);
      l.c(this.a).a(locala.c).d(2130837893).e().a(new com.bumptech.glide.load.f[] { new c(this.a, -1) }).g().a(paramViewGroup.authAvatar);
      paramViewGroup.authNickname.setText(locala.d);
      paramViewGroup.authStatus.setVisibility(0);
      paramViewGroup.authStatus.setOnClickListener(r.a(this, locala));
      return paramView;
    }
    paramViewGroup.authColumn.setVisibility(8);
    return paramView;
  }
  
  public static class ViewHolder
  {
    @BindView(a=2131755729)
    ImageView authAvatar;
    @BindView(a=2131755728)
    RelativeLayout authColumn;
    @BindView(a=2131755730)
    TextView authNickname;
    @BindView(a=2131755731)
    TextView authStatus;
    @BindView(a=2131755727)
    RadioButton withdrawCheck;
    @BindView(a=2131755724)
    ImageView withdrawIcon;
    @BindView(a=2131755725)
    TextView withdrawMethodName;
    @BindView(a=2131755726)
    TextView withdrawMethodTip;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.a(this, paramView);
    }
  }
  
  public static class a
  {
    public int a;
    public boolean b;
    public String c;
    public String d;
    public ad e;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/WithdrawMethodAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */