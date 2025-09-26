package com.ritik.loanservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loans")
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String loanNumber;
    private String mobileNumber;
    private String loanType;
    private Double totalLoan;
    private Double amountPaid;
    private Double outstandingAmount;
}
