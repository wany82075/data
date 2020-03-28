package cn.dlut.edu.data.storage.mapper;

import cn.dlut.edu.data.storage.entity.Tbl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyan
 * @since 2020-03-22
 */
@DS("master")
public interface TblMapper extends BaseMapper<Tbl> {
}
