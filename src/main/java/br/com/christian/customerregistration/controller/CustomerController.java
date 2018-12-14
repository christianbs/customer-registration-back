package br.com.christian.customerregistration.controller;

import br.com.christian.customerregistration.converter.CustomerConverter;
import br.com.christian.customerregistration.dto.CustomerDTO;
import br.com.christian.customerregistration.model.Customer;
import br.com.christian.customerregistration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    @GetMapping(produces = "application/json")
    public ResponseEntity findAll() {
        List<Customer> customers = customerService.findAll();
        if (customers == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else if (customers.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            List<CustomerDTO> dtos = customers.stream().map(c -> customerConverter.convertToDTO(c)).collect(Collectors.toList());
            return new ResponseEntity(dtos, HttpStatus.OK);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity save(@RequestBody CustomerDTO dto) {
        Customer customer = customerConverter.convertToEntity(dto);
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            customerService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
