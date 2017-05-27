package com.mobike.mobikeapp.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.middleware.GeoRange;
import com.bumptech.glide.g;
import com.bumptech.glide.l;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.o;
import com.hyphenate.chat.ChatClient;
import com.hyphenate.chat.ChatClient.Options;
import com.hyphenate.chat.Message;
import com.hyphenate.helpdesk.easeui.UIProvider;
import com.hyphenate.helpdesk.easeui.UIProvider.UserProfileProvider;
import com.mobike.mobikeapp.model.c.c;

public class i
{
  public static i a()
  {
    return a.a();
  }
  
  private void b()
  {
    UIProvider.getInstance().setUserProfileProvider(new UIProvider.UserProfileProvider()
    {
      public void setNickAndAvatar(Context paramAnonymousContext, Message paramAnonymousMessage, ImageView paramAnonymousImageView, TextView paramAnonymousTextView)
      {
        l.c(paramAnonymousContext).a(q.a().l(paramAnonymousContext)).d(2130837626).a(DiskCacheStrategy.SOURCE).e().a(new com.bumptech.glide.load.f[] { new c(paramAnonymousContext, -1) }).g().a(paramAnonymousImageView);
      }
    });
    UIProvider.getInstance().setShowProgress(true);
  }
  
  public void a(Context paramContext)
  {
    if (!GeoRange.inCHINA()) {}
    ChatClient.Options localOptions;
    do
    {
      return;
      localOptions = new ChatClient.Options();
      localOptions.setAppkey("1187161213178428#kefuchannelapp32172");
      localOptions.setTenantId("32172");
    } while (!ChatClient.getInstance().init(paramContext, localOptions));
    UIProvider.getInstance().init(paramContext);
    b();
    ChatClient.getInstance().setDebugMode(false);
  }
  
  private static class a
  {
    private static final i a = new i(null);
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */