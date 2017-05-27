package com.mobike.mobikeapp.util;

import android.content.Context;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.h;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.AuthenticationException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;

public class z
{
  public static boolean a(a parama, Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      Stripe localStripe = new Stripe("pk_live_P8PIJN8yZUaIreN0eo3ifpU9");
      localStripe.createToken(new Card(paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2), new TokenCallback()
      {
        public void onError(Exception paramAnonymousException)
        {
          this.a.a(-1, paramAnonymousException.getLocalizedMessage());
        }
        
        public void onSuccess(Token paramAnonymousToken)
        {
          f.a(this.a, paramAnonymousToken.getId());
        }
      });
      return true;
    }
    catch (AuthenticationException parama)
    {
      h.a(paramContext, parama.getLocalizedMessage());
    }
    return false;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/util/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */