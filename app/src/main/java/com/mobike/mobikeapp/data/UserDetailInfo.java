package com.mobike.mobikeapp.data;

public class UserDetailInfo
{
  private String content;
  private boolean isClickable;
  private boolean isMargin;
  private String title;
  
  public UserDetailInfo(String paramString1, String paramString2)
  {
    this.content = paramString2;
    this.title = paramString1;
    this.isMargin = false;
  }
  
  public UserDetailInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.content = paramString2;
    this.isClickable = paramBoolean;
    this.title = paramString1;
    this.isMargin = false;
  }
  
  public UserDetailInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.title = paramString1;
    this.content = paramString2;
    this.isClickable = paramBoolean1;
    this.isMargin = paramBoolean2;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isClickable()
  {
    return this.isClickable;
  }
  
  public boolean isMargin()
  {
    return this.isMargin;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.isClickable = paramBoolean;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setMargin(boolean paramBoolean)
  {
    this.isMargin = paramBoolean;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              /WORK/jd-gui-windows-1.4.0/classes2-dex2jar.jar!/com/mobike/mobikeapp/data/UserDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */