class EmployeWageComputationInJava
{
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	private final String company;
	private final int empRatePerHour;
	private int numOfWorkingDays;
	private int maxHoursPerMonth;
	private int totalEmpWage;
	public EmployeWageComputationInJava(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth)
	{
		this.company = company;
		this.empRatePerHour = empRatePerHour;
     		this.numOfWorkingDays = numOfWorkingDays;
     		this.maxHoursPerMonth = maxHoursPerMonth;
   	}

   	public void computeEmployeeWage()
   	{
      		int empHrs=0;
      		int totalEmpHrs = 0;
      		int totalWorkingDays = 0;
      		while(totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numOfWorkingDays)
      		{
			totalWorkingDays++;
        		int empCheck = (int) Math.floor(Math.random()*10) % 3;
        		switch (empCheck)
        		{
	 			case IS_PART_TIME :
	  				empHrs = 4;
	  				break;
	  			case IS_FULL_TIME :
	  				empHrs = 8;
	  				break;
	  			default :
	  				empHrs = 0;
	  				break;
         		}
         		totalEmpHrs+=empHrs;
         		System.out.println("Day: " + totalWorkingDays + " Emp Hr: " + empHrs);
       		}
       		totalEmpWage=totalEmpHrs*empRatePerHour;
	}
	public String toString()
    	{
      		return "Total employee wage for company:" + company + "is: " + totalEmpWage;
    	}
    	public static void main(String arg[])
    	{
		EmployeWageComputationInJava dMart = new EmployeWageComputationInJava("DMart", 20, 20, 100);
      		EmployeWageComputationInJava reliance = new EmployeWageComputationInJava("Reliance", 50, 28, 100);
      		dMart.computeEmployeeWage();
		System.out.println(dMart);
      		reliance.computeEmployeeWage();
      		System.out.println(reliance);
    	}
}

