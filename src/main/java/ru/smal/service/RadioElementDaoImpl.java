package ru.smal.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.smal.dao.Dao;
import ru.smal.model.RadioElement;

import java.util.List;

public class RadioElementDaoImpl implements Dao<RadioElement, Integer> {
    private final SessionFactory factory;

    public RadioElementDaoImpl(SessionFactory factory){
        this.factory = factory;
    }
    @Override
    public List<RadioElement> findByAll() {
        try(Session session = factory.openSession()){
            Query<RadioElement> result = session.createQuery("FROM RadioElement");
            return result.list();
        }

    }

    @Override
    public RadioElement findById(RadioElement radioElement) {
        return null;
    }

    @Override
    public void add(RadioElement radioElement) {

    }

    @Override
    public void update(RadioElement radioElement) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(radioElement);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(RadioElement radioElement) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(radioElement);
            session.getTransaction().commit();
        }

    }
}
