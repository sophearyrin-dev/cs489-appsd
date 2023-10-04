package miu.cs489.employeepenstion;

import miu.cs489.employeepenstion.model.Employee;
import miu.cs489.employeepenstion.model.PensionPlan;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeePensionsApp {

    public static void printEmployee(List<Employee> employees){
        System.out.println("TaskA: Print all employees\n----");
        int n = employees.size();
        int i=0;
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary).reversed());

        for (Employee e: employees){
            if(e.getPensionPlan() == null){
                e.setPensionPlan(new PensionPlan("",LocalDate.now(),0));
            }
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
        int n = employees.size();
        int i=0;
        LocalDate referenceDate = LocalDate.now().withDayOfMonth(1).plusMonths(1).minusDays(1);
        for(Employee e: employees){
            Period duration = Period.between(e.getEmploymentDate(),LocalDate.of(2023,11,30));
            int year = duration.getYears();
//            System.out.println(year);
            if(year >=5 && e.getPensionPlan().getPlanReferenceNumber()==""){

                if(e.getPensionPlan() == null){
                    e.setPensionPlan(new PensionPlan("",LocalDate.now(),0));
                }
                if(i==n-1){
                    System.out.println(e.toJSON());
                }else{
                    System.out.printf(e.toJSON()+ "%s\n",",");
                }
            }

        }
    }

    public static boolean isEligibleForUpcomingEnrollment(LocalDate referenceDate, Employee e) {
        LocalDate enrollmentCutoffDate = e.getEmploymentDate().plusYears(5).plusMonths(1); //add 5 ys and 1 month

        return e.getEmploymentDate().isBefore(referenceDate) &&
                enrollmentCutoffDate.isAfter(referenceDate) &&
                e.getPensionPlan().getEnrollmentDate() == null;
    }
    public static void main(String[] args) {

        PensionPlan pensionPlan1 = new PensionPlan("EX1089", LocalDate.of(2023,01,17),100);
        PensionPlan pensionPlan2 = new PensionPlan("SM2307", LocalDate.of(2019,11,04),1555.5);

        Employee employee1 = new Employee(001L,"Daniel","Agar", LocalDate.of(2018,01,17 ),105945.50);
        Employee employee2 = new Employee(002L,"Benard ","Shaw", LocalDate.of(2018,10,03 ),197750.00);
        Employee employee3 = new Employee(003L,"Carly","Agar", LocalDate.of(2014,05,16 ),842000.75);
        Employee employee4 = new Employee(004L,"Wesley","Schneider", LocalDate.of(2018,11,02 ),74500.00);

        employee1.setPensionPlan(pensionPlan1);
        employee3.setPensionPlan(pensionPlan2);

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
