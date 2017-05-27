package com.mobike.mobikeapp.activity.pay;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ab;
import android.support.annotation.ac;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import b.a.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.helpdesk.easeui.imageLoader.GlideImageLoader;
import com.mobike.mobikeapp.BaseActivity;
import com.mobike.mobikeapp.imagepicker.bean.ImageItem;
import com.mobike.mobikeapp.imagepicker.ui.ImageGridActivity;
import com.mobike.mobikeapp.util.AccountManager.PayApproach;
import com.mobike.mobikeapp.widget.LoadingToastView;
import com.mobike.mobikeapp.widget.NonFocusingScrollView;
import java.util.ArrayList;
import org.json.JSONObject;

@b.a.j
public class DepositRefundIssueActivity
  extends BaseActivity
{
  private static final int a = 100;
  private NonFocusingScrollView b;
  private GridView e;
  private b f;
  private ImageView g;
  private com.mobike.mobikeapp.imagepicker.b h;
  private String i;
  private EditText j;
  private Button k;
  private LoadingToastView l;
  private Handler m = new Handler();
  
  private void a(int paramInt)
  {
    this.f.a(paramInt);
    this.f.notifyDataSetChanged();
    this.j.setText(null);
    this.i = null;
    this.g.setImageResource(2130838129);
  }
  
  private void d()
  {
    this.b = ((NonFocusingScrollView)findViewById(2131755200));
    this.e = ((GridView)findViewById(2131755201));
    this.e.setVisibility(0);
    this.f = new b(null);
    this.e.setAdapter(this.f);
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        DepositRefundIssueActivity.a(DepositRefundIssueActivity.this, paramAnonymousInt);
      }
    });
    f();
    this.g = ((ImageView)findViewById(2131755202));
    this.g.setOnClickListener(e.a(this));
    k();
    ((TextView)findViewById(2131755204)).setOnClickListener(f.a(this));
    this.k = ((Button)findViewById(2131755205));
    this.k.setOnClickListener(g.a(this));
    this.k.setEnabled(false);
    this.l = ((LoadingToastView)findViewById(2131755754));
  }
  
  private void e()
  {
    android.support.v7.app.b localb = new b.a(this, 2131427642).b(2131296515).a(2131296624, new DialogInterface.OnClickListener()
    {
      @Instrumented
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
        paramAnonymousDialogInterface.dismiss();
        DepositRefundIssueActivity.this.setResult(-1);
        DepositRefundIssueActivity.this.finish();
      }
    }).b();
    localb.setCanceledOnTouchOutside(false);
    localb.show();
  }
  
  private void f()
  {
    this.h = com.mobike.mobikeapp.imagepicker.b.a();
    this.h.a(new GlideImageLoader());
    this.h.c(true);
    this.h.b(false);
    this.h.a(false);
    this.h.d(false);
  }
  
  private void k()
  {
    this.j = ((EditText)findViewById(2131755203));
    this.j.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        DepositRefundIssueActivity.a(DepositRefundIssueActivity.this).postDelayed(i.a(this), 250L);
        return false;
      }
    });
    this.j.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        DepositRefundIssueActivity.c(DepositRefundIssueActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void l()
  {
    Button localButton = this.k;
    if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.j.getText())) && (this.j.getText().toString().trim().matches("[a-zA-z0-9]+"))) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  @c(a={"android.permission.READ_EXTERNAL_STORAGE"})
  public void a()
  {
    startActivityForResult(new Intent(this, ImageGridActivity.class), 100);
  }
  
  @TargetApi(16)
  @b.a.e(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void b()
  {
    com.mobike.mobikeapp.model.c.h.a(this, getString(2131296509));
  }
  
  @TargetApi(16)
  @b.a.d(a={"android.permission.READ_EXTERNAL_STORAGE"})
  void c()
  {
    com.mobike.mobikeapp.model.c.h.a(this, getString(2131296509));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 1004)
    {
      if ((paramIntent != null) && (paramInt1 == 100))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("extra_result_items");
        this.i = ((ImageItem)paramIntent.get(0)).path;
        this.h.l().displayImage(this, ((ImageItem)paramIntent.get(0)).path, this.g);
        l();
        return;
      }
      paramIntent = Toast.makeText(this, 2131296756, 0);
      if (!(paramIntent instanceof Toast))
      {
        paramIntent.show();
        return;
      }
      VdsAgent.showToast((Toast)paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(@ac Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968615);
    d();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    j.a(this, paramInt, paramArrayOfInt);
  }
  
  private static class a
  {
    private AccountManager.PayApproach a;
    private int b;
    
    public a(AccountManager.PayApproach paramPayApproach, int paramInt)
    {
      this.a = paramPayApproach;
      this.b = paramInt;
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private DepositRefundIssueActivity.a[] b = { new DepositRefundIssueActivity.a(AccountManager.PayApproach.WX_PAY, 2131297158), new DepositRefundIssueActivity.a(AccountManager.PayApproach.ALI_PAY, 2131296394) };
    private int c = 0;
    
    private b() {}
    
    public AccountManager.PayApproach a()
    {
      return DepositRefundIssueActivity.a.a(this.b[this.c]);
    }
    
    public void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public int getCount()
    {
      return this.b.length;
    }
    
    public Object getItem(int paramInt)
    {
      return this.b[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = View.inflate(DepositRefundIssueActivity.this, 2130968805, null);
      }
      paramView = (TextView)paramViewGroup.findViewById(2131755817);
      paramView.setText(DepositRefundIssueActivity.a.b(this.b[paramInt]));
      if (this.c == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setSelected(bool);
        return paramViewGroup;
      }
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/activity/pay/DepositRefundIssueActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */