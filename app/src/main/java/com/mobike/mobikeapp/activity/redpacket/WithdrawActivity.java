package com.mobike.mobikeapp.activity.redpacket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ac;
import android.support.v7.app.b;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import com.google.gson.JsonSyntaxException;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.n;
import com.growingio.android.sdk.agent.VdsAgent;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.activity.customer.CustomerServiceWebActivity;
import com.mobike.mobikeapp.adapter.WithdrawMethodAdapter;
import com.mobike.mobikeapp.adapter.WithdrawMethodAdapter.a;
import com.mobike.mobikeapp.c.a;
import com.mobike.mobikeapp.data.CurrencyEnum;
import com.mobike.mobikeapp.data.RedPacketData.DataBean;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;
import com.mobike.mobikeapp.widget.r;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import cz.msebera.android.httpclient.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WithdrawActivity
  extends BaseActivity
{
  private RedPacketData.DataBean a;
  private WithdrawMethodAdapter b;
  @BindView(a=2131755754)
  LoadingToastView loadingToastView;
  @BindView(a=2131755925)
  TextView mFAQTv;
  @BindView(a=2131755422)
  Button mWithdrawBtn;
  @BindView(a=2131755421)
  ListView mWithdrawLv;
  @BindView(a=2131755420)
  TextView mWithdrawTv;
  
  private void a()
  {
    a(null, null, null, null, null);
  }
  
  private void a(final String paramString1, final String paramString2, String paramString3, String paramString4, String paramString5)
  {
    f.a(paramString1, paramString2, paramString4, paramString3, paramString5, new ad()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        try
        {
          paramAnonymousArrayOfd = new n().a(paramAnonymousString);
          if ((paramAnonymousArrayOfd != null) && (paramAnonymousArrayOfd.q()))
          {
            paramAnonymousInt = paramAnonymousArrayOfd.t().c("code").j();
            paramAnonymousArrayOfd = paramAnonymousArrayOfd.t().c("message").d();
            if (paramAnonymousInt == 0)
            {
              paramAnonymousString = (WithdrawMethodAdapter.a)WithdrawActivity.a(WithdrawActivity.this).getItem(WithdrawActivity.a(WithdrawActivity.this).a());
              paramAnonymousString.b = true;
              paramAnonymousString.d = paramString1;
              paramAnonymousString.c = paramString2;
              WithdrawActivity.this.mWithdrawLv.post(i.a(this));
              if (TextUtils.isEmpty(paramAnonymousArrayOfd))
              {
                paramAnonymousArrayOfd = new r(WithdrawActivity.this);
                paramAnonymousArrayOfd.setOnDismissListener(j.a(this));
                paramAnonymousArrayOfd.show();
                return;
              }
            }
          }
        }
        catch (JsonSyntaxException paramAnonymousArrayOfd)
        {
          for (;;)
          {
            paramAnonymousArrayOfd = null;
            continue;
            paramAnonymousArrayOfd = new r(WithdrawActivity.this, true, paramAnonymousArrayOfd);
          }
          new r(WithdrawActivity.this, false, paramAnonymousArrayOfd).show();
          return;
        }
        paramAnonymousArrayOfd = Toast.makeText(WithdrawActivity.this, WithdrawActivity.this.getString(2131296707), 0);
        if (!(paramAnonymousArrayOfd instanceof Toast))
        {
          paramAnonymousArrayOfd.show();
          return;
        }
        VdsAgent.showToast((Toast)paramAnonymousArrayOfd);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        paramAnonymousArrayOfd = Toast.makeText(WithdrawActivity.this, WithdrawActivity.this.getString(2131296707), 0);
        if (!(paramAnonymousArrayOfd instanceof Toast))
        {
          paramAnonymousArrayOfd.show();
          return;
        }
        VdsAgent.showToast((Toast)paramAnonymousArrayOfd);
      }
      
      public void g()
      {
        WithdrawActivity.this.loadingToastView.setLoadingText(2131296319);
        WithdrawActivity.this.loadingToastView.a();
        WithdrawActivity.this.mWithdrawBtn.setEnabled(false);
      }
      
      public void h()
      {
        WithdrawActivity.this.loadingToastView.b();
        WithdrawActivity.this.mWithdrawBtn.setEnabled(true);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @OnClick(a={2131755925})
  void onClickFAQ()
  {
    int j = 0;
    String str = getString(2131296697);
    int i;
    if (this.a == null)
    {
      i = 0;
      if (this.a != null) {
        break label51;
      }
    }
    for (;;)
    {
      startActivity(CustomerServiceWebActivity.a(this, str, a.a(i, j)));
      return;
      i = this.a.getWithdrawMaxFee();
      break;
      label51:
      j = this.a.getWithdrawMaxTimesOneday();
    }
  }
  
  @OnClick(a={2131755422})
  void onClickWithdraw()
  {
    Object localObject = (WithdrawMethodAdapter.a)this.b.getItem(this.b.a());
    switch (((WithdrawMethodAdapter.a)localObject).a)
    {
    default: 
      return;
    case 1: 
      localObject = new Intent(this, AlipayWithdrawActivity.class);
      ((Intent)localObject).putExtra("redPacketInfo", this.a);
      startActivity((Intent)localObject);
      finish();
      return;
    }
    if (((WithdrawMethodAdapter.a)localObject).b)
    {
      a();
      return;
    }
    UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, new UMAuthListener()
    {
      public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA, int paramAnonymousInt)
      {
        paramAnonymousSHARE_MEDIA = Toast.makeText(WithdrawActivity.this, WithdrawActivity.this.getString(2131296712), 0);
        if (!(paramAnonymousSHARE_MEDIA instanceof Toast)) {
          paramAnonymousSHARE_MEDIA.show();
        }
        for (;;)
        {
          WithdrawActivity.this.loadingToastView.b();
          WithdrawActivity.this.mWithdrawBtn.setEnabled(true);
          return;
          VdsAgent.showToast((Toast)paramAnonymousSHARE_MEDIA);
        }
      }
      
      public void onComplete(SHARE_MEDIA paramAnonymousSHARE_MEDIA, int paramAnonymousInt, Map<String, String> paramAnonymousMap)
      {
        paramAnonymousSHARE_MEDIA = (String)paramAnonymousMap.get("name");
        String str1 = (String)paramAnonymousMap.get("expiration");
        String str2 = (String)paramAnonymousMap.get("iconurl");
        String str3 = (String)paramAnonymousMap.get("openid");
        paramAnonymousMap = (String)paramAnonymousMap.get("unionid");
        WithdrawActivity.a(WithdrawActivity.this, paramAnonymousSHARE_MEDIA, str2, str3, paramAnonymousMap, str1);
      }
      
      public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        paramAnonymousSHARE_MEDIA = Toast.makeText(WithdrawActivity.this, WithdrawActivity.this.getString(2131296712), 0);
        if (!(paramAnonymousSHARE_MEDIA instanceof Toast)) {
          paramAnonymousSHARE_MEDIA.show();
        }
        for (;;)
        {
          WithdrawActivity.this.loadingToastView.b();
          WithdrawActivity.this.mWithdrawBtn.setEnabled(true);
          return;
          VdsAgent.showToast((Toast)paramAnonymousSHARE_MEDIA);
        }
      }
      
      public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        WithdrawActivity.this.loadingToastView.setLoadingText(2131296319);
        WithdrawActivity.this.loadingToastView.a();
        WithdrawActivity.this.mWithdrawBtn.setEnabled(false);
      }
    });
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968664);
    ButterKnife.a(this);
    if ((getIntent() != null) && (getIntent().hasExtra("redPacketInfo"))) {
      this.a = ((RedPacketData.DataBean)getIntent().getSerializableExtra("redPacketInfo"));
    }
    label179:
    int i;
    final WithdrawMethodAdapter.a locala;
    if (this.a != null)
    {
      paramBundle = String.format("%.2f", new Object[] { Float.valueOf(this.a.getTotal() / 100.0F) });
      this.mWithdrawTv.setText(q.a().j().getPrefixSymbol() + " " + paramBundle);
      this.mFAQTv.setText(2131296697);
      this.mFAQTv.setVisibility(0);
      if ((this.a == null) || (this.a.getWithdrawOrder() == null)) {
        break label386;
      }
      paramBundle = new ArrayList();
      Iterator localIterator = this.a.getWithdrawOrder().iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        switch (i)
        {
        }
      }
      locala = new WithdrawMethodAdapter.a();
      locala.a = i;
      if (this.a.getAlreadyBind() != 1) {
        break label356;
      }
    }
    label356:
    for (boolean bool = true;; bool = false)
    {
      locala.b = bool;
      locala.c = this.a.getAvatar();
      locala.d = this.a.getNickName();
      locala.e = new ad()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
          i = -1;
          try
          {
            paramAnonymousArrayOfd = new n().a(paramAnonymousString);
            paramAnonymousInt = i;
            if (paramAnonymousArrayOfd.q())
            {
              paramAnonymousInt = i;
              if (paramAnonymousArrayOfd.t().b("code")) {
                paramAnonymousInt = paramAnonymousArrayOfd.t().c("code").j();
              }
            }
          }
          catch (JsonSyntaxException paramAnonymousArrayOfd)
          {
            for (;;)
            {
              WithdrawActivity localWithdrawActivity;
              paramAnonymousInt = i;
            }
          }
          locala.b = false;
          locala.c = "";
          locala.d = "";
          WithdrawActivity.this.mWithdrawLv.post(h.a(this));
          paramAnonymousArrayOfd = WithdrawActivity.this.getString(2131296717);
          paramAnonymousString = WithdrawActivity.this.getString(2131296716);
          localWithdrawActivity = WithdrawActivity.this;
          if (paramAnonymousInt == 0) {}
          for (;;)
          {
            paramAnonymousArrayOfd = Toast.makeText(localWithdrawActivity, paramAnonymousArrayOfd, 0);
            if ((paramAnonymousArrayOfd instanceof Toast)) {
              break;
            }
            paramAnonymousArrayOfd.show();
            return;
            paramAnonymousArrayOfd = paramAnonymousString;
          }
          VdsAgent.showToast((Toast)paramAnonymousArrayOfd);
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
        
        public void g()
        {
          WithdrawActivity.this.loadingToastView.setLoadingText(2131296718);
          WithdrawActivity.this.loadingToastView.a();
          WithdrawActivity.this.mWithdrawBtn.setEnabled(false);
        }
        
        public void h()
        {
          WithdrawActivity.this.loadingToastView.b();
          WithdrawActivity.this.mWithdrawBtn.setEnabled(true);
        }
      };
      paramBundle.add(locala);
      break label179;
      paramBundle = "0";
      break;
      locala = new WithdrawMethodAdapter.a();
      locala.a = i;
      locala.b = false;
      paramBundle.add(locala);
      break label179;
    }
    this.b = new WithdrawMethodAdapter(this, paramBundle);
    this.mWithdrawLv.setAdapter(this.b);
    return;
    label386:
    this.mWithdrawBtn.setEnabled(false);
  }
  
  @OnItemClick(a={2131755421})
  void onItemClickMethod(int paramInt)
  {
    this.b.a(paramInt);
    this.b.notifyDataSetChanged();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/redpacket/WithdrawActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */