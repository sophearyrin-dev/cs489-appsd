package miu.edu.camsys.camsys614133.dto.account;

import miu.edu.camsys.camsys614133.constant.AccountType;
import miu.edu.camsys.camsys614133.dto.customer.CustomerRequest;

import java.time.LocalDate;

public record AccountRequestWithCustomer(

        String accountNumber,

        String accountType,


        LocalDate dateOpened,

        Double balance,

        CustomerRequest customer
){
}
