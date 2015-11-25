import java.util.*;
public class student {
private String stuName;
private String stuNum;
private String DOB;
private String Pos;
<<<<<<< HEAD
private mailbox owned;
=======
>>>>>>> e0c36026202835da7109d742124dee8cc9f9c3bc
    public String getName()
    {return stuName;}
	
    public void setName(String b)
    {stuName=b;}
	
    public String getNum()
    {return stuNum;}
	
    public void setStuNum(String b)
    {stuNum=b;}
	
    public String getDOB()
    {return DOB;}
	
    public void setDOB(String b)
    {DOB=b;}

    public String getPos()
    {return DOB;}
    
     public boolean equals(student other)
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
	
    public void setPos(String b)
    {DOB=b;}
<<<<<<< HEAD

    public mailbox getMailbox()
    {return owned;}
	
    public void setMailbox(mailbox b)
    {owned = b;}
=======
>>>>>>> e0c36026202835da7109d742124dee8cc9f9c3bc
}
