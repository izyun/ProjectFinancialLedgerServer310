package com.example.projectFinancialLedgerServer310.controller.ledger;

import com.example.projectFinancialLedgerServer310.entity.financial.FinancialEntity;
import com.example.projectFinancialLedgerServer310.entity.ledger.Ledger;
import com.example.projectFinancialLedgerServer310.repository.ledger.LedgerRepository;
import com.example.projectFinancialLedgerServer310.service.ledger.LedgerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static com.example.projectFinancialLedgerServer310.component.useLocalMethod.useTimeMethod.timeData;

@Controller
public class ledgerController {
    private final LedgerService ledgerService;

    public ledgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

//    @GetMapping("/ledgerList/{currentPage}")
//    public String ledgerList(Model model,
//                               @PathVariable(name = "currentPage", required = true) int currentPage) {
//        int rowPerPage = 20;
//        List<Ledger> ledgerList = LedgerService.getLedgerListByPage(currentPage, rowPerPage);
//        model.addAttribute("ledgerList", ledgerList);
//        return "ledgerList";
//    }

    @GetMapping("insertLedger")
    public String insertLedger(Model model) { // 커맨드객체
        // System.out.println(ledger);
        model.addAttribute("ledgerData", this.ledgerService.findAllLedgerData());
        return "ledger/insertLedger";
    }

    @PostMapping("insertLedger")
    public String insertLedger_post(
            @RequestParam(value = "return_operate", required = false) String return_operate,
            @RequestParam(value = "ledgerPrice", required = false) int ledgerPrice,
            @RequestParam(value = "ledgerContent", required = false) String ledgerContent,
            @RequestParam(value = "ledgerDate", required = false) String ledgerDate,
            Model model
    ) {
        this.ledgerService.saveLedgerData(new Ledger(return_operate, ledgerPrice, ledgerContent, ledgerDate, timeData()));
        //redirect 적용
//        List<Category> categoryList = categoryService.getCategoryList();
//        model.addAttribute("categoryList", categoryList);
        return "redirect:/insertLedger"; // forward
    }

//    @GetMapping("/ledgerByDay/{target}/{currentYear}/{currentMonth}/{currentDay}")
//    public String ledgerByDay(Model model,
//                              @PathVariable(name = "target") String target,
//                              @PathVariable(name = "currentYear", required = true) int currentYear,
//                              @PathVariable(name = "currentMonth", required = true) int currentMonth,
//                              @PathVariable(name = "currentDay", required = true) int currentDay) {
//        Calendar targetDay = Calendar.getInstance();
//        targetDay.set(Calendar.YEAR, currentYear);
//        targetDay.set(Calendar.MONTH, currentMonth - 1);
//        targetDay.set(Calendar.DATE, currentDay);
//        if (target.equals("pre")) {
//            targetDay.add(Calendar.DATE, -1);
//        } else if (target.equals("next")) {
//            targetDay.add(Calendar.DATE, 1);
//        }
//
//        List<Ledger> ledgerList = LedgerService.getLedgerListByDay(
////        List<Ledger> ledgerList = this.ledgerService.findAllLedgerData(
//                targetDay.get(Calendar.YEAR),
//                targetDay.get(Calendar.MONTH) + 1,
//                targetDay.get(Calendar.DATE));
//        model.addAttribute("ledgerList", ledgerList);
//        model.addAttribute("currentYear", targetDay.get(Calendar.YEAR));
//        model.addAttribute("currentMonth", targetDay.get(Calendar.MONTH) + 1);
//        model.addAttribute("currentDay", targetDay.get(Calendar.DATE));
//        return "ledgerByDay";
//    }

//    @GetMapping(value="/ledgerByMonth")
//    public String cashbookByMonth(Model model,
//                                  @RequestParam(name = "currentYear", defaultValue = "-1") int currentYear,
//                                  @RequestParam(name = "currentMonth", defaultValue = "-1") int currentMonth) {
//        // 1-1. 요청분석
//        Calendar currentDay = Calendar.getInstance(); // 2020년 11월 2일
//        // currentYear 넘어오고, currentMonth도 넘어면
//        // ISSUE : Calendar API 사용하는 코드로 변경! : currentDay.add(Calendar.MONTH, -1)
//        if(currentYear != -1 && currentMonth != -1) {
//            if(currentMonth == 0) {
//                currentYear -= 1;
//                currentMonth = 12;
//            }
//            if(currentMonth == 13) {
//                currentYear += 1;
//                currentMonth = 1;
//            }
//            currentDay.set(Calendar.YEAR, currentYear);
//            currentDay.set(Calendar.MONTH, currentMonth-1);
//        }
//        currentDay.set(Calendar.DATE, 1); // 2020년 11월 1일
//
//        currentYear = currentDay.get(Calendar.YEAR);
//        currentMonth = currentDay.get(Calendar.MONTH) + 1;
//        int lastDay = currentDay.getActualMaximum(Calendar.DATE);
//        int firstDayOfWeek = currentDay.get(Calendar.DAY_OF_WEEK);
//        // -----------------------------------------------------------------------------
//        int sumIn = LedgerService.getSumLedgerPriceByInOut("수입", currentYear, currentMonth);
//        int sumOut = LedgerService.getSumLedgerPriceByInOut("지출", currentYear, currentMonth);
//
//        // -----------------------------------------------------------------------------
//        List<Map<String, Object>> cashList = LedgerService.getCashListByMonth(currentYear, currentMonth);
//        // -------------------------------------------------------------------------------
//
//        // 3. 뷰 모델 추가
//        model.addAttribute("currentYear", currentYear); // 년
//        model.addAttribute("currentMonth", currentMonth); // 월
//        model.addAttribute("lastDay", lastDay); // 마지막 일
//        model.addAttribute("firstDayOfWeek", firstDayOfWeek); // 1일의 요일
//
//        model.addAttribute("sumIn", sumIn);
//        model.addAttribute("sumOut", sumOut);
//
//        model.addAttribute("cashList", cashList);
//
//        return "ledgerByMonth";
//}
}