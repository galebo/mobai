package com.mobike.mobikeapp.widget;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.d;

public class RideInfoOverlay_ViewBinding
  implements Unbinder
{
  private RideInfoOverlay b;
  
  @ao
  public RideInfoOverlay_ViewBinding(RideInfoOverlay paramRideInfoOverlay)
  {
    this(paramRideInfoOverlay, paramRideInfoOverlay);
  }
  
  @ao
  public RideInfoOverlay_ViewBinding(RideInfoOverlay paramRideInfoOverlay, View paramView)
  {
    this.b = paramRideInfoOverlay;
    paramRideInfoOverlay.mBikeCodeView = ((TextView)d.b(paramView, 2131755897, "field 'mBikeCodeView'", TextView.class));
    paramRideInfoOverlay.mRideDurationHourView = ((TextView)d.b(paramView, 2131755892, "field 'mRideDurationHourView'", TextView.class));
    paramRideInfoOverlay.mRideDurationHourUnit = ((TextView)d.b(paramView, 2131755893, "field 'mRideDurationHourUnit'", TextView.class));
    paramRideInfoOverlay.mRideDurationMinuteView = ((TextView)d.b(paramView, 2131755894, "field 'mRideDurationMinuteView'", TextView.class));
    paramRideInfoOverlay.mRideDistanceView = ((TextView)d.b(paramView, 2131755896, "field 'mRideDistanceView'", TextView.class));
    paramRideInfoOverlay.mRideConsumptionView = ((TextView)d.b(paramView, 2131755479, "field 'mRideConsumptionView'", TextView.class));
    paramRideInfoOverlay.mCostView = ((TextView)d.b(paramView, 2131755898, "field 'mCostView'", TextView.class));
    paramRideInfoOverlay.mLockIssueButton = ((Button)d.b(paramView, 2131755891, "field 'mLockIssueButton'", Button.class));
    paramRideInfoOverlay.mRedPacketRootView = d.a(paramView, 2131755878, "field 'mRedPacketRootView'");
    paramRideInfoOverlay.mRedPacketUnlockView = d.a(paramView, 2131755879, "field 'mRedPacketUnlockView'");
    paramRideInfoOverlay.mRedPacketMarkerView = d.a(paramView, 2131755882, "field 'mRedPacketMarkerView'");
    paramRideInfoOverlay.mProgressBar = ((ProgressBar)d.b(paramView, 2131755880, "field 'mProgressBar'", ProgressBar.class));
    paramRideInfoOverlay.mImageView = ((CheckBox)d.b(paramView, 2131755881, "field 'mImageView'", CheckBox.class));
    paramRideInfoOverlay.mRightArrow = ((ImageView)d.b(paramView, 2131755885, "field 'mRightArrow'", ImageView.class));
    paramRideInfoOverlay.mRedPacketHint = ((TextView)d.b(paramView, 2131755884, "field 'mRedPacketHint'", TextView.class));
    paramRideInfoOverlay.mLogoView = ((ImageView)d.b(paramView, 2131755883, "field 'mLogoView'", ImageView.class));
  }
  
  @i
  public void a()
  {
    RideInfoOverlay localRideInfoOverlay = this.b;
    if (localRideInfoOverlay == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localRideInfoOverlay.mBikeCodeView = null;
    localRideInfoOverlay.mRideDurationHourView = null;
    localRideInfoOverlay.mRideDurationHourUnit = null;
    localRideInfoOverlay.mRideDurationMinuteView = null;
    localRideInfoOverlay.mRideDistanceView = null;
    localRideInfoOverlay.mRideConsumptionView = null;
    localRideInfoOverlay.mCostView = null;
    localRideInfoOverlay.mLockIssueButton = null;
    localRideInfoOverlay.mRedPacketRootView = null;
    localRideInfoOverlay.mRedPacketUnlockView = null;
    localRideInfoOverlay.mRedPacketMarkerView = null;
    localRideInfoOverlay.mProgressBar = null;
    localRideInfoOverlay.mImageView = null;
    localRideInfoOverlay.mRightArrow = null;
    localRideInfoOverlay.mRedPacketHint = null;
    localRideInfoOverlay.mLogoView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/widget/RideInfoOverlay_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */