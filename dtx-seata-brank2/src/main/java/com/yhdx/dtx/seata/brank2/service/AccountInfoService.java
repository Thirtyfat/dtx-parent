package com.yhdx.dtx.seata.brank2.service;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator.
 */
@Component
public interface AccountInfoService {

    /**
     * 李四增加金额
     * @param accountNo
     * @param amount
     */
    public void updateAccountBalance(String accountNo, Double amount);
}
