package br.com.christian.customerregistration.dto;

import br.com.christian.customerregistration.constant.Risk;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerDTO {

    private Long id;
    private String name;
    private BigDecimal creditLimit;
    private Risk risk;
    private Integer interestRate;

}
