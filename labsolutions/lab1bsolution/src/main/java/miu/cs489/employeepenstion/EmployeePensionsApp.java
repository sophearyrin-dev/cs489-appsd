package miu.cs489.employeepenstion;

import miu.cs489.employeepenstion.model.Employee;
import miu.cs489.employeepenstion.model.PensionPlan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePensionsApp {

    public static void printEmployee(List<Employee> employees){
        System.out.println("TaskA: Print all employees\n----");
        int n = employees.size();
        int i=0;
        employees = employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary).reversed()).collect(Collectors.toList());

        for (Employee e: employees){
            if(i==n-1){
                System.out.println(e.toJSON());
            }else{
                System.out.printf(e.toJSON()+ "%s\n",",");
            }
            i++;
        }
    }
    public static void printMonthlyUpcomingEnroll(List<Employee> employees){
        System.out.println("TaskB: Monthly Upcoming Enroll\n-----");
        employees = employees
                .stream()
                .sorted(Comparator.comparing(Employee::getEmploymentDate)
                        .reversed()).collect(Collectors.toList());
        int n = employees.size();
        int i=0;

        for(Employee e: employees){
            if(isEligibleForUpcomingEnrollment(e)){
                if(i==n-1){
                    System.out.println(e.toJSON());
                }else{
                    System.out.printf(e.toJSON()+ "%s\n",",");
                }
            }

        }

    }

    public static boolean isEligibleForUpcomingEnrollment(Employee e) {
        var nextMonthDate = LocalDate.now().plusMonths(1L); // add one month date
        System.out.println(nextMonthDate);
        var nextMonthsYear = nextMonthDate.getYear();//get year of next year
        var nextMonthsMonth = nextMonthDate.getMonth();//get month of next
        var enrollQualificationDate = e.getEmploymentDate().plusYears(5L);
        return ((enrollQualificationDate.getYear() == nextMonthsYear)
                && (enrollQualificationDate.getMonth().equals(nextMonthsMonth))
                && (e.getPensionPlan() == null)
        );
    }
    public static void main(String[] args) {

        Employee employee1 = new Employee(001L,"Daniel","Agar", LocalDate.of(2018,01,17 ),105945.50, "EX1089", LocalDate.of(2023,01,17),100);
        Employee employee2 = new Employee(002L,"Benard ","Shaw", LocalDate.of(2018,10,03 ),197750.00,null,null,0);
        Employee employee3 = new Employee(003L,"Carly","Agar", LocalDate.of(2014,05,16 ),842000.75,"SM2307", LocalDate.of(2019,11,04),1555.5);
        Employee employee4 = new Employee(004L,"Wesley","Schneider", LocalDate.of(2018,11,02 ),74500.00,null,null,0);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        //print all employees
        printEmployee(employees);
        printMonthlyUpcomingEnroll(employees);


    }
}
