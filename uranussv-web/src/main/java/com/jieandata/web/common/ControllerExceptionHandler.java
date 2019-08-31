package com.jieandata.web.common;

import com.jieandata.jaguar.common.exception.JaguarException;
import com.jieandata.utils.bean.response.BaseResponse;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 * @author master.yang
 * @version $$Id: ControllerExceptionHandler, v 0.1 2018/7/5 上午6:08 master.yang Exp $$
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest httpRequest, HttpMessageNotReadableException ex) {
        log.error("请求[" + httpRequest.getRequestURI() + "]发生请求异常", ex);
        return new BaseResponse(RespCodeEnum.PARAM_ERROR);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest httpRequest, BusinessException busEx) {
        log.error("请求[" + httpRequest.getRequestURI() + "]发生业务异常", busEx);
        return new BaseResponse(busEx.getRespCodeEnum());
    }

    @ExceptionHandler(value = JaguarException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest httpRequest, JaguarException jaEx) {
        log.error("请求[" + httpRequest.getRequestURI() + "]发生框架异常", jaEx);
        return new BaseResponse(RespCodeEnum.ARCHITECTURE_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest httpRequest, Exception ex) {
        log.error("请求[" + httpRequest.getRequestURI() + "]发生系统异常", ex);
        return new BaseResponse(RespCodeEnum.SYSTEM_EXCEPTION);
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest httpRequest, Throwable t) {
        log.error("请求[" + httpRequest.getRequestURI() + "]发生未知异常", t);
        return new BaseResponse(RespCodeEnum.UNKNOWN_EXCEPTION);
    }
}
