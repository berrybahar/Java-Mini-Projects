
public class SumThread extends Thread
{
	private SumList sumList;
	
	public SumThread(SumList sumList)
	{
		this.sumList = sumList;
	}
	
	@Override
	public void run()
	{
		super.run();
		while(sumList.getSumList().size() > 1)
		{
			sumList.sum();
		}
	}
	
}
