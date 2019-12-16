package com.yhdx.tcc.brank2.service;

/**
 * Created by Administrator.
 */
public interface AccountInfoService {

    /**
     * 账户扣款
     * @param accountNo
     * @param amount
     */
    public  void updateAccountBalance(String accountNo, Double amount);
}
