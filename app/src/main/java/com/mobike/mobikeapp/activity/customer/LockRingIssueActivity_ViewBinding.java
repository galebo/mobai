package com.mobike.mobikeapp.activity.customer;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.NonFocusingScrollView;

public class LockRingIssueActivity_ViewBinding
  implements Unbinder
{
  private LockRingIssueActivity b;
  
  @ao
  public LockRingIssueActivity_ViewBinding(LockRingIssueActivity paramLockRingIssueActivity)
  {
    this(paramLockRingIssueActivity, paramLockRingIssueActivity.getWindow().getDecorView());
  }
  
  @ao
  public LockRingIssueActivity_ViewBinding(LockRingIssueActivity paramLockRingIssueActivity, View paramView)
  {
    this.b = paramLockRingIssueActivity;
    paramLockRingIssueActivity.mBikeIdView = ((TextView)d.b(paramView, 2131755301, "field 'mBikeIdView'", TextView.class));
    paramLockRingIssueActivity.mImageView = ((ImageView)d.b(paramView, 2131755744, "field 'mImageView'", ImageView.class));
    paramLockRingIssueActivity.content = ((TextView)d.b(paramView, 2131755224, "field 'content'", TextView.class));
    paramLockRingIssueActivity.mRemark = ((EditText)d.b(paramView, 2131755251, "field 'mRemark'", EditText.class));
    paramLockRingIssueActivity.mEditTextNum = ((TextView)d.b(paramView, 2131755252, "field 'mEditTextNum'", TextView.class));
    paramLockRingIssueActivity.mSubmitBtn = ((Button)d.b(paramView, 2131755197, "field 'mSubmitBtn'", Button.class));
    paramLockRingIssueActivity.mCustomerAccess = ((ImageView)d.b(paramView, 2131755254, "field 'mCustomerAccess'", ImageView.class));
    paramLockRingIssueActivity.mCustomerTitle = ((TextView)d.b(paramView, 2131755255, "field 'mCustomerTitle'", TextView.class));
    paramLockRingIssueActivity.mScrollView = ((NonFocusingScrollView)d.b(paramView, 2131755181, "field 'mScrollView'", NonFocusingScrollView.class));
  }
  
  @i
  public void a()
  {
    LockRingIssueActivity localLockRingIssueActivity = this.b;
    if (localLockRingIssueActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localLockRingIssueActivity.mBikeIdView = null;
    localLockRingIssueActivity.mImageView = null;
    localLockRingIssueActivity.content = null;
    localLockRingIssueActivity.mRemark = null;
    localLockRingIssueActivity.mEditTextNum = null;
    localLockRingIssueActivity.mSubmitBtn = null;
    localLockRingIssueActivity.mCustomerAccess = null;
    localLockRingIssueActivity.mCustomerTitle = null;
    localLockRingIssueActivity.mScrollView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/customer/LockRingIssueActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */