package com.yhdx.tcc.brank1.controller;

import com.yhdx.tcc.brank1.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class Bank1Controller {
    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping(value = "/transfer/{amount}/{accountNo}",method = RequestMethod.GET)
    public Boolean transfer(@PathVariable("amount") Double amount,
                            @PathVariable("accountNo")String accountNo) {
        this.accountInfoService.updateAccountBalance(accountNo, amount);
        return true;
    }

}
