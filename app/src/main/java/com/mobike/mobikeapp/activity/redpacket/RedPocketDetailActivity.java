package com.mobike.mobikeapp.activity.redpacket;

import android.os.Bundle;
import android.support.annotation.ac;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.q;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.adapter.o;
import com.mobike.mobikeapp.b.a.d;
import com.mobike.mobikeapp.data.PocketDataInfo;
import com.mobike.mobikeapp.widget.EmptyView;
import java.util.ArrayList;
import java.util.List;

public class RedPocketDetailActivity
  extends BaseActivity
  implements com.mobike.mobikeapp.b.a.c
{
  private ArrayList<PocketDataInfo> a = new ArrayList();
  private o b;
  private d e;
  @BindView(a=2131755326)
  RecyclerView mRecycerView;
  @BindView(a=2131755325)
  SwipeRefreshLayout mSwipeRefreshLayout;
  
  private void c()
  {
    EmptyView localEmptyView = (EmptyView)View.inflate(this, 2130968744, null);
    localEmptyView.setEmptyText(2131296757);
    localEmptyView.setEmptyImg(2130837644);
    this.b.setEmptyView(localEmptyView);
  }
  
  public void a()
  {
    this.b.setEnableLoadMore(true);
  }
  
  public void a(List<PocketDataInfo> paramList)
  {
    this.mRecycerView.postDelayed(g.a(this, paramList), 1000L);
  }
  
  public void b()
  {
    this.b.loadMoreEnd(true);
  }
  
  public void b(List<PocketDataInfo> paramList)
  {
    this.mSwipeRefreshLayout.setRefreshing(false);
    if ((paramList != null) && (paramList.size() > 0)) {
      this.b.setNewData(paramList);
    }
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968640);
    ButterKnife.a(this);
    this.e = new com.mobike.mobikeapp.b.c(this);
    paramBundle = new LinearLayoutManager(this);
    this.mRecycerView.setLayoutManager(paramBundle);
    this.b = new o(2130968824, this.a);
    this.b.openLoadAnimation();
    paramBundle = new q(this.mRecycerView.getContext(), ((LinearLayoutManager)paramBundle).j());
    this.mRecycerView.addItemDecoration(paramBundle);
    c();
    this.mRecycerView.setAdapter(this.b);
    this.b.setOnLoadMoreListener(e.a(this));
    this.mSwipeRefreshLayout.setOnRefreshListener(f.a(this));
    this.e.b();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/RedPocketDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */