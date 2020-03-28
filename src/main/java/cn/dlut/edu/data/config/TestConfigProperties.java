package cn.dlut.edu.data.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = TestConfigProperties.prefix)
public class TestConfigProperties {
	public static final String prefix = "cn.dlut.edu.test";
	
	private String configitem1;
	private String configitem2;
	private String configitem3;
}
