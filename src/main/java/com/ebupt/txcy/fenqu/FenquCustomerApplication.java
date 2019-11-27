package com.ebupt.txcy.fenqu;

import com.ebupt.txcy.fenqu.dao.MySimpleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(value = "com.ebupt.txcy.fenqu.dao", repositoryBaseClass = MySimpleRepository.class)
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class FenquCustomerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FenquCustomerApplication.class, args);
    }

}
