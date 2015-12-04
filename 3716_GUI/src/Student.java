import java.util.*;
import java.io.Serializable;

public class Student implements Serializable
{
   private String stuName;
   private String stuNum;
   private String DOB;
   private String pos;
   private Mailbox mail;
  
   public Student(String name, String num, String dob, String pos) {
      this.stuName = name;
      this.stuNum = num;
      this.DOB = dob;
      this.pos = pos;
      mail = new Mailbox();
   }

   public String getName() {
      return stuName;
   }
	
   public String toString() {
      return "Student name: " + stuName + "\nStudent Number: " + "\nDOB: " + DOB + "\n"; 
   }
 
   public void setName(String stuName) {
      this.stuName = stuName;
   }
	
   public String getStuNum() {
      return stuNum;
   }
	
   public void setStuNum(String stuNum) {
      this.stuNum = stuNum;
   }
	
   public String getDOB() {
      return DOB;
   }
	
   public void setDOB(String DOB) {
      this.DOB = DOB;
   }

   public String getPos() {
      return pos;
   }
	
   public void setPos(String pos) {
      this.pos = pos;
   }

   public Mailbox getMailbox() {
      return mail;
   }
	
   public void setMailbox(Mailbox mail) {
      this.mail = mail;
   }
   public Student getStudent(){
	   return this;
   }
}
