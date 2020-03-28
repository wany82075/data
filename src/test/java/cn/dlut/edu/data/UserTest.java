package cn.dlut.edu.data;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.dlut.edu.data.user.mapper.UserMapper;
import cn.dlut.edu.data.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;
    
//    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    
    @Test
    public void testSelfDefinitionSelect() {
    	try {
    		System.out.println(("----- selectUserAge30above method test ------"));
            List<User> userList = userMapper.selectUserAge30above();
            userList.forEach(System.out::println);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
//    @Test
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

}
