package com.calmkin.web.old_servlet;

import com.alibaba.fastjson.JSON;
import com.calmkin.pojo.Brand;
import com.calmkin.service.BrandService;
import com.calmkin.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
//@WebServlet("/old_addServlet")
public class old_addServlet extends HttpServlet {

    private BrandService service  =new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        防止post请求出现乱码的问题
        req.setCharacterEncoding("utf-8");
//
//        //1. 接收表单提交的数据，封装为一个Brand对象
//        String brandName = req.getParameter("brandName");
//        String companyName = req.getParameter("companyName");
//        String ordered = req.getParameter("ordered");
//        String description = req.getParameter("description");
//        String status = req.getParameter("status");
//
//        //封装为一个Brand对象
//        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setOrdered(Integer.parseInt(ordered));
//        brand.setDescription(description);
//        brand.setStatus(Integer.parseInt(status));

//        上述的方法用于提交的数据格式是 `username=zhangsan&age=23` 的情况，如果前端返回的是json格式的数据，那么不能用getparameter
//        resp.getWriter().write("测试测试");      //执行到这一步，添加成功，向前端返回成功的信息

        BufferedReader br = req.getReader();    //读取请求的reader

        String params = br.readLine();      //读取请求的所有数据

        System.out.println(params);

        Brand brand = JSON.parseObject(params,Brand.class);     //按照Brand类的字节码，把params字符串转化为brand对象

        service.add(brand);

        resp.getWriter().write("success");      //执行到这一步，添加成功，向前端返回成功的信息
        //3. 转发到查询所有Servlet
//        req.getRequestDispatcher("/selectAllServlet").forward(req,resp);

    }
}
