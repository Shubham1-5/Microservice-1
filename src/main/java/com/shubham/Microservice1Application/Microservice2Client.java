package com.shubham.Microservice1Application;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class will be responsible for communicating with Microservice2
 */
//@FeignClient(name = "myFeignClient", url = "http://localhost:7072/")  --> Hardcoding the ip and port

  @FeignClient (name = "MICROSERVICE2") //fetching from eureka server
  @LoadBalancerClient(name = "MICROSERVICE2", configuration = LoadBalancerConfigurations.class)
public interface Microservice2Client {

    /**
     * This method should have the logic to call Microservice2
     * @return
     */
    @GetMapping("ms2/v1/messages")
    public String getMessage();

}
