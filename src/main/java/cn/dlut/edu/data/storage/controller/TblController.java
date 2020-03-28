package cn.dlut.edu.data.storage.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.dlut.edu.data.base.contoller.BaseController;
import cn.dlut.edu.data.storage.service.impl.TestService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyan
 * @since 2020-03-22
 */
@Controller
@RequestMapping("/storage/tbl")
public class TblController extends BaseController {

	@Resource
	private TestService testService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test() {
		try {
			testService.testDynamicDsInsert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
