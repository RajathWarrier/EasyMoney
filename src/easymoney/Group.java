package easymoney;

//import java.util.Set;
import java.util.ArrayList;
public class Group {
	int g; //Key of particular group
	String Gname;
	ArrayList <Person> Persons = new ArrayList <Person> ();
	
	Group (String name, int key)
	{
		this.Gname = name;
		this.g = key;
	}
}
