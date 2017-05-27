package com.mobike.mobikeapp;

import android.support.annotation.ao;
import android.support.annotation.i;
import android.view.View;
import android.view.Window;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.mobike.mobikeapp.widget.TreasureAnimView;
import com.mobike.mobikeapp.widget.TreasureWebView;

public class QRCodeInputActivity_ViewBinding
  implements Unbinder
{
  private QRCodeInputActivity b;
  
  @ao
  public QRCodeInputActivity_ViewBinding(QRCodeInputActivity paramQRCodeInputActivity)
  {
    this(paramQRCodeInputActivity, paramQRCodeInputActivity.getWindow().getDecorView());
  }
  
  @ao
  public QRCodeInputActivity_ViewBinding(QRCodeInputActivity paramQRCodeInputActivity, View paramView)
  {
    this.b = paramQRCodeInputActivity;
    paramQRCodeInputActivity.mTreasureAnimView = ((TreasureAnimView)d.b(paramView, 2131755240, "field 'mTreasureAnimView'", TreasureAnimView.class));
    paramQRCodeInputActivity.mTreasureWebView = ((TreasureWebView)d.b(paramView, 2131755239, "field 'mTreasureWebView'", TreasureWebView.class));
  }
  
  @i
  public void a()
  {
    QRCodeInputActivity localQRCodeInputActivity = this.b;
    if (localQRCodeInputActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b = null;
    localQRCodeInputActivity.mTreasureAnimView = null;
    localQRCodeInputActivity.mTreasureWebView = null;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/QRCodeInputActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */