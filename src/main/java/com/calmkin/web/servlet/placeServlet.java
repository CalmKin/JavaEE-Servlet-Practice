package com.calmkin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;
import com.calmkin.service.PlaceService;
import com.calmkin.service.impl.PlaceServiceImpl;

import javax.lang.model.element.NestingKind;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/place/*")
public class placeServlet extends BaseServlet{
    PlaceService service = new PlaceServiceImpl();
    //分页查询所有核酸检测地点
    public void selectAllByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String _currpg = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currPage= Integer.parseInt(_currpg);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Place>  pageBean= service.selectByPage(currPage,pageSize);

        resp.setContentType("text/json;charset=utf-8");
        String jsonStr = JSON.toJSONString(pageBean);
        resp.getWriter().write(jsonStr);
    }

    //添加新的地点
    public void addPlace(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();
//        获取请求体里面的对象json数据
        String jsonStr = br.readLine();

        Place place = JSON.parseObject(jsonStr,Place.class);

        service.addPlace(place);

//        添加成功，向前端返回提示
        resp.getWriter().write("success");
    }

//    修改单个地点的信息
    public void changePlace(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();
//        获取请求体里面的对象json数据
        String jsonStr = br.readLine();

        Place place = JSON.parseObject(jsonStr,Place.class);

        service.changeSingle(place);

        resp.getWriter().write("success");
    }

//    批量删除地点信息
    public void deleteByIds(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();

        String jsonStr = br.readLine();

        int[] lis = JSON.parseObject(jsonStr,int[].class);

        service.deleteByIds(lis);

        resp.getWriter().write("success");
    }

    public void initPlaces(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        List<String> lis = service.accessiblePlace();

        String s = JSON.toJSONString(lis);

        resp.setContentType("text/json;charset=utf-8");

        resp.getWriter().write(s);
    }

}
