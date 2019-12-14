package com.dtx.txmsg.bank1.controller;

import com.dtx.txmsg.bank1.model.AccountChangeEvent;
import com.dtx.txmsg.bank1.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@Slf4j
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping(value = "/transfer/{accountNo}/{amount}",method = RequestMethod.GET)
    public String transfer(
            @PathVariable("accountNo")String accountNo,
            @PathVariable("amount") Double amount ){
        //创建一个事务id，作为消息内容发到mq
        String tx_no = UUID.randomUUID().toString();
        AccountChangeEvent accountChangeEvent = new AccountChangeEvent(accountNo,amount,tx_no);
        //发送消息
        accountInfoService.sendUpdateAccountBalance(accountChangeEvent);
        return "转账成功";
    }
}
