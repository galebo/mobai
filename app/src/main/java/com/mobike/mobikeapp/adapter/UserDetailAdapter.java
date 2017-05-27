package com.mobike.mobikeapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mobike.mobikeapp.data.CountryEnum;
import com.mobike.mobikeapp.data.UserDetailInfo;
import com.mobike.mobikeapp.model.c.h;
import com.mobike.mobikeapp.util.q;
import java.util.List;

public class UserDetailAdapter
  extends BaseAdapter
{
  private List<UserDetailInfo> a;
  private Context b;
  
  public UserDetailAdapter(List<UserDetailInfo> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1: 
    case 2: 
    case 3: 
    default: 
      return 2131297102;
    case 0: 
      return 2131297123;
    case 5: 
      return 2131297124;
    case 4: 
      return 2131297130;
    }
    return 2131297128;
  }
  
  public void a(int paramInt, String paramString)
  {
    ((UserDetailInfo)this.a.get(paramInt)).setContent(paramString);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    UserDetailInfo localUserDetailInfo;
    label100:
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130968764, null);
      paramViewGroup = new HolderView(paramView);
      paramView.setTag(paramViewGroup);
      localUserDetailInfo = (UserDetailInfo)this.a.get(paramInt);
      switch (paramInt)
      {
      case 3: 
      default: 
        paramViewGroup.content.setText(localUserDetailInfo.getContent());
        if ((localUserDetailInfo.isClickable()) || (paramInt == 4) || (paramInt == 5))
        {
          localObject = ContextCompat.getDrawable(this.b, 2130837946);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramViewGroup.content.setCompoundDrawables(null, null, (Drawable)localObject, null);
          paramViewGroup.content.setCompoundDrawablePadding(h.a(this.b, 5.0F));
          paramViewGroup.rootView.setBackgroundResource(2130837976);
          label183:
          paramViewGroup.name.setText(localUserDetailInfo.getTitle());
          paramViewGroup = paramViewGroup.margin;
          if (!localUserDetailInfo.isMargin()) {
            break label630;
          }
        }
        break;
      }
    }
    label630:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (HolderView)paramView.getTag();
      break;
      paramViewGroup.content.setTextColor(ContextCompat.getColor(this.b, 2131623995));
      paramViewGroup.content.setText(localUserDetailInfo.getContent());
      break label100;
      paramViewGroup.content.setTextColor(ContextCompat.getColor(this.b, 2131623995));
      if (!TextUtils.isEmpty(localUserDetailInfo.getContent()))
      {
        paramViewGroup.content.setText(localUserDetailInfo.getContent());
        break label100;
      }
      paramViewGroup.content.setText(2131297101);
      break label100;
      if (q.a().g() == CountryEnum.China)
      {
        if (Integer.valueOf(localUserDetailInfo.getContent()).intValue() == 0)
        {
          paramViewGroup.rootView.setBackgroundColor(-1);
          paramViewGroup.content.setText(2131296882);
          paramViewGroup.content.setTextColor(ContextCompat.getColor(this.b, 2131624129));
          break label100;
        }
        paramViewGroup.rootView.setBackgroundResource(2130838338);
        paramViewGroup.content.setText(2131296885);
        paramViewGroup.content.setTextColor(ContextCompat.getColor(this.b, 2131624078));
        break label100;
      }
      paramViewGroup.rootView.setVisibility(8);
      break label100;
      TextView localTextView = paramViewGroup.content;
      if (!TextUtils.isEmpty(localUserDetailInfo.getContent())) {}
      for (localObject = localUserDetailInfo.getContent();; localObject = this.b.getString(2131296998))
      {
        localTextView.setText((CharSequence)localObject);
        break;
      }
      if (q.a().g() == CountryEnum.China)
      {
        int i = q.a().d(this.b);
        if ((i == 1) || (i == 5) || (i == 6))
        {
          paramViewGroup.rootView.setBackgroundResource(2130838338);
          paramViewGroup.content.setText(a(i));
          paramViewGroup.content.setTextColor(ContextCompat.getColor(this.b, 2131624078));
          break label100;
        }
        paramViewGroup.rootView.setBackgroundColor(-1);
        paramViewGroup.content.setText(a(i));
        paramViewGroup.content.setTextColor(ContextCompat.getColor(this.b, 2131624129));
        break label100;
      }
      paramViewGroup.rootView.setVisibility(8);
      break label100;
      paramViewGroup.content.setCompoundDrawables(null, null, null, null);
      paramViewGroup.rootView.setBackgroundColor(-1);
      break label183;
    }
  }
  
  public static class HolderView
  {
    @BindView(a=2131755723)
    TextView content;
    @BindView(a=2131755705)
    View margin;
    @BindView(a=2131755541)
    TextView name;
    @BindView(a=2131755722)
    RelativeLayout rootView;
    
    public HolderView(View paramView)
    {
      ButterKnife.a(this, paramView);
    }
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/adapter/UserDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */