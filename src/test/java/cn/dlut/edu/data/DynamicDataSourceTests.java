package cn.dlut.edu.data;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.dlut.edu.data.storage.entity.Tbl;
import cn.dlut.edu.data.storage.service.ITblService;
import cn.dlut.edu.data.user.mapper.UserMapper;
import cn.dlut.edu.data.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTests {

	@Autowired
	private ITblService tblService;
	@Autowired
	private UserMapper userMapper;

//	@Test
	public void insertStorage() {
		try {
			System.out.println("----- insert a storage -------------------");
			
			Tbl storage = new Tbl();
			storage.setCommodityCode("110012");
			storage.setCount(100);

			this.tblService.save(storage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//  @Test
	public void insertUser() {
		try {
			System.out.println("----- insert a user -------------------");
			User user = new User();
			user.setName("wangyan");
			user.setAge(38);
			user.setEmail("wangyan@jsfund.cn");

			this.userMapper.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
    public void testSelfDefinitionSelect() {
    	try {
    		System.out.println(("----- selectUserAge30above method test ------"));
            List<User> userList = userMapper.selectUserAge30above();
            userList.forEach(System.out::println);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	
	@Test
	@Transactional(rollbackForClassName= {"java.lang.Exception"})
	@Rollback(value = false) 
	public void testDynamicDsInsert() throws Exception {
		insertUser();
		testSelfDefinitionSelect();
		
		boolean testRollBack = true;
		if (testRollBack) {
			throw new Exception("this is a test transactional rollback");
		}
		
		insertStorage();
	}
}
