package com.dtx.txmsg.bank1.service;


import com.dtx.txmsg.bank1.model.AccountChangeEvent;

/**
 * Created by Administrator.
 */
public interface AccountInfoService {

    /**
     * 向mq发送转账消息
     * @param accountChangeEvent
     */
    public void sendUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

    /**
     * 更新账户，扣减金额
     * @param accountChangeEvent
     */
    public void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

}
