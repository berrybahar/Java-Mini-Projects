
public class LinkedList <E>
{
	private Node<E> head;
	private Node<E> tail;
	
	public LinkedList()
	{
		head = null;
		tail = null;
	}
	
	public Node<E> getHead()
	{
		return head;
	}
	
	public Node<E> getTail()
	{
		return tail;
	}
	
	public void add(E data)
	{		
		if(head == null)
		{
			head = new Node<E>(data);
			head.setNextNode(tail);
		}
		else if(tail == null)
		{
			tail = new Node<E>(data);
			head.setNextNode(tail);
		}
		else
		{
			Node<E> newNode = new Node<E>(data);
			Node<E> temp = tail;
			Node<E> node = head;
			while(node.getNextNode() != tail)
				node = node.getNextNode();
			tail = newNode;
			node.setNextNode(temp);
			temp.setNextNode(tail);
		}
	}
	
	public E remove() throws EmptyListException
	{
		if(head == null && tail == null)
			throw new EmptyListException("The list is empty!");
		
		E remove = head.getNodeData();
		
		head = head.getNextNode();
		
		return remove;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		if(head == null)
			return str;
		Node<E> node = head;
		while(node != null)
		{
			if(node.getNextNode() != null)
				str += node.getNodeData() + ", ";
			else
				str += node.getNodeData();
			
			node = node.getNextNode();
		}
		return str;
	}
	
	public LinkedList<E> invertList() throws EmptyListException
	{
		LinkedList<E> invertedList = new LinkedList<E>();
		Node<E> temp = head;
		
		while(temp != null)
		{
			invertedList.addToStart((E)temp.getNodeData());
			temp = temp.getNextNode();
		}
		
		return invertedList;
	}
	
	private void addToStart(E data)
	{
		if(head == null)
		{
			head = new Node<E>(data);
			head.setNextNode(tail);
		}
		else if(tail == null)
		{
			Node<E> newNode = new Node<E>(data);
			tail = head;
			head = newNode;
			head.setNextNode(tail);
		}
		else
		{
			Node<E> newNode = new Node<E>(data);
			newNode.setNextNode(head);
			head = newNode;
		}
	}
	
}
