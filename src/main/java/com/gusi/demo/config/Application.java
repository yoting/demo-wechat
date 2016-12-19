package com.gusi.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.gusi.demo.utils.SpringBeanUtil;

@ComponentScan(basePackages = { "com.gusi.demo.*" })
@Configuration
@EnableAutoConfiguration
// @SpringBootApplication
public class Application {

	@Value("${app.name}")
	private String name;
	@Autowired
	private Environment env;

	// @Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));// 用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));// 密码
		dataSource.setInitialSize(2);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(0);
		dataSource.setMaxWait(60000);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestOnBorrow(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setPoolPreparedStatements(false);
		return dataSource;
	}

	@Bean
	public SpringBeanUtil springBeanUitl() {
		return new SpringBeanUtil();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// Object o = SpringBeanUtil.getBean("wechatController");
		// System.out.println(o);
	}
}