package com.calmkin.web.old_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet("/old_selectByIdServlet")
public class old_selectByIdServlet extends HttpServlet {
//    private BrandService service = new BrandService();  //因为这个类需要在两个函数中都用到，所以单独new出来进行共享
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id=request.getParameter("id");
//        Brand brand=service.selectById(Integer.parseInt(id));
//
//        request.setAttribute("brand",brand);
//
//        request.getRequestDispatcher("/update.jsp").forward(request,response);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request,response);
//    }
}