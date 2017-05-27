package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobike.mobikeapp.model.data.CommonlyAddress;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<CommonlyAddress> b = new ArrayList();
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public CommonlyAddress a(int paramInt)
  {
    return (CommonlyAddress)this.b.get(paramInt);
  }
  
  public void a(List<CommonlyAddress> paramList)
  {
    if (this.b.size() > 0) {
      this.b.clear();
    }
    this.b.addAll(paramList);
    notifyDataSetChanged();
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
    CommonlyAddress localCommonlyAddress;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130968757, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localCommonlyAddress = (CommonlyAddress)this.b.get(paramInt);
      localTextView = paramViewGroup.d;
      if (!TextUtils.isEmpty(localCommonlyAddress.mContent)) {
        break label116;
      }
    }
    label116:
    for (String str = "";; str = localCommonlyAddress.mContent)
    {
      localTextView.setText(str);
      paramViewGroup.c.setText(localCommonlyAddress.mTitle);
      if (localCommonlyAddress.mPosition <= 0) {
        break label126;
      }
      paramViewGroup.b.setSelected(true);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label126:
    paramViewGroup.b.setSelected(false);
    return paramView;
  }
  
  static class a
  {
    View a;
    ImageView b;
    TextView c;
    TextView d;
    
    public a(View paramView)
    {
      this.a = paramView;
      this.d = ((TextView)paramView.findViewById(2131755224));
      this.c = ((TextView)paramView.findViewById(2131755117));
      this.b = ((ImageView)paramView.findViewById(2131755704));
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */