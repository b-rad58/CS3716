import java.util.*;
public class admin 
{
	private Society societyName;
	/*public void deleteStu(student b)
	{societyName.removeStu(b);}
	 */
	/*public void createEvent(societyEvent b)
	{message c;
        c.all(b,societyName);}
        */
        //removed to compile will be added in later in development
	public Society getSociety()
	{return societyName;}


	/*public void assignBoardMem(student b,String pos)
	{ societyName.setBoardMember(b);
        b.setPos(pos);
        }*/
        
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

          /*if (this.x != ((Simple)other).x)
         {
         return false;
         }

         if (!this.str.equals(((Simple)other).str))
         {
         return false;
         }*/

         return true;
       }
	
}