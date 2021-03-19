package cn.stylefeng.guns.modular.module1.repository;

import cn.stylefeng.guns.modular.module1.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * demo数据仓库，可根据字段自动匹配，IDEA编辑器会自动提示补全方法名
 * @author dam.feng
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {

    /**
     * 根据标题自动匹配
     * @param title 标题
     * @return List<Demo>
     */
    List<Demo> findAllByTitleLike(String title);
}
