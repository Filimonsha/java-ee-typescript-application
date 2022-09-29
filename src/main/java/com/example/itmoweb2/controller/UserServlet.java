package com.example.itmoweb2.controller;

import com.example.itmoweb2.dao.jpa.HitDao;
import com.example.itmoweb2.dao.jpa.UserDao;
import com.example.itmoweb2.model.entity.Hit;
import com.example.itmoweb2.model.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/hello")
public class UserServlet extends HttpServlet {
    //    Session session = HibernateUtil.getSessionFactory().openSession();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("empId"));

        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();
//        request.getServletContext().get
        UserDao userDao = new UserDao(session);
        HitDao hitDao = new HitDao(session);
        userDao.save(new User().setUserName("Alice"));


        hitDao.save(new Hit().setHitX(1).setHitY(2).setHitR(2).setUser(userDao.get(1).get()));

//        Optional<User> user =
//        user.ifPresent(value -> {
//            System.out.println("Юзер" + value);
//            System.out.println("Hit" + userDao.getAll());
//        });
        System.out.println(        userDao.get(1));
        System.out.println(        userDao.getAll()
        );


        session.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
