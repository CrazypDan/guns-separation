
package cn.stylefeng.guns.sys.core.aop;

import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.core.annotion.BusinessLog;
import cn.stylefeng.guns.core.consts.AopSortConstant;
import cn.stylefeng.guns.core.consts.CommonConstant;
import cn.stylefeng.guns.core.context.login.LoginContextHolder;
import cn.stylefeng.guns.core.pojo.login.SysLoginUser;
import cn.stylefeng.guns.sys.core.log.LogManager;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * 业务日志aop切面
 *
 * @author xuyuxiang
 * @date 2020/3/20 11:47
 */
@Aspect
@Order(AopSortConstant.BUSINESS_LOG_AOP)
public class BusinessLogAop {

    /**
     * 日志切入点
     *
     * @author xuyuxiang
     * @date 2020/3/23 17:10
     */
    @Pointcut("@annotation(cn.stylefeng.guns.core.annotion.BusinessLog)")
    private void getLogPointCut() {
    }

    /**
     * 操作成功返回结果记录日志
     *
     * @author xuyuxiang
     * @date 2020/3/20 11:51
     */
    @AfterReturning(pointcut = "getLogPointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        BusinessLog businessLog = method.getAnnotation(BusinessLog.class);
        SysLoginUser sysLoginUser = LoginContextHolder.me().getSysLoginUserWithoutException();
        String account = CommonConstant.UNKNOWN;
        if(ObjectUtil.isNotNull(sysLoginUser)) {
            account = sysLoginUser.getAccount();
        }
        //异步记录日志
        LogManager.me().executeOperationLog(
                businessLog, account, joinPoint, JSON.toJSONString(result));
    }

    /**
     * 操作发生异常记录日志
     *
     * @author xuyuxiang
     * @date 2020/3/21 11:38
     */
    @AfterThrowing(pointcut = "getLogPointCut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        BusinessLog businessLog = method.getAnnotation(BusinessLog.class);
        SysLoginUser sysLoginUser = LoginContextHolder.me().getSysLoginUserWithoutException();
        String account = CommonConstant.UNKNOWN;
        if(ObjectUtil.isNotNull(sysLoginUser)) {
            account = sysLoginUser.getAccount();
        }
        //异步记录日志
        LogManager.me().executeExceptionLog(
                businessLog, account, joinPoint, exception);
    }
}
