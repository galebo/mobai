package com.mobike.mobikeapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.mobike.mobikeapp.activity.usercenter.MessageDetailActivity;
import com.mobike.mobikeapp.data.MessageDataInfo.MessageData;
import com.mobike.mobikeapp.data.OperationCardData;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.DragViewLayout;
import com.mobike.mobikeapp.widget.DragViewLayout.a;
import com.mobike.mobikeapp.widget.HintCardView;
import com.umeng.analytics.MobclickAgent;

public class OperationDialogFragment
  extends DialogFragment
  implements DialogInterface.OnKeyListener, DragViewLayout.a
{
  private static OperationDialogFragment e;
  private static final int i = 500;
  long a;
  private HintCardView b;
  private OperationCardData c;
  private boolean d;
  private ObjectAnimator f;
  private ObjectAnimator g;
  private long h;
  
  public static OperationDialogFragment a()
  {
    return e;
  }
  
  public static OperationDialogFragment a(Bundle paramBundle)
  {
    e = new OperationDialogFragment();
    e.setArguments(paramBundle);
    return e;
  }
  
  private String a(String paramString)
  {
    String str = "uid=" + q.a().d();
    if (paramString.contains("?")) {
      return paramString + "&" + str;
    }
    return paramString + "?" + str;
  }
  
  private void a(ObjectAnimator paramObjectAnimator)
  {
    a(paramObjectAnimator, null);
  }
  
  private void a(ObjectAnimator paramObjectAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.d = true;
    if (paramAnimatorListenerAdapter == null) {
      paramObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          OperationDialogFragment.this.dismiss();
        }
      });
    }
    for (;;)
    {
      paramObjectAnimator.setDuration(500L);
      paramObjectAnimator.start();
      return;
      paramObjectAnimator.addListener(paramAnimatorListenerAdapter);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(this.f);
      return;
    }
    a(this.g);
  }
  
  private void e()
  {
    String str = this.c.body.replace('^', '\n');
    this.b.a(this.c.title, str, this.c.imgUrl, this.c.jumpTitle);
    this.b.setColseOnclickListener(bo.a(this));
    if (!TextUtils.isEmpty(this.c.jumpTitle)) {
      this.b.setJumpOnclickListener(bp.a(this));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void b()
  {
    this.b.d();
  }
  
  public void c()
  {
    this.b.c();
  }
  
  public void d()
  {
    long l1 = 0L;
    long l2 = 500L - (System.currentTimeMillis() - this.h);
    if (l2 < 0L) {}
    for (;;)
    {
      this.b.postDelayed(bq.a(this), l1);
      return;
      l1 = l2;
    }
  }
  
  public void dismiss()
  {
    if (!this.d)
    {
      b(false);
      return;
    }
    int j = (int)((System.currentTimeMillis() - this.a) / 1000L);
    MobclickAgent.a(getActivity(), "90002", null, j);
    super.dismissAllowingStateLoss();
    e = null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = ((OperationCardData)getArguments().getParcelable("info"));
  }
  
  @ab
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.requestWindowFeature(1);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getWindow().getAttributes();
    localLayoutParams.height = -2;
    localLayoutParams.windowAnimations = 2131427555;
    paramBundle.getWindow().setAttributes(localLayoutParams);
    setCancelable(false);
    paramBundle.setOnKeyListener(this);
    return paramBundle;
  }
  
  @ac
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968746, paramViewGroup);
    this.b = ((HintCardView)paramLayoutInflater.findViewById(2131755636));
    ((DragViewLayout)paramLayoutInflater.findViewById(2131755635)).setmListener(this);
    this.b.a(h.m(getActivity()) - h.a(getActivity(), 45.0F), 0.4F);
    this.h = System.currentTimeMillis();
    e();
    this.a = System.currentTimeMillis();
    this.f = ObjectAnimator.ofPropertyValuesHolder(this.b, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("translationY", new float[] { 0 - h.o(getActivity()) }) });
    this.g = ObjectAnimator.ofPropertyValuesHolder(this.b, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("translationY", new float[] { h.o(getActivity()) }) });
    return paramLayoutInflater;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onStart()
  {
    super.onStart();
    Dialog localDialog = getDialog();
    if (localDialog != null)
    {
      localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      localDialog.getWindow().setLayout(-1, -1);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/OperationDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */