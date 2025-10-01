package com.ritik.loanservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(description = "DTO for loan information transfer")
@Data
public class LoanDTO {
    @Schema(description = "Unique identifier for the loan", example = "1234567890")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @Schema(description = "Customer's mobile number", example = "9876543210")
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Type of loan", example = "Personal")
    @NotEmpty(message = "LoanType can not be a null or empty")
    private String loanType;

    @Schema(description = "Total loan amount sanctioned", example = "100000.00")
    @Positive(message = "Total loan amount should be greater than zero")
    private Double totalLoan;

    @Schema(description = "Amount already paid by customer", example = "25000.00")
    @PositiveOrZero(message = "Amount paid should be greater than or equal to zero")
    private Double amountPaid;

    @Schema(description = "Remaining amount to be paid", example = "75000.00")
    @PositiveOrZero(message = "Outstanding amount should be greater than or equal to zero")
    private Double outstandingAmount;
}
