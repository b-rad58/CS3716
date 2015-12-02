import java.util.*;
import java.io.Serializable;

// create student.equals method
public class Society implements java.io.Serializable
{
   private ArrayList<Account> members= new ArrayList<>();
   private ArrayList<Account> boardMembers= new ArrayList<>();
   private Map board = new HashMap();
   private String description;
   private String name;
   private boolean sanctioned;

   public Society(String name, String description) {
      this.name = name;
      this.description = description;
      sanctioned = false;
   }

   public int numMembers() {
      return members.size();
   }
      
   public String toString() {
      return "+ Name: " + name + "\n+ Description: " + description + "\n+ Sanctioned: " + sanctioned + "\n+---------------------------------------------------------\n";
   } 
  
   public Account getAt(int i) {
      return members.get(i);
   }
	
   public Account getMember(String name) {
      for (int i=0; i<members.size(); i++) {
         if (members.get(i).getUsername() == name)
            return members.get(i);        
      }
      System.out.println(name + " is not a member of this society");
      return null;
   }
	
   public void addMember(Account acc) {
      members.add(acc);
      if (members.size() == 20) {
         this.becomeSanctioned();
         System.out.println("This society is now sanctioned!");
      }      
   }
 
   public void removeAccount(Account stu) {
      for (int i=0; i<members.size(); i++) {
         if (members.get(i) == stu) {
            members.remove(i);
            if (members.size() == 19)
               this.unSanctioned();
            break;
         }
      }        
   }
    
   public void setBoardMember(Account stu) {
      boardMembers.add(stu);
   }
    
   public void removeBoardMember(Account stu) {
      for (int i=0; i<boardMembers.size(); i++) {
         if (boardMembers.get(i) == stu)
            boardMembers.remove(i);
        }
   }
	
   public String getDescription() {
      return description;
    }
	
   public void setDescription(String desc) {
      description = desc;
   }
	
   public String getName() {
      return name;
   }
	
    public void setName(String name) {
       this.name = name;
    }

   public void becomeSanctioned() {
      sanctioned =true;
   }

   public void unSanctioned() {
      sanctioned = false;
   }
   
   
     @Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (other == this) {
			return true;
		}

		if (!(other instanceof Society)) {
			return false;
		} 
                else 
                {
			Society o = (Society)other;
			if (this.getName() != o.getName()) 
                        {
				return false;
			}
			if (this.getDescription() != o.getDescription()) 
                        {
				return false;
			}



                        for (int i=0; i<members.size(); i++)
                        {
                         if (this.getAt(i)!= o.getAt(i) ) 
                         {return false;}
        	
                        }
                         
                         for (int i=0; i<boardMembers.size(); i++)
                         {
                         if (this.getBoardAt(i) != o.getBoardAt(i)) 
                         {return false;}
                         }
			

		}
		return true;

	}
}


