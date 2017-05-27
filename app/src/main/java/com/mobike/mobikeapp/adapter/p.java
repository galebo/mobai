package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mobike.mobikeapp.model.data.b;
import java.util.ArrayList;
import java.util.List;

public class p
  extends BaseAdapter
{
  private Context a;
  private List<b> b = new ArrayList();
  
  public p(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(List<b> paramList)
  {
    if (paramList != null)
    {
      if (!this.b.isEmpty()) {
        this.b.clear();
      }
      this.b.addAll(paramList);
    }
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
    if (this.a == null) {}
    View localView;
    a locala;
    do
    {
      return paramView;
      localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.a).inflate(2130968831, paramViewGroup, false);
        paramView = new a(null);
        paramView.a = ((TextView)localView.findViewById(2131755903));
        paramView.b = localView.findViewById(2131755904);
        localView.setTag(paramView);
      }
      locala = (a)localView.getTag();
      paramViewGroup = (b)this.b.get(paramInt);
      paramView = localView;
    } while (paramViewGroup == null);
    locala.a.setText(paramViewGroup.c());
    paramView = locala.b;
    if (paramViewGroup.d()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      return localView;
    }
  }
  
  private class a
  {
    TextView a;
    View b;
    
    private a() {}
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */