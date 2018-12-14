package br.com.christian.customerregistration.model;

import br.com.christian.customerregistration.constant.Risk;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal creditLimit;
    @Enumerated(EnumType.STRING)
    private Risk risk;
    private Integer interestRate;

    public void calculateInterestRate() {
        switch (risk) {
            case A:
                interestRate = 0;
                break;
            case B:
                interestRate = 10;
                break;
            case C:
                interestRate = 20;
                break;
        }
    }
}
