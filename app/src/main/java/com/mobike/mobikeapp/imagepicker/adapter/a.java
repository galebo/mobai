package com.mobike.mobikeapp.imagepicker.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobike.mobikeapp.imagepicker.R.id;
import com.mobike.mobikeapp.imagepicker.R.layout;
import com.mobike.mobikeapp.imagepicker.R.string;
import com.mobike.mobikeapp.imagepicker.bean.ImageFolder;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
{
  private com.mobike.mobikeapp.imagepicker.b a;
  private Activity b;
  private LayoutInflater c;
  private int d;
  private List<ImageFolder> e;
  private int f = 0;
  
  public a(Activity paramActivity, List<ImageFolder> paramList)
  {
    this.b = paramActivity;
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (this.e = paramList;; this.e = new ArrayList())
    {
      this.a = com.mobike.mobikeapp.imagepicker.b.a();
      this.d = com.mobike.mobikeapp.imagepicker.b.b.a(this.b);
      this.c = ((LayoutInflater)paramActivity.getSystemService("layout_inflater"));
      return;
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public ImageFolder a(int paramInt)
  {
    return (ImageFolder)this.e.get(paramInt);
  }
  
  public void a(List<ImageFolder> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.e = paramList;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.e.clear();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.c.inflate(R.layout.adapter_folder_list_item, paramViewGroup, false);
    }
    for (paramViewGroup = new a(paramView);; paramViewGroup = (a)paramView.getTag())
    {
      ImageFolder localImageFolder = a(paramInt);
      paramViewGroup.b.setText(localImageFolder.name);
      paramViewGroup.c.setText(this.b.getString(R.string.folder_image_count, new Object[] { Integer.valueOf(localImageFolder.images.size()) }));
      this.a.l().displayImage(this.b, localImageFolder.cover.path, paramViewGroup.a);
      if (this.f != paramInt) {
        break;
      }
      paramViewGroup.d.setVisibility(0);
      return paramView;
    }
    paramViewGroup.d.setVisibility(4);
    return paramView;
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    TextView c;
    ImageView d;
    
    public a(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(R.id.iv_cover));
      this.b = ((TextView)paramView.findViewById(R.id.tv_folder_name));
      this.c = ((TextView)paramView.findViewById(R.id.tv_image_count));
      this.d = ((ImageView)paramView.findViewById(R.id.iv_folder_check));
      paramView.setTag(this);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */