package miu.edu.camsys.camsys614133.controller;


import miu.edu.camsys.camsys614133.dto.customer.CustomerRequest;
import miu.edu.camsys.camsys614133.dto.customer.CustomerResponse;
import miu.edu.camsys.camsys614133.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/camsys/api/customer"})
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerResponse>> findAllCustomer(){
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.addNewCustomer(customerRequest),
                HttpStatus.OK);
    }
}
