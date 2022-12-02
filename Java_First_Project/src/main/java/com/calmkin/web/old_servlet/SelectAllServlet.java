package com.calmkin.web.old_servlet;

//@WebServlet("/selectAllServlet")
//public class brandServlet extends HttpServlet {
//    private BrandService brandService = new BrandServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1. 调用Service查询
//        List<Brand> brands = brandService.selectAll();
//
//        //2. 将集合转换为JSON数据   序列化
//        String jsonString = JSON.toJSONString(brands, SerializerFeature.IgnoreErrorGetter);
//
//        //3. 响应数据
//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(jsonString);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request, response);
//    }
//}