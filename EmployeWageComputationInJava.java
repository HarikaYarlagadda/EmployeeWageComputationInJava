public class EmployeWageComputationInJava 
{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static int computeEmployeWage(String Company ,int EMP_RATE_PER_HOUR,int NUM_OF_WORKING_DAYS,
   int MAX_HRS_IN_MONTH)
	{
		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		System.out.println("CompanyName:"+Company);
		while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS )
		{
			totalWorkingDays++;
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			switch(empCheck)
			{
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#: " + totalWorkingDays + " empHrs: " +empHrs);
		}
		int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
		System.out.println("Total Emp Wage: " + totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args)
	{
		computeEmployeWage("Reliance",50,28,100);
		computeEmployeWage("Dmart",20,20,100);
	}
}
