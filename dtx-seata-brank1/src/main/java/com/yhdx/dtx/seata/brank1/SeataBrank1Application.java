package com.yhdx.dtx.seata.brank1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by yj on 2019/12/16.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.yhdx"})
public class SeataBrank1Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataBrank1Application.class, args);

    }
}
