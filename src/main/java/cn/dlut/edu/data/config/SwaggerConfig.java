package cn.dlut.edu.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicates;


@Configuration
@EnableSwagger2
//包扫描，在此包下的Controler都会被纳入swagger接口文档生成的范围，这里也可以配置类扫描，同时也可以在这个配置类里面细化过滤规则
@ComponentScan(basePackages = "cn.dlut.edu.data.*.controller")
public class SwaggerConfig {

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		// 指定规范，这里是SWAGGER_2
		return new Docket(DocumentationType.SWAGGER_2)
				// 设定Api文档头信息，这个信息会展示在文档UI的头部位置
				.apiInfo(swaggerDemoApiInfo()).select()
				// 添加过滤条件，谓词过滤predicate，这里是自定义注解进行过滤
				.apis(Predicates.not(RequestHandlerSelectors.withMethodAnnotation(SwaggerCustomIgnore.class)))
				// 这里配合@ComponentScan一起使用，又再次细化了匹配规则(当然，我们也可以只选择@ComponentScan、paths()方法当中的一中)
//				.paths(allowPaths())
				.build();
	}

	/**
	 * 自定义API文档基本信息实体
	 * 
	 * @return
	 */
	private ApiInfo swaggerDemoApiInfo() {
		// 构建联系实体，在UI界面会显示
		Contact contact = new Contact("嘉实基金", "http://www.jsfund.cn", "wangyan@jsfund.cn");
		return new ApiInfoBuilder().contact(contact)
				// 文档标题
				.title("Swagger2构建RESTful API文档")
				// 文档描述
				.description("SpringBoot集成Springbox开源项目，实现OAS，构建成RESTful API文档")
				// 文档版本
				.version("1.0.0").build();
	}
	
	 /**
     * path匹配规则
     * @return
     */
    @SuppressWarnings("unused")
	private Predicate<String> allowPaths(){
        return Predicates.or(
        		PathSelectors.regex("/user.*"),
        		PathSelectors.regex("/role.*")
        );
    }
}
