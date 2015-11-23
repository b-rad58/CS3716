import java.util.*;
public class message{
	public void all(Object o,society s)
	{for (int i=0; i <s.memberSize(); i++)
              {student b = s.getAt(i);
               one(o,b);
              }
        }
	public void one(Object o,student s)
	{s.getMailbox().addMessage(o);}
}

