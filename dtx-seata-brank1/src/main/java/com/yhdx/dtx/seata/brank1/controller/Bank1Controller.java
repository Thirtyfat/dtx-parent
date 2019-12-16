package com.yhdx.dtx.seata.brank1.controller;

import com.yhdx.dtx.seata.brank1.service.AccountInfoService;
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

    /**
     * 张三转账
     * @param amount
     * @return
     */
    @RequestMapping(value = "/transfer/{amount}/{accountNo}",method = RequestMethod.GET)
    public String transfer(@PathVariable("amount") Double amount,
                           @PathVariable("accountNo") String accountNo){
        accountInfoService.updateAccountBalance(accountNo,amount);
        return "bank1"+amount;
    }
}
