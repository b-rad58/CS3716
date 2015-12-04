import java.util.*;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.Serializable;

public class SocietyInventory implements Serializable
{   
   private ArrayList<Society> societyList= new ArrayList<>();
   
   public SocietyInventory(ArrayList<Society> societies) {
      this.societyList = societies;
   }
   
   public SocietyInventory() {}
  
   public void addSociety(Society s) { 
      societyList.add(s);
   }

   public Society getSociety(String name)
   { 
      for (int i =0; i<societyList.size(); i++)
      {
         Society s = societyList.get(i);
         if (s.getName().equals(name))
	    return s;
      }
      return null;
   }

   public String toString() {
      String result = "";
      for (int i=0; i<this.societyList.size(); i++) {
         result += this.societyList.get(i).toString();
      }
      return result;
   }

   public void saveSocieties()
   {
      ObjectOutputStream outputStream = null;
      try {
    	 File hold = new File("./societyList.txt");
    	 hold.delete();
         outputStream = new ObjectOutputStream(new FileOutputStream(hold,false));
         for(int i=0; i < societyList.size(); i++)
         {
            Society temp = societyList.get(i);
            outputStream.writeObject(temp);
         } 
            outputStream.flush();
      }
      catch(FileNotFoundException ex) { 
         System.out.println("societyList not found"); 
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

  public void loadSocieties()
  {
     ObjectInputStream inputStream = null;
      try {
         inputStream = new ObjectInputStream(new FileInputStream("./societyList.txt"));
         while(true) {
            try {
               this.societyList.add( (Society) inputStream.readObject());
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
         ex.printStackTrace(); 
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

  	public ArrayList<Society> getSocietyList(){
  		ArrayList<Society> b = this.societyList;
  		return b;
  	}
}

