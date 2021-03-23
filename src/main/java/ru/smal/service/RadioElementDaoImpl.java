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
    public RadioElement findById() {
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
