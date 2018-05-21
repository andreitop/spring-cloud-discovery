package com.andreitop.simpleclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/check")
    public List<ServiceInstance> checkAllServices() {
        List<ServiceInstance> instances = discoveryClient.getInstances("discovery-client");
        LOGGER.info("INSTANCES: count={}", instances.size());
        instances.forEach(it -> LOGGER.info("INSTANCE: id={}, port={}", it.getServiceId(), it.getPort()));
        return instances;

    }
}
