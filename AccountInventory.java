import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.Serializable;
//accounts and societies use the same save/load methods.  make an interface or abstract Inventory classs
public class AccountInventory implements Serializable
{
   private ArrayList<Account> accountList= new ArrayList<>();

   public AccountInventory(ArrayList<Account> accounts) {
      this.accountList = accounts;
   }


   public AccountInventory() {}


  
   public void addAccount(Account a) {
      accountList.add(a);
   }

  public ArrayList<Account> getAccounts() {
     return this.accountList;
  }

   public Account getAccount(String name) {
      Account a;
      for (int i =0; i<accountList.size()-1; i++) {
         a = accountList.get(i);
         if (a.getUsername().equals(name)) 
	    return accountList.get(i);    
      } 
      System.out.println("Account '" + name + "' not found");
      return null;
   }

   public String toString() {
      String result = "";
      for (int i=0; i<this.accountList.size(); i++) {
         result += this.accountList.get(i).toString();
      }
      return result;
   }
      
   public int login(String username, String password) {
      for (int i=0; i<accountList.size(); i++) {
         if (accountList.get(i).getUsername().equals(username) && accountList.get(i).getPassword().equals(password)) {
         System.out.println("Login succesful");
         return i;
         }
      }
      System.out.println("Incorrect Username/Password");
      return -1;      
    }
 
   public void saveAccounts()  {
      ObjectOutputStream outputStream = null;
      try {
         outputStream = new ObjectOutputStream(new FileOutputStream("./accountList.txt"));
         for(int i=0; i < accountList.size(); i++)
         {
            Account temp = accountList.get(i);
            outputStream.writeObject(temp);
         } 
            outputStream.flush();
      }
      catch(FileNotFoundException ex) { 
         System.out.println("accountList not found"); 
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

  public void loadAccounts()  {
     ObjectInputStream inputStream = null;
      try {
         inputStream = new ObjectInputStream(new FileInputStream("./accountList.txt"));
         while(true) {
            try {
               this.accountList.add((Account) inputStream.readObject());
            } 
            catch (EOFException ex) {
               inputStream.close();
               break;
            }
         }
      }
      catch(FileNotFoundException ex) { 
         System.out.println("accountList not found"); 
      } 
      catch(IOException ex) {
         ex.printStackTrace(); 
      }
      catch(ClassNotFoundException ex) {
         ex.printStackTrace();
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
}
