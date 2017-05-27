package com.mobike.mobikeapp.activity.usercenter;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;

public class InviteFriendActivity_ViewBinding
  implements Unbinder
{
  private InviteFriendActivity b;
  private View c;
  private View d;
  private TextWatcher e;
  private View f;
  
  @ao
  public InviteFriendActivity_ViewBinding(InviteFriendActivity paramInviteFriendActivity)
  {
    this(paramInviteFriendActivity, paramInviteFriendActivity.getWindow().getDecorView());
  }
  
  @ao
  public InviteFriendActivity_ViewBinding(final InviteFriendActivity paramInviteFriendActivity, View paramView)
  {
    this.b = paramInviteFriendActivity;
    paramInviteFriendActivity.shareCodeTv = ((TextView)d.b(paramView, 2131755243, "field 'shareCodeTv'", TextView.class));
    View localView = d.a(paramView, 2131755244, "field 'shareRevampTv' and method 'revampShareCode'");
    paramInviteFriendActivity.shareRevampTv = ((TextView)d.c(localView, 2131755244, "field 'shareRevampTv'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramInviteFriendActivity.revampShareCode();
      }
    });
    localView = d.a(paramView, 2131755241, "field 'friendCodeEt' and method 'afterInviteCodeTextChanged'");
    paramInviteFriendActivity.friendCodeEt = ((EditText)d.c(localView, 2131755241, "field 'friendCodeEt'", EditText.class));
    this.d = localView;
    this.e = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramInviteFriendActivity.afterInviteCodeTextChanged(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    ((TextView)localView).addTextChangedListener(this.e);
    paramView = d.a(paramView, 2131755242, "field 'submitFriendCodeBtn' and method 'submitFriendCode'");
    paramInviteFriendActivity.submitFriendCodeBtn = ((Button)d.c(paramView, 2131755242, "field 'submitFriendCodeBtn'", Button.class));
    this.f = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramInviteFriendActivity.submitFriendCode();
      }
    });
  }
  
  @i
  public void a()
  {
    InviteFriendActivity localInviteFriendActivity = this.b;
    if (localInviteFriendActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localInviteFriendActivity.shareCodeTv = null;
    localInviteFriendActivity.shareRevampTv = null;
    localInviteFriendActivity.friendCodeEt = null;
    localInviteFriendActivity.submitFriendCodeBtn = null;
    this.c.setOnClickListener(null);
    this.c = null;
    ((TextView)this.d).removeTextChangedListener(this.e);
    this.e = null;
    this.d = null;
    this.f.setOnClickListener(null);
    this.f = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/InviteFriendActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */