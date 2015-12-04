import java.util.*;
import java.io.Serializable;

public class Mailbox implements Serializable
{
   private ArrayList<Object> mail = new ArrayList<>();
        
   public void addMessage(Object message) {
      mail.add(message);
   } 

}

