
package cn.stylefeng.guns.modular.module1.dto;


import cn.stylefeng.guns.annotation.Add;
import cn.stylefeng.guns.annotation.Edit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 案例入参DTO
 *
 * @author da.feng
 */
@Getter
@Setter
@ToString
@ApiModel(description = "案例参数")
public class DemoDTO{

    @ApiModelProperty(value = "主键，添加数据时不需要")
    @NotNull(message = "id不能为空", groups = Edit.class)
    private Long id;

    @ApiModelProperty(value = "标题")
    @NotNull(message = "title不能为空", groups = {Edit.class, Add.class})
    private String title;

    @ApiModelProperty(value = "描述")
    @NotNull(message = "description不能为空", groups = {Edit.class, Add.class})
    private String description;

}
