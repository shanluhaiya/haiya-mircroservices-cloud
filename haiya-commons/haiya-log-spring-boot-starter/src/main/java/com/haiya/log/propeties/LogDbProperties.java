package com.haiya.log.propeties;

import com.zaxxer.hikari.HikariConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "haiya.audit-log.datasource")
public class LogDbProperties extends HikariConfig {
}