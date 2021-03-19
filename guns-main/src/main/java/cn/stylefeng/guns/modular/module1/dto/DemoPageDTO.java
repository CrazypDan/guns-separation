
package cn.stylefeng.guns.modular.module1.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 案例分页查询入参DTO，根据需求自行删减字段
 *
 * @author da.feng
 */
@Getter
@Setter
@ToString
@ApiModel(description = "案例分页查询对象")
public class DemoPageDTO {

    @ApiModelProperty(value = "主键，添加数据时不需要")
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页大小")
    private Integer pageSize;

}
