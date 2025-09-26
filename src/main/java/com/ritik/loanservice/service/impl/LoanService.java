package com.ritik.loanservice.service.impl;

import com.ritik.loanservice.constants.LoanConstants;
import com.ritik.loanservice.dto.LoanDTO;
import com.ritik.loanservice.entity.Loan;
import com.ritik.loanservice.exception.LoanAlreadyExistsException;
import com.ritik.loanservice.exception.ResourceNotFoundException;
import com.ritik.loanservice.mapper.LoanMapper;
import com.ritik.loanservice.repository.LoanRepository;
import com.ritik.loanservice.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {

    private final LoanRepository loanRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> byMobileNumber = loanRepository.findByMobileNumber(mobileNumber);
        if (byMobileNumber.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber: " + mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan loan = new Loan();

        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loan.setLoanNumber(String.valueOf(randomLoanNumber));
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType(LoanConstants.HOME_LOAN);
        loan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        loan.setAmountPaid(0.00);
        loan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return loan;
    }

    @Override
    public LoanDTO fetchLoan(String mobileNumber) {
        Loan loan = loanRepository.findByLoanNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));

        return LoanMapper.mapToLoanDTO(loan, new LoanDTO());
    }

    @Override
    public boolean updateLoan(LoanDTO loanDTO) {
        Loan loan = loanRepository.findByLoanNumber(loanDTO.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", loanDTO.getLoanNumber()));

        LoanMapper.mapToLoan(loanDTO, loan);
        loanRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));

        loanRepository.deleteById(loan.getLoanId());
        return true;
    }
}
