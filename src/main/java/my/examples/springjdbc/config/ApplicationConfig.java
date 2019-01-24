package my.examples.springjdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "my.examples.springjdbc.dao","my.examples.springjdbc.service" })
@Import({DataSourceConfig.class})
public class ApplicationConfig {
}
