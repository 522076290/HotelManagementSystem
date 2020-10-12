package com.hotel.www.configuration;

import com.hotel.www.fileter.AdminLoginVerifyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //声明该类为配置类
public class SessionConfiguration implements  WebMvcConfigurer {

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminLoginVerifyInterceptor())
                .addPathPatterns("/admin/**")
                .addPathPatterns("/footer/**")
                .addPathPatterns("/head/**")
                .excludePathPatterns("/login");
    }
}
