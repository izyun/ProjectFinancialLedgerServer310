package com.example.projectFinancialLedgerServer310.service.financial;


import com.example.projectFinancialLedgerServer310.entity.financial.FinancialEntity;

import java.util.HashMap;
import java.util.List;

public interface FinancialExample {

    List<FinancialEntity> FindAllFinancialData();

    void saveFinancialData(FinancialEntity financialEntity);

    String BetweenDayFinancialData(String start_day, String end_day);

}


