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

<<<<<<< HEAD

//Removed to allow for compile. will be implemented with a notification system later in development.
=======
>>>>>>> e0c36026202835da7109d742124dee8cc9f9c3bc
