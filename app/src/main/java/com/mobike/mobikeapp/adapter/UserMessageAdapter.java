package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.support.annotation.ab;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.bumptech.glide.o;
import com.mobike.mobikeapp.data.MessageDataInfo.MessageData;
import com.mobike.mobikeapp.model.c.h;
import java.util.List;

public class UserMessageAdapter
  extends BaseAdapter
{
  private Context a;
  private List<MessageDataInfo.MessageData> b;
  
  public UserMessageAdapter(Context paramContext, @ab List<MessageDataInfo.MessageData> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2130968760, paramViewGroup, false);
      localView.setTag(new ViewHolder(localView));
    }
    paramView = (ViewHolder)localView.getTag();
    paramViewGroup = (MessageDataInfo.MessageData)getItem(paramInt);
    if (!TextUtils.isEmpty(paramViewGroup.image))
    {
      paramView.image.setVisibility(0);
      l.c(this.a).a(paramViewGroup.image).a(paramView.image);
    }
    for (;;)
    {
      paramView.date.setText(h.c(paramViewGroup.timestamp));
      paramView.title.setText(paramViewGroup.title);
      return localView;
      paramView.image.setVisibility(8);
    }
  }
  
  static class ViewHolder
  {
    @BindView(a=2131755714)
    TextView body;
    @BindView(a=2131755710)
    TextView date;
    @BindView(a=2131755712)
    ImageView image;
    @BindView(a=2131755713)
    TextView title;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.a(this, paramView);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/UserMessageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */