package edu.miu.cs.cs489.lab1b.employeepensionplansmgmtapp.model;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearlySalary;

    private PensionPlan pensionPlan;

    public Employee(Long employeeId, String firstName, String lastName,
                    LocalDate employmentDate, Double yearlySalary,
                    String planReferenceNumber, LocalDate enrollmentDate,
                    Double monthlyContribution) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = (planReferenceNumber == null) ? null : new PensionPlan(planReferenceNumber, enrollmentDate, monthlyContribution);
    }

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    public boolean isUpcomingEnrollee() {
        var nextMonthDate = LocalDate.now().plusMonths(1L);
        var nextMonthsYear = nextMonthDate.getYear();
        var nextMonthsMonth = nextMonthDate.getMonth();
        var enrollQualificationDate = employmentDate.plusYears(5L);
        return ((enrollQualificationDate.getYear() == nextMonthsYear)
                && (enrollQualificationDate.getMonth().equals(nextMonthsMonth))
                && (pensionPlan == null)
        );
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", employmentDate=").append(employmentDate);
        sb.append(", yearlySalary=").append(yearlySalary);
        sb.append(", pensionPlan=").append(pensionPlan);
        sb.append('}');
        return sb.toString();
    }
}
