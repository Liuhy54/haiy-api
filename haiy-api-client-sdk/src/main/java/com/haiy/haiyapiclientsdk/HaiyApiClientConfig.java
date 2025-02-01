package com.haiy.haiyapiclientsdk;

import com.haiy.haiyapiclientsdk.client.HaiyApiClient;
import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@AutoConfiguration
@EnableConfigurationProperties(HaiyApiClientConfig.class)
@ConfigurationProperties("haiy-api.client")
@Data
@ComponentScan
public class HaiyApiClientConfig {

    private  String accessKey;

    private  String secretKey;

    @Bean
    public HaiyApiClient haiyApiClient() {
        return new HaiyApiClient(accessKey, secretKey);
    }
}
