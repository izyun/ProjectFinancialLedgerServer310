package com.example.projectFinancialLedgerServer310.service.financial;

import com.example.projectFinancialLedgerServer310.entity.financial.FinancialEntity;
import com.example.projectFinancialLedgerServer310.repository.financial.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FinancialExampleImpl implements FinancialExample {

    private FinancialRepository financialRepository;

    @Autowired
    public FinancialExampleImpl(FinancialRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    @Override
    public List<FinancialEntity> FindAllFinancialData() {
        return this.financialRepository.findAll();
    }

    @Override
    public void saveFinancialData(FinancialEntity financialEntity) {
        this.financialRepository.save(financialEntity);
    }

    @Override
    public String BetweenDayFinancialData(String start_day, String end_day) {
        int sum = 0;
//        mysql에서 모든 값 가져오기
        List<FinancialEntity> data = this.financialRepository.findAll();
//        가져온 데이터를 하나씩 불러오기
        for(FinancialEntity item : data) {
//            가져온 값의 날짜가 start_day보다 크고, end_day보다 작다는 조건 2개를 모두 만족하는 조건문
//            Integer.parseInt() : string 문자열을 int로 변환하여 사칙연산 및 숫자 비교문 가능하도록 정수 변환
            if(Integer.parseInt(start_day) <= Integer.parseInt(item.getFinancial_day()) && Integer.parseInt(end_day) >= Integer.parseInt(item.getFinancial_day()) ) {
//                수입(+) 컬럼 확인
                if (item.getReturn_operate().equals("+")) {
                    sum += Integer.parseInt(item.getPrice());
//                    지출(-) 컬럼 확인 하여 날짜 범위안에 있는 정수 계산
                }else if (item.getReturn_operate().equals("-")) {
                    sum -= Integer.parseInt(item.getPrice());
                }
            }
        }
//        html에 string으로 model에 전달해야 하기 때문에 Integer.toString()으로 문자열로 변환
        return Integer.toString(sum);
    }

}
