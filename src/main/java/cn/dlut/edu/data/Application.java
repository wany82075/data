package cn.dlut.edu.data;

import java.util.concurrent.TimeUnit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(" cn.dlut.edu.data.*.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		try {
			TimeUnit.SECONDS.sleep(6000);
		} catch (InterruptedException e) {
			// do nothing
		}
	}

}