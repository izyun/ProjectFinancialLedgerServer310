package com.example.projectFinancialLedgerServer310.entity.ledger;

import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;

@Data
@Entity
@Table(name = "ledger_data")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ledgerDate;
    private String ledgerContent;
    private String return_operate;
    private int ledgerPrice;
    private String updateDate;

    public Ledger(String return_operate, int ledgerPrice, String ledgerContent, String ledgerDate, String updateDate ) {
        this.ledgerDate = ledgerDate;
        this.ledgerContent = ledgerContent;
        this.return_operate = return_operate;
        this.ledgerPrice = ledgerPrice;
        this.updateDate = updateDate;
    }
}
