
package cn.stylefeng.guns.sys.modular.monitor.service;

import cn.stylefeng.guns.sys.modular.monitor.result.SysMachineResult;

/**
 * 系统属性监控service接口
 *
 * @author xuyuxiang
 * @date 2020/6/5 14:39
 */
public interface SysMachineService {

    /**
     * 系统属性监控
     *
     * @return 系统属性结果集
     * @author xuyuxiang
     * @date 2020/6/5 14:45
     */
    SysMachineResult query();
}
