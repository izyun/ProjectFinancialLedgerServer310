package com.example.projectFinancialLedgerServer310.service.account;

import com.example.projectFinancialLedgerServer310.entity.account.Account;
import com.example.projectFinancialLedgerServer310.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> findAllAccountData() {
        return this.accountRepository.findAll();
    }

    @Override
    public void saveAccountData(Account account) {
        this.accountRepository.save(account);

    }
}
