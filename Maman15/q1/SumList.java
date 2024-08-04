import java.util.ArrayList;

public class SumList 
{
	private int sum = 0;
	private ArrayList<Integer> sumList;
	
	public SumList(ArrayList<Integer> sumList)
	{
		this.sumList = sumList;
	}
	
	public synchronized void sum()
	{
		if(sumList.size() > 1)
		{
			sum += sumList.get(0) + sumList.get(1);
			sumList.remove(0);
			sumList.set(0, sum);
			sum = 0;
		}
	}
	
	public synchronized ArrayList<Integer> getSumList()
	{
		return sumList;
	}
}
