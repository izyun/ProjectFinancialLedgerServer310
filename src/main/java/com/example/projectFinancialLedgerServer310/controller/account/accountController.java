package com.example.projectFinancialLedgerServer310.controller.account;

import com.example.projectFinancialLedgerServer310.entity.account.Account;
import com.example.projectFinancialLedgerServer310.repository.account.AccountRepository;
import com.example.projectFinancialLedgerServer310.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class accountController {
    private final AccountService accountService;


    @Autowired
    public accountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("signUp")
    public String signUp() {
        return "account/signUp";
    }

    @PostMapping("signUp")
    public String signUp_post(
            @RequestParam(value = "input_id", required = false) String input_id,
            @RequestParam(value = "pw", required = false) String pw,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            Model model
    ) {
        this.accountService.saveAccountData(new Account(input_id, pw, name, email));
        model.addAttribute("signup_list", this.accountService.findAllAccountData());
        return "account/signUp";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("fail_Message", "");
        return "account/login";
    }

    @PostMapping("login")
    public String login_post(
            @RequestParam(value = "input_id", required = false) String input_id,
            @RequestParam(value = "pw", required = false) String pw,
            Model model
    ) {
        List<Account> members = this.accountService.findAllAccountData();
//        System.out.println(members.get(0).getInput_id());
//        System.out.println(members.get(0).getPw());
//        System.out.println(members.get(0).getName());
        String message = "";
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getInput_id().equals(input_id) && members.get(i).getPw().equals(pw)) {
                return "ledger/ledgerByMonth";
            }
        }
        model.addAttribute("fail_message", "로그인이 실패했습니다");
        model.addAttribute("list", members);
        return "account/login";
    }
}
