package easymoney;

import java.util.HashSet;

class GroupCollection extends Group{
	HashSet <Group> Groups = new HashSet <Group>();
	
	void add(Group x)
	{
		Groups.add(x);
	}
	
	void remove (Group x)
	{
		Groups.remove(x);
	}
	
	/*display()
	{
		
	}*/
}
