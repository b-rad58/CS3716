import java.util.*;
public class society
{
	private ArrayList<student> members= new ArrayList<>();
        private ArrayList<student> boardMembers= new ArrayList<>();
	private String discription;
    private String name;
    private boolean scantioned;
         
        public int memberSize()
        { return members.size();
        }
        
	public student getAt(int i)
        {return members.get(i); }

	public student getmember(String b)
    {int loc=0;
      for (int i=0; i<members.size(); i++)
         {if (members.get(i).getName()==b)
              {loc = i;}
         
         }
       return members.get(loc);
    }
	
    public void AddStudent(student b,int i)
    {members.add(b);}
    public void removeStu(student b)
    {	for (int i=0; i<members.size(); i++)
             {if (members.get(i)==b)
               {members.set(i,null);}
             }
        
    }
    
    public void setBoardMember(student s)
     {boardMembers.add(s);}
    
    public void removeBoardMember(student s)
        {for (int i=0; i<boardMembers.size(); i++)
         {  if (boardMembers.get(i)==s)
                {boardMembers.remove(i);}
         }
}
	
    public String getDiscription()
    {return discription;}
	
    public void setDiscription(String b)
    {discription=b;}
	
    public String getName()
    {return name;}
	
    public void setName(String b)
    {name=b;}
	public void setAsScanctioned()
	{scantioned=true;}
	public void setAsNotScanctioned()
	{scantioned=false;}
}


