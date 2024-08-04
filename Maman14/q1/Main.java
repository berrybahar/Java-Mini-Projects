import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws EmptyListException 
	{	
		LinkedList<String> list = new LinkedList<String>();
		
		Scanner scan = new Scanner(System.in);
		String str = "";
		System.out.println("Please enter 6 strings:");
		for(int i = 1; i <= 6; i++)
		{
			str = scan.next();
			list.add(str);
		}
		System.out.println("Your list is:");
		
		String printList = list.toString();
		
		System.out.println(printList);	
		
		LinkedList<String> invertedList = list.invertList();
		
		printList = invertedList.toString();
		
		System.out.println("The Inverted list is: \n" + printList);
		
		LinkedList<Person> personList = new LinkedList<Person>();
		
		personList.add(new Person("Recep Tayyip Erdogan", "111-11-1111", 1954));
		personList.add(new Person("Ekrem Imamoglu", "222-22-2222", 1971));
		personList.add(new Person("Kemal Kilicdaroglu", "333-33-3333", 1948));
		personList.add(new Person("Devlet Bahceli", "555-55-5555", 1948));
		
		System.out.println("\nThe person list is: \n" + toString(personList));
		System.out.println("\nThe oldest person is: " + max(personList).getName());
		
	}
	
	public static String toString(LinkedList<Person> pList)
	{
		String str = "";
		Node<Person> temp = pList.getHead();
		
		while(temp != null)
		{
			str += "Name:" + temp.getNodeData().getName() + ", ID:" + temp.getNodeData().getIdNumber() + ", Birth-Year:" + temp.getNodeData().getBirthYear();
			if(temp.getNextNode() != null)
				str += "\n";
			
			temp = temp.getNextNode();
		}
		
		return str;
	}
	
	public static <E extends Comparable> E max(LinkedList<E> list)
	{
		Node<E> temp = list.getHead();
		E max = temp.getNodeData();
		
		while(temp != null)
		{
			if(temp.getNodeData().compareTo(max) < 0)
				max = temp.getNodeData();
			temp = (Node<E>) temp.getNextNode();
		}
		
		return max;
	}
}
