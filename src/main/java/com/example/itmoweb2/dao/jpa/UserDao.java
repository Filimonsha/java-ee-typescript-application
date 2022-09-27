package com.example.itmoweb2.dao.jpa;

import com.example.itmoweb2.dao.AbstractDao;
import com.example.itmoweb2.dao.Dao;
import com.example.itmoweb2.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;
//        implements Dao<User>

public class UserDao extends AbstractDao<User> {
    private Session session;

    public UserDao(Session session){
        super(User.class,session);
    }

//
//    @Override
//    public Optional<User> get(long id) {
//        return Optional.ofNullable(session.find(User.class, id));
//    }
//
//    @Override
//    public List<User> getAll() {
//        TypedQuery<User> query = session.createQuery("FROM User",User.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Optional<User> save(User user) {
//        this.executeInsideTransaction(session -> session.persist(user),this.session);
//        return get(user.getUserId());
//    }
//
//    @Override
//    public void update(User user, String[] params) {
//
//    }
//
//    @Override
//    public void delete(User user) {

//    }

}
