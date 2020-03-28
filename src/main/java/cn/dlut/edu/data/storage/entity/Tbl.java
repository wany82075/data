package cn.dlut.edu.data.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.dlut.edu.data.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangyan
 * @since 2020-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("storage_tbl")
public class Tbl extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@TableId(value="id",  type=IdType.AUTO)
	private Long id;
	
    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Integer count;
}
