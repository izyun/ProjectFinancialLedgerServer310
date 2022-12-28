package com.example.projectFinancialLedgerServer310.repository.ledger;

import com.example.projectFinancialLedgerServer310.entity.ledger.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {
}
