package com.onfleek.turnservice.dataprovider.network.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", fallback = AccountFallback.class)
public interface AccountClient {

    @GetMapping("/accounts/{username}")
    Object getAccount(@PathVariable("userName") String userName);

}
