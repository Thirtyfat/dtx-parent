package com.yhdx.dtx.seata.brank1.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import static com.yhdx.dtx.seata.brank1.config.FeignEnvironment.SEATA_BRANK_TWO_SERVER;
import static com.yhdx.dtx.seata.brank1.config.FeignEnvironment.SEATA_BRANK_TWO_SERVER_PATH;

/**
 * Created by Administrator.
 */
@FeignClient(value= SEATA_BRANK_TWO_SERVER, path = SEATA_BRANK_TWO_SERVER_PATH,fallback=Bank2ClientFallback.class)
public interface Bank2Client {

    /**
     * 远程调用李四的微服务
     * @param amount
     * @return
     */
    @RequestMapping(value = "/transfer/{amount}/{accountNo}",method = RequestMethod.GET)
    String transfer(@PathVariable("amount") Double amount,
                    @PathVariable("accountNo") String accountNo);
}
