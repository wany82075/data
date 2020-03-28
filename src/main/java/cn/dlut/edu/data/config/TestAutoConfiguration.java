package cn.dlut.edu.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TestConfigProperties.class)
@ConditionalOnProperty(prefix = "cn.dlut.edu.test", name = "enable", havingValue = "true")
public class TestAutoConfiguration {

	 @Autowired
	  private TestConfigProperties properties;

	  @Autowired(required = false)
	  private ApplicationContext applicationContext;
	  
	  @Bean
	  public TestCreator getTestCreator() {
		  System.out.println(applicationContext);
		  return new TestCreator(properties.getConfigitem1(), properties.getConfigitem2(), properties.getConfigitem3());
	  }
}
