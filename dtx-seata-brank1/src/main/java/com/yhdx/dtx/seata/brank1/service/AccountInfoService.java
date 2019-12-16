package com.yhdx.dtx.seata.brank1.service;

/**
 * Created by Administrator.
 */
public interface AccountInfoService {

    /**
     * 张三扣减金额
     * @param accountNo
     * @param amount
     */
    public void updateAccountBalance(String accountNo, Double amount);
}
