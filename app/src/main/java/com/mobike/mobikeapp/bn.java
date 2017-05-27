package com.mobike.mobikeapp;

import b.a.g;
import b.a.h;
import java.lang.ref.WeakReference;

final class bn
{
  private static final int a = 18;
  private static final String[] b = { "android.permission.CAMERA" };
  private static final int c = 19;
  private static final String[] d = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  
  static void a(MapFragment paramMapFragment)
  {
    if (h.a(paramMapFragment.getActivity(), b))
    {
      paramMapFragment.e();
      return;
    }
    paramMapFragment.requestPermissions(b, 18);
  }
  
  static void a(MapFragment paramMapFragment, int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 18: 
      if ((h.a(paramMapFragment.getActivity()) < 23) && (!h.a(paramMapFragment.getActivity(), b)))
      {
        paramMapFragment.f();
        return;
      }
      if (h.a(paramArrayOfInt))
      {
        paramMapFragment.e();
        return;
      }
      if (!h.a(paramMapFragment.getActivity(), b))
      {
        paramMapFragment.g();
        return;
      }
      paramMapFragment.f();
      return;
    }
    if ((h.a(paramMapFragment.getActivity()) < 23) && (!h.a(paramMapFragment.getActivity(), d)))
    {
      paramMapFragment.j();
      return;
    }
    if (h.a(paramArrayOfInt))
    {
      paramMapFragment.i();
      return;
    }
    if (!h.a(paramMapFragment.getActivity(), d))
    {
      paramMapFragment.k();
      return;
    }
    paramMapFragment.j();
  }
  
  static void b(MapFragment paramMapFragment)
  {
    if (h.a(paramMapFragment.getActivity(), d))
    {
      paramMapFragment.i();
      return;
    }
    if (h.a(paramMapFragment.getActivity(), d))
    {
      paramMapFragment.a(new a(paramMapFragment, null));
      return;
    }
    paramMapFragment.requestPermissions(d, 19);
  }
  
  private static final class a
    implements g
  {
    private final WeakReference<MapFragment> a;
    
    private a(MapFragment paramMapFragment)
    {
      this.a = new WeakReference(paramMapFragment);
    }
    
    public void a()
    {
      MapFragment localMapFragment = (MapFragment)this.a.get();
      if (localMapFragment == null) {
        return;
      }
      localMapFragment.requestPermissions(bn.a(), 19);
    }
    
    public void b()
    {
      MapFragment localMapFragment = (MapFragment)this.a.get();
      if (localMapFragment == null) {
        return;
      }
      localMapFragment.j();
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */