package com.yuantu.advice;

import com.yuantu.common.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hanlimin
 * @Description: 全局Rest异常处理
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
@ControllerAdvice
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestGlobalExceptionHandler.class);


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return exceptionProsrr(ex, request.getContextPath());
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Object> jsonHandler(HttpServletRequest request, Exception ex) throws Exception {
        return exceptionProsrr(ex, request.getRequestURI() + StringUtils.defaultString(request.getQueryString()));
    }

    private ResponseEntity<Object> exceptionProsrr(Exception ex, String contextPath) {
        LOGGER.error("服务器错误", ex);

        String url = contextPath;
        Result result = Result.createFailResult();
        result.setData("{path:" + url + "}");
        result.setMsg("服务错误");
        ResponseEntity responseEntity = new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);

        return responseEntity;
    }

}
