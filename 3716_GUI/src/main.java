import java.awt.EventQueue;
import java.io.*;
import java.util.Scanner;

public class main 
{
   public static  void main (String[] args) 
   {


      SocietyInventory societies = new SocietyInventory();
      AccountInventory accounts = new AccountInventory();
      societies.loadSocieties();
      accounts.loadAccounts();




      EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					mainframe frame = new mainframe();
 					frame.setVisible(true);
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		});


      System.out.println("Welcome to MUN Society ");

   }
}
