import java.util.*;
public class Message
{
   public void all(Object o, Society s) {
      Student stu;
      for (int i=0; i<s.numMembers(); i++) {
              stu = s.getAt(i);
              one(o, stu);
       }
   }

   public void one(Object o, Student stu) {
      stu.getMailbox().addMessage(o);
   }
}

