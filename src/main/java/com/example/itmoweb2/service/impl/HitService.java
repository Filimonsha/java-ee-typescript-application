package com.example.itmoweb2.service.impl;

import com.example.itmoweb2.dao.jpa.HitDao;
import com.example.itmoweb2.model.entity.Hit;
import com.example.itmoweb2.utility.AreaHit;
import com.example.itmoweb2.utility.responseUtility.implementation.HitResponseHandler;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class HitService implements com.example.itmoweb2.service.abst.HitService {
    private final HitResponseHandler hitResponseHandler = new HitResponseHandler();

    public void getHitById(Long id, HttpServletRequest request, HttpServletResponse response) {
        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();

        HitDao hitDao = new HitDao(session);
        Optional<Hit> hit = hitDao.get(id);
        try {
            hitResponseHandler.returnOneEntity(hit, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        session.close();
    }

    public void getAllHits(HttpServletRequest request, HttpServletResponse response) {
        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();

        HitDao hitDao = new HitDao(session);

        List<Hit> allHits = hitDao.getAll();
        try {
            //        Отправляем ответ
            hitResponseHandler.returnAllEntity(allHits, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveHit(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();

        HitDao hitDao = new HitDao(session);

        HashMap<String, Object> myMap = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            myMap = objectMapper.readValue(request.getInputStream(), HashMap.class);
            if (myMap.get("x") == null || myMap.get("y") == null || myMap.get("r") == null) {
                throw new ServletException("Запрос должен включать x,y,r !");
            } else {
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
                Optional<Hit> savedHitDao = hitDao.get((Long) savedObjectID);
                hitResponseHandler.returnOneEntity(savedHitDao, response.getWriter());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        session.close();
    }
}
