package easymoney;
import java.util.Map;
import java.util.HashMap;

public class Person {
	
	public Map <String,Float> record = new HashMap <String,Float> ();
	public String name;
	//public int amount;
	Person (String name)
	{
		this.name = name;
	}
	public void trans(String name, float amnt)
	{
		record.put(name,amnt);
	}
}
