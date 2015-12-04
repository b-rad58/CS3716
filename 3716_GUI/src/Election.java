import java.util.*;

public class Election
{
   private Map votes = new HashMap();
   private ArrayList<Account> nominees = new ArrayList();
 
   public Election() {}
   
   public Election (Account u){
	   
   }

   public void addNominee(Account a) {
      if (votes.containsKey(a))
         System.out.println(a.getUsername() + "is already entered in this election");
      votes.put(a,0);
      nominees.add(a);
   }

   public void vote(Account a) {
      votes.put(a, ((int)votes.get(a))+1);
   }

   public Account getResults() {
      if (nominees.size() == 0) {
         System.out.println("No nominees have been entered");
         return null;
      }
      Account winner = nominees.get(0);
      int numVotes = 0;
      for (int i=0; i < nominees.size(); i++) {
         if ((int) votes.get(nominees.get(i)) > numVotes) {
            winner = nominees.get(i);
            numVotes = (int) votes.get(winner);
         }
      }
      return winner;
   }
}
