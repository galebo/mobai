package com.mobike.mobikeapp.imagepicker.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.imagepicker.R.anim;
import com.mobike.mobikeapp.imagepicker.R.color;
import com.mobike.mobikeapp.imagepicker.R.id;
import com.mobike.mobikeapp.imagepicker.R.layout;
import com.mobike.mobikeapp.imagepicker.R.string;
import com.mobike.mobikeapp.imagepicker.adapter.ImagePageAdapter;
import com.mobike.mobikeapp.imagepicker.adapter.ImagePageAdapter.a;
import com.mobike.mobikeapp.imagepicker.b.a;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.view.SuperCheckBox;
import com.mobike.mobikeapp.imagepicker.view.ViewPagerFixed;
import com.mobike.mobikeapp.imagepicker.view.a;
import java.util.ArrayList;
import java.util.Iterator;

public class ImagePreviewActivity
  extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, b.a
{
  public static final String b = "isOrigin";
  private boolean c;
  private com.mobike.mobikeapp.imagepicker.b d;
  private ArrayList<ImageItem> e;
  private int f = 0;
  private TextView g;
  private SuperCheckBox h;
  private SuperCheckBox i;
  private Button j;
  private ArrayList<ImageItem> k;
  private View l;
  private View m;
  private View n;
  
  public void a()
  {
    if (this.m.getVisibility() == 0)
    {
      this.m.setAnimation(AnimationUtils.loadAnimation(this, R.anim.top_out));
      this.n.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));
      this.m.setVisibility(8);
      this.n.setVisibility(8);
      this.a.d(R.color.transparent);
      if (Build.VERSION.SDK_INT >= 16) {
        this.l.setSystemUiVisibility(4);
      }
    }
    do
    {
      return;
      this.m.setAnimation(AnimationUtils.loadAnimation(this, R.anim.top_in));
      this.n.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
      this.m.setVisibility(0);
      this.n.setVisibility(0);
      this.a.d(R.color.status_bar);
    } while (Build.VERSION.SDK_INT < 16);
    this.l.setSystemUiVisibility(1024);
  }
  
  public void a(int paramInt, ImageItem paramImageItem, boolean paramBoolean)
  {
    if (this.d.q() > 0)
    {
      this.j.setText(getString(R.string.select_complete, new Object[] { Integer.valueOf(this.d.q()), Integer.valueOf(this.d.c()) }));
      this.j.setEnabled(true);
    }
    while (this.i.isChecked())
    {
      paramImageItem = this.k.iterator();
      long l1 = 0L;
      for (;;)
      {
        if (paramImageItem.hasNext())
        {
          l1 = ((ImageItem)paramImageItem.next()).size + l1;
          continue;
          this.j.setText(getString(R.string.complete));
          this.j.setEnabled(false);
          break;
        }
      }
      paramImageItem = Formatter.formatFileSize(this, l1);
      this.i.setText(getString(R.string.origin_size, new Object[] { paramImageItem }));
    }
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isOrigin", this.c);
    setResult(1005, localIntent);
    finish();
    super.onBackPressed();
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    if (paramCompoundButton.getId() == R.id.cb_origin)
    {
      if (paramBoolean)
      {
        paramCompoundButton = this.k.iterator();
        for (long l1 = 0L; paramCompoundButton.hasNext(); l1 = ((ImageItem)paramCompoundButton.next()).size + l1) {}
        paramCompoundButton = Formatter.formatFileSize(this, l1);
        this.c = true;
        this.i.setText(getString(R.string.origin_size, new Object[] { paramCompoundButton }));
      }
    }
    else {
      return;
    }
    this.c = false;
    this.i.setText(getString(R.string.origin));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i1 = paramView.getId();
    if (i1 == R.id.btn_ok)
    {
      paramView = new Intent();
      paramView.putExtra("extra_result_items", this.d.r());
      setResult(-1, paramView);
      finish();
    }
    while (i1 != R.id.btn_back) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("isOrigin", this.c);
    setResult(-1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_image_preview);
    setResult(0);
    this.c = getIntent().getBooleanExtra("isOrigin", false);
    this.f = getIntent().getIntExtra("selected_image_position", 0);
    this.e = ((ArrayList)getIntent().getSerializableExtra("extra_image_items"));
    this.d = com.mobike.mobikeapp.imagepicker.b.a();
    this.d.a(this);
    this.k = this.d.r();
    this.l = findViewById(R.id.content);
    this.m = findViewById(R.id.top_bar);
    paramBundle = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    paramBundle.topMargin = com.mobike.mobikeapp.imagepicker.b.b.a(this);
    this.m.setLayoutParams(paramBundle);
    this.n = findViewById(R.id.bottom_bar);
    findViewById(R.id.btn_back).setOnClickListener(this);
    this.g = ((TextView)findViewById(R.id.tv_des));
    this.j = ((Button)findViewById(R.id.btn_ok));
    this.j.setOnClickListener(this);
    this.h = ((SuperCheckBox)findViewById(R.id.cb_check));
    this.i = ((SuperCheckBox)findViewById(R.id.cb_origin));
    this.i.setText(getString(R.string.origin));
    this.i.setOnCheckedChangeListener(this);
    this.i.setChecked(this.c);
    paramBundle = (ViewPagerFixed)findViewById(R.id.viewpager);
    Object localObject = new ImagePageAdapter(this, this.e);
    ((ImagePageAdapter)localObject).a(new ImagePageAdapter.a()
    {
      public void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        ImagePreviewActivity.this.a();
      }
    });
    paramBundle.setAdapter((PagerAdapter)localObject);
    paramBundle.setCurrentItem(this.f, false);
    a(0, null, false);
    localObject = (ImageItem)this.e.get(this.f);
    boolean bool = this.d.a((ImageItem)localObject);
    this.g.setText(getString(R.string.preview_image_count, new Object[] { Integer.valueOf(this.f + 1), Integer.valueOf(this.e.size()) }));
    this.h.setChecked(bool);
    paramBundle.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
    {
      public void onPageSelected(int paramAnonymousInt)
      {
        ImagePreviewActivity.a(ImagePreviewActivity.this, paramAnonymousInt);
        ImageItem localImageItem = (ImageItem)ImagePreviewActivity.b(ImagePreviewActivity.this).get(ImagePreviewActivity.a(ImagePreviewActivity.this));
        boolean bool = ImagePreviewActivity.c(ImagePreviewActivity.this).a(localImageItem);
        ImagePreviewActivity.d(ImagePreviewActivity.this).setChecked(bool);
        ImagePreviewActivity.e(ImagePreviewActivity.this).setText(ImagePreviewActivity.this.getString(R.string.preview_image_count, new Object[] { Integer.valueOf(ImagePreviewActivity.a(ImagePreviewActivity.this) + 1), Integer.valueOf(ImagePreviewActivity.b(ImagePreviewActivity.this).size()) }));
      }
    });
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (ImageItem)ImagePreviewActivity.b(ImagePreviewActivity.this).get(ImagePreviewActivity.a(ImagePreviewActivity.this));
        int i = ImagePreviewActivity.c(ImagePreviewActivity.this).c();
        if ((ImagePreviewActivity.d(ImagePreviewActivity.this).isChecked()) && (ImagePreviewActivity.f(ImagePreviewActivity.this).size() >= i))
        {
          com.mobike.mobikeapp.imagepicker.b.b.a(ImagePreviewActivity.this, ImagePreviewActivity.this.getString(R.string.select_limit, new Object[] { Integer.valueOf(i) }));
          ImagePreviewActivity.d(ImagePreviewActivity.this).setChecked(false);
          return;
        }
        ImagePreviewActivity.c(ImagePreviewActivity.this).a(ImagePreviewActivity.a(ImagePreviewActivity.this), paramAnonymousView, ImagePreviewActivity.d(ImagePreviewActivity.this).isChecked());
      }
    });
  }
  
  protected void onDestroy()
  {
    this.d.b(this);
    super.onDestroy();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/ui/ImagePreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */