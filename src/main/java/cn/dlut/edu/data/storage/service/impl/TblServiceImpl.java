package cn.dlut.edu.data.storage.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.dlut.edu.data.storage.entity.Tbl;
import cn.dlut.edu.data.storage.mapper.TblMapper;
import cn.dlut.edu.data.storage.service.ITblService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangyan
 * @since 2020-03-22
 */
@Service
public class TblServiceImpl extends ServiceImpl<TblMapper, Tbl> implements ITblService {
}
