
package cn.stylefeng.guns.sys.modular.consts.service;

import cn.stylefeng.guns.core.pojo.page.PageResult;
import cn.stylefeng.guns.sys.modular.consts.entity.SysConfig;
import cn.stylefeng.guns.sys.modular.consts.param.SysConfigParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 系统参数配置service接口
 *
 * @author xuyuxiang, fengshuonan
 * @date 2020/4/14 11:14
 */
public interface SysConfigService extends IService<SysConfig> {

    /**
     * 查询系统参数配置
     *
     * @param sysConfigParam 查询参数
     * @return 查询分页结果
     * @author xuyuxiang, fengshuonan
     * @date 2020/4/14 11:14
     */
    PageResult<SysConfig> page(SysConfigParam sysConfigParam);

    /**
     * 查询系统参数配置
     *
     * @param sysConfigParam 查询参数
     * @return 系统参数配置列表
     * @author xuyuxiang, fengshuonan
     * @date 2020/4/14 11:14
     */
    List<SysConfig> list(SysConfigParam sysConfigParam);

    /**
     * 查看系统参数配置
     *
     * @param sysConfigParam 查看参数
     * @return 系统参数配置
     * @author xuyuxiang, fengshuonan
     * @date 2020/4/14 11:15
     */
    SysConfig detail(SysConfigParam sysConfigParam);

    /**
     * 添加系统参数配置
     *
     * @param sysConfigParam 添加参数
     * @author xuyuxiang, fengshuonan
     * @date 2020/4/14 11:14
     */
    void add(SysConfigParam sysConfigParam);

    /**
     * 删除系统参数配置
     *
     * @param sysConfigParam 删除参数
     * @author xuyuxiang, fengshuonan
     * @date 2020/4/14 11:15
     */
    void delete(SysConfigParam sysConfigParam);

    /**
     * 编辑系统参数配置
     *
     * @param sysConfigParam 编辑参数
     * @author xuyuxiang, fengshuonan
     * @date 2020/4/14 11:15
     */
    void edit(SysConfigParam sysConfigParam);

}
