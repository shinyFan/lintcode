package com.yuantu;

import com.yuantu.Interceptor.UserSecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * Created by brj on 2017/8/5.
 */
//@Configuration
////@Profile({"test","prod"})
//@Profile({"test"})
public class WebMvcConf extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new UserSecurityInterceptor());
        registration.excludePathPatterns("/user/**");
        registration.addPathPatterns("/**");
    }

}
