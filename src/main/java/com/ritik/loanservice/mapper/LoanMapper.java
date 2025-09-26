package com.ritik.loanservice.mapper;

import com.ritik.loanservice.dto.LoanDTO;
import com.ritik.loanservice.entity.Loan;

public class LoanMapper {

    public static LoanDTO mapToLoanDTO(Loan loan, LoanDTO loanDTO) {
        loanDTO.setLoanNumber(loan.getLoanNumber());
        loanDTO.setMobileNumber(loan.getMobileNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setTotalLoan(loan.getTotalLoan());
        loanDTO.setAmountPaid(loan.getAmountPaid());
        loanDTO.setOutstandingAmount(loan.getOutstandingAmount());
        return loanDTO;
    }

    public static Loan mapToLoan(LoanDTO loanDTO, Loan loan) {
        loan.setMobileNumber(loanDTO.getMobileNumber());
        loan.setLoanNumber(loanDTO.getLoanNumber());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setTotalLoan(loanDTO.getTotalLoan());
        loan.setAmountPaid(loanDTO.getAmountPaid());
        loan.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loan;
    }
}
