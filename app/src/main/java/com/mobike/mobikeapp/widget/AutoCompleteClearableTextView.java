package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AutoCompleteTextView;
import com.mobike.mobikeapp.model.c.h;

public class AutoCompleteClearableTextView
  extends AutoCompleteTextView
{
  private static final int a = 4;
  private static final int b = 3;
  private Drawable c;
  
  public AutoCompleteClearableTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AutoCompleteClearableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AutoCompleteClearableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = getCompoundDrawables()[2];
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!TextUtils.isEmpty(AutoCompleteClearableTextView.this.getText().toString())) {}
        for (boolean bool = true;; bool = false)
        {
          AutoCompleteClearableTextView.this.setClearDrawableVisible(bool);
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setClearDrawableVisible(false);
  }
  
  public boolean enoughToFilter()
  {
    return true;
  }
  
  public void onFilterComplete(int paramInt)
  {
    int i = Math.min(paramInt, 4);
    int j = getHeight();
    setDropDownHeight(i * h.a(getContext(), 3.0F) + j * i);
    super.onFilterComplete(paramInt);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (getAdapter() != null)) {
      performFiltering(getText(), 0);
    }
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
  
  public void setClearDrawableVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Drawable localDrawable = this.c;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      return;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/AutoCompleteClearableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */