
package cn.stylefeng.guns.sys.modular.sms.service;

import cn.stylefeng.guns.sys.modular.sms.enums.SmsSendStatusEnum;
import cn.stylefeng.guns.sys.modular.sms.enums.SmsVerifyEnum;
import cn.stylefeng.guns.sys.modular.sms.param.SysSmsSendParam;
import cn.stylefeng.guns.sys.modular.sms.param.SysSmsVerifyParam;

/**
 * 短信通知接口
 *
 * @author stylefeng
 * @date 2018/7/5 21:05
 */
public interface SmsSenderService {

    /**
     * 发送短信
     *
     * @param sysSmsSendParam 短信发送参数
     * @return 是否成功
     * @author stylefeng
     * @date 2018/7/6 16:32
     */
    boolean sendShortMessage(SysSmsSendParam sysSmsSendParam);

    /**
     * 验证短信
     *
     * @param sysSmsVerifyParam 短信验证参数
     * @return 校验结果
     * @author stylefeng
     * @date 2018/7/6 16:30
     */
    SmsVerifyEnum verifyShortMessage(SysSmsVerifyParam sysSmsVerifyParam);

    /**
     * 查看短信发送状态 0=未发送，1=发送成功，2=发送失败
     *
     * @param smsId 短信发送记录id
     * @return 发送状态
     * @author stylefeng
     * @date 2018/7/6 16:32
     */
    SmsSendStatusEnum getMessageSendStatus(Integer smsId);

}
