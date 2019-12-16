package com.yhdx.dtx.seata.brank1.service.impl;


import com.yhdx.dtx.seata.brank1.dao.AccountInfoDao;
import com.yhdx.dtx.seata.brank1.service.AccountInfoService;
import com.yhdx.dtx.seata.brank1.spring.Bank2Client;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoDao accountInfoDao;

    @Autowired
    private Bank2Client bank2Client;

    /**
     * 开启全局事务
     * @param accountNo
     * @param amount
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @GlobalTransactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank1 service begin,XID：{}", RootContext.getXID());
        //扣减张三的金额
        accountInfoDao.updateAccountBalance(accountNo,amount *-1);
        //调用李四微服务，转账
        log.info("feign client request amount {} , accountNo{}", amount,accountNo);
        String transfer = bank2Client.transfer(amount,accountNo);
        if("fallback".equals(transfer)){
            //调用李四微服务异常
            throw new RuntimeException("调用李四微服务异常");
        }
        if(amount == 2){
            //人为制造异常
            throw new RuntimeException("bank1 make exception..");
        }
    }
}
