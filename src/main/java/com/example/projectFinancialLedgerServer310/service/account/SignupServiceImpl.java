package com.example.projectFinancialLedgerServer310.service.account;

import com.example.projectFinancialLedgerServer310.entity.account.Signup;
import com.example.projectFinancialLedgerServer310.repository.account.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SignupServiceImpl implements SignupService {

    private final SignupRepository signupRepository;

    @Autowired
    public SignupServiceImpl(SignupRepository signupRepository) {

        this.signupRepository = signupRepository;
    }


    @Override
    public List<Signup> getSignupInfo() {
        return signupRepository.findAll();
    }
}
