package com.example.itmoweb2.controller;

import com.example.itmoweb2.service.impl.HitService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet(name = "HitServlet", value = "/hits")
public class HitServlet extends HttpServlet {
    HitService hitService = new HitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        String hitId = (request.getParameter("hitId"));

        if (hitId==null){
            hitService.getAllHits(request,response);
        }else{
            hitService.getHitById(Long.valueOf(hitId),request,response);
        }



//        session.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();
        hitService.saveHit(request,response);
        session.close();
    }

}
