
package cn.stylefeng.guns.sys.modular.org.controller;

import cn.stylefeng.guns.core.annotion.BusinessLog;
import cn.stylefeng.guns.core.annotion.DataScope;
import cn.stylefeng.guns.core.annotion.Permission;
import cn.stylefeng.guns.core.enums.LogAnnotionOpTypeEnum;
import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.core.pojo.response.SuccessResponseData;
import cn.stylefeng.guns.sys.modular.org.param.SysOrgParam;
import cn.stylefeng.guns.sys.modular.org.service.SysOrgService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统组织机构控制器
 *
 * @author xuyuxiang
 * @date 2020/3/20 19:47
 */
@RestController
public class SysOrgController {

    @Resource
    private SysOrgService sysOrgService;

    /**
     * 查询系统机构
     *
     * @author xuyuxiang
     * @date 2020/5/11 15:49
     */
    @Permission
    @DataScope
    @GetMapping("/sysOrg/page")
    @BusinessLog(title = "系统机构_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(SysOrgParam sysOrgParam) {
        return new SuccessResponseData(sysOrgService.page(sysOrgParam));
    }

    /**
     * 系统组织机构列表
     *
     * @author xuyuxiang
     * @date 2020/3/26 10:20
     */
    @Permission
    @DataScope
    @GetMapping("/sysOrg/list")
    @BusinessLog(title = "系统组织机构_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(SysOrgParam sysOrgParam) {
        return new SuccessResponseData(sysOrgService.list(sysOrgParam));
    }

    /**
     * 添加系统组织机构
     *
     * @author xuyuxiang
     * @date 2020/3/25 14:44
     */
    @Permission
    @DataScope
    @PostMapping("/sysOrg/add")
    @BusinessLog(title = "系统组织机构_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(SysOrgParam.add.class) SysOrgParam sysOrgParam) {
        sysOrgService.add(sysOrgParam);
        return new SuccessResponseData();
    }

    /**
     * 删除系统组织机构
     *
     * @author xuyuxiang
     * @date 2020/3/25 14:54
     */
    @Permission
    @DataScope
    @PostMapping("/sysOrg/delete")
    @BusinessLog(title = "系统组织机构_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(SysOrgParam.delete.class) SysOrgParam sysOrgParam) {
        sysOrgService.delete(sysOrgParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑系统组织机构
     *
     * @author xuyuxiang
     * @date 2020/3/25 14:54
     */
    @Permission
    @DataScope
    @PostMapping("/sysOrg/edit")
    @BusinessLog(title = "系统组织机构_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(SysOrgParam.edit.class) SysOrgParam sysOrgParam) {
        sysOrgService.edit(sysOrgParam);
        return new SuccessResponseData();
    }

    /**
     * 查看系统组织机构
     *
     * @author xuyuxiang
     * @date 2020/3/26 9:49
     */
    @Permission
    @GetMapping("/sysOrg/detail")
    @BusinessLog(title = "系统组织机构_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(SysOrgParam.detail.class) SysOrgParam sysOrgParam) {
        return new SuccessResponseData(sysOrgService.detail(sysOrgParam));
    }

    /**
     * 获取组织机构树
     *
     * @author xuyuxiang
     * @date 2020/3/26 11:55
     */
    @Permission
    @DataScope
    @GetMapping("/sysOrg/tree")
    @BusinessLog(title = "系统组织机构_树", opType = LogAnnotionOpTypeEnum.TREE)
    public ResponseData tree(SysOrgParam sysOrgParam) {
        return new SuccessResponseData(sysOrgService.tree(sysOrgParam));
    }
}
