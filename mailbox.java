import java.util.*;
public class mailbox
{   
        private student name;
        private ArrayList<Object> mailbox= new ArrayList<>();
        
       public mailbox (student bob)
       {
        name = bob;
       } 

       public void setStudent(student terry)
       {name = terry;}
       public student getStudent()
       {return name;}

       public void addMessage(Object sent)
       {mailbox.add(sent);} 
       
       
       public boolean equals(Object other)
         {
          if (other == null)
          {
            return false;
               }

             if (this.getClass() != other.getClass())
             {
              return false;
              }

          if (this.x != ((Simple)other).x)
          {
         return false;
         }

          if (!this.str.equals(((Simple)other).str))
         {
         return false;
         }
        
         return true;
         }




}
