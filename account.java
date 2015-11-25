import java.util.*;
public class account {
private student stu;
private String useName;
private String pass;
    public student getStu()
    {return stu;}
	
    public void setStu(student b)
    {stu=b;}
	
    public String getUseName()
    {return useName;}
	
    public void setUseName(String b)
    {useName=b;}
	
    public String getPass()
    {return pass;}
	
    public void setPass(String b)
    {pass=b;}
    
    public boolean accEqual(account b){
   if (this.getUseName()==b.getUseName())
      {return true;}
   else{return false;}
   }
}

