import java.util.*;
public class societyEvent 
{
	private String name;
    private String time;
    private String description;
	
	public String getDescription()
    {return description;}
	
    public void setName(String b)
    {name=b;}
	public String getName()
    {return name;}
	
    public void setTime(String b)
    {time=b;}
	public String getTime()
    {return time;}
	
    public void setDescription(String b)
    {description=b;}
	
	public void invite (society s, String m)
	{
		message g;
		g.all(m,s);
	}
	
	public boolean equals(societyEvent other)
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

