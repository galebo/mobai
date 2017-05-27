package com.mobike.mobikeapp.activity.riding;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.a;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.SurprisePlaceholderView;

public class SurpriseRedPackageActivity_ViewBinding
  implements Unbinder
{
  private SurpriseRedPackageActivity b;
  private View c;
  
  @ao
  public SurpriseRedPackageActivity_ViewBinding(SurpriseRedPackageActivity paramSurpriseRedPackageActivity)
  {
    this(paramSurpriseRedPackageActivity, paramSurpriseRedPackageActivity.getWindow().getDecorView());
  }
  
  @ao
  public SurpriseRedPackageActivity_ViewBinding(final SurpriseRedPackageActivity paramSurpriseRedPackageActivity, View paramView)
  {
    this.b = paramSurpriseRedPackageActivity;
    View localView = d.a(paramView, 2131755392, "field 'openButton' and method 'openRedPackage'");
    paramSurpriseRedPackageActivity.openButton = ((Button)d.c(localView, 2131755392, "field 'openButton'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new a()
    {
      public void a(View paramAnonymousView)
      {
        paramSurpriseRedPackageActivity.openRedPackage();
      }
    });
    paramSurpriseRedPackageActivity.imagePackageOpen = ((ImageView)d.b(paramView, 2131755390, "field 'imagePackageOpen'", ImageView.class));
    paramSurpriseRedPackageActivity.imagePackageNotOpen = ((ImageView)d.b(paramView, 2131755391, "field 'imagePackageNotOpen'", ImageView.class));
    paramSurpriseRedPackageActivity.imagePackageContent = ((SurprisePlaceholderView)d.b(paramView, 2131755389, "field 'imagePackageContent'", SurprisePlaceholderView.class));
    paramSurpriseRedPackageActivity.packageMain = ((ImageView)d.b(paramView, 2131755388, "field 'packageMain'", ImageView.class));
    paramSurpriseRedPackageActivity.titleTextView = ((TextView)d.b(paramView, 2131755117, "field 'titleTextView'", TextView.class));
    paramSurpriseRedPackageActivity.subTitleTextView = ((TextView)d.b(paramView, 2131755247, "field 'subTitleTextView'", TextView.class));
  }
  
  @i
  public void a()
  {
    SurpriseRedPackageActivity localSurpriseRedPackageActivity = this.b;
    if (localSurpriseRedPackageActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localSurpriseRedPackageActivity.openButton = null;
    localSurpriseRedPackageActivity.imagePackageOpen = null;
    localSurpriseRedPackageActivity.imagePackageNotOpen = null;
    localSurpriseRedPackageActivity.imagePackageContent = null;
    localSurpriseRedPackageActivity.packageMain = null;
    localSurpriseRedPackageActivity.titleTextView = null;
    localSurpriseRedPackageActivity.subTitleTextView = null;
    this.c.setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/riding/SurpriseRedPackageActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */