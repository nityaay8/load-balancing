package com.n9.controler;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Service1Controller {

    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public Service1Controller(WebClient.Builder webClientBuilder,
                              ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
        this.lbFunction = lbFunction;
    }

    @RequestMapping("/hello")
    public Mono<String> hello() {
        return loadBalancedWebClientBuilder.build().get().uri("http://ms2/micro/hello")
                .retrieve().bodyToMono(String.class)
                .map(greeting -> greeting);
    }
}
