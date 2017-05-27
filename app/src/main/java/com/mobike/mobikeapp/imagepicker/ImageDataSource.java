package com.mobike.mobikeapp.imagepicker;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import com.mobike.mobikeapp.imagepicker.bean.ImageFolder;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageDataSource
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public static final int a = 0;
  public static final int b = 1;
  private final String[] c = { "_display_name", "_data", "_size", "width", "height", "mime_type", "date_added" };
  private FragmentActivity d;
  private a e;
  private ArrayList<ImageFolder> f = new ArrayList();
  
  public ImageDataSource(FragmentActivity paramFragmentActivity, String paramString, a parama)
  {
    this.d = paramFragmentActivity;
    this.e = parama;
    paramFragmentActivity = paramFragmentActivity.getSupportLoaderManager();
    if (paramString == null)
    {
      paramFragmentActivity.initLoader(0, null, this);
      return;
    }
    parama = new Bundle();
    parama.putString("path", paramString);
    paramFragmentActivity.initLoader(1, parama, this);
  }
  
  public void a(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    this.f.clear();
    if (paramCursor != null)
    {
      if (paramCursor.getCount() <= 0) {
        this.e.a();
      }
    }
    else {
      return;
    }
    paramLoader = new ArrayList();
    while (paramCursor.moveToNext())
    {
      Object localObject1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(this.c[0]));
      Object localObject2 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(this.c[1]));
      long l1 = paramCursor.getLong(paramCursor.getColumnIndexOrThrow(this.c[2]));
      int i = paramCursor.getInt(paramCursor.getColumnIndexOrThrow(this.c[3]));
      int j = paramCursor.getInt(paramCursor.getColumnIndexOrThrow(this.c[4]));
      String str = paramCursor.getString(paramCursor.getColumnIndexOrThrow(this.c[5]));
      long l2 = paramCursor.getLong(paramCursor.getColumnIndexOrThrow(this.c[6]));
      ImageItem localImageItem = new ImageItem();
      localImageItem.name = ((String)localObject1);
      localImageItem.path = ((String)localObject2);
      localImageItem.size = l1;
      localImageItem.width = i;
      localImageItem.height = j;
      localImageItem.mimeType = str;
      localImageItem.addTime = l2;
      paramLoader.add(localImageItem);
      localObject2 = new File((String)localObject2).getParentFile();
      localObject1 = new ImageFolder();
      ((ImageFolder)localObject1).name = ((File)localObject2).getName();
      ((ImageFolder)localObject1).path = ((File)localObject2).getAbsolutePath();
      if (!this.f.contains(localObject1))
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localImageItem);
        ((ImageFolder)localObject1).cover = localImageItem;
        ((ImageFolder)localObject1).images = ((ArrayList)localObject2);
        this.f.add(localObject1);
      }
      else
      {
        ((ImageFolder)this.f.get(this.f.indexOf(localObject1))).images.add(localImageItem);
      }
    }
    paramCursor = new ImageFolder();
    paramCursor.name = this.d.getResources().getString(R.string.all_images);
    paramCursor.path = "/";
    paramCursor.cover = ((ImageItem)paramLoader.get(0));
    paramCursor.images = paramLoader;
    this.f.add(0, paramCursor);
    this.e.a(this.f);
    b.a().a(this.f);
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (CursorLoader localCursorLoader = new CursorLoader(this.d, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.c, null, null, this.c[6] + " DESC");; localCursorLoader = null)
    {
      if (paramInt == 1) {
        localCursorLoader = new CursorLoader(this.d, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.c, this.c[1] + " like '%" + paramBundle.getString("path") + "%'", null, this.c[6] + " DESC");
      }
      return localCursorLoader;
    }
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    Log.e("ImageSource", "onLoaderReset");
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(List<ImageFolder> paramList);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/ImageDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */