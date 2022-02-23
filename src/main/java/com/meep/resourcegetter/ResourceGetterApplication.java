package com.meep.resourcegetter;

import com.meep.resourcegetter.entity.ResourceInfo;
import feign.Feign;
import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableCircuitBreaker
public class ResourceGetterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceGetterApplication.class, args);
    }

}
