package com.yhdx.tcc.brank2.controller;

import com.yhdx.tcc.brank2.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class Bank2Controller {
    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping(value = "/transfer/{amount}",method = RequestMethod.GET)
    public Boolean transfer(@PathVariable("amount") Double amount){
        this.accountInfoService.updateAccountBalance("100010", amount);
        return true;
    }
}
