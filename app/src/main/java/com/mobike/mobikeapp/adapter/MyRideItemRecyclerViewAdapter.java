package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mobike.mobikeapp.data.ResultRidingInfo.CostSection;
import com.mobike.mobikeapp.util.o;
import java.util.List;

public class MyRideItemRecyclerViewAdapter
  extends RecyclerView.a<ViewHolder>
{
  private List<ResultRidingInfo.CostSection> a;
  private Context b;
  
  public MyRideItemRecyclerViewAdapter(Context paramContext, List<ResultRidingInfo.CostSection> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ViewHolder(LayoutInflater.from(this.b).inflate(2130968762, paramViewGroup, false));
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt)
  {
    ResultRidingInfo.CostSection localCostSection = (ResultRidingInfo.CostSection)this.a.get(paramInt);
    paramViewHolder.mCostBucket.setText(localCostSection.costBucket);
    paramViewHolder.mCostDesc.setText(localCostSection.costDesc);
    if (paramInt + 1 == this.a.size())
    {
      paramViewHolder.mCostHintLine.setVisibility(8);
      paramViewHolder.mCostAmount.setText(this.b.getString(2131296937, new Object[] { o.a(localCostSection.costAmount * 100.0F / 100.0F) }));
      paramViewHolder = paramViewHolder.mCostIcon;
      if (localCostSection.costAmount != 0.0F) {
        break label150;
      }
    }
    label150:
    for (paramInt = 2130838147;; paramInt = 2130838146)
    {
      paramViewHolder.setImageResource(paramInt);
      return;
      ImageView localImageView = paramViewHolder.mCostHintLine;
      if (localCostSection.isOutSection) {}
      for (paramInt = 2130838149;; paramInt = 2130838148)
      {
        localImageView.setImageResource(paramInt);
        break;
      }
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public class ViewHolder
    extends RecyclerView.v
  {
    @BindView(a=2131755718)
    public TextView mCostAmount;
    @BindView(a=2131755717)
    public TextView mCostBucket;
    @BindView(a=2131755720)
    public TextView mCostDesc;
    @BindView(a=2131755719)
    public ImageView mCostHintLine;
    @BindView(a=2131755716)
    public ImageView mCostIcon;
    
    public ViewHolder(View paramView)
    {
      super();
      ButterKnife.a(this, paramView);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/MyRideItemRecyclerViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */