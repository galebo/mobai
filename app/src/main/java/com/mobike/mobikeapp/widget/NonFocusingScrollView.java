package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import java.util.ArrayList;

public class NonFocusingScrollView
  extends ScrollView
{
  public NonFocusingScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NonFocusingScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NonFocusingScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ArrayList<View> getFocusables(int paramInt)
  {
    return new ArrayList();
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    return true;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/NonFocusingScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */