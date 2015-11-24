import java.io.*;
import java.util.Scanner;

public class main 
{
   public static void main (String[] args) 
   {
      String username, password;
      Account user = new Account();
      Scanner in = new Scanner(System.in);
      
      SocietyInventory societies = new SocietyInventory();
      AccountInventory accounts = new AccountInventory();
      societies.loadSocieties();
      accounts.loadAccounts();
      

      while (!in.next().equals("quit"))
      {

         System.out.println("Welcome to MUN Society Online");

         while (user != null) {
            System.out.println("Please login in to continue");
            System.out.println("login: ");
            username = in.next();
            System.out.println("password: ");
            password = in.next();
            user = user.login(username, password, accounts);
         }


     
      }
   }
}
