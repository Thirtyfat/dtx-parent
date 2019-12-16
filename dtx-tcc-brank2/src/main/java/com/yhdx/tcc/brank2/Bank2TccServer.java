
package com.yhdx.tcc.brank2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableDiscoveryClient
@EnableHystrix
@ComponentScan({"com.yhdx","org.dromara.hmily"})
public class Bank2TccServer {

	public static void main(String[] args) {
		SpringApplication.run(Bank2TccServer.class, args);

	}

}
