import java.util.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

// create student.equals method
public class Society implements Serializable
{
   private ArrayList<Account> members= new ArrayList<>();
   private ArrayList<Account> boardMembers= new ArrayList<>();
   private ArrayList<Account> vPCand= new ArrayList<>();
   private ArrayList<Account> SecCan= new ArrayList<>();
   private ArrayList<Account> TreCan= new ArrayList<>();
   private Map vPvotes = new HashMap();
   private Map sVotes = new HashMap();
   private Map tVotes = new HashMap();

private ArrayList<SocietyEvent> events = new ArrayList<>();
   private Map board = new HashMap();
   private String description;
   private String name;
   private Account president;
   private Account vicePresident;
   private Account secretary;
   private Account treasurer;
   private boolean sanctioned;
   private boolean aE;

   public Society(String name, String description,Account a) {
      this.name = name;
      this.description = description;
      sanctioned = false;
      president = a;
   }

   public Society() {
	// TODO Auto-generated constructor stub
}
   public ArrayList<Account> getvPCand() {
	return this.vPCand;
}
   public boolean getSanctioned(){
	   return sanctioned;
   }

public void setvPCand(ArrayList<Account> vPCand) {
	this.vPCand = vPCand;
}

public ArrayList<Account> getSecCan() {
	return SecCan;
}

public void setSecCan(ArrayList<Account> secCan) {
	SecCan = secCan;
}

public ArrayList<Account> getTreCan() {
	return TreCan;
}

public void setTreCan(ArrayList<Account> treCan) {
	TreCan = treCan;
}

public Account getVicePresident() {
	return vicePresident;
}

public void setVicePresident(Account vicePresident) {
	this.vicePresident = vicePresident;
}

public Account getSecretary() {
	return secretary;
}

public void setSecretary(Account secretary) {
	this.secretary = secretary;
}

public Account getTreasurer() {
	return treasurer;
}

public void setTreasurer(Account treasurer) {
	this.treasurer = treasurer;
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
	   System.out.print("Starting loop");
      for (int i=0; i<members.size(); i++) {
    	  System.out.println("looping");
    	  if (members.get(i).getStudent().getStuNum().equals(stu.getStudent().getStuNum())&& members.get(i).getStudent().getName().equals(stu.getStudent().getName())) {
    		  System.out.println("if check");
    		members.remove(i);
            System.out.println(stu.getStudent().getName()+" has been removed!");
            if (members.size() == 19)
               this.unSanctioned();
            break;
         }
      }        
   }
   
   public void removeEvent(SocietyEvent se) {
	   System.out.print("Starting loop");
      for (int i=0; i<events.size(); i++) {
    	  System.out.println("looping");
    	  if (events.get(i).getName().equals(se.getName())) {
    		  System.out.println("if check");
    		events.remove(i);
            System.out.println(se.getName()+ " has been removed!");

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
   
   public void setAe(boolean b){
	   this.aE=b;
   }
   public boolean getAe(){
	   return this.aE;
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

   public Society getSociety(){
	   return this;
   }
   public ArrayList<Account> getMemberList(){
	   return this.members;
   }
   
   public Account getPresident(){
	   return this.president;
   }
   
   public void setPresident(Account a){
	   this.president=a;
   }
   
   public void addEvent(SocietyEvent se){
	   events.add(se);
   }
   public ArrayList<SocietyEvent> getEventList(){
	   return this.events;
   }
   
   public void saveMembers() throws FileNotFoundException, UnsupportedEncodingException
   {

      ObjectOutputStream outputStream = null;
      try {
         outputStream = new ObjectOutputStream(new FileOutputStream("./"+this.getName()+".txt",false));
         for(int i=0; i < members.size(); i++)
         {
            Account temp = members.get(i);
            outputStream.writeObject(temp);
         } 
            outputStream.flush();
      }
      catch(FileNotFoundException ex) { 
         System.out.println("memberList not found"); 
      } 
      catch(IOException ex) {
         ex.printStackTrace(); 
      
	}
		finally {
         if (outputStream != null) {
            try {
               outputStream.close();
            } 
            catch (IOException ex) {
               System.out.println("oops");
            }         
         }
      }
   }
   public void loadMembers()
   {
      ObjectInputStream inputStream = null;
       try {
          inputStream = new ObjectInputStream(new FileInputStream("./"+this.getName()+".txt"));
          while(true) {
             try {
                this.members.add( (Account) inputStream.readObject());
             } 
             catch (EOFException ex) {
                inputStream.close();
                break;
             }
          }
       }
       catch(FileNotFoundException ex) { 
          System.out.println("societyList not found"); 
       } 
       catch(IOException ex) {
          ex.printStackTrace(); 
       }
       catch(ClassNotFoundException ex) {
          System.out.println("class not found");
       }
       finally {
          if (inputStream != null) {
             try {
                inputStream.close();
             } 
             catch (IOException ex) {
                System.out.println("oops");
             }         
          }
       }
    }
   
   public void getResults() {
	      if (vPCand.size() == 0) {
	         System.out.println("No nominees have been entered for VP");
	      }
	      Account vPwin = vPCand.get(0);
	      int numVotes = 0;
	      for (int i=0; i < vPCand.size(); i++) {
	         if ((int) vPvotes.get(vPCand.get(i)) > numVotes) {
	        	 vPwin = vPCand.get(i);
	            numVotes = (int) vPvotes.get(vPwin);
	         }
	      }
	      this.vicePresident=vPwin;
	      
	      if (SecCan.size() == 0) {
		         System.out.println("No nominees have been entered for sec");
		      }
		      Account secWin = SecCan.get(0);
		      numVotes = 0;
		      for (int i=0; i < SecCan.size(); i++) {
		         if ((int) sVotes.get(SecCan.get(i)) > numVotes) {
		        	 secWin = SecCan.get(i);
		            numVotes = (int) sVotes.get(secWin);
		         }
		      }
		      this.secretary=secWin;
		      
		      if (TreCan.size() == 0) {
			         System.out.println("No nominees have been entered for tre");
			      }
			      Account treWin = TreCan.get(0);
			      numVotes = 0;
			      for (int i=0; i < TreCan.size(); i++) {
			         if ((int) tVotes.get(TreCan.get(i)) > numVotes) {
			        	 treWin = TreCan.get(i);
			            numVotes = (int) tVotes.get(treWin);
			         }
			      }
			      this.treasurer=treWin;
			      
			      System.out.println("VicePresident: " +this.getVicePresident().getStudent().getName());
			      System.out.println("Secretary: " +this.getSecretary().getStudent().getName());
			      System.out.println("treasurer: " +this.getTreasurer().getStudent().getName());
		      
	   }

public Map getvPvotes() {
	return vPvotes;
}

public void setvPvotes(Map vPvotes) {
	this.vPvotes = vPvotes;
}

public Map getsVotes() {
	return sVotes;
}

public void setsVotes(Map sVotes) {
	this.sVotes = sVotes;
}

public Map gettVotes() {
	return tVotes;
}

public void settVotes(Map tVotes) {
	this.tVotes = tVotes;
}

}


