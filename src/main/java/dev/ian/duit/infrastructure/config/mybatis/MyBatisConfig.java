package dev.ian.duit.infrastructure.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("dev.ian.duit")
public class MyBatisConfig {
  
}
