package com.yhdx.dtx.seata.brank1.spring;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 **/
@Component
public class Bank2ClientFallback implements Bank2Client {

    @Override
    public String transfer(Double amount,String accountNo) {

        return "fallback";
    }
}
