package miu.cs489.employeepenstion.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PensionPlan {

    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }
}
