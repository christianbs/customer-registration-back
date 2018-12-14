package br.com.christian.customerregistration.dto;

import br.com.christian.customerregistration.constant.Risk;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CustomerDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal creditLimit;
    @NotNull
    private Risk risk;
    private Integer interestRate;

}
