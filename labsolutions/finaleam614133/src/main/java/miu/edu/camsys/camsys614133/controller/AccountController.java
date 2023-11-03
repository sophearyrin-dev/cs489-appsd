package miu.edu.camsys.camsys614133.controller;


import miu.edu.camsys.camsys614133.dto.account.AccountRequestWithCustomer;
import miu.edu.camsys.camsys614133.dto.account.AccountResponse;
import miu.edu.camsys.camsys614133.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/camsys/api/account"})
public class AccountController {

    private AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/deposit/list")
    public ResponseEntity<List<AccountResponse>> findAllAccount(){
        return new ResponseEntity<>(accountService.findAllAccount(), HttpStatus.FOUND);
    }

    @GetMapping("/prime/list")
    public ResponseEntity<List<AccountResponse>> findAllPrimeAccount(){
        return new ResponseEntity<>(accountService.primeAccoutnList(), HttpStatus.FOUND);
    }

    //Liquidity Position

    @GetMapping("/get/currentliquid")
    public ResponseEntity<List<AccountResponse>> findCurrentLiquid(){
        return new ResponseEntity<>(accountService.findAllAccount(), HttpStatus.FOUND);
    }


    @PostMapping("/new")
    public ResponseEntity<AccountResponse> saveAccount(
            AccountRequestWithCustomer accountRequest){
        return new ResponseEntity<>(accountService.addNewAccount(accountRequest), HttpStatus.CREATED);
    }
}
