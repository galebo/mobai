package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mobike.mobikeapp.model.data.b;
import java.util.ArrayList;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<b> b = new ArrayList();
  
  public i(Context paramContext, List<b> paramList)
  {
    this.b = paramList;
    this.a = paramContext;
  }
  
  public b a(int paramInt)
  {
    return (b)this.b.get(paramInt);
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public Intent b(int paramInt)
  {
    return ((b)this.b.get(paramInt)).b();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a(null);
      paramView = LayoutInflater.from(this.a).inflate(2130968758, null);
      paramViewGroup.b = paramView.findViewById(2131755705);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131755706));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      b localb = a(paramInt);
      paramViewGroup.a.setText(localb.c());
      if (!localb.d()) {
        break;
      }
      paramViewGroup.b.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.b.setVisibility(8);
    return paramView;
  }
  
  private class a
  {
    TextView a;
    View b;
    
    private a() {}
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */