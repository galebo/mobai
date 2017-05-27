package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobike.mobikeapp.data.PocketDataInfo;
import com.mobike.mobikeapp.model.c.h;
import java.util.List;

public class o
  extends BaseQuickAdapter<PocketDataInfo, BaseViewHolder>
{
  public o(int paramInt, List<PocketDataInfo> paramList)
  {
    super(paramInt, paramList);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, PocketDataInfo paramPocketDataInfo)
  {
    int i = paramPocketDataInfo.getWithdrawStatus();
    TextView localTextView = (TextView)paramBaseViewHolder.getView(2131755888);
    if (paramPocketDataInfo.getType() == 0)
    {
      paramBaseViewHolder.setText(2131755886, paramPocketDataInfo.getBikeId() + this.mContext.getResources().getString(2131296822));
      paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getCreateTime()));
      paramBaseViewHolder.getView(2131755889).setVisibility(4);
      localTextView.setTextColor(this.mContext.getResources().getColor(2131624078));
      localTextView.setText(String.format("+%.2f", new Object[] { Float.valueOf(paramPocketDataInfo.getAmount() / 100.0F) }));
    }
    do
    {
      return;
      if (paramPocketDataInfo.getType() == 1)
      {
        paramBaseViewHolder.setText(2131755886, this.mContext.getResources().getString(2131297154));
        localTextView.setTextColor(this.mContext.getResources().getColor(17170444));
        localTextView.setText(String.format("-%.2f", new Object[] { Float.valueOf(paramPocketDataInfo.getAmount() / 100.0F) }));
        paramBaseViewHolder.getView(2131755889).setVisibility(0);
        switch (i)
        {
        default: 
          paramBaseViewHolder.setText(2131755889, paramPocketDataInfo.getRemark());
          return;
        case 0: 
          paramBaseViewHolder.setText(2131755889, this.mContext.getResources().getString(2131297149));
          paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getCreateTime()));
          return;
        case 1: 
          paramBaseViewHolder.setText(2131755889, this.mContext.getResources().getString(2131297150));
          paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getUpdateTime()));
          return;
        case 2: 
          paramBaseViewHolder.setText(2131755889, this.mContext.getResources().getString(2131297151));
          paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getReciveTime()));
          return;
        }
        paramBaseViewHolder.setText(2131755889, this.mContext.getResources().getString(2131297152));
        paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getUpdateTime()));
        return;
      }
      if (paramPocketDataInfo.getType() == 2)
      {
        paramBaseViewHolder.setText(2131755886, this.mContext.getResources().getString(2131296850));
        localTextView.setTextColor(this.mContext.getResources().getColor(17170444));
        localTextView.setText(String.format("-%.2f", new Object[] { Float.valueOf(paramPocketDataInfo.getAmount() / 100.0F) }));
        paramBaseViewHolder.getView(2131755889).setVisibility(0);
        paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getCreateTime()));
        paramBaseViewHolder.setText(2131755889, this.mContext.getResources().getString(2131297027));
        return;
      }
    } while (paramPocketDataInfo.getType() != 3);
    paramBaseViewHolder.setText(2131755886, 2131297143);
    paramBaseViewHolder.setText(2131755887, h.c(paramPocketDataInfo.getCreateTime()));
    paramBaseViewHolder.getView(2131755889).setVisibility(4);
    localTextView.setTextColor(this.mContext.getResources().getColor(2131624078));
    localTextView.setText(String.format("+%.2f", new Object[] { Float.valueOf(paramPocketDataInfo.getAmount() / 100.0F) }));
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */