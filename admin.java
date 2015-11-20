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
	
}
