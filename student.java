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
    
    public String toString()
   {String b="the student's name is : "+this.getName()+"n\ ";
    b="the student's number is : "+this.getNum()+"n\ ";
    b="the student's date of birth is : "+this.getDOB()+"n\ ";
    b="the student's position is : "+this.getPos()+"n\ "  ;
   }
	
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

   if (this.getName != (other).getName)
   {
      return false;
   }
   if (this.getNum != (other).getNum)
   {
      return false;
   }
   if (this.getDOB != (other).getDOB)
   {
      return false;
   }
   if (this.getPos != (other).getPos)
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
