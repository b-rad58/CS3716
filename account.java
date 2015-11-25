import java.util.*;
public class account {
private student stu;
private String useName;
private String pass;
    public student getStu()
    {return stu;}
    
    public String toString()
        {String b="the student this account belongs to is :"+ this.getStu().getName();
        b=b+"the this account's username is :"+ this.getUseName();
        b=b+"the this account's password is :"+ this.getPass();
        return b;
        }	
    public void setStu(student b)
    {stu=b;}
	
    public String getUseName()
    {return useName;}
	
    public void setUseName(String b)
    {useName=b;}
	
    public String getPass()
    {return pass;}
	
    public void setPass(String b)
    {pass=b;}
    
    public boolean equals(account other)
{
   if (other == null)
   {
      return false;
   }

   if (this.getClass() != other.getClass())
   {
      return false;
   }

   if (this.x != ((Simple)other).x)
   {
      return false;
   }

   if (!this.str.equals(((Simple)other).str))
   {
      return false;
   }

   return true;
}
}

