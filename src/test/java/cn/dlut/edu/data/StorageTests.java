package cn.dlut.edu.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.dlut.edu.data.storage.entity.Tbl;
import cn.dlut.edu.data.storage.service.ITblService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageTests {

	@Autowired
	private ITblService tblService;
	
	@Test
	public void testSelect() {
		try {
			long id = 1;
			Tbl storage = this.tblService.getById(id);
			if (storage == null) {
				System.out.println("storage is null now");
			} else {
				System.out.println(storage.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		Tbl storage = new Tbl();
		storage.setCommodityCode("110012");
		storage.setCount(100);
		
		this.tblService.save(storage);
	}
	
	
}
