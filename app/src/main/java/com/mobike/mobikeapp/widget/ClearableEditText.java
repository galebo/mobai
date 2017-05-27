package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;

public class ClearableEditText
  extends AppCompatEditText
  implements View.OnFocusChangeListener
{
  private Drawable a;
  
  public ClearableEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = getCompoundDrawables()[2];
    if (this.a == null) {
      this.a = ContextCompat.getDrawable(getContext(), 2130837891);
    }
    this.a.setBounds(0, 0, this.a.getIntrinsicWidth(), this.a.getIntrinsicHeight());
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!TextUtils.isEmpty(ClearableEditText.this.getText().toString())) {}
        for (boolean bool = true;; bool = false)
        {
          ClearableEditText.this.setClearDrawableVisible(bool);
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setClearDrawableVisible(false);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      paramBoolean = bool;
      if (!TextUtils.isEmpty(getText().toString())) {
        paramBoolean = true;
      }
      setClearDrawableVisible(paramBoolean);
      return;
    }
    setClearDrawableVisible(false);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    label84:
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getX() > getWidth() - getTotalPaddingRight()) && (paramMotionEvent.getX() < getWidth() - getPaddingRight())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label84;
        }
        setText("");
        break;
      }
    }
  }
  
  protected void setClearDrawableVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Drawable localDrawable = this.a;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      return;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/ClearableEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */