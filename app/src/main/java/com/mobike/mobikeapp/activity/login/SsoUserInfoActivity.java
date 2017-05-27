package com.mobike.mobikeapp.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.bumptech.glide.o;
import com.google.gson.b.a;
import com.google.gson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.data.SsoUserInfo;
import com.mobike.mobikeapp.util.q;
import cz.msebera.android.httpclient.d;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SsoUserInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = "com.mobike.intent.sso.extra.info";
  private SsoUserInfo b;
  @BindView(a=2131755378)
  TextView mBindingSourceTv;
  @BindView(a=2131755377)
  CircleImageView mCircleImageView;
  @BindView(a=2131755184)
  TextView mNameTv;
  @BindView(a=2131755379)
  TextView mRulesTv;
  @BindView(a=2131755380)
  TextView mUnbindTv;
  
  @Instrumented
  public void onClick(final View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    String str2 = this.b.getUserId();
    if (this.b.getSource() == 0) {}
    for (String str1 = "WX_APP";; str1 = "QQ")
    {
      com.mobike.mobikeapp.a.f.c(str2, str1, new ad()
      {
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
        {
          paramAnonymousString = q.a().h(SsoUserInfoActivity.this);
          paramAnonymousArrayOfd = new e();
          Object localObject = (List)paramAnonymousArrayOfd.a(paramAnonymousString, new a() {}.b());
          paramAnonymousString = new ArrayList();
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              SsoUserInfo localSsoUserInfo = (SsoUserInfo)((Iterator)localObject).next();
              if (localSsoUserInfo.getSource() != SsoUserInfoActivity.a(SsoUserInfoActivity.this).getSource()) {
                paramAnonymousString.add(localSsoUserInfo);
              }
            }
          }
          q.a().c(SsoUserInfoActivity.this, paramAnonymousArrayOfd.b(paramAnonymousString));
          paramAnonymousArrayOfd = Toast.makeText(SsoUserInfoActivity.this, SsoUserInfoActivity.this.getString(2131297082), 0);
          if (!(paramAnonymousArrayOfd instanceof Toast)) {
            paramAnonymousArrayOfd.show();
          }
          for (;;)
          {
            SsoUserInfoActivity.this.finish();
            return;
            VdsAgent.showToast((Toast)paramAnonymousArrayOfd);
          }
        }
        
        public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
        
        public void g()
        {
          paramView.setEnabled(false);
        }
        
        public void h()
        {
          paramView.setEnabled(true);
        }
      });
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968653);
    ButterKnife.a(this);
    this.b = ((SsoUserInfo)getIntent().getSerializableExtra("com.mobike.intent.sso.extra.info"));
    this.mNameTv.setText(this.b.getUserName());
    int i = this.b.getSource();
    if (i == 0)
    {
      paramBundle = getString(2131297146);
      setTitle(paramBundle);
      TextView localTextView = this.mRulesTv;
      if (i != 0) {
        break label169;
      }
      paramBundle = getString(2131297001);
      label86:
      localTextView.setText(paramBundle);
      localTextView = this.mBindingSourceTv;
      if (i != 0) {
        break label179;
      }
      paramBundle = getString(2131296992);
      label107:
      localTextView.setText(paramBundle);
      paramBundle = l.a(this).a(this.b.getUserAvatar());
      if (i != 0) {
        break label189;
      }
    }
    label169:
    label179:
    label189:
    for (i = 2130838319;; i = 2130838073)
    {
      paramBundle.d(i).g().a(this.mCircleImageView);
      this.mUnbindTv.setOnClickListener(this);
      return;
      paramBundle = getString(2131296812);
      break;
      paramBundle = getString(2131297000);
      break label86;
      paramBundle = getString(2131296991);
      break label107;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/SsoUserInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */