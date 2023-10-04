package miu.cs489.employeepenstion.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PensionPlan {

    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;
}
