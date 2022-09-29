package com.example.itmoweb2.dao.jpa;

import com.example.itmoweb2.dao.AbstractDao;
import com.example.itmoweb2.model.entity.Hit;
import org.hibernate.Session;

public class HitDao extends AbstractDao<Hit> {

//    private Session session;
    public HitDao(Session session){
        super(Hit.class,session);
    }
}
