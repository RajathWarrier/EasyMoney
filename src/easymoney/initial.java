package easymoney;

import java.util.Scanner;
public class initial {
	static Group[] GroupCollection = new Group[10];
	static int z = -1;
	public static void main(String[] args) {

		System.out.println("Welcome to EasyMoney");
		Scanner s = new Scanner(System.in);
		System.out.println("Select an option:");
		int a = 0;
		
		while (a!=6)
		{
			System.out.println("1. New Group");
			System.out.println("2. Add New Transaction");
			System.out.println("3. Settle");
			System.out.println("4. Show Split");
			System.out.println("5. Show Index");
			System.out.println("6. Exit");
			a = s.nextInt();
			switch(a)
			{
			case 1:
				newgroup();
				break;
			case 2:
				newtrans();
				break;
			case 3:
				settle();
				break;
			case 4:
				split();
				break;
			case 5:
				//index();
				break;
			}
		}
		System.out.println("Thankyou for using EasyMoney");
	}
	
	static void newgroup()
	{
		Scanner gs = new Scanner(System.in);
		System.out.println("Give the Group a Name");
		String nm = gs.nextLine();
		GroupCollection[++z] = new Group (nm,z);
		System.out.println("Number of people in the group:");
		int n = gs.nextInt();
		for (int i=0;i<n;i++)
		{
			System.out.println("Name of Person"+(i+1)+":");
			String pname = gs.next();
			GroupCollection[z].Persons.add(new Person(pname));
		}
	}
	
	static void newtrans()
	{
		Scanner t = new Scanner(System.in);
		Scanner ts = new Scanner(System.in);
		System.out.println("Select Group:");
		if (z==-1)
		{
			System.out.println("No Groups to Show");
			return;
		}
		else
		{
			for (int i=0;i<=z;i++)
			{
				System.out.println((i+1) + ". " + GroupCollection[i].Gname + " Press " + GroupCollection[i].g);
			}
		}
		int k = t.nextInt();
		System.out.println("Who Paid?");
		String p = ts.nextLine();
		
		Person payer = GroupCollection[k].Persons.get(0);
		for (Person a : GroupCollection[k].Persons)
		{
			if (a.name==p)
			{
				payer = a;
				break;
			}
		}
		System.out.println("How Much Did " + p + " Pay?");
		float amount = t.nextFloat();
		System.out.println("How many participated in this activity (including you)?");
		float n = t.nextInt();
		System.out.println("Who all were part of this activity?");
		for (Person a : GroupCollection[k].Persons)
		{
			if (a!=payer)
			{
				System.out.println(a.name);
				System.out.println("Yes->1"+"	No->0");
				int i = t.nextInt();
				if (i==1)
					a.record.put(payer.name,amount/n);
			}
		}
	}
	static void settle()
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Which Group?");
		
		for (int i=0;i<=z;i++)
		{
			System.out.println(i + ". " + GroupCollection[i].Gname);
		}
		int a = ss.nextInt();
		System.out.println("Settle whose debt? (Enter Name)");
		for (Person pr : GroupCollection[a].Persons)
		{
			System.out.println(pr.name);
		}
		Person p1;
		String pro = ss.nextLine();
		for (Person pr : GroupCollection[a].Persons)
			if (pr.name==pro)
			{
				p1 = pr;
				System.out.println("Settle With? (Enter Name)");
				for (String name : p1.record.keySet())
				{
					System.out.println(name);
				}
				String name = ss.nextLine();
				p1.record.remove(name);
				break;
			}
		
	}
	static void split()
	{
		Scanner sp = new Scanner(System.in);
		System.out.println("Which Group?");
		for (int i=0;i<=z;i++)
		{
			System.out.println(i + ". " + GroupCollection[i].Gname);
		}
		int gn = sp.nextInt();
		for (Person b : GroupCollection[gn].Persons)
		{
			System.out.println(b+"Owes");
			for (String name : b.record.keySet())
			{
				System.out.print(name + "->");
				System.out.println(b.record.get(name));
			}
		}
		
	}
}
