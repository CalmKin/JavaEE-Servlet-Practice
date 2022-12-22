package com.calmkin.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径
        String uri = req.getRequestURI();
        //获取最后一段路径
        int index = uri.lastIndexOf('/');

        String methodName = uri.substring(index+1); //获取方法名

        //2. 执行方法
        //2.1 获取BrandServlet /UserServlet 字节码对象 Class
        Class<? extends BaseServlet> cls = this.getClass();

        //2.2 获取方法 Method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
//2.3 执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
