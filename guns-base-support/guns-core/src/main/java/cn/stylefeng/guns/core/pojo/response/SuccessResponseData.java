
package cn.stylefeng.guns.core.pojo.response;

/**
 * 成功响应结果
 *
 * @author xuyuxiang
 * @date 2020/3/30 15:04
 */
public class SuccessResponseData<T> extends ResponseData<T> {

    public SuccessResponseData() {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }

    public SuccessResponseData(T object) {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);
    }

    public SuccessResponseData(Integer code, String message, T object) {
        super(true, code, message, object);
    }
}
