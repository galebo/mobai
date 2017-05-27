package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.adapter.UserMessageAdapter;
import com.mobike.mobikeapp.data.MessageDataInfo;
import com.mobike.mobikeapp.data.MessageDataInfo.MessageData;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.EmptyView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.List;

public class MyMessagesActivity
  extends BaseActivity
{
  private static final int a = 1;
  private List<MessageDataInfo.MessageData> b = new ArrayList();
  private UserMessageAdapter e = null;
  @BindView(a=2131755611)
  EmptyView emptyView;
  private boolean f = false;
  private long g = 0L;
  @BindView(a=2131755285)
  ListView messageListView;
  @BindView(a=2131755284)
  SwipyRefreshLayout swipyRefreshLayout;
  
  private void a()
  {
    if (h.l(this))
    {
      this.g = 0L;
      f.a(this.g, 10, new ad()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            paramAnonymousArrayOfd = (MessageDataInfo)new e().a(paramAnonymousString, MessageDataInfo.class);
            if (paramAnonymousArrayOfd != null)
            {
              MyMessagesActivity.a(MyMessagesActivity.this, paramAnonymousArrayOfd.pageTimeStamp);
              paramAnonymousArrayOfd = paramAnonymousArrayOfd.messageDataItems;
              if ((paramAnonymousArrayOfd != null) && (!paramAnonymousArrayOfd.isEmpty()))
              {
                MyMessagesActivity.a(MyMessagesActivity.this).clear();
                MyMessagesActivity.a(MyMessagesActivity.this).addAll(paramAnonymousArrayOfd);
                MyMessagesActivity.b(MyMessagesActivity.this).notifyDataSetChanged();
              }
            }
          }
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
        
        public void g()
        {
          MyMessagesActivity.this.swipyRefreshLayout.setRefreshing(true);
        }
        
        public void h()
        {
          MyMessagesActivity.this.swipyRefreshLayout.setRefreshing(false);
        }
      });
    }
  }
  
  private void b()
  {
    if (this.g > 0L)
    {
      if (h.l(this)) {
        f.a(this.g, 10, new ad()
        {
          public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
          {
            if (!TextUtils.isEmpty(paramAnonymousString))
            {
              paramAnonymousArrayOfd = (MessageDataInfo)new e().a(paramAnonymousString, MessageDataInfo.class);
              if (paramAnonymousArrayOfd != null)
              {
                MyMessagesActivity.a(MyMessagesActivity.this, paramAnonymousArrayOfd.pageTimeStamp);
                paramAnonymousArrayOfd = paramAnonymousArrayOfd.messageDataItems;
                if ((paramAnonymousArrayOfd != null) && (!paramAnonymousArrayOfd.isEmpty()))
                {
                  MyMessagesActivity.a(MyMessagesActivity.this).addAll(paramAnonymousArrayOfd);
                  MyMessagesActivity.b(MyMessagesActivity.this).notifyDataSetChanged();
                }
              }
            }
          }
          
          public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
          
          public void g()
          {
            MyMessagesActivity.this.swipyRefreshLayout.setRefreshing(true);
          }
          
          public void h()
          {
            MyMessagesActivity.this.swipyRefreshLayout.setRefreshing(false);
          }
        });
      }
      return;
    }
    this.swipyRefreshLayout.setRefreshing(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (q.a().b()) {
        a();
      }
    }
    else {
      return;
    }
    finish();
  }
  
  @OnItemClick(a={2131755285})
  void onClickItemMessage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (MessageDataInfo.MessageData)paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.url))) {
      startActivity(MessageDetailActivity.a(paramAdapterView));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968632);
    ButterKnife.a(this);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.f = paramBundle.getBooleanExtra("new_message_notify", false);
    }
    this.emptyView.setEmptyImg(2130837998);
    if (this.f) {
      this.emptyView.setEmptyText(2131296741);
    }
    for (;;)
    {
      this.messageListView.setEmptyView(this.emptyView);
      paramBundle = this.messageListView;
      UserMessageAdapter localUserMessageAdapter = new UserMessageAdapter(this, this.b);
      this.e = localUserMessageAdapter;
      paramBundle.setAdapter(localUserMessageAdapter);
      this.swipyRefreshLayout.setOnRefreshListener(l.a(this));
      if (!q.a().b()) {
        break;
      }
      a();
      return;
      this.emptyView.setEmptyText(2131296547);
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      VdsAgent.handleClickResult(new Boolean(true));
      return true;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    VdsAgent.handleClickResult(new Boolean(bool));
    return bool;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/MyMessagesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */