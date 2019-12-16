package com.yhdx.dtx.seata.brank2.controller;

import com.yhdx.dtx.seata.brank2.service.AccountInfoService;
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


//    @RequestMapping(value = "/transfer/{amount}/{accountNo}",method = RequestMethod.GET)
//    public String transfer1(@PathVariable("amount") Double amount,
//                           @PathVariable("accountNo") String accountNo){
//        //李四增加金额
//        accountInfoService.updateAccountBalance(accountNo,amount);
//        return "bank2"+amount;
//    }
//接收张三的转账
    @RequestMapping(value = "/transfer/{amount}/{accountNo}",method = RequestMethod.GET)
    public String transfer(
                    @PathVariable("amount") Double amount,
                    @PathVariable("accountNo") String accountNo){
        //李四增加金额
        accountInfoService.updateAccountBalance(accountNo,amount);
        return "bank2"+amount;
    }
}

