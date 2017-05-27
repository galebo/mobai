package com.mobike.mobikeapp.activity.usercenter;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import com.google.gson.e;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.data.UserAvatarInfo;
import com.mobike.mobikeapp.model.a.n;
import com.mobike.mobikeapp.model.b.a;
import com.mobike.mobikeapp.model.c.f;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.ClearableEditText;
import cz.msebera.android.httpclient.d;
import org.greenrobot.eventbus.c;
import org.json.JSONObject;

public class ModifyNickNameActivity
  extends BaseActivity
{
  private static InputFilter f = new InputFilter()
  {
    private final int a = 11;
    
    public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramAnonymousInt1 < paramAnonymousInt2)
      {
        if (Character.getType(paramAnonymousCharSequence.charAt(paramAnonymousInt1)) != 19) {
          break label34;
        }
        localObject1 = "";
      }
      label34:
      do
      {
        return (CharSequence)localObject1;
        paramAnonymousInt3 = 11 - (paramAnonymousSpanned.length() - (paramAnonymousInt4 - paramAnonymousInt3));
        if (paramAnonymousInt3 <= 0) {
          return "";
        }
        localObject1 = localObject2;
      } while (paramAnonymousInt3 >= paramAnonymousInt2 - paramAnonymousInt1);
      paramAnonymousInt3 += paramAnonymousInt1;
      paramAnonymousInt2 = paramAnonymousInt3;
      if (Character.isHighSurrogate(paramAnonymousCharSequence.charAt(paramAnonymousInt3 - 1)))
      {
        paramAnonymousInt3 -= 1;
        paramAnonymousInt2 = paramAnonymousInt3;
        if (paramAnonymousInt3 == paramAnonymousInt1) {
          return "";
        }
      }
      return paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt2);
    }
  };
  private TextView a;
  private ClearableEditText b;
  private String e;
  
  private void a()
  {
    this.b = ((ClearableEditText)findViewById(2131755283));
    this.b.setFilters(new InputFilter[] { f });
    this.e = f.a().e();
    ClearableEditText localClearableEditText = this.b;
    if (TextUtils.isEmpty(this.e)) {}
    for (String str = h.b(q.a().e());; str = this.e)
    {
      localClearableEditText.setText(str);
      this.b.setSelection(this.b.getText().length());
      this.a = ((TextView)findViewById(2131755282));
      this.a.setOnClickListener(k.a(this));
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968631);
    a();
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/usercenter/ModifyNickNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */