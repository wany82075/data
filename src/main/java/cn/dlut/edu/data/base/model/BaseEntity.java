package cn.dlut.edu.data.base.model;


import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 基础父类测试
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -8273338272023894647L;
}
