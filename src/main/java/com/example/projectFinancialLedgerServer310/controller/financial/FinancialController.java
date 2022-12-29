package com.example.projectFinancialLedgerServer310.controller.financial;

import com.example.projectFinancialLedgerServer310.entity.financial.FinancialEntity;
import com.example.projectFinancialLedgerServer310.service.financial.FinancialExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.projectFinancialLedgerServer310.component.useLocalMethod.useTimeMethod.timeData;


/**
 * 가계부 작성 순서
 * 1. controller 작성 (URL 호출에 맞춰 흐름 설정) : controller/financial/FinancialController
 * 2. entity 작성 (가계부라는 DB table에 저장할 컬럼을 지정) : entity/financial/FinancialEntity
 * 3. repository 작성 (가계부 entity와 mysql과 연동할 JPARepositoy 구현) : repository/financialExample
 * 4. service Interface와 구현 클래스 작성() : service/financial/**
 */
@Controller
public class FinancialController {

    private FinancialExample financialExample;

    @Autowired
    public FinancialController(FinancialExample financialExample) {
        this.financialExample = financialExample;
    }

    /**
     *
     * @param model financialList : 특정 요일 사이의 데이터 출력
     * @return
     */
    @PostMapping("financial_day")
    public String financial_day_post(@RequestParam(value = "start_day", required = false)String start_day,
                                @RequestParam(value = "end_day", required = false)String end_day,
                                Model model ) {
        String returndata = "";
        returndata = this.financialExample.BetweenDayFinancialData(start_day, end_day);
        model.addAttribute("financialData", returndata);
        return "financial/financial_index";
    }

    /**
     *
     * @param model financialList : 가계부 테이블의 목록 모두 조회
     * @return
     */
    @GetMapping("financial_index")
    public String financial_index(Model model ) {
        model.addAttribute("financialList", this.financialExample.FindAllFinancialData());
        return "financial/financial_index";
    }

    /**
     * private String return_operand; 지출, 수익 분별 (+,-)
     * private String price; 금액
     * @return
     */
    @PostMapping("financial_index")
    public String financial_index(
            @RequestParam(value = "return_operate", required = false)String return_operate,
            @RequestParam(value = "price", required = false)String price,
            @RequestParam(value = "financial_day", required = false)String financial_day,
            Model model
    ) {
        this.financialExample.saveFinancialData(new FinancialEntity(return_operate, price, financial_day, timeData()));
        return "redirect:/financial_index";
    }
}
