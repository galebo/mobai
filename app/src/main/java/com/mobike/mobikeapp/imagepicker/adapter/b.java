package com.mobike.mobikeapp.imagepicker.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mobike.mobikeapp.imagepicker.R.id;
import com.mobike.mobikeapp.imagepicker.R.layout;
import com.mobike.mobikeapp.imagepicker.R.mipmap;
import com.mobike.mobikeapp.imagepicker.R.string;
import com.mobike.mobikeapp.imagepicker.a.a;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.view.SuperCheckBox;
import java.util.ArrayList;

public class b
  extends BaseAdapter
{
  private static final int a = 0;
  private static final int b = 1;
  private com.mobike.mobikeapp.imagepicker.b c;
  private Activity d;
  private ArrayList<ImageItem> e;
  private ArrayList<ImageItem> f;
  private boolean g;
  private int h;
  private a i;
  
  public b(Activity paramActivity, ArrayList<ImageItem> paramArrayList)
  {
    this.d = paramActivity;
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {}
    for (this.e = paramArrayList;; this.e = new ArrayList())
    {
      this.h = com.mobike.mobikeapp.imagepicker.b.b.a(this.d);
      this.c = com.mobike.mobikeapp.imagepicker.b.a();
      this.g = this.c.e();
      this.f = this.c.r();
      return;
    }
  }
  
  public ImageItem a(int paramInt)
  {
    if (this.g)
    {
      if (paramInt == 0) {
        return null;
      }
      return (ImageItem)this.e.get(paramInt - 1);
    }
    return (ImageItem)this.e.get(paramInt);
  }
  
  public void a(a parama)
  {
    this.i = parama;
  }
  
  public void a(ArrayList<ImageItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.e = paramArrayList;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.e.clear();
    }
  }
  
  public int getCount()
  {
    if (this.g) {
      return this.e.size() + 1;
    }
    return this.e.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = 1;
    int j = k;
    if (this.g)
    {
      j = k;
      if (paramInt == 0) {
        j = 0;
      }
    }
    return j;
  }
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      paramView = LayoutInflater.from(this.d).inflate(R.layout.adapter_camera_item, paramViewGroup, false);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
      paramView.setTag(null);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (b.a(b.this) != null) {
            b.a(b.this).a(1001);
          }
        }
      });
      return paramView;
    }
    final ImageItem localImageItem;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.d).inflate(R.layout.adapter_image_list_item, paramViewGroup, false);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      localImageItem = a(paramInt);
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (b.a(b.this) != null) {
            b.a(b.this).a(paramViewGroup.a, localImageItem, paramInt);
          }
        }
      });
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = b.b(b.this).c();
          if ((paramViewGroup.d.isChecked()) && (b.c(b.this).size() >= i))
          {
            com.mobike.mobikeapp.imagepicker.b.b.a(b.d(b.this), b.d(b.this).getString(R.string.select_limit, new Object[] { Integer.valueOf(i) }));
            paramViewGroup.d.setChecked(false);
            paramViewGroup.c.setVisibility(8);
            return;
          }
          b.b(b.this).a(paramInt, localImageItem, paramViewGroup.d.isChecked());
          paramViewGroup.c.setVisibility(0);
        }
      });
      if (!this.c.b()) {
        break label260;
      }
      paramViewGroup.d.setVisibility(0);
      if (!this.f.contains(localImageItem)) {
        break label240;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.d.setChecked(true);
    }
    for (;;)
    {
      if ((localImageItem != null) && (!TextUtils.isEmpty(localImageItem.path))) {
        break label272;
      }
      paramViewGroup.b.setImageResource(R.mipmap.default_image);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label240:
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.d.setChecked(false);
      continue;
      label260:
      paramViewGroup.d.setVisibility(8);
    }
    label272:
    this.c.l().displayImage(this.d, localImageItem.path, paramViewGroup.b);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(View paramView, ImageItem paramImageItem, int paramInt);
  }
  
  private class b
  {
    public View a;
    public ImageView b;
    public View c;
    public SuperCheckBox d;
    
    public b(View paramView)
    {
      this.a = paramView;
      this.b = ((ImageView)paramView.findViewById(R.id.iv_thumb));
      this.c = paramView.findViewById(R.id.mask);
      this.d = ((SuperCheckBox)paramView.findViewById(R.id.cb_check));
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */