package com.example.itmoweb2.dao.jpa;

import com.example.itmoweb2.dao.AbstractDao;
import com.example.itmoweb2.dao.Dao;
import com.example.itmoweb2.entity.Hit;
import com.example.itmoweb2.entity.User;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class HitDao extends AbstractDao<Hit> {

//    private Session session;
    public HitDao(Session session){
        super(Hit.class,session);
    }
}
