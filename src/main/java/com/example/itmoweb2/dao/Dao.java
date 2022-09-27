package com.example.itmoweb2.dao;

import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

    Object save(T t);

    void update(T t, String[] params);

    void delete(T t);


    default void executeInsideTransaction(Consumer<Session> action, Session session) {
        EntityTransaction tx = session.getTransaction();
        try {
            tx.begin();
            action.accept(session);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

}
