package com.mobike.mobikeapp;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.ab;
import android.support.annotation.ag;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baidu.middleware.GeoRange;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.GridPasswordView.a;
import com.jungly.gridpasswordview.PasswordType;
import com.mobike.mobikeapp.a.f;
import com.mobike.mobikeapp.data.UnlockBikeInfo;
import com.mobike.mobikeapp.data.UnlockBikeInfo.UserPrize;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.service.BluetoothService;
import com.mobike.mobikeapp.util.RideManager;
import com.mobike.mobikeapp.util.RideManager.d;
import com.mobike.mobikeapp.util.m;
import com.mobike.mobikeapp.util.o;
import com.mobike.mobikeapp.util.q;
import com.mobike.mobikeapp.widget.LoadingToastView;
import com.mobike.mobikeapp.widget.LockAnimView;
import com.mobike.mobikeapp.widget.TreasureAnimView;
import com.mobike.mobikeapp.widget.TreasureAnimView.a;
import com.mobike.mobikeapp.widget.TreasureWebView;
import com.mobike.mobikeapp.widget.TreasureWebView.a;
import com.umeng.analytics.MobclickAgent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@b.a.j
public class QRCodeInputActivity
  extends QRCodeBaseActivity
  implements SurfaceHolder.Callback, TreasureAnimView.a, TreasureWebView.a
{
  private static final String a = QRCodeInputActivity.class.getSimpleName();
  private android.support.v7.app.j A;
  private RideManager.d B = null;
  private BroadcastReceiver C = null;
  private Handler D = new Handler();
  private ViewStub E;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  private View b;
  private GridPasswordView k;
  private LockAnimView l;
  private Button m;
  @BindView(a=2131755240)
  TreasureAnimView mTreasureAnimView;
  @BindView(a=2131755239)
  TreasureWebView mTreasureWebView;
  private Button n;
  private Camera o;
  private Camera.Parameters p;
  private boolean q = false;
  private TextView r;
  private CountDownTimer s;
  private LoadingToastView t;
  private boolean u;
  private ImageView v;
  private ImageView w;
  private ImageView x;
  private Animation y;
  private Animation z;
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    com.mobike.mobikeapp.model.a locala = new com.mobike.mobikeapp.model.a(this);
    localArrayList.add(new Pair(Integer.valueOf(2131755509), br.a(locala)));
    paramString = new Pair(Integer.valueOf(2131755224), paramString);
    locala.e(2130968695).f(290).a(paramString).a(localArrayList);
    locala.show();
  }
  
  private void a(String paramString, int paramInt)
  {
    if (isFinishing()) {}
    do
    {
      return;
      b.a locala = new b.a(this, 2131427642);
      locala.a(false);
      locala.b(paramString).a(2131296624, new DialogInterface.OnClickListener()
      {
        @Instrumented
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
          paramAnonymousDialogInterface.dismiss();
          QRCodeInputActivity.e(QRCodeInputActivity.this).a();
          QRCodeInputActivity.t(QRCodeInputActivity.this).postDelayed(new Runnable()
          {
            public void run()
            {
              QRCodeInputActivity.e(QRCodeInputActivity.this).performClick();
            }
          }, 200L);
        }
      });
      locala.c();
    } while (paramInt != -1);
    s();
  }
  
  private void m()
  {
    this.z.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        QRCodeInputActivity.h(QRCodeInputActivity.this).setVisibility(0);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        QRCodeInputActivity.e(QRCodeInputActivity.this).performClick();
      }
    });
    this.w.setVisibility(0);
    this.w.startAnimation(this.y);
    this.v.startAnimation(this.z);
  }
  
  private void n()
  {
    h.a(this, this.k);
    this.r.setText(getString(2131296915, new Object[] { o.a("2000") }));
    this.r.setTextColor(ContextCompat.getColor(this, 2131624078));
    this.s = new CountDownTimer(3000L, 1000L)
    {
      public void onFinish()
      {
        QRCodeInputActivity.i(QRCodeInputActivity.this).setEnabled(true);
        QRCodeInputActivity.i(QRCodeInputActivity.this).setText(2131296481);
      }
      
      public void onTick(long paramAnonymousLong)
      {
        int i = Math.round((float)(paramAnonymousLong / 1000L));
        QRCodeInputActivity.i(QRCodeInputActivity.this).setText(QRCodeInputActivity.this.getString(2131296481) + "(" + i + ")");
      }
    };
    this.s.start();
  }
  
  private void o()
  {
    if (getString(2131296626).equals(this.r.getText())) {
      return;
    }
    if (this.s != null)
    {
      this.s.cancel();
      this.s = null;
    }
    if (this.n.isEnabled()) {
      this.n.setEnabled(false);
    }
    this.n.setText(2131296481);
    p();
  }
  
  private void p()
  {
    this.r.setText(2131296626);
    this.r.setTextColor(ContextCompat.getColor(this, 2131624119));
  }
  
  private void q()
  {
    if (h.l(this))
    {
      this.t.a();
      this.n.setEnabled(false);
      com.mobike.mobikeapp.util.a.a(this, false);
      final String str = this.k.getPassWord();
      this.B = new RideManager.d()
      {
        public Context a()
        {
          return QRCodeInputActivity.this;
        }
        
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            QRCodeInputActivity.this.runOnUiThread(bt.a(this));
            return;
          case 1: 
            QRCodeInputActivity.this.runOnUiThread(bu.a(this, str));
            return;
          case 50: 
            QRCodeInputActivity.this.runOnUiThread(bv.a(this, paramAnonymousString));
            return;
          case 100: 
            QRCodeInputActivity.this.runOnUiThread(bw.a(this, paramAnonymousString));
            return;
          }
          QRCodeInputActivity.this.runOnUiThread(bx.a(this));
        }
        
        public void a(UnlockBikeInfo paramAnonymousUnlockBikeInfo)
        {
          if ((!q.a().b()) || (paramAnonymousUnlockBikeInfo.userPrize == null) || (!GeoRange.inCHINA()))
          {
            QRCodeInputActivity.a(QRCodeInputActivity.this, true);
            return;
          }
          String str = paramAnonymousUnlockBikeInfo.userPrize.prizeLink;
          paramAnonymousUnlockBikeInfo = str;
          if (com.mobike.mobikeapp.util.a.a("en")) {
            paramAnonymousUnlockBikeInfo = Uri.parse(str).buildUpon().appendQueryParameter("lang", com.mobike.mobikeapp.util.a.n()).toString();
          }
          QRCodeInputActivity.this.mTreasureWebView.a(paramAnonymousUnlockBikeInfo);
          QRCodeInputActivity.this.mTreasureAnimView.setAlpha(0.0F);
          QRCodeInputActivity.this.mTreasureAnimView.setVisibility(0);
          ObjectAnimator.ofFloat(QRCodeInputActivity.this.mTreasureAnimView, "alpha", new float[] { 1.0F }).setDuration(300L).start();
        }
        
        public void a(String paramAnonymousString, int paramAnonymousInt)
        {
          QRCodeInputActivity.this.runOnUiThread(bs.a(this, paramAnonymousInt, paramAnonymousString));
        }
        
        public void b()
        {
          Context localContext = QRCodeInputActivity.this.getApplicationContext();
          h.c(localContext);
          com.mobike.mobikeapp.util.a.f(localContext);
          RideManager.a().s();
          QRCodeInputActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              QRCodeInputActivity.j(QRCodeInputActivity.this).b();
            }
          });
        }
        
        public BroadcastReceiver c()
        {
          if (QRCodeInputActivity.k(QRCodeInputActivity.this) == null) {
            QRCodeInputActivity.a(QRCodeInputActivity.this, new BroadcastReceiver()
            {
              @ag(b=18)
              public void onReceive(Context paramAnonymous2Context, Intent paramAnonymous2Intent)
              {
                paramAnonymous2Context = paramAnonymous2Intent.getAction();
                BluetoothService localBluetoothService = RideManager.a().e();
                if (paramAnonymous2Context.equals("com.mobike.ACTION_GATT_CONNECTED")) {}
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramAnonymous2Context.equals("com.mobike.ACTION_GATT_SERVICES_DISCOVERED"))
                      {
                        QRCodeInputActivity.a(QRCodeInputActivity.this, new CountDownTimer(10000L, 1000L)
                        {
                          public void onFinish()
                          {
                            MobclickAgent.c(QRCodeInputActivity.this, "01002");
                            QRCodeInputActivity.a(QRCodeInputActivity.this, RideManager.a().E());
                            QRCodeInputActivity.l(QRCodeInputActivity.this).start();
                          }
                          
                          public void onTick(long paramAnonymous3Long) {}
                        });
                        QRCodeInputActivity.l(QRCodeInputActivity.this).start();
                        return;
                      }
                      if (!paramAnonymous2Context.equals("com.mobike.DEVICE_DOES_NOT_SUPPORT_UART")) {
                        break;
                      }
                    } while (localBluetoothService == null);
                    localBluetoothService.b();
                    return;
                    if (paramAnonymous2Context.equals("com.mobike.ACTION_DATA_WRITE_DONE"))
                    {
                      RideManager.a().b(false);
                      return;
                    }
                    if (!paramAnonymous2Context.equals("com.mobike.ACTION_DATA_AVAILABLE")) {
                      break;
                    }
                  } while (!paramAnonymous2Intent.hasExtra("com.mobike.EXTRA_DATA"));
                  paramAnonymous2Context = paramAnonymous2Intent.getByteArrayExtra("com.mobike.EXTRA_DATA");
                  if (QRCodeInputActivity.l(QRCodeInputActivity.this) != null)
                  {
                    QRCodeInputActivity.l(QRCodeInputActivity.this).cancel();
                    QRCodeInputActivity.a(QRCodeInputActivity.this, null);
                  }
                  if (paramAnonymous2Context.length == 1)
                  {
                    QRCodeInputActivity.a(QRCodeInputActivity.this, RideManager.a().E());
                    QRCodeInputActivity.l(QRCodeInputActivity.this).start();
                    return;
                  }
                  RideManager.a().a(QRCodeInputActivity.this, paramAnonymous2Context);
                  return;
                } while (!paramAnonymous2Context.equals("com.mobike.ACTION_GATT_DISCONNECTED"));
                if (RideManager.a().G())
                {
                  RideManager.a().F();
                  return;
                }
                RideManager.a().b(QRCodeInputActivity.this, QRCodeInputActivity.k(QRCodeInputActivity.this));
                RideManager.a().a(QRCodeInputActivity.m(QRCodeInputActivity.this), 7, false);
              }
            });
          }
          return QRCodeInputActivity.k(QRCodeInputActivity.this);
        }
      };
      RideManager.a().a(this, str, this.B);
      MobclickAgent.c(getApplicationContext(), "00012");
      return;
    }
    h.a(this, getString(2131296740));
  }
  
  private void r()
  {
    this.mTreasureAnimView.setVisibility(8);
    this.mTreasureWebView.setVisibility(8);
    setResult(-1);
    finish();
    overridePendingTransition(17432576, 17432577);
  }
  
  private void s()
  {
    f.d(new com.mobike.mobikeapp.model.b.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(int paramAnonymousInt, cz.msebera.android.httpclient.d[] paramAnonymousArrayOfd, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousJSONObject != null)
        {
          paramAnonymousArrayOfd = paramAnonymousJSONObject.optString("message");
          QRCodeInputActivity.a(QRCodeInputActivity.this, paramAnonymousArrayOfd);
        }
      }
    });
  }
  
  private void t()
  {
    if (((this.I) && (this.J)) || (this.K))
    {
      k();
      setResult(-1);
      l();
    }
  }
  
  private void u()
  {
    if (!this.H)
    {
      t();
      return;
    }
    setResult(-1);
    l();
  }
  
  @e(a={"android.permission.CAMERA"})
  void a()
  {
    h.a(this, 2131296814);
  }
  
  @b.a.d(a={"android.permission.CAMERA"})
  void b()
  {
    h.a(this, 2131296814);
  }
  
  @b.a.c(a={"android.permission.CAMERA"})
  void c()
  {
    this.m.setSelected(true);
    try
    {
      if (this.o == null) {
        this.o = Camera.open();
      }
      if (this.o == null) {
        return;
      }
      Camera.Parameters localParameters = this.o.getParameters();
      if (localParameters != null)
      {
        com.google.zxing.client.android.camera.c.a(localParameters, true);
        this.o.setParameters(localParameters);
        this.o.startPreview();
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.o != null)
      {
        this.o.release();
        this.o = null;
      }
    }
  }
  
  @b.a.c(a={"android.permission.CAMERA"})
  void d()
  {
    this.m.setSelected(false);
    if (this.o == null) {
      return;
    }
    Camera.Parameters localParameters = this.o.getParameters();
    com.google.zxing.client.android.camera.c.a(localParameters, false);
    this.o.setParameters(localParameters);
    this.o.stopPreview();
  }
  
  public void e()
  {
    this.G = true;
    if ((this.F) && (this.G)) {
      this.mTreasureWebView.a();
    }
  }
  
  public void f()
  {
    this.J = true;
    this.d.setVisibility(4);
    if (this.I)
    {
      setResult(-1);
      l();
    }
    for (;;)
    {
      ObjectAnimator.ofFloat(this.mTreasureWebView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(500L).start();
      return;
      this.mTreasureAnimView.setVisibility(8);
      this.mTreasureWebView.setVisibility(8);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      if (paramInt2 != -1) {
        break label37;
      }
      if (Build.VERSION.SDK_INT >= 18) {
        RideManager.a().a(this, this.B.c());
      }
    }
    return;
    label37:
    RideManager.a().a(this.B, 8, true);
  }
  
  public void onAnimComplete(View paramView)
  {
    this.mTreasureAnimView.setVisibility(8);
    this.mTreasureWebView.bringToFront();
    this.mTreasureWebView.setVisibility(0);
    this.F = true;
    if ((this.F) && (this.G)) {
      this.mTreasureWebView.a();
    }
  }
  
  public void onBackPressed()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Is lock exception ");
    String str;
    if (this.K)
    {
      str = "EXCEPTION";
      m.a(str);
      if (this.e) {
        break label55;
      }
      l();
    }
    label55:
    do
    {
      return;
      str = "OK";
      break;
      if (this.K)
      {
        l();
        return;
      }
      if ((this.J) && (this.I))
      {
        m.a("mTreasureClosed && mLockProgressDone");
        setResult(0);
        l();
        return;
      }
      if (this.J)
      {
        m.a("else if(mTreasureClosed)");
        h.a(this, getString(2131297085));
        return;
      }
      if (this.I)
      {
        m.a("else if(mLockProgressDone)");
        f();
        return;
      }
      if (!this.H) {
        break label182;
      }
      m.a("else if(isTeasureSkip)");
    } while ((this.l == null) || (!this.l.f()));
    h.a(this, getString(2131297085));
    return;
    label182:
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968621);
    ButterKnife.a(this);
    this.b = findViewById(2131755231);
    this.n = ((Button)findViewById(2131755237));
    this.r = ((TextView)findViewById(2131755236));
    this.k = ((GridPasswordView)findViewById(2131755235));
    this.k.setPasswordVisibility(true);
    if (!GeoRange.inCHINA()) {
      this.k.setPasswordType(PasswordType.TEXTVISIBLE);
    }
    for (;;)
    {
      this.n.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          QRCodeInputActivity.a(QRCodeInputActivity.this);
        }
      });
      this.k.setOnPasswordChangedListener(new GridPasswordView.a()
      {
        public void a(String paramAnonymousString)
        {
          if (!QRCodeInputActivity.b(QRCodeInputActivity.this))
          {
            if (paramAnonymousString.length() == 10) {
              QRCodeInputActivity.c(QRCodeInputActivity.this);
            }
          }
          else {
            return;
          }
          QRCodeInputActivity.d(QRCodeInputActivity.this);
        }
        
        public void b(String paramAnonymousString)
        {
          if (QRCodeInputActivity.b(QRCodeInputActivity.this))
          {
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("qrcode", QRCodeInputActivity.e(QRCodeInputActivity.this).getPassWord());
            QRCodeInputActivity.this.setResult(-1, paramAnonymousString);
            QRCodeInputActivity.this.finish();
          }
        }
      });
      this.m = ((Button)findViewById(2131755230));
      this.m.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (QRCodeInputActivity.f(QRCodeInputActivity.this).isSelected())
          {
            bz.b(QRCodeInputActivity.this);
            return;
          }
          bz.a(QRCodeInputActivity.this);
        }
      });
      paramBundle = getIntent().getAction();
      if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("com.mobike.action.getQRCode")))
      {
        setTitle(2131296627);
        this.n.setVisibility(8);
        this.q = true;
      }
      this.t = ((LoadingToastView)findViewById(2131755754));
      this.v = ((ImageView)findViewById(2131755233));
      this.w = ((ImageView)findViewById(2131755234));
      this.x = ((ImageView)findViewById(2131755232));
      this.y = AnimationUtils.loadAnimation(this, 2131034181);
      this.z = AnimationUtils.loadAnimation(this, 2131034182);
      this.D.postDelayed(new Runnable()
      {
        public void run()
        {
          QRCodeInputActivity.g(QRCodeInputActivity.this);
        }
      }, 500L);
      this.mTreasureAnimView.setOnAnimationListener(this);
      this.mTreasureWebView.setOnBridgeListener(this);
      return;
      this.k.setPasswordType(PasswordType.NUMBER);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    String str = getIntent().getAction();
    if ((str != null) && (str.equals("com.mobike.action.getQRCode"))) {
      return super.onCreateOptionsMenu(paramMenu);
    }
    getMenuInflater().inflate(2131820556, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    if (this.l != null) {
      this.l.e();
    }
    RideManager.a().d(this);
    super.onDestroy();
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default: 
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    case 16908332: 
      if ((this.l != null) && (this.l.f())) {
        h.a(this, getString(2131297085));
      }
      for (;;)
      {
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
        finish();
      }
    }
    d();
    startActivity(HelpCardActivity.a(this, new Integer[] { Integer.valueOf(4) }));
    VdsAgent.handleClickResult(new Boolean(true));
    return true;
  }
  
  protected void onPause()
  {
    if (this.o != null)
    {
      this.o.release();
      this.o = null;
    }
    this.z.cancel();
    this.y.cancel();
    ((SurfaceView)findViewById(2131755229)).getHolder().removeCallback(this);
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, @ab String[] paramArrayOfString, @ab int[] paramArrayOfInt)
  {
    bz.a(this, paramInt, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    ((SurfaceView)findViewById(2131755229)).getHolder().addCallback(this);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt > 15) && (!this.u))
    {
      this.u = true;
      new Thread(new Runnable()
      {
        public void run() {}
      });
    }
    super.onTrimMemory(paramInt);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.o == null)
    {
      this.o = Camera.open();
      this.p = this.o.getParameters();
    }
    try
    {
      this.o.setPreviewDisplay(paramSurfaceHolder);
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      this.o.release();
      this.o = null;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.o != null)
    {
      this.o.stopPreview();
      this.o.setPreviewCallback(null);
      this.o.release();
      this.o = null;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/QRCodeInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */