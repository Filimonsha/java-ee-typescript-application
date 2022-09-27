package com.example.itmoweb2;

import java.io.*;

import com.example.itmoweb2.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//        User user = entityManager.getReference(User.class, 1L);
//        user.getName();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Fff" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}