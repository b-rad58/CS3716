import java.util.*;
import java.io.Serializable;

// create student.equals method
public class Society implements java.io.Serializable
{
   private ArrayList<Student> members= new ArrayList<>();
   private ArrayList<Student> boardMembers= new ArrayList<>();
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
        
   public Student getAt(int i) {
      return members.get(i);
   }
	
   public Student getMember(String name) {
      for (int i=0; i<members.size(); i++) {
         if (members.get(i).getName() == name)
            return members.get(i);        
      }
      System.out.println(name + " is not a member of this society");
      return null;
   }
	
   public void addStudent(Student stu) {
      members.add(stu);
      if (members.size() == 20)
         this.becomeSanctioned();      
   }
 
   public void removeStudent(Student stu) {
      for (int i=0; i<members.size(); i++) {
         if (members.get(i) == stu) {
            members.remove(i);
            if (members.size() == 19)
               this.unSanctioned();
            break;
         }
      }        
   }
    
   public void setBoardMember(Student stu) {
      boardMembers.add(stu);
   }
    
   public void removeBoardMember(Student stu) {
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
}


