package com.mobike.mobikeapp.imagepicker.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ab;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.imagepicker.ImageDataSource;
import com.mobike.mobikeapp.imagepicker.ImageDataSource.a;
import com.mobike.mobikeapp.imagepicker.R.id;
import com.mobike.mobikeapp.imagepicker.R.layout;
import com.mobike.mobikeapp.imagepicker.R.string;
import com.mobike.mobikeapp.imagepicker.R.style;
import com.mobike.mobikeapp.imagepicker.b.a.a;
import com.mobike.mobikeapp.imagepicker.bean.ImageFolder;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import java.util.ArrayList;
import java.util.List;

public class ImageGridActivity
  extends BaseActivity
  implements View.OnClickListener, ImageDataSource.a, com.mobike.mobikeapp.imagepicker.adapter.b.a, com.mobike.mobikeapp.imagepicker.b.a
{
  private static final String[] p = { "android.permission.CAMERA" };
  private com.mobike.mobikeapp.imagepicker.b b;
  private boolean c = false;
  private int d;
  private int e;
  private GridView f;
  private View g;
  private View h;
  private Button i;
  private Button j;
  private Button k;
  private com.mobike.mobikeapp.imagepicker.adapter.a l;
  private ListPopupWindow m;
  private List<ImageFolder> n;
  private com.mobike.mobikeapp.imagepicker.adapter.b o;
  
  private void a(int paramInt1, int paramInt2)
  {
    this.m = new ListPopupWindow(this);
    this.m.setBackgroundDrawable(new ColorDrawable(0));
    this.m.setAdapter(this.l);
    this.m.setContentWidth(paramInt1);
    this.m.setWidth(paramInt1);
    this.m.setHeight(paramInt2 * 5 / 8);
    this.m.setAnchorView(this.h);
    this.m.setModal(true);
    this.m.setAnimationStyle(R.style.popupwindow_anim_style);
    this.m.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        ImageGridActivity.this.a(1.0F);
      }
    });
    this.m.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ImageGridActivity.a(ImageGridActivity.this).b(paramAnonymousInt);
        ImageGridActivity.b(ImageGridActivity.this).f(paramAnonymousInt);
        ImageGridActivity.c(ImageGridActivity.this).dismiss();
        paramAnonymousAdapterView = (ImageFolder)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          ImageGridActivity.d(ImageGridActivity.this).a(paramAnonymousAdapterView.images);
          ImageGridActivity.e(ImageGridActivity.this).setText(paramAnonymousAdapterView.name);
        }
        ImageGridActivity.f(ImageGridActivity.this).smoothScrollToPosition(0);
      }
    });
  }
  
  private void b()
  {
    com.mobike.mobikeapp.imagepicker.b.a(this, this.b.k());
    if (this.b.k() != null)
    {
      localObject = new ImageItem();
      ((ImageItem)localObject).path = this.b.k();
      this.b.s();
      this.b.a(0, (ImageItem)localObject, true);
      if (this.b.d())
      {
        startActivityForResult(new Intent(this, ImageCropActivity.class), 1002);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_result_items", this.b.r());
      setResult(1004, (Intent)localObject);
      finish();
      return;
    }
    Object localObject = Toast.makeText(this, R.string.image_not_found, 0);
    if (!(localObject instanceof Toast))
    {
      ((Toast)localObject).show();
      return;
    }
    VdsAgent.showToast((Toast)localObject);
  }
  
  public void a()
  {
    com.mobike.mobikeapp.imagepicker.b.b.a(this, R.string.image_no_found);
    if (com.mobike.mobikeapp.imagepicker.b.a().e()) {
      a(null);
    }
  }
  
  public void a(float paramFloat)
  {
    this.f.setAlpha(paramFloat);
    this.g.setAlpha(paramFloat);
    this.h.setAlpha(1.0F);
  }
  
  public void a(int paramInt)
  {
    if (com.mobike.mobikeapp.imagepicker.b.a.a(this, paramInt, p)) {
      b(paramInt);
    }
  }
  
  public void a(int paramInt, ImageItem paramImageItem, boolean paramBoolean)
  {
    if (this.b.q() > 0)
    {
      this.i.setText(getString(R.string.select_complete, new Object[] { Integer.valueOf(this.b.q()), Integer.valueOf(this.b.c()) }));
      this.i.setEnabled(true);
      this.k.setEnabled(true);
    }
    for (;;)
    {
      this.k.setText(getResources().getString(R.string.preview_count, new Object[] { Integer.valueOf(this.b.q()) }));
      this.o.notifyDataSetChanged();
      return;
      this.i.setText(getString(R.string.complete));
      this.i.setEnabled(false);
      this.k.setEnabled(false);
    }
  }
  
  public void a(View paramView, ImageItem paramImageItem, int paramInt)
  {
    int i1 = paramInt;
    if (this.b.e()) {
      i1 = paramInt - 1;
    }
    if (this.b.b())
    {
      paramView = new Intent(this, ImagePreviewActivity.class);
      paramView.putExtra("selected_image_position", i1);
      paramView.putExtra("extra_image_items", this.b.p());
      paramView.putExtra("isOrigin", this.c);
      startActivityForResult(paramView, 1003);
      return;
    }
    this.b.s();
    this.b.a(i1, (ImageItem)this.b.p().get(i1), true);
    if (this.b.d())
    {
      startActivityForResult(new Intent(this, ImageCropActivity.class), 1002);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("extra_result_items", this.b.r());
    setResult(1004, paramView);
    finish();
  }
  
  public void a(List<ImageFolder> paramList)
  {
    this.n = paramList;
    this.b.a(paramList);
    if (paramList != null) {
      this.o.a(((ImageFolder)paramList.get(0)).images);
    }
    this.o.a(this);
    this.f.setAdapter(this.o);
    this.l.a(paramList);
  }
  
  void b(int paramInt)
  {
    Toast localToast;
    if (!this.b.a(this, paramInt))
    {
      localToast = Toast.makeText(this, R.string.open_camera_error, 0);
      if (!(localToast instanceof Toast)) {
        localToast.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      this.c = paramIntent.getBooleanExtra("isOrigin", false);
      return;
    case 1002: 
      setResult(1004, paramIntent);
      finish();
      return;
    }
    b();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i1 = paramView.getId();
    if (i1 == R.id.btn_ok)
    {
      paramView = new Intent();
      paramView.putExtra("extra_result_items", this.b.r());
      setResult(1004, paramView);
      finish();
    }
    do
    {
      return;
      if (i1 == R.id.btn_dir)
      {
        if (this.m == null) {
          a(this.d, this.e);
        }
        a(0.3F);
        this.l.a(this.n);
        if (this.m.isShowing())
        {
          this.m.dismiss();
          return;
        }
        this.m.show();
        i1 = this.l.a();
        if (i1 == 0) {}
        for (;;)
        {
          this.m.getListView().setSelection(i1);
          return;
          i1 -= 1;
        }
      }
      if (i1 == R.id.btn_preview)
      {
        paramView = new Intent(this, ImagePreviewActivity.class);
        paramView.putExtra("selected_image_position", 0);
        paramView.putExtra("extra_image_items", this.b.r());
        paramView.putExtra("isOrigin", this.c);
        startActivityForResult(paramView, 1003);
        return;
      }
    } while (i1 != R.id.btn_back);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_image_grid);
    this.b = com.mobike.mobikeapp.imagepicker.b.a();
    this.b.t();
    this.b.a(this);
    paramBundle = com.mobike.mobikeapp.imagepicker.b.b.b(this);
    this.d = paramBundle.widthPixels;
    this.e = paramBundle.heightPixels;
    findViewById(R.id.btn_back).setOnClickListener(this);
    this.i = ((Button)findViewById(R.id.btn_ok));
    this.i.setOnClickListener(this);
    this.j = ((Button)findViewById(R.id.btn_dir));
    this.j.setOnClickListener(this);
    this.k = ((Button)findViewById(R.id.btn_preview));
    this.k.setOnClickListener(this);
    this.f = ((GridView)findViewById(R.id.gridview));
    this.g = findViewById(R.id.top_bar);
    this.h = findViewById(R.id.footer_bar);
    if (this.b.b())
    {
      this.i.setVisibility(0);
      this.k.setVisibility(0);
    }
    for (;;)
    {
      this.o = new com.mobike.mobikeapp.imagepicker.adapter.b(this, null);
      this.l = new com.mobike.mobikeapp.imagepicker.adapter.a(this, null);
      a(0, null, false);
      new ImageDataSource(this, null, this);
      return;
      this.i.setVisibility(8);
      this.k.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    this.b.b(this);
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    com.mobike.mobikeapp.imagepicker.b.a.a(paramArrayOfInt, new a.a()
    {
      public void a()
      {
        Toast localToast = Toast.makeText(ImageGridActivity.this, R.string.camera_permission_hint_text_1, 0);
        if (!(localToast instanceof Toast))
        {
          localToast.show();
          return;
        }
        VdsAgent.showToast((Toast)localToast);
      }
      
      public void b()
      {
        ImageGridActivity.this.b(1001);
      }
    });
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/ui/ImageGridActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */