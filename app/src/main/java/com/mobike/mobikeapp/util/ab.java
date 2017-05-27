package com.mobike.mobikeapp.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.google.gson.e;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.VersionDataInfo;
import com.mobike.mobikeapp.data.VersionDataInfo.VersionData;
import com.mobike.mobikeapp.model.c.h;
import cz.msebera.android.httpclient.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ab
{
  private static final int a = 1;
  private static final int b = 2;
  private String c;
  private int d;
  private boolean e = false;
  private Context f;
  private VersionDataInfo.VersionData g = null;
  private NumberProgressBar h;
  private String i;
  private Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        ab.b(ab.this).setProgress(ab.a(ab.this));
        return;
      }
      ab.c(ab.this);
    }
  };
  private b k;
  
  public ab(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private void a()
  {
    if (TextUtils.isEmpty(this.g.name)) {}
    for (String str = "mobike";; str = this.g.name)
    {
      this.i = str;
      if (!this.i.endsWith(".apk"))
      {
        if (this.i.contains(".")) {
          this.i.replace(".", "");
        }
        this.i += ".apk";
      }
      return;
    }
  }
  
  private void b()
  {
    b localb = new b.a(this.f, 2131427642).a(2131296990).b(2131296989).a(2131296630, ac.a(this)).b(2131297103, ad.a()).b();
    localb.setCanceledOnTouchOutside(false);
    localb.show();
  }
  
  private void c()
  {
    b.a locala = new b.a(this.f, 2131427642).a(2131296990).b(2131296338, ae.a(this));
    View localView = LayoutInflater.from(this.f).inflate(2130968838, null);
    this.h = ((NumberProgressBar)localView.findViewById(2131755912));
    locala.b(localView);
    this.k = locala.b();
    this.k.setCanceledOnTouchOutside(false);
    this.k.show();
    new a(null).start();
  }
  
  private void d()
  {
    File localFile = new File(this.c, this.i);
    Intent localIntent;
    Uri localUri;
    if (localFile.exists())
    {
      localIntent = new Intent("android.intent.action.VIEW");
      if (Build.VERSION.SDK_INT < 24) {
        break label112;
      }
      localUri = FileProvider.getUriForFile(this.f, this.f.getApplicationContext().getPackageName() + ".provider", localFile);
      localIntent.setFlags(1);
    }
    for (;;)
    {
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(localUri, "application/vnd.android.package-archive");
      this.f.startActivity(localIntent);
      localFile.deleteOnExit();
      return;
      label112:
      localUri = Uri.fromFile(localFile);
    }
  }
  
  public void a(final boolean paramBoolean)
  {
    f.b(a.a(), new com.loopj.android.http.ad()
    {
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString)
      {
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          paramAnonymousArrayOfd = (VersionDataInfo)new e().a(paramAnonymousString, VersionDataInfo.class);
          if (paramAnonymousArrayOfd == null) {}
        }
        switch (paramAnonymousArrayOfd.result)
        {
        default: 
          if (paramBoolean) {
            h.a(ab.f(ab.this), ab.f(ab.this).getString(2131296754));
          }
          return;
        }
        ab.a(ab.this, paramAnonymousArrayOfd.versionData);
        ab.d(ab.this);
        ab.e(ab.this);
      }
      
      public void a(int paramAnonymousInt, d[] paramAnonymousArrayOfd, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
    });
  }
  
  private class a
    extends Thread
  {
    private a() {}
    
    public void run()
    {
      if (ab.g(ab.this) == null) {
        if ((ab.h(ab.this) != null) && (ab.h(ab.this).isShowing())) {
          ab.h(ab.this).dismiss();
        }
      }
      Object localObject1;
      do
      {
        return;
        localObject1 = h.a();
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      ab.a(ab.this, (String)localObject1 + File.separator + "download");
      for (;;)
      {
        try
        {
          localObject1 = (HttpURLConnection)new URL(ab.g(ab.this).url).openConnection();
          ((HttpURLConnection)localObject1).connect();
          int j = ((HttpURLConnection)localObject1).getContentLength();
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          localObject2 = new File(ab.i(ab.this));
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          localObject2 = new FileOutputStream(new File(ab.i(ab.this), ab.j(ab.this)));
          arrayOfByte = new byte['Ѐ'];
          int i = 0;
          k = ((InputStream)localObject1).read(arrayOfByte);
          i += k;
          ab.a(ab.this, (int)(i / j * 100.0F));
          ab.k(ab.this).sendEmptyMessage(1);
          if (k > 0) {
            continue;
          }
          ab.k(ab.this).sendEmptyMessage(2);
          ((FileOutputStream)localObject2).close();
          ((InputStream)localObject1).close();
        }
        catch (Exception localException)
        {
          Object localObject2;
          byte[] arrayOfByte;
          int k;
          boolean bool;
          localException.printStackTrace();
          continue;
        }
        ab.h(ab.this).dismiss();
        return;
        ((FileOutputStream)localObject2).write(arrayOfByte, 0, k);
        bool = ab.l(ab.this);
        if (!bool) {}
      }
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */