package miu.cs489.employeepenstion.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public String toJSON(){
        return String.format("{\"planReference\": %s, \"firstName\":%s, \"lastName\":%s, \"yearlySalary\":%.2f, \"employmentDate\":%s, \"enrolmentDate\": %s, \"montlhlyContribution\":%.2f}",
                pensionPlan.getPlanReferenceNumber(),firstName, lastName, yearlySalary,employmentDate,pensionPlan.getEnrollmentDate(),pensionPlan.getMonthlyContribution());
    }
}
