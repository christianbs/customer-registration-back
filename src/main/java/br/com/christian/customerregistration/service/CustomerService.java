package br.com.christian.customerregistration.service;

import br.com.christian.customerregistration.model.Customer;
import br.com.christian.customerregistration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customer.calculateInterestRate();
        customerRepository.save(customer);
    }

    public void delete(Long id) throws IllegalArgumentException {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            customerRepository.delete(optional.get());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
