package cn.stylefeng.guns.modular;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体基础类，会自动填充数据
 * @author dam.feng
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2264997586201508785L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreatedBy
    private Long createdBy;

    @Column
    @CreatedDate
    private LocalDateTime createdTime;

    @Column
    @LastModifiedBy
    private Long updateBy;

    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;

}
