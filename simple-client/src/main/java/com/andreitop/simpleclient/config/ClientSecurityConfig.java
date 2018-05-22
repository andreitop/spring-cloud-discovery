package com.andreitop.simpleclient.config;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Optional;


@Configuration
public class ClientSecurityConfig {

    @Value("${server.ssl.keyStoreType}")
    private String storeType;

    @Value("${server.ssl.keyStorePassword}")
    private String storePassword;

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {

        DiscoveryClient.DiscoveryClientOptionalArgs args =
                new DiscoveryClient.DiscoveryClientOptionalArgs();

        String storePath = Optional.ofNullable(System.getProperty("cryptostore.path"))
                .orElse(this.getClass()
                            .getClassLoader()
                            .getResource("client.p12")
                            .getPath());
        System.setProperty("javax.net.ssl.keyStore", storePath);
        System.setProperty("javax.net.ssl.keyStorePassword", storePassword);
        System.setProperty("javax.net.ssl.keyStoreType", storeType);
        System.setProperty("javax.net.ssl.trustStore", storePath);
        System.setProperty("javax.net.ssl.trustStoreType", storeType);
        System.setProperty("javax.net.ssl.trustStorePassword", storePassword);

        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
        builder.withClientName("discovery-client");
        builder.withSystemSSLConfiguration();
        builder.withMaxTotalConnections(10);
        builder.withMaxConnectionsPerHost(10);
        args.setEurekaJerseyClient(builder.build());

        return args;
    }
}
