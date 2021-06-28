package com.haiya.springmvc.interceptor;

import com.haiya.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    /**
     * 请求拦截方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 读取会话信息
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null) {
            writeContent(response, "请登录");
            return false;
        }
        UserDto user = (UserDto) object;

        // 请求的url
        String requestURI = request.getRequestURI();
        if(user.getAuthorities().contains("p1") && requestURI.contains("/r1")) {
            return true;
        }
        if(user.getAuthorities().contains("p2") && requestURI.contains("/r2")) {
            return true;
        }

        writeContent(response, "权限不足，拒绝访问");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
    }
}
