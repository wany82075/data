package cn.dlut.edu.data.storage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dlut.edu.data.storage.entity.Tbl;
import cn.dlut.edu.data.storage.mapper.TblMapper;
import cn.dlut.edu.data.user.mapper.UserMapper;
import cn.dlut.edu.data.user.model.User;
import cn.dlut.edu.data.world.entity.City;
import cn.dlut.edu.data.world.mapper.CityMapper;

@Service
public class TestService {

	@Autowired
	private TblMapper tblMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CityMapper cityMapper;

	public void insertStorage() {
		System.out.println("----- insert a storage -------------------");

		Tbl storage = new Tbl();
		storage.setCommodityCode("110012");
		storage.setCount(100);

		this.tblMapper.insert(storage);
	}

	public void insertUser() {
		System.out.println("----- insert a user -------------------");
		
		User user = new User();
		user.setName("wangyan");
		user.setAge(38);
		user.setEmail("wangyan@jsfund.cn");

		this.userMapper.insert(user);
	}
	
	public void insertCity() {
		System.out.println("------------------------insert a city ------------------------") ;
		
		City city = new City();
		city.setName("shenyang");
		city.setCountryCode("ARG");
		city.setDistrict("hengpin");
		city.setPopulation(100000);
		
//		DynamicDataSourceContextHolder.push("slave");
		this.cityMapper.insert(city);
	}

	public void testSelfDefinitionSelect() {
		try {
			System.out.println(("----- selectUserAge30above method test ------"));
			List<User> userList = userMapper.selectUserAge30above();
			userList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 两个不同的数据源不能放到一个事务里边，否则在切换数据源时会有问题
	 * 
	 * @throws Exception
	 */
//	@Transactional(rollbackForClassName = { "java.lang.Exception" })
	public void testDynamicDsInsert() throws Exception {
		try {
			insertCity();
			insertUser();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
