package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.middleware.map.LatLng;
import com.mobike.mobikeapp.data.PoiSearchSugItem;
import com.mobike.mobikeapp.data.PoiSearchSugItem.SugItemType;
import java.util.ArrayList;
import java.util.List;

public class n
  extends ArrayAdapter<PoiSearchSugItem>
{
  private Context a;
  private List<PoiSearchSugItem> b;
  private View c;
  
  public n(Context paramContext)
  {
    super(paramContext, 0);
    this.a = paramContext;
  }
  
  public PoiSearchSugItem a(int paramInt)
  {
    return (PoiSearchSugItem)this.b.get(paramInt);
  }
  
  public void a()
  {
    if (this.b != null) {
      this.b.clear();
    }
    notifyDataSetChanged();
  }
  
  public void a(View paramView)
  {
    this.c = paramView;
  }
  
  public void a(LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.b.add(new PoiSearchSugItem(paramLatLng, paramString2, paramString1));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.add(new PoiSearchSugItem(PoiSearchSugItem.SugItemType.LOCATION, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, LatLng paramLatLng)
  {
    this.b.add(new PoiSearchSugItem(paramLatLng, paramString1, paramString2));
  }
  
  public void a(List<PoiSearchSugItem> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    for (;;)
    {
      this.b.addAll(paramList);
      return;
      this.b.clear();
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2130968814, paramViewGroup, false);
      paramView = new a(null);
      paramView.a = ((ImageView)localView.findViewById(2131755842));
      paramView.b = ((TextView)localView.findViewById(2131755843));
      paramView.c = ((TextView)localView.findViewById(2131755844));
      localView.setTag(paramView);
    }
    paramView = a(paramInt);
    if (paramView != null)
    {
      paramViewGroup = (a)localView.getTag();
      switch (1.a[paramView.type.ordinal()])
      {
      default: 
        paramViewGroup.a.setImageResource(2130838067);
      }
    }
    for (;;)
    {
      paramViewGroup.b.setText(paramView.keyword);
      paramViewGroup.c.setText(paramView.address);
      return localView;
      paramViewGroup.a.setImageResource(2130838066);
      continue;
      paramViewGroup.a.setImageResource(2130838067);
    }
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    TextView c;
    
    private a() {}
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */