import java.util.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class societyInvintory
{   
        private ArrayList<society> societyList= new ArrayList<>();
	public void addSociety(society b)
	{ societyList.add(b);}

        public society getSociety(String name)
	{ 
	for (int i =0; i<societyList.size()-1; i++)
	{
                society b= societyList.get(i);
                if (b.getName() ==name)
		    {return b;}
		else
		    {System.out.println("society not found");
                     return null;}
	    }
        return null;
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
           catch(FileNotFoundException ex)
           {  System.out.println("societyList not found"); } 
           catch(IOException ex) {
              System.out.println("can't save"); }
           finally {
              if (outputStream != null) {
                 try {
                    outputStream.close();
                 } catch (IOException ex) {
                    System.out.println("oops");
                 }
         
        }}}
}

