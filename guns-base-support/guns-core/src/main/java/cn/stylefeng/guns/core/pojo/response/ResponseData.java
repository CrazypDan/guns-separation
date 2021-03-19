
package cn.stylefeng.guns.core.pojo.response;

import lombok.Data;

/**
 * 响应结果数据
 *
 * @author xuyuxiang
 * @date 2020/3/30 15:04
 */
@Data
public class ResponseData<T> {

    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    public static final Integer DEFAULT_ERROR_CODE = 500;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private T data;

    public ResponseData() {
    }

    public ResponseData(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseData<String> success() {
        return new ResponseData<>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, "success");
    }

    public static <T> ResponseData<T> success(T object) {
        return new ResponseData<>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);
    }

    public static <T> ResponseData<T> success(Integer code, String message, T object) {
        return new ResponseData<>(true, code, message, object);
    }

    public static ErrorResponseData error(String message) {
        return new ErrorResponseData(message);
    }

    public static ErrorResponseData error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    public static ErrorResponseData error(Integer code, String message, Object object) {
        return new ErrorResponseData(code, message, object);
    }
}
