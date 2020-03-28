package cn.dlut.edu.data.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class User {
	
	@TableId(value="id",  type=IdType.AUTO)
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
