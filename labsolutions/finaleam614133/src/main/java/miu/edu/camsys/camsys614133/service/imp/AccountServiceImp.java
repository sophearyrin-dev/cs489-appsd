package miu.edu.camsys.camsys614133.service.imp;

import miu.edu.camsys.camsys614133.dto.account.AccountRequestWithCustomer;
import miu.edu.camsys.camsys614133.dto.account.AccountResponse;
import miu.edu.camsys.camsys614133.dto.customer.CustomerResponse;
import miu.edu.camsys.camsys614133.model.Account;
import miu.edu.camsys.camsys614133.model.Customer;
import miu.edu.camsys.camsys614133.repository.AccountRepository;
import miu.edu.camsys.camsys614133.repository.CustomerRepository;
import miu.edu.camsys.camsys614133.service.AccountService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    public AccountServiceImp(AccountRepository accountRepository,
                             CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<AccountResponse> findAllAccount() {
        return accountRepository.findAll(Sort.by("balance").descending()).stream()
                .filter(a -> a.getAccountType().equals("checking") && a.getAccountType().equals("saving"))
                .map(
                account -> new AccountResponse(
                        account.getAccountId(),
                        account.getAccountNumber(),
                        account.getAccountType(),
                        account.getDateOpened(),
                        account.getBalance(),
                        account.getCustomers().stream().map(
                                c -> new CustomerResponse(
                                        c.getCustomerId(),
                                        c.getFistName(),
                                        c.getLastName()
                                )
                        ).collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }

    @Override
    public AccountResponse addNewAccount(AccountRequestWithCustomer newAccount) {

        Account accountToSave = new Account(
                newAccount.accountNumber(),
                newAccount.accountType(),
                newAccount.dateOpened(),
                newAccount.balance()
        );

        Customer customerToSave = new Customer(
                newAccount.customer().fistName(),
                newAccount.customer().lastName()
        );

            // Save both entities to the database
            accountRepository.save(accountToSave);
            customerRepository.save(customerToSave);

            // You can return an AccountResponse with the relevant information if needed
            AccountResponse accountResponse = new AccountResponse(
                    accountToSave.getAccountId(),
                    accountToSave.getAccountNumber(),
                    accountToSave.getAccountType(),
                    accountToSave.getDateOpened(),
                    accountToSave.getBalance(),
                    accountToSave.getCustomers().stream().map(
                            a -> new CustomerResponse(
                                    a.getCustomerId(),
                                    a.getFistName(),
                                    a.getLastName()
                            )
                    ).collect(Collectors.toList())
            );
            return accountResponse;
        }

    @Override
    public List<AccountResponse> primeAccoutnList() {
        return accountRepository.findAll(Sort.by("balance").descending()).stream()
                .filter(Account::isPrime)
                .map(
                account -> new AccountResponse(
                        account.getAccountId(),
                        account.getAccountNumber(),
                        account.getAccountType(),
                        account.getDateOpened(),
                        account.getBalance(),
                        account.getCustomers().stream().map(
                                c -> new CustomerResponse(
                                        c.getCustomerId(),
                                        c.getFistName(),
                                        c.getLastName()
                                )
                        ).collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }


}
