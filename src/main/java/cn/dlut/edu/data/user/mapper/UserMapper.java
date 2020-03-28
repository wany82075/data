package cn.dlut.edu.data.user.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.dlut.edu.data.user.model.User;

@DS("master")
public interface UserMapper extends BaseMapper<User> {

	public List<User> selectUserAge30above();
}
