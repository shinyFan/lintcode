package com.yuantu.Interceptor;

import com.yuantu.common.DataEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * Created by JINZONGFAN on 2019/4/16 14:31
 */
public class UserSecurityInterceptor implements HandlerInterceptor {

    /**
     * 处理请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object object = httpServletRequest.getSession().getAttribute(DataEntity.SESSION_KEY);
        if (object == null) {
            String path = httpServletRequest.getContextPath() + "/user/login";
            httpServletResponse.sendRedirect(path);
            return false;
        } else {
            return true;
        }
    }

    /**
     * 完成请求处理
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws
            Exception {

    }

    /**
     * 请求处理之后
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}