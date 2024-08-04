
public class Node <E>
{
	private E nodeData;
	private Node<E> nextNode;
	
	public Node(E nodeData)
	{
		this.nodeData = nodeData;
		this.nextNode = null;
	}
	
	public Node(E nodeData, E nextNodeData)
	{
		this.nodeData = nodeData;
		this.nextNode.nodeData = nextNodeData;
	}
	
	public E getNodeData()
	{
		return nodeData;
	}
	
	public void setNodeData(E nodeData)
	{
		this.nodeData = nodeData;
	}
	
	public void setNextNode(Node<E> nextNode)
	{
		this.nextNode = nextNode;
	}
	
	public Node<E> getNextNode()
	{
		return (Node<E>)nextNode;
	}
}
