import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> numList = new ArrayList<Integer>();
		ArrayList<SumThread> threadList = new ArrayList<SumThread>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the size of the list to sum: ");
		int listLength = scan.nextInt();
		
		System.out.println("Please enter the number of proccesses that you want for summing the elements of the list: ");
		int numOfProcesses = scan.nextInt();
		
		Random num = new Random();
		
		for(int i = 1; i <= listLength; i++)
			numList.add(num.nextInt(1, 101)); 
		
		SumList sumList = new SumList(numList);
		
		//////////////////////////////////////////
		System.out.println("The list:");
		for(int i = 0; i < numList.size(); i++)
			System.out.println(numList.get(i));
		/////////////////////////////////////////
		
		for(int j = 0; j < numOfProcesses; j++)
			threadList.add(new SumThread(sumList));
		
		for(int m = 0; m < threadList.size(); m++)
			threadList.get(m).start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The sum is:");
		System.out.println(numList.get(0));
	}
}