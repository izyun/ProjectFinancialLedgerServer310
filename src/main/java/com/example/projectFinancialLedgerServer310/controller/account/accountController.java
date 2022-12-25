package com.example.projectFinancialLedgerServer310.controller.account;

import com.example.projectFinancialLedgerServer310.entity.account.Signup;
import com.example.projectFinancialLedgerServer310.repository.account.SignupRepository;
import com.example.projectFinancialLedgerServer310.service.account.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class accountController {
    private final SignupService signupService;
    private final SignupRepository signupRepository;

    @Autowired
    public accountController(SignupService signupService, SignupRepository signupRepository) {
        this.signupService = signupService;
        this.signupRepository = signupRepository;
    }

    Long inject = 1L;

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

        inject++;
        signupRepository.save(new Signup(inject, input_id, pw, name, email));
        model.addAttribute("signup_list", signupService.getSignupInfo());
        return "account/signUp";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("failMessage", "");
        return "account/login";
    }

    @PostMapping("login")
    public String login_post(
            @RequestParam(value = "input_id", required = false) String input_id,
            @RequestParam(value = "pw", required = false) String pw,
            Model model
    ) {
        List<Signup> members = signupService.getSignupInfo();
        System.out.println(members.get(1).getInput_id());
        System.out.println(members.get(1).getPw());
        System.out.println(members.get(1).getName());
        String message = "";
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getInput_id().equals(input_id) && members.get(i).getPw().equals(pw)) {
                return "ledgerByMonth";
            }
        }
        model.addAttribute("fail_message", "로그인이 실패했습니다");
        model.addAttribute("list", members);
        return "account/login";
    }
}
