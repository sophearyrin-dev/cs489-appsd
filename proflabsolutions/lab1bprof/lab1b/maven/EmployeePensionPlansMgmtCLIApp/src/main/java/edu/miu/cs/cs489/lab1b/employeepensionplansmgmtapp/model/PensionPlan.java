package edu.miu.cs.cs489.lab1b.employeepensionplansmgmtapp.model;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Double monthlyContribution;

    PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    PensionPlan() {
        this(null, null, null);
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(Double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PensionPlan{");
        sb.append("planReferenceNumber='").append(planReferenceNumber).append('\'');
        sb.append(", enrollmentDate=").append(enrollmentDate);
        sb.append(", monthlyContribution=").append(monthlyContribution);
        sb.append('}');
        return sb.toString();
    }
}
