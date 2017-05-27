package com.mobike.mobikeapp.activity.login;

import android.annotation.SuppressLint;
import android.support.annotation.ao;
import android.support.annotation.i;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.LoadingToastView;

public class IDCardVerifyActivity_ViewBinding
  implements Unbinder
{
  private IDCardVerifyActivity b;
  private View c;
  private TextWatcher d;
  private View e;
  private TextWatcher f;
  private View g;
  private View h;
  private View i;
  
  @ao
  public IDCardVerifyActivity_ViewBinding(IDCardVerifyActivity paramIDCardVerifyActivity)
  {
    this(paramIDCardVerifyActivity, paramIDCardVerifyActivity.getWindow().getDecorView());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  @ao
  public IDCardVerifyActivity_ViewBinding(final IDCardVerifyActivity paramIDCardVerifyActivity, View paramView)
  {
    this.b = paramIDCardVerifyActivity;
    paramIDCardVerifyActivity.mVerifyIDCardForm = ((ScrollView)d.b(paramView, 2131755208, "field 'mVerifyIDCardForm'", ScrollView.class));
    paramIDCardVerifyActivity.mProgressView = ((LoadingToastView)d.b(paramView, 2131755754, "field 'mProgressView'", LoadingToastView.class));
    View localView = d.a(paramView, 2131755210, "field 'mIDCardNameView', method 'onNameTextChanged', method 'afterNameTextChanged', and method 'onTouchCardName'");
    paramIDCardVerifyActivity.mIDCardNameView = ((EditText)d.c(localView, 2131755210, "field 'mIDCardNameView'", EditText.class));
    this.c = localView;
    this.d = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramIDCardVerifyActivity.afterNameTextChanged(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramIDCardVerifyActivity.onNameTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
    };
    ((TextView)localView).addTextChangedListener(this.d);
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return paramIDCardVerifyActivity.onTouchCardName();
      }
    });
    localView = d.a(paramView, 2131755211, "field 'mIDCardNoView', method 'afterNameTextChanged', and method 'onTouchCardName'");
    paramIDCardVerifyActivity.mIDCardNoView = ((EditText)d.c(localView, 2131755211, "field 'mIDCardNoView'", EditText.class));
    this.e = localView;
    this.f = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramIDCardVerifyActivity.afterNameTextChanged(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    ((TextView)localView).addTextChangedListener(this.f);
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return paramIDCardVerifyActivity.onTouchCardName();
      }
    });
    localView = d.a(paramView, 2131755212, "field 'mVerifyBtn' and method 'onClickVerify'");
    paramIDCardVerifyActivity.mVerifyBtn = ((Button)d.c(localView, 2131755212, "field 'mVerifyBtn'", Button.class));
    this.g = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramIDCardVerifyActivity.onClickVerify();
      }
    });
    paramIDCardVerifyActivity.mProgressDot = ((ImageView)d.b(paramView, 2131755977, "field 'mProgressDot'", ImageView.class));
    paramIDCardVerifyActivity.mPendingView = d.a(paramView, 2131755214, "field 'mPendingView'");
    paramIDCardVerifyActivity.mRejectedView = d.a(paramView, 2131755215, "field 'mRejectedView'");
    paramIDCardVerifyActivity.mEditView = d.a(paramView, 2131755209, "field 'mEditView'");
    localView = d.a(paramView, 2131755217, "method 'onClickRedo'");
    this.h = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramIDCardVerifyActivity.onClickRedo();
      }
    });
    paramView = d.a(paramView, 2131755213, "method 'onClickNoId'");
    this.i = paramView;
    paramView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramIDCardVerifyActivity.onClickNoId();
      }
    });
  }
  
  @i
  public void a()
  {
    IDCardVerifyActivity localIDCardVerifyActivity = this.b;
    if (localIDCardVerifyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localIDCardVerifyActivity.mVerifyIDCardForm = null;
    localIDCardVerifyActivity.mProgressView = null;
    localIDCardVerifyActivity.mIDCardNameView = null;
    localIDCardVerifyActivity.mIDCardNoView = null;
    localIDCardVerifyActivity.mVerifyBtn = null;
    localIDCardVerifyActivity.mProgressDot = null;
    localIDCardVerifyActivity.mPendingView = null;
    localIDCardVerifyActivity.mRejectedView = null;
    localIDCardVerifyActivity.mEditView = null;
    ((TextView)this.c).removeTextChangedListener(this.d);
    this.d = null;
    this.c.setOnTouchListener(null);
    this.c = null;
    ((TextView)this.e).removeTextChangedListener(this.f);
    this.f = null;
    this.e.setOnTouchListener(null);
    this.e = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/login/IDCardVerifyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */