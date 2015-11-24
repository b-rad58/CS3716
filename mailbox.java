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




}
