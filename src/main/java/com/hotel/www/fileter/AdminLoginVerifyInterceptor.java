package com.hotel.www.fileter;

import com.hotel.www.model.Admin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginVerifyInterceptor extends HandlerInterceptorAdapter {
    /**
     * 进入拦截器后首先进入的方法
     * 返回false则不再继续执行
     * 返回true则继续执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)throws Exception
    {
        HttpSession session=request.getSession();
        Admin adminInfo = (Admin)session.getAttribute("AdminInfo");
        if(adminInfo==null)
        {
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return  true;
    }
    /**
     * 生成视图时执行，可以用来处理异常，并记录在日志中
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object arg2, Exception exception){

    }

    /** -
     * 生成视图之前执行，可以修改ModelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object arg2, ModelAndView arg3)
            throws Exception{
    }
}