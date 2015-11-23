import java.util.*;
public class societyInvintory
{   
        private ArrayList<society> societyList= new ArrayList<>();
	public void addSociety(society b)
	{ societyList.add(b);}

        public society getSociety(String name)

	{ 
	for (int i =0; i<societyList.size()-1; i++)
		{society b= societyList.get(i);
                if (b.getName() ==name)
		    {return b;}
		else
		    {System.out.println("society not found");
                     return null;}
	    }
return null;
	}
}

