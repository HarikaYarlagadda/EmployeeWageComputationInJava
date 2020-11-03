interface EmpWageComputationInterface
{
    public void assign_Company_Details(String name_of_Company, int wage_per_Hour, int maximum_Working_Days, int maximum_Working_Hours);

    public void calculateTotalWage();
}
class CompanyEmpWage
{
   
    final String COMPANY_NAME;
    final int WAGE_PER_HOUR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HOURS;
    int total_earned_Wage;

    CompanyEmpWage(String name_of_Company, int wage_per_Hour, int maximum_Working_Days, int maximum_Working_Hours)
    {
        COMPANY_NAME = name_of_Company;
        WAGE_PER_HOUR = wage_per_Hour;
        MAX_WORKING_DAYS = maximum_Working_Days;
        MAX_WORKING_HOURS = maximum_Working_Hours;
        total_earned_Wage = 0;
    }

    void setTotalEmployeeWage(int total_earned_Wage)
    {
    	this.total_earned_Wage = total_earned_Wage;
    }

    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("               ");
        System.out.println("Wage per hour of "+COMPANY_NAME+ " Employee is " + WAGE_PER_HOUR);
        System.out.println("Maximum working days of "+COMPANY_NAME+ " Employee is "  + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours of "+COMPANY_NAME+ " Employee is "  + MAX_WORKING_HOURS);
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + total_earned_Wage + "\n";
    }
}

class EmployeWageComputationInJava implements EmpWageComputationInterface
{
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    int noOfCompanies, i;
    CompanyEmpWage[] companies_Array; 

    public EmployeWageComputationInJava(int noOfCompanies)
    {
        this.noOfCompanies = noOfCompanies;
        companies_Array = new CompanyEmpWage[noOfCompanies]; 
        i = 0;
    }

    public void assign_Company_Details(String name_of_Company, int wage_per_Hour, int maximum_Working_Days, int maximum_Working_Hours)
    {
        companies_Array[i++] = new CompanyEmpWage(name_of_Company, wage_per_Hour, maximum_Working_Days, maximum_Working_Hours);
    }

    int generateEmployeeType()
    {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int type_of_Employee)
    {
        switch (type_of_Employee)
        {
        case FULL_TIME:
            return 8;
        case PART_TIME:
            return 4;
        default:
            return 0;
        }
    }

    public void calculateTotalWage()
    {
        for (CompanyEmpWage individual_company : companies_Array)
        {
            int total_earned_Wage = calculateTotalWage(individual_company);
            individual_company.setTotalEmployeeWage(total_earned_Wage);
            System.out.println(individual_company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage)
    {
        System.out.println("    ");
        System.out.printf("TOTAL WAGE OF AN " +companyEmpWage.COMPANY_NAME + " EMPLOYEE IS GIVEN BELOW : \n");
        System.out.println("     ");
        int workingHrs, total_earned_Wage = 0;
        for (int day = 1, total_hours_Worked = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && total_hours_Worked <= companyEmpWage.MAX_WORKING_HOURS; day++, total_hours_Worked += workingHrs)
        {
            int type_of_Employee = generateEmployeeType();
            workingHrs = getWorkingHrs(type_of_Employee);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HOUR;
            total_earned_Wage += wage;
            System.out.printf("For Day %d %s Employee's Dailywage is %d for %d Hours worked and He worked %d Hours in a month upto now\n", day, companyEmpWage.COMPANY_NAME, wage, workingHrs, total_hours_Worked + workingHrs);
            System.out.println("     ");

        }
        
        return total_earned_Wage;
    }

    public static void main(String args[])
    {
        EmployeWageComputationInJava employeeWageComputation = new EmployeWageComputationInJava(3); 
        employeeWageComputation.assign_Company_Details("DMart", 6, 20, 100);
        employeeWageComputation.assign_Company_Details("Reliance", 5, 28, 90);
        employeeWageComputation.assign_Company_Details("spencers", 5, 25, 90);
        employeeWageComputation.calculateTotalWage();
    }
}
