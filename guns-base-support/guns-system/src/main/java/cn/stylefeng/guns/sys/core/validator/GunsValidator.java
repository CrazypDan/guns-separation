

package cn.stylefeng.guns.sys.core.validator;

import cn.hutool.log.Log;
import cn.stylefeng.guns.core.context.group.RequestGroupContext;
import cn.stylefeng.guns.core.context.group.RequestParamIdContext;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.beans.PropertyDescriptor;

import static cn.stylefeng.guns.core.consts.CommonConstant.ID;

/**
 * 用于真正校验参数之前缓存一下group的class类型
 * <p>
 * 因为ConstraintValidator的自定义校验中获取不到当前进行的group
 *
 * @author fengshuonan
 * @date 2020/8/12 20:07
 */
public class GunsValidator extends LocalValidatorFactoryBean {

    private static final Log log = Log.get();

    @Override
    public void validate(Object target, Errors errors, Object... validationHints) {

        try {
            if (validationHints.length > 0) {

                // 如果是class类型，利用ThreadLocal缓存一下class类型
                if (validationHints[0] instanceof Class) {

                    // 临时保存group的class值
                    RequestGroupContext.set((Class<?>) validationHints[0]);

                    // 临时保存字段为id的值
                    RequestParamIdContext.set(getParamIdValue(target));
                }
            }
            super.validate(target, errors, validationHints);
        } finally {
            RequestGroupContext.clear();
            RequestParamIdContext.clear();
        }
    }

    /**
     * 获取参数中的id的值，如果没有id字段就返回null
     *
     * @author fengshuonan
     * @date 2020/8/12 21:24
     */
    private Long getParamIdValue(Object target) {

        try {
            PropertyDescriptor prop = new PropertyDescriptor(ID, target.getClass());
            Object paramId = prop.getReadMethod().invoke(target);
            if (paramId != null) {
                if (paramId instanceof Long) {
                    return (Long) paramId;
                }
            }
        } catch (Exception e) {
            log.error(">>> 获取参数的id值时候出错：{}", e.getMessage());
        }

        return null;
    }
}
