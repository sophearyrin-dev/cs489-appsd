package miu.edu.camsys.camsys614133.service;

import miu.edu.camsys.camsys614133.dto.customer.CustomerRequest;
import miu.edu.camsys.camsys614133.dto.customer.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAllCustomer();

    CustomerResponse addNewCustomer(CustomerRequest customerRequest);
}
