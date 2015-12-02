import java.util.*;
import java.io.*;

public class Account implements Serializable
{
   private Student stu;
   private String username;
   private String pass;
   private Mailbox box;

   public Account(Student stu, String username, String password) {
      this.stu = stu;
      this.username = username; 
      this.pass = password; 
   }
 
   public Account(Account acc) {
      this.stu = acc.getStudent();
      this.username = acc.getUsername();
      this.pass = acc.getPassword();
   }

   public Account () {}

   public String toString() {
      return "Student Number: " + stu.getStuNum() + "\nUsername: " + username + "\nPassword: " + pass;
   }

   public Student getStudent() {
      return stu;
   }
  
   public void setStudent(Student stu) {
      this.stu = stu;
   }
   public Mailbox getMailbox() {
      return box;
   }
  
   public void setMailbox(Mailbox g) {
      this.box = g;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return pass;
   }

   public void setPassword(String pass) {
      this.pass = pass;
   }    
   
   
   @Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (other == this) {
			return true;
		}

		if (!(other instanceof Account)) {
			return false;
		} else {
			Account o = (Account)other;
			if (this.getUsername() != o.getUsername()) {
				return false;
			}
			if (this.getPassword() != o.getPassword()) {
				return false;
			}
			if (this.getStudent() != o.getStudent()) {
				return false;
			}

		}
		return true;

	}
   
} 
