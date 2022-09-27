package com.example.itmoweb2;

import com.example.itmoweb2.dao.jpa.HitDao;
import com.example.itmoweb2.entity.Hit;
import com.example.itmoweb2.utility.AreaHit;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@WebServlet(name = "HitServlet", value = "/HitServlet")
public class HitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "*");
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//        response.addHeader("Access-Control-Allow-Headers", "*");
        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();
        HitDao hitDao = new HitDao(session);
        PrintWriter printWriter = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        Optional<Hit> savedHitDao = hitDao.get(1);
        printWriter.println(objectMapper.writeValueAsString(savedHitDao.get()));
        printWriter.flush();


        session.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//        response.addHeader("Access-Control-Allow-Headers", "*");
        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();

        PrintWriter printWriter = response.getWriter();
        HashMap<String, Object> myMap = new HashMap<String, Object>();

        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(request.getInputStream(), HashMap.class);
        if (myMap.get("x") == null || myMap.get("y") == null || myMap.get("r") == null) {
            throw new ServletException("Запрос должен включать x,y,r !");
        } else {
            HitDao hitDao = new HitDao(session);
            double x = Double.parseDouble(myMap.get("x").toString());
            double y = Double.parseDouble(myMap.get("y").toString());
            double r = Double.parseDouble(myMap.get("r").toString());
            Date currentDate = new Date();
            boolean resultAreaHit = AreaHit.checkAreaHit(x, y, r);
            Date executionDate = new Date(new Date().getTime() - currentDate.getTime());
            Object savedObjectID = hitDao.save(new Hit()
                    .setHitX(x)
                    .setHitY(y)
                    .setHitR(r)
                    .setAreaHit(resultAreaHit)
                    .setHitCurrentTime(currentDate)
                    .setHitExecutionTime(executionDate)

            );

//            Как после сохранения в бд забирать этот объект ?
            Optional<Hit> savedHitDao = hitDao.get((Long) savedObjectID);
            if (savedHitDao.isPresent()) {
                objectMapper.writeValue(printWriter, savedHitDao.get());
                printWriter.print(objectMapper.writeValueAsString(savedHitDao.get()));
                printWriter.flush();
                printWriter.println(objectMapper.writeValueAsString(savedHitDao.get()));
                System.out.println("Вааа" + objectMapper.writeValueAsString(savedHitDao.get()));

            }
        }
        System.out.println("Map is: " + myMap);
        session.close();
    }

}
