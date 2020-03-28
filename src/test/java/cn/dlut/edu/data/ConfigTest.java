package cn.dlut.edu.data;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.dlut.edu.data.config.TestCreator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

	@Resource
	private TestCreator testCreator;
	
	@Test
	public void test() {
		try {
			System.out.println("this is creator property " + testCreator.toString());
			
			TimeUnit.SECONDS.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
