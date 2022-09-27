package com.example.itmoweb2.dao;

import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class AbstractDao<T> implements Dao<T>{

    protected Class<T> typedClass;
    protected Session session;
    public AbstractDao(Class<T> typedClass,Session session){
        this.typedClass = typedClass;
        this.session = session;
    }

    @Override
    public Optional<T> get(long id) {
        return Optional.ofNullable(session.find(typedClass, id));
    }

    @Override
    public List<T> getAll() {
//        TypedQuery<T> query = session.createQuery("FROM User",User.class);
//        TypedQuery<T> query =

//        return query.getResultList();
        return (List<T>) session.createQuery("FROM " + this.typedClass.getName(),typedClass.getClass()).getResultList();

    }

    @Override
    public Object save(T t) {
        this.executeInsideTransaction(session -> session.persist(t),this.session);
        System.out.println("АааА" + session.getIdentifier(t));
        return session.getIdentifier(t);
    }

    @Override
    public void update(T t, String[] params) {

    }

    @Override
    public void delete(T t) {

    }
}
