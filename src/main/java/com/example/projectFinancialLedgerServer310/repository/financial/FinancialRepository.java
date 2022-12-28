package com.example.projectFinancialLedgerServer310.repository.financial;

import com.example.projectFinancialLedgerServer310.entity.financial.FinancialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<FinancialEntity, Long> {
}
