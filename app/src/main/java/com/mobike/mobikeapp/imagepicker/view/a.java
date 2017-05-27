package com.mobike.mobikeapp.imagepicker.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;

public class a
{
  public static final int a = -1728053248;
  private static String b;
  private final a c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private View h;
  private View i;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      b = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return;
    }
    catch (Throwable localThrowable)
    {
      b = null;
    }
  }
  
  @TargetApi(19)
  public a(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    ViewGroup localViewGroup = (ViewGroup)localWindow.getDecorView();
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = paramActivity.obtainStyledAttributes(new int[] { 16843759, 16843760 });
    }
    try
    {
      this.d = ((TypedArray)localObject).getBoolean(0, false);
      this.e = ((TypedArray)localObject).getBoolean(1, false);
      ((TypedArray)localObject).recycle();
      localObject = localWindow.getAttributes();
      if ((0x4000000 & ((WindowManager.LayoutParams)localObject).flags) != 0) {
        this.d = true;
      }
      if ((((WindowManager.LayoutParams)localObject).flags & 0x8000000) != 0) {
        this.e = true;
      }
      this.c = new a(paramActivity, this.d, this.e, null);
      if (!this.c.d()) {
        this.e = false;
      }
      if (this.d) {
        a(paramActivity, localViewGroup);
      }
      if (this.e) {
        b(paramActivity, localViewGroup);
      }
      return;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.h = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, this.c.b());
    paramContext.gravity = 48;
    if ((this.e) && (!this.c.a())) {
      paramContext.rightMargin = this.c.f();
    }
    this.h.setLayoutParams(paramContext);
    this.h.setBackgroundColor(-1728053248);
    this.h.setVisibility(8);
    paramViewGroup.addView(this.h);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    this.i = new View(paramContext);
    if (this.c.a()) {
      paramContext = new FrameLayout.LayoutParams(-1, this.c.e());
    }
    for (paramContext.gravity = 80;; paramContext.gravity = 5)
    {
      this.i.setLayoutParams(paramContext);
      this.i.setBackgroundColor(-1728053248);
      this.i.setVisibility(8);
      paramViewGroup.addView(this.i);
      return;
      paramContext = new FrameLayout.LayoutParams(this.c.f(), -1);
    }
  }
  
  public a a()
  {
    return this.c;
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    c(paramFloat);
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    e(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    b(paramDrawable);
    c(paramDrawable);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    View localView;
    if (this.d)
    {
      localView = this.h;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  @TargetApi(11)
  public void b(float paramFloat)
  {
    if ((this.d) && (Build.VERSION.SDK_INT >= 11)) {
      this.h.setAlpha(paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    d(paramInt);
    f(paramInt);
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.d) {
      this.h.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    View localView;
    if (this.e)
    {
      localView = this.i;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  @TargetApi(11)
  public void c(float paramFloat)
  {
    if ((this.e) && (Build.VERSION.SDK_INT >= 11)) {
      this.i.setAlpha(paramFloat);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.d) {
      this.h.setBackgroundColor(paramInt);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.e) {
      this.i.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    if (this.d) {
      this.h.setBackgroundResource(paramInt);
    }
  }
  
  public void e(int paramInt)
  {
    if (this.e) {
      this.i.setBackgroundColor(paramInt);
    }
  }
  
  public void f(int paramInt)
  {
    if (this.e) {
      this.i.setBackgroundResource(paramInt);
    }
  }
  
  public static class a
  {
    private static final String a = "status_bar_height";
    private static final String b = "navigation_bar_height";
    private static final String c = "navigation_bar_height_landscape";
    private static final String d = "navigation_bar_width";
    private static final String e = "config_showNavigationBar";
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final float n;
    
    private a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
    {
      Resources localResources = paramActivity.getResources();
      if (localResources.getConfiguration().orientation == 1)
      {
        bool1 = true;
        this.m = bool1;
        this.n = a(paramActivity);
        this.h = a(localResources, "status_bar_height");
        this.i = a(paramActivity);
        this.k = b(paramActivity);
        this.l = c(paramActivity);
        if (this.k <= 0) {
          break label116;
        }
      }
      label116:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.j = bool1;
        this.f = paramBoolean1;
        this.g = paramBoolean2;
        return;
        bool1 = false;
        break;
      }
    }
    
    @SuppressLint({"NewApi"})
    private float a(Activity paramActivity)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 16) {
        paramActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      }
      for (;;)
      {
        return Math.min(localDisplayMetrics.widthPixels / localDisplayMetrics.density, localDisplayMetrics.heightPixels / localDisplayMetrics.density);
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      }
    }
    
    @TargetApi(14)
    private int a(Context paramContext)
    {
      int i1 = 0;
      if (Build.VERSION.SDK_INT >= 14)
      {
        TypedValue localTypedValue = new TypedValue();
        paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true);
        i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      }
      return i1;
    }
    
    private int a(Resources paramResources, String paramString)
    {
      int i1 = 0;
      int i2 = paramResources.getIdentifier(paramString, "dimen", "android");
      if (i2 > 0) {
        i1 = paramResources.getDimensionPixelSize(i2);
      }
      return i1;
    }
    
    @TargetApi(14)
    private int b(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      int i2 = 0;
      int i1 = i2;
      if (Build.VERSION.SDK_INT >= 14)
      {
        i1 = i2;
        if (d(paramContext)) {
          if (!this.m) {
            break label48;
          }
        }
      }
      label48:
      for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
      {
        i1 = a(localResources, paramContext);
        return i1;
      }
    }
    
    @TargetApi(14)
    private int c(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      int i2 = 0;
      int i1 = i2;
      if (Build.VERSION.SDK_INT >= 14)
      {
        i1 = i2;
        if (d(paramContext)) {
          i1 = a(localResources, "navigation_bar_width");
        }
      }
      return i1;
    }
    
    @TargetApi(14)
    private boolean d(Context paramContext)
    {
      boolean bool = true;
      Resources localResources = paramContext.getResources();
      int i1 = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
      if (i1 != 0)
      {
        bool = localResources.getBoolean(i1);
        if ("1".equals(a.d())) {
          return false;
        }
        if ("0".equals(a.d())) {
          return true;
        }
      }
      else
      {
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey()) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return bool;
    }
    
    public int a(boolean paramBoolean)
    {
      int i2 = 0;
      if (this.f) {}
      for (int i1 = this.h;; i1 = 0)
      {
        if (paramBoolean) {
          i2 = this.i;
        }
        return i2 + i1;
      }
    }
    
    public boolean a()
    {
      return (this.n >= 600.0F) || (this.m);
    }
    
    public int b()
    {
      return this.h;
    }
    
    public int c()
    {
      return this.i;
    }
    
    public boolean d()
    {
      return this.j;
    }
    
    public int e()
    {
      return this.k;
    }
    
    public int f()
    {
      return this.l;
    }
    
    public int g()
    {
      if ((this.g) && (a())) {
        return this.k;
      }
      return 0;
    }
    
    public int h()
    {
      if ((this.g) && (!a())) {
        return this.l;
      }
      return 0;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/imagepicker/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */