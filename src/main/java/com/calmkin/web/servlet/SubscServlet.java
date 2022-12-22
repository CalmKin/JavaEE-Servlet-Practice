package com.calmkin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Subsc;
import com.calmkin.service.SubsService;
import com.calmkin.service.impl.SubsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/subs/*")
public class SubscServlet extends BaseServlet {
//公共使用的服务
    private SubsService service = new SubsServiceImpl();

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String _currPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currPage = Integer.parseInt(_currPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Subsc> pageBean = service.selectByPage(currPage, pageSize);

        String jsonStr= JSON.toJSONString(pageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonStr);

    }

    public void addSubs(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        BufferedReader br =req.getReader();

        String s = br.readLine();

        Subsc subsc = JSON.parseObject(s, Subsc.class);

//        根据用户填写的表单将预约信息进行提交
        service.addSubs(subsc);

        resp.setContentType("text/json;charset=utf-8");

        resp.getWriter().write("success");
    }


}
