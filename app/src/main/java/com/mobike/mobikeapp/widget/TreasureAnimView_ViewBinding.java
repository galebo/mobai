package com.mobike.mobikeapp.widget;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;

public class TreasureAnimView_ViewBinding
  implements Unbinder
{
  private TreasureAnimView b;
  private View c;
  
  @ao
  public TreasureAnimView_ViewBinding(TreasureAnimView paramTreasureAnimView)
  {
    this(paramTreasureAnimView, paramTreasureAnimView);
  }
  
  @ao
  public TreasureAnimView_ViewBinding(final TreasureAnimView paramTreasureAnimView, View paramView)
  {
    this.b = paramTreasureAnimView;
    View localView = d.a(paramView, 2131755392, "field 'openButton' and method 'openRedPackage'");
    paramTreasureAnimView.openButton = ((Button)d.c(localView, 2131755392, "field 'openButton'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramTreasureAnimView.openRedPackage();
      }
    });
    paramTreasureAnimView.imagePackageOpen = ((ImageView)d.b(paramView, 2131755390, "field 'imagePackageOpen'", ImageView.class));
    paramTreasureAnimView.imagePackageNotOpen = ((ImageView)d.b(paramView, 2131755391, "field 'imagePackageNotOpen'", ImageView.class));
    paramTreasureAnimView.imagePackageContent = ((SurprisePlaceholderView)d.b(paramView, 2131755389, "field 'imagePackageContent'", SurprisePlaceholderView.class));
    paramTreasureAnimView.packageMain = ((ImageView)d.b(paramView, 2131755388, "field 'packageMain'", ImageView.class));
    paramTreasureAnimView.titleTextView = ((TextView)d.b(paramView, 2131755117, "field 'titleTextView'", TextView.class));
    paramTreasureAnimView.subTitleTextView = ((TextView)d.b(paramView, 2131755247, "field 'subTitleTextView'", TextView.class));
  }
  
  @i
  public void a()
  {
    TreasureAnimView localTreasureAnimView = this.b;
    if (localTreasureAnimView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localTreasureAnimView.openButton = null;
    localTreasureAnimView.imagePackageOpen = null;
    localTreasureAnimView.imagePackageNotOpen = null;
    localTreasureAnimView.imagePackageContent = null;
    localTreasureAnimView.packageMain = null;
    localTreasureAnimView.titleTextView = null;
    localTreasureAnimView.subTitleTextView = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/TreasureAnimView_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */