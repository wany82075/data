package cn.dlut.edu.data.world.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.dlut.edu.data.world.entity.City;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyan
 * @since 2020-03-22
 */
@DS(value="slave")
public interface CityMapper extends BaseMapper<City> {

}
