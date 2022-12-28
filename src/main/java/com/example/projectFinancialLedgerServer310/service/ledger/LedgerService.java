package com.example.projectFinancialLedgerServer310.service.ledger;

import com.example.projectFinancialLedgerServer310.entity.ledger.Ledger;

import java.util.List;
import java.util.Map;

public interface LedgerService {
    public List<Ledger> findAllLedgerData();
    void saveLedgerData(Ledger ledger);
//    public List<Ledger> getLedgerListByPage(int currentPage, int rowPerPage);
//    public List<Ledger> getLedgerListByDay(int currentYear, int currentMonth, int currentDay);
//    public List<Map<String, Object>> getCashListByMonth(int currentYear, int currentMonth);
//    public int getSumLedgerPriceByInOut(String ledgerKind, int currentYear, int currentMonth);

}
