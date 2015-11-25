import java.util.*;
public class admin 
{
	private society societyName;
	public void deleteStu(student b)
	{societyName.removeStu(b);}

	/*public void createEvent(societyEvent b)
	{message c;
        c.all(b,societyName);}
        */
        //removed to compile will be added in later in development
	public society getSociety()
	{return societyName;}


	public void assignBoardMem(student b,String pos)
	{ societyName.setBoardMember(b);
        b.setPos(pos);
        }
        
        public boolean equals(admin other)
        {
         if (other == null)
         {
         return false;
         }

          if (this.getClass() != other.getClass())
          {
           return false;
          }

          if (this.getSociety != (other).getSociety)
         {
         return false;
         }
         return true;
       }
       
       public String toString()
        {String b="the society this admin runs is :"+ this.getScoiety();
        return b;
        }
	
}
