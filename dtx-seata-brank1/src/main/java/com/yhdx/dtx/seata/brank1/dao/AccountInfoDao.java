package com.yhdx.dtx.seata.brank1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator.
 */
@Mapper
@Component
public interface AccountInfoDao {

    /**
     * 更新账户金额
     * @param accountNo
     * @param amount
     * @return
     */
    @Update("update account_info set account_balance = account_balance + #{amount} where account_no = #{accountNo}")
    int updateAccountBalance(@Param("accountNo") String accountNo, @Param("amount") Double amount);

}
