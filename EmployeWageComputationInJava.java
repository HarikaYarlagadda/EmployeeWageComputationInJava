public class EmployeWageComputationInJava 
	{
		public static void main (String[] args)
		{
			int IS_FULL_TIME = 1;
			int empRatePerHr;
			int empHrs;
			int salary;
			double empCheck = Math.floor(Math.random() * 10) % 2;
			if (empCheck == IS_FULL_TIME) 
				{
					empRatePerHr = 20;
					empHrs = 8;
					salary=empHrs*empRatePerHr;
					System.out.println(salary);
				}
				else
				{
					salary = 0;
					System.out.println(salary);
				}
		}
}
