package dev.ian.duit.infrastructure.config.mybatis;

import java.time.LocalDateTime;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dev.ian.duit.domain.question.core.Mcq;
import dev.ian.duit.domain.question.core.McqChoice;
import dev.ian.duit.domain.quiz.core.QuizItemResult;


@org.springframework.context.annotation.Configuration
@MapperScan("dev.ian.duit")
public class MyBatisConfig {

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;
  
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      sessionFactory.setDataSource(dataSource);
      sessionFactory.addMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));

      // sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
      sessionFactory.addTypeAliases(
          // java classes
        LocalDateTime.class,
          Set.class,

          // owned classes
          QuizItemResult.class,
          Mcq.class,
          McqChoice.class
      );

      return sessionFactory.getObject();
    }
    
}
