package com.bryczek.centralapplication.consul.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("properties")
@Data
@RefreshScope
public class ReloadingProperties {
    private String firstProp;
}
