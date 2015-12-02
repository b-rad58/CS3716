import java.util.*;
public class Message
{
   public void all(Object o, Society s) {
      Account acc;
      for (int i=0; i<s.numMembers(); i++) {
              acc = s.getAt(i);
              one(o, acc);
       }
   }

   public void one(Object o, Account a) 
   {
      a.getMailbox().addMessage(o);
   }
}

