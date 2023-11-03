package miu.edu.camsys.camsys614133.dto.account;

import miu.edu.camsys.camsys614133.dto.customer.CustomerResponse;

import java.time.LocalDate;
import java.util.List;

public record AccountResponse(

        Integer accountId,


        String accountNumber,


        String accountType,


        LocalDate dateOpened,

        Double balance,

        List<CustomerResponse> customers
) {
}
