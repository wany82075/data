package cn.dlut.edu.data.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.dlut.edu.data.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "库存类")
public class Tbl extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@TableId(value="id",  type=IdType.AUTO)
	@ApiModelProperty(value = "库存ID，自增序列", hidden=true)
	private Long id;
	
    @TableField("commodity_code")
    @ApiModelProperty(value = "商品编码", dataType="String", example="276384", required=true)
    private String commodityCode;

    @TableField("count")
    @ApiModelProperty(value = "商品数量", dataType="int", example="100", required=true)
    private Integer count;
}
