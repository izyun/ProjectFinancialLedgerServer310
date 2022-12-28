package com.example.projectFinancialLedgerServer310.service.ledger;

import com.example.projectFinancialLedgerServer310.entity.ledger.Ledger;
import com.example.projectFinancialLedgerServer310.repository.ledger.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LedgerServiceImpl implements LedgerService {

    private final LedgerRepository ledgerRepository;

    @Autowired
    public LedgerServiceImpl(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }


    @Override
    public List<Ledger> findAllLedgerData() {
        return this.ledgerRepository.findAll();
    }

    @Override
    public void saveLedgerData(Ledger ledger) {
        this.ledgerRepository.save(ledger);
    }

//    @Override
//    public List<Ledger> getLedgerListByPage(int currentPage, int rowPerPage) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("beginRow", (currentPage-1)*rowPerPage);
//        params.put("rowPerPage", rowPerPage);
//        return jdbcTemplate.query("""
//                SELECT
//                    ledger_id cashbookId,
//                    ledger_kind cashbookKind,
//                    category_name categoryName,
//                    ledger_price ledgerPrice,
//                    ledger_content cashbookContent,
//                    ledger_date ledgerDate,
//                    create_date createDate,
//                    update_date updateDate
//                FROM ledger_list
//                ORDER BY ledger_date DESC, ledger_id DESC
//                Limit #{beginRow},#{rowPerPage}
//                """, params, new LedgerMapper());
////        return ledgerRepository.selectCashbookListByPage(map);
//    }
//
//    @Override
//    public List<Ledger> getLedgerListByDay(int currentYear, int currentMonth, int currentDay) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("currentYear", currentYear);
//        params.put("currentMonth", currentMonth);
//        params.put("currentDay", currentDay);
//        return jdbcTemplate.query("""
//                SELECT *
//                FROM ledger_data
//                WHERE YEAR(cashbook_date)=#{currentYear}
//                AND MONTH(cashbook_date)=#{currentMonth}
//                AND DAY(cashbook_date)=#{currentDay}
//                """, params, new JdbcTemplate());
//    }
//
//    @Override
//    public List<Map<String, Object>> getCashListByMonth(int currentYear, int currentMonth) {
//        return null;
//    }
//
//    @Override
//    public int getSumLedgerPriceByInOut(String ledgerKind, int currentYear, int currentMonth) {
//        return 0;
//    }
}
