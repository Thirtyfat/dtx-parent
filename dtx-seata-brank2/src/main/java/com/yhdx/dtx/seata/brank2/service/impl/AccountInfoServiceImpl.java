package com.yhdx.dtx.seata.brank2.service.impl;

import com.yhdx.dtx.seata.brank2.dao.AccountInfoDao;
import com.yhdx.dtx.seata.brank2.service.AccountInfoService;
import io.seata.core.context.RootContext;
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
    private final static String ACCOUNT = "9527";


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank2 service begin,XID：{}",RootContext.getXID());
        //李四增加金额
        log.info("feign client request amount {} , accountNo{}", amount,accountNo);
        if(ACCOUNT.equals(accountNo)){
            accountNo = "100010";
        }
        accountInfoDao.updateAccountBalance(accountNo,amount);
        if(amount==3){
            //人为制造异常
            throw new RuntimeException("bank2 make exception..");
        }
    }
}
