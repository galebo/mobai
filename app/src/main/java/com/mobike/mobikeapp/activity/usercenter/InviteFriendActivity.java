package com.mobike.mobikeapp.activity.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import com.google.gson.e;
import com.loopj.android.http.ad;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.MyApplication;
import com.mobike.mobikeapp.activity.login.LoginActivity;
import com.mobike.mobikeapp.model.a.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.util.y;
import com.mobike.mobikeapp.widget.ShareView;
import com.mobike.mobikeapp.widget.j;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import cz.msebera.android.httpclient.d;
import java.net.URLEncoder;
import org.greenrobot.eventbus.c;
import org.json.JSONObject;

public class InviteFriendActivity
  extends BaseActivity
{
  private static final int a = 148;
  private static final int b = 1;
  private static final int e = 22;
  private UMShareListener f;
  @BindView(a=2131755241)
  EditText friendCodeEt;
  @BindView(a=2131755243)
  TextView shareCodeTv;
  @BindView(a=2131755244)
  TextView shareRevampTv;
  @BindView(a=2131755242)
  Button submitFriendCodeBtn;
  
  private int a(String paramString)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    if (i < paramString.length())
    {
      int m = paramString.charAt(i);
      if ((32 <= m) && (m <= 126)) {
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        k += 1;
      }
    }
    return k * 2 + j;
  }
  
  private void a()
  {
    com.mobike.mobikeapp.a.f.d(new ad()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        paramAnonymousArrayOfd = null;
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          paramAnonymousArrayOfd = paramAnonymousString;
        }
        catch (Exception paramAnonymousString)
        {
          JSONObject localJSONObject;
          TextView localTextView;
          InviteFriendActivity localInviteFriendActivity;
          for (;;) {}
        }
        if (paramAnonymousArrayOfd != null)
        {
          paramAnonymousInt = paramAnonymousArrayOfd.optInt("code", -1);
          paramAnonymousString = paramAnonymousArrayOfd.optString("message");
          localJSONObject = paramAnonymousArrayOfd.optJSONObject("object");
          localTextView = InviteFriendActivity.this.shareCodeTv;
          localInviteFriendActivity = InviteFriendActivity.this;
          if (!TextUtils.isEmpty(paramAnonymousString)) {}
          for (paramAnonymousArrayOfd = paramAnonymousString;; paramAnonymousArrayOfd = "N/A")
          {
            localTextView.setText(localInviteFriendActivity.getString(2131296968, new Object[] { paramAnonymousArrayOfd }));
            if ((localJSONObject != null) && (!TextUtils.isEmpty(localJSONObject.optString("sharecode"))))
            {
              InviteFriendActivity.this.friendCodeEt.setEnabled(false);
              InviteFriendActivity.this.friendCodeEt.setText(localJSONObject.optString("sharecode"));
              InviteFriendActivity.this.submitFriendCodeBtn.setEnabled(false);
              InviteFriendActivity.this.submitFriendCodeBtn.setText(2131296398);
            }
            if (paramAnonymousInt != 0) {
              break;
            }
            InviteFriendActivity.this.shareRevampTv.setVisibility(0);
            return;
          }
          InviteFriendActivity.this.shareRevampTv.setVisibility(8);
          return;
        }
        InviteFriendActivity.this.shareCodeTv.setText(InviteFriendActivity.this.getString(2131296968, new Object[] { "N/A" }));
        InviteFriendActivity.this.shareRevampTv.setVisibility(8);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        InviteFriendActivity.this.shareCodeTv.setText(InviteFriendActivity.this.getString(2131296968, new Object[] { "N/A" }));
        InviteFriendActivity.this.shareRevampTv.setVisibility(8);
        com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, InviteFriendActivity.this.getString(2131296965));
      }
    });
  }
  
  private void a(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA))
    {
      y.a().a(this, getString(2131296978), getString(2131296974), c(), "", this.f);
      y.a().a(paramSHARE_MEDIA);
    }
  }
  
  private void b()
  {
    ShareView localShareView = (ShareView)findViewById(2131755245);
    localShareView.a(31);
    localShareView.setOnShareListener(f.a(this));
    this.f = new UMShareListener()
    {
      public void onCancel(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, InviteFriendActivity.this.getString(2131296459));
      }
      
      public void onError(SHARE_MEDIA paramAnonymousSHARE_MEDIA, Throwable paramAnonymousThrowable)
      {
        com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, InviteFriendActivity.this.getString(2131296575));
      }
      
      public void onResult(SHARE_MEDIA paramAnonymousSHARE_MEDIA)
      {
        if (MyApplication.b > com.mobike.mobikeapp.model.c.f.a().o()) {
          new j(InviteFriendActivity.this, "30013", "30011", "30012").show();
        }
        if (com.mobike.mobikeapp.model.c.f.a().g())
        {
          com.mobike.mobikeapp.a.f.a(InviteFriendActivity.this, new com.mobike.mobikeapp.model.b.a()
          {
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              if (paramAnonymous2Int == 200) {
                com.mobike.mobikeapp.model.c.f.a().c(9);
              }
              com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, paramAnonymous2String);
            }
            
            public void a(int paramAnonymous2Int, d[] paramAnonymous2ArrayOfd, JSONObject paramAnonymous2JSONObject)
            {
              paramAnonymous2ArrayOfd = (com.mobike.mobikeapp.model.data.a)new e().a(paramAnonymous2JSONObject.toString(), com.mobike.mobikeapp.model.data.a.class);
              com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, paramAnonymous2ArrayOfd.message);
              c.a().d(new o());
              com.mobike.mobikeapp.model.c.f.a().c(9);
            }
          });
          return;
        }
        com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, InviteFriendActivity.this.getString(2131296986));
      }
      
      public void onStart(SHARE_MEDIA paramAnonymousSHARE_MEDIA) {}
    };
  }
  
  private void b(SHARE_MEDIA paramSHARE_MEDIA)
  {
    if (!com.mobike.mobikeapp.util.a.a(this, paramSHARE_MEDIA)) {
      return;
    }
    y.a().a(this);
    y.a().a(this, getString(2131296970), paramSHARE_MEDIA, this.f);
  }
  
  private String c()
  {
    if (!TextUtils.isEmpty(this.shareCodeTv.getText())) {
      return com.mobike.mobikeapp.c.a.c(URLEncoder.encode(this.shareCodeTv.getText().toString().trim()));
    }
    return "";
  }
  
  @OnTextChanged(a={2131755241}, b=OnTextChanged.Callback.AFTER_TEXT_CHANGED)
  void afterInviteCodeTextChanged(Editable paramEditable)
  {
    int j = paramEditable.length();
    int k = a(paramEditable.toString().trim());
    int i;
    if (22 >= k)
    {
      i = 22 - k;
      paramEditable = this.submitFriendCodeBtn;
      if ((k > 22) || (!this.friendCodeEt.isEnabled())) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      paramEditable.setEnabled(bool);
      this.friendCodeEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i + j) });
      if (k > 22) {
        com.mobike.mobikeapp.model.c.h.a(this, 2131296556);
      }
      return;
      i = 0;
      break;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    UMShareAPI.get(this).onActivityResult(paramInt1, paramInt2, paramIntent);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968622);
    ButterKnife.a(this);
    b();
    this.shareCodeTv.setText(getString(2131296968, new Object[] { "N/A" }));
    if (q.a().b())
    {
      if (com.mobike.mobikeapp.model.c.h.l(this)) {
        a();
      }
      return;
    }
    startActivityForResult(LoginActivity.a(), 1);
  }
  
  @OnClick(a={2131755244})
  void revampShareCode()
  {
    View localView = View.inflate(this, 2130968833, null);
    final EditText localEditText = (EditText)localView.findViewById(2131755905);
    localEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int j = paramAnonymousEditable.length();
        int k = InviteFriendActivity.a(InviteFriendActivity.this, paramAnonymousEditable.toString().trim());
        if (22 >= k) {}
        for (int i = 22 - k;; i = 0)
        {
          localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i + j) });
          if (k > 22) {
            com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, 2131296556);
          }
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    new b.a(this, 2131427642).b(localView).b(17039360, g.a()).a(17039370, h.a(this, localEditText)).c();
  }
  
  @OnClick(a={2131755242})
  void submitFriendCode()
  {
    String str = this.friendCodeEt.getText().toString().trim();
    if (TextUtils.isEmpty(str))
    {
      com.mobike.mobikeapp.model.c.h.a(this, 2131296546);
      return;
    }
    com.mobike.mobikeapp.a.f.i(str, new ad()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        try
        {
          paramAnonymousArrayOfd = new JSONObject(paramAnonymousString);
          if (paramAnonymousArrayOfd != null)
          {
            paramAnonymousInt = paramAnonymousArrayOfd.optInt("code", -1);
            paramAnonymousArrayOfd = paramAnonymousArrayOfd.optString("message");
            if (paramAnonymousInt == 0)
            {
              com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, 2131296555);
              InviteFriendActivity.this.friendCodeEt.setEnabled(false);
              InviteFriendActivity.this.submitFriendCodeBtn.setText(2131296398);
              InviteFriendActivity.this.submitFriendCodeBtn.setEnabled(false);
              c.a().d(new o());
              return;
            }
          }
        }
        catch (Exception paramAnonymousArrayOfd)
        {
          for (;;)
          {
            paramAnonymousArrayOfd = null;
          }
          paramAnonymousString = InviteFriendActivity.this;
          if (!TextUtils.isEmpty(paramAnonymousArrayOfd)) {}
          for (;;)
          {
            com.mobike.mobikeapp.model.c.h.a(paramAnonymousString, paramAnonymousArrayOfd);
            InviteFriendActivity.this.submitFriendCodeBtn.setEnabled(true);
            return;
            paramAnonymousArrayOfd = InviteFriendActivity.this.getString(2131296965);
          }
          com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, InviteFriendActivity.this.getString(2131296965));
          InviteFriendActivity.this.submitFriendCodeBtn.setEnabled(true);
        }
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        com.mobike.mobikeapp.model.c.h.a(InviteFriendActivity.this, InviteFriendActivity.this.getString(2131296965));
        InviteFriendActivity.this.submitFriendCodeBtn.setEnabled(true);
      }
      
      public void g()
      {
        InviteFriendActivity.this.submitFriendCodeBtn.setEnabled(false);
      }
    });
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/InviteFriendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */