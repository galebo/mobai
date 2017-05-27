package com.mobike.mobikeapp.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.mobike.mobikeapp.model.a;
import java.util.Arrays;

public class r
  extends a
{
  private boolean f;
  private String g;
  
  public r(Context paramContext)
  {
    super(paramContext);
    this.f = true;
    this.g = null;
    b();
  }
  
  public r(Context paramContext, boolean paramBoolean, String paramString)
  {
    super(paramContext);
    this.f = paramBoolean;
    this.g = paramString;
    b();
  }
  
  private void b()
  {
    a locala = e(2130968699).f(288).a(Arrays.asList(new Pair[] { new Pair(Integer.valueOf(2131755523), s.a(this)) }));
    Pair localPair;
    if (this.f)
    {
      str = getContext().getString(2131296706);
      localPair = new Pair(Integer.valueOf(2131755521), str);
      if ((TextUtils.isEmpty(this.g)) && (this.f)) {
        break label141;
      }
    }
    label141:
    for (String str = this.g;; str = getContext().getString(2131296708))
    {
      locala.b(Arrays.asList(new Pair[] { localPair, new Pair(Integer.valueOf(2131755522), str) }));
      return;
      str = getContext().getString(2131296707);
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (ImageView)this.e.findViewById(2131755520);
    if (this.f) {}
    for (int i = 2130838109;; i = 2130838108)
    {
      paramBundle.setImageResource(i);
      return;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */