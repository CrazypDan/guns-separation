
package cn.stylefeng.guns.modular.module1.entity;

import cn.stylefeng.guns.modular.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * 一个示例
 *
 * @author da.feng
 */
@Getter
@Setter
@Entity(name = "demo")
public class Demo extends BaseEntity {

    /**
     * 标题
     */
    @Column
    private String title;

    /**
     * 描述
     */
    @Column
    private String description;

}
