public class test
{
   public static void main(String[] args) 
   {
     System.out.println("Test started...");
     societyInvintory testInventory = new societyInvintory();
     System.out.println("Society Inventory created");
     society test1 = new society("test1", "this is the first society created");
     society test2 = new society("test2", "this is the second society created");
     society test3 = new society("test3", "this is the third society created");
     testInventory.addSociety(test1);
     testInventory.addSociety(test2); 
     testInventory.addSociety(test3); 
     System.out.println("test1, test2, test3 added to inventory");
     testInventory.saveSocieties();
     System.out.println("societies saved");
     societyInvintory loadedInventory = new societyInvintory();
     System.out.println("loaded Inventory created");
     loadedInventory.loadSocieties();
     System.out.println("socities loaded");
     System.out.println(loadedInventory.getSociety("test2").getDiscription());
     
   }
}

