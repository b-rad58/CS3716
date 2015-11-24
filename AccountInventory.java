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

   public void saveAccounts()  {
      ObjectOutputStream outputStream = null;
      try {
         outputStream = new ObjectOutputStream(new FileOutputStream("./accountList.bin"));
         for(int i=0; i < accountList.size(); i++)
         {
            outputStream.writeObject(this);
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

  public void loadAccounts()
  {
     ObjectInputStream inputStream = null;
      try {
         inputStream = new ObjectInputStream(new FileInputStream("./accountList.txt"));
         int i=0;
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
         System.out.println("can't load"); 
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







}
