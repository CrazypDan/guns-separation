
package cn.stylefeng.guns.sys.modular.consts.enums;

import cn.stylefeng.guns.core.annotion.ExpEnumType;
import cn.stylefeng.guns.core.exception.enums.abs.AbstractBaseExceptionEnum;
import cn.stylefeng.guns.core.factory.ExpEnumCodeFactory;
import cn.stylefeng.guns.sys.core.consts.SysExpEnumConstant;

/**
 * 系统参数配置相关异常枚举
 *
 * @author xuyuxiang
 * @date 2020/4/14 11:24
 */
@ExpEnumType(module = SysExpEnumConstant.GUNS_SYS_MODULE_EXP_CODE, kind = SysExpEnumConstant.SYS_CONFIG_EXCEPTION_ENUM)
public enum SysConfigExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 数据库连接配置不存在
     */
    DATA_SOURCE_NOT_EXIST(1, "数据库连接配置不存在，请检查spring.datasource配置"),

    /**
     * 系统参数配置不存在
     */
    CONFIG_NOT_EXIST(2, "系统参数配置不存在"),

    /**
     * 系统参数配置编码重复
     */
    CONFIG_CODE_REPEAT(3, "系统参数配置编码重复，请检查code参数"),

    /**
     * 系统参数配置名称重复
     */
    CONFIG_NAME_REPEAT(4, "系统参数配置名称重复，请检查name参数"),

    /**
     * 不能删除系统参数
     */
    CONFIG_SYS_CAN_NOT_DELETE(5, "系统参数配置不能删除"),

    /**
     * 常量分类在字典中未找到
     */
    NOT_EXIST_DICT_TYPE(6, "字典类型中未找到常量分类，请检查字典类型表");

    private final Integer code;

    private final String message;

    SysConfigExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return ExpEnumCodeFactory.getExpEnumCode(this.getClass(), code);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
