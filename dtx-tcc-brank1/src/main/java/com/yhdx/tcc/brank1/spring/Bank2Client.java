package com.yhdx.tcc.brank1.spring;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import static com.yhdx.tcc.brank1.config.FeignEnvironment.TCC_BANK_TWO_SERVER;
import static com.yhdx.tcc.brank1.config.FeignEnvironment.TCC_BANK_TWO_SERVER_PATH;

/**
 * Created by Administrator.
 */
@FeignClient(value=TCC_BANK_TWO_SERVER,path = TCC_BANK_TWO_SERVER_PATH, fallback=Bank2ClientFallback.class)
public interface Bank2Client {


    /**
     * 远程调用李四的微服务
     * @param amount
     * @return
     */
    @RequestMapping(value = "/transfer/{amount}",method = RequestMethod.GET)
    @Hmily
    public Boolean transfer(@PathVariable("amount") Double amount);
}
