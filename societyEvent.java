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
	
	public boolean socEvnEqual(societyEvent b){
     if (this.getName()==b.getName())
      {return true;}
     else{return false;}
      }
	
}

