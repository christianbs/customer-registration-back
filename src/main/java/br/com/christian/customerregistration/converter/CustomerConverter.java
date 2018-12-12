package br.com.christian.customerregistration.converter;

import br.com.christian.customerregistration.dto.CustomerDTO;
import br.com.christian.customerregistration.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends Converter<Customer, CustomerDTO> {

    @Override
    Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    Class getDTOClass() {
        return CustomerDTO.class;
    }
}
