import java.io.Serializable;
import java.util.*;
public class SocietyEvent implements Serializable
{
    private String name;
    private String time;
    private String description;
    
    public SocietyEvent(String n, String t, String des){
    	this.name=n;
    	this.time=t;
    	this.description=des;
    	
    }
	
    public SocietyEvent() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
       return description;
    }
	
    public void setName(String NAME) {
       this.name = name;
    }
	
    public String getName() {
       return name;
    }
	
    public void setTime(String b) {
       this.time = time;
    }

    public String getTime() {
       return time;
    }
	
    public void setDescription(String desc) {
       this.description = desc;
    }
	
    public void invite(Society s, String m) {
		//message g;
                // removed to compile, will be added later in development 
		//g.all(m,s);
    }
	
}

