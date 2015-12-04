import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.Serializable;

abstract class Inventory
{
private ArrayList<Object> List= new ArrayList<>();

    public void save(String fileName)  {
      ObjectOutputStream outputStream = null;
      try 
      {
         outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
         for(int i=0; i < List.size(); i++)
             {
                Object temp = List.get(i);
                outputStream.writeObject(temp);
             } 
                outputStream.flush();
      }




      catch(FileNotFoundException ex) { 
         System.out.println("File not found"); 
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

    public void load(String fileName)  {
     ObjectInputStream inputStream = null;
      try {
         inputStream = new ObjectInputStream(new FileInputStream(fileName));
         while(true) {
            try {
               this.List.add((Account) inputStream.readObject());
            } 
            catch (EOFException ex) {
               inputStream.close();
               break;
            }
         }
      }
      catch(FileNotFoundException ex) { 
         System.out.println("File not found"); 
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
