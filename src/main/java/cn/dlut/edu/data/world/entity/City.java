package cn.dlut.edu.data.world.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.dlut.edu.data.base.model.BaseEntity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

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
@TableName("city")
public class City extends BaseEntity {

    private static final long serialVersionUID = 1L;
	
    @TableId(value="id",  type=IdType.AUTO)
	private Long id;
	
    @TableField("Name")
    private String Name;

    @TableField("CountryCode")
    private String CountryCode;

    @TableField("District")
    private String District;

    @TableField("Population")
    private Integer Population;
}
