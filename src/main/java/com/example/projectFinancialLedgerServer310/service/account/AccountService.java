package com.example.projectFinancialLedgerServer310.service.account;

import com.example.projectFinancialLedgerServer310.entity.account.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccountData();
    void saveAccountData(Account account);
}
