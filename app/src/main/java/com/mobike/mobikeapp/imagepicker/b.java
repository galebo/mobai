package com.mobike.mobikeapp.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcelable;
import android.support.annotation.ab;
import android.support.v4.content.FileProvider;
import com.mobike.mobikeapp.imagepicker.a.a;
import com.mobike.mobikeapp.imagepicker.bean.ImageFolder;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.view.CropImageView.Style;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class b
{
  private static b B;
  public static final String a = b.class.getSimpleName();
  public static final int b = 1001;
  public static final int c = 1002;
  public static final int d = 1003;
  public static final int e = 1004;
  public static final int f = 1005;
  public static final String g = "extra_result_items";
  public static final String h = "selected_image_position";
  public static final String i = "extra_image_items";
  private List<a> A;
  public Bitmap j;
  private boolean k = true;
  private int l = 9;
  private boolean m = true;
  private boolean n = true;
  private boolean o = false;
  private int p = 800;
  private int q = 800;
  private int r = 280;
  private int s = 280;
  private a t;
  private CropImageView.Style u = CropImageView.Style.RECTANGLE;
  private File v;
  private String w;
  private ArrayList<ImageItem> x = new ArrayList();
  private List<ImageFolder> y;
  private int z = 0;
  
  public static b a()
  {
    if (B == null) {}
    try
    {
      if (B == null) {
        B = new b();
      }
      return B;
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.fromFile(new File(paramString)));
      paramContext.sendBroadcast(localIntent);
    }
  }
  
  private void b(int paramInt, ImageItem paramImageItem, boolean paramBoolean)
  {
    if (this.A == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.A.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(paramInt, paramImageItem, paramBoolean);
      }
    }
  }
  
  public File a(Context paramContext)
  {
    if (this.v == null) {
      this.v = new File(paramContext.getCacheDir() + "/ImagePicker/cropTemp/");
    }
    return this.v;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(int paramInt, ImageItem paramImageItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.x.add(paramImageItem);
    }
    for (;;)
    {
      b(paramInt, paramImageItem, paramBoolean);
      return;
      this.x.remove(paramImageItem);
    }
  }
  
  public void a(a parama)
  {
    this.t = parama;
  }
  
  public void a(a parama)
  {
    if (this.A == null) {
      this.A = new ArrayList();
    }
    this.A.add(parama);
  }
  
  public void a(CropImageView.Style paramStyle)
  {
    this.u = paramStyle;
  }
  
  public void a(File paramFile)
  {
    this.v = paramFile;
  }
  
  public void a(List<ImageFolder> paramList)
  {
    this.y = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a(@ab Activity paramActivity, int paramInt)
  {
    if (com.mobike.mobikeapp.imagepicker.b.b.a())
    {
      Object localObject1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mobike");
      if ((((File)localObject1).exists()) || (((File)localObject1).mkdirs()))
      {
        Object localObject2 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        localObject2 = "IMG_" + ((SimpleDateFormat)localObject2).format(new Date(System.currentTimeMillis()));
        for (;;)
        {
          try
          {
            localObject1 = File.createTempFile((String)localObject2, ".jpg", (File)localObject1);
            this.w = ((File)localObject1).getAbsolutePath();
            if (Build.VERSION.SDK_INT >= 24)
            {
              localObject1 = FileProvider.getUriForFile(paramActivity, "com.mobike.mobikeapp.provider", (File)localObject1);
              localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
              ((Intent)localObject2).setFlags(67108864);
              ((Intent)localObject2).setFlags(1);
              ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
              if (((Intent)localObject2).resolveActivity(paramActivity.getPackageManager()) == null) {
                break;
              }
              paramActivity.startActivityForResult((Intent)localObject2, paramInt);
              return true;
            }
          }
          catch (Exception paramActivity)
          {
            return false;
          }
          localObject1 = Uri.fromFile((File)localObject1);
        }
      }
    }
    return false;
  }
  
  public boolean a(ImageItem paramImageItem)
  {
    return this.x.contains(paramImageItem);
  }
  
  public void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void b(a parama)
  {
    if (this.A == null) {
      return;
    }
    this.A.remove(parama);
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public int c()
  {
    return this.l;
  }
  
  public void c(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void d(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public void e(int paramInt)
  {
    this.s = paramInt;
  }
  
  public boolean e()
  {
    return this.n;
  }
  
  public void f(int paramInt)
  {
    this.z = paramInt;
  }
  
  public boolean f()
  {
    return this.o;
  }
  
  public int g()
  {
    return this.p;
  }
  
  public int h()
  {
    return this.q;
  }
  
  public int i()
  {
    return this.r;
  }
  
  public int j()
  {
    return this.s;
  }
  
  public String k()
  {
    return this.w;
  }
  
  public a l()
  {
    return this.t;
  }
  
  public CropImageView.Style m()
  {
    return this.u;
  }
  
  public List<ImageFolder> n()
  {
    return this.y;
  }
  
  public int o()
  {
    return this.z;
  }
  
  public ArrayList<ImageItem> p()
  {
    return ((ImageFolder)this.y.get(this.z)).images;
  }
  
  public int q()
  {
    if (this.x == null) {
      return 0;
    }
    return this.x.size();
  }
  
  public ArrayList<ImageItem> r()
  {
    return this.x;
  }
  
  public void s()
  {
    if (this.x != null) {
      this.x.clear();
    }
  }
  
  public void t()
  {
    if (this.A != null)
    {
      this.A.clear();
      this.A = null;
    }
    if (this.y != null)
    {
      this.y.clear();
      this.y = null;
    }
    if (this.x != null) {
      this.x.clear();
    }
    this.z = 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, ImageItem paramImageItem, boolean paramBoolean);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */