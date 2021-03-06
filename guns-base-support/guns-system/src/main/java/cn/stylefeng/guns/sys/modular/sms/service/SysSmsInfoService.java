
package cn.stylefeng.guns.sys.modular.sms.service;

import cn.stylefeng.guns.core.pojo.page.PageResult;
import cn.stylefeng.guns.sys.modular.sms.entity.SysSms;
import cn.stylefeng.guns.sys.modular.sms.enums.SmsSendStatusEnum;
import cn.stylefeng.guns.sys.modular.sms.enums.SmsVerifyEnum;
import cn.stylefeng.guns.sys.modular.sms.param.SysSmsInfoParam;
import cn.stylefeng.guns.sys.modular.sms.param.SysSmsSendParam;
import cn.stylefeng.guns.sys.modular.sms.param.SysSmsVerifyParam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统短信service接口
 *
 * @author stylefeng
 * @date 2018/7/5 13:44
 */
public interface SysSmsInfoService extends IService<SysSms> {

    /**
     * 存储短信验证信息
     *
     * @param sysSmsSendParam 发送参数
     * @param validateCode    验证码
     * @return 短信记录id
     * @author stylefeng
     * @date 2018/7/6 16:47
     */
    Long saveSmsInfo(SysSmsSendParam sysSmsSendParam, String validateCode);

    /**
     * 更新短息发送状态
     *
     * @param smsId             短信记录id
     * @param smsSendStatusEnum 发送状态枚举
     * @author stylefeng
     * @date 2018/7/6 17:12
     */
    void updateSmsInfo(Long smsId, SmsSendStatusEnum smsSendStatusEnum);

    /**
     * 校验验证码是否正确
     *
     * @param sysSmsVerifyParam 短信校验参数
     * @return 短信校验结果枚举
     * @author stylefeng
     * @date 2018/7/6 17:16
     */
    SmsVerifyEnum validateSmsInfo(SysSmsVerifyParam sysSmsVerifyParam);

    /**
     * 短信发送记录查询
     *
     * @param sysSmsInfoParam 查询参数
     * @return 查询分页结果
     * @author xuyuxiang
     * @date 2020/7/2 12:08
     */
    PageResult<SysSms> page(SysSmsInfoParam sysSmsInfoParam);
}
