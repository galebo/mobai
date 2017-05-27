package com.mobike.mobikeapp.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.ab;
import android.support.annotation.p;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.b;
import com.bumptech.glide.g;
import com.bumptech.glide.o;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.j;
import java.util.List;

public class HelpCardViewAdapter
  extends PagerAdapter
{
  private Activity a;
  private List<a> b;
  
  public HelpCardViewAdapter(@ab Activity paramActivity, @ab List<a> paramList)
  {
    this.a = paramActivity;
    this.b = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(this.a).inflate(2130968803, paramViewGroup, false);
    ViewHolder localViewHolder = new ViewHolder(localView);
    Object localObject = (a)this.b.get(paramInt);
    if (getCount() > 1)
    {
      localViewHolder.indexView.setText(paramInt + 1 + "/" + getCount());
      if (paramInt + 1 == getCount())
      {
        localViewHolder.nextView.setText(2131296592);
        localViewHolder.nextView.setOnClickListener(k.a(this));
        localViewHolder.middleView.setOnClickListener(m.a(this));
        localViewHolder.titleView.setText(((a)localObject).a);
        localViewHolder.contentView.setText(((a)localObject).b);
        if (((a)localObject).c <= 0) {
          break label270;
        }
        localObject = BitmapFactory.decodeResource(this.a.getResources(), ((a)localObject).c);
        localViewHolder.imageView.setImageBitmap(j.a((Bitmap)localObject, h.a(this.a, 3.0F), true, true, false, false));
      }
    }
    for (;;)
    {
      paramViewGroup.addView(localView);
      return localView;
      localViewHolder.nextView.setText(2131296743);
      localViewHolder.nextView.setOnClickListener(l.a(paramViewGroup, paramInt));
      break;
      localViewHolder.indexView.setVisibility(8);
      localViewHolder.nextView.setVisibility(8);
      localViewHolder.middleView.setVisibility(0);
      break;
      label270:
      com.bumptech.glide.l.a(this.a).a(((a)localObject).d).j().b(2130837716).g().b(new com.bumptech.glide.f.b.c(localViewHolder.imageView)
      {
        protected void a(Bitmap paramAnonymousBitmap)
        {
          super.a(j.a(paramAnonymousBitmap, h.a(HelpCardViewAdapter.a(HelpCardViewAdapter.this), 3.0F), true, true, false, false));
        }
      });
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public static class ViewHolder
  {
    @BindView(a=2131755810)
    TextView contentView;
    @BindView(a=2131755808)
    ImageView imageView;
    @BindView(a=2131755811)
    TextView indexView;
    @BindView(a=2131755812)
    TextView middleView;
    @BindView(a=2131755813)
    TextView nextView;
    @BindView(a=2131755809)
    TextView titleView;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.a(this, paramView);
    }
  }
  
  public static class a
  {
    public String a;
    public String b;
    @p
    public int c;
    public String d;
    
    public static a a(String paramString1, String paramString2, int paramInt)
    {
      a locala = new a();
      locala.a = paramString1;
      locala.b = paramString2;
      locala.c = paramInt;
      return locala;
    }
    
    public static a a(String paramString1, String paramString2, String paramString3)
    {
      a locala = new a();
      locala.a = paramString1;
      locala.b = paramString2;
      locala.d = paramString3;
      return locala;
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/HelpCardViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */