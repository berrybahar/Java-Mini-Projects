import java.util.Calendar;

public class Main {
	public static void main(String[] args) 
	{
		Calendar calendar = Calendar.getInstance();
		int thisMonth = calendar.get(Calendar.MONTH) + 1;
		
		SalariedEmployee salariedEmployee = new SalariedEmployee("Recep Tayyip", "Erdogan", "111-11-1111", 800.00, 1954, 2, 26);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Ekrem", "Imamoglu", "222-22-2222", 16.75, 40, 1971, 6, 3);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Kemal", "Kilicdaroglu", "333-33-3333", 10000, .06, 1948, 12, 17);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Umit", "Ozdag", "444-44-4444", 5000, .04, 300, 1961, 4, 3);
		PieceWorker pieceWorker = new PieceWorker("Devlet", "Bahceli", "555-55-5555", 770, 10, 1948, 1, 1);
		
		// create four-element Employee array
		Employee[] employees = new Employee[5];
		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = pieceWorker;
		
		System.out.printf("Employees processed polymorphically:%n%n");
		
		// generically process each element in array employees
		for (Employee currentEmployee : employees)
		{
			System.out.println(currentEmployee); // invokes toString
			
			if(currentEmployee.getBirthDate().getMonth() == thisMonth)
				System.out.printf("actual earnings: $%,.2f%nearned $%,.2f because of birthday,\nHappy Birthday to %s %s!%n%n",
						currentEmployee.earnings(false), currentEmployee.earnings(true), currentEmployee.getFirstName(), currentEmployee.getLastName());
			else
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings(false));
		}
	}
}
