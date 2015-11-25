import java.io.*;
import java.util.Scanner;

public class main 
{
   public static void main (String[] args) 
   {
      Console console = System.console();
      String username, password;
      Scanner in = new Scanner(System.in);
      Account user = null;
      SocietyInventory societies = new SocietyInventory();
      AccountInventory accounts = new AccountInventory();
      societies.loadSocieties();
      societies.saveSocieties();
      accounts.loadAccounts();
      accounts.saveAccounts();
      //System.out.println(accounts.toString());
      //System.out.println(societies.toString());


      System.out.println("Welcome to MUN Society ");


      while (!in.next().equals("quit"))
      {

         

         while (user == null) {
            System.out.println("Please login in to continue");
            System.out.print("login: ");
            username = in.next();
            System.out.print("password: ");
            password = in.next();
            int i = accounts.login(username, password);
            if (i != -1) {
               user = accounts.getAccounts().get(i);
            }

         }   

         System.out.println("\n\nWhat would you like to do next?");
         System.out.println("+------------------------------------+");
         System.out.println("+ View societies [view]");
         System.out.println("+------------------------------------+");
         System.out.println("+ Create soceity [create]");
         System.out.println("+------------------------------------+");
         
         String command = in.next();
         switch (command) {
            case "view": System.out.println("+---------------------------------------------------------");
                         System.out.println(societies.toString());
                         break;
            case "create": System.out.println("Enter information for new society");
                           System.out.print("Name: ");
                           String name = console.readLine();
                           System.out.print("Description: ");
                           String description = console.readLine();
                           System.out.println();
                           Society newSociety = new Society(name, description);
                           newSociety.addMember(user);
                           societies.addSociety(newSociety);
                           societies.saveSocieties();
                           System.out.println("Society " + name + " was created");
                           break;
         }
       
      }
   }
}
