package com.calmkin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.calmkin.pojo.*;
import com.calmkin.service.ResultService;
import com.calmkin.service.UserService;
import com.calmkin.service.impl.ResultServiceImpl;
import com.calmkin.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/result/*")
public class resultServlet extends BaseServlet {
    //多态写法
    private ResultService resultService = new ResultServiceImpl();
    private UserService userService = new UserServiceImpl();
    //条件分页查询
    public void selectByPageAndCondition(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //因为是get方法传递的参数，是  begin=xxx ? pageSize=xxx 的形式，所以可以用getParameter方法获取
        //url里面的参数依然是用getParameter来获取
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        //但是post请求体里面的数据就要用br来获取了
        BufferedReader br = req.getReader();
        String jsonStr = br.readLine();

        Condition condition = JSON.parseObject(jsonStr, Condition.class);

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        int begin = (currentPage-1)*pageSize;


        //调用service层
        PageBean<Result> pageBean = resultService.selectByPageAndCondition(begin, pageSize,condition);
        resp.setContentType("text/json;charset=utf-8");

        String jsonString = JSON.toJSONString(pageBean);

        resp.getWriter().write(jsonString);
    }
    //获取用户信息
    public void selectUserById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
        String _usid = req.getParameter("id");

        int id= Integer.parseInt(_usid);

        User user = userService.selectAllById(id);


        String jsonStr = JSON.toJSONString(user);

        resp.setContentType("text/json;charset=utf-8");

        resp.getWriter().write(jsonStr);
    }

//    用户用身份证号查询核酸结果
    public void selectByCondition(HttpServletRequest req,HttpServletResponse resp) throws Exception{

        BufferedReader br = req.getReader();

        String s = br.readLine();

        Query query = JSON.parseObject(s, Query.class);

        List<Result> results = resultService.selectByCondition(query.getCardID(),query.getUserName());

        String jsonStr= JSON.toJSONString(results);
        resp.setContentType("text/json;charset=utf-8");

        resp.getWriter().write(jsonStr);

    }

}

