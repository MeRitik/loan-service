package com.ritik.loanservice.service;

import com.ritik.loanservice.dto.LoanDTO;

public interface ILoanService {
    /**
     * Creates a new loan for the customer with the specified mobile number.
     *
     * @param mobileNumber The mobile number of the customer
     */
    void createLoan(String mobileNumber);

    /**
     * Retrieves loan details for the customer with the specified mobile number.
     *
     * @param mobileNumber The mobile number of the customer
     * @return The loan details as a LoanDTO object
     */
    LoanDTO fetchLoan(String mobileNumber);

    /**
     * Updates an existing loan with the provided loan details.
     *
     * @param loanDTO The loan data transfer object containing updated loan information
     * @return true if the update was successful, false otherwise
     */
    boolean updateLoan(LoanDTO loanDTO);

    /**
     * Deletes the loan associated with the specified mobile number.
     *
     * @param mobileNumber The mobile number of the customer
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteLoan(String mobileNumber);
}
