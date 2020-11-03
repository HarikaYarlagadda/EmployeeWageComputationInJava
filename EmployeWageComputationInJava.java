import java.util.ArrayList;
import java.util.HashMap;
interface EmployeeWageComputationInterface
{
    public void assign_Company_Details(String name_of_Company, int wage_per_Hour, int maximum_Working_Days, int maximum_Working_Hours);

    public void total_Wage_Computation();
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
        System.out.println("    ");
        System.out.println("Wage per hour of "+COMPANY_NAME+ " Employee is " + WAGE_PER_HOUR);
        System.out.println("Maximum working days of "+COMPANY_NAME+ " Employee is "  + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours of "+COMPANY_NAME+ " Employee is "  + MAX_WORKING_HOURS);
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + total_earned_Wage + "\n";
    }
}

class EmployeWageComputationInJava implements EmployeeWageComputationInterface
{
    
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    int noOfCompanies, index;
    ArrayList<CompanyEmpWage>companies_ArrayList;  
    HashMap<String, Integer> totalWages_of_companies; 
    public EmployeWageComputationInJava()
    {
    	companies_ArrayList = new ArrayList<>();
    	totalWages_of_companies = new HashMap<>();
    }

    public void assign_Company_Details(String name_of_Company, int wage_per_Hour, int maximum_Working_Days, int maximum_Working_Hours)
    {
    	CompanyEmpWage company = new CompanyEmpWage(name_of_Company, wage_per_Hour, maximum_Working_Days, maximum_Working_Hours);
    	companies_ArrayList.add(company); 
    	totalWages_of_companies.put(name_of_Company,0);
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

    public void total_Wage_Computation()
    {
        for (CompanyEmpWage individual_company : companies_ArrayList)
        {
            int total_earned_Wage = total_Wage_Computation(individual_company);
            individual_company.setTotalEmployeeWage(total_earned_Wage);
            System.out.println(individual_company);
        }
    }

    int total_Wage_Computation(CompanyEmpWage companyEmpWage)
    {
        System.out.println("    ");
        System.out.printf("TOTAL WAGE OF AN " +companyEmpWage.COMPANY_NAME + " EMPLOYEE IS GIVEN BELOW : \n");
        System.out.println("    ");
        int workingHrs, total_earned_Wage = 0;
        for (int day = 1, total_hours_Worked = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && total_hours_Worked <= companyEmpWage.MAX_WORKING_HOURS; day++, total_hours_Worked += workingHrs)
        {
            int type_of_Employee = generateEmployeeType();
            workingHrs = getWorkingHrs(type_of_Employee);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HOUR;
            total_earned_Wage += wage;
            System.out.printf("For Day %d %s Employee Dailywage is %d for %d Hours worked and He worked %d Hours in a month until now\n", day, companyEmpWage.COMPANY_NAME, wage, workingHrs, total_hours_Worked + workingHrs);
            System.out.println("    ");

        }
        totalWages_of_companies.put(companyEmpWage.COMPANY_NAME, total_earned_Wage);
        return total_earned_Wage;
    }
    void printTotalEmpWages()
    {
        System.out.println("     ");
        System.out.println("Total Wages of Employees in different companies are:");
        for (String companyName : totalWages_of_companies.keySet())
        {
            System.out.println(companyName + ": " + totalWages_of_companies.get(companyName));
        }

    }
    public int answer_Query(String companyName) 
    {
        return totalWages_of_companies.get(companyName);
    }
    public static void main(String args[])
    {
        EmployeWageComputationInJava employeeWageComputation = new EmployeWageComputationInJava();   
        employeeWageComputation.assign_Company_Details("DMart", 6, 25, 150);
        employeeWageComputation.assign_Company_Details("Reliance", 9, 35, 120);
        employeeWageComputation.assign_Company_Details("Pantaloons", 5, 30, 100);
		  employeeWageComputation.assign_Company_Details("max", 6, 60, 120);
        employeeWageComputation.total_Wage_Computation();
        employeeWageComputation.printTotalEmpWages();
        String ask_Query = "DMart";
        int totalWage = employeeWageComputation.answer_Query(ask_Query);
        System.out.println("Queried company is  " + ask_Query +" and Total Wage for " + ask_Query + " company Employee is " + totalWage);
    }
}

