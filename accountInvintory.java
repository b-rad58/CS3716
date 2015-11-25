import java.util.ArrayList;
public class accountInvintory{
private ArrayList<account> accountList= new ArrayList<>();
         public String toString()
        {String b="the accounts are :"+ for (int i = 0; i<accountList.size(); i++)
         { "n\ " +account.get(i).toString();}
        return b;
        }
	public void addAccount(account b)
	{ accountList.add(b);}

        public account getAccount(String name)
	{ boolean found= false;
          int loc =0;
	for (int i =0; i<accountList.size()-1; i++)
		{account b =accountList.get(i);
                if (b.getUseName() != name)
			{}
		else
		    {found =true;
                      loc = i;          }
	    }
          
	if (found = true)
          {return accountList.get(loc);}
          else{return null;}
	}
	public account search(String a)
	{       
boolean found= false;
          int loc =0;
	for (int i =0; i<accountList.size()-1; i++)
		{account b =accountList.get(i);
                if (b.getUseName() != a)
			{}
		else
		    {found =true;
                      loc = i;          }
	    }
          
	if (found = true)
          {return accountList.get(loc);}
	  else{return null;} 
          }
        
}
