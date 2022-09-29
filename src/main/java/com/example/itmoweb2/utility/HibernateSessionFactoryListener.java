package com.example.itmoweb2.utility;

import com.example.itmoweb2.model.entity.Hit;
import com.example.itmoweb2.model.entity.User;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

@WebListener
public class HibernateSessionFactoryListener implements ServletContextListener {

    public final Logger logger = Logger.getLogger(HibernateSessionFactoryListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        SessionFactory sessionFactory = (SessionFactory) servletContextEvent.getServletContext().getAttribute("SessionFactory");
        if(sessionFactory != null && !sessionFactory.isClosed()){
            sessionFactory.close();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("start config");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.setProperty("hibernate.hbm2ddl.auto","create");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Hit.class);
        logger.info("Hibernate Configuration created successfully");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        logger.info("ServiceRegistry created successfully");
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        logger.info("SessionFactory created successfully");

        servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
        logger.info("Hibernate SessionFactory Configured successfully");
    }
}
