import java.util.*;
import java.io.*;

public class Account implements Serializable
{
   private Student stu;
   private String username;
   private String pass;

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

   public Student getStudent() {
      return stu;
   }
  
   public void setStudent(Student stu) {
      this.stu = stu;
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
   
   public Account login(String username, String password, AccountInventory accounts) {
      Account user = accounts.getAccount(username);
      if (user != null) {
         if (user.getPassword().equals(password)) 
            return user;
         else {
           System.out.println("Incorrect Password");
           return null;
         }
      }
      else {
         System.out.println("Incorrect Username");
         return null;
      }
   }
} 
