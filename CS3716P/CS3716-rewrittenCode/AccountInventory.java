import java.util.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;


public class accountInvintory{
private ArrayList<account> accountList= new ArrayList<>();

	public void addAccount(account b)
	{ accountList.add(b);}

        public account getAccount(String name)
	{ boolean found= false;
          int loc =0;
	for (int i =0; i<accountList.size()-1; i++)
		{account b =accountList.get(i);
                if (b.getUseName() != name)
			{}
		else
		    {found =true;
                      loc = i;          }
	    }
          
	if (found = true)
          {return accountList.get(loc);}
          else{return null;}
	}
	public account search(String a)
	{       
boolean found= false;
          int loc =0;
	for (int i =0; i<accountList.size()-1; i++)
		{account b =accountList.get(i);
                if (b.getUseName() != a)
			{}
		else
		    {found =true;
                      loc = i;          }
	    }
          
	if (found = true)
          {return accountList.get(loc);}
	  else{return null;} 
          }

   public void saveAccounts()
   {
      ObjectOutputStream outputStream = null;
      try {
         outputStream = new ObjectOutputStream(new FileOutputStream("./AccountsList.txt"));
         for(int i=0; i < accountList.size(); i++)
         {
            account temp = accountList.get(i);
            outputStream.writeObject(temp);
         } 
            outputStream.flush();
      }
      catch(FileNotFoundException ex) { 
         System.out.println("accountList not found"); 
      } 
      catch(IOException ex) {
         System.out.println("can't save"); 
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
               accountList.add((account) inputStream.readObject());
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
