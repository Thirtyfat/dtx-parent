package com.yhdx.tcc.brank1.service;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator.
 */
@Component
public interface AccountInfoService {

    /**
     * 账户扣款
     * @param accountNo
     * @param amount
     */
    public  void updateAccountBalance(String accountNo, Double amount);
}
