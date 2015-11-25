import java.util.*;
<<<<<<< HEAD
public class societyInvintory
{   
        private ArrayList<society> societyList= new ArrayList<>();
	public void addSociety(society b)
	{ societyList.add(b);}

        public society getSociety(String name)

	{ 
	for (int i =0; i<societyList.size()-1; i++)
		{society b= societyList.get(i);
                if (b.getName() ==name)
		    {return b;}
		else
		    {System.out.println("society not found");
                     return null;}
	    }
return null;
	}
=======
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class societyInvintory 
{   
   private ArrayList<society> societyList= new ArrayList<>();
   
   
   public void addSociety(society b) { 
      societyList.add(b);
   }

   public society getSociety(String name)
   { 
      for (int i =0; i<societyList.size(); i++)
      {
         society b= societyList.get(i);
         if (b.getName().equals(name))
	    return b;
      }
      return null;
   }
   public String toString()
   {String b="all society's information is: ";
    for (int i=0; i<societyList.size(); i++)
         {b=b+"n\ " +societyList.get(i).toString();}
    return b;

   }

   public void saveSocieties()
   {
      ObjectOutputStream outputStream = null;
      try {
         outputStream = new ObjectOutputStream(new FileOutputStream("./societyList.txt"));
         for(int i=0; i < societyList.size(); i++)
         {
            society temp = societyList.get(i);
            outputStream.writeObject(temp);
         } 
            outputStream.flush();
      }
      catch(FileNotFoundException ex) { 
         System.out.println("societyList not found"); 
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

  public void loadSocieties()
  {
     ObjectInputStream inputStream = null;
      try {
         inputStream = new ObjectInputStream(new FileInputStream("./societyList.txt"));
         int i=0;
         while(true) {
            try {
               societyList.add((society) inputStream.readObject());
            } 
            catch (EOFException ex) {
               inputStream.close();
               break;
            }
         }
      }
      catch(FileNotFoundException ex) { 
         System.out.println("societyList not found"); 
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
>>>>>>> e0c36026202835da7109d742124dee8cc9f9c3bc
}

