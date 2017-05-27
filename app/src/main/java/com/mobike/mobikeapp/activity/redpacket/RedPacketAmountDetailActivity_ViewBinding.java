package com.mobike.mobikeapp.activity.redpacket;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;

public class RedPacketAmountDetailActivity_ViewBinding
  implements Unbinder
{
  private RedPacketAmountDetailActivity b;
  private View c;
  private View d;
  private View e;
  
  @ao
  public RedPacketAmountDetailActivity_ViewBinding(RedPacketAmountDetailActivity paramRedPacketAmountDetailActivity)
  {
    this(paramRedPacketAmountDetailActivity, paramRedPacketAmountDetailActivity.getWindow().getDecorView());
  }
  
  @ao
  public RedPacketAmountDetailActivity_ViewBinding(final RedPacketAmountDetailActivity paramRedPacketAmountDetailActivity, View paramView)
  {
    this.b = paramRedPacketAmountDetailActivity;
    View localView = d.a(paramView, 2131755322, "method 'onClick'");
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramRedPacketAmountDetailActivity.onClick(paramAnonymousView);
      }
    });
    localView = d.a(paramView, 2131755323, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramRedPacketAmountDetailActivity.onClick(paramAnonymousView);
      }
    });
    paramView = d.a(paramView, 2131755320, "method 'onClick'");
    this.e = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramRedPacketAmountDetailActivity.onClick(paramAnonymousView);
      }
    });
  }
  
  @i
  public void a()
  {
    if (this.b == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/RedPacketAmountDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */