package com.mobike.mobikeapp.model;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ab;
import android.support.annotation.y;
import android.support.v4.util.Pair;
import android.support.v7.app.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.mobike.mobikeapp.model.c.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
  extends b
{
  @y
  int d;
  protected View e;
  private int f = 0;
  private int g;
  private List<Pair<Integer, View.OnClickListener>> h = new ArrayList();
  private List<Pair<Integer, CharSequence>> i;
  
  public a(Context paramContext)
  {
    this(paramContext, R.style.BaseDialogStyle);
  }
  
  protected a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void c(View paramView)
  {
    if (paramView != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        paramView.findViewById(((Integer)localPair.first).intValue()).setOnClickListener((View.OnClickListener)localPair.second);
      }
    }
  }
  
  public a a(Pair<Integer, CharSequence> paramPair)
  {
    this.i = Collections.singletonList(paramPair);
    return this;
  }
  
  public a a(List<Pair<Integer, View.OnClickListener>> paramList)
  {
    this.h.addAll(paramList);
    return this;
  }
  
  public a b(@ab List<Pair<Integer, CharSequence>> paramList)
  {
    this.i = paramList;
    return this;
  }
  
  public a e(@y int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public a f(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public a g(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().clearFlags(131080);
    if (this.d != 0)
    {
      this.e = View.inflate(getContext(), this.d, null);
      if (this.h != null) {
        c(this.e);
      }
      if (this.i != null)
      {
        paramBundle = this.i.iterator();
        while (paramBundle.hasNext())
        {
          Pair localPair = (Pair)paramBundle.next();
          TextView localTextView = (TextView)this.e.findViewById(((Integer)localPair.first).intValue());
          if (localTextView != null) {
            localTextView.setText((CharSequence)localPair.second);
          }
        }
      }
      setContentView(this.e);
      paramBundle = getWindow().getAttributes();
      if (this.f != 0) {
        paramBundle.width = h.a(getContext(), this.f);
      }
      if (this.g != 0) {
        paramBundle.height = h.a(getContext(), this.g);
      }
      getWindow().setAttributes(paramBundle);
      return;
    }
    super.dismiss();
    throw new IllegalArgumentException("lost contentView ");
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */