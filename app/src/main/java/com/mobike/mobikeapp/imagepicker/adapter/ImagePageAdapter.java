package com.mobike.mobikeapp.imagepicker.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.mobike.mobikeapp.imagepicker.a.a;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import java.util.ArrayList;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.e.d;

public class ImagePageAdapter
  extends PagerAdapter
{
  public a a;
  private int b;
  private int c;
  private com.mobike.mobikeapp.imagepicker.b d;
  private ArrayList<ImageItem> e = new ArrayList();
  private Activity f;
  
  public ImagePageAdapter(Activity paramActivity, ArrayList<ImageItem> paramArrayList)
  {
    this.f = paramActivity;
    this.e = paramArrayList;
    paramActivity = com.mobike.mobikeapp.imagepicker.b.b.b(paramActivity);
    this.b = paramActivity.widthPixels;
    this.c = paramActivity.heightPixels;
    this.d = com.mobike.mobikeapp.imagepicker.b.a();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    PhotoView localPhotoView = new PhotoView(this.f);
    ImageItem localImageItem = (ImageItem)this.e.get(paramInt);
    this.d.l().displayImage(this.f, localImageItem.path, localPhotoView);
    localPhotoView.setOnPhotoTapListener(new e.d()
    {
      public void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (ImagePageAdapter.this.a != null) {
          ImagePageAdapter.this.a.a(paramAnonymousView, paramAnonymousFloat1, paramAnonymousFloat2);
        }
      }
    });
    paramViewGroup.addView(localPhotoView);
    return localPhotoView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, float paramFloat1, float paramFloat2);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/adapter/ImagePageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */