package com.mobike.mobikeapp.imagepicker.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.imagepicker.R.id;
import com.mobike.mobikeapp.imagepicker.R.layout;
import com.mobike.mobikeapp.imagepicker.R.string;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.view.CropImageView;
import com.mobike.mobikeapp.imagepicker.view.CropImageView.b;
import java.io.File;
import java.util.ArrayList;

public class ImageCropActivity
  extends BaseActivity
  implements View.OnClickListener, CropImageView.b
{
  private CropImageView b;
  private Bitmap c;
  private boolean d;
  private int e;
  private int f;
  private ArrayList<ImageItem> g;
  private com.mobike.mobikeapp.imagepicker.b h;
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outWidth;
    int k = paramOptions.outHeight;
    int i = 1;
    if ((k > paramInt2) || (j > paramInt1)) {
      if (j <= k) {
        break label45;
      }
    }
    label45:
    for (i = j / paramInt1;; i = k / paramInt2) {
      return i + 1;
    }
  }
  
  public void a(File paramFile)
  {
    this.g.remove(0);
    ImageItem localImageItem = new ImageItem();
    localImageItem.path = paramFile.getAbsolutePath();
    this.g.add(localImageItem);
    paramFile = new Intent();
    paramFile.putExtra("extra_result_items", this.g);
    setResult(-1, paramFile);
    finish();
  }
  
  public void b(File paramFile) {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = paramView.getId();
    if (i == R.id.btn_back) {
      finish();
    }
    while (i != R.id.btn_ok) {
      return;
    }
    this.b.a(this.h.a(this), this.e, this.f, this.d);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_image_crop);
    setResult(0);
    this.h = com.mobike.mobikeapp.imagepicker.b.a();
    findViewById(R.id.btn_back).setOnClickListener(this);
    paramBundle = (Button)findViewById(R.id.btn_ok);
    paramBundle.setText(getString(R.string.complete));
    paramBundle.setOnClickListener(this);
    ((TextView)findViewById(R.id.tv_des)).setText(getString(R.string.photo_crop));
    this.b = ((CropImageView)findViewById(R.id.cv_crop_image));
    this.b.setOnBitmapSaveCompleteListener(this);
    this.e = this.h.g();
    this.f = this.h.h();
    this.d = this.h.f();
    this.g = this.h.r();
    paramBundle = ((ImageItem)this.g.get(0)).path;
    this.b.setFocusStyle(this.h.m());
    this.b.setFocusWidth(this.h.i());
    this.b.setFocusHeight(this.h.j());
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramBundle, localOptions);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    localOptions.inSampleSize = a(localOptions, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    localOptions.inJustDecodeBounds = false;
    this.c = BitmapFactory.decodeFile(paramBundle, localOptions);
    if (this.c != null)
    {
      this.b.setImageBitmap(this.c);
      return;
    }
    com.mobike.mobikeapp.imagepicker.b.b.a(this, R.string.image_original_not_found);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      this.c.recycle();
      this.c = null;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/ui/ImageCropActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */