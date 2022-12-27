package com.example.projectFinancialLedgerServer310.repository.account;

import com.example.projectFinancialLedgerServer310.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
