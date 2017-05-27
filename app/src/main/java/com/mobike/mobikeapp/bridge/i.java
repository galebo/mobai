package com.mobike.mobikeapp.bridge;

import android.net.Uri;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.gson.JsonSyntaxException;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.n;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class i
{
  public static final String a = "mobike";
  public static final String b = "bridge";
  public static final String c = "home";
  private static final String d = "javascript:%s(%s)";
  private static final String e = "name";
  private static final String f = "callback";
  private static final String g = "data";
  private Map<String, f> h = new HashMap();
  private h i = new c(null);
  private WebView j;
  
  public void a(@ab String paramString)
  {
    paramString = this.i.a(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.a)) && (this.h.containsKey(paramString.a))) {
      ((f)this.h.get(paramString.a)).a(paramString.c, new b(this, paramString.b));
    }
  }
  
  public void a(@ab String paramString, @ab PortalOutput paramPortalOutput)
  {
    if (this.j != null) {
      this.j.post(j.a(this, paramString, paramPortalOutput));
    }
  }
  
  public void a(@ab String paramString, @ab f paramf)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramf == null)) {
      return;
    }
    this.h.put(paramString, paramf);
  }
  
  public static class a
  {
    private i a = new i(null);
    
    public a a(@ab WebView paramWebView)
    {
      WebSettings localWebSettings = paramWebView.getSettings();
      if (localWebSettings != null) {
        localWebSettings.setJavaScriptEnabled(true);
      }
      i.a(this.a, paramWebView);
      return this;
    }
    
    public a a(@ab h paramh)
    {
      i.a(this.a, paramh);
      return this;
    }
    
    public a a(@ab String paramString, @ab f paramf)
    {
      this.a.a(paramString, paramf);
      return this;
    }
    
    public i a()
    {
      return this.a;
    }
  }
  
  private static class b
    implements e
  {
    private WeakReference<i> a;
    private String b;
    
    public b(i parami, String paramString)
    {
      this.a = new WeakReference(parami);
      this.b = paramString;
    }
    
    public void a(@ab int paramInt, @ac String paramString1, @ac String paramString2)
    {
      if (this.a.get() != null) {
        ((i)this.a.get()).a(this.b, PortalOutput.assemble(paramInt, paramString1, paramString2));
      }
    }
  }
  
  private static class c
    implements h
  {
    public g a(String paramString)
    {
      str = null;
      Object localObject1 = null;
      try
      {
        localObject2 = Uri.parse(paramString);
        paramString = str;
        if ("mobike".equals(((Uri)localObject2).getScheme()))
        {
          paramString = str;
          if ("bridge".equals(((Uri)localObject2).getHost())) {
            str = ((Uri)localObject2).getQueryParameter("name");
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject2;
          label73:
          paramString = null;
          str = null;
        }
      }
      try
      {
        paramString = ((Uri)localObject2).getQueryParameter("callback");
      }
      catch (Exception paramString)
      {
        paramString = null;
        break label73;
      }
      try
      {
        localObject2 = URLDecoder.decode(((Uri)localObject2).getQueryParameter("data"), "UTF-8");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        break label73;
      }
      paramString = g.a(str, paramString, (String)localObject1);
      return paramString;
    }
    
    public String a(PortalOutput paramPortalOutput)
    {
      m localm = new com.google.gson.e().a(paramPortalOutput).t();
      Object localObject;
      if (localm.b("data"))
      {
        localm.a("data");
        localObject = null;
      }
      try
      {
        paramPortalOutput = new n().a(paramPortalOutput.data);
        if (paramPortalOutput != null) {
          localm.a("data", paramPortalOutput);
        }
        return localm.toString();
      }
      catch (JsonSyntaxException paramPortalOutput)
      {
        for (;;)
        {
          paramPortalOutput = (PortalOutput)localObject;
        }
      }
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/bridge/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */