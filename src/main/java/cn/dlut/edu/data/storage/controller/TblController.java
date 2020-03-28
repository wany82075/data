package cn.dlut.edu.data.storage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.dlut.edu.data.base.contoller.BaseController;
import cn.dlut.edu.data.storage.service.impl.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangyan
 * @since 2020-03-22
 */
@Controller
@RequestMapping("/storage/tbl")
@Api(value = "库存相关的接口")
public class TblController extends BaseController {

	@Resource
	private TestService testService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ApiOperation(value = "库存测试方法", notes = "这个方法用来测试mybatisplus的动态数据源", response = String.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "vno", value = "车牌", required = false, dataType = "string", paramType = "query", defaultValue = "辽A12345"),
			@ApiImplicitParam(name = "page", value = "page", required = false, dataType = "Integer", paramType = "query", defaultValue = "1"),
			@ApiImplicitParam(name = "count", value = "count", required = false, dataType = "Integer", paramType = "query", defaultValue = "10") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful — 请求已完成",  examples = @Example(value = @ExampleProperty(value = "测试案例", mediaType = "")) ),
			@ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"), @ApiResponse(code = 401, message = "未授权客户机访问数据"),
			@ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"), @ApiResponse(code = 500, message = "服务器不能完成请求") })
	public void test() {
		try {
			testService.testDynamicDsInsert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
