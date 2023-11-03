package miu.edu.camsys.camsys614133.service;

import miu.edu.camsys.camsys614133.dto.account.AccountRequestWithCustomer;
import miu.edu.camsys.camsys614133.dto.account.AccountResponse;

import java.util.List;

public interface AccountService {

    List<AccountResponse> findAllAccount();

    AccountResponse addNewAccount(AccountRequestWithCustomer newAccount);

    List<AccountResponse> primeAccoutnList();
}
