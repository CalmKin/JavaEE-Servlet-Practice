package com.calmkin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.calmkin.pojo.Brand;
import com.calmkin.pojo.PageBean;
import com.calmkin.service.BrandService;
import com.calmkin.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class brandServlet extends BaseServlet {
    //多态写法
    private BrandService brandService = new BrandServiceImpl();

    //用户实现分页查询
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 调用Service查询
        List<Brand> brands = brandService.selectAll();

        //2. 将集合转换为JSON数据   序列化
        String jsonString = JSON.toJSONString(brands, SerializerFeature.IgnoreErrorGetter);

        //告知浏览器响应的数据是什么， 告知浏览器使用什么字符集进行解码
        resp.setContentType("text/json;charset=utf-8");
        //向浏览器相应数据
        resp.getWriter().write(jsonString);
    }
    //添加企业信息
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();    //读取请求的reader

        String params = br.readLine();      //读取请求的所有数据

        Brand brand = JSON.parseObject(params,Brand.class);     //按照Brand类的字节码，把params字符串转化为brand对象

        brandService.add(brand);

        resp.getWriter().write("success");      //执行到这一步，添加成功，向前端返回成功的信息

    }
    //修改企业信息
    public void update(HttpServletRequest req, HttpServletResponse resp) {}
    //删除企业信息
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();      //读取请求数据

        int[] arr = JSON.parseObject(params,int[].class);   //整型数组也是对象

        brandService.deleteByIds(arr);  //调用service

        resp.getWriter().write("success");

    }

    public void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //因为是get方法传递的参数，是  begin=xxx ? pageSize=xxx 的形式，所以可以用getParameter方法获取
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        int begin = (currentPage-1)*pageSize;

        //调用service层
        PageBean pageBean = brandService.selectByPage(begin, pageSize);
        resp.setContentType("text/json;charset=utf-8");

        String jsonString = JSON.toJSONString(pageBean);

        resp.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //因为是get方法传递的参数，是  begin=xxx ? pageSize=xxx 的形式，所以可以用getParameter方法获取
        //url里面的参数依然是用getParameter来获取
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        //但是post请求体里面的数据就要用br来获取了
        BufferedReader br = req.getReader();
        String jsonStr = br.readLine();

        Brand brand = JSON.parseObject(jsonStr, Brand.class);

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        int begin = (currentPage-1)*pageSize;

        //调用service层
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(begin, pageSize,brand);
        resp.setContentType("text/json;charset=utf-8");

        String jsonString = JSON.toJSONString(pageBean);

        resp.getWriter().write(jsonString);
    }

    public void changeSingleById(HttpServletRequest req,HttpServletResponse resp) throws IOException {

        BufferedReader br = req.getReader();
        String jsonStr= br.readLine();
        //将请求体数据转化为对象
        Brand brand = JSON.parseObject(jsonStr,Brand.class);

        System.out.println(brand);

        brandService.updateSingle(brand);

        /*修改成功，向前端返回指示*/
        resp.getWriter().write("success");
    }


}