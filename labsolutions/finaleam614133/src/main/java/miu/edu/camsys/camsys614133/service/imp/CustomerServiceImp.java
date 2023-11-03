package miu.edu.camsys.camsys614133.service.imp;

import miu.edu.camsys.camsys614133.dto.customer.CustomerRequest;
import miu.edu.camsys.camsys614133.dto.customer.CustomerResponse;
import miu.edu.camsys.camsys614133.model.Customer;
import miu.edu.camsys.camsys614133.repository.CustomerRepository;
import miu.edu.camsys.camsys614133.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponse> findAllCustomer() {
        return customerRepository.findAll().stream().map(
                c -> new CustomerResponse(
                        c.getCustomerId(),
                        c.getFistName(),
                        c.getLastName()
                )
        ).collect(Collectors.toList());
    }

    @Override
    public CustomerResponse addNewCustomer(CustomerRequest customerRequest) {

        Customer customerTobeSave = new Customer(customerRequest.fistName(), customerRequest.lastName());

        Customer customerSaved = customerRepository.save(customerTobeSave);

        CustomerResponse customerResponse = new CustomerResponse(
                customerSaved.getCustomerId(),
                customerSaved.getFistName(),
                customerSaved.getLastName()
        );

        return customerResponse;
    }
}
