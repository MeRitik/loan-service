package com.ritik.loanservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "DTO for loan information transfer")
@Data
public class LoanDTO {
    @Schema(description = "Unique identifier for the loan", example = "1234567890")
    private String loanNumber;

    @Schema(description = "Customer's mobile number", example = "9876543210")
    private String mobileNumber;

    @Schema(description = "Type of loan", example = "Personal")
    private String loanType;

    @Schema(description = "Total loan amount sanctioned", example = "100000.00")
    private Double totalLoan;

    @Schema(description = "Amount already paid by customer", example = "25000.00")
    private Double amountPaid;

    @Schema(description = "Remaining amount to be paid", example = "75000.00")
    private Double outstandingAmount;
}
