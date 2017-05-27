package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobike.mobikeapp.data.BikeType;
import com.mobike.mobikeapp.data.BikeType.Type;
import java.util.List;

public class e
{
  private Context a;
  private List<BikeType> b;
  
  public e(Context paramContext, List<BikeType> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject = new a(null);
      paramView = LayoutInflater.from(this.a).inflate(2130968763, paramViewGroup, false);
      ((a)localObject).a = ((TextView)paramView.findViewById(2131755721));
      paramView.setTag(localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (a)paramView.getTag())
    {
      localObject = (BikeType)this.b.get(paramInt);
      if (((BikeType)localObject).stringID == 0) {
        break;
      }
      paramViewGroup.a.setText(((BikeType)localObject).stringID);
      return paramView;
    }
    Object localObject = ((BikeType)localObject).getName();
    paramViewGroup.a.setText((CharSequence)localObject);
    return paramView;
  }
  
  public BikeType a(int paramInt)
  {
    return (BikeType)this.b.get(paramInt);
  }
  
  public long b(int paramInt)
  {
    return paramInt;
  }
  
  public int c(int paramInt)
  {
    int i = 0;
    while (i < a())
    {
      if (a(i).type == paramInt) {
        return i;
      }
      i += 1;
    }
    return BikeType.Type.DEFAULT.ordinal();
  }
  
  private class a
  {
    TextView a;
    
    private a() {}
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */